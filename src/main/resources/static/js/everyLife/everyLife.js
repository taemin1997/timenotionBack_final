
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
$(document).ready(function() {
    // 버튼 클릭 이벤트 리스너
    $('.everyLife-btn-span button').click(function() {
        let boardLifeCycle = $(this).val();
        fetchPostsByLifeStage(boardLifeCycle);
        console.log(boardLifeCycle);
    });

    function fetchPostsByLifeStage(boardLifeCycle) {
        // lifeStage에 따라 게시글을 가져오는 AJAX 호출
        $.ajax({
            url: `/everyLife/${boardLifeCycle}`, // 실제 엔드포인트 URL로 변경
            type: 'GET',
            data: { stage: boardLifeCycle },
            success: function(response) {
                updatePosts(response);
            },
            error: function(error) {
                console.error("게시글을 가져오는 중 오류 발생:", error);
            }
        });
    }

    function updatePosts(posts) {
        var contentWrap = $('.everyLife-content-wrap');
        contentWrap.empty(); // 현재 내용을 비움

        posts.forEach(function(board) {
            var postHtml = `
                <div class="everyLife-content-box">
                    <a href="/myLife/detail-my?boardId=${board.boardId}">
                        <div class="everyLife-contents">
                            <div class="everyLife-content-title">${board.boardTitle}</div>
                            <div class="everyLife-content-date">작성일 : ${new Date(board.boardCreatedDate).toLocaleDateString('ko-KR')}</div>
                            <div class="everyLife-content-views">조회수 : ${board.boardViewCount}</div>
                            <div class="everyLife-content-writer">
                                <span class="everyLife-writer-profile">
                                    <img src="./../../img/everyLife/everyLife_profile.png" alt="">
                                </span>
                                <span class="everyLife-writer-nickname">${board.nickname}</span>
                            </div>
                            <div class="everyLife-content-detail">${board.boardContent}</div>
                        </div>
                    </a>
                </div>`;
            contentWrap.append(postHtml);
        });
    }
});







