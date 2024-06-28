let $adminRemove = document.querySelector('.admin-remove');

//삭제버튼 처림
$adminRemove?.addEventListener("click", function () {
    let boardId = this.dataset.id; //클릭된 요소의 data-id 속성값을 가져와 boardId 변수에 저장
    //this : 이벤트 핸들러 안에서 이벤트가 발생한 요소(클릭한 요소)
    //dataset : dataset 객체는 요소의 모든 data-* 속성을 포함
    //  ex) dataset.id ="123"
    //id : data-id 속성의 값을 가져온다
    location.href = `/admin/remove?boardId=${boardId}`;
});