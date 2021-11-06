package entities;

import jakarta.persistence.*;
import jakarta.persistence.Entity;

@Entity
@Table(name="RechnungPosition")
public class RechnungPosition implements IRechnungPosition{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int identifier = 0;
    private int rechnungIdentifier = 0;
    private int artikelIdentifier = 0;
    private String beschreibung = "";;
    private String artikelNummer = "";
    private int reihenfolge = 0;
    private int anzahlEinheiten = 0;
    private float preisProEinheit = 0.0f;

    @Override
    public int getIdentifier() {
        return this.identifier;
    }

    @Override
    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    @Override
    public int getRechnungIdentifier() {
        return this.rechnungIdentifier;
    }

    @Override
    public void setRechnungIdentifier(int rechnungIdentifier) {
        this.rechnungIdentifier = rechnungIdentifier;
    }

    @Override
    public String getBeschreibung() {
        return this.beschreibung;
    }

    @Override
    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    @Override
    public String getArtikelNummer() {
        return this.artikelNummer;
    }

    @Override
    public void setArtikelNummer(String artikelNummer) {
        this.artikelNummer = artikelNummer;
    }

    @Override
    public int getReihenfolge() {
        return this.reihenfolge;
    }

    @Override
    public void setReihenfolge(int reihenfolge) {
        this.reihenfolge = reihenfolge;
    }

    @Override
    public int getAnzahlEinheiten() {
        return this.anzahlEinheiten;
    }

    @Override
    public void setAnzahlEinheiten(int anzahlEinheiten) {
        this.anzahlEinheiten = anzahlEinheiten;
    }

    @Override
    public float getPreisProEinheit() {
        return this.preisProEinheit;
    }

    @Override
    public void setPreisProEinheit(float preisProEinheit) {
        this.preisProEinheit = preisProEinheit;
    }
}
