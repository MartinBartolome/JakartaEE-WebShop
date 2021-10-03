package database.dataAcessObjects;

import database.drivers.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class RechnungPositionMerkmal implements IRechnungPositionMerkmal {
    @Override
    public database.beans.IRechnungPositionMerkmal read(int identifier) {
        return null;
    }

    @Override
    public ArrayList<IRechnungPositionMerkmal> readFuerRechnungPosition(int identifier) {
        return null;
    }

    @Override
    public long write(database.beans.IRechnungPositionMerkmal rechnungPositionMerkmal) {
        try {
            String statement = "INSERT INTO RECHNUNGPOSITIONMERKMAL VALUES(?,?,?,?)";
            IParameter[] parameters = {
                new ParameterTypeInt(0, rechnungPositionMerkmal.getRechnungPositionIdentifier()),
                new ParameterTypeString(1, rechnungPositionMerkmal.getBeschreibung()),
                new ParameterTypeString(2, rechnungPositionMerkmal.getSchluessel()),
                new ParameterTypeString(3, rechnungPositionMerkmal.getWert())
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
