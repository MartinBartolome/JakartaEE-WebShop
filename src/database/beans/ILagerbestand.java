package database.beans;

public interface ILagerbestand {
    int getIdentifier();
    void setIdentifier(int identifier);
    int getLagerIdentifier();
    void setLagerIdentifier(int lagerIdentifier);
    int getArtikelIdentifier();
    void setArtikelIdentifier(int artikelIdentifier);
    float getVerfuegbareEinheiten();
    void setVerfuegbareEinheiten(float verfuegbareEinheiten);
}
