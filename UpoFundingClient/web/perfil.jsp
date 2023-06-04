<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Perfil - OB Crowdfunding</title>
    <style>
        body {
            padding-top: 50px;
        }

        .navbar {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            background-color: #333;
            z-index: 100;
        }

        .navbar a {
            color: white;
            text-align: center;
            padding: 10px;
            text-decoration: none;
            font-size: 17px;
            float: left;
            margin-left: 10px;
        }

        .navbar a:hover {
            background-color: #ddd;
            color: black;
        }

        .company-name {
            font-size: 14px;
            float: left;
            padding: 10px;
            color: white;
            margin-left: 20px;
        }

        .logout-button {
            float: right;
            padding: 10px;
            margin-left: 10px;
        }

        .contact-button {
            float: right;
            padding: 10px;
        }

        .profile-info {
            width: 400px;
            margin: 100px auto;
            padding: 20px;
            background-color: #f2f2f2;
            border-radius: 10px;
            text-align: center;
        }

        .profile-info h2 {
            margin-bottom: 20px;
        }

        .profile-info p {
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
    <div class="navbar">
        <div class="company-name">
            OB Crowdfunding
        </div>
        <a href="index.jsp">Inicio</a>
        <a href="ong.jsp">Participaciones</a>
        <a href="perfil.jsp">Perfil</a>
        <a href="logout.jsp" class="logout-button">Cerrar sesión</a>
        <a href="contacto.jsp" class="contact-button">Contacto</a>
    </div>

    <div class="profile-info">
        <h2>Información de usuario</h2>
        <p><strong>Nombre:</strong> <%= request.getSession().getAttribute("nombre") %></p>
        <p><strong>Apellidos:</strong> <%= request.getSession().getAttribute("apellidos") %></p>
        <p><strong>DNI:</strong> <%= request.getSession().getAttribute("dni") %></p>
        <p><strong>Correo:</strong> <%= request.getSession().getAttribute("correo") %></p>
        <p><strong>Teléfono:</strong> <%= request.getSession().getAttribute("telefono") %></p>
    </div>
</body>
</html>
