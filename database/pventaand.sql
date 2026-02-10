-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-05-2023 a las 19:07:18
-- Versión del servidor: 8.0.32
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `pventaand`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `caja`
--

CREATE TABLE `caja` (
  `ID` varchar(6) NOT NULL,
  `Cantidad` double NOT NULL,
  `Fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `caja`
--

INSERT INTO `caja` (`ID`, `Cantidad`, `Fecha`) VALUES
('00012c', -568, '2023-05-15'),
('00328d', 0, '2023-05-16'),
('031cde', 0, '2023-05-15'),
('04ba6d', 0, '2023-05-17'),
('17d1ed', 54, '2023-05-15'),
('1bdd85', 80, '2023-05-17'),
('22a284', 56, '2023-05-15'),
('235ab1', 0, '2023-05-17'),
('267471', 194, '2023-05-15'),
('2be3d7', 236, '2023-05-15'),
('51be51', 0, '2023-05-16'),
('710a4e', 0, '2023-05-17'),
('7b2c64', 0, '2023-05-17'),
('97be0b', 0, '2023-05-11'),
('a3d10d', -123, '2023-05-17'),
('abbdc3', 140, '2023-05-15'),
('abc001', 1850.67, '2023-03-02'),
('abc002', 853, '2022-08-12'),
('abc003', 345, '2023-04-15'),
('abc004', 345, '2022-05-15'),
('abc005', 345, '2023-05-08'),
('cbbb58', 0, '2023-05-17'),
('ee5442', 0, '2023-05-15');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `garrafa`
--

CREATE TABLE `garrafa` (
  `ID` varchar(6) NOT NULL,
  `Cantidad` int NOT NULL,
  `Sabor` varchar(25) NOT NULL,
  `Tipo` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `garrafa`
--

INSERT INTO `garrafa` (`ID`, `Cantidad`, `Sabor`, `Tipo`) VALUES
('23f4e7', 5000, 'Ron con pasas', 'Helado'),
('26502b', 6128, 'Horchata', 'Agua'),
('38f0fd', 5000, 'Otro', 'Agua'),
('43d687', 5000, 'Yogurt de arandano', 'Helado'),
('48509e', 14000, 'Lima', 'Agua'),
('7b0f01', 13751, 'Chocolate ferrero', 'Helado'),
('8858b6', 2031, 'Limon', 'Helado'),
('8a5e9f', 13751, 'Cafe', 'Helado'),
('ab916a', 5000, 'Fresa agua', 'Helado'),
('add71d', 5000, 'Nuez', 'Helado'),
('c64f55', 5000, 'Rompope', 'Agua'),
('f8779c', 5000, 'Chocochip', 'Helado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `permiso`
--

CREATE TABLE `permiso` (
  `ID` int NOT NULL,
  `Tipo` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `permiso`
--

INSERT INTO `permiso` (`ID`, `Tipo`) VALUES
(1, 'Administrador'),
(2, 'Usuario'),
(3, 'Visitante');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `ID` varchar(6) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `ApellidoP` varchar(20) NOT NULL,
  `ApellidoM` varchar(20) NOT NULL,
  `fNac` date NOT NULL,
  `Telefono` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`ID`, `Nombre`, `ApellidoP`, `ApellidoM`, `fNac`, `Telefono`) VALUES
('488e53', 'dsfg', 'sdfg', 'sdfgsdfg', '2023-05-16', '3481380455'),
('4b6186', 'Administrador', 'Apat', 'Amat', '2004-08-26', '3481380455'),
('6ea378', 'Nombre', 'A Pat', 'A Mat', '1999-09-21', '1234567890'),
('ef345a', 'Jonathan', 'Tavares', 'Ascencio', '2003-08-21', '3481380455');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `ID` varchar(6) NOT NULL,
  `Nombre` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Precio` double NOT NULL,
  `Existencias` int DEFAULT NULL,
  `Tipo` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Gasto_Garrafa` int NOT NULL,
  `Estado` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`ID`, `Nombre`, `Precio`, `Existencias`, `Tipo`, `Gasto_Garrafa`, `Estado`) VALUES
('4255e1', 'Paleta chica', 9, 0, 'Paleta', 0, 1),
('456', 'Agua Grande', 25, 0, 'Agua', 1000, 0),
('46cbab', 'Malteada', 35, 0, 'Malteada', 680, 1),
('572ce7', 'Helado Cono', 22, 0, 'Helado', 249, 1),
('874dd2', 'Galleta', 2, 43, 'Otro', 0, 1),
('a0e32b', 'Paleta de agua grande', 18, 0, 'Paleta', 0, 1),
('db962a', 'Frappe', 35, 0, 'Otro', 0, 1),
('eb9a31', 'Agua chica', 15, 0, 'Agua', 375, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto_venta`
--

CREATE TABLE `producto_venta` (
  `ID` varchar(6) NOT NULL,
  `Producto` varchar(6) NOT NULL,
  `Ventas` varchar(6) NOT NULL,
  `Cantidad` int NOT NULL,
  `Sabor` varchar(6) DEFAULT NULL,
  `Total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `producto_venta`
--

INSERT INTO `producto_venta` (`ID`, `Producto`, `Ventas`, `Cantidad`, `Sabor`, `Total`) VALUES
('073721', '572ce7', '1045c1', 1, '144f82', 27),
('1be5d0', '46cbab', '5547a6', 3, '144f82', 105),
('1ee1dd', '874dd2', '8ec8ea', 6, NULL, 12),
('23d328', '572ce7', 'e7ba04', 1, '144f82', 22),
('26ba50', 'db962a', '134a33', 4, NULL, 140),
('310705', 'a0e32b', 'e40686', 1, '249ee0', 34),
('321817', '4255e1', '240353', 1, '249ee0', 9),
('3562cb', 'a0e32b', '2d9236', 2, '249ee0', 36),
('3a166b', '46cbab', 'b690ea', 2, '5836c1', 70),
('429285', 'a0e32b', '65da27', 3, '636d90', 54),
('508336', '572ce7', '2d9236', 4, '144f82', 88),
('50c85c', '46cbab', 'bbdc5d', 3, '5836c1', 105),
('6788c8', '572ce7', 'd7602d', 2, '5836c1', 44),
('69096c', '46cbab', '243ba9', 4, '144f82', 140),
('78ab02', '572ce7', '93cc0c', 1, '5836c1', 45),
('79d5b3', '572ce7', 'e40686', 1, '144f82', 43),
('850872', '46cbab', '240353', 2, '57b280', 70),
('95966d', '46cbab', 'a39e5c', 4, 'ab34c2', 140),
('9a51d8', '572ce7', '258ed3', 5, '5836c1', 110),
('a3b111', '572ce7', '240353', 1, '144f82', 22),
('a780d0', 'a0e32b', 'bbdc5d', 4, '249ee0', 72),
('ad739b', '46cbab', 'e40686', 3, '57b280', 105),
('b68948', 'a0e32b', 'e7ba04', 2, '249ee0', 36),
('bba20c', 'a0e32b', 'a39e5c', 3, '636d90', 54),
('c7b151', '874dd2', 'e7ba04', 3, NULL, 6),
('c7ec49', '572ce7', '8ec8ea', 2, '144f82', 44),
('c7ed14', 'db962a', '65da27', 3, NULL, 105),
('d769d8', '572ce7', '134a33', 3, '5836c1', 66),
('e19392', 'a0e32b', '1bdbb0', 3, 'fbd14e', 54),
('e66a4a', '4255e1', '5547a6', 5, 'fbd14e', 45);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sabor`
--

CREATE TABLE `sabor` (
  `ID` varchar(6) NOT NULL,
  `Sabor` varchar(30) NOT NULL,
  `Tipo` varchar(10) NOT NULL,
  `Garrafa` varchar(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `sabor`
--

INSERT INTO `sabor` (`ID`, `Sabor`, `Tipo`, `Garrafa`) VALUES
('0ef063', 'Lima', 'Agua', '48509e'),
('144f82', 'Chocolate ferrero', 'Helado', '7b0f01'),
('249ee0', 'Piña', 'Paleta', NULL),
('57b280', 'Ron con pasas', 'Helado', '26502b'),
('5836c1', 'Café', 'Helado', '8a5e9f'),
('636d90', 'Limon', 'Paleta', NULL),
('665d60', 'Rompope', 'Agua', 'c64f55'),
('76d348', 'Horchata', 'Agua', '26502b'),
('ab34c2', 'Limon', 'Helado', '8858b6'),
('fbd14e', 'Guayaba', 'Paleta', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ticket`
--

CREATE TABLE `ticket` (
  `ID` varchar(6) NOT NULL,
  `Venta` varchar(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `ID` varchar(6) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Nombre` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Permiso` int DEFAULT NULL,
  `Persona` varchar(6) DEFAULT NULL,
  `Estado` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`ID`, `Password`, `Nombre`, `Permiso`, `Persona`, `Estado`) VALUES
('23ab3c', 'Jony3721', 'Jony Admin', 1, 'ef345a', 1),
('247dc7', 'sdf', 'fsdfg', 2, '4b6186', 0),
('32843b', '1234', 'Nombre', 3, '6ea378', 0),
('ceb9b2', 'asd', 'Usuario', 2, '4b6186', 1),
('e7b2e3', 'Hola mundo', 'Hola mundo', 3, '4b6186', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `ID` varchar(6) NOT NULL,
  `Total` double NOT NULL,
  `Usuario` varchar(6) NOT NULL,
  `Caja` varchar(6) NOT NULL,
  `Fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`ID`, `Total`, `Usuario`, `Caja`, `Fecha`) VALUES
('1045c1', 27, '23ab3c', '97be0b', '2023-05-14'),
('134a33', 206, '23ab3c', '22a284', '2023-05-15'),
('1bdbb0', 54, '23ab3c', '17d1ed', '2023-05-15'),
('240353', 101, '23ab3c', '04ba6d', '2023-05-17'),
('243ba9', 140, '23ab3c', 'abbdc3', '2023-05-15'),
('258ed3', 110, '23ab3c', '00012c', '2023-05-15'),
('2d9236', 124, '23ab3c', '97be0b', '2023-05-14'),
('5547a6', 150, '23ab3c', 'ee5442', '2023-05-15'),
('5b4654', -120, '23ab3c', '1bdd85', '2023-05-17'),
('65da27', 159, '23ab3c', '97be0b', '2023-05-14'),
('7974a8', -150, '23ab3c', '22a284', '2023-05-15'),
('7e1839', 100, '23ab3c', '2be3d7', '2023-05-15'),
('8ec8ea', 56, '23ab3c', '97be0b', '2023-05-14'),
('93cc0c', 44.99999999999999, '23ab3c', 'a3d10d', '2023-05-17'),
('a39e5c', 194, '23ab3c', '267471', '2023-05-15'),
('b690ea', 70, '23ab3c', '97be0b', '2023-05-15'),
('b846a2', -41, '23ab3c', '2be3d7', '2023-05-15'),
('bbdc5d', 177, '23ab3c', '2be3d7', '2023-05-15'),
('bcc111', 200, '23ab3c', '1bdd85', '2023-05-17'),
('d7602d', 44, '23ab3c', '2be3d7', '2023-05-15'),
('e40686', 182, '23ab3c', '97be0b', '2023-05-14'),
('e7ba04', 64, '23ab3c', '97be0b', '2023-05-14'),
('ec52d8', -168, '23ab3c', 'a3d10d', '2023-05-17');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `caja`
--
ALTER TABLE `caja`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `garrafa`
--
ALTER TABLE `garrafa`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `permiso`
--
ALTER TABLE `permiso`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `producto_venta`
--
ALTER TABLE `producto_venta`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Ventas` (`Ventas`),
  ADD KEY `Producto` (`Producto`),
  ADD KEY `Sabor` (`Sabor`);

--
-- Indices de la tabla `sabor`
--
ALTER TABLE `sabor`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Garrafa` (`Garrafa`);

--
-- Indices de la tabla `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Venta` (`Venta`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Persona` (`Persona`),
  ADD KEY `Permiso` (`Permiso`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Caja` (`Caja`),
  ADD KEY `Usuario` (`Usuario`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `producto_venta`
--
ALTER TABLE `producto_venta`
  ADD CONSTRAINT `producto_venta_ibfk_1` FOREIGN KEY (`Ventas`) REFERENCES `ventas` (`ID`),
  ADD CONSTRAINT `producto_venta_ibfk_2` FOREIGN KEY (`Producto`) REFERENCES `producto` (`ID`),
  ADD CONSTRAINT `producto_venta_ibfk_3` FOREIGN KEY (`Sabor`) REFERENCES `sabor` (`ID`);

--
-- Filtros para la tabla `sabor`
--
ALTER TABLE `sabor`
  ADD CONSTRAINT `sabor_ibfk_1` FOREIGN KEY (`Garrafa`) REFERENCES `garrafa` (`ID`);

--
-- Filtros para la tabla `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`Venta`) REFERENCES `ventas` (`ID`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`Persona`) REFERENCES `persona` (`ID`),
  ADD CONSTRAINT `usuario_ibfk_2` FOREIGN KEY (`Permiso`) REFERENCES `permiso` (`ID`);

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`Caja`) REFERENCES `caja` (`ID`),
  ADD CONSTRAINT `ventas_ibfk_2` FOREIGN KEY (`Usuario`) REFERENCES `usuario` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
