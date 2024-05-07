package DAO.Interface;

import Entity.ObraSocial;
import Entity.Paciente;

import java.util.List;

public interface PacienteDAO extends Generic<Paciente> {
    List<Paciente> findNombre(String nombre);
    List<Paciente> findApellido(String apellido);
    List<Paciente> findObraSocial(ObraSocial obraSocial);

}
