<?php
session_start();
// Stock les informations nécessaires a la base de donné
$dbHost = "localhost";
$dbName = "LunetteSITE";
$dbUser = "root";
$dbPassword = "root";
// Cette ligne établit la connexion à la base de données en utilisant les informations de connexion fournies.
$conn = mysqli_connect($dbHost, $dbUser, $dbPassword, $dbName);

if (!$conn) {
    die("Erreur de connexion à la base de données : " . mysqli_connect_error());
}

// Récupérer les valeurs du formulaire
$login = $_POST['login'];
$currentPassword = $_POST['current_password'];
$newPassword = $_POST['new_password'];
$confirmPassword = $_POST['confirm_password'];

// Vérifier si les mots de passe correspondent
if ($newPassword !== $confirmPassword) {
    die("Les mots de passe ne correspondent pas.");
}

// Vérifier l'existence de l'utilisateur dans la base de données
$query = "SELECT * FROM Utilisateur WHERE nom = '$login' AND mdp = '$currentPassword'";
$result = mysqli_query($conn, $query);

if (mysqli_num_rows($result) == 0) {
    die("Identifiant ou mot de passe incorrect.");
}

// Mettre à jour le mot de passe
$query = "UPDATE Utilisateur SET mdp = '$newPassword' WHERE nom = '$login'";
$result = mysqli_query($conn, $query);

if ($result) {
    echo "Le mot de passe a été mis à jour avec succès.";
} else {
    echo "Erreur lors de la mise à jour du mot de passe : " . mysqli_error($conn);
}

// Fermer la connexion à la base de données
mysqli_close($conn);
?>


