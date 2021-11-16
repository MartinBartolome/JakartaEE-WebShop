package dataAccessObjects;

import jakarta.annotation.Resource;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.UserTransaction;

public class DataAccessObject {
    private static final String PERSISTENCE_UNIT_NAME = "onlineshop";

    @PersistenceContext(unitName = PERSISTENCE_UNIT_NAME)
    protected EntityManager entityManager;

    protected DataAccessObject() {
        this.entityManager = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
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
            FacesContext.getCurrentInstance().addMessage("DataAccessObject.persist", new FacesMessage(exception.getMessage()));
            return false;
        }
        return true;
    }
}
