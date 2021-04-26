-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: progetto_finale
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country` (
  `code` varchar(2) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES ('AD','Andorra'),('AE','Emirati Arabi Uniti'),('AF','Afghanistan'),('AG','Antigua e Barbuda'),('AI','Anguilla'),('AL','Albania'),('AM','Armenia'),('AO','Angola'),('AQ','Antartide'),('AR','Argentina'),('AS','Samoa americane'),('AT','Austria'),('AU','Australia'),('AW','Aruba'),('AX','Isole Åland'),('AZ','Azerbaigian'),('BA','Bosnia ed Erzegovina'),('BB','Barbados'),('BD','Bangladesh'),('BE','Belgio'),('BF','Burkina Faso'),('BG','Bulgaria'),('BH','Bahrein'),('BI','Burundi'),('BJ','Benin'),('BL','Saint-Barthélemy'),('BM','Bermuda'),('BN','Brunei'),('BO','Bolivia'),('BQ','Caraibi olandesi'),('BR','Brasile'),('BS','Bahamas'),('BT','Bhutan'),('BV','Isola Bouvet'),('BW','Botswana'),('BY','Bielorussia'),('BZ','Belize'),('CA','Canada'),('CC','Isole Cocos (Keeling)'),('CD','Congo - Kinshasa'),('CF','Repubblica Centrafricana'),('CG','Congo-Brazzaville'),('CH','Svizzera'),('CI','Costa d’Avorio'),('CK','Isole Cook'),('CL','Cile'),('CM','Camerun'),('CN','Cina'),('CO','Colombia'),('CR','Costa Rica'),('CU','Cuba'),('CV','Capo Verde'),('CW','Curaçao'),('CX','Isola Christmas'),('CY','Cipro'),('CZ','Cechia'),('DE','Germania'),('DJ','Gibuti'),('DK','Danimarca'),('DM','Dominica'),('DO','Repubblica Dominicana'),('DZ','Algeria'),('EC','Ecuador'),('EE','Estonia'),('EG','Egitto'),('EH','Sahara occidentale'),('ER','Eritrea'),('ES','Spagna'),('ET','Etiopia'),('FI','Finlandia'),('FJ','Figi'),('FK','Isole Falkland'),('FM','Micronesia'),('FO','Isole Fær Øer'),('FR','Francia'),('GA','Gabon'),('GB','Regno Unito'),('GD','Grenada'),('GE','Georgia'),('GF','Guyana francese'),('GG','Guernsey'),('GH','Ghana'),('GI','Gibilterra'),('GL','Groenlandia'),('GM','Gambia'),('GN','Guinea'),('GP','Guadalupa'),('GQ','Guinea Equatoriale'),('GR','Grecia'),('GS','Georgia del Sud e Sandwich australi'),('GT','Guatemala'),('GU','Guam'),('GW','Guinea-Bissau'),('GY','Guyana'),('HK','RAS di Hong Kong'),('HM','Isole Heard e McDonald'),('HN','Honduras'),('HR','Croazia'),('HT','Haiti'),('HU','Ungheria'),('ID','Indonesia'),('IE','Irlanda'),('IL','Israele'),('IM','Isola di Man'),('IN','India'),('IO','Territorio britannico dell’Oceano Indiano'),('IQ','Iraq'),('IR','Iran'),('IS','Islanda'),('IT','Italia'),('JE','Jersey'),('JM','Giamaica'),('JO','Giordania'),('JP','Giappone'),('KE','Kenya'),('KG','Kirghizistan'),('KH','Cambogia'),('KI','Kiribati'),('KM','Comore'),('KN','Saint Kitts e Nevis'),('KP','Corea del Nord'),('KR','Corea del Sud'),('KW','Kuwait'),('KY','Isole Cayman'),('KZ','Kazakistan'),('LA','Laos'),('LB','Libano'),('LC','Saint Lucia'),('LI','Liechtenstein'),('LK','Sri Lanka'),('LR','Liberia'),('LS','Lesotho'),('LT','Lituania'),('LU','Lussemburgo'),('LV','Lettonia'),('LY','Libia'),('MA','Marocco'),('MC','Monaco'),('MD','Moldavia'),('ME','Montenegro'),('MF','Saint Martin'),('MG','Madagascar'),('MH','Isole Marshall'),('MK','Macedonia del Nord'),('ML','Mali'),('MM','Myanmar (Birmania)'),('MN','Mongolia'),('MO','RAS di Macao'),('MP','Isole Marianne settentrionali'),('MQ','Martinica'),('MR','Mauritania'),('MS','Montserrat'),('MT','Malta'),('MU','Mauritius'),('MV','Maldive'),('MW','Malawi'),('MX','Messico'),('MY','Malaysia'),('MZ','Mozambico'),('NA','Namibia'),('NC','Nuova Caledonia'),('NE','Niger'),('NF','Isola Norfolk'),('NG','Nigeria'),('NI','Nicaragua'),('NL','Paesi Bassi'),('NO','Norvegia'),('NP','Nepal'),('NR','Nauru'),('NU','Niue'),('NZ','Nuova Zelanda'),('OM','Oman'),('PA','Panamá'),('PE','Perù'),('PF','Polinesia francese'),('PG','Papua Nuova Guinea'),('PH','Filippine'),('PK','Pakistan'),('PL','Polonia'),('PM','Saint-Pierre e Miquelon'),('PN','Isole Pitcairn'),('PR','Portorico'),('PS','Territori palestinesi'),('PT','Portogallo'),('PW','Palau'),('PY','Paraguay'),('QA','Qatar'),('RE','Riunione'),('RO','Romania'),('RS','Serbia'),('RU','Russia'),('RW','Ruanda'),('SA','Arabia Saudita'),('SB','Isole Salomone'),('SC','Seychelles'),('SD','Sudan'),('SE','Svezia'),('SG','Singapore'),('SH','Sant’Elena'),('SI','Slovenia'),('SJ','Svalbard e Jan Mayen'),('SK','Slovacchia'),('SL','Sierra Leone'),('SM','San Marino'),('SN','Senegal'),('SO','Somalia'),('SR','Suriname'),('SS','Sud Sudan'),('ST','São Tomé e Príncipe'),('SV','El Salvador'),('SX','Sint Maarten'),('SY','Siria'),('SZ','Swaziland'),('TC','Isole Turks e Caicos'),('TD','Ciad'),('TF','Terre australi francesi'),('TG','Togo'),('TH','Thailandia'),('TJ','Tagikistan'),('TK','Tokelau'),('TL','Timor Est'),('TM','Turkmenistan'),('TN','Tunisia'),('TO','Tonga'),('TR','Turchia'),('TT','Trinidad e Tobago'),('TV','Tuvalu'),('TW','Taiwan'),('TZ','Tanzania'),('UA','Ucraina'),('UG','Uganda'),('UM','Altre isole americane del Pacifico'),('US','Stati Uniti'),('UY','Uruguay'),('UZ','Uzbekistan'),('VA','Città del Vaticano'),('VC','Saint Vincent e Grenadine'),('VE','Venezuela'),('VG','Isole Vergini Britanniche'),('VI','Isole Vergini Americane'),('VN','Vietnam'),('VU','Vanuatu'),('WF','Wallis e Futuna'),('WS','Samoa'),('YE','Yemen'),('YT','Mayotte'),('ZA','Sudafrica'),('ZM','Zambia'),('ZW','Zimbabwe');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-15 17:29:14
