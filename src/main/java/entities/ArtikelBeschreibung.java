package entities;

import jakarta.persistence.*;

@Entity
@Table(name="ArtikelBeschreibung")
public class ArtikelBeschreibung implements IArtikelBeschreibung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int identifier = 0;
    private int artikelIdentifier = 0;
    private int sprache = 0;
    private String beschreibung = "";

    @Override
    public int getIdentifier() {
        return this.identifier;
    }

    @Override
    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    @Override
    public int getArtikelIdentifier() {
        return this.artikelIdentifier;
    }

    @Override
    public void setArtikelIdentifier(int artikelIdentifier) {
        this.artikelIdentifier = artikelIdentifier;
    }

    @Override
    public int getSprache() {
        return this.sprache;
    }

    @Override
    public void setSprache(int sprache) {
        this.sprache = sprache;
    }

    public String getBeschreibung() {
        return this.beschreibung;
    }

    public void setBeschreibung(String text) {
        this.beschreibung = beschreibung;
    }
}
