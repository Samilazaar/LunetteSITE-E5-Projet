<!DOCTYPE html>
<html>
<a href="index.php"><img
            src="https://previews.123rf.com/images/dstarky/dstarky1701/dstarky170100423/69262794-l-icône-des-lunettes-de-soleil-ou-le-logo-dans-un-style-de-ligne-moderne-pictogramme-noir-de-haute.jpg"
            alt="" width="10%" height="10%" title="Découvrez notre logo !" /></a>

    <div class="login-box">
<?php session_start();
?>

<head>
    <link href="site.css" rel="stylesheet">
    <title>Inscription - Mon site</title>
</head>

<body>
    <div class="payer">
        <h1> Confirmation du paiement</h1>
        <form action="confirmer.php" method="post">
            <div class="form-row">
                <input type="text" name="nom" placeholder="Nom">
                <input type="text" name="prenom" placeholder="Prénom">
            </div>
            <input type="text" name="numerodecarte" placeholder="Numero de carte bancaire">
            Date d'expiration :<input type="date" name="date">
            <div class="form-row">
            Code CVV :<input type="number" name="confmotdepasse">
            </div>
            <form method="post" action="confirmer.php">
        <!-- Ajoutez ici les champs de votre formulaire de paiement -->
        <input type="submit" value="Payer">
    </div>
    </form>
    </div>
</body>
