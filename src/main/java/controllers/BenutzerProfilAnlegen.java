package controllers;

import dataAccessObjects.Kunde;
import dataAccessObjects.IKunde;
import dataAccessObjects.Merkmale;
import entities.*;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.util.List;

@Named
@ViewScoped
public class BenutzerProfilAnlegen extends ManagedBean {
    protected beans.IKunde kunde = null;
    protected List<GruppeMerkmal> sprachen = null;

    public BenutzerProfilAnlegen() {
        this.kunde = new beans.Kunde();
    }

    public void initialize() {
        try {
            this.kunde.getKunde().setZustand(1);
            this.kunde.getKunde().setSprache((int)getSessionValue("Sprache"));
            dataAccessObjects.IMerkmale repository = new Merkmale();
            this.sprachen = repository.getSprachen();
        } catch(Exception exObj) {
            FacesContext.getCurrentInstance().addMessage("BenutzerProfilAnlegen:initialize", new FacesMessage("Database exception"));
        }
    }

    public beans.IKunde getKunde() {
        return this.kunde;
    }

    public List<GruppeMerkmal> getSprachen() {
        return this.sprachen;
    }

    public String speichern() {
        try {
            IKunde repository = new Kunde();
            repository.insert(kunde);
            return "loadArtikelAuswahl";
        } catch(Exception exObj) {
            FacesContext.getCurrentInstance().addMessage("BenutzerProfilAnlegen:speichern", new FacesMessage("Database exception"));
        }
        return "benutzerprofilAnlegen";
    }
}
