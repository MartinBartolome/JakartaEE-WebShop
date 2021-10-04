package database.dataAcessObjects;

import database.drivers.*;
import java.sql.SQLException;

public class PreisProEinheit implements IPreisProEinheit {
    @Override
    public database.beans.IPreisProEinheit readFuerArtikel(int identifier) {
        database.beans.IPreisProEinheit bean = null;
        try {
            String query = "SELECT * FROM PREISFOREINHEIT WHERE ARTIKEL_IDENTIFIER=?";
            IParameter parameter = new ParameterTypeInt(0, identifier);
            IDriver driver = Factory.create();
            assert driver != null;
            IQueryResultsHandle handle = driver.runQuery(query, parameter);
            handle.getReader().next();
            bean = new database.beans.PreisProEinheit();
            bean.setIdentifier(handle.getReader().getInt(0));
            bean.setArtikelIdentifier(handle.getReader().getInt(1));
            bean.setGueltigVon(handle.getReader().getInt(2));
            bean.setGueltigBis(handle.getReader().getInt(3));
            bean.setPreis(handle.getReader().getFloat(4));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bean;
    }
}
