package database.dataAcessObjects;

public interface IAdresse {
    database.beans.IAdresse Read(int identifier);
    void Insert(database.beans.IAdresse adresse);
    void Update(database.beans.IAdresse adresse);
}
