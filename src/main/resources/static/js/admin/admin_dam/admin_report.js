console.log("신고 js 들어왔니?");

// let deleteBtn = document.querySelector('#deleteBtn'); // 삭제 버튼
let reportList = document.querySelector('.box-admin-list'); // 리스트 li 감싸는애

reportList.addEventListener('click', function (e){
    let $target = e.target;

    if($target.classList.contains('deleteBtn')){ // 삭제버튼 있냐?

        let list = $target.closest('li');
        let commentId = list.querySelector('#commentId').value;

        // 리스트에서 누른 값 찾기 : target.closest('li').queryselector(아이디).value
        console.log("commentId :: " + commentId);

        // 컨펌창
        if(confirm("해당 댓글을 삭제하시겠습니까? ")){
            /* ------------------fetch ---------------------------*/
            fetch( `/reportdelete/${commentId}`, {
                method:'POST'
            })
                .then(response => {
                    if (response.ok){
                        alert("해당 댓글이 삭제되었습니다.");
                    }else {
                        console.log("댓글 삭제에 실패했어요 ~ ")}
                })
                .catch(error => {
                    console.log("댓글(신고) 삭제 중 에러 발생~ ");
                })
            /* ------------------fetch ---------------------------*/

        }else{ // 컨펌창 else

        }

    }

})
/*

deleteBtn.addEventListener('click', function (e){
    let commentId = document.querySelector('#commentId').value; // 댓글 아이디
    console.log("commentId :: "+ commentId);

    // 컨펌창
    if(confirm("해당 댓글을 삭제하시겠습니까? ")){
        /!* ------------------fetch ---------------------------*!/
        fetch( `/report/delete/${commentId}`, {method:'POST'})
            .then(response => {
                if (response.ok){
                    alert("해당 댓글이 삭제되었습니다.");
                }
            })
            .catch(error => {
                console.log("댓글(신고) 삭제 중 에러 발생~ ");
            })
        /!* ------------------fetch ---------------------------*!/

    }else{ // 컨펌창 else

    }



});*/
