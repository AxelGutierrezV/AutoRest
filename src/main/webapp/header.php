<head>

    <link href="css/styles.css" rel="stylesheet" type="text/css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<div id="header">
    <nav class="navbar navbar-expand-lg bg-gradient-yellow cabecera">
        <div class="container">
            <a class="navbar-brand" href="main.php">
                <img src="img/logo resturante.png" alt="Bootstrap" width="130" height="80">
            </a>
        </div>
        <div class="container-fluid">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
                    aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse textoCabecera" id="navbarNavDropdown">
                <ul class="navbar-nav ">
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="main.php">Inicio</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Ordenes</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Comandas</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle active" href="#" role="button" data-bs-toggle="dropdown" aria-current="page" aria-expanded="false">Administración</a>
                        <ul class="dropdown-menu">
                            <li><a class="nav-link active"  aria-current="page" href="#">Empleados</a></li>
                            <a class="nav-link" href="platos.jsp">Platos</a>
                        </ul>
                    </li>
                </ul>
                <a href="login.php"><button class="btn btn-danger" type="submit">Cerrar Sesion</button></a>
            </div>
        </div>
    </nav>
</div>