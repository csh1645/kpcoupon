package com.kakaopay.kpcoupon.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="COUPON")
@Setter
@Getter
public class Coupon {

	@Id
	@Column(name="COUPON_ID")
	private String couponId;
	
	@Column(name="COUPON_PROVIDE")
	private String couponProvide;
	
	@Column(name="COUPON_USE")
	private String couponUse;
	
	@Column(name="START_DATE")
	private String startDate;
	
	@Column(name="END_DATE")
	private String endDate;
		

}
