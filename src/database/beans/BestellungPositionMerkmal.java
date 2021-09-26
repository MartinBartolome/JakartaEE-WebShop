package database.beans;

public class BestellungPositionMerkmal implements IBestellungPositionMerkmal {
    private int identifier;
    private int bestellungPositionIdentifier;
    private int beschreibung;
    private String schluessel;
    private String wert;

    @Override
    public int GetIdentifier() {
        return this.identifier;
    }

    @Override
    public void SetIdentifier(int identifier) {
        this.identifier = identifier;
    }

    @Override
    public int GetBestellungPositionIdentifier() {
        return this.bestellungPositionIdentifier;
    }

    @Override
    public void SetBestellungPositionIdentifier(int bestellungPositionIdentifier) {
        this.bestellungPositionIdentifier = bestellungPositionIdentifier;
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
    public String GetSchluessel() {
        return this.schluessel;
    }

    @Override
    public void SetSchluessel(String schluessel) {
        this.schluessel = schluessel;
    }

    @Override
    public String GetWert() {
        return this.wert;
    }

    @Override
    public void SetWert(String wert) {
        this.wert = wert;
    }
}
