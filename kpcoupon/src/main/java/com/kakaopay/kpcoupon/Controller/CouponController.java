package com.kakaopay.kpcoupon.Controller;

import java.security.NoSuchAlgorithmException;
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
	
	/**
     * N개의 쿠폰 생성
     * 
     * @param CreateCounponQty
     * @return Coupon List
     */
	@PostMapping("/create")
	public List<Coupon> createCoupon(
			@RequestBody CreateCouponQty createCouponQty){
		
		return couponService.createCoupon(createCouponQty.getCouponQty());
		
	}
	
	/**
     * 생성된 쿠폰 지급
     * 
     * @param 
     * @return couponId
     */	
	@GetMapping("/couponpProvide")
	public String couponpProvide() {
		return couponService.couponpProvide();
		
	}
	
	/**
     * 지급된 쿠폰 리스트
     * 
     * @param provideYn
     * @return coupon List
     */
	@GetMapping("/provideYnCheckCoupon/{provideYn}")
	public List<Coupon> provideYnCheckCoupon(
			@PathVariable String provideYn) {
		return couponService.provideYnCheckCoupon(provideYn);
		
	}
	
	/**
     * 지급된 쿠폰 사용
     * 
     * @param Coupon
     * @return msg
     */
	@PutMapping("/useCoupon")
	public String useCoupon(
			@RequestBody  Coupon coupon) {
		return couponService.useCoupon(coupon.getCouponId());
		
	}
	
	/**
     * 지급된 쿠폰 사용 취소
     * 
     * @param Coupon
     * @return msg
     */
	@PutMapping("/useCancleCoupon")
	public String useCancleCoupon(
			@RequestBody  Coupon coupon) {
		return couponService.useCancleCoupon(coupon.getCouponId());
		
	}
	
	/**
     * 오늘 만료된 쿠폰 리스트
     * 
     * @param provideYn
     * @return coupon List
     */
	@GetMapping("/expirationCoupon")
	public List<Coupon> expirationCoupon() {
		return couponService.expirationCoupon();
	}	
	
		
}
