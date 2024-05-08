<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Connexion</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="container">
		<h2>Connexion</h2>
		<form action="LoginServlet" method="post">
			<label for="username">Nom d'utilisateur:</label><br> <input
				type="text" id="username" name="username"
				value="${sessionScope.registeredUsername}"><br> <label
				for="password">Mot de passe:</label><br> <input type="password"
				id="password" name="password" value="${sessionScope.registeredMdp}"><br>
			<label for="role">Role:</label><br> <select id="role"
				name="role">
				<option value="enseignant"
					${"enseignant".equals(sessionScope.registeredRole) ? "selected" : ""}>Enseignant</option>
				<option value="admin"
					${"admin".equals(sessionScope.registeredRole) ? "selected" : ""}>Administrateur</option>
				<option value="agent"
					${"agent".equals(sessionScope.registeredRole) ? "selected" : ""}>Agent</option>
			</select> <br> <input type="submit" value="Se connecter">
		</form>
		<form action="Register" method="get">
			<input type="submit" value="S'inscrire">
		</form>
	</div>
</body>
</html>
