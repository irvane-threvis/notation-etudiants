import java.util.ArrayList;
import java.util.List;

public class Classe {
    private String nom;
    private List<Etudiant> etudiants;

    public Classe(String nom) {
        this.nom = nom;
        this.etudiants = new ArrayList<>();
    }
}
  public void ajouterEtudiant(Etudiant e) {
        if (e == null)
            throw new IllegalArgumentException("Etudiant invalide.");
        etudiants.add(e);
    }
    public double calculerMoyenneClasse() {
        if (etudiants.isEmpty()) return 0.0;
        double somme = 0.0;
        for (Etudiant e : etudiants) somme += e.calculerMoyenne();
        return somme / etudiants.size();
    }
      public Etudiant getMajor() {
        if (etudiants.isEmpty()) return null;
        Etudiant major = etudiants.get(0);
        for (Etudiant e : etudiants)
            if (e.calculerMoyenne() > major.calculerMoyenne())
                major = e;
        return major;
    }

    public String getNom()               { return nom; }
    public List<Etudiant> getEtudiants() { return etudiants; }
}