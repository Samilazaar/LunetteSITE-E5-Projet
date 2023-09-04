<!DOCTYPE html>
<?php session_start();
if (isset($_SESSION['nom'])) {
    $connecter = true;
} else {
    $connecter = false;
}



?>
<html lang="en">

<head>
    <?php require('bst.php');
    ?>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://unpkg.com/boxicons@2.1.4/dist/boxicons.js"></script>
    <title>Document</title>
    <link href="site.css" rel="stylesheet">
</head>

<body>
    <a><img src="https://previews.123rf.com/images/dstarky/dstarky1701/dstarky170100423/69262794-l-icône-des-lunettes-de-soleil-ou-le-logo-dans-un-style-de-ligne-moderne-pictogramme-noir-de-haute.jpg"
            alt="" width="10%" height="10%" title="Découvrez notre logo !" /></a>

    <div class="login-box">

    </div>
    <form action="" method="get" style="text-align: right;">
        <label for="search"></label>
        <?php if ($connecter) {
            echo "Bienvenue " . $_SESSION['nom'] . " !"; ?>
            <a href="deconnexion.php"><input type="button" value="Deconnexion"></a>
            <?php
        } else { ?>
            <a href="inscription.php"><input type="button" value="Inscription"></a>
            <a href="connexion.php"><input type="button" value="Connexion"></a>
            <?php
        }
        ?>




    </form>
    <?php
    include 'bdd.php';
    ?>

    <nav class="navi">
        <ul>
            <button type="submit"></button>
            <a href="panier.php">
                <box-icon type='solid' name='basket' style="float: right;"></box-icon>
            </a>

        </ul>


    </nav>
    <div class="imgban"></div>

    <?php
    $result = $bdd->query('SELECT * FROM Lunette');
    $Lunettes = $result->fetchAll(PDO::FETCH_OBJ);
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
                <a href="ajoutpanier.php?id=<?php echo $Lunette->id; ?>" class="btn btn-primary">Ajouter Panier</a>

            </div>
        </div>
        <?php

    }
    ?>
















</body>

</html>
<style>