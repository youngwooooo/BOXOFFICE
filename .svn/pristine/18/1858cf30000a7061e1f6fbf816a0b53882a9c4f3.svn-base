
/**
 * 빈 값인지 확인하는 함수
 * @param val 값(문자열)
 * @returns true, false
 * ex) isEmpty("홍길동")
 */
function isEmpty(val) {
	val = val.trim();
	if(val == null || val.length == 0) {
		return true;
	}
	
	return false;
}

/**
 * 필수 입력 항목이 비어 있을 경우 알려주는 함수
 * @param strId 요소 아이디
 * @param strName 입력 항목 이름
 * @returns true, false
 */
function checkValue(strId, strName) {
	var obj = document.getElementById(strId);
	
	if(isEmpty(obj.value)) {
		alert(strName + "은(는) 필수 입력 항목입니다.");
		obj.focus();
		return false;
	}
	
	return true;
}

/**
 * 입력 값의 길이를 확인하는 함수
 * @param strId 요소 아이디
 * @param strName 입력 항목 이름
 * @param minLen 최소 길이
 * @param maxLen 최대 길이
 * @returns true, false
 */
function checkValueLength(strId, strName, minLen, maxLen) {
	var obj = document.getElementById(strId);
	var val = obj.value;
	
	if(val.length < minLen || val.length > maxLen) {
		alert(strName + "은(는) " + minLen + "자 이상, " + maxLen + "자 이하로 입력해야 합니다.");
		obj.focus();
		return false;
	}
	
	return true;
}


/**
 * 입력 값 정규식 검사
 * @param strId 요소 아이디
 * @param regExp 정규식
 * @returns true, false
 */
function checkValueRegExp(strId, regExp, msg) {
	var obj = document.getElementById(strId);
	var val = obj.value.trim();
	
	if(!val.match(regExp)) {
		alert(msg);
		obj.focus();
		return false;
	}
	
	return true;
}

/**
 * 입력한 값이 숫자인지 확인
 * @param param
 * @param strName
 * @returns
 */
function checkNaN(param, strName) {
	if(isNaN(parseInt(param))) {
		alert(strName + "에는 숫자만 입력할 수 있습니다.");
		return false;
	}
	
	return true;
}

/**
 * 입력한 숫자가 특정 범위 내의 숫자인지 확인
 * @param param
 * @param minNum
 * @param maxNum
 * @param strName
 * @returns
 */
function checkNum(param, minNum, maxNum, strName) {
	if(param < minNum || param > maxNum) {
		alert(strName + "은(는) " + minNum + "이상 " + maxNum + "이하여야 합니다.");
		return false;
	}
	
	return true;
}

/**
 * 입력 값을 특정 형식으로 출력
 * @param type
 * @param val
 * @returns
 */
function format(type, val) {
	if(isEmpty(val)) {
		return "";
	}
	
	if(type == "DATE") {
		if(val.length != 8) {
			return val;
		}
		return val.substr(0, 4) + "/" + val.substr(4, 2) + "/" + val.substr(6, 2);
	}
	
	if(type == "HP") {
		if(val.length == 10) {
			return val.substr(0, 3) + "-" + val.substr(3, 3) + "-" + val.substr(6, 4);
			
		} else if(val.length == 11) {
			return val.substr(0, 3) + "-" + val.substr(3, 4) + "-" + val.substr(7, 4);
			
		} else {
			return val;
		}
	}
}