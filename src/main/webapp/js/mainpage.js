/**
 * mainpage에 관한 js 파일
 * 작성자 : skypotato
 * 작성일 : 2018.12.29
 */

onload = function(){
	_me.onload();
}

var _prmList = new PromotionList(); // 카테고리 리스트
var _ctgList = new CategoryList(); // 카테고리 리스트
var _prdList = new ProductList();
/**
 * 현재 페이지 객체
 */
var _me = {
	/**
	 *  현재 페이지 onload 함수
	 */
	onload: function(){
		_me.initPage();
	}
	/**
	 *	현재 페이지 초기화 함수
	 */
	,initPage: function(){
		_prmList.onload(document.querySelector("#prmList"));
		_ctgList.onload(document.querySelector("#ctgList"));
		_prdList.onload(document.querySelector("#prdList"));
		
		_ctgList.setCallback(_prdList.getData);
		
		_prmList.getData();
		_ctgList.getData();
		_prdList.getData(0, _ctgList.getSelectCategoryId());
		
		_me.setEvent();
	}
	/**
	 * 이벤트 등록 함수
	 */
	,setEvent: function(){
		document.querySelector("#addBtn").addEventListener("click", function(){
			var start = _prdList.getDisPrdCnt();
			var categoryId = _ctgList.getSelectCategoryId();
			
			_prdList.getData(start, categoryId);
			
		});
	}
}
// 1.GNB 영역
// 2.프로모션 영역
// 3.카테고리 영역
// 4.총 개수표시 영역
// 5.상품 리스트
// 6.더보기 영역
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
