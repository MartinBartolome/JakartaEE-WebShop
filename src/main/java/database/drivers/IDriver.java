package database.drivers;

import java.sql.SQLException;
import java.time.LocalDateTime;

public interface IDriver {
    void runStatement(String statement, IParameter parameter) throws SQLException;
    void runStatement(String statement, IParameter[] parameters) throws SQLException;
    void runStatement(String statement) throws SQLException;
    long runInsert(String statement, IParameter[] parameters) throws SQLException;
    IQueryResultsHandle runQuery(String query, IParameter parameter) throws SQLException;
    IQueryResultsHandle runQuery(String query, IParameter[] parameters) throws SQLException;
    IQueryResultsHandle runQuery(String query) throws SQLException;
    int runScalarQuery(String query) throws SQLException;
    int runScalarQuery(String query, IParameter parameter) throws SQLException;
    int runScalarQuery(String query, IParameter[] parameters) throws SQLException;
    Boolean testConnection() throws SQLException;
    String toDateTime(LocalDateTime dateTime);
}
