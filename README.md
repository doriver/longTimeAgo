# springboot_basic
springboot에 이것저것 해보려 만들었다   
### JPA  
* Dependency : Spring Web , Thymeleaf , Lombok , Spring Data JPA , MySQL Driver
* package : src/main/java/com/sb/basic/jpa
* jpa기본 세팅과 crud를 구현 

### Spring Security
*	의존성   
implementation 'org.springframework.boot:spring-boot-starter-security'   
implementation 'org.thymeleaf.extras:thymeleaf-extras-springsecurity5'
* package : src/main/java/com/sb/basic/security
* 간단한 로그인, 로그아웃, 페이지 권한 구현

### Spring Batch
* 의존성   
implementation 'org.springframework.boot:spring-boot-starter-batch'   
implementation 'org.springframework.boot:spring-boot-starter-quartz'
* package : src/main/java/com/sb/basic/batch
* 일련의 작업을 정해진 로직으로 수행할수 있도록 기본 세팅을 함 
