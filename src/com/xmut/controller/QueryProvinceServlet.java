package com.xmut.controller;

import com.xmut.dao.ProvinceDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author yhstart
 * @create 2021-01-24 12:43
 */
public class QueryProvinceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strProid=req.getParameter("proid");
        System.out.println("strProid:"+strProid);

        String name="默认是无数据的";
        if(strProid!=null&&!"".equals(strProid.trim())){
            ProvinceDao dao=new ProvinceDao();
            name=dao.queryProvinceNameById(Integer.valueOf(strProid));
        }

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw=resp.getWriter();
        pw.println(name);
        pw.flush();
        pw.close();
    }
}
