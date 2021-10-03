package database.beans;

public class Kunde implements IKunde {
    private int identifier;
    private int nummer;
    private String name;
    private String vorname;
    private String telefonNummer;
    private String eMailAdresse;
    private int zustand;
    private int sprache;

    @Override
    public int getIdentifier() {
        return this.identifier;
    }

    @Override
    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    @Override
    public int getNummer() {
        return this.nummer;
    }

    @Override
    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getVorname() {
        return this.vorname;
    }

    @Override
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    @Override
    public String getTelefonNummer() {
        return this.telefonNummer;
    }

    @Override
    public void setTelefonNummer(String telefonNummer) {
        this.telefonNummer = telefonNummer;
    }

    @Override
    public String getEMailAdresse() {
        return this.eMailAdresse;
    }

    @Override
    public void setEMailAdresse(String eMailAdresse) {
        this.eMailAdresse = eMailAdresse;
    }

    @Override
    public int getZustand() {
        return this.zustand;
    }

    @Override
    public void setZustand(int zustand) {
        this.zustand = zustand;
    }

    @Override
    public int getSprache() {
        return this.sprache;
    }

    @Override
    public void setSprache(int sprache) {
        this.sprache = sprache;
    }
}
