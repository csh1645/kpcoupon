package com.kakaopay.kpcoupon.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.kakaopay.kpcoupon.Base.Kpexception.Kpexception;
import com.kakaopay.kpcoupon.Entity.Coupon;

@Repository
public class CouponStore {
	
	private CouponRepository couponRepository;
	
	public CouponStore(CouponRepository couponRepository) {
		this.couponRepository = couponRepository;	
	}
	
	//수정 - 추가
	public Coupon save(Coupon coupon){
		Coupon returnCoupon = new Coupon();
		
		returnCoupon = couponRepository.save(coupon);
		
		return returnCoupon;
	}
	
	//다량수정 -다량추가
	public List<Coupon> saveAllCoupon(List<Coupon> coupons){
		List<Coupon> returnCoupons = new ArrayList<Coupon>();
		
		returnCoupons = couponRepository.saveAll(coupons);
		
		return returnCoupons;
	}
	
	//쿠폰 조회
	public Coupon selectCoupon(String couponId) {
		Optional<Coupon> optional = couponRepository.findById(couponId);
		
		Coupon coupon = new Coupon();
		
		if(!optional.isPresent()) {
			coupon = null;
		}else {
			coupon = optional.get();
		}
		
		return coupon;
		
	}
	
	//쿠폰지급
	public Coupon couponpProvide() {
		List<Coupon> returnCoupons = couponRepository.findTop1ByCouponProvideOrderByStartDateAsc("N");
		
		if(returnCoupons.isEmpty()) {
			throw new Kpexception("지급가능한 쿠폰이 없습니다.");
		}
		
		return returnCoupons.get(0);
		
	}
	
	//지급여부 확인
	public List<Coupon> provideYnCheckCoupon(String provideYn){
		List<Coupon> returnCoupons = couponRepository.findByCouponProvideOrderByStartDateAsc(provideYn);
		
		return returnCoupons;
	}
	
	//쿠폰 만료일 조회
	public List<Coupon> expirationCoupon(String endDate){
		List<Coupon> returnCoupons = couponRepository.findByEndDate(endDate);
		
		return returnCoupons;
	}
	
}
