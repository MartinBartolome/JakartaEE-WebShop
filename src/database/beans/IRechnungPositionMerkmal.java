package database.beans;

public interface IRechnungPositionMerkmal {
    int GetIdentifier();
    void SetIdentifier(int identifier);
    int GetRechnungPositionIdentifier();
    void SetRechnungPositionIdentifier(int rechnungPositionIdentifier);
    String GetBeschreibung();
    void SetBeschreibung(String beschreibung);
    String GetSchluessel();
    void SetSchluessel(String schluessel);
    String GetWert();
    void SetWert(String wert);
}
