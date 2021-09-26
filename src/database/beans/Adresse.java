package database.beans;

public class Adresse implements IAdresse {
    private int identifier;
    private int kundeIdentifier;
    private String strasse;
    private String postleitzahl;
    private String ort;

    @Override
    public int GetIdentifier() {
        return this.identifier;
    }

    @Override
    public void SetIdentifier(int identifier) {
        this.identifier = identifier;
    }

    @Override
    public int GetKundeIdentifier() {
        return this.kundeIdentifier;
    }

    @Override
    public void SetKundeIdentifier(int kundeIdentifier) {
        this.kundeIdentifier = kundeIdentifier;
    }

    @Override
    public String GetStrasse() {
        return this.strasse;
    }

    @Override
    public void SetStrasse(String strasse) {
        this.strasse = strasse;
    }

    @Override
    public String GetPostleitzahl() {
        return this.postleitzahl;
    }

    @Override
    public void SetPostleitzahl(String postleitzahl) {
        this.postleitzahl = postleitzahl;
    }

    @Override
    public String GetOrt() {
        return this.ort;
    }

    @Override
    public void SetOrt(String ort) {
        this.ort = ort;
    }
}
