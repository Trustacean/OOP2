/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 5.5.55-log : Database - perpus
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`perpus` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `perpus`;

/*Table structure for table `buku` */

DROP TABLE IF EXISTS `buku`;

CREATE TABLE `buku` (
  `id_koleksi` varchar(9) NOT NULL,
  `judul` varchar(50) NOT NULL,
  `penerbit` varchar(20) NOT NULL,
  `status_pinjam` tinyint(1) NOT NULL,
  `halaman` int(11) NOT NULL,
  `isbn` varchar(12) NOT NULL,
  PRIMARY KEY (`id_koleksi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `buku` */

insert  into `buku`(`id_koleksi`,`judul`,`penerbit`,`status_pinjam`,`halaman`,`isbn`) values 
('B56789','Algoritma dan Pemrograman','Informatika',1,770,'6021514917'),
('B56790','Pemrograman C dan C plus plus','Informatika',1,290,'8221514787'),
('B56791','Algoritma dan Pemrograman','Informatika',1,770,'6021514917'),
('B56792','Pemrograman Berbasis Mobile Android Studio','Deepublish',1,550,'978602401672'),
('B56793','Konsep dan Implementasi Pemrograman Laravel 7','Lokomedia',1,665,'986024014917'),
('B56794','Pemrograman Mikrokontroler AVR Assembly dan C','Media Online',1,780,'235648514917'),
('B56795','Esensi Bahasa Pemrograman Java','Kodebuku',0,770,'68948775215');

/*Table structure for table `datiltransaksi` */

DROP TABLE IF EXISTS `datiltransaksi`;

CREATE TABLE `datiltransaksi` (
  `id_transaksi` varchar(12) DEFAULT NULL,
  `id_koleksi` varchar(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `datiltransaksi` */

/*Table structure for table `dosen` */

DROP TABLE IF EXISTS `dosen`;

CREATE TABLE `dosen` (
  `id_peminjam` varchar(9) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `mak_pinjam` int(11) NOT NULL,
  `nip` varchar(16) NOT NULL,
  PRIMARY KEY (`id_peminjam`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `dosen` */

insert  into `dosen`(`id_peminjam`,`nama`,`alamat`,`mak_pinjam`,`nip`) values 
('D123','Sujadmiko Raharjo','Jl. Kembang Arum no.123 Condongcatur',5,'19820325007'),
('D124','Bagong Ahmadi','Jl. Proklamasi no.13 Caturtunggal',5,'19800305012'),
('D125','Yohanes Supangat','Jl. Ayam Jantan no.23X Maguwo Hardjo',5,'19781225001'),
('D126','Alberta Sri Sumini','Jl. Segi Tiga no.M88 Pakem',5,'19730321006'),
('D127','John Sabar Menanti','Gg. Kapuas no.L12 Mancasan Kidul',5,'19990909009'),
('D128','Ayu Setianing Sekar','Jl. Achmad Yani no.55 Blok I Komplek Kembang Jaya',6,'19880818018'),
('D129','Citra Jesica Indah','Jl. Pinus 5 no. 2 Cassa Grande',5,'19850520003'),
('D130','Antonius Suparman','Jl. Kantil 5 no. 352 Condongcatur',5,'19850520007');

/*Table structure for table `dvd` */

DROP TABLE IF EXISTS `dvd`;

CREATE TABLE `dvd` (
  `id_koleksi` varchar(9) NOT NULL,
  `judul` varchar(50) NOT NULL,
  `penerbit` varchar(20) NOT NULL,
  `status_pinjam` tinyint(1) NOT NULL,
  `format` varchar(10) NOT NULL,
  `isbn` varchar(12) NOT NULL,
  PRIMARY KEY (`id_koleksi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `dvd` */

insert  into `dvd`(`id_koleksi`,`judul`,`penerbit`,`status_pinjam`,`format`,`isbn`) values 
('D12345','Legendary Toefl Test Of English','Sealova Media',1,'MP4','9799483530'),
('D12346','Getting To Yes','Gramedia Pustaka',1,'DVD','978979227193'),
('D12347','Cumsumer Behavior Hoyer Macinnis','Mc GrawHill',1,'MP4','978032483427'),
('D12348','Men Are from Mars Women Are from Venus','Andi Offset',0,'BLUERAY','978602037521'),
('D12349','The Ancient Chinese Wisdom Sc','Tiga Serangkai',1,'MP4','978979291827'),
('D12350','The Art of War ','Pustaka Karya',1,'MP4','978602033465'),
('D12351','X-Men Mutant Genesis 2.0 HC','Wiley Press',1,'CDAUDIO','978078516589');

/*Table structure for table `mahasiswa` */

DROP TABLE IF EXISTS `mahasiswa`;

CREATE TABLE `mahasiswa` (
  `id_peminjam` varchar(9) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `mak_pinjam` int(11) NOT NULL,
  `nim` varchar(16) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `mahasiswa` */

insert  into `mahasiswa`(`id_peminjam`,`nama`,`alamat`,`mak_pinjam`,`nim`) values 
('M2015','Rafael Mahesa Putra','Jl. Sawo Matang no.133 Condongcatur',3,'205314077'),
('M2016','Justino Ardian Suban Baolangu','Gg. Kosan Indah Paingan Maguwoharjo',3,'205314079'),
('M2017','Gabriel Advent Batan','Gg. Programming no.1010 Desa Java',3,'205314096'),
('M2018','Mario Richard Paulo Yamlean','Jl. Apache Netbeans no.12B Oracle Black Street 5th',3,'205314104'),
('M2019','Katrina Yuliana Kartika','Gg. Inheritance no.77 Desa Object Oriented II',4,'205314099'),
('M2020','Marcelia Putri Supriosa','Jl. Graphical User Interface no.1 Kampung Java',3,'205314075'),
('M2021','Bernadetha Mega Devina A','Gg. Exception Personal no.2X Wall of Error II ',4,'195314058'),
('M2022','Yohanes Dani Adipta','Gg. Eterna Marvel no.1 Boliwood India',4,'195314068');

/*Table structure for table `majalah` */

DROP TABLE IF EXISTS `majalah`;

CREATE TABLE `majalah` (
  `id_koleksi` varchar(9) NOT NULL,
  `judul` varchar(50) NOT NULL,
  `penerbit` varchar(20) NOT NULL,
  `status_pinjam` tinyint(1) NOT NULL,
  `volume` int(11) NOT NULL,
  `seri` int(11) NOT NULL,
  `issn` varchar(12) NOT NULL,
  PRIMARY KEY (`id_koleksi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `majalah` */

insert  into `majalah`(`id_koleksi`,`judul`,`penerbit`,`status_pinjam`,`volume`,`seri`,`issn`) values 
('M695847','Infokomputer','Infomedia',0,12,2,'21253658984'),
('M695848','Tempo','Tempo Press',0,12,2,'212536845758'),
('M695849','Trubus','Gramedia Print',0,12,2,'54255788548'),
('M695850','Art Projects','Artis Press',1,12,2,'62548799521'),
('M695851','Elektron','Elek Media',0,12,2,'356548745522'),
('M695852','PCPlus','Media Indonesia',1,12,2,'45488784512'),
('M695853','CHIP','Softart Inc',0,12,2,'98765215487');

/*Table structure for table `transaksi` */

DROP TABLE IF EXISTS `transaksi`;

CREATE TABLE `transaksi` (
  `id_transaksi` varchar(12) NOT NULL,
  `tgl_pinjam` date NOT NULL,
  `tgl_kembali` date NOT NULL,
  `denda` float NOT NULL,
  `id_koleksi` varchar(9) NOT NULL,
  `id_peminjam` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `transaksi` */

insert  into `transaksi`(`id_transaksi`,`tgl_pinjam`,`tgl_kembali`,`denda`,`id_koleksi`,`id_peminjam`) values 
('T1636837422','2021-11-01','2021-12-01',0,'D12345','D123'),
('T1636837552','2021-11-02','2021-11-30',0,'M695849','U8812'),
('T1636837552','2021-11-02','2021-11-30',0,'B56789','U8812'),
('T1636837552','2021-11-02','2021-11-30',0,'D12346','U8812'),
('T1636837552','2021-11-02','2021-11-30',0,'M695851','U8812'),
('T1636837991','2021-11-03','2021-12-04',1000,'B56790','M2015'),
('T1636837991','2021-11-03','2021-12-04',1000,'D12349','M2015'),
('T1636837991','2021-11-03','2021-12-04',1000,'B56792','M2015'),
('T1636837991','2021-11-03','2021-12-04',1000,'M695847','M2015'),
('T1636837991','2021-11-03','2021-12-04',1000,'M695850','M2015'),
('T1636837991','2021-11-03','2021-12-04',1000,'D12351','M2015'),
('T1636997716','2021-11-15','2021-12-15',0,'D12347','D127'),
('T1636997716','2021-11-15','2021-12-15',0,'M695847','D127'),
('T1636997716','2021-11-15','2021-12-15',0,'B56795','D127'),
('T1637000122','2021-10-13','2021-11-15',3000,'D12349','D126'),
('T1637000122','2021-10-13','2021-11-15',3000,'B56794','D126'),
('T1637000122','2021-10-13','2021-11-15',3000,'M695849','D126'),
('T1637004594','2021-10-13','2021-11-15',0,'D12345','D123'),
('T1637004594','2021-10-13','2021-12-15',0,'D12345','D123'),
('T1637004594','2021-10-13','2021-12-15',0,'M695850','D123'),
('T1637004594','2021-10-13','2021-12-15',0,'B56792','D123'),
('T1637004594','2021-10-13','2021-12-15',0,'B56794','D123');

/*Table structure for table `umum` */

DROP TABLE IF EXISTS `umum`;

CREATE TABLE `umum` (
  `id_peminjam` varchar(9) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `mak_pinjam` int(11) NOT NULL,
  `nik` varchar(16) NOT NULL,
  PRIMARY KEY (`id_peminjam`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `umum` */

insert  into `umum`(`id_peminjam`,`nama`,`alamat`,`mak_pinjam`,`nik`) values 
('U8810','Chelsea Olivia','Gg. Anak Jalanan no.2X The World of the Married',4,'3404070802756001'),
('U8811','Raffi Ahmad','Jl. Ikatan Cinta no.8 SKY Castle 2th',4,'3404080702156006'),
('U8812','Kevin Julio','Gg. Ganteng2 Srigala no.11 Crash Landing on U ',4,'3404070305875004'),
('U8813','Ayu Ting Ting','Jl. Cinta Fitri no.8A The World of the Married',4,'5404080804758009'),
('U8814','Prilly Latuconsina','Gg. Intan no.25 Squid Gam',4,'4404080602776003'),
('U8815','Via Valen','Gg. Putri Yang Ditukar no.9 Dali and Cocky Prince',4,'3404071205756012'),
('U8816','Gisella Anastasia','Gg. Preman Pensiun no.99 The Good Detective',4,'3404071112957021'),
('U8817','Tantowi Sukoco','Gg. Manusia Srigala no.4 Horor Ritual',4,'3404071112957011');

/*Table structure for table `peminjam` */

DROP TABLE IF EXISTS `peminjam`;

/*!50001 DROP VIEW IF EXISTS `peminjam` */;
/*!50001 DROP TABLE IF EXISTS `peminjam` */;

/*!50001 CREATE TABLE  `peminjam`(
 `id_peminjam` varchar(9) ,
 `nama` varchar(30) ,
 `alamat` varchar(50) ,
 `mak_pinjam` int(11) ,
 `nip` varchar(16) 
)*/;

/*View structure for view peminjam */

/*!50001 DROP TABLE IF EXISTS `peminjam` */;
/*!50001 DROP VIEW IF EXISTS `peminjam` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `peminjam` AS select `dosen`.`id_peminjam` AS `id_peminjam`,`dosen`.`nama` AS `nama`,`dosen`.`alamat` AS `alamat`,`dosen`.`mak_pinjam` AS `mak_pinjam`,`dosen`.`nip` AS `nip` from `dosen` union select `mahasiswa`.`id_peminjam` AS `id_peminjam`,`mahasiswa`.`nama` AS `nama`,`mahasiswa`.`alamat` AS `alamat`,`mahasiswa`.`mak_pinjam` AS `mak_pinjam`,`mahasiswa`.`nim` AS `nim` from `mahasiswa` union select `umum`.`id_peminjam` AS `id_peminjam`,`umum`.`nama` AS `nama`,`umum`.`alamat` AS `alamat`,`umum`.`mak_pinjam` AS `mak_pinjam`,`umum`.`nik` AS `nik` from `umum` */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
