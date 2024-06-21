// const paging = document.querySelector('.inquiry-paging');
// let page = 1;
// const showContent = 7;
// let contentCount = document.querySelectorAll('.inquiry-contents').length;
// let endPage = Math.ceil((contentCount / showContent));

// const inquiryModal = document.querySelector('.inquiry-modal');
const modalBtn = document.querySelector('.inquiry-button button[type="button"]');
const modalExitBtn = document.querySelector('.inquiry-modal-btns button[type="button"]');
// const inquiryModalTitle = document.querySelector('.inquiry-modal-title input[type="text"]');
// const inquiryAnswerModalmodify = document.querySelector('.inquiry-modal-answer-modify');
const inquiryAnswerModalexit = document.querySelector('.inquiry-modal-answer-exit');
const inquiryAnswerModal = document.querySelector('#inquiry-modal-answer');
const answerModalBtn = document.querySelectorAll('.inquiry-content-button');
const inquiryModify = document.querySelector('.inquiry-modal-modify');
const inquiryModifyText = document.querySelector('.inquiry-modal-modify > textarea');
const inquiryModifyBefore = document.querySelector('.inquiry-modal-answer-realAnswer');
const inquiryModifyComment = document.querySelector('.inquiry-modal-answer-comment');



console.log(inquiryModifyText);


// 등록완료 버튼이 default로 나오게 하려고 만든 함수
// 값이 들어갔으면, 수정 버튼이 나오게끔
function btnDisplay() {
    if (inquiryModifyBefore.value !== "답변 전") {
        inquiryAnswerModalmodify.style.display = 'flex';
        inquiryModifyComment.style.display = 'none';
    }
}



answerModalBtn.forEach((btn) => {
    btn.addEventListener('click', () => {
        inquiryAnswerModal.style.display = 'block';
        inquiryModifyBefore.style.display = 'none';
        // inquiryModifyText.style.display = 'block';
        inquiryModify.style.display = 'block';
        btnDisplay();
    })
});


inquiryAnswerModalexit.addEventListener('click', () => {
    inquiryAnswerModal.style.display = 'none';
})


inquiryModifyComment.addEventListener('click', () => {
    if (inquiryModifyText.value === "") {
        alert('답변 달아줘');
    } else {
        let submit = confirm('등록할까요?');
        if (submit) {
            inquiryAnswerModal.style.display = 'none';
        }
    }
})



// inquiryAnswerModalmodify.addEventListener('click', () => {
//     inquiryModify.style.display = 'block';
//     inquiryModifyBefore.style.display = 'none';

//     if (inquiryModifyText.value !== "") {
//         let check = confirm("수정하시겠습니까?")
//         if (check) {
//             inquiryAnswerModal.style.display = 'none';
//             inquiryModify.style.display = 'none';
//             inquiryModifyText.value = "";
//             inquiryModifyBefore.style.display = 'block';
//         }
//     }
// });

// inquiryAnswerModalmodify.addEventListener('click', () => {
//     inquiryModify.style.display = 'block';
//     inquiryModifyBefore.style.display = 'none';
//     btnDisplay();
// })


// inquiryAnswerModalexit.addEventListener('click', () => {
//     inquiryAnswerModal.style.display = 'none';
//     inquiryModifyText.value = "";
//     inquiryModify.style.display = 'none';
// });



// const modalTitle = document.querySelector('.inquiry-modal-title input[type="text"]');
// const modalContent = document.querySelector('.inquiry-modal-content textarea');
// const modalSubmit = document.querySelector('.inquiry-modal-btns button[type="submit"]');

// // console.log(modatContent);
// // console.log(modalTitle);
// // console.log(modalSubmit);



// modalSubmit.addEventListener('click', () => {


//     if (modalContent.value === "" || modalTitle.value === "") {
//         inquiryModal.style.display = 'flex';
//         alert('제목 또는 내용 입력');
//         if (modalContent.value === "") {
//             modalContent.style.border = "none";
//             modalContent.style.outline = "1px solid red";


//             modalContent.addEventListener('keydown', () => {
//                 modalContent.style.outline = "1px solid skyblue";
//             });
//         }
//         if (modalTitle.value === "") {
//             modalTitle.style.border = "none";
//             modalTitle.style.outline = "1px solid red";


//             modalTitle.addEventListener('keydown', () => {
//                 modalTitle.style.outline = "1px solid skyblue";
//             })
//         }
//     } else {
//         let submit = confirm("등록하시겠습니까?");
//         if (submit) {
//             alert("등록완료");
//             inquiryModal.style.display = 'none';
//         } else {
//             inquiryModal.style.display = 'flex';
//         }
//     }
// });

// modalContent.addEventListener('focus', () => {
//     modalContent.style.outline = "none";
// })


// footer 위 배너 함수 //
const inquiryPrev = document.querySelector('.inquiry-prev');
const inquiryNext = document.querySelector('.inquiry-next');
const bannerImg = document.querySelectorAll('.inquriy-banner-img');
let bannerWidth = 900;
let currentIdx = 0;
let imgLength = bannerImg.length;

// console.log(inquiryNext);
// console.log(inquiryPrev);
// console.log(bannerImg);

inquiryNext.addEventListener('click', () => {
    currentIdx++;
    bannerImg.forEach((img) => {
        img.style.left = -(currentIdx * bannerWidth) + "px";
        img.style.transition = "0.5s ease";
    });
    checkEnd();
});

inquiryPrev.addEventListener('click', () => {
    currentIdx--;
    bannerImg.forEach((img) => {
        img.style.left = -(currentIdx * bannerWidth) + "px";
        img.style.transition = "0.5s ease";
    });
    checkEnd();
});

function checkEnd() {
    if (currentIdx <= 0) {
        inquiryPrev.style.display = 'none';
    } else {
        inquiryPrev.style.display = 'block';
    }

    if (currentIdx >= imgLength - 1) {
        inquiryNext.style.display = 'none';
    } else {
        inquiryNext.style.display = 'block';
    }
}