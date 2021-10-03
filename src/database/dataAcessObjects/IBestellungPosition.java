package database.dataAcessObjects;

import java.util.ArrayList;

public interface IBestellungPosition {
    ArrayList<database.beans.IBestellungPosition> readFuerBestellung(int identifier);
    void write(ArrayList<database.beans.IBestellungPosition> bestellungPositionen);
}
