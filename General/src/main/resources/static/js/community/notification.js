const notificationPrev = document.querySelector('.notification-prev');
const notificationNext = document.querySelector('.notification-next');
const bannerImg = document.querySelectorAll('.notification-banner-img');
let bannerWidth = 900;
let currentIdx = 0;
let imgLength = bannerImg.length;

// console.log(notificationNext);
// console.log(notificationPrev);
// console.log(bannerImg);

notificationNext.addEventListener('click', () =>{
  currentIdx++;
  bannerImg.forEach((img) =>{
    img.style.left = -(currentIdx * bannerWidth) + "px";
    img.style.transition = "0.5s ease";
    checkEnd();
  })
});
notificationPrev.addEventListener('click', () =>{
  currentIdx--;
  bannerImg.forEach((img) =>{
    img.style.left = -(currentIdx * bannerWidth) + "px";
    img.style.transition = "0.5s ease";
    checkEnd();
  })
});

function checkEnd(){
  if(currentIdx <= 0){
    notificationPrev.style.display = 'none';
  }else{
    notificationPrev.style.display = 'block';
  }

  if(currentIdx >= imgLength - 1){
    notificationNext.style.display = 'none';
  }else{
    notificationNext.style.display = 'block';
  }
}


