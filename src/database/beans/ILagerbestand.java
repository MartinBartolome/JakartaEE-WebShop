package database.beans;

public interface ILagerbestand {
    int GetIdentifier();
    void SetIdentifier(int identifier);
    int GetLagerIdentifier();
    void SetLagerIdentifier(int lagerIdentifier);
    int GetArtikelIdentifier();
    void SetArtikelIdentifier(int artikelIdentifier);
    float GetVerfuegbareEinheiten();
    void SetVerfuegbareEinheiten(float verfuegbareEinheiten);
}
