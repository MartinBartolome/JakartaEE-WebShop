package database.dataAcessObjects;

import jakarta.json.Json;
import jakarta.json.JsonException;
import jakarta.json.JsonObject;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class ApplicationSettings implements IApplicationSettings {
    public database.beans.IApplicationSettings read(String fileName) throws JsonException, IOException {
        database.beans.IApplicationSettings bean = new database.beans.ApplicationSettings();
        String content = Files.readString(Path.of(fileName));
        var jsonReader = Json.createReader(new StringReader(content));
        JsonObject parser = jsonReader.readObject();
        String fileVersion = parser.getString("fileVersion");
        bean.setDatabaseDriverName(parser.getString("databaseDriverName"));
        bean.setDatabaseName(parser.getString("databaseName"));
        bean.setDatabaseServerName(parser.getString("databaseServerName"));
        bean.setDatabaseUserName(parser.getString("databaseUserName"));
        bean.setDatabaseUserPassword(parser.getString("databaseUserPassword"));
        return bean;
    }
}
