/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.orders;

import entities.Book;
import entities.BookOrder;
import entities.Cart;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.math.NumberUtils;
import sessionbean.BookFacadeLocal;
import sessionbean.BookOrderFacadeLocal;

/**
 *
 * @author hoangdd
 */
@WebServlet(name = "AddToCart", urlPatterns = {"/AddToCart"})
public class AddToCart extends HttpServlet {

    @EJB
    private BookOrderFacadeLocal bookOrderFacade;

    @EJB
    private BookFacadeLocal bookFacade;

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
        System.out.println("AddToCart.java : idBook : " + idBook);
        Cart cart = (Cart) session.getAttribute("cart");
        String strSoLuong = request.getParameter("quantity");
        int soLuong;
        if (NumberUtils.isNumber(strSoLuong)){
            soLuong = Integer.parseInt(strSoLuong);
        }else{
            System.out.println("AddToCart.java : so luong sach nhap vao la string");
            response.sendRedirect("/bookstore-war/index/book/detailBook.jsp?idBook=" + idBook);
            return;
        }
        
        if ((soLuong < 1)) {
            System.out.println("AddToCart.java : so luong sach < 1");
            response.sendRedirect("/bookstore-war/index/book/detailBook.jsp?idBook=" + idBook);
            return;
        }
//        try {
//            soLuong = Integer.parseInt(request.getParameter("quantity"));
//        } catch (NumberFormatException | IllegalStateException e) {
//            response.sendRedirect("/bookstore-war/index/book/detailBook.jsp?idBook=" + idBook);
//            return;
//        }
        Book book = bookFacade.find(idBook);
        BookOrder bookOrder = new BookOrder();
        bookOrder.setQuantity(soLuong);
        bookOrder.setTotalPrice(book.getOriginalprice() * soLuong);
        bookOrder.setIdBook(book);
        bookOrder.setIdCart(cart);

        List<BookOrder> listBookOrder = cart.getBookOrderList();

//
        boolean trungPhanTu = false;
        for (int i = 0; i < listBookOrder.size(); i++) {
            if (listBookOrder.get(i).getIdBook().getIdBook() == idBook) {
                listBookOrder.set(i, bookOrder);
                trungPhanTu = true;
                break;
            }
        }

        if (trungPhanTu == false) {
            listBookOrder.add(bookOrder);
            cart.setBookOrderList(listBookOrder);
        }
        
        session.setAttribute("cart", cart);
        System.out.println("AddToCart.java : kich thuoc list BookOrder : " + listBookOrder.size());
        response.sendRedirect("/bookstore-war/index/book/detailBook.jsp?idBook=" + idBook);
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
