<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Connexion</title>
</head>
<body>
    <h1>Connexion</h1>
    <form action="loginServlet" method="post">
        <label for="username">Nom d'utilisateur:</label>
        <input type="text" id="username" name="username"><br>
        <label for="password">Mot de passe:</label>
        <input type="password" id="password" name="password"><br>
        <input type="submit" value="Se connecter">
    </form>
</body>
</html>
