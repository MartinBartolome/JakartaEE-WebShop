package database.dataAcessObjects;

import database.drivers.*;

import java.sql.SQLException;

public class ArtikelMerkmalBeschreibung implements IArtikelMerkmalBeschreibung {
    @Override
    public database.beans.IArtikelMerkmalBeschreibung read(int identifier) {
        database.beans.IArtikelMerkmalBeschreibung bean = null;
        try {
            String query = "SELECT * FROM ARTIKELMERKMALBESCHREIBUNG WHERE IDENTIFIER=?";
            IParameter parameter = new ParameterTypeInt(0, identifier);
            IDriver driver = Factory.create();
            assert driver != null;
            IQueryResultsHandle handle = driver.runQuery(query, parameter);
            handle.getReader().next();
            bean = new database.beans.ArtikelMerkmalBeschreibung();
            bean.setIdentifier(handle.getReader().getInt(0));
            bean.setArtikelMerkmalIdentifier(handle.getReader().getInt(1));
            bean.setSprache(handle.getReader().getInt(2));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bean;
    }

    @Override
    public database.beans.IArtikelMerkmalBeschreibung read(int artikelMerkmalIdentifier, int sprache) {
        database.beans.IArtikelMerkmalBeschreibung bean = null;
        try {
            String query = "SELECT * FROM ARTIKELMERKMALBESCHREIBUNG WHERE ARTIKELMERKMALIDENTIFIER=? AND SPRACHE=?";
            IParameter[] parameters = {
                new ParameterTypeInt(0, artikelMerkmalIdentifier),
                new ParameterTypeInt(1, sprache),
            };
            IDriver driver = Factory.create();
            assert driver != null;
            IQueryResultsHandle handle = driver.runQuery(query, parameters);
            handle.getReader().next();
            bean = new database.beans.ArtikelMerkmalBeschreibung();
            bean.setIdentifier(handle.getReader().getInt(0));
            bean.setArtikelMerkmalIdentifier(handle.getReader().getInt(1));
            bean.setSprache(handle.getReader().getInt(2));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
