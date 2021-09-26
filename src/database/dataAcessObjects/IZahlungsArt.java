package database.dataAcessObjects;

public interface IZahlungsArt {
    database.beans.IZahlungsArt Read(int identifier);
    void Update(database.beans.IZahlungsArt zahlungsArt);
}
