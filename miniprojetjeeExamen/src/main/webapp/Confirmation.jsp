<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Confirmation de la Demande de Tirage</title>
</head>
<body>
    <h1>Confirmation de la Demande de Tirage</h1>
    <p>Votre demande de tirage a été enregistrée avec succès :</p>
    <p>Matière : ${demandeTirage.matiere}</p>
    <p>Document : ${demandeTirage.document}</p>
    <p>Nombre de copies : ${demandeTirage.nombreCopies}</p>
</body>
</html>
