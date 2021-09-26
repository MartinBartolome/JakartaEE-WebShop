package database.dataAcessObjects;

import java.util.ArrayList;

public interface IArtikelMerkmal {
    database.beans.IArtikelMerkmal Read(int identifier);
    ArrayList<database.beans.IArtikelMerkmal> ReadFuerArtikel(int identifier);
}
