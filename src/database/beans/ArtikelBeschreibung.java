package database.beans;

public class ArtikelBeschreibung implements IArtikelBeschreibung {
    private int identifier;
    private int artikelIdentifier;
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
    public int GetArtikelIdentifier() {
        return this.artikelIdentifier;
    }

    @Override
    public void SetArtikelIdentifier(int artikelIdentifier) {
        this.artikelIdentifier = artikelIdentifier;
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
