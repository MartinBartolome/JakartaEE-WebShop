package database.dataAcessObjects;

import database.drivers.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class Bestellung implements IBestellung {
    @Override
    public ArrayList<database.beans.IBestellung> readFuerKunde(int identifier) {
        ArrayList<database.beans.IBestellung> beans = new ArrayList<>();
        try {
            String query = "SELECT * FROM BESTELLUNG WHERE ARTIKELIDENTIFIER=?";
            IParameter parameter = new ParameterTypeInt(0, identifier);
            IDriver driver = Factory.create();
            assert driver != null;
            IQueryResultsHandle handle = driver.runQuery(query, parameter);
            while (handle.getReader().next()) {
                database.beans.IBestellung bean = new database.beans.Bestellung();
                bean.setIdentifier(handle.getReader().getInt(0));
                bean.setKundeIdentifier(handle.getReader().getInt(1));
                bean.setEmpfaengerName(handle.getReader().getString(2));
                bean.setEmpfaengerVorname(handle.getReader().getString(3));
                bean.setEmpfaengerAddresse(handle.getReader().getString(4));
                bean.setEmpfaengerPostleitzahl(handle.getReader().getString(5));
                bean.setEmpfaengerOrt(handle.getReader().getString(6));
                bean.setEmpfaengerZahlungsArt(handle.getReader().getString(7));
                bean.setEmpfaengerNummerKreditkarte(handle.getReader().getString(8));
                bean.setEmpfaengerVerfallKreditkarte(handle.getReader().getString(9));
                bean.setDatumBestellung(handle.getReader().getInt(10));
                bean.setDatumAuslieferung(handle.getReader().getInt(11));
                bean.setZustand(handle.getReader().getInt(12));
                beans.add(bean);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public database.beans.IBestellung read(int identifier) {
        database.beans.IBestellung bean = null;
        try {
            String query = "SELECT * FROM BESTELLUNG WHERE IDENTIFIER=?";
            IParameter parameter = new ParameterTypeInt(0, identifier);
            IDriver driver = Factory.create();
            assert driver != null;
            IQueryResultsHandle handle = driver.runQuery(query, parameter);
            handle.getReader().next();
            bean = new database.beans.Bestellung();
            bean.setIdentifier(handle.getReader().getInt(0));
            bean.setKundeIdentifier(handle.getReader().getInt(1));
            bean.setEmpfaengerName(handle.getReader().getString(2));
            bean.setEmpfaengerVorname(handle.getReader().getString(3));
            bean.setEmpfaengerAddresse(handle.getReader().getString(4));
            bean.setEmpfaengerPostleitzahl(handle.getReader().getString(5));
            bean.setEmpfaengerOrt(handle.getReader().getString(6));
            bean.setEmpfaengerZahlungsArt(handle.getReader().getString(7));
            bean.setEmpfaengerNummerKreditkarte(handle.getReader().getString(8));
            bean.setEmpfaengerVerfallKreditkarte(handle.getReader().getString(9));
            bean.setDatumBestellung(handle.getReader().getInt(10));
            bean.setDatumAuslieferung(handle.getReader().getInt(11));
            bean.setZustand(handle.getReader().getInt(12));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bean;
    }

    @Override
    public void overwrite(database.beans.IBestellung bestellung) {
        database.beans.IBestellung bean = null;
        try {
            StringBuilder statement = new StringBuilder();
            statement.append("UPDATE BESTELLUNG SET ");
            statement.append("DATUMAUSLIERERUNG=?,");
            statement.append("ZUSTAND=? ");
            statement.append("WHERE IDENTIFIER=?");
            IParameter[] parameters = {
                new ParameterTypeInt(0, bestellung.getDatumAuslieferung()),
                new ParameterTypeInt(1, bestellung.getZustand())
            };
            IDriver driver = Factory.create();
            assert driver != null;
            driver.runInsert(statement.toString(), parameters);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public long write(database.beans.IBestellung bestellung) {
        try {
            String statement = "INSERT INTO BESTELLUNG VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            IParameter[] parameters = {
                new ParameterTypeInt(0, bestellung.getKundeIdentifier()),
                new ParameterTypeString(1, bestellung.getEmpfaengerVorname()),
                new ParameterTypeString(2, bestellung.getEmpfaengerName()),
                new ParameterTypeString(3, bestellung.getEmpfaengerAddresse()),
                new ParameterTypeString(4, bestellung.getEmpfaengerPostleitzahl()),
                new ParameterTypeString(5, bestellung.getEmpfaengerOrt()),
                new ParameterTypeString(6, bestellung.getEmpfaengerZahlungsArt()),
                new ParameterTypeString(7, bestellung.getEmpfaengerNummerKreditkarte()),
                new ParameterTypeString(8, bestellung.getEmpfaengerVerfallKreditkarte()),
                new ParameterTypeInt(9, bestellung.getDatumBestellung()),
                new ParameterTypeInt(10, bestellung.getDatumAuslieferung()),
                new ParameterTypeInt(11, bestellung.getZustand())
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
