-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2013 年 12 月 16 日 03:06
-- 服务器版本: 5.6.12-log
-- PHP 版本: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `wechat`
--
CREATE DATABASE IF NOT EXISTS `wechat` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `wechat`;

-- --------------------------------------------------------

--
-- 表的结构 `leads`
--

CREATE TABLE IF NOT EXISTS `leads` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `merchant_no` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '商户编号',
  `merchant_name` varchar(30) COLLATE utf8_bin NOT NULL COMMENT '商户名称',
  `merchant_purpose` tinyint(2) NOT NULL COMMENT '商户意向',
  `merchant_contact` varchar(10) COLLATE utf8_bin NOT NULL COMMENT '联系人姓名',
  `contact_position` tinyint(2) NOT NULL COMMENT '联系人身份',
  `contact_mobile` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '手机号码',
  `status` tinyint(2) NOT NULL COMMENT '线索状态',
  `memo` varchar(300) COLLATE utf8_bin NOT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='线索表' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `parameters`
--

CREATE TABLE IF NOT EXISTS `parameters` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `enum` int(11) NOT NULL COMMENT '组id',
  `name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '参数名称，页面显示',
  `value` int(11) NOT NULL COMMENT '参数值',
  `status` tinyint(1) NOT NULL COMMENT '状态',
  `param_order` smallint(6) NOT NULL COMMENT '顺序号',
  `memo` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `enum` (`enum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='参数表' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `sales`
--

CREATE TABLE IF NOT EXISTS `sales` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `type` tinyint(2) NOT NULL COMMENT '用户类别',
  `bank_card_no` varchar(18) COLLATE utf8_bin NOT NULL COMMENT '借记卡号',
  `bank` varchar(10) COLLATE utf8_bin NOT NULL COMMENT '开户银行',
  `id_no` varchar(18) COLLATE utf8_bin NOT NULL COMMENT '身份证号',
  `mobile` varchar(15) COLLATE utf8_bin NOT NULL COMMENT '手机号码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='客户经理信息表' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `task`
--

CREATE TABLE IF NOT EXISTS `task` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `task_no` varchar(15) COLLATE utf8_bin NOT NULL COMMENT '任务编号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `merchant_no` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '商户编号',
  `merchant_name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '商户名称',
  `phase` tinyint(2) NOT NULL COMMENT '阶段',
  `status` tinyint(2) NOT NULL COMMENT '状态',
  `contact_name` varchar(10) COLLATE utf8_bin NOT NULL COMMENT '联系人姓名',
  `contact_position` tinyint(2) NOT NULL COMMENT '联系人身份',
  `contact_mobile` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '联系人手机号码',
  `memo` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `urgent_degree` tinyint(2) NOT NULL COMMENT '紧急程度',
  `sales_id` int(11) DEFAULT NULL COMMENT '客勤id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE IF NOT EXISTS `we_user` (
  `id` int(11) NOT NULL,
  `name` varchar(10) COLLATE utf8_bin NOT NULL,
  `open_id` varchar(28) COLLATE utf8_bin NOT NULL,
  `username` varchar(10) COLLATE utf8_bin NOT NULL,
  `password` varchar(6) COLLATE utf8_bin NOT NULL,
  `token` varchar(37) COLLATE utf8_bin DEFAULT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  `last_login` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `open_id` (`open_id`,`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- 转存表中的数据 `user`
--

INSERT INTO `we_user` (`id`, `name`, `open_id`, `username`, `password`, `token`, `enabled`, `last_login`) VALUES
(1, 'martin', 'ozNTQjrPHlpuyG69UybLjpvm9teM', '1001', '123456', '', 1, NULL),
(2, 'shawn', 'ozNTQjm2zLLkAP9y4a0Ipq3mrVMQ', '1002', '123456', '', 1, NULL),
(3, 'zhang', 'ozNTQjmSoc-Ezew1oSySpadQSnOw', '1003', '123456', '', 1, NULL),
(4, 'kang', 'ozNTQjpZ_MUpZ25fKhG15BNxV8Tk', '1004', '4001', '4e3b2605-7105-4f59-b32e-a8436cd79037', 1, NULL),
(5, 'chen', '', '1005', '5001', NULL, 1, NULL),
(6, 'lu wenjie', 'ozNTQjuqE4bhmXVCmKVh8iyS8gI4', '1006', '6001', '', 1, NULL),
(7, 'wang', '', '1007', '7001', NULL, 1, NULL),
(8, 'guan', '', '1008', '8001', NULL, 1, NULL),
(9, 'zhao', 'ozNTQjrf4QX7ufwkacMzQ-h49jAk', '1009', '9001', '', 1, NULL),
(10, 'lu jingyi', '', '1010', '0101', NULL, 1, NULL);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
