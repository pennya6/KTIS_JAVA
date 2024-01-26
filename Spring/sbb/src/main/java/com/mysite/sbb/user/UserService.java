package com.mysite.sbb.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //생성자 주입방법
public class UserService {
	
	private final UserRepository repository;
	private final PasswordEncoder encoder;
	
	public SiteUser create(String username, String email, String password) {
		SiteUser siteUser=new SiteUser();
		siteUser.setUsername(username);
		siteUser.setEmail(email);
		siteUser.setPassword(encoder.encode(password));
		this.repository.save(siteUser);
		return siteUser;
	}

}
