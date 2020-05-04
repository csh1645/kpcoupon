package com.kakaopay.kpcoupon.Logic.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kakaopay.kpcoupon.Base.Jwt.JwtUtil;
import com.kakaopay.kpcoupon.Entity.SignInRequest;
import com.kakaopay.kpcoupon.Entity.SignInResponse;
import com.kakaopay.kpcoupon.Entity.SignUpRequest;
import com.kakaopay.kpcoupon.Entity.User;
import com.kakaopay.kpcoupon.Logic.UserService;
import com.kakaopay.kpcoupon.Store.UserRepository;



@Service
public class UserLogic implements UserService {
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private UserRepository userRepository;

	public void signUp(SignUpRequest signUpRequest) {
		verifyDuplicatedUser(signUpRequest.getEmail());
		User newUser = User.builder().userEmail(signUpRequest.getEmail()).userPassword(signUpRequest.getPassword())
				.token(jwtUtil.createToken()).build();	
		userRepository.save(newUser);
	}

	private void verifyDuplicatedUser(String userEmail) {
		if (userRepository.findByUserEmail(userEmail).isPresent())
			throw new IllegalArgumentException("중복된 유저입니다.");
	}

	public SignInResponse signIn(SignInRequest signInRequest) {
		User findUser = userRepository.findByUserEmail(signInRequest.getEmail())
				.orElseThrow(() -> new IllegalArgumentException("없는 유저입니다."));
		if (!findUser.getUserPassword().equals(signInRequest.getPassword()))
			throw new IllegalArgumentException("암호가 일치하지 않습니다.");
		return new SignInResponse(findUser.getToken());
	}

	@Override
	public User findById(Long userId) {
		return userRepository.findById(userId).get();
	}
}