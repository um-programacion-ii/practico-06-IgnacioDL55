package DAO.Implements;

import DAO.Interface.PacienteDAO;
import Entity.ObraSocial;
import Entity.Paciente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PacienteDAOIm implements PacienteDAO {
    private Map<Integer, Paciente> pacientes = new HashMap<>();

    @Override
    public List<Paciente> listarTodos() {
        return new  ArrayList<>(pacientes.values());
    }

    @Override
    public Paciente buscarPorId(int id) {
        return pacientes.get(id);
    }

    @Override
    public void registrar(Paciente paciente) {
        System.out.println("El Paciente "+ paciente.getNombre() + paciente.getApellido() +" fue registrado" );
        pacientes.put(paciente.getId(), paciente);
    }

    @Override
    public void modificar(Paciente paciente) {
        System.out.println("Paciente" + paciente.getNombre() + paciente.getApellido() + " fue modificado y actualizado");
        pacientes.put(paciente.getId(), paciente);

    }

    @Override
    public void eliminar(int id) {
        System.out.println("Paciente: " + id + " eliminado");
        pacientes.remove(id);

    }

    @Override
    public List<Paciente> findNombre(String nombre) {
        List<Paciente>pacientesWithNombre = new ArrayList<>();
        for (Paciente paciente : pacientes.values()){
            if(paciente.getNombre().equals(nombre)){
                pacientesWithNombre.add(paciente);
            }
        }
        return pacientesWithNombre;
    }

    @Override
    public List<Paciente> findApellido(String apellido) {
        List<Paciente> pacientesWithApellido = new ArrayList<>();
        for (Paciente paciente : pacientes.values()) {
            if (paciente.getApellido().equals(apellido)) {
                pacientesWithApellido.add(paciente);
            }
        }
        return pacientesWithApellido;
    }

    @Override
    public List<Paciente> findObraSocial(ObraSocial obraSocial) {
        List<Paciente> pacientesWithObraSocial = new ArrayList<>();
        for (Paciente paciente : pacientes.values()) {
            if (paciente.getObraSocial().equals(obraSocial)) {
                pacientesWithObraSocial.add(paciente);
            }
        }
        return pacientesWithObraSocial;
    }

}
