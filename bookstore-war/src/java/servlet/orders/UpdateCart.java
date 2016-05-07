/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.orders;

import entities.BookOrder;
import entities.Cart;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hoangdd
 */
@WebServlet(name = "UpdateCart", urlPatterns = {"/UpdateCart"})
public class UpdateCart extends HttpServlet {

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
        int idBook = Integer.parseInt(request.getParameter("idBook"));
        String isEdit = request.getParameter("isEdit");
        String isRemove = request.getParameter("isRemove");

        Cart cart = (Cart) session.getAttribute("cart");
        List<BookOrder> listBookOrder = new ArrayList<>();
        if (cart == null) {
            cart = new Cart();
        } else {
            listBookOrder = cart.getBookOrderList();
        }

        if (isEdit.compareToIgnoreCase("true") == 0) {
            response.sendRedirect("/bookstore-war/index/book/detailBook.jsp?idBook=" + idBook);
        } else if (isRemove.compareToIgnoreCase("true") == 0) {
            for (int i = 0; i < listBookOrder.size(); i++) {
                if (listBookOrder.get(i).getIdBook().getIdBook() == idBook) {
                    listBookOrder.remove(i);
                    response.sendRedirect("/bookstore-war/index/orders/checkOut.jsp");
                    break;
                }
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

}
