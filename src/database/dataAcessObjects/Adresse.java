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
            IQueryResultsHandle handle = driver.runQuery(query.toString(), parameter);
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
    public void write(database.beans.IAdresse adresse) {
        try {
            String query = "INSERT INTO ADRESSE VALUES(?,?,?,?)";
            IParameter[] parameters = {
                new ParameterTypeInt(0, adresse.getKundeIdentifier()),
                new ParameterTypeString(0, adresse.getStrasse()),
                new ParameterTypeString(0, adresse.getPostleitzahl()),
                new ParameterTypeString(0, adresse.getOrt())
            };
            IDriver driver = Factory.create();
            driver.runStatement(query.toString(), parameters);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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
                new ParameterTypeString(0, adresse.getPostleitzahl()),
                new ParameterTypeString(0, adresse.getOrt()),
                new ParameterTypeInt(0, adresse.getIdentifier())
            };
            IDriver driver = Factory.create();
            driver.runStatement(statement.toString(), parameters);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
