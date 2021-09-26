package database.dataAcessObjects;

import java.util.ArrayList;

public interface ILagerbestand {
    ArrayList<ILagerbestand> ReadFuerArtikel(int identifier);
    database.beans.ILagerbestand Read(int identifier);
}
