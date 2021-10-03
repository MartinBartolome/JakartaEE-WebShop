package database.dataAcessObjects;

import java.util.ArrayList;

public interface IBestellungPosition {
    ArrayList<IBestellungPosition> readFuerBestellung(int identifier);
    database.beans.IBestellungPosition read(int identifier);
    void overwrite(database.beans.IBestellungPosition bestellung);
    void write(database.beans.IBestellungPosition bestellung);
}
