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
import DAO.EmpDao;
import Pojo.Emp;
/**
 *
 * @author Dilip J Sarvaiya
 */
@WebServlet(urlPatterns = {"/SaveServlet"})
public class SaveServlet extends HttpServlet {
    StringBuffer strbuff=new StringBuffer();
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
          //String email, String pass, String conf_pass, int age, String branch, String msg, String gender, String hobby  
            
        String email=request.getParameter("email");  
        String pass=request.getParameter("password");  
        String conf_pass=request.getParameter("conf_pass");  
        int age=Integer.parseInt(request.getParameter("age"));  
        String branch=request.getParameter("branch");  
        String msg=request.getParameter("msg");  
        String gender=request.getParameter("gender");  
         String hobby[]=request.getParameterValues("hobby");
         for(String hob:hobby)
            {
                if(strbuff.toString().contains(hob))
                {
                }
                else
                {
                    
                    strbuff.append(hob+ " ");
                }
            }
            out.println(strbuff.toString());
        
          
        Emp e=new Emp();  
        e.setEmail(email);  
        e.setPass(pass);  
        e.setConf_pass(conf_pass);
        e.setAge(age);
        e.setBranch(branch);
        e.setMsg(msg);
        e.setGender(gender);
        e.setHobby(strbuff.toString());
          
        int status=EmpDao.save(e);  
        if(status>0){  
            out.print("<p style=\"color:#ffffff;\" >Record saved successfully!</p>");  
            request.getRequestDispatcher("index.html").include(request, response);  
        }else{  
            out.println("Sorry! unable to save record");  
        }  
          
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
