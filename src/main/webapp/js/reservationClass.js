/**
 * 예약앱에서 사용되는 클래스를 정의하는 js 파일
 */
function SlideImage(element){
	var _this = this;
	var _slideImageElement = element;
	
	this.SlideImage = function(){
		
	}
	this.getElement = function(){
		return _slideImageElement;
	}
	this.setElement = function(element){
		_slideImageElement = element;
	}
	this.removeElement = function(){
		_slideImageElement.remove();
	}
	this.getSlideImageHTML = function(){
		return _slideImageElement.innerHTML;
	}
	this.setSlideImageHTML = function(html){
		_slideImageElement.innerHTML = html;
	}
}
function SlideImageList(element){
	var _this = this;
	var _slideImageArr = [];
	var _slideImageListElement = element;
	
	this.SlideImageList = function(){
		_this.mappingSlideImages();
	}
	this.getElement = function(){
		return _slideImageListElement;
	}
	this.setElement = function(element){
		if(index<0||index>=_slideImageArr.length) return false;
		
		_slideImageListElement = element;
	}
	this.get = function(index){
		if(index<0||index>=_slideImageArr.length) return false;
		
		return _slideImageArr[index];
	}
	this.set = function(index, slideImage){
		if(index<0||index>=_slideImageArr.length) return false;
		if(comm.null2void(slideImage)==="") return false;
		
		_slideImageArr[index] = slideImage
	}
	this.add = function(slideImage){
		if(comm.null2void(slideImage)==="") return false;
		
		_slideImageListElement.insertAdjacentElement(slideImage.getElement());
		_slideImageArr.push(slideImage);
	}
	this.remove = function(index){
		if(index<0||index>=_slideImageArr.length) return false;
		
		_slideImageArr[index].removeElement();
		_slideImageArr.splice(index, 1);
	}
	this.mappingSlideImages = function(){
		var slideImages = _slideImageListElement.querySelectorAll(".slideImage");
		slideImages.forEach(function(element){
			var slideImage = new SlideImage(element);
			_slideImageArr.push(slideImage);
		});
	}
	this.slideLeft = function(){
		
	}
	this.slideRight = function(){
		
	}
	this.startCarousel = function(){
		
	}
	this.stopCarousel = function(){
		
	}
}

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