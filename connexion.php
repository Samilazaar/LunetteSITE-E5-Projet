<!DOCTYPE html>
<html lang="en">

<head>
    <?php include('bdd.php'); ?>
    <?php session_start(); ?>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Connexion</title>
    <link rel="stylesheet" type="text/css" href="site.css">
</head>

<body>
    <a href="index.php"><img
            src="https://previews.123rf.com/images/dstarky/dstarky1701/dstarky170100423/69262794-l-icône-des-lunettes-de-soleil-ou-le-logo-dans-un-style-de-ligne-moderne-pictogramme-noir-de-haute.jpg"
            alt="" width="10%" height="10%" title="Découvrez notre logo !" /></a>

    <div class="login-box">
        <h1>Connexion</h1>
        <form action="connexion.php" method="POST">
            <p>Mail</p>
            <input type="text" name="mail" placeholder="Entrez votre adresse mail">
            <p>Mot de passe</p>
            <input type="password" name="mdp" placeholder="Entrez votre mot de passe">
            <input type="submit" name="submit" value="Connexion">
            <a href="changemdp.php" class="btn btn-primary">Changement de mot de passe</a>
        </form>
        
        <?php
        if (isset($_POST['mail']) and isset($_POST['mdp'])) {
            $sth = $bdd->prepare('SELECT * FROM Utilisateur WHERE mail = :mail  AND mdp = :mdp');
            $sth->execute([
                'mail' => $_POST['mail'],
                'mdp' => $_POST['mdp'],
            ]);
            $user = $sth->fetch(PDO::FETCH_ASSOC);
            if ($user) {
                // L'utilisateur a été trouvé, connectez-le
                $_SESSION['id'] = $user['id'];
                $_SESSION['mail'] = $user['mail'];
                $_SESSION['nom'] = $user['nom']; // Remplacez 'nom' par le nom de la colonne qui contient le nom de l'utilisateur
                $requete2 = $bdd->prepare('SELECT *,quantite FROM Lunette
                INNER JOIN panier ON Lunette.id = panier.idproducts
            
                WHERE panier.idUser = :idUser;
                ');
                $requete2->execute([
                    'idUser' => $user['id']
                ]);
                $panier = array();
                while ($row = $requete2->fetch(PDO::FETCH_ASSOC)) {
                    $panier[] = $row;
                }

                $_SESSION['panier'] = $panier;
                // Masquer les boutons d'inscription et de connexion
                echo "<style>{ display: none; }</style>";
            } else {
                // L'utilisateur n'a pas été trouvé, affichez un message d'erreur
                echo "Adresse e-mail ou mot de passe incorrect.";

            }
            header('location:index.php');


        }
        

        ?>
    </div>
</body>

</html>