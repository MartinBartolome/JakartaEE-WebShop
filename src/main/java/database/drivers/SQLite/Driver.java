package database.drivers.SQLite;

import database.Database;
import database.beans.IApplicationSettings;
import database.drivers.IDriver;
import database.drivers.IParameter;
import database.drivers.IQueryResultsHandle;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

public class Driver implements IDriver {
    protected Connection openConnection() throws SQLException {
        IApplicationSettings bean = Database.getInstance().getApplicationSettings();
        return DriverManager.getConnection(bean.getDatabaseServerName() + "/" + bean.getDatabaseName(), bean.getDatabaseUserName(), bean.getDatabaseUserPassword());
    }
    @Override
    public String toDateTime(LocalDateTime dateTime) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return format.format(dateTime);
    }

    @Override
    public void runStatement(String statement, IParameter parameter) throws SQLException {
        Connection connection = openConnection();
        PreparedStatement connectionStatement = connection.prepareStatement(statement);
        parameter.addToStatement(connectionStatement);
        connectionStatement.execute();
        connection.close();
    }

    @Override
    public void runStatement(String statement, IParameter[] parameters) throws SQLException {
        Connection connection = openConnection();
        PreparedStatement connectionStatement = connection.prepareStatement(statement);
        for (IParameter parameter : parameters)
        {
            parameter.addToStatement(connectionStatement);
        }
        connectionStatement.execute();
        connection.close();
    }

    @Override
    public void runStatement(String statement) throws SQLException {
        Connection connection = openConnection();
        Statement connectionStatement = connection.createStatement();
        connectionStatement.execute(statement);
        connection.close();
    }

    @Override
    public IQueryResultsHandle runQuery(String query, IParameter parameter) throws SQLException {
        Connection connection = openConnection();
        PreparedStatement connectionStatement = connection.prepareStatement(query);
        parameter.addToStatement(connectionStatement);
        ResultSet reader = connectionStatement.executeQuery();
        return new QueryResultsHandle(connection, reader);
    }

    @Override
    public IQueryResultsHandle runQuery(String query, IParameter[] parameters) throws SQLException {
        Connection connection = openConnection();
        PreparedStatement connectionStatement = connection.prepareStatement(query);
        for (IParameter parameter : parameters)
        {
            parameter.addToStatement(connectionStatement);
        }
        ResultSet reader = connectionStatement.executeQuery();
        return new QueryResultsHandle(connection, reader);
    }

    @Override
    public IQueryResultsHandle runQuery(String query) throws SQLException {
        Connection connection = openConnection();
        Statement connectionStatement = connection.createStatement();
        ResultSet reader = connectionStatement.executeQuery(query);
        return new QueryResultsHandle(connection, reader);
    }

    @Override
    public int runScalarQuery(String query) throws SQLException {
        Connection connection = openConnection();
        Statement connectionStatement = connection.createStatement();
        ResultSet reader = connectionStatement.executeQuery(query);
        reader.last();
        return reader.getRow();
    }

    @Override
    public int runScalarQuery(String query, IParameter parameter) throws SQLException {
        Connection connection = openConnection();
        PreparedStatement connectionStatement = connection.prepareStatement(query);
        parameter.addToStatement(connectionStatement);
        ResultSet reader = connectionStatement.executeQuery();
        reader.last();
        return reader.getRow();
    }

    @Override
    public int runScalarQuery(String query, IParameter[] parameters) throws SQLException {
        Connection connection = openConnection();
        PreparedStatement connectionStatement = connection.prepareStatement(query);
        for (IParameter parameter : parameters)
        {
            parameter.addToStatement(connectionStatement);
        }
        ResultSet reader = connectionStatement.executeQuery();
        reader.last();
        return reader.getRow();
    }

    @Override
    public Boolean testConnection() throws SQLException {
        return (null != openConnection());
    }

    @Override
    public long runInsert(String statement, IParameter[] parameters) throws SQLException {
        Connection connection = openConnection();
        PreparedStatement connectionStatement = connection.prepareStatement(statement);
        for (IParameter parameter : parameters)
        {
            parameter.addToStatement(connectionStatement);
        }
        connectionStatement.execute();
        connectionStatement.getGeneratedKeys();
        ResultSet reader = connectionStatement.getGeneratedKeys();
        reader.next();
        return reader.getLong(0);
    }
}
