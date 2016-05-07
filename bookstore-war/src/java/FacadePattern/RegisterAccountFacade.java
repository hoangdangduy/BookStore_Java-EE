/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FacadePattern;

import entities.Address;
import entities.Customer;
import entities.CustomerMember;
import entities.Fullname;
import entities.Person;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;
import sessionbean.AddressFacadeLocal;
import sessionbean.CustomerFacadeLocal;
import sessionbean.CustomerMemberFacadeLocal;
import sessionbean.FullnameFacadeLocal;
import sessionbean.PersonFacadeLocal;

/**
 *
 * @author hoangdd
 */
public class RegisterAccountFacade {

    CustomerMemberFacadeLocal customerMemberFacade = lookupCustomerMemberFacadeLocal();

    CustomerFacadeLocal customerFacade = lookupCustomerFacadeLocal();

    PersonFacadeLocal personFacade = lookupPersonFacadeLocal();

    FullnameFacadeLocal fullnameFacade = lookupFullnameFacadeLocal();
    AddressFacadeLocal addressFacade = lookupAddressFacadeLocal();

    Person person;
    Fullname fullname;
    Address address;
    Customer customer;
    CustomerMember customerMember;

    EntityManagerFactory emf;

//    @PersistenceContext(unitName = "bookstore-ejbPU")
    EntityManager em;

    UserTransaction utx;

    public Address getAddress() {
        return address;
    }

    public Fullname getFullname() {
        return fullname;
    }

    public Person getPerson() {
        return person;
    }

    public Customer getCustomer() {
        return customer;
    }

    public CustomerMember getCustomerMember() {
        return customerMember;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setFullname(Fullname fullname) {
        this.fullname = fullname;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setCustomerMember(CustomerMember customerMember) {
        this.customerMember = customerMember;
    }

    public boolean addAccount() {
        try {
            addressFacade.create(address);
            fullnameFacade.create(fullname);
            personFacade.create(person);
            customerFacade.create(customer);
            customerMemberFacade.create(customerMember);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    private AddressFacadeLocal lookupAddressFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (AddressFacadeLocal) c.lookup("java:module/AddressFacade!sessionbean.AddressFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private FullnameFacadeLocal lookupFullnameFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (FullnameFacadeLocal) c.lookup("java:module/FullnameFacade!sessionbean.FullnameFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private PersonFacadeLocal lookupPersonFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (PersonFacadeLocal) c.lookup("java:module/PersonFacade!sessionbean.PersonFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private CustomerFacadeLocal lookupCustomerFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (CustomerFacadeLocal) c.lookup("java:module/CustomerFacade!sessionbean.CustomerFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private CustomerMemberFacadeLocal lookupCustomerMemberFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (CustomerMemberFacadeLocal) c.lookup("java:module/CustomerMemberFacade!sessionbean.CustomerMemberFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
