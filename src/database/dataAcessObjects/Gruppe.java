package database.dataAcessObjects;

import database.drivers.*;

import java.sql.SQLException;

public class Gruppe implements IGruppe {
    @Override
    public database.beans.IGruppe read(int identifier) {
        database.beans.IGruppe bean = null;
        try {
            String query = "SELECT * FROM GRUPPE WHERE IDENTIFIER=?";
            IParameter parameter = new ParameterTypeInt(0, identifier);
            IDriver driver = Factory.create();
            IQueryResultsHandle handle = driver.runQuery(query, parameter);
            handle.getReader().next();
            bean = new database.beans.Gruppe();
            bean.setIdentifier(handle.getReader().getInt(0));
            bean.setKommentar(handle.getReader().getString(1));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bean;
    }
}
