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
