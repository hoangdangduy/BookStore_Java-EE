/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.orders;

import entities.AddressShipping;
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
import sessionbean.AddressShippingFacadeLocal;
import sessionbean.BookOrderFacadeLocal;
import sessionbean.CartFacadeLocal;
import sessionbean.CustomerMemberFacadeLocal;

/**
 *
 * @author hoangdd
 */
@WebServlet(name = "AddAddressShipping", urlPatterns = {"/AddAddressShipping"})
public class AddAddressShipping extends HttpServlet {

    @EJB
    private CustomerMemberFacadeLocal customerMemberFacade;

    @EJB
    private CartFacadeLocal cartFacade;

    @EJB
    private BookOrderFacadeLocal bookOrderFacade;

    @EJB
    private AddressShippingFacadeLocal addressShippingFacade;

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

        String num = request.getParameter("num");
        String ward = request.getParameter("ward");
        String district = request.getParameter("district");
        String city = request.getParameter("city");
        String phonePerson1 = request.getParameter("phonenum1");
        String namePerson1 = request.getParameter("name1");
        String phonePerson2 = request.getParameter("phonenum2");
        String namePerson2 = request.getParameter("name2");

        AddressShipping as = new AddressShipping();
        as.setNum(num);
        as.setWard(ward);
        as.setDistric(district);
        as.setCity(city);
        as.setNamePerson1(namePerson1);
        as.setNamePerson2(namePerson2);
        as.setPhonePerson1(phonePerson1);
        as.setPhonePerson2(phonePerson2);
        as.setIdAddressShipping(addressShippingFacade.getMaxID() + 1);
        addressShippingFacade.create(as);

        Cart cart = (Cart) session.getAttribute("cart");
        List<BookOrder> listBookOrder = cart.getBookOrderList();

        for (int i = 0; i < listBookOrder.size(); i++) {
            listBookOrder.get(i).setIdBookOrder(bookOrderFacade.getMaxID() + 1);
            bookOrderFacade.create(listBookOrder.get(i));
        }

        double sum = 0;
        for (BookOrder bookOrder : listBookOrder) {
            sum += bookOrder.getTotalPrice();
        }

        cart.setTotalPrice(sum);
        cartFacade.edit(cart);

        cart = new Cart();

        int idCart;

        try {
            idCart = cartFacade.getMaxID();
        } catch (Exception e) {
            idCart = 1;
        }
        cart.setIdCart(idCart + 1);
        cartFacade.create(cart);
        session.setAttribute("cart", cart);
//        session.removeAttribute("cart");
        response.sendRedirect("/bookstore-war/index/home/home.jsp");

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
