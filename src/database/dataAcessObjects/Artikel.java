package database.dataAcessObjects;

import database.drivers.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class Artikel implements IArtikel {
    @Override
    public ArrayList<database.beans.IArtikel> readFuerArtikelArt(int identifier) {
        ArrayList<database.beans.IArtikel> beans = new ArrayList<>();
        try {
            String query = "SELECT * FROM ARTIKEL WHERE ARTIKELART=?";
            IParameter parameter = new ParameterTypeInt(0, identifier);
            IDriver driver = Factory.create();
            assert driver != null;
            IQueryResultsHandle handle = driver.runQuery(query, parameter);
            while (handle.getReader().next()) {
                database.beans.IArtikel bean = new database.beans.Artikel();
                bean.setIdentifier(handle.getReader().getInt(0));
                bean.setNummer(handle.getReader().getInt(1));
                bean.setArtikelArt(handle.getReader().getInt(2));
                bean.setEinheit(handle.getReader().getInt(3));
                bean.setZustand(handle.getReader().getInt(4));
                beans.add(bean);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return beans;
    }

    @Override
    public database.beans.IArtikel read(int identifier) {
        database.beans.Artikel bean = null;
        try {
            String query = "SELECT * FROM ARTIKEL WHERE IDENTIFIER=?";
            IParameter parameter = new ParameterTypeInt(0, identifier);
            IDriver driver = Factory.create();
            assert driver != null;
            IQueryResultsHandle handle = driver.runQuery(query, parameter);
            handle.getReader().next();
            bean = new database.beans.Artikel();
            bean.setIdentifier(handle.getReader().getInt(0));
            bean.setNummer(handle.getReader().getInt(1));
            bean.setArtikelArt(handle.getReader().getInt(2));
            bean.setEinheit(handle.getReader().getInt(3));
            bean.setZustand(handle.getReader().getInt(4));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bean;
    }
}
