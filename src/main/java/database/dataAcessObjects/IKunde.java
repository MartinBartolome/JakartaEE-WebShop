package database.dataAcessObjects;

public interface IKunde {
    database.beans.IKunde read(int identifier);
    database.beans.IKunde read(String eMailAdresse);
    void overwrite(database.beans.IKunde kunde);
    long write(database.beans.IKunde kunde);
}
