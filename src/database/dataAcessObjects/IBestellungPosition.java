package database.dataAcessObjects;

import java.util.ArrayList;

public interface IBestellungPosition {
    ArrayList<IBestellungPosition> ReadFuerBestellung(int identifier);
    database.beans.IBestellungPosition Read(int identifier);
    void Update(database.beans.IBestellungPosition bestellung);
    void Insert(database.beans.IBestellungPosition bestellung);
}
