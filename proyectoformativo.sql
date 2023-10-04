-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-10-2023 a las 15:07:33
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyectoformativo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `almacen`
--

CREATE TABLE `almacen` (
  `idAlmacen` int(11) NOT NULL,
  `fechaAlmacen` date NOT NULL,
  `documentoEncargado` varchar(45) NOT NULL,
  `nombreEncargado` varchar(45) NOT NULL,
  `horaEntrada` time NOT NULL,
  `Objeto_idObjeto` int(11) NOT NULL,
  `Persona_idPersona` int(11) NOT NULL,
  `horaSalida` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `almacen`
--

INSERT INTO `almacen` (`idAlmacen`, `fechaAlmacen`, `documentoEncargado`, `nombreEncargado`, `horaEntrada`, `Objeto_idObjeto`, `Persona_idPersona`, `horaSalida`) VALUES
(1, '2023-10-03', '1231', 'Josue', '11:15:00', 1, 2, '23:15:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `computador`
--

CREATE TABLE `computador` (
  `idComputador` int(11) NOT NULL,
  `marcaComputador` varchar(45) NOT NULL,
  `colorComputador` varchar(45) NOT NULL,
  `complementoComputador` varchar(45) NOT NULL,
  `Persona_idPersona` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `computador`
--

INSERT INTO `computador` (`idComputador`, `marcaComputador`, `colorComputador`, `complementoComputador`, `Persona_idPersona`) VALUES
(1, 'Hp', 'Blanco', 'Completo', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `objeto`
--

CREATE TABLE `objeto` (
  `idObjeto` int(11) NOT NULL,
  `descripcionObjeto` varchar(45) NOT NULL,
  `cantidadObjeto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `objeto`
--

INSERT INTO `objeto` (`idObjeto`, `descripcionObjeto`, `cantidadObjeto`) VALUES
(1, 'Memoria USB', 201);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `idPersona` int(11) NOT NULL,
  `tipoDocumento` varchar(45) NOT NULL,
  `documentoPersona` varchar(45) NOT NULL,
  `nombrePersona` varchar(45) NOT NULL,
  `telefonoPersona` varchar(45) NOT NULL,
  `rolPersona` varchar(45) NOT NULL,
  `correoPersona` varchar(45) NOT NULL,
  `contraseñaPersona` varbinary(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`idPersona`, `tipoDocumento`, `documentoPersona`, `nombrePersona`, `telefonoPersona`, `rolPersona`, `correoPersona`, `contraseñaPersona`) VALUES
(1, 'Cedula de Ciudadania', '1234', 'Nicolas', '123132', 'Celador', 'nico@gmail.com', 0x2432612431302473356d396c6f714a4733344e713363474132365964653369524b6a6d31587a473056757131676375566a754e4d344e783939617143),
(2, 'Cedula de Ciudadania', '12345', 'Juan', '12312', 'Encargado', 'juan@gmail.com', 0x24326124313024532e2f6333496642792f6e6548762e68564b304f742e684a416c7a3465636c4d544e4f4e6e704b4e4831697634596b375169385161);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recepcion`
--

CREATE TABLE `recepcion` (
  `idRecepcion` int(11) NOT NULL,
  `fechaRecepcion` date NOT NULL,
  `documentoCelador` varchar(45) NOT NULL,
  `nombreCelador` varchar(45) NOT NULL,
  `horaEntrada` time NOT NULL,
  `Computador_idComputador` int(11) NOT NULL,
  `horaSalida` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `recepcion`
--

INSERT INTO `recepcion` (`idRecepcion`, `fechaRecepcion`, `documentoCelador`, `nombreCelador`, `horaEntrada`, `Computador_idComputador`, `horaSalida`) VALUES
(6, '2023-10-03', '12312', 'Juan', '11:12:00', 1, '12:00:16');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `almacen`
--
ALTER TABLE `almacen`
  ADD PRIMARY KEY (`idAlmacen`,`Objeto_idObjeto`,`Persona_idPersona`),
  ADD KEY `fk_Almacen_Objeto1_idx` (`Objeto_idObjeto`),
  ADD KEY `fk_Almacen_Persona1_idx` (`Persona_idPersona`);

--
-- Indices de la tabla `computador`
--
ALTER TABLE `computador`
  ADD PRIMARY KEY (`idComputador`),
  ADD KEY `fk_Computador_Persona1_idx` (`Persona_idPersona`);

--
-- Indices de la tabla `objeto`
--
ALTER TABLE `objeto`
  ADD PRIMARY KEY (`idObjeto`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`idPersona`);

--
-- Indices de la tabla `recepcion`
--
ALTER TABLE `recepcion`
  ADD PRIMARY KEY (`idRecepcion`),
  ADD KEY `fk_Recepcion_Computador1_idx` (`Computador_idComputador`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `almacen`
--
ALTER TABLE `almacen`
  MODIFY `idAlmacen` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `computador`
--
ALTER TABLE `computador`
  MODIFY `idComputador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `objeto`
--
ALTER TABLE `objeto`
  MODIFY `idObjeto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `idPersona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `recepcion`
--
ALTER TABLE `recepcion`
  MODIFY `idRecepcion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `almacen`
--
ALTER TABLE `almacen`
  ADD CONSTRAINT `fk_Almacen_Objeto1` FOREIGN KEY (`Objeto_idObjeto`) REFERENCES `objeto` (`idObjeto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Almacen_Persona1` FOREIGN KEY (`Persona_idPersona`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `computador`
--
ALTER TABLE `computador`
  ADD CONSTRAINT `fk_Computador_Persona1` FOREIGN KEY (`Persona_idPersona`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `recepcion`
--
ALTER TABLE `recepcion`
  ADD CONSTRAINT `fk_Recepcion_Computador1` FOREIGN KEY (`Computador_idComputador`) REFERENCES `computador` (`idComputador`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
