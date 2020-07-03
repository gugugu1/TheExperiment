-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.0.67-community-nt - MySQL Community Edition (GPL)
-- 服务器操作系统:                      Win32
-- HeidiSQL 版本:                  9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 manage 的数据库结构
CREATE DATABASE IF NOT EXISTS `manage` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;
USE `manage`;


-- 导出  表 manage.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `username` varchar(50) collate utf8_bin NOT NULL,
  `userpassword` varchar(50) collate utf8_bin NOT NULL,
  PRIMARY KEY  (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  manage.user 的数据：~16 rows (大约)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`username`, `userpassword`) VALUES
	('12', '12'),
	('123', '123'),
	('12312', '12312'),
	('1234', '123'),
	('12345', '12345'),
	('123456', '123'),
	('1743', '12'),
	('2020', '123'),
	('2020616', '2020616'),
	('616', '616'),
	('789', '789'),
	('aaa', '111'),
	('admin', 'password'),
	('jsp', 'jsp'),
	('root', 'root'),
	('zqh', '123');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


-- 导出  表 manage.usinguser 结构
CREATE TABLE IF NOT EXISTS `usinguser` (
  `usingid` varchar(50) collate utf8_bin NOT NULL,
  `usingname` varchar(50) collate utf8_bin NOT NULL,
  `usingpassword` varchar(50) collate utf8_bin default NULL,
  `usingphone` varchar(50) collate utf8_bin NOT NULL,
  `usingemail` varchar(50) collate utf8_bin default NULL,
  `usingdescribe` text collate utf8_bin,
  PRIMARY KEY  (`usingid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  manage.usinguser 的数据：~10 rows (大约)
DELETE FROM `usinguser`;
/*!40000 ALTER TABLE `usinguser` DISABLE KEYS */;
INSERT INTO `usinguser` (`usingid`, `usingname`, `usingpassword`, `usingphone`, `usingemail`, `usingdescribe`) VALUES
	('1', '李烈', '11547', '11547', '123@email.com', '普通会员555'),
	('1415267', 'jack', '11547', '15048', '11475@qq.com', '111'),
	('1457', 'jack', '15048', '15048', '11475@qq.com', '1233'),
	('1536', 'jack', '15048', '15048', '11475@qq.com', '555'),
	('1704020', '昭陵', '15048', '15048', '1024@email.com', '超级会员'),
	('2', '王力', '47946', '47946', '789@email.com', '超级会员111'),
	('2020', 'kkkhhh', '1024', '1024', '1024@email.com', 'kkk'),
	('asd32', 'c', '15048', '15048', '1024@email.com', '5546'),
	('asdqwe', 'jack', '456', '456', '741@163.com', '会员'),
	('test', '测试', '123456', '1234', '1234@qq.com', '1234');
/*!40000 ALTER TABLE `usinguser` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
