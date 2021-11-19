package controllers;

import beans.IMerkmal;
import beans.IArtikel;
import beans.IKonfigurationArtikel;
import beans.Merkmal;
import dataAccessObjects.IMerkmale;
import dataAccessObjects.Merkmale;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.inject.Named;
import jakarta.persistence.*;

@Named
@RequestScoped
public class KonfiguratorBase extends ManagedBean {
    protected IKonfigurationArtikel artikel;
    protected beans.IEinkaufswagen getEinkaufswagen() {
        return (beans.IEinkaufswagen)getSessionValue("Einkaufswagen");
    }

    protected KonfiguratorBase() {
        if (null == getSessionValue("Einkaufswagen")) {
            setSessionValue("Einkaufswagen", new beans.Einkaufswagen());
        }
    }

    public void initialize() {
        try {
            final int artikelIdentifier = (int)getSessionValue("ArtikelIdentifier");
            final int sprache = (int)getSessionValue("Sprache");
            dataAccessObjects.IArtikel repositoryArtikel = new dataAccessObjects.Artikel();
            this.artikel.setArtikel(repositoryArtikel.get(artikelIdentifier, sprache));
            dataAccessObjects.IMerkmale repositoryMerkmale = new dataAccessObjects.Merkmale();
            this.artikel.getMerkmaleInformation().setMerkmale(repositoryMerkmale.getMerkmaleFuerInformation(artikelIdentifier, sprache));
            this.artikel.getMerkmaleKonfiguration().setMerkmale(repositoryMerkmale.getMerkmaleFuerKonfiguration(artikelIdentifier, sprache));
            this.artikel.getMerkmaleKalkulation().setMerkmale(repositoryMerkmale.getMerkmaleFuerKalkulation(artikelIdentifier, sprache));
            getEinkaufswagen().artikelHinzufuegen(this.artikel);
        } catch(Exception exObj) {
            FacesContext.getCurrentInstance().addMessage("KonfiguratorManagedBean:initialize", new FacesMessage("Username Or Password Is Incorrect"));
        }
    }

    public String inEinkaufswagenLegen() {
        IKonfigurationArtikel artikel = getEinkaufswagen().getArtikel(getRequestParameter("ArtikelIdentifier"));
        artikel.setZustand(IKonfigurationArtikel.Zustand.Gueltig);
        return "loadArtikelAuswahl";
    }

    public String konfigurationAbbrechen() {
        beans.IEinkaufswagen einkaufswagen = (beans.IEinkaufswagen)getSessionValue("Einkaufswagen");
        for (beans.IKonfigurationArtikel artikel : einkaufswagen.getArtikel()) {
            if (artikel.getZustand() == IKonfigurationArtikel.Zustand.Ungueltig) {
                einkaufswagen.artikelLoeschen(artikel.getIdentifier());
                break;
            }
        }
        return "loadArtikelAuswahl";
    }
    public void MengeChanged(ValueChangeEvent vce) {
        float menge=Float.parseFloat(vce.getNewValue().toString());
        float preisproeinheit=Float.parseFloat(artikel.getMerkmaleKalkulation().getPreisProEinheit());
        artikel.getMerkmaleKalkulation().setBetrag(String.valueOf(menge*preisproeinheit));
    }
}
