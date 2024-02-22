package com.ohgiraffers.section02.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import static com.ohgiraffers.common.JDBCTemplate.close;

public class MenuDAO {

    private Properties prop = new Properties();

    public MenuDAO() {
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/menu-query.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int selectLastMenuCode(Connection con) {

        Statement stmt = null;
        ResultSet rset = null;

        int maxMenuCode = 0;

        String query = prop.getProperty("selectLastMenuCode");

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);

            if(rset.next()) {
                maxMenuCode = rset.getInt("MAX(A.MENU_CODE)");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            close(rset);
            close(stmt);
        }

        return maxMenuCode;
    }
}
