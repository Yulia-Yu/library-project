<html lang="en">
<head>
    <link rel="stylesheet" href="/authors.css", type="text/css">
</head>
<body>
    <div class="table-container">
        <ul class="table">
            <li class="table-header">
                <div class="col col-1">ID</div>
                <div class="col col-2">Name</div>
                <div class="col col-3">Surname</div>
            </li>

            <#list authors as author>
                <li class="table-row">
                    <div class="col col-1">${author.id}</div>
                    <div class="col col-2">${author.name}</div>
                    <div class="col col-3">${author.surname}</div>
                </li>
            </#list>

        <ul>
    </div>
</body>
</html>