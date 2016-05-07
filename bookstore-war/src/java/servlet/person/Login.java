/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.person;

import entities.Cart;
import entities.CustomerMember;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessionbean.BookFacadeLocal;
import sessionbean.CartFacadeLocal;
import sessionbean.CustomerMemberFacadeLocal;

/**
 *
 * @author hoangdd
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @EJB
    private CartFacadeLocal cartFacade;

    @EJB
    private BookFacadeLocal bookFacade;

    @EJB
    private CustomerMemberFacadeLocal customerMemberFacade;

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
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        CustomerMember customerMember = customerMemberFacade.getCustomerMember(username, password);

        Cart cart = new Cart();
        int idCart;

        try {
            idCart = cartFacade.getMaxID();
        } catch (Exception e) {
            idCart = 1;
        }
        cart.setIdCart(idCart + 1);

        if ((customerMember instanceof CustomerMember) && (customerMember != null)) {
            session.setAttribute("username", username);
            session.setAttribute("idPerson", customerMember.getIdPerson());
            cartFacade.create(cart);
            session.setAttribute("cart", cart);
            response.sendRedirect("/bookstore-war/index/home/home.jsp");
        } else {
            response.sendRedirect("/bookstore-war/index/person/login.jsp");
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
