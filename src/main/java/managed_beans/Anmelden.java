package managed_beans;

import beans.AnmeldeDaten;
import beans.IAnmeldeDaten;
import entities.Kunde;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.persistence.Query;
import java.util.logging.Logger;

@Named
@RequestScoped
public class Anmelden extends ManagedBean {
    private static final long serialVersionUID = 3L;
    private static final Logger logger = Logger.getLogger(Anmelden.class.toString());
    private IAnmeldeDaten anmeldeDaten;

    public Anmelden() {
        this.anmeldeDaten = new AnmeldeDaten();
    }

    public IAnmeldeDaten getAnmeldeDaten() {
        return this.anmeldeDaten;
    }

    public void initialize() {
        setSessionValue("KundeIdentifier", 0);
    }

    public String anmelden() {
        try {
            Query query = this.entityManager.createQuery("SELECT k FROM Kunde k WHERE k.eMailAdresse=:eMailAdresse AND k.passwort=:passwort");
            query.setParameter("eMailAdresse", this.anmeldeDaten.getEmailAdresse());
            query.setParameter("passwort", this.anmeldeDaten.getPasswort());
            Kunde kunde = (Kunde)query.getSingleResult();
            if (kunde != null) {
                setSessionValue("KundeIdentifier", kunde.getIdentifier());
                setSessionValue("Sprache", kunde.getSprache());
                FacesContext.getCurrentInstance().addMessage("anmelden", new FacesMessage("Verifikation erfolgreich"));
                return "loadArtikelAuswahl";
            }
        } catch(Exception exObj) {
            FacesContext.getCurrentInstance().addMessage("loginForm:loginName", new FacesMessage("Username Or Password Is Incorrect"));
        }
        return "loadAnmelden";
    }
}
