const generalButton = document.getElementById("general");
const suspensionButton = document.getElementById("suspension");
const withdrawalButton = document.getElementById("withdrawal");
let uniId = 1; //초기값 주기
let statusStep = 1;

// generalButton 클릭 시
generalButton.addEventListener("click", async function() {
    if (confirm("변경하시겠습니까?")) {
        statusStep = 1; // 상태 변경 값

        try {
            await sendStatusStep(statusStep, uniId);
            location.reload(); // 페이지 새로고침
        } catch (error) {
            console.error("상태 변경 요청 실패:", error);
        }
    } else {
        console.log("취소");
    }
});

// suspensionButton 클릭 시
suspensionButton.addEventListener("click", async function() {
    if (confirm("변경하시겠습니까?")) {
             statusStep = 2; // 상태 변경 값
        try {
            await sendStatusStep(statusStep, uniId);
            location.reload(); // 페이지 새로고침
        } catch (error) {
            console.error("상태 변경 요청 실패:", error);
        }
    } else {
        console.log("취소");
    }
});

// withdrawalButton 클릭 시
withdrawalButton.addEventListener("click", async function() {
    if (confirm("변경하시겠습니까?")) {
         statusStep = 3; // 상태 변경 값

        try {
            await sendStatusStep(statusStep, uniId);
            location.reload(); // 페이지 새로고침
        } catch (error) {
            console.error("상태 변경 요청 실패:", error);
        }
    } else {
        console.log("취소");
    }
});

// 변경 버튼 클릭 시 이벤트 처리
let changeButtons = document.querySelectorAll('.admin-six button#change-status');
changeButtons.forEach(function(button) {
    button.addEventListener('click', function() {
        let modal = document.getElementById('myModal');
        modal.style.display = "block";

        // 클릭된 버튼이 속한 리스트 아이템에서 uniId 가져오기
        let listItem = button.closest('li');
         uniId = parseInt(listItem.querySelector('.admin-one').textContent.trim());
        // let statusStep = listItem.querySelector('.admin-five').textContent.trim();

        console.log("uniId:", uniId);
        // console.log("statusStep:", statusStep);

        // sendStatusStep(statusStep, uniId); // 상태 변경 요청 보내기
    });
});

// 상태 변경 요청 보내기
async function sendStatusStep(statusStep, uniId) {
    console.log("Sending statusStep:", statusStep, "for uniId:", uniId);

    try {
        const response = await fetch(`/admin/memberList?statusStep=${statusStep}&uniId=${uniId}`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                statusStep: statusStep,
                uniId: uniId
            })
        });

        if (!response.ok) {
            throw new Error("상태 변경 요청 실패");
        }

    } catch (error) {
        console.error("상태 변경 요청 오류:", error.message);
    }
}

// 취소 버튼 클릭 시 모달 닫기
let statusCancelButton = document.getElementById("status-cancel");
statusCancelButton.addEventListener("click", function() {
    closeModal();
});

// 모달 닫기 함수
function closeModal() {
    let modal = document.getElementById('myModal');
    modal.style.display = "none";
}

// 상태 변경 함수
function changeStatus(newStatus) {
    console.log("새로운 상태:", newStatus);
    closeModal(); // 상태 변경 후 모달 닫기
}
