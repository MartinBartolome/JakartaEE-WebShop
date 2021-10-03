package database.drivers;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ParameterTypeString extends Parameter {
    private String value;

    public ParameterTypeString(int index, String value) {
        super(index);
        this.value = value;
    }

    @Override
    public void addToStatement(PreparedStatement statement) throws SQLException {
        statement.setString(this.index, this.value);
    }
}

