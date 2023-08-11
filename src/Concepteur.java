import java.time.LocalDate;

public class Concepteur extends Salarie implements ConcepteurInterface, ISalarie{
private short nbreAnneeDev;


	
	public Concepteur(int code, String firstName, String lastName, LocalDate dateEmbauche, int nbreAnneeDev2) {
		super(code, firstName, lastName, dateEmbauche);
		this.nbreAnneeDev = nbreAnneeDev;
	}
	
	
	public short getNbreAnneeDev() {
        return nbreAnneeDev;
    }


	@Override
	public String getNom() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getPrenom() {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	
}
