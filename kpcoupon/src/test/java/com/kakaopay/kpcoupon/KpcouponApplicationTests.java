package com.kakaopay.kpcoupon;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.Random;

import org.aspectj.lang.annotation.Before;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kakaopay.kpcoupon.Entity.Coupon;
import com.kakaopay.kpcoupon.Logic.CouponService;
import com.kakaopay.kpcoupon.Store.CouponRepository;
import com.kakaopay.kpcoupon.Store.CouponStore;


@RunWith(SpringRunner.class)
@SpringBootTest
class KpcouponApplicationTests {
	
	@Autowired
	private CouponRepository couponRepo;
	
	@Autowired
	private CouponStore couponStore;
	
	@Autowired
	private CouponService couponService;
	
	@Test
	public void couponCreate() {
		
		char[] possibleCharacters =
		    {'1','2','3','4','5','6','7','8','9','0','A','B','C','D','E','F',
		     'G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V',
		     'W','X','Y','Z'};
		
		int possibleCharacterCount = possibleCharacters.length;
				
		Random rnd = new Random();
		
		StringBuffer buf = new StringBuffer(30);
		for (int i= 15; i > 0; i--) {
			
			switch (i) {
			case 5:
				buf.append("-");
				break;
				
			case 11:
				buf.append("-");
				break;
			default:
				buf.append(possibleCharacters[rnd.nextInt(possibleCharacterCount)]);
				break;
			}
			
		}
		
		String couponId = buf.toString();
		
		Coupon setCoupon = new Coupon();
		setCoupon.setCouponId(couponId);
		setCoupon.setCouponUse("N");
		setCoupon.setCouponProvide("N");
		setCoupon.setStartDate("20200505");
		setCoupon.setEndDate("20200508");
		
		couponRepo.save(setCoupon);
		
		Optional<Coupon> selectCoupon = couponRepo.findById(couponId);
		
		Assert.assertNotNull(selectCoupon.get());
	}
	
	@Test
	public void couponpProvide() {
		tempCouponCreate();
		
		Coupon couponpProvide = couponRepo.findTop1ByCouponProvideOrderByStartDateAsc("N").get(0);
		
		Assert.assertNotNull(couponpProvide);
	}
	
	
	public Coupon tempCouponCreate() {
		Coupon setCoupon = new Coupon();
		setCoupon.setCouponId("aaaaa-aaaaaa-aaaaaaa");
		setCoupon.setCouponUse("N");
		setCoupon.setCouponProvide("N");
		setCoupon.setStartDate("20200505");
		setCoupon.setEndDate("20200508");
		
		couponRepo.save(setCoupon);
		
		return couponRepo.save(setCoupon);
	}
	

}
