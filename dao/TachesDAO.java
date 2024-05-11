package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Tache;
import utils.JDBCUtils;

public class TachesDAO {
    // Méthode pour récupérer les tâches depuis la base de données
    public static List<Tache> getTaches() throws SQLException {
        List<Tache> taches = new ArrayList<>();

        // Connexion à la base de données
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();

            // Requête SQL pour récupérer les tâches
            String query = "SELECT nom_enseignant, nombre_copies, date_reception, document_imprimer FROM taches";

            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            // Parcourir les résultats et créer des objets Tache
            while (rs.next()) {
                String nomEnseignant = rs.getString("nom_enseignant");
                int nombreCopies = rs.getInt("nombre_copies");
                String dateReception = rs.getString("date_reception");
                String documentImprimer = rs.getString("document_imprimer");

                Tache tache = new Tache(nomEnseignant, nombreCopies, dateReception, documentImprimer);
                taches.add(tache);
            }
        } finally {
            // Fermer les ressources
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return taches;
    }
}
