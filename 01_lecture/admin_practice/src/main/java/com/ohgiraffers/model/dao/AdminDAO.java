package com.ohgiraffers.model.dao;

import com.ohgiraffers.model.dto.AttendanceRecordDTO;
import com.ohgiraffers.model.dto.EmployeeDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;

import static com.ohgiraffers.common.JDBCTemplate.*;

public class AdminDAO {

    public List<Map<String, Object>> byPeriodAttendanceInfo() {

        Scanner sc = new Scanner(System.in);
        AttendanceRecordDTO period = new AttendanceRecordDTO();
        String empId = null;
        int dateCode;

        while (true) {

            System.out.print("조회하실 직원의 ID를 입력하세요 : ");
            empId = sc.nextLine();
            if (checkId(empId)) {
                break;
            } else {
                System.out.println("유효하지 않은 ID 입니다. 다시 입력해주세요.");
            }
        }


        System.out.print("조회를 시작할 날짜를 입력하세요 ex) 20240101 : ");
        dateCode = sc.nextInt();

        if (checkDate(dateCode)) {
            period.setDateCode();
        } else {
            System.out.println("유효하지 않은 날짜입니다. 다시 입력해주세요.");
        }


        System.out.print("마지막 날짜를 입력하세요 ex) 20240101 : ");
        dateCode = sc.nextInt();

        if (!checkDate(dateCode)) {
            System.out.println("유효하지 않은 날짜입니다. 다시 입력해주세요.");

        }




        Connection con = getConnection();

        Statement stmt = null;
        ResultSet rset = null;


        List<Map<String, Object>> byPeriodInfoList = null;

        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/attendance-management-query.xml"));
            String query = prop.getProperty("byPeriodAttendance");


            rset = stmt.executeQuery(query);

            byPeriodInfoList = new ArrayList<>();

            while (rset.next()) {
                Map<String, Object> byPeriod = new LinkedHashMap<>();

                byPeriod.put("ID ", rset.getString("emp_id"));
                byPeriod.put("날짜 ", rset.getString("date_code"));
                byPeriod.put("근태코드 ", rset.getString("attendance_code"));
                byPeriod.put("출근 ", rset.getString("arrival_at_work").charAt(0));
                byPeriod.put("퇴근 ", rset.getString("leave_work").charAt(0));
                byPeriod.put("지각 ", rset.getString("late_work").charAt(0));
                byPeriod.put("휴가 ", rset.getString("vacation").charAt(0));
                byPeriod.put("결근 ", rset.getString("day_off").charAt(0));

                byPeriodInfoList.add(byPeriod);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con);
            close(stmt);
            close(rset);
        }

        return byPeriodInfoList;
    }
}





