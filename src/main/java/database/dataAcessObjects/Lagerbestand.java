package database.dataAcessObjects;

import database.drivers.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class Lagerbestand implements ILagerbestand {
    @Override
    public database.beans.ILagerbestand readFuerArtikel(int identifier) {
        database.beans.ILagerbestand bean = null;
        try {
            String query = "SELECT * FROM LAGERBESTAND WHERE ARTIKEL_IDENTIFIER=?";
            IParameter parameter = new ParameterTypeInt(0, identifier);
            IDriver driver = Factory.create();
            assert driver != null;
            IQueryResultsHandle handle = driver.runQuery(query, parameter);
            handle.getReader().next();
            bean = new database.beans.Lagerbestand();
            bean.setIdentifier(handle.getReader().getInt(0));
            bean.setArtikelIdentifier(handle.getReader().getInt(1));
            bean.setLagerIdentifier(handle.getReader().getInt(2));
            bean.setVerfuegbareEinheiten(handle.getReader().getFloat(3));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bean;
    }

    @Override
    public database.beans.ILagerbestand read(int identifier) {
        database.beans.ILagerbestand bean = null;
        try {
            String query = "SELECT * FROM LAGERBESTAND WHERE IDENTIFIER=?";
            IParameter parameter = new ParameterTypeInt(0, identifier);
            IDriver driver = Factory.create();
            assert driver != null;
            IQueryResultsHandle handle = driver.runQuery(query, parameter);
            handle.getReader().next();
            bean = new database.beans.Lagerbestand();
            bean.setIdentifier(handle.getReader().getInt(0));
            bean.setArtikelIdentifier(handle.getReader().getInt(1));
            bean.setLagerIdentifier(handle.getReader().getInt(2));
            bean.setVerfuegbareEinheiten(handle.getReader().getFloat(3));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bean;
    }
}
