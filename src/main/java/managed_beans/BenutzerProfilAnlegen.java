package managed_beans;

import entities.*;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.Query;
import jakarta.transaction.UserTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Named
@RequestScoped
public class BenutzerProfilAnlegen extends ManagedBean {
    private static final long serialVersionUID = 5L;
    private static final Logger log = Logger.getLogger(BenutzerProfilAnlegen.class.toString());
    private Kunde kunde;
    private Adresse adresse;
    private ZahlungsArt zahlungsArt;
    private List<GruppeMerkmal> sprachen;

    public BenutzerProfilAnlegen() {
        this.kunde = new Kunde();
        this.adresse = new Adresse();
        this.zahlungsArt = new ZahlungsArt();
    }

    public void initialize() {
        Query query = this.entityManager.createQuery("SELECT g FROM GruppeMerkmal g WHERE g.gruppeIdentifier=2");
        this.sprachen = query.getResultList();
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

    public String speichern() {
        speichernKunde();
        speichernAdresse();
        speichernZahlungsArt();
        return "loadArtikelAuswahl";
    }

    private void speichernKunde() {
        this.kunde.setZustand(1);
        this.kunde.setSprache(3);
        // Epoch seconds now - 01.01.2021 00:00:00
        final long nummer = java.time.Instant.now().getEpochSecond() - 1609459200;
        this.kunde.setNummer(nummer);
        super.persist(this.kunde);
        Query query = this.entityManager.createQuery("SELECT k FROM Kunde k WHERE k.nummer=:nummer");
        query.setParameter("nummer", nummer);
        this.kunde = (Kunde)query.getSingleResult();
    }

    private void speichernAdresse() {
        this.adresse.setKundeIdentifier(this.kunde.getIdentifier());
        super.persist(this.adresse);
    }

    private void speichernZahlungsArt() {
        this.zahlungsArt.setKundeIdentifier(this.kunde.getIdentifier());
        super.persist(this.zahlungsArt);
    }
}
