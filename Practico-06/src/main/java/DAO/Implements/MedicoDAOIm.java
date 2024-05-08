package DAO.Implements;

import DAO.Interface.MedicoDAO;
import Entity.Especialidad;
import Entity.Medico;
import Entity.ObraSocial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedicoDAOIm implements MedicoDAO {
    private Map<Integer, Medico> medicos = new HashMap<>();
    @Override
    public List<Medico> findNombre(String nombre) {
        List<Medico> medicosWithNombre = new ArrayList<>();
        for (Medico medico : medicos.values()) {
            if (medico.getNombre().equals(nombre)) {
                medicosWithNombre.add(medico);
            }
        }
        return medicosWithNombre;
    }

    @Override
    public List<Medico> findApellido(String apellido) {
        List<Medico> medicosWithApellido = new ArrayList<>();
        for (Medico medico : medicos.values()) {
            if (medico.getApellido().equals(apellido)) {
                medicosWithApellido.add(medico);
            }
        }
        return medicosWithApellido;
    }

    @Override
    public List<Medico> findObraSocial(ObraSocial obraSocial) {
        List<Medico> medicosAcceptObraSocial = new ArrayList<>();
        for (Medico medico : medicos.values()) {
            if (medico.getObraSocialRecibidas().equals(obraSocial)) {
                medicosAcceptObraSocial.add(medico);
            }
        }
        return medicosAcceptObraSocial;
    }

    @Override
    public List<Medico> findEspecialidad(Especialidad especialidad) {
        List<Medico> medicosWithEspecialidad = new ArrayList<>();
        for (Medico medico : medicos.values()) {
            if (medico.getEspecialidad().equals(especialidad)) {
                medicosWithEspecialidad.add(medico);
            }
        }
        return medicosWithEspecialidad;
    }

    @Override
    public List<Medico> listarTodos() {
        return new ArrayList<>(medicos.values());
    }

    @Override
    public Medico buscarPorId(int id) {
        return medicos.get(id);
    }

    @Override
    public void registrar(Medico medico) {
        System.out.println("El medico "+ medico.getNombre()+" "+ medico.getApellido() +" se ha registrado");
        medicos.put(medico.getId(), medico);

    }

    @Override
    public void modificar(Medico medico) {
        System.out.println("El medico "+ medico.getNombre()+ " "+ medico.getApellido() +" se ha actualizado");
        medicos.put(medico.getId(), medico);

    }

    @Override
    public void eliminar(int id) {
        System.out.println("Medico: "+ id +" eliminado");
        medicos.remove(id);

    }
}
