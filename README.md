"""
# SSAFIT_PROJECT

## 📚 프로젝트 소개
SSAFIT은 사용자가 비디오에 리뷰를 작성하고 관리할 수 있는 웹 애플리케이션입니다. 이 프로젝트는 동영상 조회, 게시, 수정, 삭제 및 리뷰 작성, 수정, 삭제, 조회와 같은 주요 기능을 제공합니다. Spring Boot와 MyBatis를 사용하여 백엔드를 구현하였습니다.

## ⏳ 개발 기간
- **2024년 10월**

## 👥 개발자 소개 및 역할 분담
- **백가은 (팀장, Backend 개발)**: 프로젝트 구조 설계, Spring Boot 기반 리뷰 및 사용자 관리 기능 구현, MyBatis를 활용한 데이터베이스 연동
- **김종명 (Backend 개발)**: Spring Boot 기반 비디오 관리 기능 구현, MyBatis를 활용한 데이터베이스 연동

## 💻 개발 환경
- **IDE**: Spring Tool Suit 4
- **프로그래밍 언어**: Java, SQL
- **빌드 도구**: Maven
- **데이터베이스**: MySQL
- **서버 프레임워크**: Spring Boot
- **협업 툴**: Git

## 🛒 기술 스택
- **Backend**: Spring Boot, Java, MyBatis
- **Database**: MySQL
- **Version Control**: Git
- **API**: RESTful

## 🗂️ 프로젝트 구조
```plaintext
SSAFIT
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── ssafy
│   │   │           └── mvc
│   │   │               ├── config
│   │   │               │   ├── DBConfig.java
│   │   │               │   └── SwaggerConfig.java
│   │   │               ├── controller
│   │   │               │   ├── GlobalExceptionHandlerAdvice.java
│   │   │               │   ├── ReviewController.java
│   │   │               │   ├── UserController.java
│   │   │               │   └── VideoController.java
│   │   │               ├── model
│   │   │               │   ├── dao
│   │   │               │   │   ├── ReviewDao.java
│   │   │               │   │   ├── UserDao.java
│   │   │               │   │   └── VideoDao.java
│   │   │               │   ├── dto
│   │   │               │   │   ├── Review.java
│   │   │               │   │   ├── Status.java
│   │   │               │   │   ├── User.java
│   │   │               │   │   └── Video.java
│   │   │               ├── service
│   │   │               │   ├── ReviewService.java
│   │   │               │   ├── ReviewServiceImpl.java
│   │   │               │   ├── UserService.java
│   │   │               │   ├── UserServiceImpl.java
│   │   │               │   ├── VideoService.java
│   │   │               │   └── VideoServiceImpl.java
│   │   ├── resources
│   │   │   ├── mappers
│   │   │   │   ├── review.xml
│   │   │   │   ├── user.xml
│   │   │   │   └── video.xml
│   │   ├── static
│   │   └── templates
│   └── SsafitApplication.java
```

## 🏷️ 주요 기능 상세

### 🎥 Video Controller
1. **PUT /video/update**: 
   - **기능 설명**: 비디오의 상세 정보를 수정하는 기능입니다. 비디오의 제목, 설명 등을 업데이트할 수 있습니다.
  
2. **POST /video/write**:
   - **기능 설명**: 새로운 비디오를 업로드하거나 작성하는 기능입니다. 비디오의 제목, 설명, 카테고리 등을 입력할 수 있습니다.

3. **GET /video/list**:
   - **기능 설명**: 등록된 모든 비디오 목록을 조회하는 기능입니다. 페이지네이션 및 필터링 옵션을 제공할 수 있습니다.
  
4. **GET /video/list/{part}**:
   - **기능 설명**: 특정 운동 부위에 해당하는 비디오 목록을 조회하는 기능입니다.

5. **GET /video/detail/{id}**:
   - **기능 설명**: 특정 비디오의 상세 정보를 조회하는 기능입니다. 조회 시 비디오 제목, 설명, 업로드 날짜, 조회수 등을 제공합니다.

6. **DELETE /video/delete/{id}**:
   - **기능 설명**: 특정 비디오를 삭제하는 기능입니다. 삭제 시 해당 비디오의 모든 관련 리뷰 및 데이터를 제거할 수 있습니다.

### 📝 Review Controller
1. **GET /video/review/{id}**:
   - **기능 설명**: 특정 리뷰의 상세 정보를 조회하는 기능입니다. 리뷰 내용, 작성자, 작성일, 조회수 등을 제공합니다.

2. **PUT /video/review/{id}**:
   - **기능 설명**: 특정 리뷰를 수정하는 기능입니다. 리뷰의 제목과 내용을 변경할 수 있습니다.
  
3. **DELETE /video/review/{id}**:
   - **기능 설명**: 특정 리뷰를 삭제하는 기능입니다. 삭제 시 해당 리뷰가 비디오와 관련된 모든 데이터에서 제거됩니다.

4. **POST /video/review/{videoId}**:
   - **기능 설명**: 특정 비디오에 리뷰를 작성하는 기능입니다. 작성자는 리뷰 내용을 포함하여 비디오에 대한 피드백을 남길 수 있습니다.

5. **GET /video/review/list/{videoId}**:
   - **기능 설명**: 특정 비디오에 대한 모든 리뷰 목록을 조회하는 기능입니다. 리뷰는 최신순 또는 인기순으로 정렬할 수 있습니다.

### 👤 User Controller
1. **POST /user/regist**:
   - **기능 설명**: 새로운 사용자를 등록하는 기능입니다. 사용자명, 비밀번호, 이메일 등의 정보를 입력하여 계정을 생성합니다.

2. **POST /user/login**:
   - **기능 설명**: 사용자 로그인 기능입니다. 인증을 통해 사용자의 로그인 상태를 유지합니다.

3. **DELETE /user/logout**:
   - **기능 설명**: 사용자 로그아웃 기능입니다. 로그인 상태를 해제합니다.


## 🗂️ 주요 파일 설명
1. **config**: 프로젝트 설정과 관련된 파일들이 포함됩니다.
   - `DBConfig.java`: 데이터베이스 설정을 관리합니다.
   - `SwaggerConfig.java`: API 문서를 자동 생성하기 위한 Swagger 설정을 포함합니다.

2. **controller**: HTTP 요청을 처리하는 컨트롤러 클래스들이 포함됩니다.
   - `GlobalExceptionHandlerAdvice.java`: 전역 예외 처리를 관리합니다.
   - `ReviewController.java`: 리뷰 관련 API를 처리합니다.
   - `UserController.java`: 사용자 인증 및 관리 API를 처리합니다.
   - `VideoController.java`: 비디오 관련 API를 처리합니다.

3. **model**
   - **dao**: 데이터베이스 접근 객체들이 정의되어 있습니다.
     - `ReviewDao.java`, `UserDao.java`, `VideoDao.java`: 각각 리뷰, 사용자, 비디오 데이터베이스 작업을 관리합니다.
   - **dto**: 데이터 전송 객체들이 정의되어 있습니다.
     - `Review.java`, `Status.java`, `User.java`, `Video.java`: 클라이언트와 서버 간의 데이터 교환을 위한 모델입니다.

4. **service**: 비즈니스 로직을 구현하는 클래스들이 포함됩니다.
   - `ReviewService.java`, `ReviewServiceImpl.java`: 리뷰 관련 비즈니스 로직을 처리합니다.
   - `UserService.java`, `UserServiceImpl.java`: 사용자 관련 비즈니스 로직을 처리합니다.
   - `VideoService.java`, `VideoServiceImpl.java`: 비디오 관련 비즈니스 로직을 처리합니다.

5. **resources/mappers**: MyBatis XML 매퍼 파일들이 포함됩니다.
   - `review.xml`, `user.xml`, `video.xml`: 각각 리뷰, 사용자, 비디오 데이터를 매핑하는 SQL 쿼리를 정의합니다.

## 🔄 주요 기능 흐름
1. **리뷰 작성 및 관리 흐름**:
   - 사용자가 리뷰를 작성할 때, `ReviewController`가 요청을 수신합니다.
   - `ReviewService`가 비즈니스 로직을 처리하며, 데이터베이스 작업은 `ReviewDao`를 통해 수행됩니다.
   - MyBatis 매퍼 (`review.xml`)가 SQL 쿼리를 실행하여 리뷰 데이터를 저장하거나 수정합니다.
   - 사용자가 리뷰를 조회하거나 삭제할 때도 동일한 흐름을 따릅니다.

2. **비디오 조회 및 관리 흐름**:
   - 사용자가 비디오 목록을 조회하거나 새 비디오를 추가할 때, `VideoController`가 요청을 처리합니다.
   - `VideoService`는 비즈니스 로직을 관리하고, `VideoDao`가 데이터베이스와 상호작용합니다.
   - MyBatis 매퍼 (`video.xml`)를 사용해 데이터베이스에서 비디오 정보를 가져오거나 업데이트합니다.

3. **사용자 인증 흐름**:
   - 사용자가 회원가입하거나 로그인할 때, `UserController`가 요청을 수신합니다.
   - `UserService`는 인증 및 사용자 관리 로직을 수행하며, `UserDao`를 통해 데이터베이스와 상호작용합니다.