package com.kakaopay.kpcoupon.Entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateCouponQty {
	private Long couponQty;
	private String endDate;

	@Builder
	public CreateCouponQty(Long couponQty, String endDate) {
		this.couponQty = couponQty;
		this.endDate = endDate;
	}
}