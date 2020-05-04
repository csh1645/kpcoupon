package com.kakaopay.kpcoupon.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kakaopay.kpcoupon.Entity.SignInRequest;
import com.kakaopay.kpcoupon.Entity.SignInResponse;
import com.kakaopay.kpcoupon.Entity.SignUpRequest;
import com.kakaopay.kpcoupon.Logic.UserService;

@RestController
@RequestMapping("/sign")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/signUp")
	public String signUp(SignUpRequest signUpRequest) {
		userService.signUp(signUpRequest);
		return "Sign Up OK";
	}

	@PostMapping("/signIn")
	public SignInResponse signIn(SignInRequest signInRequest) {
		return userService.signIn(signInRequest);
	}
}