package com.kakaopay.kpcoupon.Base.Jwt;

public interface JwtUtil {
	
	String createToken();

	void verifyToken(String givenToken);
}
