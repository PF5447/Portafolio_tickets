<?php

include_once __DIR__."/../model/Persona.php";
include_once __DIR__."/GenericDAO.php";

class PersonaDAO implements GenericDAO {
    private $conexion;
    
    public function __construct($conexion) {
        $this->conexion = $conexion;
    }

    public function actualizar($registro) {
        
    }

    public function agregar($registros) {
        
    }

    public function buscarPorId($idregistro) {
        
    }

    public function eliminar($idRegistro) {
        
    }

    public function listarTodos() {
        $personas = array();
        $acentos = $this->conexion->query("SET NAMES 'utf8'");
        $listadoPersonas = $this->conexion->query("SELECT * FROM persona"); 
        
        foreach($listadoPersonas as $filas) {            
            $persona = new Persona();            
            $persona->setNombre($filas["nombre"]); 
            $persona->setFechaNacimiento($filas["fecha_nacimiento"]); 
            $persona->setEmail($filas["correo"]); 
            
            array_push($personas, $persona);
        }
        
        return $personas;
    }

}
