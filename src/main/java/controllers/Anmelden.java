package controllers;

import beans.AnmeldeDaten;
import beans.IAnmeldeDaten;
import dataAccessObjects.Kunde;
import dataAccessObjects.IKunde;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class Anmelden extends ManagedBean {
    private IAnmeldeDaten anmeldeDaten = null;

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
            IKunde repository = new Kunde();
            final int identifier = repository.get(this.anmeldeDaten);
            setSessionValue("KundeIdentifier", identifier);
            return "loadArtikelAuswahl";
        } catch(Exception exObj) {
            FacesContext.getCurrentInstance().addMessage("Anmelden:anmelden", new FacesMessage("Database exception"));
        }
        return "loadAnmelden";
    }
}
