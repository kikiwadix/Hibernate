-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-03-2017 a las 19:24:17
-- Versión del servidor: 10.1.19-MariaDB
-- Versión de PHP: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hibernatefestival`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cantante`
--

CREATE TABLE `cantante` (
  `Id` int(11) NOT NULL,
  `Nombre` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `Visible` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `cantante`
--

INSERT INTO `cantante` (`Id`, `Nombre`, `Visible`) VALUES
(1, 'Enrique Bunbury', 1),
(2, 'Paul McCartney', 1),
(3, 'Angel Hernández', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cartel`
--

CREATE TABLE `cartel` (
  `Id` int(11) NOT NULL,
  `Festival` int(11) NOT NULL,
  `Grupo` int(11) NOT NULL,
  `Visible` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `cartel`
--

INSERT INTO `cartel` (`Id`, `Festival`, `Grupo`, `Visible`) VALUES
(1, 1, 1, 1),
(2, 1, 2, 1),
(3, 1, 3, 1),
(4, 2, 3, 1),
(5, 2, 1, 1),
(6, 1, 4, 1),
(7, 3, 4, 1),
(8, 3, 3, 0),
(9, 3, 2, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `festival`
--

CREATE TABLE `festival` (
  `Id` int(11) NOT NULL,
  `Nombre` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `Ciudad` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `Visible` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `festival`
--

INSERT INTO `festival` (`Id`, `Nombre`, `Ciudad`, `Visible`) VALUES
(1, 'Zaidin Festival', 'Granada', 1),
(2, 'SOS Festival', 'Murcia', 1),
(3, 'Hibernate Festival', 'Guadix', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grupo`
--

CREATE TABLE `grupo` (
  `Id` int(11) NOT NULL,
  `Nombre` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `GuitarraId` int(11) NOT NULL,
  `CantanteId` int(11) NOT NULL,
  `Visible` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `grupo`
--

INSERT INTO `grupo` (`Id`, `Nombre`, `GuitarraId`, `CantanteId`, `Visible`) VALUES
(1, 'SpanishGroup', 1, 1, 1),
(2, 'InternationalGroup', 2, 2, 1),
(3, 'CristoRey Band', 3, 3, 1),
(4, 'Los Albayzineros Metaleros', 4, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `guitarra`
--

CREATE TABLE `guitarra` (
  `Id` int(11) NOT NULL,
  `Nombre` varchar(100) CHARACTER SET utf32 COLLATE utf32_spanish2_ci NOT NULL,
  `Visible` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `guitarra`
--

INSERT INTO `guitarra` (`Id`, `Nombre`, `Visible`) VALUES
(1, 'Santi Campillo', 1),
(2, 'Santana', 1),
(3, 'Luis Serrano', 1),
(4, 'Paco De Lucía', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cantante`
--
ALTER TABLE `cantante`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `cartel`
--
ALTER TABLE `cartel`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `festival`
--
ALTER TABLE `festival`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `grupo`
--
ALTER TABLE `grupo`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `guitarra`
--
ALTER TABLE `guitarra`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cantante`
--
ALTER TABLE `cantante`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `cartel`
--
ALTER TABLE `cartel`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT de la tabla `festival`
--
ALTER TABLE `festival`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `grupo`
--
ALTER TABLE `grupo`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `guitarra`
--
ALTER TABLE `guitarra`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
