package controller;

import database.beans.User;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.UserTransaction;

import java.io.Serializable;
import java.util.PropertyResourceBundle;
import java.util.logging.Logger;

@Named
@RequestScoped
public class RegisterController implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final Logger log = Logger.getLogger(RegisterController.class.toString());

    @PersistenceContext(unitName = "onlineshop")
    private EntityManager em;

    @Resource
    private UserTransaction ut;

    @Inject
    private User customer;

    @Produces
    public PropertyResourceBundle getBundle() {
        FacesContext context = FacesContext.getCurrentInstance();
        return context.getApplication().evaluateExpressionGet(context, "#{msg}", PropertyResourceBundle.class);
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public String persist() {
        try {
            ut.begin();
            em.persist(customer);
            ut.commit();
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, getBundle().getString("registerSuccesfull"), null);
            FacesContext.getCurrentInstance().addMessage("registerForm", m);
        } catch (Exception e) {
            e.printStackTrace();
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, getBundle().getString("registerUnsuccesfull"), null);
            FacesContext.getCurrentInstance().addMessage("registerForm", m);
            log.info("Error registering user: " + customer);
            return "failure";
        }
        log.info("User registered: " + customer);
        return "success";
    }
}
