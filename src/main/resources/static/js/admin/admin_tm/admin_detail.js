const modifyBtn = document.querySelector('.ad-detail-modify-btns button[type="button"]');
const modifyTexts = document.querySelectorAll('.ad-detail-content textarea');


// console.log(modifyTexts);
modifyBtn.addEventListener('click', () => {
  let modify = confirm('수정할까요?');
  if(modify){
    for(let i = 0; i < modifyTexts.length; i++){
      modifyTexts[i].readOnly= false; 
    }
  }
});

const modifySubmit = document.querySelector('.ad-detail-btns button[type="submit"]');

modifySubmit.addEventListener('click', ()=>{
  let modify = confirm('수정할까요?');
  if(modify){
    // form action = "modify.html" method = "post"
  }
})

const $commentRemove = $('.ad-detail-comment-userinfo button[type="button"]');
const $replyRemove = $('.ad-detail-reply-userinfo button[type="button"]');

// console.log($commentRemove.parents().eq(3));
// console.log(replyRemove);
// console.log($commentRemove);
// $commentRemove.on('click', () => {
//   $commentRemove.parents().eq(3).remove();
// })

$commentRemove.each(function(index, element) {
  $(element).on('click', function() {
    let remove = confirm('삭제할까요?')
    if(remove){
      $(element).parents().eq(3).remove();
    }
  });
});

$replyRemove.each(function(index, element) {
  $(element).on('click', function() {
    let remove = confirm('삭제할까요?')
    if(remove){
      $(element).parents().eq(3).remove();
    }
  });
});
