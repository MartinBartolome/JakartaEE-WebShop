package database.beans;

public class ArtikelMerkmalBeschreibung implements IArtikelMerkmalBeschreibung {
    private int identifier;
    private int artikelMerkmalIdentifier;
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
}
