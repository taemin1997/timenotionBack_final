
//유아기, 유년기, 아동기, 청소년기, 성인, 중년, 노년 클릭 시 페이지 넘어가기//
$(document).ready(function() {

    // 버튼 클릭 이벤트 리스너
    // $('.everyLife-btn-span button').click(function() {
    //     let boardLifeCycle = $(this).val();
    //     fetchPostsByLifeStage(boardLifeCycle);
    //     console.log(boardLifeCycle);
    // });

    function fetchPostsByLifeStage(boardLifeCycle) {
        // lifeStage에 따라 게시글을 가져오는 AJAX 호출
        $.ajax({
            url: `/everyLife/${boardLifeCycle}`, // 실제 엔드포인트 URL로 변경
            type: 'GET',
            data: { boardLifeCycle: boardLifeCycle },
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
        let profileTags = '';
        posts.forEach(function(board) {
            let profileFileName = encodeURIComponent(board.userFileProfileSource + '/' + board.userFileProfileUuid + '_' + board.userFileProfileName); // ☆★☆★☆★ 파일 경로를 URL 인코딩
            console.log(profileFileName + "조합된 프로필 파일 이름 ");
            if (board.userFileProfileSource) {
                profileTags = `
                    <img src="/v1/user-files?fileName=${profileFileName}" alt="프로필사진" class="img-profile-img">
                `;
            } else {
                profileTags = `
                    <img src="/img/main/basic-profile.png" alt="기본 프로필 사진" class="img-profile-img">
                `;
            }
            var postHtml = `
                <div class="everyLife-content-box">
                    <a href="/myLife/detail-my?boardId=${board.boardId}">
                        <div class="everyLife-contents">
                            <div class="everyLife-content-title">${board.boardTitle}</div>
                            <div class="everyLife-content-date">작성일 : ${new Date(board.boardCreatedDate).toLocaleDateString('ko-KR')}</div>
                            <div class="everyLife-content-views">조회수 : ${board.boardViewCount}</div>
                            <div class="everyLife-content-writer">
                                <span class="everyLife-writer-profile">
                                    ${profileTags}
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

$(document).ready(function() {
    // 검색 버튼 이벤트 핸들러
    $("form").submit(function(event) {
        event.preventDefault(); // 기본 폼 제출 동작을 막음
        var keyword = $("input[name='searchKeyword']").val();
        searchContent(keyword);
    });

    // 검색어에 따라 필터링하는 함수
    function searchContent(keyword) {
        $.ajax({
            url: `/everyLife/search`,
            type: 'GET',
            data: { keyword: keyword },
            success: function(data) {
                renderContent(data);
            },
            error: function(error) {
                console.error('Error fetching search results:', error);
            }
        });
    }

    // 서버에서 받은 데이터를 화면에 렌더링하는 함수
    function renderContent(data) {
        var contentWrap = $(".everyLife-content-wrap");
        contentWrap.empty(); // 기존 컨텐츠를 지움

        if (data.length === 0) {
            contentWrap.append('<div class="no-results">검색 결과가 없습니다.</div>');
            return;
        }
        let profileTags = '';

        data.forEach(function(board) {
            let profileFileName = encodeURIComponent(board.userFileProfileSource + '/' + board.userFileProfileUuid + '_' + board.userFileProfileName); // ☆★☆★☆★ 파일 경로를 URL 인코딩
            if (board.userFileProfileSource) {
                profileTags = `
                    <img src="/v1/user-files?fileName=${profileFileName}" alt="프로필사진" class="img-profile-img">
                `;
            } else {
                profileTags = `
                    <img src="/img/main/basic-profile.png" alt="기본 프로필 사진" class="img-profile-img">
                `;
            }
            var contentHtml = `
                <div class="everyLife-content-box">
                    <a href="/myLife/detail-my?boardId=${board.boardId}">
                        <div class="everyLife-contents">
                            <div class="everyLife-content-title">${board.boardTitle}</div>
                            <div class="everyLife-content-date">작성일: ${formatDate(board.boardCreatedDate)}</div>
                            <div class="everyLife-content-views">조회수: ${board.boardViewCount}</div>
                            <div class="everyLife-content-writer">
                                <span class="everyLife-writer-profile">
                                    ${profileTags}
                                </span>
                                <span class="everyLife-writer-nickname">${board.nickname}</span>
                            </div>
                            <div class="everyLife-content-detail">${board.boardContent}</div>
                        </div>
                    </a>
                </div>
            `;
            contentWrap.append(contentHtml);
        });
    }

    // 날짜 포맷팅 함수 =====> 이 함수가 있어야 날짜가 똑바로 뜸 ===> js91번쨰줄
    function formatDate(dateString) {
        var date = new Date(dateString);
        var options = { year: 'numeric', month: '2-digit', day: '2-digit' };
        return date.toLocaleDateString('ko-KR', options);
    }
});

// -------------------------------------------------
function getQueryParam(param) {
    let urlParams = new URLSearchParams(window.location.search);
    return urlParams.get(param);
}

document.addEventListener('DOMContentLoaded', (event) => {
    let keyword = getQueryParam('keyword');
    searchContent(keyword);

    function searchContent(keyword) {
        $.ajax({
            url: `/everyLife/search`,
            type: 'GET',
            data: { keyword: keyword },
            success: function(data) {
                renderContent(data);
            },
            error: function(error) {
                console.error('Error fetching search results:', error);
            }
        });

        function renderContent(data) {
            var contentWrap = $(".everyLife-content-wrap");
            contentWrap.empty(); // 기존 컨텐츠를 지움

            if (data.length === 0) {
                contentWrap.append('<div class="no-results">검색 결과가 없습니다.</div>');
                return;
            }

            data.forEach(function(board) {
                var contentHtml = `
                <div class="everyLife-content-box">
                    <a href="/myLife/detail-my?boardId=${board.boardId}">
                        <div class="everyLife-contents">
                            <div class="everyLife-content-title">${board.boardTitle}</div>
                            <div class="everyLife-content-date">작성일: ${formatDate(board.boardCreatedDate)}</div>
                            <div class="everyLife-content-views">조회수: ${board.boardViewCount}</div>
                            <div class="everyLife-content-writer">
                                <span class="everyLife-writer-profile">
                                    <img src="./../../img/everyLife/everyLife_profile.png" alt="">
                                </span>
                                <span class="everyLife-writer-nickname">${board.nickname}</span>
                            </div>
                            <div class="everyLife-content-detail">${board.boardContent}</div>
                        </div>
                    </a>
                </div>
            `;
                contentWrap.append(contentHtml);
            });
        }

        // 날짜 포맷팅 함수 =====> 이 함수가 있어야 날짜가 똑바로 뜸 ===> js91번쨰줄
        function formatDate(dateString) {
            var date = new Date(dateString);
            var options = { year: 'numeric', month: '2-digit', day: '2-digit' };
            return date.toLocaleDateString('ko-KR', options);
        }
    }
});

//----------------------------------------------------
function filterByLifeCycle(boardLifeCycle) {
    // 서버로 요청 보내기
    window.location.href = `/everyLife/${boardLifeCycle}`;
}


document.getElementById("keyword").addEventListener("keyup", function(event) {
    if (event.key === "Enter") {
        document.getElementById("searchButton").click();
    }
});


function searchEveryLife(){

    let keyword = document.querySelector('#keyword').value;

    window.location.href = `/everyLife/search/${keyword}`;
}





/* ---------- 프로필사진 파일 처리 ---------------------------------------------------- */
/*
        1. 파일 경로 조합
        2. 조합한 경로 이미지태그에 넣고
        3. innerHTML로 안에 넣어주기
*/

/*
        1. 유저 아이디 가져오기
        2. 이미지 태그 넣을 부모태그 가져오기
*/

document.querySelectorAll('.everyLife-content-box').forEach(box => {
    let uniId = box.querySelector('#uniId').value; // ★ 각 박스의 숨겨진 입력 필드에서 uniId 값을 가져옵니다
    console.log(uniId);
    fetchFiles(uniId, box.querySelector('.everyLife-writer-profile'));
});

function fetchFiles(uniId, profileBox) {
    console.log("2222222" + uniId);
    fetch(`/v1/everyLife/${uniId}/files`, { method: 'GET' })
        .then(res => res.json())
        .then(data => {
            let profileTags = '';

            data.forEach(item => {
                let profileFileName = encodeURIComponent(item.userFileProfileSource + '/' + item.userFileProfileUuid + '_' + item.userFileProfileName);
                console.log("파일 이름 : " + profileFileName)
                console.log("소스: "+ item.userFileProfileSource);
                console.log("name: "+ item.userFileProfileName);
                console.log("uuid: "+ item.userFileProfileUuid);
                if (item.userFileProfileSource) {
                    profileTags = `
                        <img src="/v1/user-files?fileName=${profileFileName}" alt="프로필사진">
                    `;
                } else {
                    profileTags = `
                        <img src="/img/main/basic-profile.png" alt="기본 이미지">
                    `;
                }
            });

            profileBox.innerHTML = profileTags;
        })
        .catch(error => console.error('Error:', error));
}