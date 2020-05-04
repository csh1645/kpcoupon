package com.kakaopay.kpcoupon.Logic;

import java.util.List;

import com.kakaopay.kpcoupon.Entity.Coupon;

public interface CouponService {
	public List<Coupon> createCoupon(Long qty);
	
	public String couponpProvide();
	
	public List<Coupon> provideYnCheckCoupon(String provideYn);
	
	public String useCoupon(String couponId);
	
	public String useCancleCoupon(String couponId);
	
	public List<Coupon> expirationCoupon();
}
