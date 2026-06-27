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