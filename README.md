# spring-toy-project

### google docs
* https://drive.google.com/drive/folders/12CGqyz-UFBszuElMsr_M1edTmutmoCRv

##
### project
<blockquote>활용 스택</blockquote>

* JDK 1.8
* Gradle
* Spring Boot 2.0
* Rest API (Springfox-swagger-ui)
* Spring-Data-JPA 2.0
* Spring Security, JWT
* AWS RDS Mariadb

<blockquote>project-structure</blockquote>
<pre><code>
commerce
├── advice
│   ├── ItemErrorAdvice.class
│   ├── OrderErrorAdvice.class
│   └── UserErrorAdvice.class
├── aop
│   └── LogAspect.class
├── applications
│   ├── ItemService.class
│   ├── OrderService.class
│   └── UserService.class
├── config
│   ├── SecurityConfig.class
│   └── SwaggerConfig.class
├── domain
│   ├── enums
│   │   ├── OrderStatus.class
│   │   └── UserLevel.class
│   ├── item
│   │   ├── item.class
│   │   ├── ItemNotFoundException.class
│   │   ├── ItemOverlapException.class
│   │   ├── ItemRepository.class
│   │   ├── ItemRequestDto.class
│   │   ├── ItemResponseDto.class
│   │   └── ItemStockLimitException.class
│   ├── orderItem
│   │   ├── OrderItem.class
│   │   ├── OrderItemRepository.class
│   │   ├── OrderItemRequestDto.class     
│   │   └── OrderItemResponseDto.class
│   ├── orders
│   │   ├── OrderNotFoundException.class
│   │   ├── OrderRepository.class
│   │   ├── OrderResponseDto.class     
│   │   └── Orders.class
│   ├── session
│   │   ├── SessionRequestDto.class
│   │   └── SessionResponseDto.class
│   └── user
│       └── BaseTimeEntity.class
├── filters
│   └── BaseTimeEntity.class
├── interfaces
│   ├── ItemController.class
│   ├── OrderController.class
│   ├── ProfileController.class
│   ├── ProjectExplainController.class
│   ├── SessionController.class        
│   └── USerController.class
├── utils
│   └── JwtUtil.class
└── CommerceApplication.class
</code></pre>

##
### 일정
<blockquote>완료</blockquote>

* github -> gitlab 이전 (완료, 4/10
* aws ec2 생성 (아마존리눅스, java8, git) (완료, 4/10)
* aws ec2 배포(backend-api, 80 port) (완료, 4/11)
* aws rds mariadb, nginx 무중단 배포, 배포스크립트 (완료, 4/15)

<blockquote>예정</blockquote>

 * TDD junit5 ( tdd 도입과 함께, swagger -> rest api docs로 변경)
 * 도메인 구입, https 적용 (443 port)
 * jenkins 또는 gitlab ci/cd 구축
 * 프론트 구현 + 배포 (react)
 * 모듈 추가 + msa 설계

