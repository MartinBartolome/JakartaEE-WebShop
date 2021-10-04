package database.dataAcessObjects;

import database.drivers.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class RechnungPosition implements IRechnungPosition {
    @Override
    public ArrayList<database.beans.IRechnungPosition> readFuerRechnung(int identifier) {
        ArrayList<database.beans.IRechnungPosition> beans = new ArrayList<>();
        try {
            String query = "SELECT * FROM RECHNUNGPOSITION WHERE RECHNUNG_IDENTIFIER=? ORDER BY REIHENFOLGE ASC";
            IParameter parameter = new ParameterTypeInt(0, identifier);
            IDriver driver = Factory.create();
            assert driver != null;
            IQueryResultsHandle handle = driver.runQuery(query, parameter);
            while (handle.getReader().next()) {
                database.beans.IRechnungPosition bean = new database.beans.RechnungPosition();
                bean.setIdentifier(handle.getReader().getInt(0));
                bean.setRechnungIdentifier(handle.getReader().getInt(1));
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
    public void write(ArrayList<database.beans.IRechnungPosition> rechnungPositionen) {
        try {
            IParameter[] parameters = new IParameter[rechnungPositionen.size()];
            StringBuilder statement = new StringBuilder();
            statement.append("INSERT INTO RECHNUNGPOSITION ");
            Boolean firstRow = true;
            int index = 0;
            for (database.beans.IRechnungPosition rechnungPosition : rechnungPositionen) {
                if (firstRow) {
                    statement.append("VALUES(?,?,?,?,?,?)");
                    firstRow = false;
                } else {
                    statement.append(",(?,?,?,?,?,?)");
                }
                parameters[index] = new ParameterTypeInt(index++, rechnungPosition.getRechnungIdentifier());
                parameters[index] = new ParameterTypeString(index++, rechnungPosition.getBeschreibung());
                parameters[index] = new ParameterTypeString(index++, rechnungPosition.getArtikelNummer());
                parameters[index] = new ParameterTypeInt(index++, rechnungPosition.getReihenfolge());
                parameters[index] = new ParameterTypeInt(index++, rechnungPosition.getAnzahlEinheiten());
                parameters[index] = new ParameterTypeFloat(index++, rechnungPosition.getPreisProEinheit());
            }
            IDriver driver = Factory.create();
            assert driver != null;
            driver.runStatement(statement.toString(), parameters);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
