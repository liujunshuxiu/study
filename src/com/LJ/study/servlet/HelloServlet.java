package com.LJ.study.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class HelloServlet extends GenericServlet{
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        OutputStream out = servletResponse.getOutputStream();
        out.write("Hello Servlet!! \n--by Intellij IDEA".getBytes());
    }
}
