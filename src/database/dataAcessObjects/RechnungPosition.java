package database.dataAcessObjects;

import java.util.ArrayList;

public class RechnungPosition implements IRechnungPosition {
    @Override
    public database.beans.IRechnungPosition Read(int identifier) {
        return null;
    }

    @Override
    public ArrayList<IRechnungPosition> ReadFuerRechnung(int identifier) {
        return null;
    }

    @Override
    public void Insert(database.beans.IRechnungPosition rechnungPosition) {

    }
}
