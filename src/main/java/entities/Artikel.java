package entities;

import jakarta.persistence.*;

@Entity
@Table(name="Artikel")
public class Artikel implements IArtikel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int identifier = 0;
    private int nummer = 0;
    private int artikelArt = 0;
    private int einheit = 0;
    private int zustand = 0;
    private int konfigurator = 0;

    @Override
    public int getIdentifier() {
        return this.identifier;
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

    @Override
    public int getKonfigurator() {
        return this.konfigurator;
    }

    @Override
    public void setKonfigurator(int konfigurator) {
        this.konfigurator = konfigurator;
    }
}
