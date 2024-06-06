# Documentation du Projet LunetteSITE

## Sommaire
1. [Page d'Inscription](#page-dinscription)
2. [Création de la Base de Données](#création-de-la-base-de-données)
3. [Gestion du Panier](#gestion-du-panier)
4. [Page de Connexion](#page-de-connexion)
5. [Ajout de Lunettes](#ajout-de-lunettes)
6. [Suppression de Lunettes](#suppression-de-lunettes)

## Page d'Inscription

### HTML et PHP
```html
<!DOCTYPE html>
<html>
<a href="index.php">
    <img src="moderne.png" alt="" width="10%" height="10%" title="Découvrez notre logo !" />
</a>

<?php session_start(); ?>

<head>
    <link href="site.css" rel="stylesheet">
    <title>Inscription - Mon site</title>
</head>

<body>
<?php 
$hash = '$2y$07$BCryptRequires22Chrcte/VlQH0piJtjXl.0t1XkA8pw9dMXTpOq';

if (password_verify('rasmuslerdorf', $hash)) {
} else {
    echo 'Le mot de passe est invalide.';
}
?>
    <div class="container">
        <h1>Inscription</h1>
        <form action="base.php" method="post">
            <div class="form-row">
                <input type="text" name="nom" placeholder="Nom">
                <input type="text" name="prenom" placeholder="Prénom">
            </div>
            <input type="email" name="mail" placeholder="Email">
            <div class="form-row">
                <input type="password" name="motdepasse" placeholder="Saisir votre mot de passe">
                <input type="password" name="confmotdepasse" placeholder="Confirmez Mot de Passe">
            </div>
            <input type="submit" value="Envoyez">
        </form>
    </div>
</body>

</html>

