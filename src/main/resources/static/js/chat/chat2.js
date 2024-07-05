document.addEventListener('DOMContentLoaded', function () {
    const chatBtn = document.querySelector('.chat-btn');
    const receiverIdElement = document.getElementById('get-user-id');

    if (receiverIdElement) {
        const receiverId = parseInt(receiverIdElement.innerText.trim());
        console.log('Receiver ID:', receiverId); // 확인용 console.log

        chatBtn.addEventListener('click', function (event) {
            event.preventDefault();

            fetch('/chat/check-or-create-room', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ receiverId: receiverId })
            })
                .then(response => response.json())
                .then(data => {
                    console.log('Response from server:', data); // 확인용 console.log

                    if (data.success) {
                        // 채팅방으로 이동
                        window.location.href = `/chat/room/${data.roomId}`;
                    } else {
                        alert('채팅방을 생성하는 중에 오류가 발생했습니다.');
                    }
                })
                .catch(error => console.error('Error:', error));
        });
    } else {
        console.error('Receiver ID element not found.');
    }
});