package database.dataAcessObjects;

import java.util.ArrayList;

public interface IArtikelMerkmalBeschreibung {
    database.beans.IArtikelMerkmalBeschreibung read(int identifier);
    database.beans.IArtikelMerkmalBeschreibung read(int artikelMerkmalIdentifier, int sprache);
}
