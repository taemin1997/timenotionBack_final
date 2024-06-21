//rgb 재정의
function rgb(r, g, b) {
  return `rgb(${Math.round(r)}, ${Math.round(g)}, ${Math.round(b)})`;
}

//현재 비밀번호 
//비밀번호

const editOriPasswordInput = document.getElementById('edit-ori-password-input');
const editOriPasswordResult = document.getElementById('edit-ori-password-result');
const editOriPasswordParagraph = document.getElementById('edit-ori-password-paragraph');

// 변수생성
let editOriPasswordCount = 0 ;
//패스워드박스 focus blur 처리 
editOriPasswordInput.addEventListener('focus', editOriPasswordInputFocusFunction);
editOriPasswordInput.addEventListener('blur',editOriPasswordInputBlurFunction);
editOriPasswordInput.addEventListener('keydown',editOriPasswordInputKeydownFunction);

//패스워드 박스 함수 처리 
function editOriPasswordInputFocusFunction(){
  if(editOriPasswordCount ===0 ){
    editOriPasswordInput.style.outline = "none";
    editOriPasswordInput.style.opacity = 0.7;
    editOriPasswordInput.style.borderWidth = "3px";
    editOriPasswordInput.style.borderColor = '#B2E8F7';
  }else{
    editOriPasswordInput.style.outline = "none";
    editOriPasswordInput.style.borderWidth = "3px";
    editOriPasswordInput.style.borderColor = "#FEB7B1";
    editOriPasswordInput.style.borderWidth = "3px";
  }
  if(this.value !== ''){
    editOriPasswordInput.style.outline = "none";
    editOriPasswordInput.style.opacity = 0.7;
    editOriPasswordInput.style.borderWidth = "3px";
    editOriPasswordInput.style.borderColor = '#B2E8F7';
  }
  editOriPasswordCount++;
}

function editOriPasswordInputBlurFunction(){
 
  editOriPasswordResult.innerText = "필수 입력 항목입니다.";
  editOriPasswordResult.style.color = rgb(255, 119, 119);
  editOriPasswordResult.style.fontSize = "12px";
  editOriPasswordInput.style.borderColor =  rgb(255, 119, 119);
  editOriPasswordInput.style.borderWidth = "1px";
  editOriPasswordInput.style.marginBottom = "5px";
  editOriPasswordParagraph.style.color =  rgb(255, 119, 119);
  if(this.value !== ''){
    editOriPasswordInput.style.opacity = 0.7;
    editOriPasswordInput.style.borderWidth = "1px";
    editOriPasswordInput.style.borderColor = 'gray';
    editOriPasswordParagraph.style.color =  'black';
    editOriPasswordResult.innerText = " ";

  }

};

function editOriPasswordInputKeydownFunction(){
  editOriPasswordInput.style.outline = "none";
  editOriPasswordInput.style.opacity = 0.7;
  editOriPasswordInput.style.borderWidth = "3px";
  editOriPasswordInput.style.borderColor = '#B2E8F7';
  editOriPasswordResult.innerText = "";
  editOriPasswordParagraph.style.color =  'black';
}













//새 비밀번호

const editPasswordInput = document.getElementById('edit-password-input');
const editPasswordResult = document.getElementById('edit-password-result');
const editPasswordParagraph = document.getElementById('edit-password-paragraph');

// 변수생성
let editPasswordCount = 0 ;
//패스워드박스 focus blur 처리 
editPasswordInput.addEventListener('focus', editPasswordInputFocusFunction);
editPasswordInput.addEventListener('blur',editPasswordInputBlurFunction);
editPasswordInput.addEventListener('keydown',editPasswordInputKeydownFunction);

//패스워드 박스 함수 처리 
function editPasswordInputFocusFunction(){
  if(editPasswordCount ===0 ){
    editPasswordInput.style.outline = "none";
    editPasswordInput.style.opacity = 0.7;
    editPasswordInput.style.borderWidth = "3px";
    editPasswordInput.style.borderColor = '#B2E8F7';
  }else{
    editPasswordInput.style.outline = "none";
    editPasswordInput.style.borderWidth = "3px";
    editPasswordInput.style.borderColor = "#FEB7B1";
    editPasswordInput.style.borderWidth = "3px";
  }
  if(this.value !== ''){
    editPasswordInput.style.outline = "none";
    editPasswordInput.style.opacity = 0.7;
    editPasswordInput.style.borderWidth = "3px";
    editPasswordInput.style.borderColor = '#B2E8F7';
  }
  editPasswordCount++;
}

function editPasswordInputBlurFunction(){
 
  editPasswordResult.innerText = "필수 입력 항목입니다.";
  editPasswordResult.style.color = rgb(255, 119, 119);
  editPasswordResult.style.fontSize = "12px";
  editPasswordInput.style.borderColor =  rgb(255, 119, 119);
  editPasswordInput.style.borderWidth = "1px";
  editPasswordInput.style.marginBottom = "5px";
  editPasswordParagraph.style.color =  rgb(255, 119, 119);
  if(this.value !== ''){
    editPasswordInput.style.opacity = 0.7;
    editPasswordInput.style.borderWidth = "1px";
    editPasswordInput.style.borderColor = 'gray';
    editPasswordParagraph.style.color =  'black';
    editPasswordResult.innerText = " ";

  }

}
function editPasswordInputKeydownFunction(){
  editPasswordInput.style.outline = "none";
  editPasswordInput.style.opacity = 0.7;
  editPasswordInput.style.borderWidth = "3px";
  editPasswordInput.style.borderColor = '#B2E8F7';
  editPasswordResult.innerText = "";
  editPasswordParagraph.style.color =  'black';
}


//비밀번호 확인 


const editPasswordCheckInput = document.getElementById('edit-password-check-input');
const editPasswordCheckResult = document.getElementById('edit-password-check-result');
const editPasswordCheckParagraph = document.getElementById('edit-password-check-paragraph');

// 변수생성
let editPasswordCheckCount = 0 ;
//패스워드박스 focus blur 처리 
editPasswordCheckInput.addEventListener('focus', editPasswordCheckInputFocusFunction);
editPasswordCheckInput.addEventListener('blur',editPasswordCheckInputBlurFunction);
editPasswordCheckInput.addEventListener('keydown',editPasswordCheckInputKeydownFunction);

//패스워드 박스 함수 처리 
function editPasswordCheckInputFocusFunction(){
  if(editPasswordCheckCount ===0 ){
    editPasswordCheckInput.style.outline = "none";
    editPasswordCheckInput.style.borderWidth = "3px";
    editPasswordCheckInput.style.borderColor = '#B2E8F7';
    editPasswordCheckInput.style.opacity = 0.7;
  }else{
    editPasswordCheckInput.style.outline = "none";
    editPasswordCheckInput.style.borderWidth = "3px";
    editPasswordCheckInput.style.borderColor = "#FEB7B1";
    editPasswordCheckInput.style.borderWidth = "3px";
  }
  if(this.value !== ''){
    editPasswordCheckInput.style.outline = "none";
    editPasswordCheckInput.style.opacity = 0.7;
    editPasswordCheckInput.style.borderWidth = "3px";
    editPasswordCheckInput.style.borderColor = '#B2E8F7';
  }
  editPasswordCheckCount++;
}

function editPasswordCheckInputBlurFunction(){
 
  editPasswordCheckResult.innerText = "확인을 위해 비밀번호를 한 번 더 입력해주세요..";
  editPasswordCheckResult.style.color = rgb(255, 119, 119);
  editPasswordCheckResult.style.fontSize = "12px";
  editPasswordCheckInput.style.borderColor =  rgb(255, 119, 119);
  editPasswordCheckInput.style.borderWidth = "1px";
  editPasswordCheckInput.style.marginBottom = "5px";
  editPasswordCheckParagraph.style.color =  rgb(255, 119, 119);
  if(this.value !== ''){
    editPasswordCheckInput.style.opacity = 0.7;
    editPasswordCheckInput.style.borderWidth = "1px";
    editPasswordCheckInput.style.borderColor = 'gray';
    editPasswordCheckParagraph.style.color =  'black';
    editPasswordCheckResult.innerText = " ";

  }

};
function editPasswordCheckInputKeydownFunction(){
  editPasswordCheckInput.style.outline = "none";
  editPasswordCheckInput.style.opacity = 0.7;
  editPasswordCheckInput.style.borderWidth = "3px";
  editPasswordCheckInput.style.borderColor = '#B2E8F7';
  editPasswordCheckResult.innerText = "";
  editPasswordCheckParagraph.style.color =  'black';
};


//버튼 클릭했는데 빈 값 표시하기 
const SaveButton = document.getElementsByClassName("save-button");


for (let i = 0; i < SaveButton.length; i++) {
  SaveButton[i].addEventListener('click', editSaveButtonClickFunction);
};

//버튼을 클릭했을때 값이 입력되지않으면 빨간 표시가 뜨게 설정
function editSaveButtonClickFunction(){
  //현재 비밀번호
  if(editOriPasswordInput.value ===''){
    console.log("값이 안들어있음");
    editOriPasswordResult.innerText = "필수 입력 항목입니다.";
    editOriPasswordResult.style.color = rgb(255, 119, 119);
    editOriPasswordResult.style.fontSize = "12px";
    editOriPasswordInput.style.borderColor =  rgb(255, 119, 119);
    editOriPasswordInput.style.borderWidth = "1px";
    editOriPasswordInput.style.marginBottom = "5px";
    editOriPasswordParagraph.style.color =  rgb(255, 119, 119);
  }
  // //새 비밀번호
  if(editPasswordInput.value === ''){
    editPasswordResult.innerText = "확인을 위해 비밀번호를 한 번 더 입력해주세요..";
    editPasswordResult.style.color = rgb(255, 119, 119);
    editPasswordResult.style.fontSize = "12px";
    editPasswordInput.style.borderColor =  rgb(255, 119, 119);
    editPasswordInput.style.borderWidth = "1px";
    editPasswordInput.style.marginBottom = "5px";
    editPasswordParagraph.style.color =  rgb(255, 119, 119);
    console.log(editPasswordCheckInput.value);
  }
  //새 비밀번호 확인 
  if(editPasswordCheckInput.value === ''){
    editPasswordCheckResult.innerText = "확인을 위해 비밀번호를 한 번 더 입력해주세요..";
    editPasswordCheckResult.style.color = rgb(255, 119, 119);
    editPasswordCheckResult.style.fontSize = "12px";
    editPasswordCheckInput.style.borderColor =  rgb(255, 119, 119);
    editPasswordCheckInput.style.borderWidth = "1px";
    editPasswordCheckInput.style.marginBottom = "5px";
    editPasswordCheckParagraph.style.color =  rgb(255, 119, 119);
    console.log(editPasswordCheckInput.value);
  }
  //새 비밀번호와 비밀번호 확인 일치여부
  if(editPasswordCheckInput.value !== editPasswordInput.value){
    console.log("2");
    editPasswordCheckResult.innerText = "비밀번호와 일치하지 않습니다.";
    editPasswordCheckResult.style.color = rgb(255, 119, 119);
    editPasswordCheckResult.style.fontSize = "12px";
    editPasswordCheckInput.style.borderColor =  rgb(255, 119, 119);
    editPasswordCheckInput.style.borderWidth = "1px";
    editPasswordCheckInput.style.marginBottom = "5px";
    editPasswordCheckParagraph.style.color =  rgb(255, 119, 119);
  }};




//새 비밀번호 변수 , 비밀번호 확인 변수 
//   const editPasswordInput = document.getElementById('edit-password-input');
// const editPasswordResult = document.getElementById('edit-password-result');
// const editPasswordParagraph = document.getElementById('edit-password-paragraph');

// const editPasswordCheckInput = document.getElementById('edit-password-check-input');
// const editPasswordCheckResult = document.getElementById('edit-password-check-result');
// const editPasswordCheckParagraph = document.getElementById('edit-password-check-paragraph');


editPasswordInput.addEventListener('keyup', editPasswordInputKeyupFunction);
editPasswordCheckInput.addEventListener('keyup', editPasswordCheckInputKeyupFunction);

  function editPasswordInputKeyupFunction() {
    editPasswordInput.style.outline = "none";
    editPasswordInput.style.opacity = 0.7;
    editPasswordInput.style.borderWidth = "3px";
    editPasswordInput.style.borderColor = '#B2E8F7';
    editPasswordResult.innerText = "";
    editPasswordParagraph.style.color = 'black';
    editCheckPasswordMatch();
  }

  function editPasswordCheckInputKeyupFunction() {
    editPasswordCheckInput.style.outline = "none";
    editPasswordCheckInput.style.opacity = 0.7;
    editPasswordCheckInput.style.borderWidth = "3px";
    editPasswordCheckInput.style.borderColor = '#B2E8F7';
    editPasswordCheckResult.innerText = "";
    editPasswordCheckParagraph.style.color = 'black';
    editCheckPasswordMatch();
  }

//비밀번호 일치 확인
function editCheckPasswordMatch() {
  const password = editPasswordInput.value;
  const confirmPassword = editPasswordCheckInput.value;

  if (password === confirmPassword && password !== '' && confirmPassword !== '') {
    editPasswordCheckResult.innerText = "비밀번호가 일치합니다.";
    editPasswordCheckResult.style.color = '#9CE1F7';
  } else if (password !== confirmPassword && password !== '' && confirmPassword !== '') {
    editPasswordCheckResult.innerText = "비밀번호가 일치하지 않습니다.";
    editPasswordCheckResult.style.color = 'rgb(255, 119, 119)';
  } else {
    editPasswordCheckResult.innerText = "";
  }
}