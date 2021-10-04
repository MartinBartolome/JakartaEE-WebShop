package database.dataAcessObjects;
import java.util.ArrayList;

public interface IArtikel {
    ArrayList<database.beans.IArtikel> readFuerArtikelArt(int identifier);
    database.beans.IArtikel read(int identifier);
}
