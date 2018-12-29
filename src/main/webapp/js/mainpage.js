/**
 * mainpage에 관한 js 파일
 * 작성자 : skypotato
 * 작성일 : 2018.12.29
 */

onload = function(){
	_me.onload();
}

var _category = new Category(); // 카테고리
/**
 * 현재 페이지 객체
 */
var _me = {
	/**
	 *  현재 페이지 onload 함수
	 */
	onload: function(){
		console.log("mainPage onload!!!!!");
		_me.initPage();
	}
	/**
	 *	현재 페이지 초기화 함수
	 */
	,initPage: function(){
		_category.onload();
	}
}
// 1.GNB 영역
// 2.프로모션 영역
// 3.카테고리 영역
// 4.총 개수표시 영역
// 5.상품 리스트
// 6.더보기 영역