package database.dataAcessObjects;

import java.util.ArrayList;

public interface ILagerbestand {
    database.beans.ILagerbestand readFuerArtikel(int identifier);
    database.beans.ILagerbestand read(int identifier);
}
