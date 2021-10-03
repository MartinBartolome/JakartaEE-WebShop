package database.dataAcessObjects;
import java.util.ArrayList;

public interface IBestellung {
    ArrayList<database.beans.IBestellung> readFuerKunde(int identifier);
    database.beans.IBestellung read(int identifier);
    void overwrite(database.beans.IBestellung bestellung);
    long write(database.beans.IBestellung bestellung);
}
