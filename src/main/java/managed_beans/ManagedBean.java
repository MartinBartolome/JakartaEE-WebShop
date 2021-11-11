package managed_beans;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.faces.application.Application;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.UserTransaction;

import java.io.Serializable;
import java.util.Map;
import java.util.PropertyResourceBundle;

@Named
@RequestScoped
public class ManagedBean implements Serializable {
    private static final String PERSISTENCE_UNIT_NAME = "onlineshop";

    @PersistenceContext(unitName = PERSISTENCE_UNIT_NAME)
    protected EntityManager entityManager;

    protected Object getSessionValue(String key) {
        return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(key);
    }

    protected void setSessionValue(String key, Object value) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(key, value);
    }

    protected String getRequestParameter(String key) {
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> parameters = context.getExternalContext().getRequestParameterMap();
        return parameters.get(key);
    }

    protected ManagedBean() {
        this.entityManager = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
    }

    @Produces
    public PropertyResourceBundle getBundle() {
        FacesContext context = FacesContext.getCurrentInstance();
        return context.getApplication().evaluateExpressionGet(context, "#{msg}", PropertyResourceBundle.class);
    }

    @Resource
    protected UserTransaction userTransation;

    protected boolean persist(Object entity) {
        try {
            this.userTransation.begin();
            this.entityManager.persist(entity);
            this.userTransation.commit();
        }
        catch (Exception exception) {
            FacesContext.getCurrentInstance().addMessage("ManagedBean.persist", new FacesMessage(exception.getMessage()));
            return false;
        }
        return true;
    }
}
