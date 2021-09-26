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
    public int GetIdentifier() {
        return this.identifier;
    }

    @Override
    public void SetIdentifier(int identifier) {
        this.identifier = identifier;
    }

    @Override
    public int GetRechnungIdentifier() {
        return this.rechnungIdentifier;
    }

    @Override
    public void SetRechnungIdentifier(int rechnungIdentifier) {
        this.rechnungIdentifier = rechnungIdentifier;
    }

    @Override
    public int GetBeschreibung() {
        return this.beschreibung;
    }

    @Override
    public void SetBeschreibung(int beschreibung) {
        this.beschreibung = beschreibung;
    }

    @Override
    public int GetArtikelNummer() {
        return this.artikelNummer;
    }

    @Override
    public void SetArtikelNummer(int artikelNummer) {
        this.artikelNummer = artikelNummer;
    }

    @Override
    public int GetReihenfolge() {
        return this.reihenfolge;
    }

    @Override
    public void SetReihenfolge(int reihenfolge) {
        this.reihenfolge = reihenfolge;
    }

    @Override
    public int GetAnzahlEinheiten() {
        return this.anzahlEinheiten;
    }

    @Override
    public void SetAnzahlEinheiten(int anzahlEinheiten) {
        this.anzahlEinheiten = anzahlEinheiten;
    }

    @Override
    public int GetPreisProEinheit() {
        return this.preisProEinheit;
    }

    @Override
    public void SetPreisProEinheit(int preisProEinheit) {
        this.preisProEinheit = preisProEinheit;
    }
}
