package database.beans;

public interface IPreisProEinheit {
    int GetIdentifier();
    void SetIdentifier(int identifier);
    int GetArtikelIdentifier();
    void SetArtikelIdentifier(int artikelIdentifier);
    int GetGueltigVon();
    void SetGueltigVon(int gueltigVon);
    int GetGueltigBis();
    void SetGueltigBis(int gueltigBis);
    float GetPreis();
    void SetPreis(float preis);
}
