CREATE TABLE `roombook` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `custid` bigint(20) NOT NULL,
  `roomid` bigint(20) NOT NULL,
  `startdate` date NOT NULL,
  `enddate` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
