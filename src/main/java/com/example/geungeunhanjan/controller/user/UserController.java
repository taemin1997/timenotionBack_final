package com.example.geungeunhanjan.controller.user;

import com.example.geungeunhanjan.domain.dto.user.UserSessionDTO;
import com.example.geungeunhanjan.domain.vo.user.UniVO;
import com.example.geungeunhanjan.domain.vo.user.UserVO;
import com.example.geungeunhanjan.mapper.user.UserMapper;
import com.example.geungeunhanjan.service.user.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    //로그인 회원가입 관리하는 페이지 입니다!!!!!!!!!!!!!!!!!!!!!!!

    private final UserService userService;
    private final UserMapper userMapper;


    @GetMapping("/join")
    public String join() {
        return "/user/join";
    }

    // 기능처리
    @PostMapping("/join")
    public String join(HttpServletRequest request) {
        UserVO userVO = new UserVO();
        String year = request.getParameter("userBirth");
        String month = request.getParameter("month");
        String day = request.getParameter("day");

        String formattedDate = String.format("%s-%02d-%02d", year, Integer.parseInt(month), Integer.parseInt(day));
        LocalDate birthDate = LocalDate.parse(formattedDate);

        userVO.setUserId(userMapper.getUserSeqNext());
        userVO.setUserName(request.getParameter("userName"));
        userVO.setUserPassword(request.getParameter("userPassword"));
        userVO.setUserEmail(request.getParameter("userEmail"));
        userVO.setUserNickname(request.getParameter("userNickname"));
        userVO.setUserBirth(birthDate.atStartOfDay());

        userMapper.userJoin(userVO);

        UniVO uniVO = new UniVO();
        uniVO.setUserId(userVO.getUserId());

        userService.userUniJoin(uniVO);


        return "redirect:/user/login";
    }

    // 로그인 getMapping
    @GetMapping("/login")
    public String login(HttpSession session) {
        // 이미 로그인 된 상태인지 확인 후, 로그인 페이지로 리다이렉트
//        if (session.getAttribute("userId") != null) {
//            return "redirect:/main";
//        }
        return "/user/login";
    }


    @PostMapping("/login")
    public String userLogin(@RequestParam("userEmail") String userEmail,
                            @RequestParam("userPassword") String userPassword,
                            HttpSession session) {

        Long userId = userService.userLogin(userEmail, userPassword);
        boolean result = userId != null && userId > 0;


        if (result) {
            UserSessionDTO userSessionDTO = userService.uniUserIdNickname(userId);
            session.setAttribute("uniId", userSessionDTO.getUniId());
            session.setAttribute("userNickname", userSessionDTO.getUserNickname());
            return "redirect:/main";
        } else {
            return "redirect:/main/login?error";
        }
    }


    // 로그아웃
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();  // 세션 무효화
        return "redirect:/main";
    }

    @GetMapping("/login/passwordFind")
    public String findPassword() {
        return "user/passwordFind";
    }

    @GetMapping("/login/passwordFind/passwordFind2")
    public String findPassword2() {
        return "user/passwordFind2";
    }


//    private final OAuth2AuthorizedClientService authorizedClientService;
//    private final CustomOAuth2UserService customOAuth2UserService;
//
//    @GetMapping("/login/oauth2/code/kakao")
//    public String kakaoLoginCallback(@AuthenticationPrincipal CustomOAuth2User customOAuth2User) {
//
//        // OAuth2User 객체에서 필요한 사용자 정보를 가져와서 처리
//        String name = customOAuth2User.getName();
//        String profilePic = customOAuth2User.getProfilePic();
//        String providerId = customOAuth2User.getProviderId();
////        String name = (String) oauth2User.getAttribute("name");
////        String profilePic = (String) oauth2User.getAttribute("profile_image");
////        String providerId = (String) oauth2User.getAttribute("id");
//
//        KakaoVO kakaoUser = kakaoUserService.findByProviderId(providerId);
//        if (kakaoUser == null) {
//            // 새로운 사용자라면 DB에 저장
//            kakaoUser = new KakaoVO();
//            kakaoUser.setName(name);
//            kakaoUser.setProfilePic(profilePic);
////            kakaoUser.setProvider(provider);
//            kakaoUser.setProviderId(providerId);
//            kakaoUserService.insertUser(kakaoUser);
//        } else {
//            // 기존 사용자라면 정보 업데이트
//            kakaoUser.setName(name);
//            kakaoUser.setProfilePic(profilePic);
//            kakaoUserService.updateUser(kakaoUser);
//        }
//
//        return "redirect:/main"; // 로그인 후 리디렉션할 경로
//    }


}
