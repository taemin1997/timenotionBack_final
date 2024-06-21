function rgb(r, g, b) {
  return `rgb(${Math.round(r)}, ${Math.round(g)}, ${Math.round(b)})`;
}

const findInput = document.getElementById('find-input');
const findResult = document.getElementById('find-result');
const findButton = document.getElementsByClassName("find-button")[0];
let findCount = 0;

findInput.addEventListener('focus', findInputFocusFunction);
findInput.addEventListener('blur', findInputBlurFunction);
findInput.addEventListener('keydown', findInputKeydownFunction);

function findInputFocusFunction(){
  if(findCount === 0){
    findInput.style.outline = "none";
    findInput.style.borderWidth = "3px";
    findInput.style.borderColor = '#B2E8F7';
    findInput.style.opacity = 0.7;
  } else {
    findInput.style.outline = "none";
    findInput.style.borderWidth = "3px";
    findInput.style.borderColor = "#FEB7B1";
    findInput.style.borderWidth = "3px";
  }
  if(this.value !== ''){
    findInput.style.outline = "none";
    findInput.style.opacity = 0.7;
    findInput.style.borderWidth = "3px";
    findInput.style.borderColor = '#B2E8F7';
  }
  findCount++;
}

function findInputBlurFunction(){
  findResult.innerText = "필수 입력 항목입니다.";
  findResult.style.color = rgb(255, 119, 119);
  findResult.style.fontSize = "12px";
  findInput.style.borderColor =  rgb(255, 119, 119);
  findInput.style.borderWidth = "1px";
  findInput.style.marginBottom = "5px";
  if(this.value !== ''){
    findInput.style.opacity = 0.7;
    findInput.style.borderWidth = "1px";
    findInput.style.borderColor = 'gray';
    findResult.innerText = " ";
  }
}

function findInputKeydownFunction(){
  findInput.style.outline = "none";
  findInput.style.opacity = 0.7;
  findInput.style.borderWidth = "3px";
  findInput.style.borderColor = '#B2E8F7';
  findResult.innerText = "";
}

findButton.addEventListener('click', findButtonClickFunction);

function findButtonClickFunction(){
  if(findInput.value === ''){
    findResult.innerText = "필수 입력 항목입니다.";
    findResult.style.color = rgb(255, 119, 119);
    findResult.style.fontSize = "12px";
    findInput.style.borderColor =  rgb(255, 119, 119);
    findInput.style.borderWidth = "1px";
    findInput.style.marginBottom = "5px";
  }
}

// // 이메일 인증 번호
// $checkEmail.click(function() {
//   $.ajax({
//     type : "POST",
//     url : "login/passwordFind2",
//     data : {
//       "email" : $memail.val()
//     },
//     success : function(data){
//       alert("해당 이메일로 인증번호 발송이 완료되었습니다. \n 확인부탁드립니다.")
//       console.log("data : "+data);
//       chkEmailConfirm(data, $memailconfirm, $memailconfirmTxt);
//     }
//   })
// })
// // 이메일 인증번호 체크 함수
// function chkEmailConfirm(data, $memailconfirm, $memailconfirmTxt){
//   $memailconfirm.on("keyup", function(){
//     if (data != $memailconfirm.val()) { //
//       emconfirmchk = false;
//       $memailconfirmTxt.html("<span id='emconfirmchk'>인증번호가 잘못되었습니다</span>")
//       $("#emconfirmchk").css({
//         "color" : "#FA3E3E",
//         "font-weight" : "bold",
//         "font-size" : "10px"
//
//       })
//       //console.log("중복아이디");
//     } else { // 아니면 중복아님
//       emconfirmchk = true;
//       $memailconfirmTxt.html("<span id='emconfirmchk'>인증번호 확인 완료</span>")
//
//       $("#emconfirmchk").css({
//         "color" : "#0D6EFD",
//         "font-weight" : "bold",
//         "font-size" : "10px"
//
//       })
//     }
//   })
// }