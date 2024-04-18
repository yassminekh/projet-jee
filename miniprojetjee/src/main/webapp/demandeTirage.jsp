<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Demande de Tirage</title>
</head>
<body>
    <h1>Demande de Tirage</h1>
    <form action="tirageServlet" method="post">
        <label for="document">Document à imprimer:</label>
        <input type="text" id="document" name="document"><br>
        <label for="copies">Nombre de copies:</label>
        <input type="number" id="copies" name="copies"><br>
        <input type="submit" value="Envoyer">
    </form>
</body>
</html>
