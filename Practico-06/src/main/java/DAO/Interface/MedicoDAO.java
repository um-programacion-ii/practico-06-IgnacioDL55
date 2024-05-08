package DAO.Interface;

import Entity.Especialidad;
import Entity.Medico;
import Entity.ObraSocial;

import java.util.List;

public interface MedicoDAO extends Generic<Medico> {
    List<Medico> findNombre(String nombre);
    List<Medico> findApellido(String apellido);
    List<Medico> findObraSocial(ObraSocial obraSocial);
    List<Medico> findEspecialidad(Especialidad especialidad);
}
