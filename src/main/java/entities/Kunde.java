package entities;

import jakarta.persistence.*;

@Entity
@Table(name="Kunde")
public class Kunde implements IKunde {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int identifier = 0;
    private long nummer = 0;
    private String name = "";
    private String vorname = "";
    private String telefonNummer = "";
    private String eMailAdresse = "";
    private String passwort = "";
    private int zustand = 0;
    private int sprache = 0;

    @Override
    public int getIdentifier() {
        return this.identifier;
    }

    @Override
    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    @Override
    public long getNummer() {
        return this.nummer;
    }

    @Override
    public void setNummer(long nummer) {
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
    public String getPasswort() {
        return this.passwort;
    }

    @Override
    public void setPasswort(String passwort) {
        this.passwort = passwort;
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
