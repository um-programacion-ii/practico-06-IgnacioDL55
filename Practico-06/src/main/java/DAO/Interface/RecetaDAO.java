package DAO.Interface;

import Entity.Medicamento;
import Entity.Medico;
import Entity.Receta;

import java.util.List;

public interface RecetaDAO extends Generic<Receta> {
    List<Receta> findMedicamentos(Medicamento medicamento);
    List<Receta> findMedico(Medico medico);
}
