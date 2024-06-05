// ---- 삭제 문구 ---- //
// function del() {
//   if (confirm('정말 삭제하시겠습니까?')) list_ok.submit();
// }

// ---- 좋아요 하트 구현 ---- //

const heartImage = document.getElementById('heartImage');

heartImage.addEventListener('click', changeHeartColor);

function changeHeartColor() {
  if (heartImage.classList.contains('red')) {
    heartImage.classList.remove('red');
  } else {
    heartImage.classList.add('red');
  }
}

// ---- 댓글 구현 ---- //

function toggleReplyInput(comment) {
  const replyInput = comment.parentElement.querySelector('.box-re-comment-btn');

  replyInput.style.display = replyInput.style.display === 'none' ? 'flex' : 'none';
}

/* 1. 신고 모달  택스트 비활성화--------------------------------------------*/

$(document).ready(function () {
  // 텍스트 입력창을 기본적으로 비활성화
  $('.report-input').prop('disabled', true);

  $('input[name="report-reason"]').change(function () {
    if ($('#g').is(':checked')) {
      $('.report-input').prop('disabled', false); // 활성화
    } else {
      $('.report-input').prop('disabled', true); // 비활성화
    }
  });
});

/* 2. '점점점' 누르면 버튼 나오게 */
$('.dotdotdot').on('click', function (e) {
  console.log("점점점 클릭됨");
  // console.log($(this).next);
  // console.log(e.currentTarget.next);
  $('.box-mini-report').css('display', 'none');
  $(e.target).next().css('display', 'flex'); /* 누른거만 나오게  */
});

/* 3. '신고하기' 누르면 '신고모달' 뜸 */
$('.box-mini-report').on('click', function () {
  $('.box-mini-report').css('display', 'none');
  $('.report').css('display', 'flex');

  $('.dotdotdot').on('click', function (e) {
    $('.report').css('display', 'none');
  });
});
/* 4. '닫기' 누르면 닫히게 */
$('.report-btn-close').on('click', function () {
  $('.report').css('display', 'none');
});
$('.report-btn-report').on('click', function () {
  $('.report').css('display', 'none');
});

/* 5. 바깥 클릭 -> 모달 숨기기 */
$(document).on('click', function (e) {
  if (!$(e.target).closest('.dotdotdot, .box-mini-report, .report').length) {
    $('.box-mini-report').css('display', 'none');
    $('.report').css('display', 'none');
  }
}); // 클릭한 html 요소가 . 얘네랑 일치하지 . length(객체에 포함된 요소 수를 반환함, 하나라도 일치하면 length가 적어도 1이 되는 것)

{   // 버튼 처리
  let $modifyBtn = document.querySelector('.btn-modify');
  let $removeBtn = document.querySelector('.btn-remove');
  let $backBtn = document.querySelector('.btn-back');

  //삭제버튼 처림
  $removeBtn?.addEventListener("click", function () {
    let boardId = this.dataset.id; //클릭된 요소의 data-id 속성값을 가져와 boardId 변수에 저장
    //this : 이벤트 핸들러 안에서 이벤트가 발생한 요소(클릭한 요소)
    //dataset : dataset 객체는 요소의 모든 data-* 속성을 포함
    //  ex) dataset.id ="123"
    //id : data-id 속성의 값을 가져온다
    location.href = `/myLife/remove?boardId=${boardId}`;
  });

  //수정 버튼 처리
  $modifyBtn?.addEventListener("click", function () {
    let boardId = this.dataset.id; //클릭된 요소의 data-id 속성값을 가져와 변수에 저장
    console.log(boardId)
    location.href = `/myLife/update_writingMode?boardId=${boardId}`;
  });

  //뒤로가기 버튼
  $backBtn?.addEventListener("click", function () {
    window.history.back() //브라우저의 이전 페이지로 이동
  });
}

//상세 페이지에서 이미지 띄우기
let boardId = document.querySelector('#boardId').value;
displayImgAjax(); //이미지 표시 함수 호출
//Ajax : Asynchronous JavaScript and XML
// JS와 XML을 활용하여 비동기 통신으로 데이터를 교환하는 기법
// Ajax라는 기술을 활용하는 방법은 여러가지가 있지만 우리는 fetchAPI를 사용한다.
function displayImgAjax() {
  // fetch()함수는 js에 내장된 함수이므로 바로 사용하면된다.
  /*
  fetch('api주소', {설정객체})
      .then(함수)       // api에서 보낸 응답을 then으로 받는다.
      .then(함수);      // 위의 then에서 반환하는 값을 여기서 받는다.

   */
  // fetch(`/v1/boards/${boardId}/files`, {method : 'GET'})
  //     .then(res => res.json()) // 응답을 받아서 데이터를 변환하고 다음 then으로 넘겨준다.
  //     .then(data => console.log(data))  // 위에서 넘겨준 데이터를 올바르게 처리한다.


  fetch(`/v1/boards/${boardId}/files`, {method: 'GET'})
      //서버에 GET요청을 보내 파일 목록을 가져옴
      .then(res => res.json())//응답을 JSON으로 변환
      .then(list => { //변환된 데이터를 list 변수에 저장
        let tags = ''; //HTML 태그를 저장할 변수 초기화

        console.log(list);
        for (let i = 0; i < list.length; i++) {
          let fileName = list[i].boardFileSourceName + '/' + list[i].boardFileUuid + '_' + list[i].boardFileName;
          //파일 경로 조합

          tags += ` <img src="/v1/files?fileName=${fileName}" data-id="${list[i].boardFileId}" data-name="${fileName}"/> `;
        }

        let $postImgs = document.querySelector('.post-images'); //이미지가 삽입될 요소

        $postImgs.innerHTML = tags; //생성된 html 태그를 삽입
      });
}

//제목 배경 색 변경
// document.addEventListener("DOMContentLoaded", function() {
//   const boardTitleDiv = document.getElementsByClassName('wrapper-title');
//   const boardLifeCycle = [[${boards.boardLifeCycle}]]; // 서버에서 전달된 값을 여기에 할당
//
//   switch(boardLifeCycle) {
//     case '유아기':
//       boardTitleDiv.classList.add('infant');
//       break;
//     case '유년기':
//       boardTitleDiv.classList.add('childhood');
//       break;
//     case '아동기':
//       boardTitleDiv.classList.add('schoolage');
//       break;
//     case '청소년기':
//       boardTitleDiv.classList.add('adolescence');
//       break;
//     case '청년기':
//       boardTitleDiv.classList.add('youngadult');
//       break;
//     case '중년기':
//       boardTitleDiv.classList.add('midlife');
//       break;
//     case '노년기':
//       boardTitleDiv.classList.add('senior');
//       break;
//     default:
//       break;
//   }
// });
