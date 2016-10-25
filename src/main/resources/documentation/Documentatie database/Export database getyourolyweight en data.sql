-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Gegenereerd op: 25 okt 2016 om 21:01
-- Serverversie: 10.1.16-MariaDB
-- PHP-versie: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `getyourolyweight`
--

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `atlete`
--

CREATE TABLE `atlete` (
  `FirstName` varchar(100) NOT NULL,
  `LastName` varchar(100) NOT NULL,
  `Email` varchar(200) NOT NULL,
  `ScheduleID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `atlete`
--

INSERT INTO `atlete` (`FirstName`, `LastName`, `Email`, `ScheduleID`) VALUES
('Ad', 'de Vries', 'ad@test.nl', NULL),
('Bram', 'Test', 'bram@avans.nl', NULL),
('Kees', 'Jansen', 'kjansen@avans.nl', NULL),
('Lucie', 'Test', 'lucie@avans.nl', NULL),
('Mark', 'de Vries', 'mark@test.nl', NULL),
('Mark', 'Test', 'mtest@avans.nl', NULL),
('Romy', 'Ceuleers', 'rlceulee@avans.nl', 0);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `exercise`
--

CREATE TABLE `exercise` (
  `ExerciseID` varchar(11) NOT NULL,
  `ExerciseName` varchar(30) NOT NULL,
  `SkillID` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `exercise`
--

INSERT INTO `exercise` (`ExerciseID`, `ExerciseName`, `SkillID`) VALUES
('C1', 'Cleanpull', 'CJ'),
('C2', 'Frontsquat', 'CJ'),
('C3', 'Clean en Jerk', 'CJ'),
('S1', 'Snatchpull', 'SN'),
('S2', 'Backsquat', 'SN'),
('S3', 'Snatch', 'SN');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `schedulecleanjerk`
--

CREATE TABLE `schedulecleanjerk` (
  `ScheduleCJID` int(11) NOT NULL,
  `Email` varchar(60) NOT NULL,
  `FrontSquat` int(11) NOT NULL,
  `CleanJerkGoalWeight` int(11) NOT NULL,
  `CleanJerkGoalDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `schedulecleanjerk`
--

INSERT INTO `schedulecleanjerk` (`ScheduleCJID`, `Email`, `FrontSquat`, `CleanJerkGoalWeight`, `CleanJerkGoalDate`) VALUES
(1, 'rlceulee@avans.nl', 90, 85, '2016-11-30'),
(2, 'mtest@avans.nl', 110, 90, '2016-11-30'),
(3, 'kjansen@avans.nl', 100, 85, '2017-01-31'),
(4, 'rlceulee@avans.nl', 90, 80, '2016-07-30');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `schedulesnatch`
--

CREATE TABLE `schedulesnatch` (
  `ScheduleSnatchID` int(11) NOT NULL,
  `Email` varchar(60) NOT NULL,
  `BackSquat` int(11) NOT NULL,
  `SnatchGoalWeight` int(11) NOT NULL,
  `SnatchGoalDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `schedulesnatch`
--

INSERT INTO `schedulesnatch` (`ScheduleSnatchID`, `Email`, `BackSquat`, `SnatchGoalWeight`, `SnatchGoalDate`) VALUES
(5, 'lucie@avans.nl', 100, 70, '2016-11-30'),
(24, 'kjansen@avans.nl', 200, 110, '2016-12-31'),
(25, 'lucie@avans.nl', 90, 50, '2016-12-31'),
(26, 'rlceulee@avans.nl', 120, 65, '2016-11-30'),
(28, 'mark@test.nl', 100, 60, '2016-11-30'),
(38, 'rlceulee@avans.nl', 90, 85, '2016-11-30');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `skill`
--

CREATE TABLE `skill` (
  `SkillID` varchar(11) NOT NULL,
  `SkillName` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `skill`
--

INSERT INTO `skill` (`SkillID`, `SkillName`) VALUES
('CJ', 'Clean & Jerk'),
('SN', 'Snatch');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `week`
--

CREATE TABLE `week` (
  `WeekID` varchar(11) NOT NULL,
  `Percentage` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `week`
--

INSERT INTO `week` (`WeekID`, `Percentage`) VALUES
('W1', 75),
('W2', 85),
('W3', 95),
('W4', 100);

--
-- Indexen voor geëxporteerde tabellen
--

--
-- Indexen voor tabel `atlete`
--
ALTER TABLE `atlete`
  ADD PRIMARY KEY (`Email`);

--
-- Indexen voor tabel `exercise`
--
ALTER TABLE `exercise`
  ADD PRIMARY KEY (`ExerciseID`);

--
-- Indexen voor tabel `schedulecleanjerk`
--
ALTER TABLE `schedulecleanjerk`
  ADD PRIMARY KEY (`ScheduleCJID`,`Email`);

--
-- Indexen voor tabel `schedulesnatch`
--
ALTER TABLE `schedulesnatch`
  ADD PRIMARY KEY (`ScheduleSnatchID`,`Email`);

--
-- Indexen voor tabel `skill`
--
ALTER TABLE `skill`
  ADD PRIMARY KEY (`SkillID`);

--
-- Indexen voor tabel `week`
--
ALTER TABLE `week`
  ADD PRIMARY KEY (`WeekID`);

--
-- AUTO_INCREMENT voor geëxporteerde tabellen
--

--
-- AUTO_INCREMENT voor een tabel `schedulecleanjerk`
--
ALTER TABLE `schedulecleanjerk`
  MODIFY `ScheduleCJID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT voor een tabel `schedulesnatch`
--
ALTER TABLE `schedulesnatch`
  MODIFY `ScheduleSnatchID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
