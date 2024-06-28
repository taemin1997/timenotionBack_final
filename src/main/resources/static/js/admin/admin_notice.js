// 삭제 버튼 확인시 삭제 / 취소시 삭제 취소 되게 구현
document.addEventListener("DOMContentLoaded", function() {
    document.querySelectorAll("#admin-notice-delete").forEach(function(button) {
        button.addEventListener("click", function(event) {
            var confirmDelete = confirm("정말로 삭제하시겠습니까?");
            if (confirmDelete) {
                // 부모 form을 찾아서 submit
                button.closest("form").submit();
            } else {
                // 삭제 취소
                event.preventDefault();
            }
        });
    });
});
