package database.beans;

public interface IApplicationSettings {
    String getDatabaseDriverName();
    void setDatabaseDriverName(String driverName);
    String getDatabaseServerName();
    void setDatabaseServerName(String serverName);
    String getDatabaseName();
    void setDatabaseName(String databaseName);
    String getDatabaseUserName();
    void setDatabaseUserName(String userName);
    String getDatabaseUserPassword();
    void setDatabaseUserPassword(String userPassword);
}
