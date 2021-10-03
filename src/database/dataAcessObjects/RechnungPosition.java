package database.dataAcessObjects;

import java.util.ArrayList;

public class RechnungPosition implements IRechnungPosition {
    @Override
    public database.beans.IRechnungPosition read(int identifier) {
        return null;
    }

    @Override
    public ArrayList<IRechnungPosition> readFuerRechnung(int identifier) {
        return null;
    }

    @Override
    public void write(database.beans.IRechnungPosition rechnungPosition) {

    }
}
