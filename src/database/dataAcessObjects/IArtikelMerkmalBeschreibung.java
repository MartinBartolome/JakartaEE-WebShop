package database.dataAcessObjects;

import java.util.ArrayList;

public interface IArtikelMerkmalBeschreibung {
    database.beans.IArtikelMerkmalBeschreibung Read(int identifier);
    database.beans.IArtikelMerkmalBeschreibung Read(int artikelMerkmalIdentifier, int sprache);
}
