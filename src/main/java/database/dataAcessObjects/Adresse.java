package database.dataAcessObjects;

import database.drivers.*;

import java.sql.SQLException;

public class Adresse implements IAdresse {
    @Override
    public database.beans.IAdresse read(int identifier) {
        database.beans.IAdresse bean = new database.beans.Adresse();
        try {
            String query = "SELECT * FROM ADRESSE WHERE IDENTIFIER=?";
            IParameter parameter = new ParameterTypeInt(0, identifier);
            IDriver driver = Factory.create();
            assert driver != null;
            IQueryResultsHandle handle = driver.runQuery(query, parameter);
            handle.getReader().next();
            bean = new database.beans.Adresse();
            bean.setIdentifier(handle.getReader().getInt(0));
            bean.setKundeIdentifier(handle.getReader().getInt(1));
            bean.setStrasse(handle.getReader().getString(2));
            bean.setPostleitzahl(handle.getReader().getString(3));
            bean.setOrt(handle.getReader().getString(4));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bean;
    }

    @Override
    public long write(database.beans.IAdresse adresse) {
        try {
            String query = "INSERT INTO ADRESSE VALUES(?,?,?,?)";
            IParameter[] parameters = {
                new ParameterTypeInt(0, adresse.getKundeIdentifier()),
                new ParameterTypeString(1, adresse.getStrasse()),
                new ParameterTypeString(2, adresse.getPostleitzahl()),
                new ParameterTypeString(3, adresse.getOrt())
            };
            IDriver driver = Factory.create();
            assert driver != null;
            return driver.runInsert(query, parameters);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
   }

    @Override
    public void overwrite(database.beans.IAdresse adresse) {
        try {
            StringBuilder statement = new StringBuilder();
            statement.append("UPDATE ADRESSE SET ");
            statement.append("STRASSE=?,");
            statement.append("POSTLEITZAHL=?,");
            statement.append("ORT=? ");
            statement.append("WHERE IDENTIFIER=?");
            IParameter[] parameters = {
                new ParameterTypeString(0, adresse.getStrasse()),
                new ParameterTypeString(1, adresse.getPostleitzahl()),
                new ParameterTypeString(2, adresse.getOrt()),
                new ParameterTypeInt(3, adresse.getIdentifier())
            };
            IDriver driver = Factory.create();
            assert driver != null;
            driver.runStatement(statement.toString(), parameters);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
