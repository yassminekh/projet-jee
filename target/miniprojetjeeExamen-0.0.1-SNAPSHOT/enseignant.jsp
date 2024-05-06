<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Interface Enseignant</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <header>
        <h1>Interface Enseignant</h1>
    </header>
    <main>
        <div class="container">
            <div class="button-group">
                <button>Liste Groupes</button>
                <button>Liste Matières</button>
            </div>
            <div class="data-entry">
                <form>
                    <label for="date">Date du document :</label>
                    <input type="date" id="date" name="date">
                    <label for="description">Description :</label>
                    <textarea id="description" name="description" rows="4"></textarea>
                    <input type="submit" value="Télécharger">
                    <input type="submit" value="Valider">
                </form>
            </div>
        </div>
    </main>
    <footer>
        <p>© 2024 Plateforme de Gestion d'Impression. Tous droits réservés.</p>
    </footer>
</body>
</html>
