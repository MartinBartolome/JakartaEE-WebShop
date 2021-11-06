package managed_beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.logging.Logger;

@Named
@RequestScoped
public class BestellungAusloesenSchritt4 extends ManagedBean {
    private static final long serialVersionUID = 9L;
    private static final Logger log = Logger.getLogger(BestellungAusloesenSchritt4.class.toString());
}
