package database.dataAcessObjects;

import java.util.ArrayList;

public interface IRechnungPositionMerkmal {
    database.beans.IRechnungPositionMerkmal Read(int identifier);
    ArrayList<IRechnungPositionMerkmal> ReadFuerRechnungPosition(int identifier);
    void Insert(database.beans.IRechnungPositionMerkmal rechnungPositionMerkmal);
}
