package DAO.Interface;

import Entity.Especialidad;

import java.util.List;

public interface EspecialidadDAO extends Generic<Especialidad> {
    List<Especialidad> findNombre(String nombre);
}
