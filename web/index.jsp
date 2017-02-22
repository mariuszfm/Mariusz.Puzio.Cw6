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
        <form action="showBase.jsp">
            <input type="submit" value="Pokaz zawartosc bazy" />
        </form>
        <h3>2.</h3>
        <form action="Add" method="POST">
            <input type="submit" value="Dodaj nowe dzieło" name="chooseArt" />
        </form>
    </body>
</html>
