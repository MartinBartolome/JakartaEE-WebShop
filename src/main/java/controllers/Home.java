package controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.logging.Logger;

@Named
@RequestScoped
public class Home  extends ManagedBean {
    public void initialize() {
        setSessionValue("Sprache", 3);
    }
    public int getIdentifier() {
        Object value = getSessionValue("KundeIdentifier");
        if(value != null)
            return (int)value;
        else
            return 0;
    }
    public String getPageAnmelden()
    {
        return "anmelden.xhtml";
    }

    public String getPageBenutzerProfilAnlegen()
    {
        return "benutzerprofilAnlegen.xhtml";
    }

    public String getPageBenutzerProfilEditieren()
    {
        return "benutzerprofilEditieren.xhtml";
    }

    public String getPageAbmelden() { return "abmelden.xhtml"; }

    public void Abmelden()
    {
        setSessionValue("KundeIdentifier",0);
    }
}
