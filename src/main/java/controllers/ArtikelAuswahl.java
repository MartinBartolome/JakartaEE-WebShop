package controllers;

import beans.Artikel;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Named
@ViewScoped
public class ArtikelAuswahl extends ManagedBean {
    private List<beans.IArtikel> artikel;

    public void initialize() {
        suchen();
    }

    public String getPageEinkaufswagen() {
        return "einkaufswagen.xhtml";
    }

    public List<beans.IArtikel> getArtikel() {
        return this.artikel;
    }

    public void suchen() {
        try {
            setSessionValue("ArtikelIdentifier", 0);
            dataAccessObjects.IArtikel repository = new dataAccessObjects.Artikel();
            this.artikel = repository.get((int)getSessionValue("Sprache"));
        } catch (Exception exception) {
            String text = exception.getMessage();
        }
    }

    public String artikelInKonfiguratorLaden() {
        setSessionValue("ArtikelIdentifier", Integer.parseInt(getRequestParameter("ArtikelIdentifier")));
        return "load" + getRequestParameter("ArtikelKonfigurator");
    }
}
