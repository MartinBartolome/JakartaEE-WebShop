package entities;

import jakarta.persistence.*;
import jakarta.persistence.Entity;

@Entity
@Table(name="Adresse")
public class Adresse implements IAdresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int identifier = 0;
    private int kundeIdentifier = 0;
    private String strasse = "";
    private String postleitzahl = "";
    private String ort = "";

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
