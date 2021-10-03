package database.beans;

public class Adresse implements IAdresse {
    private int identifier;
    private int kundeIdentifier;
    private String strasse;
    private String postleitzahl;
    private String ort;

    @Override
    public int getIdentifier() {
        return this.identifier;
    }

    @Override
    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    @Override
    public int getKundeIdentifier() {
        return this.kundeIdentifier;
    }

    @Override
    public void setKundeIdentifier(int kundeIdentifier) {
        this.kundeIdentifier = kundeIdentifier;
    }

    @Override
    public String getStrasse() {
        return this.strasse;
    }

    @Override
    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    @Override
    public String getPostleitzahl() {
        return this.postleitzahl;
    }

    @Override
    public void setPostleitzahl(String postleitzahl) {
        this.postleitzahl = postleitzahl;
    }

    @Override
    public String getOrt() {
        return this.ort;
    }

    @Override
    public void setOrt(String ort) {
        this.ort = ort;
    }
}
