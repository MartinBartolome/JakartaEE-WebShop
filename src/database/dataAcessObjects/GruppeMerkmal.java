package database.dataAcessObjects;

import java.util.ArrayList;

public class GruppeMerkmal implements IGruppeMerkmal {
    @Override
    public ArrayList<database.beans.IGruppeMerkmal> readFuerGruppe(int gruppeIdentifier) {
        ArrayList<database.beans.IGruppeMerkmal> beans = null;
        beans = new ArrayList<database.beans.IGruppeMerkmal>();
        String query = "SELECT * FROM GRUPPEMERKMAL WHERE GRUPPEIDENTIFIER=@gruppeIdentifier";
        //String parameter = "@gruppeIdentifier";
        // Sql prepare
        // sql execute
        //bean.SetIdentifier(identifier);
        //bean.SetKommentar();
        // while {
            IGruppeMerkmal bean = new GruppeMerkmal();
        // }
        return beans;
    }

    @Override
    public database.beans.IGruppeMerkmal read(int identifier) {
        database.beans.IGruppeMerkmal bean = null;
        try {
            bean = new database.beans.GruppeMerkmal();
            String query = "SELECT * FROM GRUPPEMERKMAL WHERE IDENTIFIER=@identifier";
            //String parameter = "@Identifier";
            // Sql prepare
            // sql execute
            //bean.SetIdentifier(identifier);
            //bean.SetKommentar();
        }
        finally {
        }
        return bean;
    }
}
