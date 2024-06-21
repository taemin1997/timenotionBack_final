// ---- 삭제 문구 ---- //
function del() {
    if (confirm("정말 삭제하시겠습니까?"))
        list_ok.submit();
}

// ---- 좋아요 하트 구현 ---- //

const heartImage = document.getElementById('heartImage');

heartImage.addEventListener('click', changeHeartColor);

function changeHeartColor() {
    if (heartImage.classList.contains('red')) {

        heartImage.classList.remove('red');
    } else {
        heartImage.classList.add('red');
    }
}


// ---- 댓글 구현 ---- //

function toggleReplyInput(comment) {

    const replyInput = comment.parentElement.querySelector('.box-re-comment-btn');

    replyInput.style.display = (replyInput.style.display === 'none') ? 'flex' : 'none';
}