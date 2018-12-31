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
	if(!isAsync) isAsync=true; // 기본적으로 비동기 방식을 사용한다.
	
	var oReq = new XMLHttpRequest();

	oReq.addEventListener("load", callbackFn);
	oReq.open("GET", url, isAsync);
	oReq.send();
}
/**
 * replaceAll
 * @param {String} str1 : 치환될 문자
 * @param {String} str2 : 치환할 문자
 * @returns {String} temp_str
 * */
String.prototype.replaceAll = function( str1, str2 ){
	var temp_str = this;
	if(temp_str == null || temp_str == "undefined" || temp_str == ""){
		return "";
	}else{
		 temp_str = temp_str.replace(/(^\s*)|(\s*$)/gi, "");
		 temp_str = temp_str.replace(eval("/" + str1 + "/gi"), str2);
		 return temp_str;		
	}
};
/**
 * 카테고리 클래스
 */
function CategoryList(){
	var _this = null;
	var _ctgList = null;
	var _resultList = null;
	
	this.onload = function(element, object){
		_this = this;
		_ctgList = element;
		_resultList = object;
		_this.getData();
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
		_ctgList.innerHTML = ctgTemplate.replace("${id}","0")
										.replace("${name}","전체리스트")
										.replace("${active}","active");
	}
	/**
	 * 카테고리 추가
	 */
	this.addCategory = function(data){
		var ctgTemplate = document.querySelector("#categoryItem").innerHTML;
		ctgTemplate = ctgTemplate.replace("${id}",data.id)
									.replace("${name}",data.name)
									.replace("${active}","");
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
		_this.addMark();
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
}