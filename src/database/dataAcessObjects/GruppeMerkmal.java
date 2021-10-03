package database.dataAcessObjects;

import database.drivers.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class GruppeMerkmal implements IGruppeMerkmal {
    @Override
    public ArrayList<database.beans.IGruppeMerkmal> readFuerGruppe(int gruppeIdentifier) {
        ArrayList<database.beans.IGruppeMerkmal> beans = new ArrayList<>();
        try {
            String query = "SELECT * FROM GRUPPEMERKMAL WHERE GRUPPEIDENTIFIER=?";
            IParameter parameter = new ParameterTypeInt(0, gruppeIdentifier);
            IDriver driver = Factory.create();
            assert driver != null;
            IQueryResultsHandle handle = driver.runQuery(query, parameter);
            while (handle.getReader().next()) {
                database.beans.IGruppeMerkmal bean = new database.beans.GruppeMerkmal();
                bean.setIdentifier(handle.getReader().getInt(0));
                bean.setGruppeIdentifier(handle.getReader().getInt(1));
                bean.setSchluessel(handle.getReader().getString(2));
                bean.setWert(handle.getReader().getString(3));
                beans.add(bean);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return beans;
    }

    @Override
    public database.beans.IGruppeMerkmal read(int identifier) {
        database.beans.IGruppeMerkmal bean = null;
        try {
            String query = "SELECT * FROM GRUPPEMERKMAL WHERE IDENTIFIER=?";
            IParameter parameter = new ParameterTypeInt(0, identifier);
            IDriver driver = Factory.create();
            assert driver != null;
            IQueryResultsHandle handle = driver.runQuery(query, parameter);
            handle.getReader().next();
            bean = new database.beans.GruppeMerkmal();
            bean.setIdentifier(handle.getReader().getInt(0));
            bean.setGruppeIdentifier(handle.getReader().getInt(1));
            bean.setSchluessel(handle.getReader().getString(2));
            bean.setWert(handle.getReader().getString(3));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bean;
    }
}
