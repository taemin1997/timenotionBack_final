package com.example.geungeunhanjan.controller.user;


import com.example.geungeunhanjan.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// 로그인으로
@RequestMapping("/login")
@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    // 로그인 getMapping
//    @GetMapping()
//    public String login(HttpSession session){
//        // 이미 로그인 된 상태인지 확인 후, 로그인 페이지로 리다이렉트
////        if (session.getAttribute("userId") != null) {
////            return "redirect:/main";
////        }
//        return "/user/login";
//    }

    // 실제 로그인 처리
//    @PostMapping()
//    public String userLogin(@RequestParam("userEmail") String userEmail, @RequestParam("userPassword") String userPassword, HttpSession session){
//
//        Long userId = userService.userLogin(userEmail, userPassword);
//        boolean result = userId != null && userId > 0;
//        session.removeAttribute("userId");
//
//        if(result){
//            session.setAttribute("userId", userId);
//            return "redirect:/main";
//        }else {
//            return "redirect:/login?error";
//        }
//    }
    @GetMapping("/passwordFind")
    public String findPassword() {
        return "user/passwordFind";
    }

    @GetMapping("/passwordFind/passwordFind2")
    public String findPassword2() {
        return "user/passwordFind2";
    }
}
