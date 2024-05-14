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

import java.security.cert.TrustAnchor;
import java.util.ArrayList;
import java.util.Arrays;
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
        ObraSocial sancorSalud = new ObraSocial(1, "sancor salud");
        ObraSocial osde = new ObraSocial(2,"OSDE");

        Especialidad traumatologo = new Especialidad(1, "Traumatologo");
        Especialidad cardiologo = new Especialidad(2, "Cardiologo");

        List<Medico> medicos = new ArrayList<>();
        Medico medico = new Medico(1,"Armado","Huesillo",Arrays.asList(sancorSalud),traumatologo);
        Medico medico1= new Medico(2,"Luis", "Ramirez",Arrays.asList(osde,sancorSalud),traumatologo);
        Medico medico2= new Medico(3,"Javier","Hernandez",Arrays.asList(osde),cardiologo);
        Medico medico3= new Medico(4,"Pepe","Argento",Arrays.asList(osde,sancorSalud),cardiologo);
        medicos.add(medico);
        medicos.add(medico1);
        medicos.add(medico2);
        medicos.add(medico3);

        Paciente paciente1 = new Paciente(2, "Humberto", "Tonico",osde);

        Mockito.when(medicoDAO.findEspecialidad(cardiologo)).thenReturn(medicos);
        List<Medico> cardiologos = gestionTurnoService.solicitarMedicoEspecialidad(paciente1,cardiologo,false);
        List<Medico> medicosEsperados = Arrays.asList(medico2,medico3);
        assertEquals(medicosEsperados,cardiologos);

        System.out.println(cardiologos);
        System.out.println(medicosEsperados);

    }

    @Test
    public void testMedicosEspecialidadRazonParticular() {

        ObraSocial sancorSalud = new ObraSocial(1, "sancor salud");
        ObraSocial osde = new ObraSocial(2,"OSDE");

        Especialidad traumatologo = new Especialidad(1, "Traumatologo");
        Especialidad cardiologo = new Especialidad(2, "Cardiologo");

        List<Medico> medicos = new ArrayList<>();
        Medico medico = new Medico(1,"Armado","Huesillo",Arrays.asList(sancorSalud),traumatologo);
        Medico medico1= new Medico(2,"Luis", "Ramirez",Arrays.asList(osde,sancorSalud),traumatologo);
        Medico medico2= new Medico(3,"Javier","Hernandez",Arrays.asList(osde),traumatologo);
        Medico medico3= new Medico(4,"Pepe","Argento",Arrays.asList(osde,sancorSalud),cardiologo);


        medicos.add(medico);
        medicos.add(medico1);
        medicos.add(medico2);
        medicos.add(medico3);

        Paciente paciente = new Paciente(1,"Juan", "Gomez",null);

        Mockito.when(medicoDAO.findEspecialidad(traumatologo)).thenReturn(medicos);
        List<Medico> traumatologos = gestionTurnoService.solicitarMedicoEspecialidad(paciente,traumatologo,true);
        List<Medico> medicosEsperados = Arrays.asList(medico,medico1,medico2);
        assertEquals(medicosEsperados, traumatologos);

    }

    @Test
    public void testSolicitarTurno(){
        ObraSocial sancorSalud = new ObraSocial(1, "sancor salud");

        Especialidad traumatologo = new Especialidad(1, "Traumatologo");

        Medico medico = new Medico(1,"Armado","Huesillo",Arrays.asList(sancorSalud),traumatologo);

        Paciente paciente = new Paciente(1,"Juan", "Gomez",sancorSalud);

        gestionTurnoService.solicitarTurno(paciente,medico,traumatologo,false);
        Mockito.verify(turnoDAO).registrar(Mockito.any(Turno.class));

    }


}
