# 회원관리
### memberInsert()
MemberMain → MemberServiceImpl → MemberDAOImpl → MemberDTO → MemberArrayData(MemberArrayData)
### memberList()
MemberMain → MemberServiceImpl → MemberDAOImpl → MemberDTO → MemberArrayData(MemberArrayData) → MemberView
### memberUpdate()
MemberMain → MemberServiceImpl → MemberDAOImpl → MemberDTO → MemberArrayData(MemberArrayData)
### memberDelete()
MemberMain → MemberServiceImpl → MemberDAOImpl → MemberDTO → MemberArrayData(MemberArrayData)
## MemberMain
콘솔에 작업 메뉴를 출력
## MemberArrayListData
자료형을 ArrayList로 처리한 데이터

해당 클래스에서 데이터를 메모리에 저장
### *MemberArrayData*
*자료형을 Array로 처리한 데이터*
## MemberDTO
*DTO - Data Transfer Object(데이터 교환 객체)*

계층 간 데이터 교환을 위해 사용
## MemberView
데이터를 화면에 출력
## MemberService
서비스를 정의하는 인터페이스
## MemberServiceImpl
MemberService를 구현하는 클래스
## MemberDAO
*DAO - Data Access Object(데이터 접근 객체)*

데이터의 CRUD 작업을 정의하는 인터페이스
## MemberDAOImpl
MemberDAO를 구현하는 클래스
