package database.dataAcessObjects;
import java.util.ArrayList;

public interface IArtikel {
    ArrayList<database.beans.IArtikel> ReadFuerArtikelArt(int identifier);
    database.beans.IArtikel Read(int identifier);
}
