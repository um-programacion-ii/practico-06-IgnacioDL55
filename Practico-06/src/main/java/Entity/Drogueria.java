package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drogueria {
    private List<Medicamento> medicamentosEnDrogueria;

    public List<Medicamento> getMedicamentosEnDrogueria(List<Medicamento> medicamentosEnDrogueria) {
        return medicamentosEnDrogueria;
    }
}
