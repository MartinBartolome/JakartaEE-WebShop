package database.dataAcessObjects;

import java.util.ArrayList;

public interface IRechnungPosition {
    database.beans.IRechnungPosition Read(int identifier);
    ArrayList<IRechnungPosition> ReadFuerRechnung(int identifier);
    void Insert(database.beans.IRechnungPosition rechnungPosition);
}
