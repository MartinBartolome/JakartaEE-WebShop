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
import java.util.Map;

@Named
@ViewScoped
public class BenutzerProfilController extends ManagedBean {
    protected beans.IKunde kunde = null;
    protected List<GruppeMerkmal> sprachen = null;
    protected boolean isNeuerKunde;

    public void initialize(Boolean IsNeuerKunde) {
        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            Map<String,String> params =
                fc.getExternalContext().getRequestParameterMap();
            isNeuerKunde = Boolean.valueOf(params.get("newUser"));
            dataAccessObjects.IMerkmale merkmalrepo = new Merkmale();
            this.sprachen = merkmalrepo.getSprachen();
            if(isNeuerKunde) {
                this.kunde = new beans.Kunde();
                this.kunde.setKunde(new entities.Kunde());
                this.kunde.getKunde().setZustand(1);
                this.kunde.getKunde().setSprache((int)getSessionValue("Sprache"));
                this.kunde.setAdresse(new Adresse());
                this.kunde.setZahlungsArt(new ZahlungsArt());
            }
            else
            {
                IKunde repository = new Kunde();
                this.kunde = repository.get((int)getSessionValue("KundeIdentifier"));
            }

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
            if(isNeuerKunde)
            {
                IKunde repository = new Kunde();
                repository.insert(kunde);
            }
            else
            {
                IKunde repository = new Kunde();
                repository.update(kunde);
                return "loadArtikelAuswahl";
            }

            return "loadArtikelAuswahl";
        } catch(Exception exObj) {
            FacesContext.getCurrentInstance().addMessage("BenutzerProfilAnlegen:speichern", new FacesMessage("Database exception"));
        }
        return "benutzerprofilAnlegen";
    }
}
