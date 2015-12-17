package com.tsystems.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Improve the code by using WebServlet annotation and JSP page.
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    private  static final Logger LOG = LoggerFactory.getLogger(HelloServlet.class);

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOG.info("Inside HelloServlet.doGet()");
        Object paramName = request.getParameter("name");
        String message = "JSP"; // default param
        if (paramName != null) {
            message = (String)paramName;
            LOG.info("Parameter name: " + message);
        }
        // use jsp to show the content(needn't write so many html in java code)
        request.setAttribute("name", message);
        request.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(request, response);
    }
}
