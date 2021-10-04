package database;

import database.beans.IApplicationSettings;
import jakarta.json.*;

import java.io.IOException;

public class Database {
    private static Database instance = null;
    private IApplicationSettings applicationSettings = null;

    public static Database getInstance()
    {
        if (null == instance) {
            try
            {
                instance = new Database();
            } catch (JsonException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    private Database() throws JsonException, IOException {
        loadApplicationSettings("./ApplicationSetting.json");
    }

    public void loadApplicationSettings(String applicationSettingsFileName) throws JsonException, IOException {
        this.applicationSettings = new database.beans.ApplicationSettings();
        database.dataAcessObjects.IApplicationSettings reader = new database.dataAcessObjects.ApplicationSettings();
        this.applicationSettings = reader.read(applicationSettingsFileName);
    }

    public IApplicationSettings getApplicationSettings()
    {
        return this.applicationSettings;
    }
}
