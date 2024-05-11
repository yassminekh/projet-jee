package model;

public class Tache {
    private String nomEnseignant;
    private int nombreCopies;
    private String dateReception;
    private String documentImprimer;

    public Tache(String nomEnseignant, int nombreCopies, String dateReception, String documentImprimer) {
        this.nomEnseignant = nomEnseignant;
        this.nombreCopies = nombreCopies;
        this.dateReception = dateReception;
        this.documentImprimer = documentImprimer;
    }

    public String getNomEnseignant() {
        return nomEnseignant;
    }

    public void setNomEnseignant(String nomEnseignant) {
        this.nomEnseignant = nomEnseignant;
    }

    public int getNombreCopies() {
        return nombreCopies;
    }

    public void setNombreCopies(int nombreCopies) {
        this.nombreCopies = nombreCopies;
    }

    public String getDateReception() {
        return dateReception;
    }

    public void setDateReception(String dateReception) {
        this.dateReception = dateReception;
    }

    public String getDocumentImprimer() {
        return documentImprimer;
    }

    public void setDocumentImprimer(String documentImprimer) {
        this.documentImprimer = documentImprimer;
    }
}
