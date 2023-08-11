import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Modele {

    public static void main(String[] args) {
        SalarieDAO salarieDAO = new SalarieDAO("concepteur.csv", "analyste.csv");
        Scanner scanner = new Scanner(System.in);

        char choix = ' ';

        while (choix != 'G') {
            System.out.println("Faites votre choix:");
            System.out.println("A- Liste des salariés");
            System.out.println("B- Ajouter un concepteur");
            System.out.println("C- Ajouter un analyste");
            System.out.println("D- Supprimer un salarié");
            System.out.println("E- Salariés depuis une certaine date");
            System.out.println("F- Concepteurs avec plus d'années de dev");
            System.out.println("G- Quitter");

            choix = scanner.next().charAt(0);

            switch (choix) {
                case 'A':
                	try {
                        List<Concepteur> concepteurs = salarieDAO.getWithoutDefaultConcepteur();
                        List<Analyste> analystes = salarieDAO.getWithoutDefaultAnalyste();
                        
                        System.out.println("Concepteurs:");
                        for (Concepteur concepteur : concepteurs) {
                            System.out.println(concepteur.getCode() + " " + concepteur.getNom() + " " + concepteur.getPrenom());
                        }
                        
                        System.out.println("Analystes:");
                        for (Analyste analyste : analystes) {
                            System.out.println(analyste.getCode() + " " + analyste.getLastName() + " " + analyste.getFirstName());
                        }
                    } catch (IOException e) {
                        System.out.println("Erreur lors de la lecture des fichiers.");
                    }
                    break;
                case 'B':
                    // Lire les données depuis l'utilisateur
                    int code  /* lire le code */;
                    String lastName  /* lire le nom */;
                    String firstName  /* lire le prénom */;
                    LocalDate dateEmbauche  /* lire la date */;
                    int anneesDev  /* lire le nombre d'années */;
                    // Appeler traitementB de SalarieDAO
                    break;
                case 'C':
                    // Lire les données depuis l'utilisateur
                    // Appeler traitementC de SalarieDAO
                    break;
                case 'D':
                    // Lire le code depuis l'utilisateur
                    // Appeler traitementD de SalarieDAO
                    break;
                case 'E':
                    // Lire la date depuis l'utilisateur
                    // Appeler traitementE de SalarieDAO
                    break;
                case 'F':
                    // Lire le nombre d'années depuis l'utilisateur
                    // Appeler traitementF de SalarieDAO
                    break;
                case 'G':
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix non valide.");
            }
        }
    }
}
