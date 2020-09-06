package com.nsbt.mrs.app.login

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class LoginController {

    @GetMapping("loginForm")
    fun loginForm() =
        ModelAndView("login/loginForm")
}
