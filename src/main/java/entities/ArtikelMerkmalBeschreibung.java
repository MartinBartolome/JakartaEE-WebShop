package entities;

import jakarta.persistence.*;

@Entity
@Table(name="ArtikelMerkmalBeschreibung")
public class ArtikelMerkmalBeschreibung implements IArtikelMerkmalBeschreibung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int identifier = 0;
    private int artikelMerkmalIdentifier = 0;
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
    public int getArtikelMerkmalIdentifier() {
        return this.artikelMerkmalIdentifier;
    }

    @Override
    public void setArtikelMerkmalIdentifier(int artikelMerkmalIdentifier) {
        this.artikelMerkmalIdentifier = artikelMerkmalIdentifier;
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
