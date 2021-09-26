package database.dataAcessObjects;

import java.util.ArrayList;

public interface IRechnung {
    database.beans.IRechnung Read(int identifier);
    ArrayList<database.beans.IRechnung> ReadFuerKunde(int identifier);
    void Insert(database.beans.IRechnung rechnung);
}
