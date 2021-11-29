package dataAccessObjects;

import beans.IKonfigurationArtikel;
import beans.IMerkmal;
import entities.BestellungPosition;
import entities.BestellungPositionMerkmal;
import jakarta.persistence.Query;

import java.util.List;

public class Bestellung extends DataAccessObject implements IBestellung {
    public void insert(beans.Bestellung bestellung) {

        entities.Bestellung b = new entities.Bestellung();
        b.setDatumBestellung(1);
        b.setDatumAuslieferung(2);
        b.setKundeIdentifier(bestellung.getKunde().getKunde().getIdentifier());
        b.setEmpfaengerName(bestellung.getKunde().getKunde().getName());
        b.setEmpfaengerVorname(bestellung.getKunde().getKunde().getVorname());
        b.setEmpfaengerAddresse(bestellung.getKunde().getAdresse().getStrasse());
        b.setEmpfaengerOrt(bestellung.getKunde().getAdresse().getOrt());
        b.setEmpfaengerPostleitzahl(bestellung.getKunde().getAdresse().getPostleitzahl());
        b.setEmpfaengerZahlungsArt(String.valueOf(bestellung.getKunde().getZahlungsArt().getZahlungsArt()));
        b.setEmpfaengerNummerKreditkarte(bestellung.getKunde().getZahlungsArt().getNummerKreditkarte());
        b.setEmpfaengerVerfallKreditkarte(bestellung.getKunde().getZahlungsArt().getVerfallKreditkarte());
        b.setZustand(5);
        this.persist(b);
        int pos = 0;
        for (IKonfigurationArtikel artikel : bestellung.getEinkaufswagen().getArtikel()) {

            BestellungPosition bp = new BestellungPosition();
            bp.setBestellungIdentifier(Integer.valueOf(b.getIdentifier()));
            bp.setArtikelIdentifier(Integer.valueOf(artikel.getArtikel().getIdentifier()));
            bp.setBeschreibung(artikel.getArtikel().getBeschreibung());
            bp.setArtikelNummer(String.valueOf(artikel.getArtikel().getNummer()));
            bp.setReihenfolge(pos++);
            bp.setAnzahlEinheiten(Integer.valueOf(artikel.getMerkmaleKalkulation().getMenge()));
            bp.setPreisProEinheit(Float.valueOf(artikel.getMerkmaleKalkulation().getPreisProEinheit()));
            this.persist(bp);
        }

    }
}
