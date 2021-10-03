package database.dataAcessObjects;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ApplicationSettings implements IApplicationSettings {
    public database.beans.IApplicationSettings read(String fileName) throws JSONException, IOException {
        database.beans.IApplicationSettings bean = new database.beans.ApplicationSettings();
        String content = Files.readString(Path.of(fileName));
        JSONObject parser = new JSONObject(content);
        String fileVersion = parser.getString("fileVersion");
        bean.setDatabaseDriverName(parser.getString("databaseDriverName"));
        bean.setDatabaseName(parser.getString("databaseName"));
        bean.setDatabaseServerName(parser.getString("databaseServerName"));
        bean.setDatabaseUserName(parser.getString("databaseUserName"));
        bean.setDatabaseUserPassword(parser.getString("databaseUserPassword"));
        return bean;
    }
}
