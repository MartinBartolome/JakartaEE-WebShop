package database.beans;

public class ArtikelMerkmalBeschreibung implements IArtikelMerkmalBeschreibung {
    private int identifier;
    private int artikelMerkmalIdentifier;
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
    public int GetArtikelMerkmalIdentifier() {
        return this.artikelMerkmalIdentifier;
    }

    @Override
    public void SetArtikelMerkmalIdentifier(int artikelMerkmalIdentifier) {
        this.artikelMerkmalIdentifier = artikelMerkmalIdentifier;
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
