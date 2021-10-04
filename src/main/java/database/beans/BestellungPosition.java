package database.beans;

public class BestellungPosition implements IBestellungPosition {
    private int identifier;
    private int bestellungIdentifier;
    private int artikelIdentifier;
    private String beschreibung;
    private String artikelNummer;
    private int reihenfolge;
    private int anzahlEinheiten;
    private float preisProEinheit;

    @Override
    public int getIdentifier() {
        return this.identifier;
    }

    @Override
    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    @Override
    public int getBestellungIdentifier() {
        return this.bestellungIdentifier;
    }

    @Override
    public void setBestellungIdentifier(int bestellungIdentifier) {
        this.bestellungIdentifier = bestellungIdentifier;
    }

    @Override
    public int getArtikelIdentifier() {
        return this.artikelIdentifier;
    }

    @Override
    public void setArtikelIdentifier(int artikelIdentifier) {
        this.artikelIdentifier = artikelIdentifier;
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
