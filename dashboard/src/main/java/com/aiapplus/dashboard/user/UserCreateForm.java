package com.aiapplus.dashboard.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateForm {
    @NotEmpty(message = "아이디는 필수 항목입니다.")
    private String username;

    @NotEmpty(message = "비밀번호는 필수 항목입니다.")
    @Size(min = 6, message = "비밀번호는 최소 6자 이상이어야 합니다.")
    private String password1;

    @NotEmpty(message = "비밀번호 확인은 필수 항목입니다.")
    private String password2;
    
    @NotEmpty(message = "이메일은 필수 항목입니다.")
    @Email(message = "올바른 이메일 주소를 입력하세요.")
    private String email;

    @NotEmpty(message = "이름은 필수 항목입니다.")
    private String firstName;

    @NotEmpty(message = "성은 필수 항목입니다.")
    private String lastName;

    private Integer companyId;

    @NotEmpty(message = "부서는 필수 항목입니다.")
    private String department;

    private boolean staff;
}
