-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 07-06-2018 a las 21:16:58
-- Versión del servidor: 10.1.25-MariaDB
-- Versión de PHP: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `usuarios`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Tbl_Album`
--

CREATE TABLE `Tbl_Album` (
  `idalbum` int(11) NOT NULL,
  `album` varchar(50) NOT NULL,
  `fechalanzamiento` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `Tbl_Album`
--

INSERT INTO `Tbl_Album` (`idalbum`, `album`, `fechalanzamiento`) VALUES
(1, 'Curb', '01-09-1996'),
(2, 'The State', '07-03-2000'),
(3, 'Silver Side Up', '11-09-2001'),
(4, 'The Long Road', '23-09-2003'),
(5, 'All Right Reasons', '28-09-2005'),
(6, 'Dark Horse', '18-11-2008'),
(7, 'Here And Now', '21-11-2011'),
(8, 'No Fixed Address', '17-11-2014'),
(9, 'Feed the Machine', '05-09-2017');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Tbl_Cancion`
--

CREATE TABLE `Tbl_Cancion` (
  `idcancion` int(11) NOT NULL,
  `cancion` varchar(50) NOT NULL,
  `valoracion` int(11) DEFAULT NULL,
  `idalbum` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `Tbl_Cancion`
--

INSERT INTO `Tbl_Cancion` (`idcancion`, `cancion`, `valoracion`, `idalbum`) VALUES
(1, 'Little Friend', 3, 1),
(2, 'Pusher', 5, 1),
(3, 'Breathe', 3, 1),
(4, 'Detangler', 5, 1),
(5, 'Curb', 3, 1),
(6, 'Where?', 5, 1),
(7, 'Falls Back On', 3, 1),
(8, 'Sea Groove', 5, 1),
(9, 'Fly', 5, 1),
(10, 'Just Four', 5, 1),
(11, 'Window Shopper', 5, 1),
(12, 'I Don t Have', 5, 1),
(13, 'Little Friend', 3, 2),
(14, 'Cowboy Hat', 5, 2),
(15, 'Leader of Men', 3, 2),
(16, 'Old Enough', 5, 2),
(17, 'Worthy to Say', 3, 2),
(18, 'Diggin This', 5, 2),
(19, 'Deep', 3, 2),
(20, 'One Last Run', 5, 2),
(21, 'Not Leavin Yet', 5, 2),
(22, 'Hold Out Your Hand', 5, 2),
(23, 'Never Again', 3, 3),
(24, 'How Your Remind Me', 5, 3),
(25, 'Woke Up This Morning', 3, 3),
(26, 'Too Bad', 5, 3),
(27, 'Just For', 3, 3),
(28, 'Hollywood', 5, 3),
(29, 'Money Bought', 3, 3),
(30, 'Where Do I Hide', 5, 3),
(31, 'Hangnail', 5, 3),
(32, 'od Times ne', 5, 3),
(33, 'Hero', 5, 3),
(34, 'Flat on the Floor', 3, 4),
(35, 'Do This Anymore', 5, 4),
(36, 'Someday', 3, 4),
(37, 'Believe it or Not', 5, 4),
(38, 'Feelin\' Way Too Damn od', 3, 4),
(39, 'Because Of You', 5, 4),
(40, 'Figured You Out', 3, 4),
(41, 'Should\'ve Listened', 5, 4),
(42, 'Throw Yourself Away', 5, 4),
(43, 'Another Hole in the Head', 5, 4),
(44, 'See You at the Show', 5, 4),
(45, 'Follow You Home', 3, 5),
(46, 'Fight for All the Wrong Reasons', 5, 5),
(47, 'Photograph', 3, 5),
(48, 'Animals', 5, 5),
(49, 'Savin\' Me', 3, 5),
(50, 'Far Away', 5, 5),
(51, 'Next Contestant', 3, 5),
(52, 'Side of a Bullet', 5, 5),
(53, 'If Everyone Cared', 5, 5),
(54, 'Someone That You\'re With', 5, 5),
(55, 'Rockstar', 5, 5),
(56, 'Something in Your Mouth', 3, 6),
(57, 'Burn It to the Ground', 5, 6),
(58, 'tta Be Somebody', 3, 6),
(59, 'Next  Round', 3, 6),
(60, 'Just to Get High', 5, 6),
(61, 'Never nna Be Alone', 3, 6),
(62, 'Shakin\' Hands', 5, 6),
(63, 'S.E.X.', 5, 6),
(64, 'If Today Was Your Last Day', 5, 6),
(65, 'This Afternoon', 5, 6),
(66, 'This Means War', 3, 7),
(67, 'Bottoms Up', 5, 7),
(68, 'When We Stand Together', 3, 7),
(69, 'Midnight Queen', 5, 7),
(70, 'tta Get Me Some', 3, 7),
(71, 'Lullaby', 5, 7),
(72, 'Kiss It odbye', 3, 7),
(73, 'Trying Not to Love You', 5, 7),
(74, 'Holding on to Heaven', 5, 7),
(75, 'Everything I Wanna Do', 5, 7),
(76, 'Don\'t Ever Let It End', 5, 7),
(77, 'Million Miles an Hour', 3, 8),
(78, 'Edge of a Revolution', 5, 8),
(79, 'What Are You Waiting For?', 3, 8),
(80, 'She Keeps Me Up', 5, 8),
(81, 'Make Me Believe Again', 3, 8),
(82, 'Satellite', 5, 8),
(83, 'Get \'Em Up', 3, 8),
(84, 'The Hammer\'s Coming Down', 5, 8),
(85, 'Miss You', 5, 8),
(86, 't Me Runnin\' Round', 5, 8),
(87, 'Sister Sin', 5, 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `apellido` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `n_usuario` varchar(15) DEFAULT NULL,
  `c_usuario` varchar(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nombre`, `apellido`, `email`, `n_usuario`, `c_usuario`) VALUES
(1, 'Gustavo', 'Reque', 'GEduardo19RL94@gmail.com', 'GEduardoRL94', '123456'),
(2, 'Vinton', 'Cerf', 'test@gmail.com', 'vcerf', '123'),
(3, 'ntest', 'atest', 'test@gmail.com', 'test', '123'),
(4, 'ntest2', 'atest2', 'test2@gmail.com', 'test2', '123');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Tbl_Album`
--
ALTER TABLE `Tbl_Album`
  ADD PRIMARY KEY (`idalbum`);

--
-- Indices de la tabla `Tbl_Cancion`
--
ALTER TABLE `Tbl_Cancion`
  ADD PRIMARY KEY (`idcancion`),
  ADD KEY `FK_Cancion` (`idalbum`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Tbl_Album`
--
ALTER TABLE `Tbl_Album`
  MODIFY `idalbum` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT de la tabla `Tbl_Cancion`
--
ALTER TABLE `Tbl_Cancion`
  MODIFY `idcancion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=88;
--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `Tbl_Cancion`
--
ALTER TABLE `Tbl_Cancion`
  ADD CONSTRAINT `FK_Cancion` FOREIGN KEY (`idalbum`) REFERENCES `Tbl_Album` (`idalbum`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
