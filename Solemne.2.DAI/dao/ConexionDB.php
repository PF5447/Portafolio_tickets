<?php

class ConexionDB {
    const HOST = "localhost";
    const DBNAME = "solemne_2_db";
    const PORT = "3306";
    const USER = "admin";
    const PASS = "1234";
    
    public static function getConexion() {
        $dsn = "mysql:host=".self::HOST.";dbname=".self::DBNAME.";port=".self::PORT;
        $conexion = new PDO($dsn, self::USER, self::PASS);
        return $conexion;
    }
}
