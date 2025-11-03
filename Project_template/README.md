# 🧩 Spring Legacy MVC Template

> **기본 스프링 MVC + MyBatis + Tiles + Security + FileUpload + Ajax(REST) 프로젝트 템플릿**

---

## 📁 프로젝트 생성 및 기본 설정

### 🔹 새 프로젝트 생성
File > New > Spring Legacy Project > Spring MVC Project

yaml
코드 복사

- **Project name:** `Project`  
- **Root package:** `com.test.project`

---

## ⚙️ 버전 설정

| 항목 | 버전 | 설정 위치 |
|------|------|------------|
| **Java** | 11 | `pom.xml`, Project > Properties > Project Facets |
| **Spring Framework** | 5.0.7 | `pom.xml` |

---

## 🧱 프로젝트 구성 요소

| 구성요소 | 설명 | 관련 설정 파일 |
|-----------|------|----------------|
| **Spring MVC** | 기본 MVC 패턴 구성 | `servlet-context.xml` |
| **MyBatis (인터페이스 매퍼)** | SQL 매핑, DB 연동 | `root-context.xml`, `mapper/config` |
| **Tiles** | JSP 레이아웃 관리 | `servlet-context.xml` |
| **Spring Security** | 로그인/권한 관리 | `web.xml`, `pom.xml` |
| **File Upload** | 파일 업로드 기능 | `web.xml` |
| **Ajax / REST Controller** | 비동기 통신 및 REST API | `pom.xml (jackson-databind)` |

---

## 🧩 서브 프로젝트 구성 예시

| 서브 프로젝트 | 목적 | 핵심 설정 파일 |
|----------------|------|----------------|
| **MyBatisSimpleTest / SecurityTest** | MyBatis 또는 Security 단독 테스트용 | `pom.xml`, `root-context.xml` |
| **TilesTest** | Tiles 템플릿 테스트 | `pom.xml`, `servlet-context.xml` |
| **SecurityTest** | Security 기능 확인 | `pom.xml`, `web.xml` |
| **FileTest** | 파일 업로드 테스트 | `web.xml` |
| **AjaxTest** | REST Controller & JSON 테스트 | `pom.xml (jackson-databind)` |

---

## 📜 SQL 스크립트
- `/Project/script.sql`  
  → 기본 테이블, 회원/게시판 등 초기 데이터 생성용 SQL

---

## 👤 회원 관련 기능
| 기능 | JSP | Controller |
|------|------|-------------|
| 회원가입 | `views/content/member/add.jsp` | `MemberController.java` |
| 로그인 | `views/content/member/login.jsp` | `MemberController.java` |
| 로그아웃 | - | `MemberController.java` |

---

## 🗂 게시판 관련 기능
- CRUD (Create, Read, Update, Delete)
- 게시글 등록 / 수정 / 삭제 / 상세보기 / 목록보기

---

## 🧾 주요 파일 구조

src/main/java
└─ com.test.project
├─ controller
│ └─ MemberController.java
├─ mapper
│ └─ MemberMapper.java # 재사용 가능 Mapper 인터페이스
└─ model
└─ MemberDTO.java

src/main/webapp/WEB-INF/views
├─ content/
│ └─ member/
│ ├─ add.jsp
│ └─ login.jsp
├─ inc/
│ └─ header.jsp
└─ layout/
└─ tiles 설정 관련 JSP

src/main/resources
├─ mappers/
│ └─ member-mapper.xml
└─ config/
└─ mybatis-config.xml

yaml
코드 복사

---

## 💾 사용 기술 스택

| 분류 | 기술 |
|------|------|
| **Language** | Java 11 |
| **Framework** | Spring 5.0.7 (Legacy MVC) |
| **ORM / DB Layer** | MyBatis |
| **View Template** | JSP + Tiles |
| **Security** | Spring Security |
| **Build Tool** | Maven |
| **Server** | Apache Tomcat 9 |
| **Database** | Oracle (또는 MySQL) |
| **Front** | JSTL, jQuery, Ajax |

---

## 🧠 참고
- STS(Spring Tool Suite) 또는 Eclipse 기반 프로젝트
- `.settings`, `.classpath`, `.project`, `/bin`, `/target` 등은 `.gitignore`로 관리
- 각 모듈은 독립 테스트 가능하며, `Project`는 전체 통합형 구조

---

📌 **본 템플릿은 학습용/기본 구조용으로, 실제 배포 전 환경설정(security, datasource, file path 등)은 별도 구성 필요**