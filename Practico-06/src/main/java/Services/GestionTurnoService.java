package Services;

import DAO.Implements.TurnoDAOIm;
import DAO.Interface.MedicoDAO;
import DAO.Interface.PacienteDAO;
import DAO.Interface.TurnoDAO;
import Entity.*;

import java.util.ArrayList;
import java.util.List;

public class GestionTurnoService {
    private static GestionTurnoService instancia;
    private TurnoDAO turnoDAO;
    private PacienteDAO pacienteDAO;
    private MedicoDAO medicoDAO;


    private GestionTurnoService(TurnoDAO turnoDAO) {
        this.turnoDAO = turnoDAO;
    }

    public static synchronized GestionTurnoService getInstancia(TurnoDAO turnoDAO, MedicoDAO medicoDAO, PacienteDAO pacienteDAO) {
        if (instancia == null) {
            instancia = new GestionTurnoService(turnoDAO);
        }
        return instancia;
    }

    private GestionTurnoService(TurnoDAO turnoDAO, PacienteDAO pacienteDAO, MedicoDAO medicoDAO) {
        this.turnoDAO = turnoDAO;
        this.medicoDAO = medicoDAO;
        this.pacienteDAO = pacienteDAO;
    }

    public static void reiniciarInstancia() {
        instancia = null;
    }

    public List<Medico> solicitarMedicoEspecialidad(Paciente paciente, Especialidad especialidad, boolean razonP){
        List<Medico> medicoEspecialidad = medicoDAO.findEspecialidad(especialidad);
        List<Medico> mFiltrado = new ArrayList<Medico>();
        for (Medico medicos : medicoEspecialidad){
            if (medicos.getObraSocialRecibidas().contains(paciente.getObraSocial()) && medicos.getEspecialidad() != null){
                mFiltrado.add(medicos);
                System.out.println("Medicos: " + mFiltrado);
            } else if (razonP){
                mFiltrado = medicoEspecialidad;
            }
        }
        return mFiltrado;
    }

    public void solicitarTurno(Paciente paciente, Medico medico,Especialidad especialidad, boolean razonP){
        if (paciente == null || medico == null || especialidad == null) {
            System.out.println("Error, faltan datos para generar el turno");
        } else {
            Turno turno1 = new Turno(1,paciente,medico,razonP);
            turnoDAO.registrar(turno1);
        }
    }
}
