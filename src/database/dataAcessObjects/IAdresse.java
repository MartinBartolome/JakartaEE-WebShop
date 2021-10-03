package database.dataAcessObjects;

public interface IAdresse {
    database.beans.IAdresse read(int identifier);
    void write(database.beans.IAdresse adresse);
    void overwrite(database.beans.IAdresse adresse);
}
