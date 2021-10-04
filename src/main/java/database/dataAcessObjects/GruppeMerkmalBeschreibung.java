package database.dataAcessObjects;

import database.drivers.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class GruppeMerkmalBeschreibung implements IGruppeMerkmalBeschreibung {
    @Override
    public database.beans.IGruppeMerkmalBeschreibung read(int identifier) {
        database.beans.IGruppeMerkmalBeschreibung bean = null;
        try {
            String query = "SELECT * FROM GRUPPEMERKMALBESCHREIBUNG WHERE IDENTIFIER=?";
            IParameter parameter = new ParameterTypeInt(0, identifier);
            IDriver driver = Factory.create();
            assert driver != null;
            IQueryResultsHandle handle = driver.runQuery(query, parameter);
            handle.getReader().next();
            bean = new database.beans.GruppeMerkmalBeschreibung();
            bean.setIdentifier(handle.getReader().getInt(0));
            bean.setGruppeMerkmalIdentifier(handle.getReader().getInt(1));
            bean.setSprache(handle.getReader().getInt(2));
            bean.setText(handle.getReader().getString(3));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bean;
    }

    @Override
    public ArrayList<database.beans.IGruppeMerkmalBeschreibung> read(int gruppeMerkmalIdentifier, int sprache) {
        ArrayList<database.beans.IGruppeMerkmalBeschreibung> beans = new ArrayList<>();
        try {
            String query = "SELECT * FROM GRUPPEMERKMALBESCHREIBUNG WHERE GRUPPEMERKMALIDENTIFIER=? AND SPRACHE=?";
            IParameter[] parameters = {
                new ParameterTypeInt(0, gruppeMerkmalIdentifier),
                new ParameterTypeInt(1, sprache),
            };
            IDriver driver = Factory.create();
            assert driver != null;
            IQueryResultsHandle handle = driver.runQuery(query, parameters);
            while (handle.getReader().next()) {
                database.beans.IGruppeMerkmalBeschreibung bean = new database.beans.GruppeMerkmalBeschreibung();
                bean.setIdentifier(handle.getReader().getInt(0));
                bean.setGruppeMerkmalIdentifier(handle.getReader().getInt(1));
                bean.setSprache(handle.getReader().getInt(2));
                bean.setText(handle.getReader().getString(3));
                beans.add(bean);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return beans;
    }
}
