package database.dataAcessObjects;

import database.drivers.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class ArtikelMerkmal implements IArtikelMerkmal{
    @Override
    public database.beans.IArtikelMerkmal read(int identifier) {
        database.beans.IArtikelMerkmal bean = null;
        try {
            String query = "SELECT * FROM ARTIKELMERKMAL WHERE IDENTIFIER=?";
            IParameter parameter = new ParameterTypeInt(0, identifier);
            IDriver driver = Factory.create();
            assert driver != null;
            IQueryResultsHandle handle = driver.runQuery(query, parameter);
            handle.getReader().next();
            bean = new database.beans.ArtikelMerkmal();
            bean.setIdentifier(handle.getReader().getInt(0));
            bean.setArtikelIdentifier(handle.getReader().getInt(1));
            bean.setSchluessel(handle.getReader().getString(2));
            bean.setWert(handle.getReader().getString(3));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bean;
    }

    @Override
    public ArrayList<database.beans.IArtikelMerkmal> readFuerArtikel(int identifier) {
        ArrayList<database.beans.IArtikelMerkmal> beans = new ArrayList<>();
        try {
            String query = "SELECT * FROM ARTIKELMERKMAL WHERE ARTIKELIDENTIFIER=?";
            IParameter parameter = new ParameterTypeInt(0, identifier);
            IDriver driver = Factory.create();
            assert driver != null;
            IQueryResultsHandle handle = driver.runQuery(query, parameter);
            while (handle.getReader().next()) {
                database.beans.IArtikelMerkmal bean = new database.beans.ArtikelMerkmal();
                bean.setIdentifier(handle.getReader().getInt(0));
                bean.setArtikelIdentifier(handle.getReader().getInt(1));
                bean.setSchluessel(handle.getReader().getString(2));
                bean.setWert(handle.getReader().getString(3));
                beans.add(bean);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return beans;
    }
}
