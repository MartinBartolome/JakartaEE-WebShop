package database.drivers;

import database.Database;

public class Factory {
    public static IDriver create()
    {
        switch (Database.getInstance().getApplicationSettings().getDatabaseDriverName())
        {
            case "SQLite":
                return new database.drivers.SQLite.Driver();
            default:
                break;
        }
        return null;
    }
}
