console.log("윤담씨 프사불러오기위해 만든 너의일대기 js");



/* ---------- 프로필사진 파일 처리 ---------------------------------------------------- */
/*
        1. 파일 경로 조합
        2. 조합한 경로 이미지태그에 넣고
        3. innerHTML로 안에 넣어주기
*/

/*
        1. 유저 아이디 가져오기
        2. 이미지 태그 넣을 부모태그 가져오기
*/
// 팔로워 목록 프로필 처리
document.querySelectorAll('.flwers-box').forEach(box => {
    let followerId = box.querySelector('#followerId').value; // ★ 각 박스의 숨겨진 입력 필드에서 uniId 값을 가져옵니다
    console.log("팔로워 아이디 : " + followerId);
    fetchFiles(followerId, box.querySelector('.flwers-img-box'));
});

function fetchFiles(followerId, profileBox) {
    console.log("넘어온 팔로워 아이디 : " + followerId);
    fetch(`/v1/followerImg/${followerId}/files`, { method: 'GET' })
        .then(res => res.json())
        .then(data => {
            let profileTags = '';
            console.log(" 데이터 로그 :" + data);
            data.forEach(item => {
                console.log("여긴 왔냐?? ");
                let profileFileName = encodeURIComponent(item.userFileProfileSource + '/' + item.userFileProfileUuid + '_' + item.userFileProfileName);
                console.log("파일 이름 : " + profileFileName)
                if (item.userFileProfileSource) {
                    profileTags = `
                        <img src="/v1/user-files?fileName=${profileFileName}" alt="프로필사진"/>
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


// 팔로잉 목록 프로필 처리
document.querySelectorAll('.flwing-box').forEach(box => {
    let followingId = box.querySelector('#followingId').value; // ★ 각 박스의 숨겨진 입력 필드에서 uniId 값을 가져옵니다
    console.log("팔로잉 아이디 : " + followingId);
    fetchFollowing(followingId, box.querySelector('.flwing-img-box'));
});

function fetchFollowing(followingId, profileBox) {
    console.log("넘어온 팔로잉 아이디 : " + followingId);
    fetch(`/v1/followingImg/${followingId}/files`, { method: 'GET' })
        .then(res => res.json())
        .then(data => {
            let profileTags = '';
            console.log(" 데이터 로그 :" + data);
            data.forEach(item => {
                console.log("여긴 왔냐?? 222 ");
                let profileFileName = encodeURIComponent(item.userFileProfileSource + '/' + item.userFileProfileUuid + '_' + item.userFileProfileName);
                console.log("파일 이름 : " + profileFileName)
                if (item.userFileProfileSource) {
                    profileTags = `
                        <img src="/v1/user-files?fileName=${profileFileName}" alt="프로필사진"/>
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
