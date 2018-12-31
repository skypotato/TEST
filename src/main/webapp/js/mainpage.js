/**
 * mainpage에 관한 js 파일
 * 작성자 : skypotato
 * 작성일 : 2018.12.29
 */

onload = function(){
	_me.onload();
}

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
		_ctgList.onload(document.querySelector("#ctgList"));
		_prdList.onload(document.querySelector("#prdList"));
		
		_ctgList.setCallback(_prdList.getData);
		
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
