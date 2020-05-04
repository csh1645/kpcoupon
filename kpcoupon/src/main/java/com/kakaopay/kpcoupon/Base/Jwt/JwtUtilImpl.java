package com.kakaopay.kpcoupon.Base.Jwt;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

@Component
public class JwtUtilImpl implements JwtUtil {
	private String TEST_SIGN_KEY = "CSH1645";
	private Date EXPIRED_TIME = new Date(System.currentTimeMillis() + 100000000 * 10);
	private String ISSUER = "CSH";

	@Override
	public String createToken() {
		return JWT.create().withIssuer(ISSUER).withExpiresAt(EXPIRED_TIME).sign(Algorithm.HMAC256(TEST_SIGN_KEY));
	}

	@Override
	public void verifyToken(String givenToken) {
		JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TEST_SIGN_KEY)).withIssuer(ISSUER).build();
		verifier.verify(givenToken);
	}
}