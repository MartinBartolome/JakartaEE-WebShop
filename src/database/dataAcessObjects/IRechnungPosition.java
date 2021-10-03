package database.dataAcessObjects;

import java.util.ArrayList;

public interface IRechnungPosition {
    database.beans.IRechnungPosition read(int identifier);
    ArrayList<IRechnungPosition> readFuerRechnung(int identifier);
    void write(database.beans.IRechnungPosition rechnungPosition);
}
