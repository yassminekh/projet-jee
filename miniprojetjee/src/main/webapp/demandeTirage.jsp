<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Demande de Tirage</title>
</head>
<body>
    <h1>Demande de Tirage</h1>
    <form action="demandeTirage" method="post">
        <label for="matiere">Matière :</label>
        <input type="text" id="matiere" name="matiere"><br>
        <label for="document">Document :</label>
        <input type="text" id="document" name="document"><br>
        <label for="nombreCopies">Nombre de copies :</label>
        <input type="number" id="nombreCopies" name="nombreCopies"><br>
        <input type="submit" value="Envoyer">
    </form>
</body>
</html>
