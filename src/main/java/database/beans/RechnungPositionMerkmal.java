package database.beans;

public class RechnungPositionMerkmal implements IRechnungPositionMerkmal {
    private int identifier;
    private int rechnungPositionIdentifier;
    private String beschreibung;
    private String schluessel;
    private String wert;

    @Override
    public int getIdentifier() {
        return this.identifier;
    }

    @Override
    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    @Override
    public int getRechnungPositionIdentifier() {
        return this.rechnungPositionIdentifier;
    }

    @Override
    public void setRechnungPositionIdentifier(int rechnungPositionIdentifier) {
        this.rechnungPositionIdentifier = rechnungPositionIdentifier;
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
    public String getSchluessel() {
        return this.schluessel;
    }

    @Override
    public void setSchluessel(String schluessel) {
        this.schluessel = schluessel;
    }

    @Override
    public String getWert() {
        return this.wert;
    }

    @Override
    public void setwert(String wert) {
        this.wert = wert;
    }
}
