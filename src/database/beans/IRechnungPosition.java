package database.beans;

public interface IRechnungPosition {
    int GetIdentifier();
    void SetIdentifier(int identifier);
    int GetRechnungIdentifier();
    void SetRechnungIdentifier(int rechnungIdentifier);
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
