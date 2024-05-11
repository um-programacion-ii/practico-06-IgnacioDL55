package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Farmacia {
    private List<Medicamento> stockmedicamentos = new ArrayList<>();
    private Drogueria drogueriaAsociada;

    public void solicitarMedicamento(Medicamento medicamento, int cantidad) {
        if (stockmedicamentos.contains(medicamento)) {
            int nuevoStock = medicamento.getCantidad();
            medicamento.setCantidad(nuevoStock + cantidad);
        }else {
            System.out.println("No existe el medicamento"+ stockmedicamentos);
        }
    }

    public void retirarMedicamento(Medicamento medicamento, int cantidad) {
        if (stockmedicamentos.contains(medicamento)) {
            int nuevoStock = medicamento.getCantidad();
            if (nuevoStock >= cantidad) {
                medicamento.setCantidad(nuevoStock - cantidad);
            }else {
                System.out.println("No se puede retirar la cantidad que pides");
            }
        } else {
            System.out.println("No existe el medicamento");
        }
    }
}
