package com.aiapplus.dashboard.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    @GetMapping("/dashboard")
    public String login() {
        return "dashboard";
    }
    @GetMapping("/data_analysis_result")
    public String data_analysis_page(){
        return "data_analysis";
    }
    @GetMapping("/stt_result")
    public String stt_result_page(){
        return "stt_result";
    }
    @GetMapping("/job")
    public String job_page(){
        return "job";
    }
    @GetMapping("/system_setting")
    public String system_setting_page(){
        return "system_setting";
    }
}