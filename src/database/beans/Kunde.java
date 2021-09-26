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
    public int GetIdentifier() {
        return this.identifier;
    }

    @Override
    public void SetIdentifier(int identifier) {
        this.identifier = identifier;
    }

    @Override
    public int GetNummer() {
        return this.nummer;
    }

    @Override
    public void SetNummer(int nummer) {
        this.nummer = nummer;
    }

    @Override
    public String GetName() {
        return this.name;
    }

    @Override
    public void SetName(String name) {
        this.name = name;
    }

    @Override
    public String GetVorname() {
        return this.vorname;
    }

    @Override
    public void SetVorname(String vorname) {
        this.vorname = vorname;
    }

    @Override
    public String GetTelefonNummer() {
        return this.telefonNummer;
    }

    @Override
    public void SetTelefonNummer(String telefonNummer) {
        this.telefonNummer = telefonNummer;
    }

    @Override
    public String GetEMailAdresse() {
        return this.eMailAdresse;
    }

    @Override
    public void SetEMailAdresse(String eMailAdresse) {
        this.eMailAdresse = eMailAdresse;
    }

    @Override
    public int GetZustand() {
        return this.zustand;
    }

    @Override
    public void SetZustand(int zustand) {
        this.zustand = zustand;
    }

    @Override
    public int GetSprache() {
        return this.sprache;
    }

    @Override
    public void SetSprache(int sprache) {
        this.sprache = sprache;
    }
}
