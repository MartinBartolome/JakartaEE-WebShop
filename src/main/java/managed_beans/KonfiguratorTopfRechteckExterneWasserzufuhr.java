package managed_beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.logging.Logger;

@Named
@RequestScoped
public class KonfiguratorTopfRechteckExterneWasserzufuhr extends ManagedBean {
    private static final long serialVersionUID = 22L;
    private static final Logger log = Logger.getLogger(KonfiguratorTopfRechteckExterneWasserzufuhr.class.toString());
}
