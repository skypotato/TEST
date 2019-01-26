/**
 * RESERVATION 공통 javaScript
 * 작성자 : skypotato
 * 작성일 : 2018.12.29
 */

// 공통부 객체화
var comm = {
	/**
	 * ajax 통신 함수
	 * @param {String} url
	 * @param {function} callbackFn
	 * @param {boolean} isAsync
	 */
	ajax: function(url, callbackFn, isAsync) {
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
	 * 값이 null, undefined, NaN일 경우 대체 값으로 변환하거나 void를 출력하는 함수
	 * @param targetVal
	 * @param changeVal
	 * @returns
	 */
	,null2void: function(targetVal, changeVal){
		if(targetVal&&targetVal!="")
			return targetVal;
		else if(changeVal&&changeVal!="")
			return changeVal;
		else
			return "";
		
	}
	/**
	 * Get 파라미터 값 가져오기
	 * @param {String} name
	 * @returns {String}
	 */
	,getParameterByName: function(name) {
	    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
	    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
	        results = regex.exec(location.search);
	    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
	}
	/**
	 * handlebar를 이용한 템플릿 렌더링 함수
	 * @param {String} id
	 * @param {Object} data
	 * @returns {String}
	 */
	,getRederingTemplateById: function( id, data ){
		var template = document.querySelector("#"+id).innerText;
		var bindTemplate = Handlebars.compile(template);  //bindTemplate은 메서드입니다.
		var resultStr = "";
		
		try{
			resultStr = bindTemplate(data);
		}
		catch(e){
			console.error(e);
		}
		
		return resultStr;
	}
}
/**
 * replaceAll
 * @param {String} str1 : 치환될 문자
 * @param {String} str2 : 치환할 문자
 * @returns {String} temp_str
 * */
String.prototype.replaceAll = function( str1, str2 ){
	var temp_str = this;
	if(!temp_str){
		return "";
	}else{
		// 정규식 특수문자 처리
		str1 = str1.replace(/\^/g,"\\\^");
		str1 = str1.replace(/\$/g,"\\\$");
		str1 = str1.replace(/\*/g,"\\\*");
		str1 = str1.replace(/\+/g,"\\\+");
		str1 = str1.replace(/\?/g,"\\\?");
		str1 = str1.replace(/\./g,"\\\.");
		// 변환
		temp_str = temp_str.replace(eval("/"+str1+"/g"), str2);
		return temp_str;		
	}
};