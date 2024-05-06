package model;

public class DemandeTirage {
    private String matiere;
    private String document;
    private int nombreCopies;
    //constructeur
    public DemandeTirage(String matiere, String document, int nombreCopies) {
        this.matiere = matiere;
        this.document = document;
        this.nombreCopies = nombreCopies;
    }

    // Getters et setters
    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public int getNombreCopies() {
        return nombreCopies;
    }

    public void setNombreCopies(int nombreCopies) {
        this.nombreCopies = nombreCopies;
    }
}
