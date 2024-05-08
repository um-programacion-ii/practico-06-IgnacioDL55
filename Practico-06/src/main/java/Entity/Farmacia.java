package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Farmacia {
    private int id;
    private List<Medicamento> Stockmedicamentos;
    private Drogueria drogueriaAsociada;
}
