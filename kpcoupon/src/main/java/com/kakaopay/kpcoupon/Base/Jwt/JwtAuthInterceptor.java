package com.kakaopay.kpcoupon.Base.Jwt;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.kakaopay.kpcoupon.Store.UserRepository;

public class JwtAuthInterceptor implements HandlerInterceptor {
//	@Autowired
//	private JwtUtil jwtUtil;
//	
//	@Autowired
//	private UserRepository userRepository;
//	
//	@Autowired
//	private JwtUtilImpl jwtUtilImpl;
//	
//	private String HEADER_TOKEN_KEY = "token";
//	private String TEST_SIGN_KEY = "CSH1645";
//	private Date EXPIRED_TIME = new Date(System.currentTimeMillis() + 100000000 * 10);
//	private String ISSUER = "CSH";
//
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		String givenToken = request.getHeader(HEADER_TOKEN_KEY);
//		System.out.println(givenToken);
//		verifyToken(givenToken);
////		User user = userRepository.findById(Long.parseLong(request.getHeader("userId")))
////				.orElseThrow(() -> new IllegalArgumentException("없는 유저 입니다."));
////		String givenToken = request.getHeader(HEADER_TOKEN_KEY);
////		verifyToken(givenToken, user.getToken());
//		return true;
//	}
//	
//	private void verifyToken(String givenToken, String membersToken) {
//		if (!givenToken.equals(membersToken)) {
//			throw new IllegalArgumentException("사용자의 Token과 일치하지 않습니다.");
//		}
//		jwtUtil.verifyToken(givenToken);
//	}
//	
//	public void verifyToken(String givenToken) {
//		JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TEST_SIGN_KEY)).withIssuer(ISSUER).build();
//		verifier.verify(givenToken);
//	}
}