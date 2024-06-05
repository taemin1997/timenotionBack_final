
//검색창 기능 구현 //
function filterContent() {
    const keyword = document.querySelector('input[name="searchKeyword"]').value.toLowerCase();
    const contents = document.querySelectorAll('.everyLife-content-box');

    contents.forEach(content => {
        const title = content.querySelector('.everyLife-content-title').innerText.toLowerCase();
        const detail = content.querySelector('.everyLife-content-detail').innerText.toLowerCase();
        const nickname = content.querySelector('.everyLife-writer-nickname').innerText.toLowerCase();

        if (title.includes(keyword) || detail.includes(keyword) || nickname.includes(keyword)) {
            content.style.display = "";
        } else {
            content.style.display = "none";
        }
    });
}

//유아기, 유년기, 아동기, 청소년기, 성인, 중년, 노년 클릭 시 페이지 넘어가기//







