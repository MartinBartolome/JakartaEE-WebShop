package controllers;

import beans.Bestellung;
import beans.IEinkaufswagen;
import beans.IKonfigurationArtikel;
import dataAccessObjects.IKunde;
import dataAccessObjects.Kunde;
import dataAccessObjects.Merkmale;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.util.logging.Logger;

@Named
@ViewScoped
public class BestellungAusloesenSchritt1 extends ManagedBean {
    private beans.Bestellung bestellung = null;

    public beans.Bestellung getBestellung() {
        return this.bestellung;
    }

    public BestellungAusloesenSchritt1() {
        this.bestellung = new Bestellung();
    }

    public void initialize() {
        try {
            dataAccessObjects.IKunde repositoryKunde = new dataAccessObjects.Kunde();
            beans.IKunde kunde = repositoryKunde.get((int)getSessionValue("KundeIdentifier"));
            this.bestellung.setKunde(kunde);
            this.bestellung.setEinkaufswagen((IEinkaufswagen) getSessionValue("Einkaufswagen"));
            dataAccessObjects.IMerkmale repositoryMerkmale = new dataAccessObjects.Merkmale();
            this.bestellung.getKalkulation().setMerkmale(repositoryMerkmale.getMerkmaleFuerKalkulation((int)getSessionValue("Sprache")));
            kalkulieren();
            setSessionValue("Bestellung", this.bestellung);
        } catch(Exception exception) {
            FacesContext.getCurrentInstance().addMessage("BenutzerProfilEditieren:initialize", new FacesMessage("Database exception"));
        }
    }

    private void kalkulieren()
    {
        float bestellungVersandKosten = 0.0f;
        float bestellungSteuernBetrag = 0.0f;
        float bestellungBetrag = 0.0f;
        for (IKonfigurationArtikel artikel : this.bestellung.getEinkaufswagen().getArtikel()) {
            final float menge = Float.parseFloat(artikel.getMerkmaleKalkulation().getMenge());
            final float betrag = Float.parseFloat(artikel.getMerkmaleKalkulation().getBetrag());
            bestellungVersandKosten = menge * artikel.getMerkmaleKalkulation().getVersandKostenProEinheit();
            bestellungSteuernBetrag = (float)(betrag * artikel.getMerkmaleKalkulation().getSteuernSatz() * 0.01);
            bestellungBetrag += betrag;
        }
        this.bestellung.getKalkulation().setVersandkosten(bestellungVersandKosten);
        this.bestellung.getKalkulation().setSteuern(bestellungSteuernBetrag);
        this.bestellung.getKalkulation().setBetrag(bestellungBetrag + bestellungSteuernBetrag + bestellungVersandKosten);
    }

    public String schrittBestaetigen() {
        return "loadBestellungAusloesenSchritt2";
    }
}
