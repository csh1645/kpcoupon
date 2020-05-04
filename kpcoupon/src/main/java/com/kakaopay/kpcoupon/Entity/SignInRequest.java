package com.kakaopay.kpcoupon.Entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignInRequest {
	private String email;
	private String password;

	@Builder
	public SignInRequest(String email, String password) {
		this.email = email;
		this.password = password;
	}
}