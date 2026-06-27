import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("SYSTEME DE NOTATION DES ETUDIANTS");
        System.out.println("----------------------------------");

        System.out.print("Nom de la classe : ");
        String nomClasse = sc.nextLine();
        Classe classe = new Classe(nomClasse);

        System.out.print("Nombre d'etudiants : ");
        int nbEtudiants = lireEntier();

        for (int i = 1; i <= nbEtudiants; i++) {
            System.out.println("\nEtudiant " + i);

            System.out.print("Prenom : ");
            String prenom = sc.nextLine();

            System.out.print("Nom    : ");
            String nom = sc.nextLine();

            Etudiant etudiant = new Etudiant(nom, prenom);

            System.out.println("Entrez 3 notes pour "
                + prenom + " (entre 0 et 20) :");

            int nbNotes = 0;
            while (nbNotes < etudiant.getMaxNotes()) {
                System.out.print("Note " + (nbNotes + 1) + " : ");
                String saisie = sc.nextLine().trim();

                try {
                    double note = Double.parseDouble(
                        saisie.replace(",", "."));
                    etudiant.ajouterNote(note);
                    nbNotes++;
                } catch (IllegalArgumentException e) {
                    System.out.println("Erreur : " + e.getMessage());
                }
            }

            classe.ajouterEtudiant(etudiant);
            Bulletin bulletin = new Bulletin(etudiant);
            bulletin.afficher();
        }

        System.out.println("\nRESUME DE LA CLASSE");
        System.out.println("------------------------------");
        System.out.println("Classe    : " + classe.getNom());
        System.out.println("Effectif  : "
            + classe.getEtudiants().size() + " etudiant(s)");
        System.out.printf("Moy. gen. : %.2f / 20%n",
            classe.calculerMoyenneClasse());

        Etudiant major = classe.getMajor();
        if (major != null) {
            System.out.println("Major     : "
                + major.getPrenom() + " " + major.getNom());
            System.out.println("Mention   : " + major.getMention());
        }
        System.out.println("------------------------------");

        sc.close();
    }

    private static int lireEntier() {
        while (true) {
            try {
                int val = Integer.parseInt(sc.nextLine().trim());
                if (val <= 0) {
                    System.out.print("Entrez un nombre positif : ");
                    continue;
                }
                return val;
            } catch (NumberFormatException e) {
                System.out.print("Entrez un nombre entier : ");
            }
        }
    }
}