package database.dataAcessObjects;

import java.util.ArrayList;

public class Rechnung implements IRechnung {
    @Override
    public database.beans.IRechnung read(int identifier) {
        return null;
    }

    @Override
    public ArrayList<database.beans.IRechnung> readFuerKunde(int identifier) {
        return null;
    }

    @Override
    public void write(database.beans.IRechnung rechnung) {

    }
}
