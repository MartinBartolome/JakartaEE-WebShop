package database.dataAcessObjects;

import java.util.ArrayList;

public interface ILagerbestand {
    ArrayList<ILagerbestand> readFuerArtikel(int identifier);
    database.beans.ILagerbestand read(int identifier);
}
