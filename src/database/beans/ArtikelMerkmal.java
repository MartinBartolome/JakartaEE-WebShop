package database.beans;

public class ArtikelMerkmal implements IArtikelMerkmal {
    private int identifier;
    private int artikelIdentifier;
    private String schluessel;
    private String wert;

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
    public String GetSchluessel() {
        return this.schluessel;
    }

    @Override
    public void SetSchluessel(String schluessel) {
        this.schluessel = schluessel;
    }

    @Override
    public String GetWert() {
        return this.wert;
    }

    @Override
    public void SetWert(String wert) {
        this.wert = wert;
    }
}
