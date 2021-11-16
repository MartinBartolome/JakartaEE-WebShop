package managed_beans;

import entities.*;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Named
@RequestScoped
public class BenutzerProfilEditieren extends ManagedBean {
    private static final long serialVersionUID = 25L;
    private static final Logger log = Logger.getLogger(BenutzerProfilEditieren.class.toString());
    private Kunde kunde;
    private Adresse adresse;
    private ZahlungsArt zahlungsArt;
    private List<GruppeMerkmal> sprachen;

    public void initialize() {
        try {
            // Sprachen
            Query query = this.entityManager.createQuery("SELECT g FROM GruppeMerkmal g WHERE g.gruppeIdentifier=2");
            this.sprachen = query.getResultList();
            // Kundendaten
            query = this.entityManager.createQuery("SELECT k FROM Kunde k WHERE k.identifier=:identifier");
            query.setParameter("identifier", (int)getSessionValue("KundeIdentifier"));
            this.kunde = (Kunde)query.getSingleResult();
            // Adresse
            query = this.entityManager.createQuery("SELECT a FROM Adresse a WHERE a.kundeIdentifier=:identifier");
            query.setParameter("identifier", kunde.getIdentifier());
            this.adresse = (Adresse) query.getSingleResult();
            // Zahlungsart
            query = this.entityManager.createQuery("SELECT z FROM ZahlungsArt z WHERE z.kundeIdentifier=:identifier");
            query.setParameter("identifier", this.kunde.getIdentifier());
            this.zahlungsArt = (ZahlungsArt) query.getSingleResult();
        } catch(Exception exception) {
        }
    }

    public IKunde getKunde() {
        return this.kunde;
    }

    public IAdresse getAdresse() {
        return this.adresse;
    }

    public IZahlungsArt getZahlungsArt() {
        return this.zahlungsArt;
    }

    public List<GruppeMerkmal> getSprachen() {
        return this.sprachen;
    }

    public void speichern() {
    }
}
