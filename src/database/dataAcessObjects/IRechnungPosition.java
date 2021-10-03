package database.dataAcessObjects;

import java.util.ArrayList;

public interface IRechnungPosition {
    ArrayList<database.beans.IRechnungPosition> readFuerRechnung(int identifier);
    void write(ArrayList<database.beans.IRechnungPosition> rechnungPositionen);
}
