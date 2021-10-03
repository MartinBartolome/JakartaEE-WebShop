package database.dataAcessObjects;

import java.util.ArrayList;

public interface IArtikelMerkmal {
    database.beans.IArtikelMerkmal read(int identifier);
    ArrayList<database.beans.IArtikelMerkmal> readFuerArtikel(int identifier);
}
