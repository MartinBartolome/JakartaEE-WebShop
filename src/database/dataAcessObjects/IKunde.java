package database.dataAcessObjects;

public interface IKunde {
    database.beans.IKunde Read(int identifier);
    database.beans.IKunde Read(String eMailAdresse);
    void Update(database.beans.IKunde kunde);
    void Insert(database.beans.IKunde kunde);
}
