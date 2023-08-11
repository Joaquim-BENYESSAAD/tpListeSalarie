import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Vue {

	private static List<Salarie> salaries = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char choix = ' ';

		while (choix != 'D') {
			System.out.println("Faites votre choix:");
			System.out.println("A- Lister les salariés existants");
			System.out.println("B- Ajouter un concepteur");
			System.out.println("C- Ajouter un analyste");
			System.out.println("D- Supprimer un salarié");
			System.out.println("E- Connaitre les salariés depuis une certaine date");
			System.out.println("F- Connaitre les concepteurs avec plus d'années de dev");

			choix = sc.next().charAt(0);

			switch (choix) {
			case 'A':
				listeSalarie();
				break;
			case 'B':
				ajouterConcepteur(sc);
				break;
			case 'C':
				ajouterAnalyste(sc);
				break;
			case 'D':
				supprimerSalarie(sc);
				break;
			case 'E':
				salarieDepuisDate(sc);
				break;
			case 'F':
				AnalysteDepuisAnnee(sc);
				break;
			default:
				System.out.println("Choix non valide.");
			}
		}
	}

	public static void listeSalarie() {
		System.out.println("Voici la liste des salariés:");
		for (Salarie salarie : salaries) {
			System.out.println(
					salarie.code + " " + salarie.firstName + " " + salarie.lastName + " " + salarie.dateEmbauche);
		}

	}

	public static void ajouterConcepteur(Scanner sc) {
		System.out.println("Entrez votre code: ");
		int code = sc.nextInt();

		System.out.println("Entrez votre prénom: ");
		String firstName = sc.next();

		System.out.println("Entrez votre nom: ");
		String lastName = sc.next();

		System.out.println("Entrez la date d'embauche (format: yyyy-mm-dd) :");
		String dateEmbaucheStr = sc.next();
		LocalDate dateEmbauche = LocalDate.parse(dateEmbaucheStr);

		System.out.println("Entrez votre nombre d'années de développement");
		int nbreAnneeDev = sc.nextInt();

		Concepteur concepteur = new Concepteur(code, firstName, lastName, dateEmbauche, nbreAnneeDev);
		salaries.add(concepteur);

		System.out.println("Vous avez été enregistré :)");

	}

	public static void ajouterAnalyste(Scanner sc) {
		System.out.println("Entrez votre code: ");
		int code = sc.nextInt();

		System.out.println("Entrez votre prénom: ");
		String firstName = sc.next();

		System.out.println("Entrez votre nom: ");
		String lastName = sc.next();

		System.out.println("Entrez la date d'embauche (format: yyyy-mm-dd) :");
		String dateEmbaucheStr = sc.next();
		LocalDate dateEmbauche = LocalDate.parse(dateEmbaucheStr);

		System.out.println("Entrez votre nombre de déplacements");
		int nbreDep = sc.nextInt();

		Analyste analyste = new Analyste(code, firstName, lastName, dateEmbauche, nbreDep);
		salaries.add(analyste);

		System.out.println("Vous avez été enregistré :)");

	}

	public static void supprimerSalarie(Scanner sc) {
		System.out.println("saisissez le code de la personne que vous voulez supprimer");
		int codeDelete = sc.nextInt();

		Iterator<Salarie> iterator = salaries.iterator();
		boolean trouve = false;

		while (iterator.hasNext()) {
			Salarie salarie = iterator.next(); 
				ISalarie iSalarie = (ISalarie) salarie;
				if (iSalarie.getCode() == (codeDelete)) {
					iterator.remove();
					trouve = true;
					break;
			}
			
		}

		if (trouve) {
				System.out.println("Le salarié a été supprimé avec succès !");
		} else {
				System.out.println("Aucun salarié trouvé avec ce code.");
		}
	}

	public static void salarieDepuisDate(Scanner sc) {
		System.out.println("Veuillez entrer la date d'entrée du salarié: ");
		String dateSalarieStr = sc.next();
		LocalDate dateSalarie = LocalDate.parse(dateSalarieStr);
		boolean trueSalarie = false;
		
		Iterator<Salarie> iterator = salaries.iterator();
		while(iterator.hasNext()) {
			Salarie salarie = iterator.next();
			ISalarie iSalarie = (ISalarie) salarie;
			if(iSalarie.getDateEmbauche().equals(dateSalarie)) {
				 System.out.println("Salarie trouvé : " + salarie.toString());
				 trueSalarie = true;
			}
			
		}
		if(trueSalarie = false) {
			System.out.println("Aucun Salarie trouvé depuis votre date...");
		}
	}

	public static void AnalysteDepuisAnnee(Scanner sc) {
		System.out.println("Veuillez entrer la date d'entrée du salarié: ");
		int anneeDev = sc.nextInt();
		
		boolean trueAnneeDev = false;
		
		Iterator<Salarie> iterator = salaries.iterator();
		while(iterator.hasNext()) {
			Salarie salarie = iterator.next();
			AnalysteInterface analysteInterface = (AnalysteInterface) salarie;
			if(analysteInterface.getNbreDep() == anneeDev) {
				 System.out.println("Salarie trouvé : " + salarie.toString());
				 trueAnneeDev = true;
			}
			
		}
		if(trueAnneeDev = false) {
			System.out.println("Aucun Salarie trouvé depuis votre nombre d'années de développements...");
		}
	} 
}
