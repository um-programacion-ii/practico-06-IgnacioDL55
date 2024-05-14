package Services;

import DAO.Implements.MedicoDAOIm;
import DAO.Implements.PacienteDAOIm;
import DAO.Implements.RecetaDAOIm;
import DAO.Implements.TurnoDAOIm;
import DAO.Interface.MedicoDAO;
import DAO.Interface.PacienteDAO;
import DAO.Interface.RecetaDAO;
import DAO.Interface.TurnoDAO;
import Entity.Medicamento;
import Entity.Paciente;
import Entity.Receta;
import Entity.Turno;

import java.util.List;

public class AtencionMedicoService {
    private static AtencionMedicoService instancia;
    private PacienteDAOIm paciente;
    private MedicoDAOIm medico;
    private RecetaDAOIm recetas = new RecetaDAOIm();
    private TurnoDAOIm turnos = new TurnoDAOIm();

    public static synchronized AtencionMedicoService getInstancia(PacienteDAOIm paciente, MedicoDAOIm medico,RecetaDAOIm receta, TurnoDAOIm turno) {
        if (instancia == null) {
            instancia = new AtencionMedicoService();
        }
        return instancia;
    }

    public static void reiniciarInstancia() {
        instancia = null;
    }

    public Turno GestionTurnoInit(Turno turno) {
        Turno turnoGestionado = new Turno(turno.getId(), turno.getPaciente(),turno.getMedico(), turno.isRazonParticular());
        turnos.modificar(turnoGestionado);
        return turnoGestionado;
    }

    public Receta GestionRecetaInit(List<Medicamento> medicamentos, Turno turno) {
        if (medicamentos != null) {
            int recetasContadas = recetas.listarTodos().size();
            Receta recetaGestionada = new Receta(recetasContadas + 1, medicamentos, turno.getMedico());
            recetas.registrar(recetaGestionada);
            return recetaGestionada;
        }
        return null;
    }
}
