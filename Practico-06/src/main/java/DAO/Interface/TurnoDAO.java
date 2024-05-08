package DAO.Interface;

import Entity.Medico;
import Entity.Paciente;
import Entity.Turno;

import java.util.List;

public interface TurnoDAO extends Generic<Turno>{
    List<Turno> findPaciente(Paciente paciente);
    List<Turno> findMedico(Medico medico);
    List<Turno> findRazon(boolean razon);
}
