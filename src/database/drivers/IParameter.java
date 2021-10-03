package database.drivers;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface IParameter {
    void addToStatement(PreparedStatement statement) throws SQLException;
    int getIndex();
}
