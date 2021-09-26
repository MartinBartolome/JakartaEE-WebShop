package database.beans;

public interface IBestellungPosition {
    int GetIdentifier();
    void SetIdentifier(int identifier);
    int GetBestellungIdentifier();
    void SetBestellungIdentifier(int bestellungIdentifier);
    int GetArtikelIdentifier();
    void SetArtikelIdentifier(int artikelIdentifier);
    int GetBeschreibung();
    void SetBeschreibung(int beschreibung);
    int GetArtikelNummer();
    void SetArtikelNummer(int artikelNummer);
    int GetReihenfolge();
    void SetReihenfolge(int reihenfolge);
    int GetAnzahlEinheiten();
    void SetAnzahlEinheiten(int anzahlEinheiten);
    int GetPreisProEinheit();
    void SetPreisProEinheit(int preisProEinheit);
}
