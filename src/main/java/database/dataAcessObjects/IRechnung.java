package database.dataAcessObjects;

import java.util.ArrayList;

public interface IRechnung {
    database.beans.IRechnung read(int identifier);
    ArrayList<database.beans.IRechnung> readFuerKunde(int identifier);
    long write(database.beans.IRechnung rechnung);
}
