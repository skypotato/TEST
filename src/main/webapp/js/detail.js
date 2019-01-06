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
