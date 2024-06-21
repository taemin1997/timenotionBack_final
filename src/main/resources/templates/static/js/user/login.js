//rgb 재정의
function rgb(r, g, b) {
  return `rgb(${Math.round(r)}, ${Math.round(g)}, ${Math.round(b)})`;
}
// NodeList에 map 메소드를 추가
// NodeList에 map 메소드를 추가
NodeList.prototype.map = Array.prototype.map;

const loginId = document.querySelector('#login-id-input');
const loginIdParagraph = document.querySelector('#login-id-paragraph');
const loninIdResult = document.querySelector('#login-id-result');
const loginPw = document.querySelector('#login-password-input');
const loginPwParagraph = document.querySelector('#login-password-paragraph');
const loginPwResult = document.querySelector('#login-password-result');


console.log(loginPwParagraph);
console.log(loginPwResult);

let loginIdCount = 0;
let loginPwCount = 0;

loginId.addEventListener('focus', loginIdInputFocusFunction);
loginId.addEventListener('blur', loginIdBlurFunction);
loginId.addEventListener('keydown', loginIdInputKeydownFunction);

function loginIdInputFocusFunction(){
  if(loginIdCount === 0){
    loginId.style.outline = "none";
    loginId.style.opacity = 0.7;
    loginId.style.borderWidth = "3px";
    loginId.style.borderColor = 'B2E8F7';
  }else{
    loginId.style.outline = "none";
    loginId.style.borderWidth = "3px";
    loginId.style.borderColor = "#FEB7B1";
    loginId.style.borderWidth = "3px";
  }
  if(this.value !== ''){
    loginId.style.outline = "none";
    loginId.style.opacity = 0.7;
    loginId.style.borderWidth = "3px";
    loginId.style.borderColor = '#B2E8F7';
  }
  loginIdCount++;
};

function loginIdBlurFunction(){
 
  loninIdResult.innerText = "필수 입력 항목입니다.";
  loninIdResult.style.color = rgb(255, 119, 119);
  loninIdResult.style.fontSize = "12px";
  loginId.style.borderColor =  rgb(255, 119, 119);
  loginId.style.borderWidth = "1px";
  loginId.style.marginBottom = "5px";
  loginIdParagraph.style.color =  rgb(255, 119, 119);
  if(this.value !== ''){
    loginId.style.opacity = 0.7;
    loginId.style.borderWidth = "1px";
    loginId.style.borderColor = 'gray';
    loginIdParagraph.style.color =  'black';
    loninIdResult.innerText = " ";
  }
};

function loginIdInputKeydownFunction(){
  loginId.style.outline = "none";
  loginId.style.opacity = 0.7;
  loginId.style.borderWidth = "3px";
  loginId.style.borderColor = '#B2E8F7';
  loninIdResult.innerText = "";
  loginIdParagraph.style.color =  'black';
}

loginPw.addEventListener('focus', loginPasswordInputFocusFunction);
loginPw.addEventListener('blur', loginPasswordBlurFunction);
loginPw.addEventListener('keydown', loginPwInputKeydownFunction);

function loginPasswordInputFocusFunction(){
  if(loginPwCount === 0){
    loginPw.style.outline = "none";
    loginPw.style.opacity = 0.7;
    loginPw.style.borderWidth = "3px";
    loginPw.style.borderColor = 'B2E8F7';
  }else{
    loginPw.style.outline = "none";
    loginPw.style.borderWidth = "3px";
    loginPw.style.borderColor = "#FEB7B1";
    loginPw.style.borderWPwth = "3px";
  }
  if(this.value !== ''){
    loginPw.style.outline = "none";
    loginPw.style.opacity = 0.7;
    loginPw.style.borderWidth = "3px";
    loginPw.style.borderColor = '#B2E8F7';
  }
  loginPwCount++;
};

function loginPasswordBlurFunction(){
 
  loginPwResult.innerText = "필수 입력 항목입니다.";
  loginPwResult.style.color = rgb(255, 119, 119);
  loginPwResult.style.fontSize = "12px";
  loginPw.style.borderColor =  rgb(255, 119, 119);
  loginPw.style.borderWidth = "1px";
  loginPw.style.marginBottom = "5px";
  loginPwParagraph.style.color =  rgb(255, 119, 119);
  if(this.value !== ''){
    loginPw.style.opacity = 0.7;
    loginPw.style.borderWidth = "1px";
    loginPw.style.borderColor = 'gray';
    loginPwParagraph.style.color =  'black';
    loginPwResult.innerText = " ";
  }
};

function loginPwInputKeydownFunction(){
  loginPw.style.outline = "none";
  loginPw.style.opacity = 0.7;
  loginPw.style.borderWidth = "3px";
  loginPw.style.borderColor = '#B2E8F7';
  loginPwResult.innerText = "";
  loginPwParagraph.style.color =  'black';
}