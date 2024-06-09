$(document).ready(function() {
    // 버튼 클릭 이벤트 리스너
    $('.everyLife-btn-span button').click(function() {
        let boardLifeCycle = $(this).attr('id'); // 버튼의 id를 boardLifeCycle로 사용
        fetchPostsByLifeStage(boardLifeCycle);
        console.log("Clicked button ID:", boardLifeCycle);
    });

    function fetchPostsByLifeStage(boardLifeCycle) {
        // lifeStage에 따라 게시글을 가져오는 AJAX 호출
        $.ajax({
            url: `/myLife/${boardLifeCycle}`, // 실제 엔드포인트 URL로 변경
            type: 'GET',
            success: function(response) {
                console.log("Response data:", response); // 응답 데이터 확인
                updatePosts(response);
            },
            error: function(error) {
                console.error("Error fetching posts:", error);
            }
        });
    }

    function updatePosts(posts) {
        var contentWrap = $('.list'); // .list 클래스를 선택하여 내용 업데이트
        contentWrap.empty(); // 현재 내용을 비움

        posts.forEach(function(board) {
            var postHtml = `
                <div class="list-one">
                    <a href="/myLife/detail-my?boardId=${board.boardId}">
                        <div class="list-one-detail">
                            <div class="title">
                                <h3>${board.boardTitle}</h3>
                                <p>조회수 : ${board.boardViewCount}</p>
                            </div>
                            <div class="list-date">
                                <p>작성일 : ${new Date(board.boardCreatedDate).toLocaleDateString('ko-KR')}</p>
                            </div>
                            <div class="list-text">
                                <p>${board.boardContent}</p>
                            </div>
                        </div>
                    </a>
                </div>`;
            contentWrap.append(postHtml);
        });
    }
});


/* --------------------------------------- 프사 / 배사 */

// let boardId = document.querySelector('#boardId').value;

function displayImgAjax() {
fetch(`/v1/mylife/${uniId}/files`, {method: 'GET'})
    .then(res => res.json())//응답을 JSON으로 변환
    .then(list => { //변환된 데이터를 list 변수에 저장
        let tags = ''; //HTML 태그를 저장할 변수 초기화

        for (let i = 0; i < list.length; i++) {
            let backFileName = list[i].uploadPath + '/' + list[i].uuid + '_' + list[i].name;
            //파일 경로 조합

            tags += `<a href="/download?fileName=${fileName}">
                         <img src="/v1/files?fileName=${fileName}" data-id="${list[i].fileId}" data-name="${fileName}"/>
                        </a>`;
        }

        let $postImgs = document.querySelector('.post-images'); //이미지가 삽입될 요소

        $postImgs.innerHTML = tags; //생성된 html 태그를 삽입
    });
}