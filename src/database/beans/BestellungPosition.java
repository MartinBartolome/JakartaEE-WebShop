package database.beans;

public class BestellungPosition implements IBestellungPosition {
    private int identifier;
    private int bestellungIdentifier;
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
    public int GetBestellungIdentifier() {
        return this.bestellungIdentifier;
    }

    @Override
    public void SetBestellungIdentifier(int bestellungIdentifier) {
        this.bestellungIdentifier = bestellungIdentifier;
    }

    @Override
    public int GetArtikelIdentifier() {
        return this.artikelIdentifier;
    }

    @Override
    public void SetArtikelIdentifier(int artikelIdentifier) {
        this.artikelIdentifier = artikelIdentifier;
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
