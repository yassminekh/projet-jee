<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inscription</title>
    <!-- Inclure Bootstrap -->
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="container">
        <h2 class="text-center mt-5">Inscription</h2>
        <form action="Register" method="post" class="mt-4">
            <div class="form-group">
                <label for="username">Nom d'utilisateur:</label>
                <input type="text" id="username" name="username" class="form-control">
            </div>
            <div class="form-group">
                <label for="password">Mot de passe:</label>
                <input type="password" id="password" name="password" class="form-control">
            </div>
           
            <div class="form-group">
                <label for="role">Rôle:</label>
                <select id="role" name="role" class="form-control">
                    <option value="enseignant">Enseignant</option>
                    <option value="agent">Agent</option>
                    <option value="admin">Admin</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">S'inscrire</button>
        </form>
    </div>
</body>
</html>
