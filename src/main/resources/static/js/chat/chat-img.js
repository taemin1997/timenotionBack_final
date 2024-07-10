
/* 1. 단일  */

let uniId = document.querySelector('#receiverId2').value; // 유저아이디 가져옴
console.log("senderId :  " + uniId )
AjaxOfUserFile();

function AjaxOfUserFile() {
    fetch(`/v1/mylife/${uniId}/files`, { method: 'GET' })
        .then(res => {
            if (!res.ok) {
                throw new Error('Network response was not ok');
            }
            return res.text(); // 먼저 응답을 텍스트로 변환
        })
        .then(text => {
            if (!text) {
                // 응답이 비어 있는 경우 기본 프로필 사진을 표시
                console.log("응답이 비어서 기본 프로필 들어갔습니다.")
                let $profileBox = document.querySelector('.box-profile-img-a');
                $profileBox.innerHTML = `
            <img src="/img/main/basic-profile.png" alt="기본 프로필 사진" class="img-profile-img">
          `;
                return;
            }
            return JSON.parse(text); // 텍스트가 비어있지 않으면 JSON으로 파싱
        }) // ------------------------------------------------ 여기까지 복붙 0710
        .then(data => { // 변환된 데이터를 data 변수에 저장
            let profileTags = '';
            let backTags = '';

            /* 파일 경로 조합 */
            let profileFileName = encodeURIComponent(data.userFileProfileSource + '/' + data.userFileProfileUuid + '_' + data.userFileProfileName); // ☆★☆★☆★ 파일 경로를 URL 인코딩
            let backFileName = encodeURIComponent(data.userFileBackSource + '/' + data.userFileBackUuid + '_' + data.userFileBackName); // ☆★☆★☆★ 파일 경로를 URL 인코딩
            /* 프로필 사진 태그에 넣기 */
            if (data.userFileProfileSource) {
                profileTags = `
                    <img src="/v1/user-files?fileName=${profileFileName}" alt="프로필사진" class="img-profile-img">
                `;
            } else {
                profileTags = `
                    <img src="/img/main/basic-profile.png" alt="기본 프로필 사진" class="img-profile-img">
                `;
            }

            /* 배경 사진 태그에 넣기 */ /* 여기선 이거 안 씀 ! 프사만 씀. */
            if (data.userFileBackSource) {
                backTags = `
                    <img src="/v1/user-files?fileName=${backFileName}" alt="배경사진" class="img-back-img">
                `;
            } else {
                backTags = `
                    <img src="/img/main/basic-background3.png" alt="기본 배경사진" class="img-back-img">
                `;
            }

            let $profileBox = document.querySelector('.profile-img-box');
            let $backBox = document.querySelector('.profile-bg-img-box');

            /* html에 만든 태그 넣기 */
            $profileBox.innerHTML = profileTags;
            $backBox.innerHTML = backTags;
        });
}



/* 2. 리스트  */

document.querySelectorAll('.chat-wrapper').forEach(box => {
    let uniId = box.querySelector('#receiverId2').value; // 프사 유저 정보
    fetchFiles(uniId, box.querySelector('.profile-list-img-box'));
});

function fetchFiles(uniId, profileBox) {
    fetch(`/v1/everyLife/${uniId}/files`, { method: 'GET' })
        .then(res => {
            if (!res.ok) {
                throw new Error('Network response was not ok');
            }
            return res.text(); // 먼저 응답을 텍스트로 변환
        })
        .then(text => {
            if (!text) {
                // 응답이 비어 있는 경우 기본 프로필 사진을 표시
                console.log("응답이 비어서 기본 프로필 들어갔습니다.")
                let $profileBox = document.querySelector('.box-profile-img-a');
                $profileBox.innerHTML = `
            <img src="/img/main/basic-profile.png" alt="기본 프로필 사진" class="img-profile-img">
          `;
                return;
            }
            return JSON.parse(text); // 텍스트가 비어있지 않으면 JSON으로 파싱
        }) // ------------------------------------------------ 여기까지 복붙 0710
        .then(data => {
            let profileTags = '';
            let number = 1;
            data.forEach(item => {
                let profileFileName = encodeURIComponent(item.userFileProfileSource + '/' + item.userFileProfileUuid + '_' + item.userFileProfileName);

                console.log(number++ + "번 회원의 파일");
                console.log("파일 이름 : " + profileFileName)
                if (item.userFileProfileSource) {
                    profileTags = `
                        <img src="/v1/user-files?fileName=${profileFileName}" alt="프로필사진">
                    `;
                } else {
                    profileTags = `
                        <img src="/img/main/basic-profile.png" alt="기본 이미지">
                    `;
                }
            });

            profileBox.innerHTML = profileTags;
        })
        .catch(error => console.error('Error:', error));
}
