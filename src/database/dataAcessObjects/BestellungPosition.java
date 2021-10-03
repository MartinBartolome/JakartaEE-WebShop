package database.dataAcessObjects;

import database.drivers.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class BestellungPosition implements IBestellungPosition {
    @Override
    public ArrayList<database.beans.IBestellungPosition> readFuerBestellung(int identifier) {
        ArrayList<database.beans.IBestellungPosition> beans = new ArrayList<>();
        try {
            String query = "SELECT * FROM BESTELLUNG WHERE BESTELLUNG_IDENTIFIER=? ORDER BY REIHENFOLGE ASC";
            IParameter parameter = new ParameterTypeInt(0, identifier);
            IDriver driver = Factory.create();
            assert driver != null;
            IQueryResultsHandle handle = driver.runQuery(query, parameter);
            while (handle.getReader().next()) {
                database.beans.IBestellungPosition bean = new database.beans.BestellungPosition();
                bean.setIdentifier(handle.getReader().getInt(0));
                bean.setBestellungIdentifier(handle.getReader().getInt(1));
                bean.setBeschreibung(handle.getReader().getString(2));
                bean.setArtikelNummer(handle.getReader().getString(3));
                bean.setReihenfolge(handle.getReader().getInt(4));
                bean.setAnzahlEinheiten(handle.getReader().getInt(5));
                bean.setPreisProEinheit(handle.getReader().getFloat(6));
                beans.add(bean);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void write(ArrayList<database.beans.IBestellungPosition> bestellungPositionen) {
        try {
            IParameter[] parameters = new IParameter[bestellungPositionen.size()];
            StringBuilder statement = new StringBuilder();
            statement.append("INSERT INTO BESTELLUNGPOSITION ");
            Boolean firstRow = true;
            int index = 0;
            for (database.beans.IBestellungPosition bestellungPosition : bestellungPositionen) {
                if (firstRow) {
                    statement.append("VALUES(?,?,?,?,?,?)");
                    firstRow = false;
                } else {
                    statement.append(",(?,?,?,?,?,?)");
                }
                parameters[index] = new ParameterTypeInt(index++, bestellungPosition.getBestellungIdentifier());
                parameters[index] = new ParameterTypeString(index++, bestellungPosition.getBeschreibung());
                parameters[index] = new ParameterTypeString(index++, bestellungPosition.getArtikelNummer());
                parameters[index] = new ParameterTypeInt(index++, bestellungPosition.getReihenfolge());
                parameters[index] = new ParameterTypeInt(index++, bestellungPosition.getAnzahlEinheiten());
                parameters[index] = new ParameterTypeFloat(index++, bestellungPosition.getPreisProEinheit());
            }
            IDriver driver = Factory.create();
            assert driver != null;
            driver.runStatement(statement.toString(), parameters);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
