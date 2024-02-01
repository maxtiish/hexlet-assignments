@import gg.jte.Content
@param Content content

<!doctype html>
<html lang="en">
    <head>
        <meta charset="untf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <title>My first layout</title>
    </head>
    <body>
        <header>
            <a href="/">Main page</a>
            <a href="/users">Users</a>
        </header>
        <div class ="content">
            ${content}
        </div>
        <footer>
            Nothing
        </footer>
    </body>
</html>