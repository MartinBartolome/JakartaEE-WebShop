package database.dataAcessObjects;

import java.util.ArrayList;

public interface IGruppeMerkmalBeschreibung {
    database.beans.IGruppeMerkmalBeschreibung read(int identifier);
    ArrayList<database.beans.IGruppeMerkmalBeschreibung> read(int gruppeMerkmalIdentifier, int sprache);
}
