package TestServices;

import DAO.Interface.EspecialidadDAO;
import DAO.Interface.MedicoDAO;
import DAO.Interface.PacienteDAO;
import DAO.Interface.TurnoDAO;
import Entity.*;
import Services.GestionTurnoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGestionTurnoService {
    private static GestionTurnoService gestionTurnoService;

    @Mock
    private TurnoDAO turnoDAO;

    @Mock
    private PacienteDAO pacienteDAO;

    @Mock
    private MedicoDAO medicoDAO;

    @Mock
    private EspecialidadDAO especialidadDAO;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        gestionTurnoService = GestionTurnoService.getInstancia(turnoDAO,medicoDAO,pacienteDAO,especialidadDAO);
        gestionTurnoService.reiniciarInstancia();

    }


    @Test
    public void testSolicitarMedicoEspecialidad() {
        List<ObraSocial> obraSociales = new ArrayList<>();
        ObraSocial sancorSalud = new ObraSocial(1, "sancor salud");
        ObraSocial osde = new ObraSocial(2,"OSDE");

        Especialidad traumatologo = new Especialidad(1, "Traumatologo");
        Especialidad cardiologo = new Especialidad(2, "Cardiologo");

        List<Medico> medicos = new ArrayList<>();
        Medico medico = new Medico(1,"Armado","Huesillo",obraSociales,traumatologo);
        Medico medico1= new Medico(2,"Luis", "Ramirez",obraSociales,traumatologo);
        Medico medico2= new Medico(3,"Javier","Hernandez",obraSociales,cardiologo);
        medicos.add(medico);
        medicos.add(medico1);
        medicos.add(medico2);

        Paciente paciente = new Paciente(1,"Juan", "Gomez",sancorSalud);
        Paciente paciente1 = new Paciente(2, "Humberto", "Tonico",osde);

        Mockito.when(medicoDAO.findEspecialidad(traumatologo)).thenReturn(medicos);
        List<Medico> traumatologos = gestionTurnoService.solicitarMedicoEspecialidad(paciente,traumatologo,false);
        for (Medico medicoResult: traumatologos ){
            assertEquals(medicoResult.getNombre(),medico.getNombre());
        }

    }

    @Test
    public void testMedicosEspecialidadRazonParticular() {
        List<ObraSocial> obraSociales = new ArrayList<>();
        ObraSocial sancorSalud = new ObraSocial(1, "sancor salud");
        ObraSocial osde = new ObraSocial(2,"OSDE");

        Especialidad traumatologo = new Especialidad(1, "Traumatologo");
        Especialidad cardiologo = new Especialidad(2, "Cardiologo");

        List<Medico> medicos = new ArrayList<>();
        Medico medico = new Medico(1,"Armado","Huesillo",obraSociales,traumatologo);
        Medico medico1= new Medico(2,"Luis", "Ramirez",obraSociales,traumatologo);
        Medico medico2= new Medico(3,"Javier","Hernandez",obraSociales,cardiologo);
        medicos.add(medico);
        medicos.add(medico1);
        medicos.add(medico2);

        Paciente paciente = new Paciente(1,"Juan", "Gomez",sancorSalud);

        Mockito.when(medicoDAO.findEspecialidad(traumatologo)).thenReturn(medicos);
        List<Medico> traumatologos = gestionTurnoService.solicitarMedicoEspecialidad(paciente,traumatologo,true);
        assertEquals(medicos, traumatologos);
    }

    @Test
    public void testSolicitarTurno(){
        List<ObraSocial> obraSociales = new ArrayList<>();
        ObraSocial sancorSalud = new ObraSocial(1, "sancor salud");
        ObraSocial osde = new ObraSocial(2,"OSDE");
        ObraSocial swissMedical = new ObraSocial(2,"Swiss Medical");

        Especialidad traumatologo = new Especialidad(1, "Traumatologo");
        Medico medico = new Medico(1,"Armado","Huesillo",obraSociales,traumatologo);
        Paciente paciente = new Paciente(1,"Juan", "Gomez",sancorSalud);

        gestionTurnoService.solicitarTurno(paciente,medico,traumatologo,false);
        Mockito.verify(turnoDAO).registrar(Mockito.any(Turno.class));

    }

}
