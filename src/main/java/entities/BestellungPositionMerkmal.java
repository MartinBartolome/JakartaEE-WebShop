package entities;

import jakarta.persistence.*;

@Entity
@Table(name="BestellungPositionMerkmal")
public class BestellungPositionMerkmal implements IBestellungPositionMerkmal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int identifier = 0;
    private int bestellungPositionIdentifier = 0;
    private int beschreibung = 0;
    private String schluessel = "";
    private String wert = "";

    @Override
    public int getIdentifier() {
        return this.identifier;
    }

    @Override
    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    @Override
    public int getBestellungPositionIdentifier() {
        return this.bestellungPositionIdentifier;
    }

    @Override
    public void setBestellungPositionIdentifier(int bestellungPositionIdentifier) {
        this.bestellungPositionIdentifier = bestellungPositionIdentifier;
    }

    @Override
    public int getBeschreibung() {
        return this.beschreibung;
    }

    @Override
    public void setBeschreibung(int beschreibung) {
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
    public void setWert(String wert) {
        this.wert = wert;
    }
}
