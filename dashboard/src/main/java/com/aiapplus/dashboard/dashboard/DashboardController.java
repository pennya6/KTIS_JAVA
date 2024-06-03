package com.aiapplus.dashboard.dashboard;

import com.aiapplus.dashboard.user.UserInfo;
import com.aiapplus.dashboard.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class DashboardController {
    private final UserService userService;
    private final SessionRegistry sessionRegistry;

    @Autowired
    public DashboardController(UserService userService, SessionRegistry sessionRegistry){
        this.userService=userService;
        this.sessionRegistry = sessionRegistry;
    }

    public String username(Principal principal){
        UserInfo userInfo=this.userService.getUserByUsername(principal.getName());
        return userInfo.getUsername();
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/dashboard")
    public String login(Model model, Principal principal) {
        model.addAttribute("username",username(principal));
        return "dashboard";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/data_analysis_result")
    public String data_analysis_page(Model model, Principal principal){
        model.addAttribute("username",username(principal));
        return "data_analysis";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/stt_result")
    public String stt_result_page(Model model, Principal principal){
        model.addAttribute("username",username(principal));
        return "stt_result";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/job")
    public String job_page(Model model, Principal principal){
        model.addAttribute("username",username(principal));
        return "job";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/system_setting")
    public String system_setting_page(Model model, Principal principal){
        model.addAttribute("username",username(principal));
        return "system_setting";
    }
}