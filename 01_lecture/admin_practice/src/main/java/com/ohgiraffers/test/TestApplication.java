package com.ohgiraffers.test;

import com.ohgiraffers.model.dao.AdminDAO;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class TestApplication {
    public static void main(String[] args) {

        AdminDAO adminDAO=new AdminDAO();
        List<Map<String, Object>> byPeriodInfoList = adminDAO.byPeriodAttendanceInfo();


    }
}
