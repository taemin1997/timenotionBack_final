//rgb 재정의
function rgb(r, g, b) {
  return `rgb(${Math.round(r)}, ${Math.round(g)}, ${Math.round(b)})`;
}
// NodeList에 map 메소드를 추가
NodeList.prototype.map = Array.prototype.map;

const all = document.querySelector("#check_all");
const requiredCheckboxes = document.querySelectorAll(".check[required]");
const terms = document.querySelectorAll("input.check");
const error = document.querySelector(".required-message");
const error2 = document.querySelector(".required-message2");
const button = document.querySelector(".join");
// let msg = document.createElement("p")

button.addEventListener('click', joinFunction);

function joinFunction() {
  let allChecked = true;

  requiredCheckboxes.forEach((checkbox) => {
    if (!checkbox.checked) {
      allChecked = false;
    }
  });

  if (!allChecked) {
    error.innerText = "필수 선택 항목입니다";
    error2.innerText = "필수 선택 항목입니다";
    error.style.color = "red";
    error2.style.color = "red";
    error.style.fontSize = "12px";
    error2.style.fontSize = "12px";
  } else {
    error.innerText = "";
    error2.innerText = "";
  }
  if(joinPasswordInput.value ===''){
  joinPasswordResult.innerText = "필수 입력 항목입니다.";
  joinPasswordResult.style.color = rgb(255, 119, 119);
  joinPasswordResult.style.fontSize = "12px";
  joinPasswordInput.style.borderColor = rgb(255, 119, 119);
  joinPasswordInput.style.borderWidth = "1px";
  joinPasswordInput.style.marginBottom = "5px";
  joinPasswordParagraph.style.color = rgb(255, 119, 119);
  }
 

  if(joinPasswordCheckInput.value ===''){
    joinPasswordCheckResult.innerText = "필수 입력 항목입니다.";
  joinPasswordCheckResult.style.color = rgb(255, 119, 119);
  joinPasswordCheckResult.style.fontSize = "12px";
  joinPasswordCheckInput.style.borderColor = rgb(255, 119, 119);
  joinPasswordCheckInput.style.borderWidth = "1px";
  joinPasswordCheckInput.style.marginBottom = "5px";
  joinPasswordCheckParagraph.style.color = rgb(255, 119, 119);
  }

  if(nameInput.value ===''){
    nameResult.innerText = "필수 입력 항목입니다.";
  nameResult.style.color = rgb(255, 119, 119);
  nameResult.style.fontSize = "12px";
  nameInput.style.borderColor = rgb(255, 119, 119);
  nameInput.style.borderWidth = "1px";
  nameParagraph.style.color = rgb(255, 119, 119);
  }

  if (!joinIdInput.value) {
    joinIdResult.innerText = "필수 입력 항목입니다.";
    joinIdResult.style.color = 'rgb(255, 119, 119)';
    joinIdResult.style.fontSize = '12px';
    joinIdInput.style.borderColor = 'rgb(255, 119, 119)';
    joinIdInput.style.borderWidth = '1px';
    joinIdParagraph.style.color = 'rgb(255, 119, 119)';
  } else{
    joinIdButton.addEventListener('click',joinIdDuplicationClickFunction);
  }

  if (EmailInput.value === '') {
    EmailResult.innerText = "필수 입력 항목입니다.";
    EmailResult.style.color = 'rgb(255, 119, 119)';
    EmailResult.style.fontSize = '12px';
    EmailInput.style.borderColor = 'rgb(255, 119, 119)';
    EmailInput.style.borderWidth = '1px';
    EmailParagraph.style.color = 'rgb(255, 119, 119)';
  } else{
    EmailButton.addEventListener('click',EmailDuplicationClickFunction);
  }

  if (!joinNicknameInput.value) {
    joinNicknameResult.innerText = "필수 입력 항목입니다.";
    joinNicknameResult.style.color = 'rgb(255, 119, 119)';
    joinNicknameResult.style.fontSize = '12px';
    joinNicknameInput.style.borderColor = 'rgb(255, 119, 119)';
    joinNicknameInput.style.borderWidth = '1px';
    joinNicknameParagraph.style.color = 'rgb(255, 119, 119)';
  } else{
    joinNicknameButton.addEventListener('click',joinNicknameDuplicationClickFunction);
  }
  //생년월일 

  //년도
  for (let i = 0; i < editBirthInput.length; i++) {
    if(editBirthInput[i].value === ''){
      console.log("년도");
      editBirthResult.style.fontSize = '12px';
      editBirthResult.style.color = rgb(255, 119, 119);
      editBirthResult.innerText = "필수 입력 항목입니다.";
      // editBirthInput[i].style.borderColor = 'rgb(255, 119, 119)';
      // editBirthInput[i].style.borderWidth = "1px";
    }else{
      // editBirthResult.innerText = "";
      editBirthInput[i].style.borderColor = 'black';
    }
  }
  for (let i = 0; i < editBirthMonthInput.length; i++) {
    if (editBirthMonthInput[i].selectedIndex === 0) { // 선택된 옵션이 없는 경우
      editBirthResult.style.fontSize = '12px';
      editBirthResult.style.color = 'rgb(255, 119, 119)';
      editBirthResult.innerText = "필수 입력 항목입니다.";
      // editBirthMonthInput[i].style.borderColor = 'rgb(255, 119, 119)';
      // editBirthMonthInput[i].style.borderWidth = "1px";
    }else{
      editBirthMonthInput[i].style.borderColor = 'black';
    }
  }
  for (let i = 0; i < editBirthDayInput.length; i++) {
    if (editBirthDayInput[i].selectedIndex === 0) { // 선택된 옵션이 없는 경우
      editBirthResult.style.fontSize = '12px';
      editBirthResult.style.color = 'rgb(255, 119, 119)';
      editBirthResult.innerText = "필수 입력 항목입니다.";
      // editBirthDayInput[i].style.borderColor = 'rgb(255, 119, 119)';
      // editBirthDayInput[i].style.borderWidth = "1px";
    }else{
      editBirthDayInput[i].style.borderColor = 'black';
    }
  }
};



// 전체 동의 체크박스를 클릭할 때마다 실행되는 이벤트 리스너
all.addEventListener("click", () => {
  terms.forEach((check) => {
    check.checked = all.checked;
  });
});

// 약관 동의 체크박스를 클릭할 때마다 실행되는 이벤트 리스너
terms.forEach((check) => {
  check.addEventListener("click", () => {
    // 전체 동의 체크박스 상태를 변경
    all.checked = terms.map((check) => check.checked).filter((checked) => checked).length === 3;

  });
});








//비밀번호

const joinPasswordInput = document.getElementById('join-password-input');
const joinPasswordResult = document.getElementById('join-password-result');
const joinPasswordParagraph = document.getElementById('join-password-paragraph');

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
const joinPasswordCheckInput = document.getElementById('join-passwordcheck-input');
const joinPasswordCheckResult = document.getElementById('join-passwordcheck-result');
const joinPasswordCheckParagraph = document.getElementById('join-passwordcheck-paragraph');

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

//이름확인
const nameInput = document.getElementById('name-input');
const nameResult = document.getElementById('name-result');
const nameParagraph = document.getElementById('name-paragraph');

// 변수생성
let nameCount = 0;
//이름박스 focus blur 처리 
nameInput.addEventListener('focus', nameInputFocusFunction);
nameInput.addEventListener('blur', nameInputBlurFunction);
nameInput.addEventListener('keydown', nameInputKeydownFunction);


//이름 박스 함수 처리 
function nameInputFocusFunction() {

  if (nameCount === 0) {

    nameInput.style.outline = "none";
    nameInput.style.opacity = 0.7;
    nameInput.style.borderWidth = "3px";
    nameInput.style.borderColor = '#B2E8F7';
  } else {
    nameInput.style.outline = "none";
    nameInput.style.borderWidth = "3px";
    nameInput.style.borderColor = "#FEB7B1";
    nameInput.style.borderWidth = "3px";
  }
  if (this.value !== '') {
    nameInput.style.outline = "none";
    nameInput.style.opacity = 0.7;
    nameInput.style.borderWidth = "3px";
    nameInput.style.borderColor = '#B2E8F7';
  }
  nameCount++;

};

function nameInputBlurFunction() {

  nameResult.innerText = "필수 입력 항목입니다.";
  nameResult.style.color = rgb(255, 119, 119);
  nameResult.style.fontSize = "12px";
  nameInput.style.borderColor = rgb(255, 119, 119);
  nameInput.style.borderWidth = "1px";
  nameParagraph.style.color = rgb(255, 119, 119);
  if (this.value !== '') {
    nameInput.style.opacity = 0.7;
    nameInput.style.borderWidth = "1px";
    nameInput.style.borderColor = 'gray';
    nameParagraph.style.color = 'black';
    nameResult.innerText = " ";

  }

};

//아이디
// const joinIdInput = document.getElementById('join-id-input');
// const joinIdResult = document.getElementById('join-id-result');
// const joinIdParagraph = document.getElementById('join-id-paragraph');
// const joinIdDuplication = document.getElementsById('join-id-button');

// function joinIdDuplicationClickFunction(){
//   if(true){
//     joinIdResult.innerText = "중복된 아이디 입니다.";
//     joinIdResult.style.color = rgb(255, 119, 119);
//     joinIdResult.style.fontSize = "12px";
//     joinIdInput.style.borderColor = rgb(255, 119, 119);
//     joinIdInput.style.borderWidth = "1px";
//     joinIdParagraph.style.color = rgb(255, 119, 119);
//   }else {
//       joinIdInput.style.opacity = 0.7;
//       joinIdInput.style.borderWidth = "1px";
//       joinIdInput.style.borderColor = 'gray';
//       joinIdParagraph.style.color = 'black';
//       joinIdResult.innerText = " ";
//     }
//   }


// // 변수생성
// let joinIdCount = 0;
// //패스워드박스 focus blur 처리 
// joinIdInput.addEventListener('focus', joinIdInputFocusFunction);
// joinIdInput.addEventListener('blur', joinIdInputBlurFunction);
// joinIdInput.addEventListener('keydown', joinIdInputKeydownFunction);
// joinIdDuplication.addEventListener('click', joinIdDuplicationClickFunction);

// //패스워드 박스 함수 처리 
// function joinIdInputFocusFunction() {
//   if (joinIdCount === 0) {
//     joinIdInput.style.outline = "none";
//     joinIdInput.style.borderWidth = "3px";
//     joinIdInput.style.borderColor = '#B2E8F7';
//     joinIdInput.style.opacity = 0.7;
//   } else {
//     joinIdInput.style.outline = "none";
//     joinIdInput.style.borderWidth = "3px";
//     joinIdInput.style.borderColor = "#FEB7B1";
//     joinIdInput.style.borderWidth = "3px";
//   }
//   if (this.value !== '') {
//     joinIdInput.style.outline = "none";
//     joinIdInput.style.opacity = 0.7;
//     joinIdInput.style.borderWidth = "3px";
//     joinIdInput.style.borderColor = '#B2E8F7';
//   }
//   joinIdCount++;
// }

// function joinIdInputBlurFunction() {

//   joinIdResult.innerText = "필수 입력 항목입니다.";
//   joinIdResult.style.color = rgb(255, 119, 119);
//   joinIdResult.style.fontSize = "12px";
//   joinIdInput.style.borderColor = rgb(255, 119, 119);
//   joinIdInput.style.borderWidth = "1px";
//   joinIdParagraph.style.color = rgb(255, 119, 119);

//   if (this.value !== '') {
//     joinIdInput.style.opacity = 0.7;
//     joinIdInput.style.borderWidth = "1px";
//     joinIdInput.style.borderColor = 'gray';
//     joinIdParagraph.style.color = 'black';
//     joinIdResult.innerText = " ";

//   }

// }

// 아이디
const joinIdInput = document.getElementById('join-id-input');
const joinIdResult = document.getElementById('join-id-result');
const joinIdParagraph = document.getElementById('join-id-paragraph');
const joinIdButton = document.getElementById('join-id-button');

// 변수생성
let joinIdCount = 0;

// 중복확인 버튼 클릭 이벤트 처리
joinIdButton.addEventListener('click', joinIdDuplicationClickFunction);

// 아이디 중복 확인 함수
function joinIdDuplicationClickFunction() {

  const isDuplicated = true; // 중복되었다고 가정

  if (joinIdInput.value === '') {
    joinIdResult.innerText = "필수 입력 항목입니다.";
    joinIdResult.style.color = 'rgb(255, 119, 119)';
    joinIdResult.style.fontSize = '12px';
    joinIdInput.style.borderColor = 'rgb(255, 119, 119)';
    joinIdInput.style.borderWidth = '1px';
    joinIdParagraph.style.color = 'rgb(255, 119, 119)';
  } else {
    joinIdInput.style.opacity = 0.7;
    joinIdInput.style.borderWidth = '1px';
    joinIdInput.style.borderColor = 'gray';
    joinIdParagraph.style.color = 'black';
    joinIdResult.innerText = "사용가능한 닉네임입니다.";
    joinIdResult.style.color = '#9CE1F7';
  }
}

// 아이디 박스 함수 처리 
function joinIdInputFocusFunction() {
  if (joinIdCount === 0) {
    joinIdInput.style.outline = "none";
    joinIdInput.style.borderWidth = "3px";
    joinIdInput.style.borderColor = '#B2E8F7';
    joinIdInput.style.opacity = 0.7;
  } else {
    joinIdInput.style.outline = "none";
    joinIdInput.style.borderWidth = "3px";
    joinIdInput.style.borderColor = "#FEB7B1";
    joinIdInput.style.borderWidth = "3px";
  }
  if (this.value !== '') {
    joinIdInput.style.outline = "none";
    joinIdInput.style.opacity = 0.7;
    joinIdInput.style.borderWidth = "3px";
    joinIdInput.style.borderColor = '#B2E8F7';
  }
  joinIdCount++;
}

function joinIdInputBlurFunction() {
  // 아이디 입력란이 비어있을 때만 메시지를 표시합니다.
  if (!joinIdInput.value) {
    joinIdResult.innerText = "필수 입력 항목입니다.";
    joinIdResult.style.color = 'rgb(255, 119, 119)';
    joinIdResult.style.fontSize = '12px';
    joinIdInput.style.borderColor = 'rgb(255, 119, 119)';
    joinIdInput.style.borderWidth = '1px';
    joinIdParagraph.style.color = 'rgb(255, 119, 119)';
  } else {
    // 입력이 되어 있으면 에러 메시지를 숨깁니다.
    joinIdResult.innerText = "";
    joinIdInput.style.opacity = 0.7;
    joinIdInput.style.borderWidth = "1px";
    joinIdInput.style.borderColor = 'gray';
    joinIdParagraph.style.color = 'black';

  }
}

function joinIdInputKeydownFunction() {
  joinIdInput.style.outline = "none";
  joinIdInput.style.opacity = 0.7;
  joinIdInput.style.borderWidth = "3px";
  joinIdInput.style.borderColor = '#B2E8F7';
  joinIdResult.innerText = "";
  joinIdParagraph.style.color = 'black';
}

//패스워드박스 focus blur 처리 
joinIdInput.addEventListener('focus', joinIdInputFocusFunction);
joinIdInput.addEventListener('blur', joinIdInputBlurFunction);
joinIdInput.addEventListener('keydown', joinIdInputKeydownFunction);


// 이메일
const EmailInput = document.getElementById('email-input');
const EmailResult = document.getElementById('email-result');
const EmailParagraph = document.getElementById('email-paragraph');
const EmailButton = document.getElementById('email-button');

// 변수생성
let EmailCount = 0;

// 중복확인 버튼 클릭 이벤트 처리
EmailButton.addEventListener('click', EmailDuplicationClickFunction);

// 이메일 중복 확인 함수
function EmailDuplicationClickFunction() {
  // 여기서 실제 중복 확인 로직을 구현해야 합니다.
  // 지금은 무조건 중복된 이메일로 처리하는 가짜 로직을 사용합니다.
  const isDuplicated = true; // 중복되었다고 가정

  if (EmailInput.value === '') {
    EmailResult.innerText = "필수 입력 항목입니다.";
    EmailResult.style.color = 'rgb(255, 119, 119)';
    EmailResult.style.fontSize = '12px';
    EmailInput.style.borderColor = 'rgb(255, 119, 119)';
    EmailInput.style.borderWidth = '1px';
    EmailParagraph.style.color = 'rgb(255, 119, 119)';
  } else {
    EmailInput.style.opacity = 0.7;
    EmailInput.style.borderWidth = '1px';
    EmailInput.style.borderColor = 'gray';
    EmailParagraph.style.color = 'black';
    EmailResult.innerText = "사용가능한 닉네임입니다.";
    EmailResult.style.color = '#9CE1F7';
  }
}

// 이메일 박스 함수 처리 
function EmailInputFocusFunction() {
  if (EmailCount === 0) {
    EmailInput.style.outline = "none";
    EmailInput.style.borderWidth = "3px";
    EmailInput.style.borderColor = '#B2E8F7';
    EmailInput.style.opacity = 0.7;
  } else {
    EmailInput.style.outline = "none";
    EmailInput.style.borderWidth = "3px";
    EmailInput.style.borderColor = "#FEB7B1";
    EmailInput.style.borderWidth = "3px";
  }
  if (this.value !== '') {
    EmailInput.style.outline = "none";
    EmailInput.style.opacity = 0.7;
    EmailInput.style.borderWidth = "3px";
    EmailInput.style.borderColor = '#B2E8F7';
  }
  EmailCount++;
}

function EmailInputBlurFunction() {
  // 이메일 입력란이 비어있을 때만 메시지를 표시합니다.
  if (!EmailInput.value) {
    EmailResult.innerText = "필수 입력 항목입니다.";
    EmailResult.style.color = 'rgb(255, 119, 119)';
    EmailResult.style.fontSize = '12px';
    EmailInput.style.borderColor = 'rgb(255, 119, 119)';
    EmailInput.style.borderWidth = '1px';
    EmailParagraph.style.color = 'rgb(255, 119, 119)';
  } else {
    // 입력이 되어 있으면 에러 메시지를 숨깁니다.
    EmailResult.innerText = "";
    EmailInput.style.opacity = 0.7;
    EmailInput.style.borderWidth = "1px";
    EmailInput.style.borderColor = 'gray';
    EmailParagraph.style.color = 'black';

  }
}

function EmailInputKeydownFunction() {
  EmailInput.style.outline = "none";
  EmailInput.style.opacity = 0.7;
  EmailInput.style.borderWidth = "3px";
  EmailInput.style.borderColor = '#B2E8F7';
  EmailResult.innerText = "";
  EmailParagraph.style.color = 'black';
}

//이미지박스 focus blur 처리 
EmailInput.addEventListener('focus', EmailInputFocusFunction);
EmailInput.addEventListener('blur', EmailInputBlurFunction);
EmailInput.addEventListener('keydown', EmailInputKeydownFunction);

// 닉네임
const joinNicknameInput = document.getElementById('join-nickname-input');
const joinNicknameResult = document.getElementById('join-nickname-result');
const joinNicknameParagraph = document.getElementById('join-nickname-paragraph');
const joinNicknameButton = document.getElementById('join-nickname-button');

// 변수생성
let joinNicknameCount = 0;

// 중복확인 버튼 클릭 이벤트 처리
joinNicknameButton.addEventListener('click', joinNicknameDuplicationClickFunction);

// 닉네임 중복 확인 함수
function joinNicknameDuplicationClickFunction() {
  // 여기서 실제 중복 확인 로직을 구현해야 합니다.
  // 지금은 무조건 중복된 닉네임으로 처리하는 가짜 로직을 사용합니다.
  const isDuplicated = true; // 중복되었다고 가정

  if (joinNicknameInput.value === '') {
    joinNicknameResult.innerText = "필수 입력 항목입니다.";
    joinNicknameResult.style.color = 'rgb(255, 119, 119)';
    joinNicknameResult.style.fontSize = '12px';
    joinNicknameInput.style.borderColor = 'rgb(255, 119, 119)';
    joinNicknameInput.style.borderWidth = '1px';
    joinNicknameParagraph.style.color = 'rgb(255, 119, 119)';
  } else {
    joinNicknameInput.style.opacity = 0.7;
    joinNicknameInput.style.borderWidth = '1px';
    joinNicknameInput.style.borderColor = 'gray';
    joinNicknameParagraph.style.color = 'black';
    joinNicknameResult.innerText = "사용가능한 닉네임입니다";
    joinNicknameResult.style.color = '#9CE1F7';
  }
}

// 닉네임 박스 함수 처리 
function joinNicknameInputFocusFunction() {
  if (joinNicknameCount === 0) {
    joinNicknameInput.style.outline = "none";
    joinNicknameInput.style.borderWidth = "3px";
    joinNicknameInput.style.borderColor = '#B2E8F7';
    joinNicknameInput.style.opacity = 0.7;
  } else {
    joinNicknameInput.style.outline = "none";
    joinNicknameInput.style.borderWidth = "3px";
    joinNicknameInput.style.borderColor = "#FEB7B1";
    joinNicknameInput.style.borderWidth = "3px";
  }
  if (this.value !== '') {
    joinNicknameInput.style.outline = "none";
    joinNicknameInput.style.opacity = 0.7;
    joinNicknameInput.style.borderWidth = "3px";
    joinNicknameInput.style.borderColor = '#B2E8F7';
  }
  joinNicknameCount++;
}

function joinNicknameInputBlurFunction() {
  // 닉네임 입력란이 비어있을 때만 메시지를 표시합니다.
  if (!joinNicknameInput.value) {
    joinNicknameResult.innerText = "필수 입력 항목입니다.";
    joinNicknameResult.style.color = 'rgb(255, 119, 119)';
    joinNicknameResult.style.fontSize = '12px';
    joinNicknameInput.style.borderColor = 'rgb(255, 119, 119)';
    joinNicknameInput.style.borderWidth = '1px';
    joinNicknameParagraph.style.color = 'rgb(255, 119, 119)';
  } else {
    // 입력이 되어 있으면 에러 메시지를 숨깁니다.
    joinNicknameResult.innerText = "";
    joinNicknameInput.style.opacity = 0.7;
    joinNicknameInput.style.borderWidth = "1px";
    joinNicknameInput.style.borderColor = 'gray';
    joinNicknameParagraph.style.color = 'black';
  }
}

function joinNicknameInputKeydownFunction() {
  joinNicknameInput.style.outline = "none";
  joinNicknameInput.style.opacity = 0.7;
  joinNicknameInput.style.borderWidth = "3px";
  joinNicknameInput.style.borderColor = '#B2E8F7';
  joinNicknameResult.innerText = "";
  joinNicknameParagraph.style.color = 'black';
}

//패스워드박스 focus blur 처리 
joinNicknameInput.addEventListener('focus', joinNicknameInputFocusFunction);
joinNicknameInput.addEventListener('blur', joinNicknameInputBlurFunction);
joinNicknameInput.addEventListener('keydown', joinNicknameInputKeydownFunction);




//keydown 함수

function nameInputKeydownFunction() {
  nameInput.style.outline = "none";
  nameInput.style.opacity = 0.7;
  nameInput.style.borderWidth = "3px";
  nameInput.style.borderColor = '#B2E8F7';
  nameResult.innerText = "";
  nameParagraph.style.color = 'black';
}

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
}

//생년월일 

const editBirthResult = document.getElementById('edit-birth-result');
const editBirthParagraph = document.getElementById('edit-birth-paragraph');
const editBirthInput = document.getElementsByClassName('edit-birth-year');

for (let i = 0; i < editBirthInput.length; i++) {
  editBirthInput[i].addEventListener('blur', editBirthInputBlurFunction);
}

function editBirthInputBlurFunction() {
  console.log(this.value);

  if (this.value === '') {
    editBirthResult.style.fontSize = '12px';
    editBirthResult.style.color = 'red';
    editBirthResult.innerText = "필수 입력 항목입니다. ";

  } else

    if (this.value >= 1900 && this.value <= 2024) {
      editBirthResult.innerText = " ";

    } else {
      editBirthResult.style.fontSize = '12px';
      editBirthResult.style.color = 'red';
      editBirthResult.innerText = "범위를 벗어났습니다. 다시 입력해주세요";
    }

};

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