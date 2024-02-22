package com.ohgiraffers.section02.run;


import com.ohgiraffers.section02.model.dao.MenuDAO;

import java.sql.Connection;

import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application {

    public static void main(String[] args) {

        Connection con = getConnection();
        MenuDAO registDAO = new MenuDAO();

        /* 메뉴의 마지막 번호 조회 */
        int maxMenuCode = registDAO.selectLastMenuCode(con);
        System.out.println("maxMenuCode = " + maxMenuCode);
    }
}
