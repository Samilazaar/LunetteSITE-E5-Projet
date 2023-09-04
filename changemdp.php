<!DOCTYPE html>
<html>
<head>
    <title>Changement de mot de passe</title>
</head>
<body>
    <h1>Changement de mot de passe</h1>
    <form action="modifier.php" method="post">
        <label for="login">Login :</label>
        <input type="text" name="login" id="login" required><br><br>
        
        <label for="current_password">Mot de passe actuel :</label>
        <input type="password" name="current_password" id="current_password" required><br><br>
        
        <label for="new_password">Nouveau mot de passe :</label>
        <input type="password" name="new_password" id="new_password" required><br><br>
        
        <label for="confirm_password">Confirmer le nouveau mot de passe :</label>
        <input type="password" name="confirm_password" id="confirm_password" required><br><br>
        
        <input type="submit" value="Changer le mot de passe">
    </form>
</body>
</html>
