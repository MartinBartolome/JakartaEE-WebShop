package database.beans;

public class Lager implements ILager {
    private int identifier;
    private String beschreibung;

    @Override
    public int GetIdentifier() {
        return this.identifier;
    }

    @Override
    public void SetIdentifier(int identifier) {
        this.identifier = identifier;
    }

    @Override
    public String GetBeschreibung() {
        return this.beschreibung;
    }

    @Override
    public void SetBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
}
