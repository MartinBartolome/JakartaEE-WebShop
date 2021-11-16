package controllers;

import beans.Artikel;
import beans.IKonfigurationArtikel;
import beans.KonfigurationArtikel;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.util.logging.Logger;

@Named
@ViewScoped
public class Einkaufswagen  extends ManagedBean {
    public beans.IEinkaufswagen getEinkaufswagen() {
        return (beans.IEinkaufswagen)getSessionValue("Einkaufswagen");
    }

    public void initialize() {
    }

    public String artikelLoeschen() {
        getEinkaufswagen().artikelLoeschen(getRequestParameter("ArtikelIdentifier"));
        return "loadEinkaufswagen";
    }

    public String artikelEditieren() {
        beans.IArtikel artikel = getEinkaufswagen().getArtikel(getRequestParameter("ArtikelIdentifier")).getArtikel();
        setSessionValue("ArtikelIdentifier", artikel.getIdentifier());
        return "load" + artikel.getKonfigurator();
    }

    public String bestellungAusloesen() {
        return "loadBestellungAusloesenSchritt1";
    }

    public String abbrechen() {
        return "loadArtikelAuswahl";
    }
}
