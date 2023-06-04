<%-- 
    Document   : index
    Created on : 02-jun-2023, 17:35:19
    Author     : Garrido
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="login.css"  type="text/css">
        <style>

        </style>
    </head>
    <body>
        <div id="contenedor">
            <div id="central">
                <div id="login">
                    <div class="titulo">
                        Bienvenido
                    </div>
                    <form id="loginform">
                        <input type="text" name="usuario" placeholder="Usuario" required>

                        <input type="password" placeholder="Contraseña" name="password" required>

                        <button type="submit" title="Ingresar" name="Ingresar">Login</button>
                    </form>
                    <div class="pie-form">
                        <a href="registro.jsp">¿No tienes Cuenta? Registrate</a>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
