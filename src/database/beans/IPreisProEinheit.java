package database.beans;

public interface IPreisProEinheit {
    int getIdentifier();
    void setIdentifier(int identifier);
    int getArtikelIdentifier();
    void setArtikelIdentifier(int artikelIdentifier);
    int getGueltigVon();
    void setGueltigVon(int gueltigVon);
    int getGueltigBis();
    void setGueltigBis(int gueltigBis);
    float getPreis();
    void setPreis(float preis);
}
