package database.drivers;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ParameterTypeFloat extends Parameter {
    private float value;

    public ParameterTypeFloat(int index, float value) {
        super(index);
        this.value = value;
    }

    @Override
    public void addToStatement(PreparedStatement statement) throws SQLException {
        statement.setFloat(this.index, this.value);
    }
}

