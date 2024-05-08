package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Turno {
    private int id;
    private Paciente paciente;
    private Medico medico;
    private boolean razonParticular;

}
