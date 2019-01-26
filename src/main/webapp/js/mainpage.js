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
