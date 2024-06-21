function rgb(r, g, b) {
  return `rgb(${Math.round(r)}, ${Math.round(g)}, ${Math.round(b)})`;
}

// 이메일
const EmailInput = document.getElementById('email-input');
const EmailResult = document.getElementById('email-result');
const EmailParagraph = document.getElementById('email-paragraph');
const EmailButton = document.getElementById('email-button');
const countdownDisplay = document.getElementById('countdown');


// 변수생성
let EmailCount = 0;

// 중복확인 버튼 클릭 이벤트 처리
// EmailButton.addEventListener('click', EmailDuplicationClickFunction);



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



EmailButton.addEventListener('click', function() {
  if (EmailInput.value === '') {
    EmailResult.innerText = "필수 입력 항목입니다.";
    EmailResult.style.color = 'rgb(255, 119, 119)';
    EmailResult.style.fontSize = '12px';
    EmailInput.style.borderColor = 'rgb(255, 119, 119)';
    EmailInput.style.borderWidth = '1px';
    EmailParagraph.style.color = 'rgb(255, 119, 119)';
  } else{startCountdown(10); // 3분(180초)으로 초기화한 카운트다운 시작}
}
});

function startCountdown(seconds) {
  let remainingTime = seconds;

  // 1초마다 카운트다운 갱신
  const countdownTimer = setInterval(function() {

    const minutes = Math.floor(remainingTime / 60);
    const seconds = remainingTime % 60;
    countdownDisplay.textContent = `${minutes}분 ${seconds}초`;

    // 남은 시간이 0보다 작거나 같으면 카운트다운 종료
    if (remainingTime <= 0) {
      clearInterval(countdownTimer);
      countdownDisplay.textContent = '0분 0초';
    } else {
      remainingTime--; // 1초씩 감소
    }
  }, 1000);
}


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
  console.log(1111);
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


function nameInputKeydownFunction() {
  nameInput.style.outline = "none";
  nameInput.style.opacity = 0.7;
  nameInput.style.borderWidth = "3px";
  nameInput.style.borderColor = '#B2E8F7';
  nameResult.innerText = "";
  nameParagraph.style.color = 'black';
}

const button = document.getElementsByClassName("submit2");

// HTMLCollection 내의 모든 버튼에 대해 반복문을 통해 이벤트 리스너를 추가합니다.
for (let i = 0; i < button.length; i++) {
  button[i].addEventListener('click', functionSubmit);
}

function functionSubmit() {
  if (nameInput.value === '') {
    nameResult.innerText = "필수 입력 항목입니다.";
    nameResult.style.color = rgb(255, 119, 119);
    console.log(1111);
    nameResult.style.fontSize = "12px";
    nameInput.style.borderColor = rgb(255, 119, 119);
    nameInput.style.borderWidth = "1px";
    nameParagraph.style.color = rgb(255, 119, 119);
  } else {
    nameInput.style.opacity = 0.7;
    nameInput.style.borderWidth = "1px";
    nameInput.style.borderColor = 'gray';
    nameParagraph.style.color = 'black';
    nameResult.innerText = " ";
  }
}
