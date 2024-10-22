# 근근한잔 (타임노션)
<img width="500" src=https://github.com/jang1234567/timenotionBack_final/assets/120088675/d9c6e0d6-f1af-403a-83a6-8c26445c0c51>


## 📁 프로젝트 소개
<Strong>**근근한잔💪 (타임노션)** </Strong>은 개인의 생애주기별 경험과 추억을 기록하고, 이를 다른 사람들과 공유함으로써 공감을 형성하고 팔로잉/팔로우를 통한 채팅도 할 수 있는 플랫폼입니다. 


## ⏱ 개발 기간
24.05.03 - 24.05.31 **"1차개발"** <br>
24.06.03 - 24.06.28 **"채팅+관리자 페이지"**



## 주요 기능

1. **시기별 일대기 공유**
   - 사용자는 자신의 일생을 기록할 수 있습니다.<br>
   - 특정 연도를 선택하여 자신의 일대기를 작성하고 게시글을 올리면, 리스트에서 시기별로 볼 수 있습니다.<br>
     이를 통해 자신의 유년기,유아기,청소년기,청년기,중년기, 노년기 등을 모아볼 수 있습니다.

2. **채팅/커뮤니티 형성**
   - 공통 키워드를 통해 경험을 공유하며 사용자 간의 친밀함을 생성하고 새로운 만남을 도모할 수 있습니다.
   - 게시글을 공유하고 서로의 생각을 이야기하며 마음이 가는 사람에게 채팅을 할 수 있습니다.

3. **팔로잉/팔로우,게시물 좋아요**
   - 내가 계속 보고싶은 게시물에 좋아요를 누를 수 있다.
   - 자주 보고 싶은 사람을 팔로우해서 해당 인원의 게시물을 볼 수 있다.

4. **그룹화**
   - 여러 사용자의 일대기를 모아 특정 시기나 집단을 중심으로 묶어냄으로써,<br>  그 시기나 집단의 역사적 기록을 체계적으로 보존하고 다양한 관점에서 재조명할 수 있습니다.<br>  이를 통해 한 개인이 자기계발의 계기를 마련할 수 있습니다.

5. **키워드를 통한 공통사**
   - 사이트의 키워드 기능을 통해 내 관심사를 검색하고 자신과 직종, 학교, 지역 등이 같은 다양한 사람들과 만날 수 있도록 합니다.<br>  댓글,채팅을 통해 다양한 경험을 공유하며 소통할 수 있습니다.

---

## 📖목차
- [팀 구성](#팀-구성)
- [ERD 구성](#erd-구성)
- [Stacks](#-stacks)

## 🧑‍💻팀 구성
**Producer Git-hub Page 장윤근**

| 팀장  | [장윤근](https://github.com/jang1234567) |
|:----:|:-----:|
| 부팀장 |  [윤담](https://github.com/dev-yoondam)   |
| 팀원  |  [고태민](https://github.com/taemin1997) |
| 팀원  |  [문동주](https://github.com/mdongjoo) |
| 팀원  |  [김주선](https://github.com/joosun0823) |
| 팀원  |  [양효준](https://github.com/HyoJun00) |

---

## 🔗서비스 흐름도

<img width="800" src='https://github.com/user-attachments/assets/a4c56a5e-6be3-4959-8de8-c01ecfb6956c'>
<br>
<Strong><관리자></Strong><br>
<img height="400" width="400" src='https://github.com/user-attachments/assets/178fccdf-a974-447c-a9de-1ca083921c87'>



## 💡ERD 구성

<details open>
<summary>ERD</summary>
  
<img width="800" src='https://github.com/user-attachments/assets/3cf36b83-0b8a-42d7-8d9a-e1e39a04ba79'>

</details>


## 💻 기능 및 화면 소개

**<메인화면>**<br>
<table>
  <tr>
    <td align="center">
      <strong><메인화면></strong><br>
      <img width="400" src="https://github.com/jang1234567/timenotionBack_final/assets/120088675/73ea0508-944f-436e-b7e4-62b4e3eda60c">
    </td>
    <td align="center">
      <strong><키워드/배너></strong><br>
      <img width="400" src="https://github.com/jang1234567/timenotionBack_final/assets/120088675/1efd923a-b6f3-43be-9338-538940175b6f">
    </td>
  </tr>
</table>

- 게시글 좋아요,조회순으로 메인화면의 메인 게시글을 띄워줍니다.
- 사용자들이 많이 검색하는 키워드를 보여줍니다.

---

**<about페이지>**<br>
<table>
  <tr>
    <td align="center">
      <strong><about페이지></strong><br>
      <img width="400" src="https://github.com/user-attachments/assets/fb0aca13-b469-4257-9b44-6814c8cc20ae">
    </td>
  </tr>
  <tr>
    <td align="center">
      <img width="400" src="https://github.com/user-attachments/assets/582a8700-f682-4316-bf1f-bfa54261dc39">
    </td>
    <td align="center">
      <img width="400" src="https://github.com/user-attachments/assets/892c2650-0cec-4085-bcea-6d8dba0b6713">
    </td>
  </tr>
</table>

- 타임노션 웹페이지에 대한 설명

---

**<로그인, 회원가입>**<br>
<table>
  <tr>
    <td align="center">
      <strong><로그인></strong><br>
      <img width="400" src="https://github.com/jang1234567/timenotionBack_final/assets/120088675/a28d2e60-f0f5-4918-a3b0-4192572259c0">
    </td>
    <td style="width: 50px;"></td> <!-- 빈 셀을 추가하여 간격 확보 -->
    <td align="center">
      <strong><회원가입></strong><br>
      <img height="400" width="200px" src="https://github.com/jang1234567/timenotionBack_final/assets/120088675/4b02463d-ed48-4fc5-bf9c-e2d84ba683e3">
    </td>
  </tr>
</table>

- 일반적인 로그인, 회원가입이 가능하고 카카오를 이용하여 로그인, 회원가입이 가능합니다.

---




**<비밀번호 찾기>**<br>
<table>
  <tr>
    <td align="center">
      <strong><비밀번호 찾기></strong><br>
      <img width="400" src="https://github.com/user-attachments/assets/60b6520b-8099-48e3-a76e-2535879eb995">
    </td>
    <td align="center">
      <img width="400" src="https://github.com/user-attachments/assets/6142854b-077f-4012-b8b0-e488ef405bb5">
    </td>
  </tr>
</table>

- 문자인증을 통하여 비밀번호 찾기 및 변경을 할 수 있습니다.


---

**<나의 일대기>**<br>
<table>
  <tr>
    <td align="center">
      <strong><나의 일대기></strong><br>
      <img width="400" src="https://github.com/user-attachments/assets/a17da4fd-bd4b-4b8d-b28e-7ee8e00f4162">
    </td>
    <td align="center">
      <strong><내가 좋아요한 게시글 목록></strong><br>
      <img width="400" src="https://github.com/user-attachments/assets/30cc1cf3-078a-4a1c-8f4f-bd20c4780be1">
    </td>
  </tr>
  <tr>
    <td align="center">
      <strong><내가 쓴 댓글 목록></strong><br>
      <img width="400" src="https://github.com/user-attachments/assets/965c1863-0604-409f-ad64-9db3fe124f87">
    </td>
    <td align="center">
      <strong><회원 정보 수정></strong><br>
      <img width="400" src="https://github.com/user-attachments/assets/d97b0727-5e7c-4f8e-b95c-f63a7799245e">
    </td>
  </tr>
</table>

- 마이페이지처럼 내가 직접 활동한 목록들을 수정하고 볼 수 있습니다.

---

**<게시글, 댓글 작성 밒 신고>**<br>
<table>
  <tr>
    <td align="center">
      <strong><게시글 작성></strong><br>
      <img width="400" src="https://github.com/jang1234567/timenotionBack_final/assets/120088675/84b29d08-cd1a-4859-8c7e-920af1714ea5">
    </td>
    <td align="center">
      <strong><댓글 작성></strong><br>
      <img width="400" src="https://github.com/user-attachments/assets/baccff61-901c-4b25-abb3-3dab3c20e57f">
    </td>
     <td align="center">
      <strong><댓글 신고></strong><br>
      <img width="200" src="https://github.com/user-attachments/assets/4f0bc4b9-0e04-41e4-a940-9be4299e4f09">
      <img width="200" src="https://github.com/user-attachments/assets/c3a8d199-f2ea-4094-856d-071e6aaf9b81">
    </td>
  </tr>
</table>

-  댓글로 욕설이나 좋지 않은 언행을 한 특정인원을 신고하여 관리자에게 알림이 가도록 구현하였습니다.





---

**<모두의 일대기>**<br>
<table>
  <tr>
    <td align="center">
      <strong><모두의 일대기></strong><br>
      <img width="400" src="https://github.com/jang1234567/timenotionBack_final/assets/120088675/4f3f5cf0-0d8c-4fb1-9a1c-7bd0bbc0b283">
    </td>
    <td align="center">
      <strong><상세페이지></strong><br>
      <img width="400" src="https://github.com/user-attachments/assets/6bfb7fd1-dfda-49c4-84c4-034073c5e88a">
    </td>
    <td align="center">
      <strong><게시글 좋아요></strong><br>
      <img width="400" src="https://github.com/user-attachments/assets/64135823-c278-4b7f-9e43-52c77266dde8">
    </td>
  </tr>
</table>

- 상세페이지에서 특정인원의 게시글이 마음에 들었을 경우, 게시글 좋아요 버튼을 누를수 있습니다.
- 정렬된 상태로 게시글을 확인할 수 있습니다.



---

**<너의 일대기>**<br>
<table>
  <tr>
    <td align="center">
      <strong><너의 일대기></strong><br>
      <img width="400" src="https://github.com/user-attachments/assets/a3b36d09-95f4-4c05-9275-ba469508e580">
    </td>
    <td align="center">
      <strong><팔로우, 팔로잉></strong><br>
      <img width="400" src="https://github.com/user-attachments/assets/d97a452b-763c-49dd-905e-42a12a63f82d">
    </td>
  </tr>
</table>

- 마음에 드는 사용자의 페이지에 들어가서 해당 인원을 팔로잉 할 수 있습니다.


---

**<채팅>**<br>
<table>
  <tr>
    <td align="center">
      <strong><채팅목록></strong><br>
      <img width="400" src="https://github.com/user-attachments/assets/ca14e2e4-57fb-4ecd-a05a-551d3780e802">
    </td>
    <td align="center">
      <strong><채팅방></strong><br>
      <img width="400" src="https://github.com/user-attachments/assets/f8bafa24-4143-45d1-8c31-58ac5eb9ce26">
    </td>
  </tr>
</table>

- 마음에 드는 사용자의 페이지에 들어가서 해당 인원에게 채팅할 수 있습니다.


---




  **<커뮤니티(공지,문의)>**<br>
<table>
  <tr>
    <td align="center">
      <strong><공지></strong><br>
      <img width="400" src="https://github.com/user-attachments/assets/d86ba5f4-819a-4d9e-a3b6-7853c09ba031">
    </td>
    <td align="center">
      <img width="400" src="https://github.com/user-attachments/assets/2dcc7a6a-29bf-4316-861a-d765aa67dcab">
    </td>
    <td align="center">
      <strong><문의></strong><br>
      <img width="400" src="https://github.com/user-attachments/assets/d1c2f72d-0895-42c4-a269-55ca40480628">
    </td>
    <td align="center">
      <img width="400" src="https://github.com/user-attachments/assets/193f0321-d462-4a6b-8f82-4bc6b08feb4d">
    </td>
  </tr>
</table>

- 공지는 관리자만 가능하며 관리자가 아닌 사람은 로그인하면 작성하기 버튼이 보이지 않는다.<br>
- 문의는 모든 회원들이 할 수 있으며, 문의에 대한 답변은 관리자만 할 수 있다.


---
**<관리자 페이지>**
<table>
  <tr>
    <td align="center">
      <strong><대쉬보드></strong><br>
      <img width="400" src="https://github.com/user-attachments/assets/5994bf9f-c57c-4c5c-947c-b0780e7825fb">
    </td>
    <td align="center">
      <strong><게시글 관리></strong><br>
      <img width="400" src="https://github.com/user-attachments/assets/9f8f01ca-76d6-4258-aca3-290032f5d4c3">
    </td>
    <td align="center">
      <strong><공지관리></strong><br>
      <img width="400" src="https://github.com/user-attachments/assets/8d3ed4d0-50e3-420a-b4e1-d323d5c32cbf">
    </td>
    <td align="center">
      <strong><문의관리></strong><br>
      <img width="400" src="https://github.com/user-attachments/assets/16966be5-9220-4683-b753-cbcc1c8b0edf">
    </td>
          <td align="center">
      <strong><회원관리></strong><br>
      <img width="400" src="https://github.com/user-attachments/assets/e6271070-8b1f-4a6d-acad-c6ae02824672">
    </td>
  </tr>
</table>

- 관리자는 모든 인원들의 상태를 확인하고 관리할 수 있어야 합니다.

---

## ⚙ Stacks

### Environment
<div>
  <img src="https://img.shields.io/badge/Visual Studio Code-007ACC?style=flat&logo=visualstudiocode&logoColor=white"/>
  <img src="https://img.shields.io/badge/IntelliJ-FE315D?style=flat&logo=intellijidea&logoColor=white"/>
  <img src="https://img.shields.io/badge/DBeaver-382923?style=flat&logo=dbeaver&logoColor=white"/>
  <img src="https://img.shields.io/badge/Git-F05032?style=flat&logo=git&logoColor=white"/>
  <img src="https://img.shields.io/badge/GitHub-181717?style=flat&logo=github&logoColor=white"/>
</div>

### Development
<div>
  <img src="https://img.shields.io/badge/HTML-E34F26?style=flat&logo=html5&logoColor=white"/>
  <img src="https://img.shields.io/badge/CSS-1572B6?style=flat&logo=css3&logoColor=white"/>
  <img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=flat&logo=javascript&logoColor=white"/>
  <img src="https://img.shields.io/badge/Java-5382A1?style=flat"/>
  <img src="https://img.shields.io/badge/Thymeleaf-005F0F?style=flat&logo=thymeleaf&logoColor=white"/>
  <img src="https://img.shields.io/badge/Springboot-6DB33F?style=flat&logo=springboot&logoColor=white"/>
  <img src="https://img.shields.io/badge/Oracle-F80000?style=flat&logo=oracle&logoColor=white"/>
  <img src="https://img.shields.io/badge/MyBatis-362929?style=flat"/>
</div>

### API
<div>
  <img src="https://img.shields.io/badge/COOLSMS-0288D1?style=flat&logo=twilio&logoColor=white"/>
  <img src="https://img.shields.io/badge/KakaoLogin-FFCD00?style=flat&logo=kakao&logoColor=white"/>
   <img alt="Static Badge" src="https://img.shields.io/badge/WebSocket-010101%3Fstyle%3Dflat%26logo%3DWebSocket%26logoColor%3Dwhite%22">

</div>
