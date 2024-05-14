package DAO.Implements;

import DAO.Interface.TurnoDAO;
import Entity.Medico;
import Entity.Paciente;
import Entity.Turno;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TurnoDAOIm implements TurnoDAO {
    private Map<Integer, Turno> turnos = new HashMap<>();

    @Override
    public List<Turno> findPaciente(Paciente paciente) {
        List<Turno> turnosWithPaciente = new ArrayList<>();
        for (Turno turno : this.turnos.values()) {
            if (turno.getPaciente().equals(paciente)) {
                turnosWithPaciente.add(turno);
            }
        }
        return turnosWithPaciente;

    }

    @Override
    public List<Turno> findMedico(Medico medico) {
        List<Turno> turnosWithMedico = new ArrayList<>();
        for (Turno turno : this.turnos.values()) {
            if (turno.getMedico().equals(medico)) {
                turnosWithMedico.add(turno);
            }
        }
        return turnosWithMedico;
    }

    @Override
    public List<Turno> findRazon(boolean razon) {
        List<Turno> turnosWithRazon = new ArrayList<>();
        for (Turno turno : this.turnos.values()) {
            if (turno.isRazonParticular());
        }
        return turnosWithRazon;
    }

    @Override
    public List<Turno> listarTodos() {
        return new ArrayList<>(this.turnos.values());
    }

    @Override
    public Turno buscarPorId(int id) {
        return turnos.get(id);
    }

    @Override
    public void registrar(Turno turno) {
        System.out.println("Registrando Turno");
        turnos.put(turno.getId(), turno);

    }

    @Override
    public void modificar(Turno turno) {
        System.out.println("Actualizando Turno");
        turnos.put(turno.getId(), turno);

    }

    @Override
    public void eliminar(int id) {
        System.out.println("Eliminando Turno");
        turnos.remove(id);

    }
}
