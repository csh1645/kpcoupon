package com.kakaopay.kpcoupon.Logic;

import com.kakaopay.kpcoupon.Entity.SignInRequest;
import com.kakaopay.kpcoupon.Entity.SignInResponse;
import com.kakaopay.kpcoupon.Entity.SignUpRequest;
import com.kakaopay.kpcoupon.Entity.User;

public interface UserService {

	public void signUp(SignUpRequest signUpRequest);
		
	public SignInResponse signIn(SignInRequest signInRequest);
	
	public User findById(Long userId);
}
