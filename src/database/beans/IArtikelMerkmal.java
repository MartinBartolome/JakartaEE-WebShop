package database.beans;

public interface IArtikelMerkmal {
    int GetIdentifier();
    void SetIdentifier(int identifier);
    int GetArtikelIdentifier();
    void SetArtikelIdentifier(int ArtikelIdentifier);
    String GetSchluessel();
    void SetSchluessel(String schluessel);
    String GetWert();
    void SetWert(String wert);
}
