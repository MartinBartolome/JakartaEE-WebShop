package database.dataAcessObjects;

import java.util.ArrayList;

public interface IGruppeMerkmal {
    ArrayList<database.beans.IGruppeMerkmal> readFuerGruppe(int gruppeIdentifier);
    database.beans.IGruppeMerkmal read(int identifier);
}
