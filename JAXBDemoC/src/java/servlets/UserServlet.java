/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.webservice.UserService_Service;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import org.netbeans.xml.schema.user.UserInfo;




/**
 *
 * @author birui
 */
public class UserServlet extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/JAXBDemo/UserService.wsdl")
    private UserService_Service service;



    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String method = request.getParameter("method");
        if (method.equals("login")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            UserInfo result = login(username, password);
            request.setAttribute("loginstatus", result);
            if (result != null) {
                List<UserInfo> infoList = new ArrayList<UserInfo>();
                infoList.add(result);
                request.setAttribute("infoList", infoList);
                request.getRequestDispatcher("dashboard.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Wrong Username or Pasword");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else if (method.equals("register")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String first_name = request.getParameter("first_name");
            String last_name = request.getParameter("last_name");
            String birth_year = request.getParameter("birth_year");
            String birth_month = request.getParameter("birth_month");
            Boolean signup = register(username, password, birth_year, birth_month, email, first_name, last_name);
            if(signup){
                request.setAttribute("error", "Register succeed!");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }else{
                request.setAttribute("error", "Error occurred!");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }


    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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

    private UserInfo login(java.lang.String username, java.lang.String password) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.webservice.UserService port = service.getUserServicePort();
        return port.login(username, password);
    }

    private Boolean register(java.lang.String username, java.lang.String password, java.lang.String birthYear, java.lang.String birthMonth, java.lang.String email, java.lang.String firstName, java.lang.String lastName) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.webservice.UserService port = service.getUserServicePort();
        return port.register(username, password, birthYear, birthMonth, email, firstName, lastName);
    }

    



}
