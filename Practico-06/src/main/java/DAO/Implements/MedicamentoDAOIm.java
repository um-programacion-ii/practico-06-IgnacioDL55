package DAO.Implements;

import DAO.Interface.MedicamentoDAO;
import Entity.Farmacia;
import Entity.Medicamento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedicamentoDAOIm implements MedicamentoDAO {
    private Map<Integer, Medicamento> medicamentos = new HashMap<>();

    @Override
    public List<Medicamento> findNombre(String nombre) {
        List<Medicamento> medicamentoWithNombre = new ArrayList<>();
        for (Medicamento medicamento : medicamentos.values()) {
            if (medicamento.getNombre().equals(nombre)) {
                medicamentoWithNombre.add(medicamento);
            }
        }
        return medicamentoWithNombre;
    }

    @Override
    public List<Medicamento> findCantidad(int cantidad) {
        List<Medicamento> medicamentoWithCantidad = new ArrayList<>();
        for (Medicamento medicamento : medicamentos.values()) {
            if (medicamento.getCantidad() >= cantidad) {
                medicamentoWithCantidad.add(medicamento);
            }
        }
        return medicamentoWithCantidad;

    }

    @Override
    public List<Medicamento> listarTodos() {
        return new ArrayList<>(medicamentos.values());
    }

    @Override
    public Medicamento buscarPorId(int id) {
        return medicamentos.get(id);
    }

    @Override
    public void registrar(Medicamento medicamento) {
        System.out.println("El medicamento "+ medicamento.getNombre() +" se ha registrado");
        medicamentos.put(medicamento.getId(), medicamento);

    }

    @Override
    public void modificar(Medicamento medicamento) {
        System.out.println("El medicamento "+ medicamento.getNombre() +" se ha actualizado");
        medicamentos.put(medicamento.getId(), medicamento);

    }

    @Override
    public void eliminar(int id) {
        System.out.println("El medicamento "+ id +" se ha eliminado");
        medicamentos.remove(id);

    }
}
