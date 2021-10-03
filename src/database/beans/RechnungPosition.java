package database.beans;

public class RechnungPosition implements  IRechnungPosition{
    private int identifier;
    private int rechnungIdentifier;
    private int artikelIdentifier;
    private int beschreibung;
    private int artikelNummer;
    private int reihenfolge;
    private int anzahlEinheiten;
    private int preisProEinheit;

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
    public int getBeschreibung() {
        return this.beschreibung;
    }

    @Override
    public void setBeschreibung(int beschreibung) {
        this.beschreibung = beschreibung;
    }

    @Override
    public int getArtikelNummer() {
        return this.artikelNummer;
    }

    @Override
    public void setArtikelNummer(int artikelNummer) {
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
    public int getPreisProEinheit() {
        return this.preisProEinheit;
    }

    @Override
    public void setPreisProEinheit(int preisProEinheit) {
        this.preisProEinheit = preisProEinheit;
    }
}
