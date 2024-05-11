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
    // M�thode pour r�cup�rer les t�ches depuis la base de donn�es
    public static List<Tache> getTaches() throws SQLException {
        List<Tache> taches = new ArrayList<>();

        // Connexion � la base de donn�es
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();

            // Requ�te SQL pour r�cup�rer les t�ches
            String query = "SELECT nom_enseignant, nombre_copies, date_reception, document_imprimer FROM taches";

            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            // Parcourir les r�sultats et cr�er des objets Tache
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
