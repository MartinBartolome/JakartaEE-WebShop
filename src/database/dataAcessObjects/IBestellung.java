package database.dataAcessObjects;
import java.util.ArrayList;

public interface IBestellung {
    ArrayList<database.beans.IBestellung> ReadFuerKunde(int identifier);
    database.beans.IBestellung Read(int identifier);
    void Update(database.beans.IBestellung bestellung);
    void Insert(database.beans.IBestellung bestellung);
}
