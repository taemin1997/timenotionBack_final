let $bannerBox = $(".sub-banner-box");
console.log($bannerBox)
let $bannerImgs = $(".sub-banner-img")
let currentIdx = 0;
let slideCnt = $bannerImgs.length;

/* 슬라이드배너 */

function moveBanner(){
  currentIdx = 0;
  $bannerBox.css("transition", "1s ease");
  $bannerBox.css("left", "0px");

}

setInterval(function() {
  if (currentIdx === slideCnt - 1) {
    moveFirst();
  } else {
    moveNext();
  }
}, 3000);

function moveNext(){
  currentIdx++;
  $bannerBox.css("left", -(currentIdx * 920) + "px");
  $bannerBox.css("transition", "1s ease");
}
function moveFirst(){
  $bannerBox.css("left", 0);
  $bannerBox.css("transition", "0.000001s ease");
  currentIdx = 0;
}


// //키워드 클릭시 구현중입니다 alert창
// document.addEventListener("DOMContentLoaded", function() {
//   // keyword 클래스를 가진 모든 요소 선택
//   const keywords = document.getElementsByClassName("keyword");
//   const keywords2 = document.getElementsByClassName("keyword2");
//
//   // 모든 요소에 대해 클릭 이벤트 리스너 추가
//   for (let i = 0; i < keywords.length; i++) {
//     keywords[i].addEventListener('click', () => {
//       alert("서비스 구현중입니다.");
//     });
//   }
//   for (let i = 0; i < keywords2.length; i++) {
//     keywords2[i].addEventListener('click', () => {
//       alert("서비스 구현중입니다.");
//     });
//   }
// });

  const keywords = document.getElementsByClassName("keyword");
  for (let i = 0; i < keywords.length; i++) {
    keywords[i].addEventListener('click', () => {
      let keyword = keywords[i].innerText;
      location.href = '/everyLife?keyword=' + encodeURIComponent(keyword);
    });
  }


  const keywords2 = document.getElementsByClassName("keyword2");

  for (let i = 0; i < keywords2.length; i++) {
    keywords2[i].addEventListener('click', () => {
      let keyword = keywords2[i].innerText;
      location.href = '/everyLife?keyword=' + encodeURIComponent(keyword);
    });
  }



  /* 메인배너 사진 불러오기  --------------------------------------------------------------*/
/* - 왼쪽 메인배너 불러오기 (단일) ------------  */
let leftBanner = document.querySelector('#leftBanner').value;
let leftUserId = document.querySelector('#leftUserId').value;



AjaxOfUserFile(leftBanner, leftUserId);

function AjaxOfUserFile(boardId, userId) {
    // 1. 메인배너 패치
  fetch(`/v1/leftBanner/${boardId}/files`, { method: 'GET' })
      .then(res => res.json()) // 응답을 JSON으로 변환
      .then(data => { // 변환된 데이터를 data 변수에 저장
        /* 파일 경로 조합 */
          let bannerFileName = encodeURIComponent(data.boardFileSourceName + '/' + data.boardFileUuid + '_' + data.boardFileName); // ☆★☆★☆★ 파일 경로를 URL 인코딩
          let bannerTag = '';

        if (data.boardFileSourceName) {
            bannerTag = `
                    <img src="/v1/user-files?fileName=${bannerFileName}" alt="왼쪽 배너사진" class="img-profile-img">
                `;
        } else {
            bannerTag = `
                    <img src="/img/main/basic-profile.png" alt="기본 프로필 사진" class="img-profile-img">
                `;
        }

        let $bannerBox = document.querySelector('.leftBanner-box');
        $bannerBox.innerHTML = bannerTag;
      });


    // 2. 프로필사진 패치
    fetch(`/v1/leftBanner/profile/${userId}/files`, { method: 'GET' })
        .then(res => res.json()) // 응답을 JSON으로 변환
        .then(data => { // 변환된 데이터를 data 변수에 저장
            let profileFileName = encodeURIComponent(data.userFileProfileSource + '/' + data.userFileProfileUuid + '_' + data.userFileProfileName); // ☆★☆★☆★ 파일 경로를 URL 인코딩
            let profileTag = '';
            if (data.userFileProfileSource) {
                profileTag = `
                    <img src="/v1/user-files?fileName=${profileFileName}" alt="왼쪽 배너사진" class="img-profile-img">
                `;
            } else {
                profileTag = `
                    <img src="/img/main/basic-profile.png" alt="기본 프로필 사진" class="img-profile-img">
                `;
            }

            $profileBox = document.querySelector('.banner-profile-img');
            $profileBox.innerHTML = profileTag;

        });

}




/* - 오른쪽 메인배너 불러오기 (리스트) ------------  ----------------------   */
/* - 오른쪽 메인배너 불러오기 (리스트) ------------  ----------------------   */
/* - 오른쪽 메인배너 불러오기 (리스트) ------------  ----------------------   */

document.querySelectorAll('.main-top-box').forEach(box => {
    let rightBanner = box.querySelector('#rightBanner').value;
    let rightUserId = box.querySelector('#rightUserId').value;
    let rightBannerBox = box.querySelector('.rightBanner-box');
    let profileBox = box.querySelector('.right-banner-profile-img');

    AjaxOfRightBanner(rightBanner, rightUserId, rightBannerBox, profileBox);
});

function AjaxOfRightBanner(boardId, userId, bannerBox, profileBox) {

    // 1. 메인배너 패치 (오른쪽)
    fetch(`/v1/rightBanner/${boardId}/files`, { method: 'GET' })
        .then(res => res.json())
        .then(data => {
            let bannerTag = '';
            data.forEach(item => {
                let bannerFileName = encodeURIComponent(item.boardFileSourceName + '/' + item.boardFileUuid + '_' + item.boardFileName);
                if (item.boardFileSourceName) {
                    bannerTag = `
                        <img src="/v1/user-files?fileName=${bannerFileName}" alt="오른쪽 배너 사진"/>
                    `;
                } else {
                    bannerTag = `
                        <img src="/img/main/basic-profile.png" alt="기본 이미지">
                    `;
                }
            });
            bannerBox.innerHTML = bannerTag;
        })
        .catch(error => console.error('Error:', error));

    // 프로필사진 패치
    fetch(`/v1/rightBanner/profile/${userId}/files`, { method: 'GET' })
        .then(res => res.json())
        .then(data => {
            let profileTags = '';
            if (data.length > 0) { // 데이터가 있는지 확인
                data.forEach(item => {
                    let profileFileName = encodeURIComponent(item.userFileProfileSource + '/' + item.userFileProfileUuid + '_' + item.userFileProfileName);
                    if (item.userFileProfileSource) {
                        profileTags = `
                        <img src="/v1/user-files?fileName=${profileFileName}" alt="프로필사진"/>
                    `;
                    } else{
                        profileTags = `
                                <img src="/img/main/basic-profile.png" alt="기본 이미지">
                                        `;
                    }
                });
            } else { // 데이터가 없으면 기본 이미지 사용
                profileTags = `
                <img src="/img/main/basic-profile.png" alt="기본 이미지">
            `;
            }
            profileBox.innerHTML = profileTags; // 기존 내용을 덮어씁니다.
        })
        .catch(error => console.error('Error:', error));
}


/* 인기 컨텐츠 프로필사진 ------------------------------------------------------------------------------------  */
/* 인기 컨텐츠 프로필사진 ------------------------------------------------------------------------------------  */
/* 인기 컨텐츠 프로필사진 ------------------------------------------------------------------------------------  */



document.querySelectorAll('.wrap-pop-main').forEach(box => {
    let popUserId = box.querySelector('#popUserId').value;
    let profileBox = box.querySelector('.box-profile-img');
    console.log("인기컨텐츠 유저 아이디 : " + popUserId );

    AjaxOfPopProfile(popUserId, profileBox);
});

function AjaxOfPopProfile(userId, profileBox) {

    // 프로필사진 패치
    fetch(`/v1/rightBanner/profile/${userId}/files`, { method: 'GET' })
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
                <img src="/img/main/basic-profile.png" alt="기본 프로필 사진" >
              `;

                return;
            }
            return JSON.parse(text); // 텍스트가 비어있지 않으면 JSON으로 파싱
        }) // ------------------------------------------------ 여기까지 복붙 0710
        .then(data => {
            let profileTags = '';
            if (data.length > 0) { // 데이터가 있는지 확인
                data.forEach(item => {
                        let profileFileName = encodeURIComponent(item.userFileProfileSource + '/' + item.userFileProfileUuid + '_' + item.userFileProfileName);
                        console.log(userId + "번 유저의 -- 파일 이름 : " + profileFileName);
                            if (item.userFileProfileSource) {
                                profileTags = `
                                <img src="/v1/user-files?fileName=${profileFileName}" alt="프로필사진"/>
                            `;
                            } else{
                                profileTags = `
                                <img src="/img/main/basic-profile.png" alt="기본 이미지">
                                        `;
                            }
                });
            } else { // 데이터가 없으면 기본 이미지 사용
                console.log("데이터가 없어서 기본이미지 사용");
                profileTags = `
                <img src="/img/main/basic-profile.png" alt="기본 이미지">
            `;
            }
            profileBox.innerHTML = profileTags; // 기존 내용을 덮어씁니다.
        })
        .catch(error => console.error('Error:', error));
}











