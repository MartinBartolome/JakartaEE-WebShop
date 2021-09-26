package database.dataAcessObjects;

import java.util.ArrayList;

public interface IGruppeMerkmalBeschreibung {
    database.beans.IGruppeMerkmalBeschreibung Read(int identifier);
    ArrayList<database.beans.IGruppeMerkmalBeschreibung> Read(int gruppeMerkmalIdentifier, int sprache);
}
