<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Galeria sztuki</title>
    </head>
    <body>
        <h1>Galeria sztuki</h1>
        <h2>Wybierz jedna z opcji:</h2>
        <h3>1.</h3>
        <form action="Show" method="POST">
            <input type="submit" value="Pokaz wszytkie dzieła" name="showArts" />
        </form>
        <h3>2.</h3>
        <form action="Show" method="POST">
            <input type="submit" value="Pokaz wszystkich twórców" name="showCreators" />
        </form>
        <h3>3.</h3>
        <form action="Show" method="POST">
            <input type="submit" value="Pokaz wszystkie kategorie" name="showCategories" />
        </form>
    </body>
</html>
