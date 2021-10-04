package database.beans;

public interface IArtikel {
    int getIdentifier();
    void setIdentifier(int identifier);
    int getNummer();
    void setNummer(int nummer);
    int getArtikelArt();
    void setArtikelArt(int artikelArt);
    int getEinheit();
    void setEinheit(int einheit);
    int getZustand();
    void setZustand(int zustand);
}
