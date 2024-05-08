package DAO.Interface;

import Entity.Farmacia;
import Entity.Medicamento;

import java.util.List;

public interface MedicamentoDAO extends Generic<Medicamento>{
    List<Medicamento> findNombre(String nombre);
    List<Medicamento> findCantidad(int cantidad);

}
