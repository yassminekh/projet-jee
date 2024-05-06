<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inscription</title>
</head>
<body>
    <h2>Inscription</h2>
    <form action="RegisterServlet" method="post">
        <label for="username">Nom d'utilisateur:</label><br>
        <input type="text" id="username" name="username"><br>
        <label for="password">Mot de passe:</label><br>
        <input type="password" id="password" name="password"><br>
        <label for="email">E-mail:</label><br>
        <input type="email" id="email" name="email"><br><br>
        <input type="submit" value="S'inscrire">
    </form>
</body>
</html>
