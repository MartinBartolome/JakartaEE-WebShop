package database.dataAcessObjects;

import org.json.JSONException;

import java.io.IOException;

public interface IApplicationSettings {
    database.beans.IApplicationSettings read(String fileName) throws JSONException, IOException;

}
