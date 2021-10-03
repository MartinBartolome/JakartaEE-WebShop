package database.dataAcessObjects;

import java.util.ArrayList;

public interface IPreisProEinheit {
    database.beans.IPreisProEinheit read(int identifier);
    ArrayList<database.beans.IPreisProEinheit> readFuerArtikel(int identifier);
}
