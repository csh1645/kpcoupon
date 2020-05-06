package com.kakaopay.kpcoupon.Entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UseCouponId {
	private String couponId;
	//private String endDate;

	@Builder
	public UseCouponId(String couponId) {
		this.couponId = couponId;
	}
}