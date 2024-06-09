const infancy = document.querySelector('#infancy');
const babyhood = document.querySelector('#babyhood');
const childhood = document.querySelector('#childhood');
const adolescence = document.querySelector('#adolescence');
const adult = document.querySelector('#adult');
const middleAge = document.querySelector('#middle-age');
const oldAge = document.querySelector('#old-age');
const boardListContainer = document.querySelector('#board-list-container');

async function fetchFilteredBoards(cycle) {
    console.log("사이클:", cycle);
    try {
        const response = await fetch(`/myLife/filter?cycle=${encodeURIComponent(cycle)}`);
        if (!response.ok) {
            throw new Error("생애 주기별 게시글 필터링 실패");
        }
        const boards = await response.json();
        console.log("Filtered boards:", boards);
        displayBoards(boards);
    } catch (error) {
        console.error(error.message);
    }
}

function displayBoards(boards) {
    boardListContainer.innerHTML = ''; // 기존 게시글 리스트 초기화
    boards.forEach(board => {
        const boardElement = document.createElement('div');
        boardElement.textContent = board.boardTitle; // 예시로 제목만 추가
        boardListContainer.appendChild(boardElement);
    });
}

infancy.addEventListener('click', () => {
    fetchFilteredBoards("유아기");
});

babyhood.addEventListener('click', () => {
    fetchFilteredBoards("유년기");
});

childhood.addEventListener('click', () => {
    fetchFilteredBoards("아동기");
});

adolescence.addEventListener('click', () => {
    fetchFilteredBoards("청소년기");
});

adult.addEventListener('click', () => {
    fetchFilteredBoards("성인기");
});

middleAge.addEventListener('click', () => {
    fetchFilteredBoards("중년기");
});

oldAge.addEventListener('click', () => {
    fetchFilteredBoards("노년기");
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