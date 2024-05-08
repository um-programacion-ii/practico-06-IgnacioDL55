package DAO.Implements;

import DAO.Interface.RecetaDAO;
import Entity.Medicamento;
import Entity.Medico;
import Entity.Receta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecetaDAOIm implements RecetaDAO {
    private Map<Integer, Receta> recetas = new HashMap<>();
    @Override
    public List<Receta> findMedicamentos(Medicamento medicamento) {
        List<Receta> recetasWithMedicamento = new ArrayList<>();
        for (Receta receta : recetas.values()) {
            if (receta.getMedicamentos().equals(medicamento)) {
                recetasWithMedicamento.add(receta);
            }
        }
        return recetasWithMedicamento;
    }

    @Override
    public List<Receta> findMedico(Medico medico) {
        List<Receta> recetaWithMedico = new ArrayList<>();
        for (Receta receta : recetas.values()) {
            if (receta.getMedicamentos().equals(medico)) {
                recetaWithMedico.add(receta);
            }
        }
        return recetaWithMedico;
    }

    @Override
    public List<Receta> listarTodos() {
        return new ArrayList<>(recetas.values());
    }

    @Override
    public Receta buscarPorId(int id) {
        return recetas.get(id);
    }

    @Override
    public void registrar(Receta receta) {
        System.out.println("La receta fue registrada");
        recetas.put(receta.getId(), receta);

    }

    @Override
    public void modificar(Receta receta) {
        System.out.println("La receta fue actualizada");
        recetas.put(receta.getId(), receta);

    }

    @Override
    public void eliminar(int id) {
        System.out.println("La receta fue eliminada");
        recetas.remove(id);

    }
}
