package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="RechnungPositionMerkmal")
public class RechnungPositionMerkmal implements IRechnungPositionMerkmal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int identifier = 0;
    private int rechnungPositionIdentifier = 0;
    private String beschreibung = "";
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
