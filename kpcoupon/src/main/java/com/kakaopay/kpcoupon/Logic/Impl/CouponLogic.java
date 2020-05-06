package com.kakaopay.kpcoupon.Logic.Impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kakaopay.kpcoupon.Base.Kpexception.Kpexception;
import com.kakaopay.kpcoupon.Entity.Coupon;
import com.kakaopay.kpcoupon.Logic.CouponService;
import com.kakaopay.kpcoupon.Store.CouponStore;

@Transactional
@Service
public class CouponLogic implements CouponService {
	
	@Autowired
	private CouponStore couponStore;
	
	public CouponLogic(CouponStore couponStore) {
		this.couponStore = couponStore;	
	}
	
	final char[] possibleCharacters =
	    {'1','2','3','4','5','6','7','8','9','0','A','B','C','D','E','F',
	     'G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V',
	     'W','X','Y','Z'};
	
	@Override
	public List<Coupon> createCoupon(Long qty) {
		
		//쿠폰 시작-만료일자 생성
		List<String> expDate = expirationDate();
		
		List<Coupon> saveCoupons = new ArrayList<Coupon>();
		
		final int possibleCharacterCount = possibleCharacters.length;

		Random rnd = new Random();
		int createQty = 0;
		while (createQty < qty) {
			
			StringBuffer buf = new StringBuffer(30);
			//쿠폰 생성
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
			
			Coupon checkCoupon = couponStore.selectCoupon(couponId);
			
			if(Objects.isNull(checkCoupon)) {
				createQty++;
				
				Coupon setCoupon = new Coupon();
				setCoupon.setCouponId(couponId);
				setCoupon.setCouponUse("N");
				setCoupon.setCouponProvide("N");
				setCoupon.setStartDate(expDate.get(0));
				setCoupon.setEndDate(expDate.get(1));
				
				couponStore.save(setCoupon);
				
				saveCoupons.add(setCoupon);
			}
			
		}
		
		//return couponStore.saveAllCoupon(saveCoupons);
		return saveCoupons;
	}

	@Override
	public String couponpProvide() {
		
		Coupon coupon = couponStore.couponpProvide();
		
		coupon.setCouponProvide("Y");
		
		couponStore.save(coupon);
		
		String couponId = coupon.getCouponId();
				
		return couponId;
	}

	@Override
	public List<Coupon> provideYnCheckCoupon(String provideYn) {
				
		return couponStore.provideYnCheckCoupon(provideYn);
	}
	
	@Override
	public String useCoupon(String couponId) {
		
		Coupon coupon = couponStore.selectCoupon(couponId);
		
		if(Objects.isNull(coupon)) {
			throw new Kpexception("쿠폰이 존재하지 않습니다.");
		}
				
		String returnMsg;
		
		if(coupon.getCouponProvide().equals("Y") &&
				coupon.getCouponUse().equals("N")) {
			coupon.setCouponUse("Y");
			couponStore.save(coupon);
			returnMsg = "쿠폰을 사용 하겠습니다.";
		}else if(coupon.getCouponProvide().equals("N")) {
			returnMsg = "사용 할 수 없는 쿠폰입니다.";
		}else {
			returnMsg = "이미 사용된 쿠폰입니다.";
		}
		
		return returnMsg;
				

	}

	@Override
	public String useCancleCoupon(String couponId) {
		
		Coupon coupon = couponStore.selectCoupon(couponId);
		
		if(Objects.isNull(coupon)) {
			throw new Kpexception("쿠폰이 존재하지 않습니다.");
		}
		
		String returnMsg;
		
		if(coupon.getCouponProvide().equals("Y") &&
				coupon.getCouponUse().equals("Y")) {
			coupon.setCouponUse("N");
			couponStore.save(coupon);
			returnMsg = "쿠폰사용을 취소하였습니다.";
		} else if(coupon.getCouponProvide().equals("Y") &&
				coupon.getCouponUse().equals("N")) {
			returnMsg = "사용하지 않은 쿠폰입니다.";
		}else {
			returnMsg = "취소할 쿠폰이 없습니다.";
		}
		
		return returnMsg;
	}
	
	@Override
	public List<Coupon> expirationCoupon() {
				
		List<String> expDate = expirationDate();
		
		return couponStore.expirationCoupon(expDate.get(0));
	}
		
	
	public List<String> expirationDate(){
		
		List<String> expirationDate = new ArrayList<String>();
		
		//시작일자		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		expirationDate.add(dateFormat.format(date));
		
		//종료일자
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
        cal.add(Calendar.DATE, 3);		
		expirationDate.add(dateFormat.format(cal.getTime()));
		
		return expirationDate;
	}
	
	@Scheduled(fixedDelay = 60000) 
	public void expirationCouponSend() {
		
		List<String> expDate = expirationDate();
		List<Coupon> expCouponList = couponStore.expirationCoupon(expDate.get(1));
		
		if(expCouponList.isEmpty()) {
			System.out.println("만료 대상이 없습니다.");
		}
		
		for(Coupon coupon : expCouponList ) {
			System.out.println("'" + coupon.getCouponId() + "'쿠폰이 3일후 만료됩니다.");
		}
	}
}
