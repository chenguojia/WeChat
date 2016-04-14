-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2013 年 12 月 25 日 02:28
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

DELIMITER $$
--
-- 函数
--
CREATE DEFINER=`root`@`localhost` FUNCTION `_nextval`(n varchar(50)) RETURNS int(11)
    DETERMINISTIC
begin  
    declare _cur int;  
    set _cur=(select current_value from tb_sequence where name= n);  
    update tb_sequence  
     set current_value = _cur + _increment  
     where name=n ;  
    return _cur;  
    end$$

DELIMITER ;

-- --------------------------------------------------------

--
-- 表的结构 `action_log`
--

CREATE TABLE IF NOT EXISTS `action_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `open_id` varchar(28) COLLATE utf8_bin DEFAULT NULL,
  `action` tinyint(4) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `memo` varchar(300) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `leads`
--

CREATE TABLE IF NOT EXISTS `leads` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `contact_mobile` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `contact_position` int(11) DEFAULT NULL,
  `memo` longtext COLLATE utf8_bin,
  `merchant_contact` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `merchant_intention` int(11) DEFAULT NULL,
  `merchant_name` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `merchant_number` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `number` varchar(12) COLLATE utf8_bin DEFAULT NULL,
  `sales_number` varchar(8) COLLATE utf8_bin DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `task_type` int(11) DEFAULT NULL,
  `channel` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `merchant`
--

CREATE TABLE IF NOT EXISTS `merchant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `merchant_address`
--

CREATE TABLE IF NOT EXISTS `merchant_address` (
  `id` int(11) NOT NULL DEFAULT '0',
  `mid` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `business_name` varchar(150) COLLATE utf8_bin DEFAULT NULL,
  `short_address` varchar(150) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- 表的结构 `merchant_credit`
--

CREATE TABLE IF NOT EXISTS `merchant_credit` (
  `id` int(11) NOT NULL AUTO_INCREMENT, 
  `branch_code` varchar(4) COLLATE utf8_bin NOT NULL, --分支机构
  `region_code` varchar(4) COLLATE utf8_bin NOT NULL, --地区码
  `mid` varchar(15) COLLATE utf8_bin NOT NULL, 
  `sub_code` varchar(4) COLLATE utf8_bin NOT NULL, --分店号
  `credit_rating` varchar(3) COLLATE utf8_bin NOT NULL, --授信等级
  `credit_line` float NOT NULL, --授信额度
  `max_repayment_period` varchar(2) COLLATE utf8_bin NOT NULL, --最长还款期
  `fee_rate` float NOT NULL, --手续费率
  `fee` float NOT NULL, --手续费
  `refund_way` varchar(8) COLLATE utf8_bin NOT NULL, --还款方式
  `fixed_daily_payment` float DEFAULT NULL, --固定每日还款金额
  `fixed_daily_repay_ratio` float NOT NULL, --固定每日还款比例
  `min_monthly_payments` float NOT NULL, --月最小还款额
  `open_rate` float NOT NULL, --优惠费率
  `open_fee` float NOT NULL, --优惠手续费
  `acquirer_id` varchar(8) COLLATE utf8_bin NOT NULL, --收单机构编码
  `mcc_code` varchar(4) COLLATE utf8_bin NOT NULL, 
  `network_days_state` int(11) DEFAULT 0, --入网天数状态
  `monthly_card_amount_state` int(11) DEFAULT 0, --月均刷卡额状态
  `last_month_transction_state` int(11) DEFAULT 0, --上月交易状态
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=716063 ;

-- --------------------------------------------------------

--
-- 表的结构 `parameter`
--

CREATE TABLE IF NOT EXISTS `parameter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `enum` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `memo` longtext COLLATE utf8_bin,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `param_order` int(11) DEFAULT NULL,
  `parent` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `value` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=75 ;

-- --------------------------------------------------------

--
-- 表的结构 `sales`
--

CREATE TABLE IF NOT EXISTS `sales` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bank` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `bank_card_number` varchar(18) COLLATE utf8_bin DEFAULT NULL,
  `id_number` varchar(18) COLLATE utf8_bin DEFAULT NULL,
  `mobile` varchar(14) COLLATE utf8_bin DEFAULT NULL,
  `number` varchar(8) COLLATE utf8_bin DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `email` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `region_code` varchar(4) COLLATE utf8_bin DEFAULT NULL,
  `branch_code` varchar(4) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_g96jugrma86ovqbuxhhkq42bo` (`number`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `task`
--

CREATE TABLE IF NOT EXISTS `task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `contact_mobile` varchar(14) COLLATE utf8_bin DEFAULT NULL,
  `contact_name` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `memo` longtext COLLATE utf8_bin,
  `merchant_name` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `merchant_number` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `number` varchar(12) COLLATE utf8_bin DEFAULT NULL,
  `phase` int(11) DEFAULT NULL,
  `sales_number` varchar(8) COLLATE utf8_bin DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `urgent_degree` int(11) DEFAULT NULL,
  `contact_position` int(11) DEFAULT NULL,
  `channel` int(11) DEFAULT NULL,
  `last_update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `tb_sequence`
--

CREATE TABLE IF NOT EXISTS `tb_sequence` (
  `name` varchar(50) COLLATE utf8_bin NOT NULL,
  `current_value` int(11) NOT NULL,
  `_increment` int(11) NOT NULL DEFAULT '1',
  `type` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `open_id` varchar(28) COLLATE utf8_bin DEFAULT NULL,
  `username` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(6) COLLATE utf8_bin DEFAULT NULL,
  `token` varchar(37) COLLATE utf8_bin DEFAULT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  `last_login` timestamp NULL DEFAULT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `open_id` (`open_id`,`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

DELIMITER $$
--
-- 事件
--
CREATE DEFINER=`testuser`@`localhost` EVENT `refresh_daily_sequence` ON SCHEDULE EVERY 1 DAY STARTS '2013-12-20 00:00:00' ON COMPLETION NOT PRESERVE ENABLE DO update tb_sequence set current_value=1 where type=1$$

DELIMITER ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
