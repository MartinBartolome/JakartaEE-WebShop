package database.drivers;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ParameterTypeBoolean extends Parameter {
    private Boolean value;

    public ParameterTypeBoolean(int index, Boolean value) {
        super(index);
        this.value = value;
    }

    @Override
    public void addToStatement(PreparedStatement statement) throws SQLException {
        statement.setBoolean(this.index, this.value);
    }
}

