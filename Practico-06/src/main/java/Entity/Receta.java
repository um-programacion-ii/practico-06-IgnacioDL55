package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Receta {
    private int id;
    private List<Medicamento> medicamentos;
    private Medico medico;
    private Date fecha;

}
