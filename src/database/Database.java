package database;

import database.beans.IApplicationSettings;
import org.json.JSONException;

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
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    private Database() throws JSONException, IOException {
        loadApplicationSettings("./ApplicationSetting.json");
    }

    public void loadApplicationSettings(String applicationSettingsFileName) throws JSONException, IOException {
        this.applicationSettings = new database.beans.ApplicationSettings();
        database.dataAcessObjects.IApplicationSettings reader = new database.dataAcessObjects.ApplicationSettings();
        this.applicationSettings = reader.read(applicationSettingsFileName);
    }

    public IApplicationSettings getApplicationSettings()
    {
        return this.applicationSettings;
    }
}
