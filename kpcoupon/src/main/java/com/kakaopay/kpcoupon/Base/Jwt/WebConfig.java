package com.kakaopay.kpcoupon.Base.Jwt;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
//	private String[] INTERCEPTOR_WHITE_LIST = { "/sign/signUp/**", "/sign/signIn/**", };
//
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(new JwtAuthInterceptor()).addPathPatterns("/*").excludePathPatterns("/sign/signUp",
//				"/sign/signIn",
//				"/swagger-ui.html",
//				"/v2/api-docs",
//				"/configuration/security",
//				"/configuration/ui",
//				"/swagger-resources");
//	}
}