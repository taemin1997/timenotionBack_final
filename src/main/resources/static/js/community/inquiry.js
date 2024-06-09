// const paging = document.querySelector('.inquiry-paging');
// let page = 1;
// const showContent = 7;
// let contentCount = document.querySelectorAll('.inquiry-contents').length;
// let endPage = Math.ceil((contentCount / showContent));

// const inquiryModal = document.querySelector('.inquiry-modal');
// const modalBtn = document.querySelector('.inquiry-button button[type="button"]');
// // const modalExitBtn = document.querySelector('.inquiry-modal-btns button[type="button"]');
// // const inquiryModalTitle = document.querySelector('.inquiry-modal-title input[type="text"]');
// // const inquiryAnswerModalDelete = document.querySelector('.inquiry-modal-answer-delete');
// // const inquiryAnswerModalexit = document.querySelector('.inquiry-modal-answer-exit');
// // const inquiryAnswerModal = document.querySelector('#inquiry-modal-answer');
// // const answerModalBtn = document.querySelectorAll('.inquiry-content-button');
// //
// // //
// modalBtn.addEventListener('click', () => {
//   inquiryModal.style.display = 'flex';
// });
//
// modalExitBtn.addEventListener('click', () => {
//   inquiryModal.style.display = 'none';
// });
//
//
// inquiryAnswerModalDelete.addEventListener('click', ()=>{
//   let check = confirm('삭제하겠습니까?');
//   if(check){
//
//   }else{
//     inquiryAnswerModal.style.display = 'none';
//   }
// });
//
// inquiryAnswerModalexit.addEventListener('click', () => {
//   inquiryAnswerModal.style.display = 'none';
// });
//
// answerModalBtn.forEach((btn) => {
//   btn.addEventListener('click', () =>{
//     inquiryAnswerModal.style.display = 'block';
//   })
// });


$(document).ready(function() {
  // "물어보세요" 버튼 클릭 시
  $('.inquiry-button button').click(function(){
    // inquiry-modal을 표시합니다.
    $('.inquiry-modal').css('display', 'block');
  });

  // "닫기" 버튼 클릭 시
  $('.inquiry-modal-btns button[type="button"]').click(function(){
    // inquiry-modal을 숨깁니다.
    $('.inquiry-modal').css('display', 'none');
  });

  // 문의 내용을 클릭했을 때
  $('.inquiry-content-button').on('click', function() {
    let inquiryId = $(this).data('inquiryid');
    let userId = $(this).data('userid');
    let uniId = $(this).data('uniid');
    console.log('inquiryId:', inquiryId);
    console.log('userid: ', userId);
    console.log('uniId: ' + uniId);


    if (!inquiryId) {
      console.error('없어요');
      return;
    }

    // 서버에서 해당 문의의 정보를 가져옵니다.
    $.ajax({
      url: '/community/inquiry/' + inquiryId,
      method: 'GET',
      success: function(data) {
        console.log('받은 데이터:', data);
        // 공개 여부를 확인하여 비공개이면 모달을 열지 않습니다.
        if (data.inquiryPublic === "X" && userId !== uniId && uniId !== 1) {
          alert("비공개 문의글");
          return;
        }

        // 가져온 데이터를 모달에 표시합니다.
        $('.inquiry-modal-answer-title').text(data.inquiryTitle);
        $('.inquiry-modal-answer-content').text(data.inquiryContent);
        $('.inquiry-modal-answer-realAnswer').text(data.inquiryResponse);
        $('#inquiry-modal-answer').attr('data-inquiryid', inquiryId);
        $('#inquiry-modal-answer').attr('data-userid', userId);
        $('#inquiry-modal-answer').show();

        // 가져온 사용자 정보를 비교하여 삭제 버튼을 표시하거나 숨깁니다.
        $.ajax({
          url: '/api/getUserInfo',
          method: 'GET',
          success: function(userInfo) {
            console.log('사용자 정보:', userInfo);
            console.log('작성자:', userId);
            if (userInfo === userId) {
              // 현재 사용자와 문의 작성자가 일치하면 삭제 버튼을 표시합니다.
              $('.inquiry-modal-answer-delete').show();
            } else {
              // 다른 사용자가 작성한 문의에 대한 답변이므로 삭제 버튼을 숨깁니다.
              $('.inquiry-modal-answer-delete').hide();
            }
          },
          error: function(error) {
            console.error("사용자 정보를 가져오는 중 에러 발생:", error);
          }
        });
      },
      error: function(error) {
        console.error("문의 정보를 가져오는 중 에러 발생:", error);
      }
    });
  });

  // "답변 모달 닫기" 버튼 클릭 시
  $('.inquiry-modal-answer-exit').on('click', function() {
    // 답변 모달을 숨깁니다.
    $('#inquiry-modal-answer').hide();
  });

  // "삭제" 버튼 클릭 시
  $('.inquiry-modal-answer-delete').on('click', function() {
    if (confirm('삭제할래요?')) {
      let inquiryId = $('#inquiry-modal-answer').data('inquiryid');
      let userId = $('#inquiry-modal-answer').data('userid');

      console.log(inquiryId);
      console.log(userId);

      if (!inquiryId || !userId) {
        console.log('뭔가 없어');
        return;
      }

      // 서버에 삭제 요청을 보냅니다.
      $.ajax({
        url: '/community/inquiry/deleteInquiry?inquiryId=' + inquiryId + '&userId=' + userId,
        method: 'POST',
        success: function() {
          alert('삭제 완료');
          location.reload(); // 페이지 새로 고침
        },
        error: function(error) {
          console.error("삭제 중 에러 발생:", error);
        }
      });
    }
  });
});



// $(document).ready(function() {
//   // "물어보세요" 버튼 클릭 시
//   $('.inquiry-button button').click(function(){
//     // inquiry-modal을 표시합니다.
//     $('.inquiry-modal').css('display', 'block');
//   });
//
//   // "닫기" 버튼 클릭 시
//   $('.inquiry-modal-btns button[type="button"]').click(function(){
//     // inquiry-modal을 숨깁니다.
//     $('.inquiry-modal').css('display', 'none');
//   });
//
//   // 문의 내용을 클릭했을 때
//   $('.inquiry-content-button').on('click', function() {
//     let inquiryId = $(this).data('inquiryid');
//     let userId = $(this).data('userid');
//     console.log('inquiryId:', inquiryId);
//     console.log('userid: ', userId);
//
//     if (!inquiryId) {
//       console.error('없어요');
//       return;
//     }
//
//     // 서버에서 해당 문의의 정보를 가져옵니다.
//     $.ajax({
//       url: '/community/inquiry/' + inquiryId,
//       method: 'GET',
//       success: function(data) {
//         console.log('받은 데이터:', data);
//         // 가져온 데이터를 모달에 표시합니다.
//         $('.inquiry-modal-answer-title').text(data.inquiryTitle);
//         $('.inquiry-modal-answer-content').text(data.inquiryContent);
//         $('.inquiry-modal-answer-realAnswer').text(data.inquiryResponse);
//         $('#inquiry-modal-answer').attr('data-inquiryid', inquiryId);
//         $('#inquiry-modal-answer').attr('data-userid', userId);
//         $('#inquiry-modal-answer').show();
//
//         // 가져온 사용자 정보를 비교하여 삭제 버튼을 표시하거나 숨깁니다.
//         $.ajax({
//           url: '/api/getUserInfo',
//           method: 'GET',
//           success: function(userInfo) {
//             console.log('사용자 정보:', userInfo);
//             console.log('작성자:', userId);
//             if (userInfo === userId) {
//               // 현재 사용자와 문의 작성자가 일치하면 삭제 버튼을 표시합니다.
//               $('.inquiry-modal-answer-delete').show();
//             } else {
//               // 다른 사용자가 작성한 문의에 대한 답변이므로 삭제 버튼을 숨깁니다.
//               $('.inquiry-modal-answer-delete').hide();
//             }
//           },
//           error: function(error) {
//             console.error("사용자 정보를 가져오는 중 에러 발생:", error);
//           }
//         });
//       },
//       error: function(error) {
//         console.error("문의 정보를 가져오는 중 에러 발생:", error);
//       }
//     });
//   });
//
//   // "답변 모달 닫기" 버튼 클릭 시
//   $('.inquiry-modal-answer-exit').on('click', function() {
//     // 답변 모달을 숨깁니다.
//     $('#inquiry-modal-answer').hide();
//   });
//
//   // "삭제" 버튼 클릭 시
//   $('.inquiry-modal-answer-delete').on('click', function() {
//     if (confirm('삭제할래요?')) {
//       let inquiryId = $('#inquiry-modal-answer').data('inquiryid');
//       let userId = $('#inquiry-modal-answer').data('userid');
//
//       console.log(inquiryId);
//       console.log(userId);
//
//       if (!inquiryId || !userId) {
//         console.log('뭔가 없어');
//         return;
//       }
//
//       // 서버에 삭제 요청을 보냅니다.
//       $.ajax({
//         url: '/community/inquiry/deleteInquiry?inquiryId=' + inquiryId + '&userId=' + userId,
//         method: 'POST',
//         success: function() {
//           alert('삭제 완료');
//           location.reload(); // 페이지 새로 고침
//         },
//         error: function(error) {
//           console.error("삭제 중 에러 발생:", error);
//         }
//       });
//     }
//   });
// });



// $(document).ready(function(){
//   // "물어보세요" 버튼 클릭 시
//   $('.inquiry-button button').click(function(){
//     // inquiry-modal을 표시합니다.
//     $('.inquiry-modal').css('display', 'block');
//   });
//
//   // "닫기" 버튼 클릭 시
//   $('.inquiry-modal-btns button[type="button"]').click(function(){
//     // inquiry-modal을 숨깁니다.
//     $('.inquiry-modal').css('display', 'none');
//   });
// });
//
// $(document).ready(function() {
//   $('.inquiry-content-button').on('click', function() {
//     let inquiryId = $(this).data('inquiryid');
//     let userId = $(this).data('userid');
//     console.log('inquiryId:', inquiryId);
//     console.log('userid: ', userId);
//
//     if (!inquiryId) {
//       console.error('없어요');
//       return;
//     }
//
//     $.ajax({
//       url: '/community/inquiry/' + inquiryId,
//       method: 'GET',
//       success: function(data) {
//         console.log('받은 데이터:', data);
//         $('.inquiry-modal-answer-title').text(data.inquiryTitle);
//         $('.inquiry-modal-answer-content').text(data.inquiryContent);
//         $('.inquiry-modal-answer-realAnswer').text(data.inquiryResponse);
//         $('#inquiry-modal-answer').attr('data-inquiryid', inquiryId);
//         $('#inquiry-modal-answer').attr('data-userid', userId);
//         $('#inquiry-modal-answer').show();
//       },
//       error: function(error) {
//         console.error("에러에러에러:", error);
//       }
//     });
//   });
//
//   $('.inquiry-modal-answer-exit').on('click', function() {
//     $('#inquiry-modal-answer').hide();
//   });
//
//   $('.inquiry-modal-answer-delete').on('click', function() {
//     if (confirm('삭제할래요?')) {
//
//       let inquiryId = $('#inquiry-modal-answer').data('inquiryid');
//       let userId = $('#inquiry-modal-answer').data('userid');
//
//       console.log(inquiryId);
//       console.log(userId);
//
//       if (!inquiryId || !userId) {
//         console.log('뭔가 없어');
//         return;
//       }
//
//       $.ajax({
//         url: '/community/inquiry/deleteInquiry?inquiryId=' + inquiryId + '&userId=' + userId,
//         method: 'POST',
//         success: function() {
//           alert('삭제 완료');
//           location.reload(); // 페이지 새로 고침
//         },
//         error: function(error) {
//           console.error("삭제 중 에러 발생:", error);
//         }
//       });
//     }
//   });
// });



const modalTitle = document.querySelector('.inquiry-modal-title input[type="text"]');
const modalContent = document.querySelector('.inquiry-modal-content textarea');
const modalSubmit = document.querySelector('.inquiry-modal-btns button[type="submit"]');

// console.log(modatContent);
// console.log(modalTitle);
// console.log(modalSubmit);



modalSubmit.addEventListener('click', () =>{
  if(modalContent.value === "" || modalTitle.value === ""){
    inquiryModal.style.display = 'flex';
    alert('제목 또는 내용 입력');
    if(modalContent.value === ""){
      modalContent.style.border = "none";
      modalContent.style.outline = "1px solid red";
      

      modalContent.addEventListener('keydown', () => {
        modalContent.style.outline = "1px solid skyblue"; 
      });
    }
    if(modalTitle.value === ""){
      modalTitle.style.border = "none";
      modalTitle.style.outline = "1px solid red";
      

      modalTitle.addEventListener('keydown', () => {
        modalTitle.style.outline = "1px solid skyblue";
      })
    }
  }else{
    let submit = confirm("등록하시겠습니까?");
    if(submit){
      alert("등록완료");
      inquiryModal.style.display = 'none';
    }else{
      inquiryModal.style.display = 'flex';
    }
  }
});

modalContent.addEventListener('focus', () =>{
  modalContent.style.outline = "none";
})

const inquiryPrev = document.querySelector('.inquiry-prev');
const inquiryNext = document.querySelector('.inquiry-next');
const bannerImg = document.querySelectorAll('.inquriy-banner-img');
let bannerWidth = 900;
let currentIdx = 0;
let imgLength = bannerImg.length;

// console.log(inquiryNext);
// console.log(inquiryPrev);
// console.log(bannerImg);

inquiryNext.addEventListener('click', () =>{
  currentIdx++;
  bannerImg.forEach((img) =>{
    img.style.left = -(currentIdx * bannerWidth) + "px";
    img.style.transition = "0.5s ease";
  });
  checkEnd();
});

inquiryPrev.addEventListener('click', () =>{
  currentIdx--;
  bannerImg.forEach((img) =>{
    img.style.left = -(currentIdx * bannerWidth) + "px";
    img.style.transition = "0.5s ease";
  });
  checkEnd();
});

function checkEnd(){
  if(currentIdx <= 0){
    inquiryPrev.style.display = 'none';
  }else{
    inquiryPrev.style.display = 'block';
  }

  if(currentIdx >= imgLength - 1){
    inquiryNext.style.display = 'none';
  }else{
    inquiryNext.style.display = 'block';
  }
}

