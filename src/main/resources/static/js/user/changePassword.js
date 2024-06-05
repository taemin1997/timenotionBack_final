//rgb 재정의
function rgb(r, g, b) {
  return `rgb(${Math.round(r)}, ${Math.round(g)}, ${Math.round(b)})`;
}
//비밀번호

const joinPasswordInput = document.getElementById('password-input');
const joinPasswordResult = document.getElementById('password-result');
const joinPasswordParagraph = document.getElementById('password-paragraph');

// 변수생성
let joinPasswordCount = 0;
//패스워드박스 focus blur 처리 
joinPasswordInput.addEventListener('focus', joinPasswordInputFocusFunction);
joinPasswordInput.addEventListener('blur', joinPasswordInputBlurFunction);
joinPasswordInput.addEventListener('keydown', joinPasswordInputKeydownFunction);

//패스워드 박스 함수 처리 
function joinPasswordInputFocusFunction() {
  console.log("dkdk");
  if (joinPasswordCount === 0) {
    console.log("0");
    joinPasswordInput.style.outline = "none";
    joinPasswordInput.style.opacity = 0.7;
    joinPasswordInput.style.borderWidth = "3px";
    joinPasswordInput.style.borderColor = '#B2E8F7';
  } else {
    joinPasswordInput.style.outline = "none";
    joinPasswordInput.style.borderWidth = "3px";
    joinPasswordInput.style.borderColor = "#FEB7B1";
    joinPasswordInput.style.borderWidth = "3px";
  }
  if (this.value !== '') {
    joinPasswordInput.style.outline = "none";
    joinPasswordInput.style.opacity = 0.7;
    joinPasswordInput.style.borderWidth = "3px";
    joinPasswordInput.style.borderColor = '#B2E8F7';
  }
  joinPasswordCount++;
  console.log(joinPasswordCount);
};

function joinPasswordInputBlurFunction() {

  joinPasswordResult.innerText = "필수 입력 항목입니다.";
  joinPasswordResult.style.color = rgb(255, 119, 119);
  joinPasswordResult.style.fontSize = "12px";
  joinPasswordInput.style.borderColor = rgb(255, 119, 119);
  joinPasswordInput.style.borderWidth = "1px";
  joinPasswordInput.style.marginBottom = "5px";
  joinPasswordParagraph.style.color = rgb(255, 119, 119);
  if (this.value !== '') {
    joinPasswordInput.style.opacity = 0.7;
    joinPasswordInput.style.borderWidth = "1px";
    joinPasswordInput.style.borderColor = 'gray';
    joinPasswordParagraph.style.color = 'black';
    joinPasswordResult.innerText = " ";

  }

};

//비밀번호확인
const joinPasswordCheckInput = document.getElementById('passwordcheck-input');
const joinPasswordCheckResult = document.getElementById('passwordcheck-result');
const joinPasswordCheckParagraph = document.getElementById('passwordcheck-paragraph');

// 변수생성
let joinPasswordCheckCount = 0;
//패스워드박스 focus blur 처리 
joinPasswordCheckInput.addEventListener('focus', joinPasswordCheckInputFocusFunction);
joinPasswordCheckInput.addEventListener('blur', joinPasswordCheckInputBlurFunction);
joinPasswordCheckInput.addEventListener('keydown', joinPasswordCheckInputKeydownFunction);

//패스워드 박스 함수 처리 
function joinPasswordCheckInputFocusFunction() {

  if (joinPasswordCheckCount === 0) {

    joinPasswordCheckInput.style.outline = "none";
    joinPasswordCheckInput.style.opacity = 0.7;
    joinPasswordCheckInput.style.borderWidth = "3px";
    joinPasswordCheckInput.style.borderColor = '#B2E8F7';
  } else {
    joinPasswordCheckInput.style.outline = "none";
    joinPasswordCheckInput.style.borderWidth = "3px";
    joinPasswordCheckInput.style.borderColor = "#FEB7B1";
    joinPasswordCheckInput.style.borderWidth = "3px";
  }
  if (this.value !== '') {
    joinPasswordCheckInput.style.outline = "none";
    joinPasswordCheckInput.style.opacity = 0.7;
    joinPasswordCheckInput.style.borderWidth = "3px";
    joinPasswordCheckInput.style.borderColor = '#B2E8F7';

  }
  joinPasswordCheckCount++;

};

function joinPasswordCheckInputBlurFunction() {
  console.log(111);
  joinPasswordCheckResult.innerText = "필수 입력 항목입니다.";
  joinPasswordCheckResult.style.color = rgb(255, 119, 119);
  joinPasswordCheckResult.style.fontSize = "12px";
  joinPasswordCheckInput.style.borderColor = rgb(255, 119, 119);
  joinPasswordCheckInput.style.borderWidth = "1px";
  joinPasswordCheckInput.style.marginBottom = "5px";
  joinPasswordCheckParagraph.style.color = rgb(255, 119, 119);
  if (this.value !== '') {
    joinPasswordCheckInput.style.opacity = 0.7;
    joinPasswordCheckInput.style.borderWidth = "1px";
    joinPasswordCheckInput.style.borderColor = 'gray';
    joinPasswordCheckParagraph.style.color = 'black';
    joinPasswordCheckResult.innerText = " ";

  }

};

function joinPasswordInputKeydownFunction() {
  joinPasswordInput.style.outline = "none";
  joinPasswordInput.style.opacity = 0.7;
  joinPasswordInput.style.borderWidth = "3px";
  joinPasswordInput.style.borderColor = '#B2E8F7';
  joinPasswordResult.innerText = "";
  joinPasswordParagraph.style.color = 'black';

}

function joinPasswordCheckInputKeydownFunction() {
  joinPasswordCheckInput.style.outline = "none";
  joinPasswordCheckInput.style.opacity = 0.7;
  joinPasswordCheckInput.style.borderWidth = "3px";
  joinPasswordCheckInput.style.borderColor = '#B2E8F7';
  joinPasswordCheckResult.innerText = "";
  joinPasswordCheckParagraph.style.color = 'black';


  joinPasswordInput.addEventListener('keyup', joinPasswordInputKeyupFunction);
  joinPasswordCheckInput.addEventListener('keyup', joinPasswordCheckInputKeyupFunction);

  function joinPasswordInputKeyupFunction() {
    joinPasswordInput.style.outline = "none";
    joinPasswordInput.style.opacity = 0.7;
    joinPasswordInput.style.borderWidth = "3px";
    joinPasswordInput.style.borderColor = '#B2E8F7';
    joinPasswordResult.innerText = "";
    joinPasswordParagraph.style.color = 'black';
    checkPasswordMatch();
  }

  function joinPasswordCheckInputKeyupFunction() {
    joinPasswordCheckInput.style.outline = "none";
    joinPasswordCheckInput.style.opacity = 0.7;
    joinPasswordCheckInput.style.borderWidth = "3px";
    joinPasswordCheckInput.style.borderColor = '#B2E8F7';
    joinPasswordCheckResult.innerText = "";
    joinPasswordCheckParagraph.style.color = 'black';
    checkPasswordMatch();
  }

}
//비밀번호 일치 확인
function checkPasswordMatch() {
  const password = joinPasswordInput.value;
  const confirmPassword = joinPasswordCheckInput.value;

  if (password === confirmPassword && password !== '' && confirmPassword !== '') {
    joinPasswordCheckResult.innerText = "비밀번호가 일치합니다.";
    joinPasswordCheckResult.style.color = '#9CE1F7';
  } else if (password !== confirmPassword && password !== '' && confirmPassword !== '') {
    joinPasswordCheckResult.innerText = "비밀번호가 일치하지 않습니다.";
    joinPasswordCheckResult.style.color = 'rgb(255, 119, 119)';
  } else {
    joinPasswordCheckResult.innerText = "";
  }
}
//버튼을 눌렀을때
const button = document.querySelector(".submit2");
// let msg = document.createElement("p")

button.addEventListener('click', joinFunction);

function joinFunction() {
  if (joinPasswordInput.value === '') {
    joinPasswordResult.innerText = "필수 입력 항목입니다.";
    joinPasswordResult.style.color = rgb(255, 119, 119);
    joinPasswordResult.style.fontSize = "12px";
    joinPasswordInput.style.borderColor = rgb(255, 119, 119);
    joinPasswordInput.style.borderWidth = "1px";
    joinPasswordInput.style.marginBottom = "5px";
    joinPasswordParagraph.style.color = rgb(255, 119, 119);
  }
  // else {
  //   oinPasswordInput.addEventListener('keyup', joinPasswordInputKeyupFunction);
  //   joinPasswordCheckInput.addEventListener('keyup', joinPasswordCheckInputKeyupFunction);

  // }

  else if (joinPasswordCheckInput.value === '') {
    joinPasswordCheckResult.innerText = "필수 입력 항목입니다.";
    joinPasswordCheckResult.style.color = rgb(255, 119, 119);
    joinPasswordCheckResult.style.fontSize = "12px";
    joinPasswordCheckInput.style.borderColor = rgb(255, 119, 119);
    joinPasswordCheckInput.style.borderWidth = "1px";
    joinPasswordCheckInput.style.marginBottom = "5px";
    joinPasswordCheckParagraph.style.color = rgb(255, 119, 119);
    joinFunction();
  }else {
    oinPasswordInput.addEventListener('keyup', joinPasswordInputKeyupFunction);
    joinPasswordCheckInput.addEventListener('keyup', joinPasswordCheckInputKeyupFunction);

  }
}