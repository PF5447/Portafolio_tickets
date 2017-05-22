<?php


interface GenericDAO {
    
    public function buscarPorId($idregistro);
    
    public function agregar($registros);
    
    public function actualizar($registro);
    
    public function eliminar($idRegistro);
    
    public function listarTodos();
}
