package database.drivers;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ParameterTypeInt extends Parameter {
    private int value;

    public ParameterTypeInt(int index, int value) {
        super(index);
        this.value = value;
    }

    @Override
    public void addToStatement(PreparedStatement statement) throws SQLException {
        statement.setInt(this.index, this.value);
    }
}

