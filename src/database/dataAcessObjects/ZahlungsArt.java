package database.dataAcessObjects;

import database.drivers.*;
import java.sql.SQLException;

public class ZahlungsArt implements IZahlungsArt {
    @Override
    public database.beans.IZahlungsArt readFuerKunde(int identifier) {
        database.beans.IZahlungsArt bean = null;
        try {
            String query = "SELECT * FROM ZAHLUNGSART WHERE KUNDE_IDENTIFIER=?";
            IParameter parameter = new ParameterTypeInt(0, identifier);
            IDriver driver = Factory.create();
            assert driver != null;
            IQueryResultsHandle handle = driver.runQuery(query, parameter);
            handle.getReader().next();
            bean = new database.beans.ZahlungsArt();
            bean.setIdentifier(handle.getReader().getInt(0));
            bean.setKundeIdentifier(handle.getReader().getInt(1));
            bean.setZahlungsArt(handle.getReader().getInt(2));
            bean.setNummerKreditkarte(handle.getReader().getString(3));
            bean.setVerfallKreditkarte(handle.getReader().getString(4));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bean;
    }

    @Override
    public void overwrite(database.beans.IZahlungsArt zahlungsArt) {
        try {
            StringBuilder statement = new StringBuilder();
            statement.append("UPDATE ZAHLUNGSART SET ");
            statement.append("ZAHLUNGSART=?, ");
            statement.append("NUMMERKREDITKARTE=?, ");
            statement.append("VERFALLKREDITKARTE=? ");
            statement.append("WHERE IDENTIFIER=?");
            IParameter[] parameters = {
                new ParameterTypeInt(0, zahlungsArt.getZahlungsArt()),
                new ParameterTypeString(1, zahlungsArt.getNummerKreditkarte()),
                new ParameterTypeString(2, zahlungsArt.getVerfallKreditkarte()),
                new ParameterTypeInt(0, zahlungsArt.getIdentifier())
            };
            IDriver driver = Factory.create();
            assert driver != null;
            driver.runStatement(statement.toString(), parameters);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
