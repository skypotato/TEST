/**
 * RESERVATION 공통 javaScript
 * 작성자 : skypotato
 * 작성일 : 2018.12.29
 */

/**
 * ajax 통신 함수
 * @param url
 * @param callbackFn
 * @param isAsync
 */
function ajax(url, callbackFn, isAsync) {
	if (!url) {
		return;
	}
	if (typeof callbackFn != 'function') {
		return;
	}
	var oReq = new XMLHttpRequest();

	oReq.addEventListener("load", callbackFn);
	oReq.open("GET", url, isAsync);
	oReq.send();
}
/**
 * Get 파라미터 값 가져오기
 * @param name
 * @returns
 */
function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
        results = regex.exec(location.search);
    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}
/**
 * handlebar를 이용한 템플릿 렌더링 함수
 * @param id
 * @param data
 * @returns
 */
function getRederingTemplateById( id, data ){
	var template = document.querySelector("#"+id).innerText;
	var bindTemplate = Handlebars.compile(template);  //bindTemplate은 메서드입니다.
	
	return bindTemplate(data);
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