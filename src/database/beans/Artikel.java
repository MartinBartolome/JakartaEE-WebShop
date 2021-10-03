package database.beans;

public class Artikel implements IArtikel {
    private int identifier;
    private int nummer;
    private int artikelArt;
    private int einheit;
    private int zustand;

    @Override
    public int getIdentifier() {
        return 0;
    }

    @Override
    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    @Override
    public int getNummer() {
        return this.nummer;
    }

    @Override
    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    @Override
    public int getArtikelArt() {
        return this.artikelArt;
    }

    @Override
    public void setArtikelArt(int artikelArt) {
        this.artikelArt = artikelArt;
    }

    @Override
    public int getEinheit() {
        return this.einheit;
    }

    @Override
    public void setEinheit(int einheit) {
        this.einheit = einheit;
    }

    @Override
    public int getZustand() {
        return this.zustand;
    }

    @Override
    public void setZustand(int zustand) {
        this.zustand = zustand;
    }
}
