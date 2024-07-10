$(document).ready(function() {
    // 버튼 클릭 이벤트 리스너
    $('.everyLife-btn-span button').click(function() {
        let boardLifeCycle = $(this).val(); // 버튼의 value를 boardLifeCycle로 사용
        fetchPostsByLifeStage(boardLifeCycle);
        console.log("Clicked button Value:", boardLifeCycle);
    });

    function fetchPostsByLifeStage(boardLifeCycle) {
        // lifeStage에 따라 게시글을 가져오는 AJAX 호출
        $.ajax({
            url: `/myLife/${boardLifeCycle}`, // 실제 엔드포인트 URL로 변경
            type: 'GET',
            success: function(response) {
                updatePosts(response);
            },
            error: function(error) {
                console.error("Error fetching posts:", error);
            }
        });
    }

    function updatePosts(posts) {
        var contentWrap = $('.fourth-container .list'); // .list 클래스를 선택하여 내용 업데이트
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
let uniId = document.querySelector('#uniId').value; // 유저아이디 가져옴
AjaxOfUserFile();

function AjaxOfUserFile() {
    fetch(`/v1/mylife/${uniId}/files`, { method: 'GET' })
        .then(res => {
            if (!res.ok) {
                throw new Error('Network response was not ok');
            }
            return res.text(); // 먼저 응답을 텍스트로 변환
        })
        .then(text => {
            if (!text) {
                // 응답이 비어 있는 경우 기본 프로필 사진을 표시
                console.log("응답이 비어서 기본 프로필 들어갔습니다.")
                let $profileBox = document.querySelector('.profile-img-box');
                $profileBox.innerHTML = `
            <img src="/img/main/basic-profile.png" alt="기본 프로필 사진" class="img-profile-img">
          `;
                let $backBox = document.querySelector('.profile-bg-img-box');
                $backBox.innerHTML = `
                <img src="/img/main/basic-background3.png" alt="기본 배경사진" class="img-back-img">
                `;
                return;
            }
            return JSON.parse(text); // 텍스트가 비어있지 않으면 JSON으로 파싱
        }) // ------------------------------------------------ 여기까지 복붙 0710
        .then(data => { // 변환된 데이터를 data 변수에 저장
            let profileTags = '';
            let backTags = '';

            /* 파일 경로 조합 */
            let profileFileName = encodeURIComponent(data.userFileProfileSource + '/' + data.userFileProfileUuid + '_' + data.userFileProfileName); // ☆★☆★☆★ 파일 경로를 URL 인코딩
            let backFileName = encodeURIComponent(data.userFileBackSource + '/' + data.userFileBackUuid + '_' + data.userFileBackName); // ☆★☆★☆★ 파일 경로를 URL 인코딩
            /* 프로필 사진 태그에 넣기 */
            if (data.userFileProfileSource) {
                console.log("여기까지 온것? 1");
                profileTags = `
                    <img src="/v1/user-files?fileName=${profileFileName}" alt="프로필사진" class="img-profile-img">
                `;
            } else {
                console.log("여기까지 온것? 2");

                profileTags = `
                    <img src="/img/main/basic-profile.png" alt="기본 프로필 사진" class="img-profile-img">
                `;
            }

            /* 배경 사진 태그에 넣기 */
            if (data.userFileBackSource) {
                backTags = `
                    <img src="/v1/user-files?fileName=${backFileName}" alt="배경사진" class="img-back-img">
                `;
            } else {
                backTags = `
                    <img src="/img/main/basic-background3.png" alt="기본 배경사진" class="img-back-img">
                `;
            }

            let $profileBox = document.querySelector('.profile-img-box');
            let $backBox = document.querySelector('.profile-bg-img-box');

            /* html에 만든 태그 넣기 */
            $profileBox.innerHTML = profileTags;
            $backBox.innerHTML = backTags;
        });
}

function filterByLifeCycle(boardLifeCycle) {
    let userId = document.getElementById('uniId').value;
    // 서버로 요청 보내기
    window.location.href = `/myLife/${boardLifeCycle}/${userId}`;
}