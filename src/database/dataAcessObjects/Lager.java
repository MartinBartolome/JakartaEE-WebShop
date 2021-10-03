package database.dataAcessObjects;

import database.drivers.*;
import java.sql.SQLException;

public class Lager implements ILager {
    @Override
    public database.beans.ILager read(int identifier) {
        database.beans.ILager bean = null;
        try {
            String query = "SELECT * FROM LAGER WHERE IDENTIFIER=?";
            IParameter parameter = new ParameterTypeInt(0, identifier);
            IDriver driver = Factory.create();
            assert driver != null;
            IQueryResultsHandle handle = driver.runQuery(query, parameter);
            handle.getReader().next();
            bean = new database.beans.Lager();
            bean.setIdentifier(handle.getReader().getInt(0));
            bean.setBeschreibung(handle.getReader().getString(1));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bean;
    }
}
