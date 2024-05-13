package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import DAO.Implements.MedicamentoDAOIm;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drogueria {
    public MedicamentoDAOIm medicamentoDAOIm;

    public Medicamento getMedicamentosEnDrogueria(Medicamento medicamento) {
        Medicamento medicamento1 = new Medicamento(medicamento.getId(), medicamento.getNombre(), medicamento.getCantidad());
        medicamentoDAOIm.modificar(medicamento1);
        return medicamento1;
    }
}
