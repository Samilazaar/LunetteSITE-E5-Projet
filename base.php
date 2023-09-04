<?php include('bdd.php');

session_start();
if (isset($_POST['nom']) and isset($_POST['prenom']) and isset($_POST['motdepasse']) and isset($_POST['mail']) and isset($_POST['confmotdepasse']) and $_POST['motdepasse'] == $_POST['confmotdepasse']) {
    $stmt = $bdd->prepare("INSERT INTO Utilisateur (nom,prenom,mdp,mail,administrateur) VALUES (:nom, :prenom, :mdp, :mail ,:administrateur);");
    $stmt->execute([
        "nom" => $_POST['nom'],
        "prenom" => $_POST['prenom'],
        "mdp" => $_POST['motdepasse'],
        "mail" => $_POST['mail'],
        "administrateur" => 0
    ]);

    header('location:connexion.php');

}


?>