# 스프링 부트와 AWS로 혼자 구현하는 웹 서비스

  - SpringBoot 책에서 만든 프로젝트을 변형하여 기능이 추가된 게시글을 구현
  
## Version

  - IDE : IntelliJ IDEA 2019.03.1 (Ultimate Edition)
  - Gradle : gradle-4.10.2
  - SpringBoot : 2.1.7.RELEASE
  - Database : 8.0.18 MySQL Community Server

## Usage

  - application.properties
  ```
  spring.datasource.url=jdbc:mysql://${databasePath}:3306/${databaseName}?serverTimezone=UTC&characterEncoding=UTF-8
  spring.datasource.username=${databaseUserName}
  spring.datasource.password=${databasePW}
  ```
  - application-oauth.properties
  ```
  spring.security.oauth2.client.registration.google.client-id=${google_client_id}
  spring.security.oauth2.client.registration.google.client-secret=${google_client_pw}

  spring.security.oauth2.client.registration.naver.client-id=${naver_client_id}
  spring.security.oauth2.client.registration.naver.client-secret=${naver_client_pw}

  spring.security.oauth2.client.registration.kakao.client-id=${kakao_client_id}
  spring.security.oauth2.client.registration.kakao.client-secret=${kakao_client_pw}
  ```

## Implementation function

  - 게시판 CRUD(등록, 조회, 수정, 삭제) + 검색
  - SpringSecurity 적용
  - OAuth2.0 로그인 구현(구글, 네이버, 카카오)
  - 게시판 Paging 구현