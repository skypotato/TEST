/**
 * 예약앱에서 사용되는 클래스를 정의하는 js 파일
 */
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
function PromotionList(){
	var _this = null;
	var _prmList = null;
	var _prmIdx = 0;
	
	this.onload = function(element){
		_this = this;
		_prmList = element;
	}
	/**
	 * 데이터 조회
	 */
	this.getData = function(start, categoryId){
		// apiURL 설정
		var url = "api/promotions";
		
		ajax(url, function() {
			var jsonObj = JSON.parse(this.responseText);
			var promotions = jsonObj.items;
			
			_this.initPrmList();
			
			promotions.forEach(function(item){
				_this.addPromotion(item);
			});
			
			_this.slideAnimation();
		}, true);
	}
	/**
	 * 프로모션 리스트 초기화
	 */
	this.initPrmList = function(){
		_prmList.innerHTML="";
	}
	/**
	 * 프로모션 추가
	 */
	this.addPromotion = function(data){
		var prmTemplate = document.querySelector("#promotionItem").innerHTML;
		
		prmTemplate = prmTemplate.replaceAll("${productImageUrl}",data.productImageUrl);
		
		_prmList.insertAdjacentHTML("beforeend", prmTemplate);
	}
	/**
	 * 현재 보여지는 프로모션 개수
	 */
	this.getDisPrmCnt = function(){
		return _prmList.querySelectorAll(".item").length;
	}
	/**
	 * 프로모션 슬라이드 애니메이션
	 */
	this.slideAnimation = function(){
		var promotions = _prmList.querySelectorAll(".item");
		if(promotions.length > 0){
			// 첫번째 프로모션 위치 지정
			promotions[0].style.transform = "translateX(0%)";
		}
		// 프로모션 item이 2개 이상일 경우에만 동작한다.
		if(promotions.length > 2){
			_this.leftSlide(promotions);
		}		
	}
	this.leftSlide = function(promotions){
		setTimeout(() => {
			var targetIdx = _prmIdx%promotions.length		// 자레에서 좌측으로 이동할 item 인덱스
			var actionIdx = (_prmIdx+1)%promotions.length	// 자리에 위치할 item 인덱스
			promotions[targetIdx].style.transition = "transform 2s ease 0s";
			promotions[actionIdx].style.transition = "transform 2s ease 0s";
			promotions[targetIdx].style.transform = "translateX(-100%)";
			promotions[actionIdx].style.transform = "translateX(0%)";
			// transition delay
			setTimeout(() => {
				// transition 해제 후 위치 변경
				promotions[targetIdx].style.transition = "none";
				promotions[targetIdx].style.transform = "translateX(100%)";
				// 다음 인덱스 설정
				_prmIdx = actionIdx;
				// 재귀호출
				_this.leftSlide(promotions);
			}, 2000);
		}, 2500);
	}
}

/**
 * 
 * @returns
 */
function SlideNaviImages(){
	var _this = null;
	var _slideSection = null;
	
	var _slideElement = null;
	var _prevBtn = null;
	var _nextBtn = null;
	
	var _isActiveAni = false;
	
	this.onload = function(element){
		_this = this;
		_slideSection = element;
		_slideElement = element.querySelector(".detail_swipe");
		_prevBtn = _slideSection.querySelector(".btn_prev");
		_nextBtn = _slideSection.querySelector(".btn_nxt");
		_this.setEvent();
	}
	
	this.getTargetItemIdx = function(){
		var images = _slideElement.querySelectorAll(".item");
		
		for(var i=0;i < images.length;i++){
			if(images[i].classList.contains("target"))
				return i;
		}
	}
	
	this.initNaviBtn = function(){
		var images = _slideElement.querySelectorAll(".item");
		
		if(images.length>1){
			_prevBtn.querySelector("i").classList.add("off");
			_nextBtn.querySelector("i").classList.remove("off");
		}
		else{
			_prevBtn.querySelector("i").classList.add("off");
			_nextBtn.querySelector("i").classList.add("off");
		}
	}
	
	this.prevAnimation = function(){
		var images = _slideElement.querySelectorAll(".item");
		var targetIdx = _this.getTargetItemIdx();		// 자레에서 좌측으로 이동할 item 인덱스
		var actionIdx = (targetIdx-1)					// 자리에 위치할 item 인덱스
		
		if(actionIdx<0||_isActiveAni){
			return;
		}
		
		_isActiveAni = true;
		
		images[targetIdx].classList.remove("target");
		images[actionIdx].classList.add("target");
		images[targetIdx].style.transition = "transform 2s ease 0s";
		images[actionIdx].style.transition = "transform 2s ease 0s";
		images[targetIdx].style.transform = "translateX(100%)";
		images[actionIdx].style.transform = "translateX(0%)";
		
		_nextBtn.querySelector("i").classList.remove("off");
		if(actionIdx<=0){
			_prevBtn.querySelector("i").classList.add("off")
		}
		
		_slideSection.querySelector(".figure_pagination > .num").innerHTML=actionIdx+1
		// transition delay
		setTimeout(() => {
			images[targetIdx].style.transition = "none";
			_isActiveAni = false;
		}, 2000);
	}
	
	this.nextAnimation = function(){
		var images = _slideElement.querySelectorAll(".item");
		var targetIdx = _this.getTargetItemIdx();		// 자레에서 좌측으로 이동할 item 인덱스
		var actionIdx = (targetIdx+1)					// 자리에 위치할 item 인덱스
		
		if(actionIdx>images.length-1||_isActiveAni){
			return;
		}
		
		_isActiveAni = true;
		
		images[targetIdx].classList.remove("target");
		images[actionIdx].classList.add("target");
		images[targetIdx].style.transition = "transform 2s ease 0s";
		images[actionIdx].style.transition = "transform 2s ease 0s";
		images[targetIdx].style.transform = "translateX(-100%)";
		images[actionIdx].style.transform = "translateX(0%)";
		
		_prevBtn.querySelector("i").classList.remove("off");
		if(actionIdx>=images.length-1){
			_nextBtn.querySelector("i").classList.remove("off");
		}
		
		_slideSection.querySelector(".figure_pagination > .num").innerHTML=actionIdx+1;
		// transition delay
		setTimeout(() => {
			images[targetIdx].style.transition = "none";
			_isActiveAni = false;
		}, 2000);
	}
	
	this.setEvent = function(){
		_prevBtn.addEventListener("click", function(){
			if(!this.querySelector("i").classList.contains("off"))
				_this.prevAnimation();
		});
		_nextBtn.addEventListener("click", function(){
			if(!this.querySelector("i").classList.contains("off"))
				_this.nextAnimation();
		});
	}
	
}
