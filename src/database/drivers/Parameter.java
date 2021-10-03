package database.drivers;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class Parameter implements IParameter {
    protected int index;

    public Parameter(int index)
    {
        this.index = index;
    }

    @Override
    public abstract void addToStatement(PreparedStatement statement) throws SQLException;

    @Override
    public int getIndex()
    {
        return this.index;
    }
}
