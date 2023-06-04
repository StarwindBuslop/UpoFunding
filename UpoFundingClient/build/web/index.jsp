<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>OB Crowdfunding</title>
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
            transition: margin-left 0.3s ease-in-out;
        }

        .contact-button {
            float: right;
            padding: 10px;
            margin-left: 10px;
            transition: margin-left 0.3s ease-in-out;
        }

        .navbar a:last-child {
            margin-right: 0;
        }

        .navbar a:nth-last-child(2):hover ~ .logout-button {
            margin-left: 120px;
        }

        .navbar a:nth-last-child(2):hover ~ .contact-button {
            margin-left: 120px;
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

    <h1>Bienvenido a OB Crowdfunding</h1>
    

</body>
</html>
