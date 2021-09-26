package database.beans;

public class RechnungPositionMerkmal implements IRechnungPositionMerkmal {
    private int identifier;
    private int rechnungPositionIdentifier;
    private String beschreibung;
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
    public int GetRechnungPositionIdentifier() {
        return this.rechnungPositionIdentifier;
    }

    @Override
    public void SetRechnungPositionIdentifier(int rechnungPositionIdentifier) {
        this.rechnungPositionIdentifier = rechnungPositionIdentifier;
    }

    @Override
    public String GetBeschreibung() {
        return this.beschreibung;
    }

    @Override
    public void SetBeschreibung(String beschreibung) {
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
