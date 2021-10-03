package database.dataAcessObjects;

import database.drivers.*;

import java.sql.SQLException;

public class Kunde implements IKunde {
    @Override
    public database.beans.IKunde read(int identifier) {
        return null;
    }

    @Override
    public database.beans.IKunde read(String eMailAdresse) {
        return null;
    }

    @Override
    public void overwrite(database.beans.IKunde kunde) {

    }

    @Override
    public long write(database.beans.IKunde kunde) {
        try {
            String statement = "INSERT INTO KUNDE VALUES(?,?,?,?,?,?,?)";
            IParameter[] parameters = {
                new ParameterTypeInt(0, kunde.getNummer()),
                new ParameterTypeString(1, kunde.getName()),
                new ParameterTypeString(2, kunde.getVorname()),
                new ParameterTypeString(3, kunde.getTelefonNummer()),
                new ParameterTypeString(4, kunde.getEMailAdresse()),
                new ParameterTypeInt(5, kunde.getZustand()),
                new ParameterTypeInt(6, kunde.getSprache())
            };
            IDriver driver = Factory.create();
            assert driver != null;
            return driver.runInsert(statement, parameters);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}
