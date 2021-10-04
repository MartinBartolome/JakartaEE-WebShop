package database.drivers.SQLite;

import database.drivers.IQueryResultsHandle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryResultsHandle implements IQueryResultsHandle {
    protected ResultSet reader = null;
    protected Connection connection = null;

    public QueryResultsHandle(Connection connection, ResultSet reader) {
        this.connection = connection;
        this.reader = reader;
    }

    public ResultSet getReader()
    {
        return this.reader;
    }

    public Boolean hasRows() throws SQLException {
        this.reader.last();
        return (0 != this.reader.getRow());
    }

    public void close() throws SQLException {
        this.reader.close();
        this.connection.close();
    }
}
