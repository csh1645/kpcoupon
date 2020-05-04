package com.kakaopay.kpcoupon.Entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignInResponse {
	private String token;

	@Builder
	public SignInResponse(String token) {
		this.token = token;	}
}