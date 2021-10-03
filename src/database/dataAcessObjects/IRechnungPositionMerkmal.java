package database.dataAcessObjects;

import java.util.ArrayList;

public interface IRechnungPositionMerkmal {
    database.beans.IRechnungPositionMerkmal read(int identifier);
    ArrayList<IRechnungPositionMerkmal> readFuerRechnungPosition(int identifier);
    void write(database.beans.IRechnungPositionMerkmal rechnungPositionMerkmal);
}
