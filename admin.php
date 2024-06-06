<?php
    include 'bdd.php';

?>
<?php require ('bst.php');
    ?>


<?php
    $result = $bdd->query('SELECT * FROM Lunette');
    $Lunettes = $result->fetchAll(PDO::FETCH_OBJ);
    ?><a href="ajouterlunette.php"><input type="button" value="Ajouter Lunette"></a> <?php
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
                <a href="supprimerlunette.php?id=<?php echo $Lunette->id; ?>" class="btn btn-primary">Supprimer lunette</a>

            </div>
        </div>
        <?php

    }
    ?>