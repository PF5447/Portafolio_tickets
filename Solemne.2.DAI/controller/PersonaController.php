<?php

include_once __DIR__."/../dao/ConexionDB.php";
include_once __DIR__."/../dao/PersonaDAO.php";

/**
 * Description of PersonaController
 *
 * @author CETECOM
 */
class PersonaController {
    
    public function __construct() {
        
    }

    public function listarPersonasRegistradas() {
        $conexion = ConexionDB::getConexion();
        $daoPersona = new PersonaDAO($conexion);
        
        return $daoPersona->listarTodos();
    }
}
