package com.example.geungeunhanjan.controller.error;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if (statusCode == 500) {
                model.addAttribute("message", "Internal Server Error");
                return "main/error500";
            } else if (statusCode == 400) {
                model.addAttribute("message", "Bad Request");
                return "main/error400";
            }
        }
        return "error/unknown"; // default error page
    }
}