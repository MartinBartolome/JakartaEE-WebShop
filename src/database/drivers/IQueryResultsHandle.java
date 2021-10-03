package database.drivers;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IQueryResultsHandle {
    void close() throws SQLException;
    Boolean hasRows() throws SQLException;
    ResultSet getReader();
}