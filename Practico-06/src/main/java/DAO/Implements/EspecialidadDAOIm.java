package DAO.Implements;

import DAO.Interface.EspecialidadDAO;
import Entity.Especialidad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EspecialidadDAOIm implements EspecialidadDAO {
    private Map<Integer, Especialidad> especialidades = new HashMap<>();

    @Override
    public List<Especialidad> findNombre(String nombre) {
        List<Especialidad> especialidadesWithNombre = new ArrayList<>();
        for (Especialidad especialidad : especialidades.values()) {
            if (especialidad.getNombre().equals(nombre)) {
                especialidadesWithNombre.add(especialidad);
            }
        }
        return especialidadesWithNombre;
    }

    @Override
    public List<Especialidad> listarTodos() {
        return new ArrayList<>(especialidades.values());
    }

    @Override
    public Especialidad buscarPorId(int id) {
        return especialidades.get(id);
    }

    @Override
    public void registrar(Especialidad especialidad) {
        System.out.println("La especialidad "+ especialidad.getNombre() +" fue registrada" );
        especialidades.put(especialidad.getId(), especialidad);

    }

    @Override
    public void modificar(Especialidad especialidad) {
        System.out.println("La especialidad "+ especialidad.getNombre() +" fue registrada" );
        especialidades.put(especialidad.getId(), especialidad);

    }

    @Override
    public void eliminar(int id) {
        System.out.println("La especialidad "+ id +" fue eliminada" );
        especialidades.remove(id);

    }
}
