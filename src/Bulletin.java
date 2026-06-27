public class Bulletin {
    private Etudiant etudiant;

    public Bulletin(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public void afficher() {
        System.out.println("------------------------------");
        System.out.println("BULLETIN DE NOTES");
        System.out.println("------------------------------");
        System.out.println("Etudiant : " + etudiant.getPrenom()
            + " " + etudiant.getNom());

        int i = 1;
        for (double note : etudiant.getNotes()) {
            System.out.println("Note " + i + " : " + note + " / 20");
            i++;
        }

        System.out.printf("Moyenne  : %.2f / 20%n",
            etudiant.calculerMoyenne());
        System.out.println("Mention  : " + etudiant.getMention());
        System.out.println("------------------------------");
    }
}