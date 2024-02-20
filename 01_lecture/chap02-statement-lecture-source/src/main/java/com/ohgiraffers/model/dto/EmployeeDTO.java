package com.ohgiraffers.model.dto;

/* DTO(Data Transfer Object)
*  : 여러 계층 간 데이터 전송을 위해 다양한 타입의 데이터를 하나로 묶어 전송하는 쓰임의 클래스
*    유사한 말롤 VO, Bean, Entity, (DO, Domain, Row)등이 있음
* */

/* DTO 클래스의 조건
*  1. 모든 필드는 private
*  2. 기본생성자와 모든 필드를 초기화하는 생성자
*  3. 모든 필드에 대한 setter/getter
*  4. toString() Overriding을 이용한 필드 값 반환용 메소드
*  5. 직렬화 처리
* */
public class EmployeeDTO implements java.io.Serializable {

    private String empId;
    private String empName;
    private String empNo;
    private String email;
    private String phone;
    private String deptCode;
    private String jobCode;
    private String salLevel;
    private int salary;
    private double bonus;
    private String managerId;
    private java.sql.Date hireDate;
    private java.sql.Date entDate;
    private String entYn;

}
