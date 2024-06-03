package com.aiapplus.dashboard.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name="accounts_user")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "last_login")
    private Date lastLogin;

    @Column(name = "is_superuser", nullable = false)
    private boolean isSuperuser;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "is_staff", nullable = false)
    private boolean isStaff;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Column(name = "date_joined", nullable = false)
    private Date dateJoined;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "department", nullable = false)
    private String department;

    @Column(name = "status", nullable = false, length = 100, columnDefinition = "varchar(100) default '미승인'")
    private String status;
}
