package com.kakaopay.kpcoupon.Store;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kakaopay.kpcoupon.Entity.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, String>{
	//사용자에게 지급할 미지급 쿠폰 1건 조회
	public List<Coupon> findTop1ByCouponProvideOrderByRegDateAsc(String couponProvide);
	
	//사용자에게 집근된 쿠폰 리스트
	public List<Coupon> findByCouponProvideOrderByRegDateAsc(String couponProvide);
	
	//쿠폰 만료 전 체크-리스트
	public List<Coupon> findByEndDateGreaterThan(String endDate);
	
	//쿠폰 만료대상 체크-리스트
	public List<Coupon> findByEndDate(String endDate);
	
}
