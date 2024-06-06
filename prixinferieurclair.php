<?php
// Inclure le fichier de connexion à la base de données
include 'bdd.php';

// Récupérer les lunettes de couleur claire et dont le prix est inférieur à 500
$result = $bdd->prepare('SELECT * FROM Lunette WHERE couleur = :couleur AND prix < :prix_max');
$result->bindParam(':couleur', $couleur, PDO::PARAM_STR);
$result->bindParam(':prix_max', $prix_max, PDO::PARAM_INT);

// Définir les valeurs des paramètres
$couleur = 'clair';
$prix_max = 500;

$result->execute();
$Lunettes = $result->fetchAll(PDO::FETCH_OBJ);
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <?php require('bst.php'); ?>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://unpkg.com/boxicons@2.1.4/dist/boxicons.js"></script>
    <title>Lunettes inférieures à 500€ et de couleur claire</title>
    <link href="site.css" rel="stylesheet">
</head>

<body>
    <h1>Lunettes inférieures à 500€ et de couleur claire</h1>

    <?php
    foreach ($Lunettes as $Lunette) {
    ?>
        <div class="card" style="width: 18rem;">
            <img src="<?php echo $Lunette->image; ?>" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">
                    <?php echo $Lunette->prix . "$"; ?>
                </h5>
                <p class="card-text">
                    <?php echo $Lunette->nom; ?>
                </p>
                <a href="ajoutpanier.php?id=<?php echo $Lunette->id; ?>" class="btn btn-primary">Ajouter au Panier</a>
            </div>
        </div>
    <?php
    }
    ?>

</body>

</html>
