package database.beans;

public class ApplicationSettings implements IApplicationSettings {
    private String databaseDriverName;
    private String databaseServerName;
    private String databaseName;
    private String databaseUserName;
    private String databaseUserPassword;

    @Override
    public String getDatabaseDriverName() {
        return this.databaseDriverName;
    }

    @Override
    public void setDatabaseDriverName(String driverName) {
        this.databaseDriverName = driverName;
    }

    @Override
    public String getDatabaseServerName() {
        return this.databaseServerName;
    }

    @Override
    public void setDatabaseServerName(String serverName) {
        this.databaseServerName = serverName;
    }

    @Override
    public String getDatabaseName() {
        return this.databaseName;
    }

    @Override
    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    @Override
    public String getDatabaseUserName() {
        return this.databaseUserName;
    }

    @Override
    public void setDatabaseUserName(String userName) {
        this.databaseUserName = userName;
    }

    @Override
    public String getDatabaseUserPassword() {
        return this.databaseUserPassword;
    }

    @Override
    public void setDatabaseUserPassword(String userPassword) {
        this.databaseUserPassword = userPassword;
    }
}
