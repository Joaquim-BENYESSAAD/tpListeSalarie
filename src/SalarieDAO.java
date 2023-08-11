import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SalarieDAO {
	public String concepteurFile;
	public String analysteFile;
	
	 public SalarieDAO(String concepteurFile, String analysteFile) {
	        this.concepteurFile = concepteurFile;
	        this.analysteFile = analysteFile;
	    }
	
	public void persist(Salarie salarie) throws IOException{
		if(salarie instanceof Concepteur) {
			FileWriter writer = new FileWriter(concepteurFile, true);
			writer.append(salarie.getCode() + ";" + salarie.getLastName()+";"
						+ salarie.getFirstName() +";"+ salarie.getDateEmbauche()+";"
						+ ((Concepteur) salarie).getNbreAnneeDev()+ "\n");
			writer.close();
		}else if(salarie instanceof Analyste) {
			FileWriter writer = new FileWriter(analysteFile, true);
			writer.append(salarie.getCode() + ";" + salarie.getLastName()+";"
						+ salarie.getFirstName() +";"+ salarie.getDateEmbauche()+";"
						+ ((Analyste) salarie).getNbreDep()+ "\n");
			writer.close();
		}
	}

	
	public List<Concepteur> getWithoutDefaultConcepteur() throws IOException {
        List<Concepteur> concepteurs = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(concepteurFile));
        
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(";");
            int code = Integer.parseInt(data[0]);
            String nom = data[1];
            String prenom = data[2];
            LocalDate dateEmbauche = LocalDate.parse(data[3]);
            int nbreAnneeDev = Integer.parseInt(data[4]);
            
            Concepteur concepteur = new Concepteur(code, nom, prenom, dateEmbauche, nbreAnneeDev);
            concepteurs.add(concepteur);
        }
        
        reader.close();
        return concepteurs;
    }

    public List<Analyste> getWithoutDefaultAnalyste() throws IOException {
        List<Analyste> analystes = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(analysteFile));
        
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(";");
            int code = Integer.parseInt(data[0]);
            String nom = data[1];
            String prenom = data[2];
            LocalDate dateEmbauche = LocalDate.parse(data[3]);
            int nbreDep = Integer.parseInt(data[4]);
            
            Analyste analyste = new Analyste(code, nom, prenom, dateEmbauche, nbreDep);
            analystes.add(analyste);
        }
        
        reader.close();
        return analystes;
    }
}
