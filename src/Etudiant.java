import java.util.ArrayList;
import java.util.List;

public class Etudiant {
    private String nom;
    private String prenom;
    private List<Double> notes;
    private static final int MAX_NOTES = 3;

    public Etudiant(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.notes = new ArrayList<>();
    }

    public void ajouterNote(double note) {
        if (note < 0 || note > 20)
            throw new IllegalArgumentException("Note invalide : entre 0 et 20.");
        if (notes.size() >= MAX_NOTES)
            throw new IllegalStateException("Maximum " + MAX_NOTES + " notes atteint.");
        notes.add(note);
    }

    public double calculerMoyenne() {
        if (notes.isEmpty()) return 0.0;
        double somme = 0.0;
        for (double n : notes) somme += n;
        return somme / notes.size();
    }

    public String getMention() {
        double moy = calculerMoyenne();
        if (moy >= 16) return "Tres Bien";
        if (moy >= 14) return "Bien";
        if (moy >= 12) return "Assez Bien";
        if (moy >= 10) return "Passable";
        return "Insuffisant";
    }

    public String getNom()         { return nom; }
    public String getPrenom()      { return prenom; }
    public List<Double> getNotes() { return notes; }
    public int getMaxNotes()       { return MAX_NOTES; }
}