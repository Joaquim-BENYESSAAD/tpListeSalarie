import java.time.LocalDate;

 public class Analyste extends Salarie implements AnalysteInterface {
	private int nbreDep;
	
	public Analyste(int code, String firstName, String lastName, LocalDate dateEmbauche, int nbreDep) {
		super(code, firstName, lastName, dateEmbauche);
		this.nbreDep = nbreDep;
	}
	
	
	public int getNbreDep() {
		return nbreDep;
	}
}
