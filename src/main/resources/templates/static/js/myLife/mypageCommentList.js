const contents = document.querySelector(".comment-contents");
const buttons = document.querySelector(".comment-pagination-buttons");


// 전체 글의 개수 임의로 100개로 설정 
const numOfContent = 100;
//한페이지에 보여줄 글의 개수 
const maxContent = 10;
//한 회며에 보여줄 버튼의 개수
const maxButton = 5;
//글을 모두 보여주기 위해 필요한 페이지 개수
const maxPage = Math.ceil(numOfContent/ maxContent);
//현재 페이지 (시작페이지 =1)
let page = 1;







//글 목록 & 버튼 생성 함수 구현 
const makeContent = (id) =>{
  const content = document.createElement("li");
  content.classList.add("content");
  content.innerHTML = 
    <><span class="content-img">이미지</span>
      <span class="content-comment">댓글 내용</span>
      <span class="content-title">게시글 제목</span>
      <span class="content-date">2022.01.01</span>
    </>
  ;
  return content;
};

const makeButton = (id)=>{
  const button = document.createElement("button");
  button.classList.add("button");
  button.dataset.num = id;
  button.innerText =id;
  button.addEventListener("click",(e)=>{
    Array.prototype.forEach.call(button.children,(button)=>{
      if(button.dataset.num) button.classList.remove("active");
    });
    e.target.classList.add("active");
    renderContent(parseInt(e.target.dataset.num));
  });
  return button;
}

//랜더링 함수 구현
const renderContent = (page) =>{
  //목록 리스트 초기화 
  while (contents.hasChildNodes()){
    contents.removeChild(contents.lastChild);
  }
  //글의 최대 개수를 넘지 않는 선에서 , 화면에 최대 10개의 글 생성
  for(let id = (page -1)*maxContent +1 ; id <= page*maxContent && id <= numOfContent; id++){
    contents.appendChild(makeContent(id));
  }
};

const renderButton = (page)=>{
//버튼 리스트 초기화 
  while(buttons.hasChildNodes()){
    buttons.removeChild(buttons.lastChild);
  }
  //화면에 최대 5개의 페이지 버튼 생성
  for(let id = page ; id < page + makeButton && id <= maxPage ; id++){
    buttons.appendChild(makeButton(id));
  }
  //첫 버튼 활성화 (class = "active ")
  buttons.children[0].classList.add("active");

  buttons.prepend(prev);
  buttons.append(next);

  //이전 , 다음 페이지 버튼이 필요한지 체크 
  if(page -maxButton <1) buttons.removeChild(prev);
  if(page +maxButton >maxPage) buttons.removeChild(next);


  const render = (page)=>{
    renderContent(page);
    renderButton(page);
  };
  render(page);
}





//페이지 이동 함수 구현
const goPrevPage = ()=>{
  page -= maxButton;
  render(page);
};

const goNextPage = () => {
  page += maxButton;
  render(page);
};

const prev = document.createElement("button");
prev.classList.add("button", "prev");
prev.innerHTML = '<ion-icon name="chevron-back-outline"></ion-icon>';
prev.addEventListener("click", goPrevPage);

const next = document.createElement("button");
next.classList.add("button", "next");
next.innerHTML = '<ion-icon name="chevron-forward-outline"></ion-icon>';
next.addEventListener("click", goNextPage);

