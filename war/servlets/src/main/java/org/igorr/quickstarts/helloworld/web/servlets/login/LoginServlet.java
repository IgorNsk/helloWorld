package org.igorr.quickstarts.helloworld.web.servlets.login;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.igorr.quickstarts.helloworld.exceptions.AppException;
import org.igorr.quickstarts.helloworld.beans.BeansConfiguration;
import org.igorr.quickstarts.helloworld.beans.services.starter.BeanWithDependency;
import org.igorr.quickstarts.helloworld.beans.services.starter.GreetingService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.SQLException;
import java.util.Locale;


/**
 * Created by db2inst on 07.09.16.
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/login/*")
public class LoginServlet extends HttpServlet {

    private static final Logger LOG = LogManager.getLogger(LoginServlet.class);

    private static final int COLUMN_COUNT = 5;

    /**
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        response.setContentType("text/html;charset=UTF-8");


        String login = request.getParameter("login");
        String password = request.getParameter("password");


        //

        LOG.info("Test Start");

        try (PrintWriter out = response.getWriter()) {

            printHeader(out, request);

            out.println("<h3> login:" + login + "</h3>");
            out.println("<h3> password:" + password + "</h3>");

            printRequest(out, request, response);
        } catch (AppException e) {
            e.printStackTrace();
        }


        // Доергаем спринговые бины
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(BeansConfiguration.class);
        GreetingService greetingService = context.getBean(GreetingService.class);

        BeanWithDependency withDependency = context.getBean(BeanWithDependency.class);
        LOG.info(greetingService.sayGreeting()); // "Greeting, user!"
        LOG.info(withDependency.printText()); // "Some text!"

        //В случае с @Scope("prototype") hashCode будет отличаться
        LOG.info(context.getBean(GreetingService.class).toString());
        LOG.info(context.getBean(GreetingService.class).toString());
        //********************************************************

        LOG.info(context.getBean("greetingService").toString());

        LOG.info("Message: " + context.getMessage("message", null, Locale.getDefault()));
        LOG.info("Argument.required: " + context.getMessage("argument.required", new Object[]{"Test_Argument"}, Locale.getDefault()));
        LOG.info("Argument.required: " + context.getMessage("argument.required", new Object[]{"Test_UK_Argument"}, Locale.UK));

        context.registerShutdownHook();


    }

    private void printHeader(PrintWriter out, HttpServletRequest request) {

        out.println("<html>");
        out.println("<head>");
        out.println("<title> Servlet ClientServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet ClientServlet at " + request.getContextPath() + "</h1>");

    }

    void printRequest(PrintWriter out, HttpServletRequest request, HttpServletResponse response) throws AppException {


        LOG.info("Test Start");
        LOG.info(request.getContextPath());
        LOG.info(response.getContentType());

        printHeaderTable(out);

        try {
            LOG.info("out.close()");
        } catch (Exception e) {
            LOG.error(e.getMessage());
            throw new AppException(e);
        }

    }

    private void printHeaderTable(PrintWriter out) {
        out.println("<table border=\"1\" cellpadding=\"7\" cellspacing=\"0\">");
        out.println("<tr>");
        out.println("<td colspan=\"" + COLUMN_COUNT + "\" bgcolor=\"#D3EDF6\" align=\"center\">Заголовок</td>");
        out.println("</tr>");
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}
