<?php
include('bdd.php');
if (isset($_POST['nom']) and isset($_POST['prix']) and isset($_POST['couleur']) and isset($_POST['marque']) and isset($_FILES['image']) and $_FILES['image']['error'] == 0) {
    if ($_FILES['image']['size'] <= 1000000) {
        $fileInfo = pathinfo($_FILES['image']['name']);
        $extension = $fileInfo['extension'];
        $extensions = ['jpg', 'jpeg', 'gif', 'png'];
        if (in_array($extension, $extensions)) {
            $time = time();
            $chemin = 'images/' . $time . '.' . $extension;
            move_uploaded_file($_FILES['image']['tmp_name'], $chemin);  
        }
    }

    $stmt = $bdd->prepare("INSERT INTO Lunette (Nom,Image,Prix,couleur,Marque) VALUES(:nom,:image,:prix,:couleur,:marque);");
    $stmt->execute([
        "nom"=>$_POST['nom'],
        "prix"=>$_POST['prix'],
        "image"=>$chemin,
        "couleur"=>$_POST['couleur'],
        "marque"=>$_POST['marque'],
    ]
        
    );

header('location:admin.php');
}
 