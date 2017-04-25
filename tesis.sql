/*
Navicat MySQL Data Transfer

Source Server         : Tesis
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : tesis

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-04-25 12:01:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mg_api
-- ----------------------------
DROP TABLE IF EXISTS `mg_api`;
CREATE TABLE `mg_api` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `token_id` varchar(255) NOT NULL,
  `token_pass` varchar(255) NOT NULL,
  `estado` varchar(20) NOT NULL DEFAULT 'ACTIVO',
  PRIMARY KEY (`id`),
  KEY `APIUser` (`user_id`),
  CONSTRAINT `APIUser` FOREIGN KEY (`user_id`) REFERENCES `mg_usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of mg_api
-- ----------------------------

-- ----------------------------
-- Table structure for mg_eventos
-- ----------------------------
DROP TABLE IF EXISTS `mg_eventos`;
CREATE TABLE `mg_eventos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `descripcion` varchar(512) NOT NULL,
  `fecha_registro` datetime NOT NULL,
  `fecha_inicio` datetime NOT NULL,
  `fecha_fin` datetime NOT NULL,
  `visibilidad` varchar(30) NOT NULL DEFAULT 'PRIVADO',
  `categoria_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `p_name` varchar(60) NOT NULL,
  `p_address` varchar(80) NOT NULL,
  `p_lat` float(10,6) NOT NULL,
  `p_lng` float(10,6) NOT NULL,
  `p_type` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Categoria` (`categoria_id`),
  KEY `UsuarioAdmin` (`user_id`),
  CONSTRAINT `Categoria` FOREIGN KEY (`categoria_id`) REFERENCES `mg_eventos_categoria` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `UsuarioAdmin` FOREIGN KEY (`user_id`) REFERENCES `mg_usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of mg_eventos
-- ----------------------------

-- ----------------------------
-- Table structure for mg_eventos_categoria
-- ----------------------------
DROP TABLE IF EXISTS `mg_eventos_categoria`;
CREATE TABLE `mg_eventos_categoria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of mg_eventos_categoria
-- ----------------------------

-- ----------------------------
-- Table structure for mg_eventos_fotos
-- ----------------------------
DROP TABLE IF EXISTS `mg_eventos_fotos`;
CREATE TABLE `mg_eventos_fotos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(30) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `url` varchar(255) NOT NULL,
  `evento_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Evento` (`evento_id`),
  CONSTRAINT `Evento` FOREIGN KEY (`evento_id`) REFERENCES `mg_eventos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of mg_eventos_fotos
-- ----------------------------

-- ----------------------------
-- Table structure for mg_lista_invitados
-- ----------------------------
DROP TABLE IF EXISTS `mg_lista_invitados`;
CREATE TABLE `mg_lista_invitados` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `evento_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `InvitadoEvento` (`evento_id`),
  KEY `InvitiadoUser` (`user_id`),
  CONSTRAINT `InvitadoEvento` FOREIGN KEY (`evento_id`) REFERENCES `mg_eventos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `InvitiadoUser` FOREIGN KEY (`user_id`) REFERENCES `mg_usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of mg_lista_invitados
-- ----------------------------

-- ----------------------------
-- Table structure for mg_posicion
-- ----------------------------
DROP TABLE IF EXISTS `mg_posicion`;
CREATE TABLE `mg_posicion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `fecha` datetime NOT NULL,
  `name` varchar(60) NOT NULL,
  `address` varchar(80) NOT NULL,
  `lat` float(10,6) NOT NULL,
  `lng` float(10,6) NOT NULL,
  `type` varchar(30) NOT NULL,
  `default` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `Usuario` (`user_id`),
  CONSTRAINT `Usuario` FOREIGN KEY (`user_id`) REFERENCES `mg_usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of mg_posicion
-- ----------------------------
INSERT INTO `mg_posicion` VALUES ('2', '1', '0000-00-00 00:00:00', 'fds', 'sdf', '1.000000', '1.000000', 'a', '0');

-- ----------------------------
-- Table structure for mg_usuarios
-- ----------------------------
DROP TABLE IF EXISTS `mg_usuarios`;
CREATE TABLE `mg_usuarios` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL DEFAULT 'a@a.com',
  `token` varchar(1024) DEFAULT NULL,
  `level` varchar(22) NOT NULL DEFAULT 'USUARIO',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of mg_usuarios
-- ----------------------------
INSERT INTO `mg_usuarios` VALUES ('1', 'test', '123abc', 'a@a.com', null, 'USUARIO');
INSERT INTO `mg_usuarios` VALUES ('2', 'usuario2', '123abc', 'a@a.com', null, 'USUARIO');
INSERT INTO `mg_usuarios` VALUES ('3', 'usuario3', '123abc', 'a@a.com', null, 'USUARIO');

-- ----------------------------
-- Table structure for registro_actividad
-- ----------------------------
DROP TABLE IF EXISTS `registro_actividad`;
CREATE TABLE `registro_actividad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  `actividad` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `RegistroUsuarioAct` (`user_id`),
  CONSTRAINT `RegistroUsuarioAct` FOREIGN KEY (`user_id`) REFERENCES `mg_usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of registro_actividad
-- ----------------------------

-- ----------------------------
-- Table structure for registro_ingreso
-- ----------------------------
DROP TABLE IF EXISTS `registro_ingreso`;
CREATE TABLE `registro_ingreso` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  `ip` varchar(15) NOT NULL DEFAULT '0.0.0.0',
  `aplicacion` varchar(50) NOT NULL DEFAULT 'WEB',
  PRIMARY KEY (`id`),
  KEY `UsuarioLog` (`user_id`),
  CONSTRAINT `UsuarioLog` FOREIGN KEY (`user_id`) REFERENCES `mg_usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of registro_ingreso
-- ----------------------------
INSERT INTO `registro_ingreso` VALUES ('1', '2', '2017-04-25 11:28:05', '0.0.0.0', 'WEB');
INSERT INTO `registro_ingreso` VALUES ('2', '3', '2017-04-25 09:28:21', '192.168.1.154', 'APP');
