-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 31-05-2023 a las 12:58:31
-- Versión del servidor: 10.4.19-MariaDB
-- Versión de PHP: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `crowfunding`
--
CREATE DATABASE IF NOT EXISTS `upofunding` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `upofunding`;
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `donacion`
--

CREATE TABLE `donacion` (
  `idDonacion` int(50) NOT NULL PRIMARY KEY,
  `idUsuario` int(50) NOT NULL,
  `idProyecto` int(50) NOT NULL,
  `idONG` int(50) NOT NULL,
  `cantidad` int(255) NOT NULL,
  `metodoPago` varchar(1000) NOT NULL,
  `fechaEmision` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `evento`
--

CREATE TABLE `evento` (
  `idEvento` int(50) NOT NULL PRIMARY KEY,
  `nombre` varchar(1000) NOT NULL,
  `idTipo` int(50) NOT NULL,
  `pais` varchar(1000) NOT NULL,
  `localidad` varchar(1000) NOT NULL,
  `direccion` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inversion`
--

CREATE TABLE `inversion` (
  `idInversion` int(50) NOT NULL PRIMARY KEY,
  `IdUsuario` int(50) NOT NULL,
  `cantidad` int(255) NOT NULL,
  `metodoPago` varchar(1000) NOT NULL,
  `idProyecto` int(50) NOT NULL,
  `idEvento` int(50) NOT NULL,
  `fechaEmision` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyecto`
--

CREATE TABLE `proyecto` (
  `idProyecto` int(50) NOT NULL PRIMARY KEY,
  `nombreProyecto` varchar(1000) NOT NULL,
  `idUsuario` int(50) NOT NULL,
  `meta` int(255) NOT NULL,
  `fechaInicio` date NOT NULL,
  `fechaFin` date NOT NULL,
  `descripcion` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `solidaria`
--

CREATE TABLE `solidaria` (
  `idONG` int(50) NOT NULL PRIMARY KEY,
  `nombre` varchar(1000) NOT NULL,
  `pais` varchar(1000) NOT NULL,
  `localidad` varchar(1000) NOT NULL,
  `provincia` varchar(1000) NOT NULL,
  `descripcion` varchar(1000) NOT NULL,
  `direccion` varchar(1000) NOT NULL,
  `idProyecto` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo`
--

CREATE TABLE `tipo` (
  `idTipo` int(50) NOT NULL PRIMARY KEY,
  `nombreTipo` varchar(1000) NOT NULL,
  `porcentajeTipo` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(50) NOT NULL PRIMARY KEY,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `dni` int(10) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `telefono` int(13) NOT NULL,
  `contrasena` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `donacion`
--
ALTER TABLE `donacion`
  ADD CONSTRAINT idDon FOREIGN KEY (idUsuario) REFERENCES usuario (idUsuario),
  ADD CONSTRAINT idProyecto FOREIGN KEY (idProyecto) REFERENCES proyecto (idProyecto),
  ADD CONSTRAINT idONG FOREIGN KEY (idONG) REFERENCES solidaria (idONG);

--
-- Indices de la tabla `evento`
--
ALTER TABLE `evento`
  ADD CONSTRAINT idTipo FOREIGN KEY (idTipo) REFERENCES tipo (idTipo);

--
-- Indices de la tabla `inversion`
--
ALTER TABLE `inversion`
  ADD CONSTRAINT idInver FOREIGN KEY (idUsuario) REFERENCES usuario (idUsuario),
  ADD CONSTRAINT idEvento FOREIGN KEY (idEvento) REFERENCES evento (idEvento);

--
-- Indices de la tabla `proyecto`
--
ALTER TABLE `proyecto`
  ADD CONSTRAINT idUsuario FOREIGN KEY (idUsuario) REFERENCES usuario (idUsuario);


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
