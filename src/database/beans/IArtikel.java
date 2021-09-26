package database.beans;

public interface IArtikel {
    int GetIdentifier();
    void SetIdentifier(int identifier);
    int GetNummer();
    void SetNummer(int nummer);
    int GetArtikelArt();
    void SetArtikelArt(int artikelArt);
    int GetEinheit();
    void SetEinheit(int einheit);
    int GetZustand();
    void SetZustand(int zustand);
}
