package com.kakaopay.kpcoupon.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="USER")
@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="USER_ID")
	private Long userId;
	private String userEmail;
	private String userPassword;
	private String token;
	
	@Builder
	public User(Long userId, String userEmail, String userPassword, String token) {
		this.userId = userId;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.token = token;
	}
	
//	@Builder
//	public User(String userEmail, String userPassword, String token) {
//		this.userEmail = userEmail;
//		this.userPassword = userPassword;
//		this.token = token;
//	}
//	
//	@Builder
//	public User(String userEmail, String userPassword) {
//		this.userEmail = userEmail;
//		this.userPassword = userPassword;
//	}
//	
//	@Builder
//	public User(String userEmail) {
//		this.userEmail = userEmail;
//	}
	
	
}
