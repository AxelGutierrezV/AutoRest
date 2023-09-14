<nav class="navbar navbar-expand-lg bg-body-primary cabecera">
    <div class="container">
        <a class="navbar-brand" href="#">
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
                    <a class="nav-link active" aria-current="page" href="#">Ordenes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Comandas</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Administración</a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">Empleados</a></li>
                        <li><a class="dropdown-item" href="#">Perfiles</a></li>
                        <li class="nav item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Platos</a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="#">Empleados</a></li>
                                <li><a class="dropdown-item" href="#">Perfiles</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>

            </ul>
            <a href="login.html"><button class="btn btn-danger" type="submit">Cerrar Sesion</button></a>
        </div>
    </div>
</nav>