package TestServices;

import DAO.Implements.MedicoDAOIm;
import DAO.Implements.PacienteDAOIm;
import DAO.Implements.RecetaDAOIm;
import DAO.Implements.TurnoDAOIm;
import DAO.Interface.MedicoDAO;
import DAO.Interface.PacienteDAO;
import DAO.Interface.RecetaDAO;
import DAO.Interface.TurnoDAO;
import Entity.*;
import Services.AtencionMedicoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAtencionMedicoService {
    private AtencionMedicoService atencionMedicoService;

    @Mock
    private PacienteDAOIm pacienteDAO;

    @Mock
    private MedicoDAOIm medicoDAO;

    @Mock
    private RecetaDAOIm recetaDAO;

    @Mock
    private TurnoDAOIm turnoDAO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        atencionMedicoService = AtencionMedicoService.getInstancia(pacienteDAO, medicoDAO, recetaDAO, turnoDAO);
        atencionMedicoService.reiniciarInstancia();
    }

    @Test
    public void testGestionTurnoInit() {
        Turno turno = new Turno(1, new Paciente(), new Medico(), false);
        Turno turnoGestionado = atencionMedicoService.GestionTurnoInit(turno);

        assertEquals(turno, turnoGestionado);
    }

    @Test
    public void testGestionRecetaInitWithMedicamentos() {
        List<Medicamento> medicamentos = new ArrayList<>();
        medicamentos.add(new Medicamento(1, "Paracetamol", 10));
        medicamentos.add(new Medicamento(2, "Omeprazol", 10));

        Turno turno = new Turno(1, new Paciente(), new Medico(), false);
        Receta recetaGestionada = atencionMedicoService.GestionRecetaInit(medicamentos, turno);

        assertEquals(1, recetaGestionada.getId());
        assertEquals(medicamentos, recetaGestionada.getMedicamentos());
        assertEquals(turno.getMedico(), recetaGestionada.getMedico());
    }

    @Test
    public void testGestionRecetaInitWithoutMedicamentos() {
        Turno turno = new Turno(1, new Paciente(), new Medico(), false);
        Receta recetaGestionada = atencionMedicoService.GestionRecetaInit(null, turno);

        assertEquals(null, recetaGestionada);
    }

}
