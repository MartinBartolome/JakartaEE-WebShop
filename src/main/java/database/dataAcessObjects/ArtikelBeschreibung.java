package database.dataAcessObjects;

import database.drivers.*;

import java.sql.SQLException;

public class ArtikelBeschreibung implements IArtikelBeschreibung {
    @Override
    public database.beans.IArtikelBeschreibung read(int identifier) {
        database.beans.IArtikelBeschreibung bean = null;
        try {
            String query = "SELECT * FROM ARTIKELBESCHREIBUNG WHERE IDENTIFIER=?";
            IParameter parameter = new ParameterTypeInt(0, identifier);
            IDriver driver = Factory.create();
            assert driver != null;
            IQueryResultsHandle handle = driver.runQuery(query, parameter);
            handle.getReader().next();
            bean = new database.beans.ArtikelBeschreibung();
            bean.setIdentifier(handle.getReader().getInt(0));
            bean.setArtikelIdentifier(handle.getReader().getInt(1));
            bean.setSprache(handle.getReader().getInt(2));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bean;
    }

    @Override
    public database.beans.IArtikelBeschreibung read(int artikelIdentifier, int sprache) {
        database.beans.IArtikelBeschreibung bean = null;
        try {
            String query = "SELECT * FROM ARTIKELBESCHREIBUNG WHERE ARTIKELIDENTIFIER=? AND SPRACHE=?";
            IParameter[] parameters = {
                new ParameterTypeInt(0, artikelIdentifier),
                new ParameterTypeInt(1, sprache),
            };
            IDriver driver = Factory.create();
            assert driver != null;
            IQueryResultsHandle handle = driver.runQuery(query, parameters);
            handle.getReader().next();
            bean = new database.beans.ArtikelBeschreibung();
            bean.setIdentifier(handle.getReader().getInt(0));
            bean.setArtikelIdentifier(handle.getReader().getInt(1));
            bean.setSprache(handle.getReader().getInt(2));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bean;
    }
}
