package managed_beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.logging.Logger;

@Named
@RequestScoped
public class KonfiguratorBewaesserungsSpitze extends ManagedBean {
    private static final long serialVersionUID = 12L;
    private static final Logger log = Logger.getLogger(KonfiguratorBewaesserungsSpitze.class.toString());
}
