package database.dataAcessObjects;

import database.drivers.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class Rechnung implements IRechnung {
    @Override
    public database.beans.IRechnung read(int identifier) {
        database.beans.IRechnung bean = null;
        try {
            String query = "SELECT * FROM RECHNUNG WHERE IDENTIFIER=?";
            IParameter parameter = new ParameterTypeInt(0, identifier);
            IDriver driver = Factory.create();
            assert driver != null;
            IQueryResultsHandle handle = driver.runQuery(query, parameter);
            handle.getReader().next();
            bean = new database.beans.Rechnung();
            bean.setIdentifier(handle.getReader().getInt(0));
            bean.setKundeIdentifier(handle.getReader().getInt(1));
            bean.setKundeIdentifier(handle.getReader().getInt(2));
            bean.setEmpfaengerName(handle.getReader().getString(3));
            bean.setEmpfaengerVorname(handle.getReader().getString(4));
            bean.setEmpfaengerAddresse(handle.getReader().getString(5));
            bean.setEmpfaengerPostleitzahl(handle.getReader().getString(6));
            bean.setEmpfaengerOrt(handle.getReader().getString(7));
            bean.setDatumRechnung(handle.getReader().getInt(8));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bean;
    }

    @Override
    public ArrayList<database.beans.IRechnung> readFuerKunde(int identifier) {
        ArrayList<database.beans.IRechnung> beans = new ArrayList<>();
        try {
            String query = "SELECT * FROM RECHNUNG WHERE KUNDE_IDENTIFIER=?";
            IParameter parameter = new ParameterTypeInt(0, identifier);
            IDriver driver = Factory.create();
            assert driver != null;
            IQueryResultsHandle handle = driver.runQuery(query, parameter);
            while (handle.getReader().next()) {
                database.beans.Rechnung bean = new database.beans.Rechnung();
                bean.setIdentifier(handle.getReader().getInt(0));
                bean.setKundeIdentifier(handle.getReader().getInt(1));
                bean.setKundeIdentifier(handle.getReader().getInt(2));
                bean.setEmpfaengerName(handle.getReader().getString(3));
                bean.setEmpfaengerVorname(handle.getReader().getString(4));
                bean.setEmpfaengerAddresse(handle.getReader().getString(5));
                bean.setEmpfaengerPostleitzahl(handle.getReader().getString(6));
                bean.setEmpfaengerOrt(handle.getReader().getString(7));
                bean.setDatumRechnung(handle.getReader().getInt(8));
                beans.add(bean);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return beans;
    }

    @Override
    public long write(database.beans.IRechnung rechnung) {
        try {
            String statement = "INSERT INTO RECHNUNG VALUES(?,?,?,?,?,?)";
            IParameter[] parameters = {
                new ParameterTypeInt(0, rechnung.getKundeIdentifier()),
                new ParameterTypeString(1, rechnung.getEmpfaengerName()),
                new ParameterTypeString(2, rechnung.getEmpfaengerVorname()),
                new ParameterTypeString(3, rechnung.getEmpfaengerAddresse()),
                new ParameterTypeString(4, rechnung.getEmpfaengerPostleitzahl()),
                new ParameterTypeString(5, rechnung.getEmpfaengerOrt())
            };
            IDriver driver = Factory.create();
            assert driver != null;
            driver.runStatement(statement, parameters);
            // Get identifier
            String query = "SELECT LAST_INSERT_ROWID()";
            IQueryResultsHandle handle = driver.runQuery(query);
            handle.getReader().next();
            return handle.getReader().getLong(0);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}
