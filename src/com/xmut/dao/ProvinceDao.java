package com.xmut.dao;

import com.xmut.entiy.Province;

import java.sql.*;

public class ProvinceDao {
    public String queryProvinceNameById(Integer provinceId) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "";
        String url = "jdbc:mysql://localhost:3306/springdb";
        String username = "root";
        String password = "123";
        String name = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            sql = "select name from province where id=?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, provinceId);
            rs = pst.executeQuery();
            if (rs.next()) {
                name = rs.getString("name");

            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return name;
    }


    public Province queryProvinceById(Integer provinceId) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "";
        String url = "jdbc:mysql://localhost:3306/springdb";
        String username = "root";
        String password = "123";
        Province province=null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            sql = "select id,name,jiancheng,shenghui from province where id=?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, provinceId);
            rs = pst.executeQuery();
            if (rs.next()) {
                province=new Province();
                province.setId(rs.getInt("id"));
                province.setName(rs.getString("name"));
                province.setJiancheng(rs.getString("jiancheng"));
                province.setShenghui(rs.getString("shenghui"));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return province;
    }
}