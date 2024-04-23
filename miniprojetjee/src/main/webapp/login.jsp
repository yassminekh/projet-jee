<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Connexion</title>
  <link rel="stylesheet" href="style.css"> </head>
<body>
  <div class="container">
    <h1>Connexion</h1>
    <form action="LoginServlet" method="post">
      <div class="form-group">
        <label for="username">Nom d'utilisateur:</label>
        <input type="text" id="username" name="username" required>
      </div>
      <div class="form-group">
        <label for="password">Mot de passe:</label>
        <input type="password" id="password" name="password" required>
      </div>
      <div class="form-group">
        <input type="submit" value="Se connecter" class="btn btn-primary">
      </div>
    </form>
  </div>

  <script>
    const passwordInput = document.getElementById('password');
    const toggleVisibility = document.getElementById('toggleVisibility');

    toggleVisibility.addEventListener('click', (event) => {
      if (passwordInput.type === 'password') {
        passwordInput.type = 'text';
        toggleVisibility.textContent = 'Masquer le mot de passe';
      } else {
        passwordInput.type = 'password';
        toggleVisibility.textContent = 'Afficher le mot de passe';
      }
    });
  </script>
</body>
</html>
