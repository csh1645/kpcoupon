package com.kakaopay.kpcoupon.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kakaopay.kpcoupon.Base.Jwt.JwtUtil;
import com.kakaopay.kpcoupon.Entity.Coupon;
import com.kakaopay.kpcoupon.Entity.CreateCouponQty;
import com.kakaopay.kpcoupon.Logic.CouponService;

@RestController
@RequestMapping("/coupon")
public class CouponController {
	
	private CouponService couponService;

	private JwtUtil jwtUtil;
	
	public CouponController(CouponService couponService, JwtUtil jwtUtil) {
		this.couponService = couponService;
		this.jwtUtil = jwtUtil;
	}
	
	//쿠폰생성
	@PostMapping("/create")
	public List<Coupon> createCoupon(
			@RequestBody CreateCouponQty createCouponQty){
		
		return couponService.createCoupon(createCouponQty.getCouponQty());
		
	}
	
		
	//쿠폰지급
	@GetMapping("/couponpProvide")
	public String couponpProvide() {
		return couponService.couponpProvide();
		
	}
	
	
	//지급된 쿠폰 리스트
	@GetMapping("/provideYnCheckCoupon/{provideYn}")
	public List<Coupon> provideYnCheckCoupon(
			@PathVariable String provideYn) {
		return couponService.provideYnCheckCoupon(provideYn);
		
	}
	
	//지급된 쿠폰 사용
	@PutMapping("/useCoupon")
	public String useCoupon(
			@RequestBody  Coupon coupon) {
		return couponService.useCoupon(coupon.getCouponId());
		
	}
	
	//지급된 쿠폰 사용 취소
	@PutMapping("/useCancleCoupon")
	public String useCancleCoupon(
			@RequestBody  Coupon coupon) {
		return couponService.useCancleCoupon(coupon.getCouponId());
		
	}
	
	//지급된 쿠폰 리스트
	@GetMapping("/expirationCoupon")
	public List<Coupon> expirationCoupon() {
		return couponService.expirationCoupon();
	}	
	
		
}
