/**
 * detail에 관한 js 파일
 * 작성자 : skypotato
 * 작성일 : 2019.01.03
 */

onload = function(){
	_me.onload();
}

var _productImageList = new SlideNaviImages();
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
		_me.getData();
		_me.setEvent();
		_productImageList.onload(document.querySelector("#slideNaviImages"));
	}
	/**
	 * 이벤트 등록 함수
	 */
	,setEvent: function(){
		document.querySelector("#unFoldBtn").addEventListener("click", function(){
			var content = document.querySelector("#foldContent");
			content.classList.remove("close3");
			document.querySelector("#foldBtn").style.display = "";
			document.querySelector("#unFoldBtn").style.display = "none";
		});
		document.querySelector("#foldBtn").addEventListener("click", function(){
			var content = document.querySelector("#foldContent");
			content.classList.add("close3");
			document.querySelector("#foldBtn").style.display = "none";
			document.querySelector("#unFoldBtn").style.display = "";
		});
		document.querySelector("#detailInfoBtn").addEventListener("click", function(){
			document.querySelector("#detailInfoBtn").classList.add("active");
			document.querySelector("#directionsBtn").classList.remove("active");
			
			document.querySelector(".detail_location").classList.add("hide");
			document.querySelector(".detail_area_wrap").classList.remove("hide");
		});
		document.querySelector("#directionsBtn").addEventListener("click", function(){
			document.querySelector("#directionsBtn").classList.add("active");
			document.querySelector("#detailInfoBtn").classList.remove("active");
			
			document.querySelector(".detail_area_wrap").classList.add("hide");
			document.querySelector(".detail_location").classList.remove("hide");
			
		});
	}
	/**
	 * 데이터 조회하기
	 */
	,getData: function(){
		// apiURL 설정
		var url = "api/products/"+getParameterByName("id");
		
		ajax(url, function() {
			var jsonObj = JSON.parse(this.responseText);
			// TODO: Image 셋팅
			_me.setProduct(jsonObj);
		}, false);
	}
	/**
	 * 제품 셋팅
	 */
	,setProduct: function(data){
		document.querySelector("body").insertAdjacentHTML("beforeend", getRederingTemplateById("product",data));
	}
}
