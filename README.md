# 사전과제 : Rest API 기반 쿠폰시스템

## 1. 프로젝트 소개
  - 사용자에게 할인, 선물등 쿠폰을 제공하는 API 서비스

## 2. 개발 환경
  - openJdk 1.8
  - Spring Boot 2.1.7
  - Maven
  - JPA
  - H2

## 3. 문제해결 전략
  - 랜덤한 코드의 쿠폰을 N개 생성하여 데이터베이스에 보관하는 API
        
  - 생성된 쿠폰중 하나를 사용자에게 지급하는 API
  
  - 사용자에게 지급된 쿠폰을 조회하는 API
  
  - 지급된 쿠폰중 하나를 사용하는 API(쿠폰 재사용은 불가)
  
  - 지급된 쿠폰중 하나를 사용 취소하는 API를 구현하세요. (취소된 쿠폰 재사용 가능)
  
  - 발급된 쿠폰중 당일 만료된 전체 쿠폰 목록을 조회하는 API
  
  - 발급된 쿠폰중 만료 3일전 사용자에게 메세지(“쿠폰이 3일 후 만료됩니다.”)를 발송하는 기능
      

## 4. 프로젝트 빌드
  - 이클립스 기준
    - git을 이용하여 Clone : https://github.com/csh1645/kpcoupon.git
    
## 5. 실행 방법
  - KpcouponApplication.java 실행
    - Run As -> Spring Boot App
  - API 테스트
    - swagger를 이용한 테스트
    - URL : http://localhost/swagger-ui.html
  - H2 DB 경로
    - DB 경로 : http://localhost/console
