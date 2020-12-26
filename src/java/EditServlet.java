/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Pojo.Emp;
import DAO.EmpDao;
/**
 *
 * @author Dilip J Sarvaiya
 */
@WebServlet(urlPatterns = {"/EditServlet"})
public class EditServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            
            /* TODO output your page here. You may use following sample code. */
               
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
          
        Emp e=EmpDao.getEmployeeById(id);  
            out.println("<!DOCTYPE html>\n" +
"<!--\n" +
"To change this license header, choose License Headers in Project Properties.\n" +
"To change this template file, choose Tools | Templates\n" +
"and open the template in the editor.\n" +
"-->\n" +
"<html>\n" +
"    <head>\n" +
"        <title>Dilip Sarvaiya</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"       \n" +
"        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" />\n" +
"        \n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"       <style>\n" +
"            body{\n" +
"                background-color: black;\n" +
"            }\n" +
"            .container\n" +
"            {\n" +
"                padding-bottom: 20px;\n" +
"                background-color: orange;\n" +
"            }\n" +
"            h2\n" +
"            {\n" +
"                color:white;\n" +
"            }\n" +
"        </style>\n"+
"    </head>\n" +
"    <body >\n" +
"<nav class='navbar navbar-expand-lg navbar-dark bg-primary'><h2>Update Records</h2></nav>\n"+
"       <div class=\"container\">\n" +
"            <form method =\"post\" action=\"EditServlet2\">\n" +
"            <input type='hidden' name='id' value='"+e.getId()+"' />\n"+                  
"            <div class=\"form-group\">\n" +
"              <label for=\"email\">Email:</label>\n" +
"              <input type=\"email\" class=\"form-control\" id=\"email\" value='"+e.getEmail()+"' placeholder=\"Enter email\" name=\"email\">\n" +
"            </div>\n" +
"            <div class=\"form-group\">\n" +
"                <label for=\"pwd\">Password:</label>\n" +
"                <input type=\"password\" class=\"form-control\" id=\"pwd\" value='"+e.getPass()+"' placeholder=\"Enter password\" name=\"password\">\n" +
"            </div>\n" +
"            <div class=\"form-group\">\n" +
"              <label for=\"pwd\">Confirm Password:</label>\n" +
"              <input type=\"password\" class=\"form-control\" id=\"pwd\" value='"+e.getConf_pass()+"' placeholder=\"Confirm password\" name=\"conf_pass\">\n" +
"            </div>\n" +
"            <div class=\"form-group\">\n" +
"                <label for=\"age\">Age</label>\n" +
"                <input type=\"number\" class=\"form-control\" value='"+e.getAge()+"' placeholder=\"Choose Age\" name=\"age\">\n" +
"            </div>\n" +
"            <div class=\"form-group\">\n" +
"              <label for=\"branch\">Select the Branch</label>\n" +
"              <select class=\"form-control\" value='"+e.getBranch()+"' name=\"branch\">\n" +
"                             <option>Computer Engineering</option>\n" +
"                             <option>Electrical Engineering</option>\n" +
"                             <option>Mechnical Engineering</option>\n" +
"                             <option>Electronics Engineering</option>\n" +
"                             <option>Civil Engineering</option>\n" +
"              </select>\n" +
"            </div>\n" +
"            <div class=\"form-group\">\n" +
"                <label for=\"msg\">Message</label>\n" +
"                 <input value='"+e.getMsg()+"' name=\"msg\"  class=\"form-control\" rows=\"3\" ></textarea>\n" +
"           </div>\n" +
"           <div class=\"form-group\">   \n" +
"                <label for=\"gender\">Gender</label>\n" +
"           </div>        \n" +
"            <div class=\"form-group\">    \n" +
"                \n" +
"             <input type=\"radio\" value=\"Male\"  checked name=\"gender\" />Male\n" +
"             <input type=\"radio\" value=\"Female\"   name=\"gender\" />Female\n" +
"            </div>\n" +
"           \n" +
"  \n" +
"        <div class=\"form-group\">\n" +
"            <label for=\"hobbies\">Hobbies</label>\n" +
"            <div class=\"form-group\">   \n" +
"                <input name =\"hobby\" value=\"Reading\"  checked type=\"checkbox\">Reading\n" +
"            </div>\n" +
"             <div class=\"form-group\">  \n" +
"                <input name=\"hobby\" value=\"Watching\" checked class=\"form-group\" type=\"checkbox\">Watching\n" +
"             </div>\n" +
"           \n" +
"             <div class=\"form-group\">  \n" +
"                <input name=\"hobby\" value=\"Playing\" checked class=\"form-group\"  type=\"checkbox\">Playing\n" +
"             </div>\n" +
"             <div class=\"form-group\">  \n" +
"                <input name=\"hobby\" value=\"Writing\" checked type=\"checkbox\">Writing\n" +
"             </div>\n" +
"        </div>\n" +
"       <div class=\"form-group\">\n" +
"            <input name=\"edit\"  class=\"btn btn-success\" type=\"submit\"  value='Edit & Save '>\n" +
"       </div>\n" +
"        </form>\n" +
"    </div>\n" +
"    </body>\n" +
"</html>  \n" +
"");          
        out.close();  
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

}
