<head>
    <?php
    include('bst.php');
    ?>
    <a href="index.php"><img
            src="https://previews.123rf.com/images/dstarky/dstarky1701/dstarky170100423/69262794-l-icône-des-lunettes-de-soleil-ou-le-logo-dans-un-style-de-ligne-moderne-pictogramme-noir-de-haute.jpg"
            alt="" width="10%" height="10%" title="Découvrez notre logo !" /></a>

    <div class="login-box">

</head>

<?php
include('bdd.php');
session_start();
if (isset($_SESSION['mail'])) {
    // L'utilisateur est connecté, ne rien faire
} else {
    // L'utilisateur n'est pas connecté, rediriger vers la page de connexion
    header("Location:connexion.php");
    exit();
}
?>
<div>
    <h2>Voici votre Panier :</h2>
</div>

<?php
$iduser = $_SESSION['id'];
$stmt2 = $bdd->prepare("SELECT * FROM Lunette inner join Panier on lunette.id= panier.idProducts where idUser=:idUser");
$stmt2->execute([
    "idUser" => $iduser
]);
$Lunettes = $stmt2->fetchAll(PDO::FETCH_OBJ);
foreach ($Lunettes as $Lunette) {





    ?>

    <body>

        <div class="card" style="width: 18rem;">
            <img src="<?php echo $Lunette->image; ?>" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">
                    <?php echo $Lunette->prix . "$"; ?>
                </h5>
                <p class="card-text">
                    <?php echo $Lunette->nom; ?>
                </p>
                <a href="supprimerpanier.php?id=<?php echo $Lunette->idPanier; ?>" class="btn btn-danger">Supprimer</a>
    


            </div>
        </div>

        <?php
        include('bts.php');

}
?>
</body>

<a href="payer.php" class="btn btn-primary">Payer</a>
