package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medico {
    private int id;
    private String nombre;
    private String apellido;
    private List<ObraSocial> obraSocialRecibidas;
    private Especialidad especialidad;
}
