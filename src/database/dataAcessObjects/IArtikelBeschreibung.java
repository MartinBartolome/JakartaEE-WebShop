package database.dataAcessObjects;

public interface IArtikelBeschreibung {
    database.beans.IArtikelBeschreibung Read(int identifier);
    database.beans.IArtikelBeschreibung Read(int artikelIdentifier, int sprache);
}
