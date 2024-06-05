// document.addEventListener('DOMContentLoaded',function () {
//     //변수
//     const form = document.getElementById('noticeForm');
//     const title = document.getElementsByClassName("notification-title");
//     const content = document.getElementById('textarea');
//     const titleError = document.getElementById('titleError');
//     const contentError = document.getElementById('contentError');
//
//     form.addEventListener('submit', function (event) {
//         let valid = true;
//
//         // 제목 유효성 검사
//         if (title.value.trim() === '') {
//             titleError.textContent = '제목을 입력해주세요.';
//             valid = false;
//         } else if (title.value.length < 1 || title.value.length > 40) {
//             titleError.textContent = '입력값을 1~40자 이내로 입력해주세요.';
//             valid = false;
//         } else {
//             titleError.textContent = '';
//         }
//
//         // Content validation
//         if (content.value.trim() === '') {
//             contentError.textContent = '공지 내용을 입력해주세요';
//             valid = false;
//         } else if (content.value.length < 1 || content.value.length > 600) {
//             contentError.textContent = '입력값을 1~600자 이내로 입력해주세요.';
//             valid = false;
//         } else {
//             contentError.textContent = '';
//         }
//
//         if (!valid) {
//             event.preventDefault(); // Prevent form submission
//             alert("글을 입력하세요");
//
//         }
//
//     });
// });
document.addEventListener('DOMContentLoaded', function () {
    const form = document.getElementById('noticeForm');
    const title = document.querySelector('.notification-title');
    const content = document.getElementById('textarea');
    const titleError = document.getElementById('titleError');
    const contentError = document.getElementById('contentError');

    form.addEventListener('submit', function (event) {
        let valid = true;

        // Title validation
        if (title.value.trim() === '') {
            valid = false;
        } else if (title.value.length < 1 || title.value.length > 40) {
            alert("입력값을 1~40자 이내로 입력해주세요.");
            valid = false;
        } else {
            titleError.textContent = '';
        }

        // Content validation
        if (content.value.trim() === '') {
            valid = false;
        } else if (content.value.length < 1 || content.value.length > 600) {
            alert("입력값을 1~600자 이내로 입력해주세요.");
            valid = false;
        } else {
            contentError.textContent = '';
        }

        if (!valid) {
            event.preventDefault(); // Prevent form submission
            alert("제목과 공지내용을 입력하세요.");
        }
    });
});
