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
		_prdList.onload(document.querySelector("#prdList"));
		_ctgList.onload(document.querySelector("#ctgList"),prdList);
	}
}
// 1.GNB 영역
// 2.프로모션 영역
// 3.카테고리 영역
// 4.총 개수표시 영역
// 5.상품 리스트
// 6.더보기 영역
function ProductList(){
	var _this = null;
	var _prdList = null;
	
	this.onload = function(element){
		_this = this;
		_prdList = element;
		_this.getData();
	}
	/**
	 * 데이터 조회
	 */
	this.getData = function(start, categoryId){
		// apiURL 설정
		var url = "api/products";
		
		ajax(url, function() {
			var jsonObj = JSON.parse(this.responseText);
			var products = jsonObj.items;
			
			_this.initPrdList();
			
			for(var i=0;i<products.length;i++){
				var item = products[i];
				var div = "";
				if(i%2==0)
					div = "left";
				else
					div = "right";
				_this.addProduct(item, div);
			}
			
		}, false);
	}
	/**
	 * 상품 리스트 초기화
	 */
	this.initPrdList = function(){
		_prdList.querySelector("#left").innerHTML = "";
		_prdList.querySelector("#right").innerHTML = "";
	}
	/**
	 * 상품 추가
	 */
	this.addProduct = function(data, div){
		var prdTemplate = document.querySelector("#itemList").innerHTML;
		prdTemplate = prdTemplate.replaceAll("${id}",data.displayInfoId);
		prdTemplate = prdTemplate.replaceAll("${placeName}",data.placeName);
		prdTemplate = prdTemplate.replaceAll("${content}",data.productContent);
		prdTemplate = prdTemplate.replaceAll("${description}",data.productDescription);
		if(div==="left")
			_prdList.querySelector("#left").insertAdjacentHTML("beforeend", prdTemplate);
		else if(div==="right")
			_prdList.querySelector("#right").insertAdjacentHTML("beforeend", prdTemplate);
	}
}