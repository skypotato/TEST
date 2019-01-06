/**
 * RESERVATION 공통 javaScript
 * 작성자 : skypotato
 * 작성일 : 2018.12.29
 */

/**
 * ajax 통신 함수
 * @param url
 * @param callbackFn
 * @param isAsync
 */
function ajax(url, callbackFn, isAsync) {
	if (!url) {
		return;
	}
	if (typeof callbackFn != 'function') {
		return;
	}
	var oReq = new XMLHttpRequest();

	oReq.addEventListener("load", callbackFn);
	oReq.open("GET", url, isAsync);
	oReq.send();
}
/**
 * Get 파라미터 값 가져오기
 * @param name
 * @returns
 */
function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
        results = regex.exec(location.search);
    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}
/**
 * handlebar를 이용한 템플릿 렌더링 함수
 * @param id
 * @param data
 * @returns
 */
function getRederingTemplateById( id, data ){
	var template = document.querySelector("#"+id).innerText;
	var bindTemplate = Handlebars.compile(template);  //bindTemplate은 메서드입니다.
	
	return bindTemplate(data);
}
/**
 * replaceAll
 * @param {String} str1 : 치환될 문자
 * @param {String} str2 : 치환할 문자
 * @returns {String} temp_str
 * */
String.prototype.replaceAll = function( str1, str2 ){
	var temp_str = this;
	if(!temp_str){
		return "";
	}else{
		// 정규식 특수문자 처리
		str1 = str1.replace(/\^/g,"\\\^");
		str1 = str1.replace(/\$/g,"\\\$");
		str1 = str1.replace(/\*/g,"\\\*");
		str1 = str1.replace(/\+/g,"\\\+");
		str1 = str1.replace(/\?/g,"\\\?");
		str1 = str1.replace(/\./g,"\\\.");
		// 변환
		temp_str = temp_str.replace(eval("/"+str1+"/g"), str2);
		return temp_str;		
	}
};
/**
 * 카테고리 클래스
 */
function CategoryList(){
	var _this = null;
	var _ctgList = null;
	var _callBack = null;
	
	this.onload = function(element){
		_this = this;
		_ctgList = element;
	}
	/**
	 * 데이터 조회
	 */
	this.getData = function(){
		// apiURL 설정
		var url = "api/categories";
		
		ajax(url, function() {
			var jsonObj = JSON.parse(this.responseText);
			var categories = jsonObj.items;
			
			_this.initCtgList();
			
			categories.forEach(function(item) {
				_this.addCategory(item);
			});
			
			_this.setEvent();
			
		}, false);
	}
	/**
	 * 카테고리 리스트 초기화
	 */
	this.initCtgList = function(){
		var ctgTemplate = document.querySelector("#categoryItem").innerHTML;
		
		ctgTemplate = ctgTemplate.replace("${id}","0");
		ctgTemplate = ctgTemplate.replace("${name}","전체리스트");
		ctgTemplate = ctgTemplate.replace("${active}","active");
		
		_ctgList.innerHTML = ctgTemplate;
	}
	/**
	 * 카테고리 추가
	 */
	this.addCategory = function(data){
		var ctgTemplate = document.querySelector("#categoryItem").innerHTML;
		
		ctgTemplate = ctgTemplate.replace("${id}",data.id);
		ctgTemplate = ctgTemplate.replace("${name}",data.name);
		ctgTemplate = ctgTemplate.replace("${active}","");
		
		_ctgList.insertAdjacentHTML("beforeend", ctgTemplate);
	}
	/**
	 * 이벤트 등록
	 */
	this.setEvent = function(){
		_ctgList.querySelectorAll(".item").forEach(function(item){
			item.addEventListener("click", function(){
				_this.selectCategory(this);
			});
		});
	}
	/**
	 * 카테고리 선택
	 */
	this.selectCategory = function(item){
		_this.removeAllMark();
		_this.addMark(item);
		
		if(_callBack&&typeof(_callBack)=="function")
			_callBack(0,_this.getSelectCategoryId);
	}
	/**
	 * 전체 카테고리의 표시 삭제 
	 */
	this.removeAllMark = function(){
		_ctgList.querySelectorAll(".item > a").forEach(function(item){
			item.classList.remove("active");
		});
	}
	/**
	 * 카테고리 표시 등록
	 */
	this.addMark = function(item){
		item.querySelector("a").classList.add("active");
	}
	/**
	 * 선택된 categoryId 출력
	 */
	this.getSelectCategoryId = function(){
		var item = _ctgList.querySelector(".active").closest(".item");
		return item.getAttribute("data-category");
	}
	this.setCallback = function(callBack){
		if(callBack&&typeof(callBack)=="function")
			_callBack = callBack;
	}
}
/**
 * 상품 리스트 클래스
 */
function ProductList(){
	var _this = null;
	var _prdList = null;
	
	this.onload = function(element){
		_this = this;
		_prdList = element;
	}
	/**
	 * 데이터 조회
	 */
	this.getData = function(start, categoryId){
		// apiURL 설정
		var url = "api/products?start=${start}&categoryId=${categoryId}";
		
		if(start) url=url.replaceAll("${start}",start);
		else url=url.replaceAll("${start}","0");
		if(categoryId) url=url.replaceAll("${categoryId}",categoryId)
		else url=url.replaceAll("${categoryId}","");
		
		ajax(url, function() {
			var jsonObj = JSON.parse(this.responseText);
			var products = jsonObj.items;
			
			// 첫 조회만 초기화 시킴
			if(!start||start==0) _this.initPrdList();
			
			for(var i=0;i<products.length;i++){
				var item = products[i];
				var div = "";
				if(i%2==0)
					div = "left";
				else
					div = "right";
				_this.addProduct(item, div);
			}
			
			var totalCnt = jsonObj.totalCount;
			_this.setTotalCnt(totalCnt);
			
			if(totalCnt<=_this.getDisPrdCnt())
				document.querySelector("#addBtn").style.display = "none";
		}, true);
	}
	/**
	 * 상품 리스트 초기화
	 */
	this.initPrdList = function(){
		_prdList.querySelector("#left").innerHTML = "";
		_prdList.querySelector("#right").innerHTML = "";
		
		document.querySelector("#addBtn").style.display = "";
	}
	/*
	 * 상품 추가
	 */
	this.addProduct = function(data, div){
		var prdTemplate = document.querySelector("#itemList").innerHTML;
		
		prdTemplate = prdTemplate.replaceAll("${displayInfoId}",data.displayInfoId);
		prdTemplate = prdTemplate.replaceAll("${placeName}",data.placeName);
		prdTemplate = prdTemplate.replaceAll("${productContent}",data.productContent);
		prdTemplate = prdTemplate.replaceAll("${productDescription}",data.productDescription);
		prdTemplate = prdTemplate.replaceAll("${productImageUrl}",data.productImageUrl);
		
		if(div==="left")
			_prdList.querySelector("#left").insertAdjacentHTML("beforeend", prdTemplate);
		else if(div==="right")
			_prdList.querySelector("#right").insertAdjacentHTML("beforeend", prdTemplate);
	}
	/**
	 * 전체 개수 셋팅
	 */
	this.setTotalCnt = function(totalCnt){
		document.querySelector("#totalCntMsg").setAttribute("data-totalCnt", totalCnt?totalCnt:0);
		document.querySelector("#totalCntMsg").innerHTML = totalCnt+"개";
	}
	/**
	 * 현재 보여지는 상품 개수
	 */
	this.getDisPrdCnt = function(){
		return _prdList.querySelectorAll(".item").length;
	}
}