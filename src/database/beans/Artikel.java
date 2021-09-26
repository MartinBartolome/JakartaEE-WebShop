package database.beans;

public class Artikel implements IArtikel {
    private int identifier;
    private int nummer;
    private int artikelArt;
    private int einheit;
    private int zustand;

    @Override
    public int GetIdentifier() {
        return 0;
    }

    @Override
    public void SetIdentifier(int identifier) {
        this.identifier = identifier;
    }

    @Override
    public int GetNummer() {
        return this.nummer;
    }

    @Override
    public void SetNummer(int nummer) {
        this.nummer = nummer;
    }

    @Override
    public int GetArtikelArt() {
        return this.artikelArt;
    }

    @Override
    public void SetArtikelArt(int artikelArt) {
        this.artikelArt = artikelArt;
    }

    @Override
    public int GetEinheit() {
        return this.einheit;
    }

    @Override
    public void SetEinheit(int einheit) {
        this.einheit = einheit;
    }

    @Override
    public int GetZustand() {
        return this.zustand;
    }

    @Override
    public void SetZustand(int zustand) {
        this.zustand = zustand;
    }
}
