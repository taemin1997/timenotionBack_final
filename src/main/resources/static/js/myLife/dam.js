import * as reply from "./module.js";

let page = 1;
let hasNext = true;
let uniId = document.querySelector('#uniId').value;
console.log("uniId:", uniId);


/* boardId
 <input type="hidden" id="boardId" th:value="${boards.boardId}"> 이런식으로 아무데나 갖다놔야함 */
let boardId = document.querySelector('#boardId').value;
let $replyListWrap = document.querySelector('.wrapper-reply');



$replyListWrap.addEventListener('click', function (e) {
    let $target = e.target;
    if ($target.classList.contains('real-delete-btn')) {
        /* 삭제 버튼이 클릭되었는지 확인하고, 해당 요소를 처리 */
        $target.closest('.delete-btn').classList.add('none');
        let commentId = $target.closest('.comment-id-tag').dataset.id; // 댓글 ID 가져오기

        reply.remove(commentId, () => {
            // 댓글 삭제 함수 호출
            page = 1; // 페이지를 초기화
            reply.getList2(boardId, page, function (data) {
                // 댓글 목록을 다시 가져옴
                hasNext = data.hasNext;
                // 다음 페이지 여부를 갱신
                displayComment(data.contentList); // displayComment 함수를 사용하여 댓글 목록을 화면에 표시
            });
        });
    }
});





/* 2. 댓글 등록 ----------------------------------------*/
{
    //  댓글 작성 완료 버튼 //
    let $btnWriteReply = document.querySelector('.box-btn-reply-btn');
    /* 2-1. */
    $btnWriteReply?.addEventListener('click', function () {
        /* 1 ) 입력할 댓글 내용 가져옴 */
        // 입력한 댓글 내용(컨텐츠) //
        let content = document.querySelector('#comment-content').value;
        if (!content) {
            alert("댓글 입력");
            return;
        }
        // ♡♡  댓글 아이디, 컨텐츠 정보 담는 변수 선언
        /* 여기 이름이 내 DTO의 필드명이랑 일치해야함 */
        let replyInfo = {boardId: boardId, commentContent: content}; // content 변수를 사용하여 수정

        /* 2 ) 댓글 등록 함수 호출
            댓 입력창 초기화 / 페이지 초기화 / 댓 리스트 뿌려줌
            function getList2(boardId, page, callback)호출 -> boardId, page 넣어줌
            - 특정 게시물의 댓글목록을 page 단위로 가져옴
            - 서버에 Get 요청 -> JSON형식으로 파싱
            - 파싱된 데이터를 콜백함수에 전달  */
        reply.register(replyInfo, () => {
            document.querySelector('#comment-content').value = '';
            page = 1;
            reply.getList2(boardId, page, function (data) {
                hasNext = data.hasNext;
                displayComment(data.contentList);
            });
        });
    });

    /*2-2. 댓글 목록을 페이지 단위로 가져와서 화면에 출력
            서버에 get 요청을 보내고, 응답 페이지를 콜백 함수로 처리하여 댓글 표시 */
    reply.getList2(boardId, page, function (data) {
        hasNext = data.hasNext;
        console.log(data.contentList);
        displayComment(data.contentList);
    });

    /*2-3. 스크롤 이벤트를 감지하여 페이지 끝에 도달하면 다음 페이지 댓글 가져옴
    *       새로운 댓글 목록을 기존 목록에 추가 */
    window.addEventListener('scroll', function () {
        if (!hasNext) return;
        // ♡♡  documentElement 객체에서 3개의 프로퍼티를 동시에 가져온다.
        let {scrollTop, scrollHeight, clientHeight} = document.documentElement;/*
        console.log("scrollTop(스크롤 상단의 현재 위치) : ", scrollTop);
        console.log("scrollHeight(전체 문서의 높이) : ", scrollHeight);
        console.log("clientHeight(클라이언트[웹브라우저]의 화면 높이) : ", clientHeight);*/
        if (clientHeight + scrollTop >= scrollHeight - 5) {
            console.log("바닥~~!!");
            page++;
            /* 여기 찾아봐야함 ☆☆☆☆☆☆ */
            reply.getList2(boardId, page, function (data) {
                hasNext = data.hasNext;
                appendReply(data.contentList);
            });
        }
    });

} // 2.close

/* 3. 기존 댓글 지우고 새로운 댓글 목록 씌우는 함수
   innserHTML : 기존 내용 유지 x, 새롭게 덮어 씌임
    onclick="del();" <=- 삭제버튼에 잇던거 빼둠 */
function displayComment(commentList) {
    let $commentWrap = document.querySelector('.wrapper-reply');
    let tags = '';
    commentList.forEach(r => {
        tags += `
<div class="wrapper-main-reply comment-id-tag" data-id="${r.commentId}">
    <div class="box-main-reply-top">
        <a href="#" class="reply-top-left">
            <div class="box-profile"><img src="./../../img/main/봉준호 (8).jpg" alt=""/></div>
            <div><span class="nickname">${r.nickname}</span></div>
            <div class="tag">일기주인</div>
            <div ${r.uniId}>나오냐</div>
        </a>
        <div class="reply-top-right">
            <div class="delete-btn">
                <button id="delete" class="real-delete-btn">삭제</button>
            </div>
            <div class="date">${reply.timeForToday(r.commentCreatedDate)}</div>
            <div class="dotdotdot">...</div>
            <div class="box-mini-report">
                <button class="mini-button">신고하기</button>
            </div>
        </div>
    </div>
    <div class="box-main-reply-bottom">
        <div class="reply-content">
            <p>${r.commentContent}</p>
        </div>
    </div>
    <div class="wrapper-re-comment">
        <div class="box-re-comment">
            <button class="reply-btn" onClick="toggleReplyInput(this)">답글쓰기</button>
            <div class="box-re-comment-btn" style="display: none;">
                <textarea class="re-textarea" placeholder="댓글을 남겨보세요"></textarea>
                <button class="re-submit-btn" onClick="submitReply(this)">완료</button>
            </div>
        </div>
    </div>
</div>
<hr/>
        `;
    }); // 댓글목록 순회
    $commentWrap.innerHTML = tags;
} // 3.close

/* 4. 기존 댓글목록 유지하고 새로운 댓글 추가하는 함수
   insertAdjacentHTML : 새로운 html 내용을 기존 내용 뒤에 삽입 */
function appendReply(commentList) {
    let $commentWrap = document.querySelector('.wrapper-reply');
    let tags = '';
    console.log("댓글 추가중?");
    commentList.forEach(r => {
        tags += `
<div class="wrapper-main-reply comment-id-tag" data-id="${r.commentId}">
    <div class="box-main-reply-top">
        <a href="#" class="reply-top-left">
            <div class="box-profile"><img src="./../../img/main/봉준호 (8).jpg" alt=""/></div>
            <div><span class="nickname">${r.nickname}</span></div>
            <div class="tag">일기주인</div>
            <div ${r.uniId}>나오냐</div>
        </a>
        <div class="reply-top-right">
            <div class="delete-btn">
                <button id="delete" class="real-delete-btn">삭제</button>
            </div>
            <div class="date">${reply.timeForToday(r.commentCreatedDate)}</div>
            <div class="dotdotdot">...</div>
            <div class="box-mini-report">
                <button class="mini-button">신고하기</button>
            </div>
        </div>
    </div>
    <div class="box-main-reply-bottom">
        <div class="reply-content">
            <p>${r.commentContent}</p>
        </div>
    </div>
    <div class="wrapper-re-comment">
        <div class="box-re-comment">
            <button class="reply-btn" onClick="toggleReplyInput(this)">답글쓰기</button>
            <div class="box-re-comment-btn" style="display: none;">
                <textarea class="re-textarea" placeholder="댓글을 남겨보세요"></textarea>
                <button class="re-submit-btn" onClick="submitReply(this)">완료</button>
            </div>
        </div>
    </div>
</div>
<hr/>
        `;
    }); // 댓글 목록 순회
    $commentWrap.insertAdjacentHTML("beforeend", tags);
} // 4.close

/*

<div className="wrapper-main-reply comment-id-tag" data-id="${r.commentId}">
    <div className="box-main-reply-top">
        <a href="#" className="reply-top-left">
            <div className="box-profile"><img src="./../../img/main/봉준호 (8).jpg" alt=""/></div>
            <div><span className="nickname">${r.nickname}</span></div>
            <div className="tag">일기주인</div>
            <div ${r.commentId}>나오냐</div>
        </a>
        <div className="reply-top-right">
            <div className="delete-btn">
                <button id="delete" className="real-delete-btn">삭제</button>
            </div>
            <div className="date">${reply.timeForToday(r.commentCreatedDate)}</div>
            <div className="dotdotdot">...</div>
            <div className="box-mini-report">
                <button className="mini-button">신고하기</button>
            </div>
        </div>
    </div>
    <div className="box-main-reply-bottom">
        <div className="reply-content">
            <p>${r.commentContent}</p>
        </div>
    </div>
    <div className="wrapper-re-comment">
        <div className="box-re-comment">
            <button className="reply-btn" onClick="toggleReplyInput(this)">답글쓰기</button>
            <div className="box-re-comment-btn" style="display: none;">
                <textarea className="re-textarea" placeholder="댓글을 남겨보세요"></textarea>
                <button className="re-submit-btn" onClick="submitReply(this)">완료</button>
            </div>
        </div>
    </div>
</div>
<hr/>
*/








