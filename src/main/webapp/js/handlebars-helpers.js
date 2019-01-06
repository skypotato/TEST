/**
 * Handlebar helper 사용자 javascript
 * 작성자 : skypotato
 * 작성일 : 2019.01.06
 */

/**
 * 배열을 limit만큼 잘라준다.
 * @param arr
 * @param limit
 * @returns
 */
Handlebars.registerHelper('limit', function (arr, limit) {
	if(!Array.isArray(arr)){
		return [];
	}
	return arr.slice(0, limit);
});

/**
 * 소수점을 원하는 자리수만큼 반올림 처리한다.
 * @param float
 * @param digit
 * @returns
 */
Handlebars.registerHelper('toFixed', function (float, digit) {
	if(!parseFloat(float)){
		return 0;
	}
	return float.toFixed(digit);
});

/**
 * target값과 value값이 일치하는지 여부를 판단한다.
 * @param target
 * @param value
 * @param options
 * @returns
 */
Handlebars.registerHelper('ifEquals', function(target, value, options) {
	if (target == value) {
		return options.fn(this);
	}
	return options.inverse(this);
});