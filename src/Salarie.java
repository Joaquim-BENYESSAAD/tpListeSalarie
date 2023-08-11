import java.time.LocalDate;

public abstract class Salarie {
	int code;
	String firstName;
	String lastName;
	LocalDate dateEmbauche;

	
	public Salarie(int code, String firstName, String lastName, LocalDate dateEmbauche) {
		this.code = code;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateEmbauche = dateEmbauche;
	}
	
	 
	    public int getCode() {
	        return code;
	    }

	    
	    public String getLastName() {
	        return firstName;
	    }

	  
	    public String getFirstName() {
	        return firstName;
	    }

	    
	    public LocalDate getDateEmbauche() {
	        return dateEmbauche;
	    }

	    @Override
	    public String toString() {
	        return "Code: " + code +
	               "\nFirst Name: " + firstName +
	               "\nLast Name: " + lastName +
	               "\nDate d'embauche: " + dateEmbauche;
	    }
		
}

