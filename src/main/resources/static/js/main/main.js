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