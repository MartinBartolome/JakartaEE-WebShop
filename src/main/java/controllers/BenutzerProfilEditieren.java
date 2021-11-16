package controllers;

import dataAccessObjects.IKunde;
import dataAccessObjects.Kunde;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class BenutzerProfilEditieren extends BenutzerProfilAnlegen {
    public void initialize() {
        try {
            IKunde repository = new Kunde();
            this.kunde = repository.get((int)getSessionValue("KundeIdentifier"));
        } catch(Exception exception) {
            FacesContext.getCurrentInstance().addMessage("BenutzerProfilEditieren:initialize", new FacesMessage("Database exception"));
        }
    }

    @Override
    public String speichern() {
        try {
            IKunde repository = new Kunde();
            repository.update(kunde);
            return "loadArtikelAuswahl";
        } catch(Exception exObj) {
            FacesContext.getCurrentInstance().addMessage("BenutzerProfilEditieren:speichern", new FacesMessage("Database exception"));
        }
        return "benutzerprofilEditieren";
    }
}
