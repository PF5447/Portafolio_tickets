<?php


class Persona {
    
    private $nombre;
    private $fechaNacimiento;
    private $email;
    
    public function __construct() {   
    }
    
    public function getNombre() {
        return $this->nombre;
    }

    public function getFechaNacimiento() {
        return $this->fechaNacimiento;
    }

    public function getEmail() {
        return $this->email;
    }

    public function setFechaNacimiento($fechaNacimiento) {
        $this->fechaNacimiento = $fechaNacimiento;
    }

    public function setEmail($email) {
        $this->email = $email;
    }
}
