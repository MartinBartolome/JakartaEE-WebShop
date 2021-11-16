package controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.util.logging.Logger;

@Named
@ViewScoped
public class BestellungAusloesenSchritt3  extends ManagedBean {
    public void initialize() {
    }

    public beans.Bestellung getBestellung() {
        return (beans.Bestellung)getSessionValue("Bestellung");
    }

    public String schrittBestaetigen() {
        return "loadBestellungAusloesenSchritt4";
    }
}
