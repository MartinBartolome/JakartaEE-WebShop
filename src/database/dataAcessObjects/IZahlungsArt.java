package database.dataAcessObjects;

public interface IZahlungsArt {
    database.beans.IZahlungsArt readFuerKunde(int identifier);
    void overwrite(database.beans.IZahlungsArt zahlungsArt);
}
