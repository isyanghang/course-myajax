package com.xmut.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xmut.dao.ProvinceDao;
import com.xmut.entiy.Province;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author yhstart
 * @create 2021-01-24 19:30
 */
public class QueryJsonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json="{}";
        String strProid=request.getParameter("proid");
        if(strProid!=null && strProid.trim().length()>0){
            ProvinceDao dao=new ProvinceDao();
            Province p=dao.queryProvinceById(Integer.valueOf(strProid));
            ObjectMapper om=new ObjectMapper();
            json=om.writeValueAsString(p);

            response.setContentType("application/json;charset=utf-8");
            PrintWriter pw= response.getWriter();
            pw.println(json);
            pw.flush();
            pw.close();
        }
    }
}
