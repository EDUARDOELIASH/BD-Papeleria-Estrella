-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 29, 2021 at 06:57 AM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 7.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `papeleria_estrella`
--
CREATE DATABASE IF NOT EXISTS `papeleria_estrella` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `papeleria_estrella`;

-- --------------------------------------------------------

--
-- Table structure for table `cliente`
--

CREATE TABLE `cliente` (
  `Numero_Cl` int(11) NOT NULL,
  `Nombre_Cl` varchar(50) DEFAULT NULL,
  `Telefono_Cl` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cliente`
--

INSERT INTO `cliente` (`Numero_Cl`, `Nombre_Cl`, `Telefono_Cl`) VALUES
(0, NULL, NULL),
(1, 'Elias Gijon Vazquez', '8995062750'),
(2, 'Mario Hernandez Salazar', '8997052718'),
(3, 'Luciana Melendes Coronado', '8995067546'),
(4, 'Federico Gonzales Herrera', '8993075645'),
(5, 'Jose Luis Masias Rueda', '8996072445'),
(6, 'Pedro Medina', '8993974800'),
(7, 'Carlos Cortes', '8996340908'),
(8, 'Martin Vazquez', '8998540910'),
(9, 'Ramiro Gomez', '8997548907'),
(10, 'Maria Hernandez', '8991542635'),
(11, 'Ana Garza', '8998451526'),
(12, 'Josue Villareal', '8996589584'),
(13, 'Mario', '8991920000'),
(14, 'Enrique', '8990000001'),
(15, 'Betsaida', '8990232323'),
(16, 'Jocabed', '8999234523'),
(17, 'Sarai', 'null'),
(18, 'Fernando', 'null'),
(19, 'Rodolfo', '8995456532'),
(20, 'Mario', '5545645485');

--
-- Triggers `cliente`
--
DELIMITER $$
CREATE TRIGGER `ultimo_Numero_Cl` AFTER INSERT ON `cliente` FOR EACH ROW BEGIN
UPDATE ultimas_claves_secuenciales set Numero_Cl = new.Numero_Cl;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `cliente_venta`
--

CREATE TABLE `cliente_venta` (
  `Codigo_V` varchar(8) DEFAULT NULL,
  `Numero_Cl` int(11) DEFAULT NULL,
  `Importe_V` double DEFAULT NULL,
  `Cambio_V` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cliente_venta`
--

INSERT INTO `cliente_venta` (`Codigo_V`, `Numero_Cl`, `Importe_V`, `Cambio_V`) VALUES
('V1', 1, 100, 54),
('V2', 2, 20, 0),
('V3', 3, 100, 32),
('V4', 4, 50, 7),
('V5', 5, 50, 30),
('V6', 6, 200, 62),
('V7', 7, 100, 25),
('V8', 8, 100, 13),
('V9', 9, 100, 45),
('V10', 10, 100, 42),
('V11', 11, 200, 157),
('V14', 14, 200, 35),
('V15', 0, 50, 5);

-- --------------------------------------------------------

--
-- Table structure for table `producto`
--

CREATE TABLE `producto` (
  `Codigo_P` varchar(11) NOT NULL,
  `NOMBRE_P` varchar(50) DEFAULT NULL,
  `Existencia_P` int(11) DEFAULT NULL,
  `Precio_P` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `producto`
--

INSERT INTO `producto` (`Codigo_P`, `NOMBRE_P`, `Existencia_P`, `Precio_P`) VALUES
('0', NULL, 0, 0),
('13111300755', 'DIST. FOMI 20 * 30 cm', 139, 5),
('13111308525', 'PLACA UNICEL 25*25*2 CM', 15, 10),
('14111606L21', 'PAPEL CASCARON 1/2 56*70 CM', 7, 19),
('14111616333', 'PAPEL LUSTRINA LUSTRE BANDERA', 18, 8),
('24111503066', 'BOLSA CAMISETA MEDIANA', 3, 29),
('41111604014', 'REGLA PLASTICO BACO 30CM', 23, 6),
('60121121418', 'PAPEL CARTULINA IMP. FLUOR ROSA 48*66 CM', 4, 9),
('60141001012', 'GLOBO PAYASO SURTIDO', 235, 6),
('60141001015', 'GLOBO DECORATOR#9 COLOR BLANCO', 145, 6),
('60141001022', 'GLOBO DECORATOR#9 COLOR NEGRO', 90, 6);

-- --------------------------------------------------------

--
-- Table structure for table `producto_venta`
--

CREATE TABLE `producto_venta` (
  `Codigo_V` varchar(8) DEFAULT NULL,
  `Codigo_P` varchar(11) DEFAULT NULL,
  `Cantidad_P` int(11) DEFAULT NULL,
  `Venta_Registrada` bit(1) DEFAULT NULL,
  `ExistenciaMod` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `producto_venta`
--

INSERT INTO `producto_venta` (`Codigo_V`, `Codigo_P`, `Cantidad_P`, `Venta_Registrada`, `ExistenciaMod`) VALUES
('V1', '60141001012', 5, b'1', b'1'),
('V1', '14111616333', 2, b'1', b'1'),
('V10', '14111606L21', 2, b'1', b'1'),
('V11', '60121121418', 2, b'1', b'1'),
('V14', '13111308525', 12, b'1', b'1'),
('V2', '0', 0, b'1', b'1'),
('V3', '60121121418', 2, b'1', b'1'),
('V3', '60141001015', 5, b'1', b'1'),
('V4', '14111606L21', 1, b'1', b'1'),
('V5', '0', 0, b'1', b'1'),
('V6', '60121121418', 2, b'1', b'1'),
('V6', '60141001022', 10, b'1', b'1'),
('V6', '13111308525', 3, b'1', b'1'),
('V9', '13111300755', 5, b'1', b'1'),
('V7', '60141001012', 10, b'1', b'1'),
('V8', '41111604014', 2, b'1', b'1');

--
-- Triggers `producto_venta`
--
DELIMITER $$
CREATE TRIGGER `Act_Existencia_P` AFTER INSERT ON `producto_venta` FOR EACH ROW BEGIN
UPDATE producto SET Existencia_P = Existencia_P - producto_venta.new.cantidad_P WHERE producto.Codigo_P = producto_venta.new.Codigo_P;
UPDATE producto_venta SET Existencia_Mod = 1 WHERE producto_venta.Codigo_P = producto_venta.new.Codigo_P AND producto_venta.Codigo_V = producto_venta.new.Codigo_V;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `proveedor`
--

CREATE TABLE `proveedor` (
  `Codigo_Pro` varchar(6) NOT NULL,
  `Nombre_Pro` varchar(50) DEFAULT NULL,
  `Direccion_Pro` varchar(50) DEFAULT NULL,
  `No_Tel_Pro` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `proveedor`
--

INSERT INTO `proveedor` (`Codigo_Pro`, `Nombre_Pro`, `Direccion_Pro`, `No_Tel_Pro`) VALUES
('0', NULL, NULL, NULL),
('123', 'proveedor1', '8990022343', 'null'),
('1546', 'Proveedor4', '8995456565', 'Calle ff'),
('ABAH1', 'ABASTECEDORA DE MERCERIAS, S.A DE C.V.', 'BLVD HIDALGO 1675 LOC 2B REYNOSA, TAMPS', '8999241224'),
('afd', 'Proveedor2', '8996542132', 'Callef #45'),
('asd', 'proveedor1', '23', '34'),
('CGR6Y3', 'COMERCIAL GARZA REYNA, S.A. DE C.V.', '5 FEBRERO 516 SAN RICARDO, REYNOSA TAMAULIPAS', '8180042000'),
('INID9', 'Inix Comercial, S.A. de C.V.', 'MARIANO MATAMOROS NO. 304, COL. TLALPAN', '8991287265'),
('JUAG0', 'JUAN ANTELMO MARTINEZ MARTINEZ', 'PUEBLA 214 SOLIDARIDAD, REYNOSA', '8991287265'),
('MARFM4', 'MAR DISTRIBUIDORES', 'TLAXCALA 99 SOLIDARIDAD, REYNOSA TAMAULIPAS', '8991287265'),
('null', 'null', 'null', 'null');

-- --------------------------------------------------------

--
-- Table structure for table `proveedor_productos`
--

CREATE TABLE `proveedor_productos` (
  `Codigo_P` varchar(11) DEFAULT NULL,
  `Codigo_Pro` varchar(6) DEFAULT NULL,
  `Fecha_C` date DEFAULT NULL,
  `Cantidad_C` int(11) DEFAULT NULL,
  `Precio_C` double DEFAULT NULL,
  `Total_C` double DEFAULT NULL,
  `ExistenciaMod` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `proveedor_productos`
--

INSERT INTO `proveedor_productos` (`Codigo_P`, `Codigo_Pro`, `Fecha_C`, `Cantidad_C`, `Precio_C`, `Total_C`, `ExistenciaMod`) VALUES
('13111300755', 'ABAH1', '2020-12-17', 144, 1.117, 168.8, b'1'),
('13111308525', 'CGR6Y3', '2020-10-20', 10, 2.15, 21.5, b'1'),
('13111308525', 'CGR6Y3', '2020-12-20', 10, 2.5, 25, b'1'),
('13111308525', 'CGR6Y3', '2020-12-23', 10, 2.5, 25, b'1'),
('14111606L21', 'CGR6Y3', '2020-10-20', 10, 8.33, 83.3, b'1'),
('14111616333', 'CGR6Y3', '2020-10-20', 20, 1.6, 32.1, b'1'),
('24111503066', 'JUAG0', '2020-11-08', 3, 25.03, 75.09, b'1'),
('41111604014', 'CGR6Y3', '2020-11-27', 25, 2.43, 60.9, b'1'),
('60121121418', 'CGR6Y3', '2020-10-20', 10, 3.65, 36.5, b'1'),
('60141001012', 'ABAH1', '2020-11-07', 250, 0.56, 140, b'1'),
('60141001015', 'MARFM4', '2020-11-07', 150, 0.56, 84, b'1'),
('60141001022', 'MARFM4', '2020-11-07', 100, 0.56, 56, b'1');

-- --------------------------------------------------------

--
-- Table structure for table `servicio`
--

CREATE TABLE `servicio` (
  `Codigo_S` varchar(4) NOT NULL,
  `Nombre_S` varchar(50) DEFAULT NULL,
  `Precio_S` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `servicio`
--

INSERT INTO `servicio` (`Codigo_S`, `Nombre_S`, `Precio_S`) VALUES
('0', NULL, 0),
('CDLU', 'CORTE DE LETRAS DE UNICEL', 20),
('DCCS', 'DECORACIONES', 15),
('ENVT', 'ENVOLTURAS DE REGALO', 15),
('LLDG', 'LLENADO DE GLOBOS/C HELIO', 75),
('MNLD', 'MANUALIDADES, ETC', 25),
('MPFI', 'MARCO PARA FOTO INFANTILES DE UNICEL', 50),
('MQTA', 'ELABORACION DE MAQUETA', 10),
('SCBN', 'COPIAS BLANCO Y NEGRO', 2),
('SCCO', 'COPIAS A COLOR', 5),
('SENG', 'ENGARGOLADO', 10),
('SENM', 'ENMICADO', 12);

-- --------------------------------------------------------

--
-- Table structure for table `servicio_venta`
--

CREATE TABLE `servicio_venta` (
  `Codigo_V` varchar(8) DEFAULT NULL,
  `Codigo_S` varchar(4) DEFAULT NULL,
  `Cantidad_S` int(11) DEFAULT NULL,
  `Ventas_S_Registrada` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `servicio_venta`
--

INSERT INTO `servicio_venta` (`Codigo_V`, `Codigo_S`, `Cantidad_S`, `Ventas_S_Registrada`) VALUES
('V1', '0', 0, b'0'),
('V10', 'SCCO', 4, b'0'),
('V11', 'MNLD', 1, b'0'),
('V14', 'ENVT', 3, b'0'),
('V2', 'SCBN', 5, b'0'),
('V2', 'SCCO', 2, b'0'),
('V3', 'SENG', 2, b'0'),
('V3', '0', 0, b'0'),
('V4', 'SENM', 2, b'0'),
('V5', 'SCCO', 4, b'0'),
('V6', '0', 0, b'0'),
('V6', 'ENVT', 2, b'0'),
('V7', 'ENVT', 1, b'0'),
('V8', 'LLDG', 1, b'0'),
('V9', 'SENG', 3, b'0');

-- --------------------------------------------------------

--
-- Table structure for table `ultimas_claves_secuenciales`
--

CREATE TABLE `ultimas_claves_secuenciales` (
  `Codigo_V` varchar(8) DEFAULT NULL,
  `Numero_Cl` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ultimas_claves_secuenciales`
--

INSERT INTO `ultimas_claves_secuenciales` (`Codigo_V`, `Numero_Cl`) VALUES
('V15', 20);

-- --------------------------------------------------------

--
-- Table structure for table `venta`
--

CREATE TABLE `venta` (
  `Codigo_V` varchar(8) NOT NULL,
  `Fecha_V` date DEFAULT NULL,
  `Total_V` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `venta`
--

INSERT INTO `venta` (`Codigo_V`, `Fecha_V`, `Total_V`) VALUES
('V1', '2020-11-11', 46),
('V10', '2020-12-19', 58),
('V11', '2020-12-20', 43),
('V14', '2021-02-12', 165),
('V15', '2021-05-28', 45),
('V2', '2020-11-11', 20),
('V3', '2020-11-12', 68),
('V4', '2020-11-12', 43),
('V5', '2020-11-13', 20),
('V6', '2020-11-13', 138),
('V7', '2020-12-17', 75),
('V8', '2020-12-18', 87),
('V9', '2020-12-19', 55);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`Numero_Cl`),
  ADD KEY `Nombre_Cl` (`Nombre_Cl`);

--
-- Indexes for table `cliente_venta`
--
ALTER TABLE `cliente_venta`
  ADD KEY `FK_Codigo_Venta_CV` (`Codigo_V`),
  ADD KEY `FK_Numero_Cliente_CV` (`Numero_Cl`);

--
-- Indexes for table `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`Codigo_P`),
  ADD KEY `NOMBRE_P` (`NOMBRE_P`);

--
-- Indexes for table `producto_venta`
--
ALTER TABLE `producto_venta`
  ADD KEY `FK_Codigo_Venta_PV` (`Codigo_V`),
  ADD KEY `FK_Codigo_Producto_PV` (`Codigo_P`);

--
-- Indexes for table `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`Codigo_Pro`),
  ADD KEY `Nombre_Pro` (`Nombre_Pro`);

--
-- Indexes for table `proveedor_productos`
--
ALTER TABLE `proveedor_productos`
  ADD KEY `FK_Codigo_Proveedor_PP` (`Codigo_Pro`),
  ADD KEY `FK_Codigo_Producto_PP` (`Codigo_P`);

--
-- Indexes for table `servicio`
--
ALTER TABLE `servicio`
  ADD PRIMARY KEY (`Codigo_S`),
  ADD KEY `Nombre_S` (`Nombre_S`);

--
-- Indexes for table `servicio_venta`
--
ALTER TABLE `servicio_venta`
  ADD KEY `FK_Codigo_Venta_SV` (`Codigo_V`),
  ADD KEY `FK_Codigo_Servicio_SV` (`Codigo_S`);

--
-- Indexes for table `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`Codigo_V`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cliente_venta`
--
ALTER TABLE `cliente_venta`
  ADD CONSTRAINT `FK_Codigo_Venta_CV` FOREIGN KEY (`Codigo_V`) REFERENCES `venta` (`Codigo_V`),
  ADD CONSTRAINT `FK_Numero_Cliente_CV` FOREIGN KEY (`Numero_Cl`) REFERENCES `cliente` (`Numero_Cl`);

--
-- Constraints for table `producto_venta`
--
ALTER TABLE `producto_venta`
  ADD CONSTRAINT `FK_Codigo_Producto_PV` FOREIGN KEY (`Codigo_P`) REFERENCES `producto` (`Codigo_P`),
  ADD CONSTRAINT `FK_Codigo_Venta_PV` FOREIGN KEY (`Codigo_V`) REFERENCES `venta` (`Codigo_V`);

--
-- Constraints for table `proveedor_productos`
--
ALTER TABLE `proveedor_productos`
  ADD CONSTRAINT `FK_Codigo_Producto_PP` FOREIGN KEY (`Codigo_P`) REFERENCES `producto` (`Codigo_P`),
  ADD CONSTRAINT `FK_Codigo_Proveedor_PP` FOREIGN KEY (`Codigo_Pro`) REFERENCES `proveedor` (`Codigo_Pro`);

--
-- Constraints for table `servicio_venta`
--
ALTER TABLE `servicio_venta`
  ADD CONSTRAINT `FK_Codigo_Servicio_SV` FOREIGN KEY (`Codigo_S`) REFERENCES `servicio` (`Codigo_S`),
  ADD CONSTRAINT `FK_Codigo_Venta_SV` FOREIGN KEY (`Codigo_V`) REFERENCES `venta` (`Codigo_V`);
--
-- Database: `phpmyadmin`
--
CREATE DATABASE IF NOT EXISTS `phpmyadmin` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `phpmyadmin`;

-- --------------------------------------------------------

--
-- Table structure for table `pma__bookmark`
--

CREATE TABLE `pma__bookmark` (
  `id` int(10) UNSIGNED NOT NULL,
  `dbase` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `user` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `label` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `query` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Bookmarks';

-- --------------------------------------------------------

--
-- Table structure for table `pma__central_columns`
--

CREATE TABLE `pma__central_columns` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_type` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_length` text COLLATE utf8_bin DEFAULT NULL,
  `col_collation` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_isNull` tinyint(1) NOT NULL,
  `col_extra` varchar(255) COLLATE utf8_bin DEFAULT '',
  `col_default` text COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Central list of columns';

-- --------------------------------------------------------

--
-- Table structure for table `pma__column_info`
--

CREATE TABLE `pma__column_info` (
  `id` int(5) UNSIGNED NOT NULL,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `column_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `comment` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `mimetype` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `transformation` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `transformation_options` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `input_transformation` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `input_transformation_options` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Column information for phpMyAdmin';

-- --------------------------------------------------------

--
-- Table structure for table `pma__designer_settings`
--

CREATE TABLE `pma__designer_settings` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `settings_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Settings related to Designer';

-- --------------------------------------------------------

--
-- Table structure for table `pma__export_templates`
--

CREATE TABLE `pma__export_templates` (
  `id` int(5) UNSIGNED NOT NULL,
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `export_type` varchar(10) COLLATE utf8_bin NOT NULL,
  `template_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `template_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Saved export templates';

-- --------------------------------------------------------

--
-- Table structure for table `pma__favorite`
--

CREATE TABLE `pma__favorite` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `tables` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Favorite tables';

-- --------------------------------------------------------

--
-- Table structure for table `pma__history`
--

CREATE TABLE `pma__history` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `username` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `timevalue` timestamp NOT NULL DEFAULT current_timestamp(),
  `sqlquery` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='SQL history for phpMyAdmin';

-- --------------------------------------------------------

--
-- Table structure for table `pma__navigationhiding`
--

CREATE TABLE `pma__navigationhiding` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `item_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `item_type` varchar(64) COLLATE utf8_bin NOT NULL,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Hidden items of navigation tree';

-- --------------------------------------------------------

--
-- Table structure for table `pma__pdf_pages`
--

CREATE TABLE `pma__pdf_pages` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `page_nr` int(10) UNSIGNED NOT NULL,
  `page_descr` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='PDF relation pages for phpMyAdmin';

-- --------------------------------------------------------

--
-- Table structure for table `pma__recent`
--

CREATE TABLE `pma__recent` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `tables` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Recently accessed tables';

-- --------------------------------------------------------

--
-- Table structure for table `pma__relation`
--

CREATE TABLE `pma__relation` (
  `master_db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `master_table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `master_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Relation table';

-- --------------------------------------------------------

--
-- Table structure for table `pma__savedsearches`
--

CREATE TABLE `pma__savedsearches` (
  `id` int(5) UNSIGNED NOT NULL,
  `username` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `search_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `search_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Saved searches';

-- --------------------------------------------------------

--
-- Table structure for table `pma__table_coords`
--

CREATE TABLE `pma__table_coords` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `pdf_page_number` int(11) NOT NULL DEFAULT 0,
  `x` float UNSIGNED NOT NULL DEFAULT 0,
  `y` float UNSIGNED NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table coordinates for phpMyAdmin PDF output';

-- --------------------------------------------------------

--
-- Table structure for table `pma__table_info`
--

CREATE TABLE `pma__table_info` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `display_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table information for phpMyAdmin';

-- --------------------------------------------------------

--
-- Table structure for table `pma__table_uiprefs`
--

CREATE TABLE `pma__table_uiprefs` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `prefs` text COLLATE utf8_bin NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Tables'' UI preferences';

-- --------------------------------------------------------

--
-- Table structure for table `pma__tracking`
--

CREATE TABLE `pma__tracking` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `version` int(10) UNSIGNED NOT NULL,
  `date_created` datetime NOT NULL,
  `date_updated` datetime NOT NULL,
  `schema_snapshot` text COLLATE utf8_bin NOT NULL,
  `schema_sql` text COLLATE utf8_bin DEFAULT NULL,
  `data_sql` longtext COLLATE utf8_bin DEFAULT NULL,
  `tracking` set('UPDATE','REPLACE','INSERT','DELETE','TRUNCATE','CREATE DATABASE','ALTER DATABASE','DROP DATABASE','CREATE TABLE','ALTER TABLE','RENAME TABLE','DROP TABLE','CREATE INDEX','DROP INDEX','CREATE VIEW','ALTER VIEW','DROP VIEW') COLLATE utf8_bin DEFAULT NULL,
  `tracking_active` int(1) UNSIGNED NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Database changes tracking for phpMyAdmin';

-- --------------------------------------------------------

--
-- Table structure for table `pma__userconfig`
--

CREATE TABLE `pma__userconfig` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `timevalue` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `config_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='User preferences storage for phpMyAdmin';

--
-- Dumping data for table `pma__userconfig`
--

INSERT INTO `pma__userconfig` (`username`, `timevalue`, `config_data`) VALUES
('root', '2021-05-26 22:38:12', '{\"Console\\/Mode\":\"show\",\"Console\\/Height\":80.98599999999999}');

-- --------------------------------------------------------

--
-- Table structure for table `pma__usergroups`
--

CREATE TABLE `pma__usergroups` (
  `usergroup` varchar(64) COLLATE utf8_bin NOT NULL,
  `tab` varchar(64) COLLATE utf8_bin NOT NULL,
  `allowed` enum('Y','N') COLLATE utf8_bin NOT NULL DEFAULT 'N'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='User groups with configured menu items';

-- --------------------------------------------------------

--
-- Table structure for table `pma__users`
--

CREATE TABLE `pma__users` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `usergroup` varchar(64) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Users and their assignments to user groups';

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pma__bookmark`
--
ALTER TABLE `pma__bookmark`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pma__central_columns`
--
ALTER TABLE `pma__central_columns`
  ADD PRIMARY KEY (`db_name`,`col_name`);

--
-- Indexes for table `pma__column_info`
--
ALTER TABLE `pma__column_info`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `db_name` (`db_name`,`table_name`,`column_name`);

--
-- Indexes for table `pma__designer_settings`
--
ALTER TABLE `pma__designer_settings`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `pma__export_templates`
--
ALTER TABLE `pma__export_templates`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `u_user_type_template` (`username`,`export_type`,`template_name`);

--
-- Indexes for table `pma__favorite`
--
ALTER TABLE `pma__favorite`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `pma__history`
--
ALTER TABLE `pma__history`
  ADD PRIMARY KEY (`id`),
  ADD KEY `username` (`username`,`db`,`table`,`timevalue`);

--
-- Indexes for table `pma__navigationhiding`
--
ALTER TABLE `pma__navigationhiding`
  ADD PRIMARY KEY (`username`,`item_name`,`item_type`,`db_name`,`table_name`);

--
-- Indexes for table `pma__pdf_pages`
--
ALTER TABLE `pma__pdf_pages`
  ADD PRIMARY KEY (`page_nr`),
  ADD KEY `db_name` (`db_name`);

--
-- Indexes for table `pma__recent`
--
ALTER TABLE `pma__recent`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `pma__relation`
--
ALTER TABLE `pma__relation`
  ADD PRIMARY KEY (`master_db`,`master_table`,`master_field`),
  ADD KEY `foreign_field` (`foreign_db`,`foreign_table`);

--
-- Indexes for table `pma__savedsearches`
--
ALTER TABLE `pma__savedsearches`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `u_savedsearches_username_dbname` (`username`,`db_name`,`search_name`);

--
-- Indexes for table `pma__table_coords`
--
ALTER TABLE `pma__table_coords`
  ADD PRIMARY KEY (`db_name`,`table_name`,`pdf_page_number`);

--
-- Indexes for table `pma__table_info`
--
ALTER TABLE `pma__table_info`
  ADD PRIMARY KEY (`db_name`,`table_name`);

--
-- Indexes for table `pma__table_uiprefs`
--
ALTER TABLE `pma__table_uiprefs`
  ADD PRIMARY KEY (`username`,`db_name`,`table_name`);

--
-- Indexes for table `pma__tracking`
--
ALTER TABLE `pma__tracking`
  ADD PRIMARY KEY (`db_name`,`table_name`,`version`);

--
-- Indexes for table `pma__userconfig`
--
ALTER TABLE `pma__userconfig`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `pma__usergroups`
--
ALTER TABLE `pma__usergroups`
  ADD PRIMARY KEY (`usergroup`,`tab`,`allowed`);

--
-- Indexes for table `pma__users`
--
ALTER TABLE `pma__users`
  ADD PRIMARY KEY (`username`,`usergroup`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pma__bookmark`
--
ALTER TABLE `pma__bookmark`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pma__column_info`
--
ALTER TABLE `pma__column_info`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pma__export_templates`
--
ALTER TABLE `pma__export_templates`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pma__history`
--
ALTER TABLE `pma__history`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pma__pdf_pages`
--
ALTER TABLE `pma__pdf_pages`
  MODIFY `page_nr` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pma__savedsearches`
--
ALTER TABLE `pma__savedsearches`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- Database: `test`
--
CREATE DATABASE IF NOT EXISTS `test` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `test`;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
