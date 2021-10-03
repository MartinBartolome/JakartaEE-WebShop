package database.dataAcessObjects;

public interface IArtikelBeschreibung {
    database.beans.IArtikelBeschreibung read(int identifier);
    database.beans.IArtikelBeschreibung read(int artikelIdentifier, int sprache);
}
