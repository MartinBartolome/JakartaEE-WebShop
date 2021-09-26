package database.dataAcessObjects;

import java.util.ArrayList;

public interface IPreisProEinheit {
    database.beans.IPreisProEinheit Read(int identifier);
    ArrayList<database.beans.IPreisProEinheit> ReadFuerArtikel(int identifier);
}
