<html>

<body>

    <div class="container">
        <h1>Lunette</h1>
        <form action="ajouterlunettebdd.php" method="post" enctype="multipart/form-data">
            <div class="form-row">
            <label for="nom">Nom des lunettes</label><input type="text" name="nom" id="nom">
            <label for="prix">Prix </label><input type="text" name="prix" id="prix">
            <label for="image">Image : </label><input type="file" name="image" id="image" accept="image/png, image/gif, image/jpeg">
            <label for="couleur">couleur</label><input type="text" name="couleur" id="couleur">
            <label for="marque">marque</label><input type="text" name="marque" id="marque">
            
            </div>
    
            <button type="submit">Ajouter </button>
    </div>
    </form>
    </div>
</body>

</html>