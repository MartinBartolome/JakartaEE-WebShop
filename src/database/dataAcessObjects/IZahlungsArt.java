package database.dataAcessObjects;

public interface IZahlungsArt {
    database.beans.IZahlungsArt read(int identifier);
    void overwrite(database.beans.IZahlungsArt zahlungsArt);
}
