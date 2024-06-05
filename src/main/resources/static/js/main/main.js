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
