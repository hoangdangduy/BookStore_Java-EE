/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.person;

import FacadePattern.RegisterAccountFacade;
import entities.Address;
import entities.Customer;
import entities.CustomerMember;
import entities.Fullname;
import entities.Person;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionbean.AddressFacadeLocal;
import sessionbean.FullnameFacadeLocal;
import sessionbean.PersonFacadeLocal;

/**
 *
 * @author hoangdd
 */
@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {

    @EJB
    private PersonFacadeLocal personFacade;

    @EJB
    private FullnameFacadeLocal fullnameFacade;

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
        RegisterAccountFacade raf = new RegisterAccountFacade();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        String fname = null;
        String mname = null;
        String lname = null;
        String num = request.getParameter("num");
        String ward = request.getParameter("ward");
        String district = request.getParameter("district");
        String city = request.getParameter("city");
        String phonenum = request.getParameter("phonenum");
        String email = request.getParameter("email");

        int i = fullname.indexOf(" ");
        fname = fullname.substring(0, i);
        int k = fullname.lastIndexOf(" ");
        lname = fullname.substring(k + 1);
        mname = fullname.substring(i + 1, k);

        int idAddress = addressFacade.getMaxID() + 1;
        int idFullname = fullnameFacade.getMaxID() + 1;
        int idPerson = personFacade.getMaxID() + 1;

        Address address = new Address(idAddress, num, ward, district, city);
        Fullname fullnameEntity = new Fullname(idFullname, fname, mname, lname);
        Person person = new Person(idPerson, ward, fullnameEntity, address);
        Customer customer = new Customer(idPerson, phonenum, email);
        CustomerMember customerMember = new CustomerMember(idPerson, username, password, 1);

        raf.setAddress(address);
        raf.setFullname(fullnameEntity);
        raf.setPerson(person);
        raf.setCustomer(customer);
        raf.setCustomerMember(customerMember);

        if (raf.addAccount()) {
            System.out.println("Register.java : dang ki thanh cong");
            response.sendRedirect("/bookstore-war/index/home/home.jsp");
        } else {
            System.out.println("Register.java : dang ki ko thanh cong");
            response.sendRedirect("/bookstore-war/index/person/register.jsp");
        }
        
//        addressFacade.create(address);
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
