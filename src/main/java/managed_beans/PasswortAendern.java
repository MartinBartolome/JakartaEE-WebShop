package managed_beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.logging.Logger;

@Named
@RequestScoped
public class PasswortAendern extends ManagedBean {
    private static final long serialVersionUID = 24L;
    private static final Logger log = Logger.getLogger(PasswortAendern.class.toString());
}
