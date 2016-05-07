/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.person;

import entities.Address;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessionbean.AddressFacadeLocal;

/**
 *
 * @author hoangdd
 */
@WebServlet(name = "EditAddress", urlPatterns = {"/EditAddress"})
public class EditAddress extends HttpServlet {

    @EJB
    private AddressFacadeLocal addressFacade;

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
        HttpSession session = request.getSession();
        int idPerson = (int) session.getAttribute("idPerson");
        System.out.println(idPerson);
        Address address = addressFacade.find(idPerson);
        System.out.println("EditAddress.java : " + address.getIdAddress());
        String num = request.getParameter("num");
        String ward = request.getParameter("ward");
        String district = request.getParameter("district");
        String city = request.getParameter("city");

        if ((num != null) && (!num.isEmpty())) {
            address.setNum(num);
        }

        if ((ward != null) && (!ward.isEmpty())) {
            address.setWard(ward);
        }
        if ((district != null) && (!district.isEmpty())) {
            address.setDistric(district);
        }
        if ((city != null) && (!city.isEmpty())) {
            address.setCity(city);
        }
        addressFacade.edit(address);

        response.sendRedirect("/bookstore-war/index/person/editAddress.jsp");
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
