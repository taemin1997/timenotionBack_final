// ---- 삭제 문구 ---- //
function del() {
    if (confirm("정말 삭제하시겠습니까?"))
        list_ok.submit();
}

// ---- 좋아요 하트 구현 ---- //

const heartImage = document.getElementById('heartImage');

heartImage.addEventListener('click', changeHeartColor);

function changeHeartColor() {
    if (heartImage.classList.contains('red')) {

        heartImage.classList.remove('red');
    } else {
        heartImage.classList.add('red');
    }
}

// ---- 댓글 구현 ---- //

function toggleReplyInput(btn) {

    var replyInput = btn.parentElement.querySelector('.reply-input');

    replyInput.style.display = (replyInput.style.display === 'none') ? 'flex' : 'none';

}

/* === 신고하기 ====================================================== */

    /* 1. 신고 모달  택스트 비활성화--------------------------------------------*/

    $(document).ready(function () {
        // 텍스트 입력창을 기본적으로 비활성화
        $('.report-input').prop('disabled', true);
  
        $('input[name="report-reason"]').change(function () {
          if ($('#g').is(':checked')) {
            $('.report-input').prop('disabled', false); // 활성화
          } else {
            $('.report-input').prop('disabled', true); // 비활성화
          }
        });
      });
  
  
    /* 2. '점점점' 누르면 버튼 나오게 */
    $('.detail_dot').on('click', function(e){
      console.log($(this).next);
      // console.log(e.currentTarget.next);
      $('.box-mini-report').css('display', 'none');
      $(e.target).next().css('display', 'flex'); /* 누른거만 나오게  */
    }) 
  
    /* 3. '신고하기' 누르면 '신고모달' 뜸 */
    $('.box-mini-report').on('click', function(){
        $('.box-mini-report').css('display', 'none');
      $('.report').css('display', 'flex');
      
      $('.detail_dot').on('click', function(e){
        $('.report').css('display', 'none');
      })
    })


  /* 4. '닫기' 누르면 닫히게 */
    $('.report-btn-close, .report-btn-report').on('click', function(){
      $('.report').css('display', 'none');
    })

  
    /* 5. 바깥 클릭 -> 모달 숨기기 */
    $(document).on('click', function(e){
    if(!$(e.target).closest('.detail_dot, .box-mini-report, .report').length)  {
      $('.box-mini-report').css('display', 'none');
      $('.report').css('display', 'none');
    }
  }); // 클릭한 html 요소가 . 얘네랑 일치하지 . length(객체에 포함된 요소 수를 반환함, 하나라도 일치하면 length가 적어도 1이 되는 것)
  
  
  