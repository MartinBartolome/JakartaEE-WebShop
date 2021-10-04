package database.dataAcessObjects;

import jakarta.json.JsonException;

import java.io.IOException;

public interface IApplicationSettings {
    database.beans.IApplicationSettings read(String fileName) throws JsonException, IOException;
}
