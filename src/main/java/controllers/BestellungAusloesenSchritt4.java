package controllers;

import dataAccessObjects.Bestellung;
import dataAccessObjects.Merkmale;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.util.logging.Logger;

@Named
@ViewScoped
public class BestellungAusloesenSchritt4 extends ManagedBean {
    public void initialize() {
    }

    public beans.Bestellung getBestellung() {
        return (beans.Bestellung)getSessionValue("Bestellung");
    }

    public String schrittBestaetigen() {
        try {
            dataAccessObjects.IBestellung repository = new Bestellung();
            repository.insert((beans.Bestellung)getSessionValue("Bestellung"));
            removeSessionValue("Bestellung");
            removeSessionValue("ArtikelIdentifier");
            removeSessionValue("Einkaufswagen");
            return "loadArtikelAuswahl";
        } catch(Exception exObj) {
            FacesContext.getCurrentInstance().addMessage("BestellungAusloesenSchritt4:initialize", new FacesMessage("Database exception"));
        }
        return "loadBestellungAusloesenSchritt4";
    }
}
