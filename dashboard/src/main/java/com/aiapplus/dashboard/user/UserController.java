package com.aiapplus.dashboard.user;

import com.aiapplus.dashboard.group.UserGroupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserGroupService userGroupService;

    @GetMapping("/")
    public String login(){
//        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
//        String username=authentication.getName();
//        System.out.println("username"+username);
//        UserInfo user=userService.getUserByUsername(username);
//        if("미승인".equals(user.getStatus())){
//            return "signup";
//        }
        return "login";
    }
    @GetMapping("/signup")
    public String signup(Model model)
    {
        model.addAttribute("userCreateForm",new UserCreateForm());
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "signup";
        }
        if(!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())){
            bindingResult.rejectValue("password2","passwordInCorrect","2개의 패스워드가 일치하지 않습니다.");
            return "signup";
        }
        //TODO : 회원가입 recheck
        userService.create(userCreateForm.getUsername(),
                userCreateForm.getPassword1(),userCreateForm.getEmail(),userCreateForm.getFirstName(),userCreateForm.getLastName(),
                true,userCreateForm.getDepartment(),userCreateForm.getCompanyId(), LocalDateTime.now(),"미승인");

        String username=userCreateForm.getUsername();
        Long userId = userService.findUserIdByUsername(username);

        userGroupService.create(userId,1);

        return "login";
    }


}
