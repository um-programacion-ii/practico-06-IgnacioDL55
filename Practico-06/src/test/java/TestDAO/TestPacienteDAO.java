package TestDAO;

import DAO.Implements.PacienteDAOIm;
import DAO.Interface.PacienteDAO;
import Entity.ObraSocial;
import Entity.Paciente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPacienteDAO {
    private PacienteDAO pacienteDAO;

    @BeforeEach
    public void setUp(){
        pacienteDAO = new PacienteDAOIm();
    }

    ObraSocial sancorSalud = new ObraSocial(1, "sancor salud");
    ObraSocial osde = new ObraSocial(2,"OSDE");
    ObraSocial swissMedical = new ObraSocial(2,"Swiss Medical");

    @Test
    public void testListarPacientes(){
        Paciente paciente0 = new Paciente(1, "Franco", "Fernandez", osde);
        Paciente paciente1 = new Paciente(2, "Francisco", "Oliva", swissMedical);
        Paciente paciente2 = new Paciente(3, "Franco", "Hernandez", sancorSalud);
        pacienteDAO.registrar(paciente0);
        pacienteDAO.registrar(paciente1);
        pacienteDAO.registrar(paciente2);
        List<Paciente> pacientesListados= pacienteDAO.listarTodos();
        assertEquals(Arrays.asList(paciente0,paciente1,paciente2), pacientesListados);



    }

    @Test
    public void testFindId(){
        Paciente paciente = new Paciente(1, "Pepe", "Honguito", sancorSalud );
        pacienteDAO.registrar(paciente);
        assertEquals(1, pacienteDAO.buscarPorId(1).getId() );
    }

    @Test
    public void testRegistrar(){
        Paciente paciente = new Paciente(1, "Pepe", "Honguito", sancorSalud );
        pacienteDAO.registrar(paciente);
        assertEquals(paciente, pacienteDAO.buscarPorId(1));
    }

    @Test
    public void testModificar(){
        Paciente paciente = new Paciente(2, "Luis", "Rojas", osde);
        pacienteDAO.registrar(paciente);
        paciente.setApellido("Rojo");
        pacienteDAO.modificar(paciente);
        assertEquals(paciente, pacienteDAO.buscarPorId(2));
    }

    @Test
    public void testEliminar(){
        Paciente paciente = new Paciente(3, "Samuel", "De Luque", swissMedical);
        pacienteDAO.registrar(paciente);
        pacienteDAO.eliminar(paciente.getId());
        assertEquals(null, pacienteDAO.buscarPorId(3));
    }

    @Test
    public void testFindByNombre(){
        Paciente paciente0 = new Paciente(1, "Franco", "Fernandez", osde);
        Paciente paciente1 = new Paciente(2, "Francisco", "Oliva", swissMedical);
        Paciente paciente2 = new Paciente(3, "Franco", "Hernandez", sancorSalud);
        pacienteDAO.registrar(paciente0);
        pacienteDAO.registrar(paciente1);
        pacienteDAO.registrar(paciente2);
        assertEquals("Franco", pacienteDAO.buscarPorId(1).getNombre(), pacienteDAO.buscarPorId(3).getApellido());

    }
    @Test
    public void testFindByApellido(){
        Paciente paciente0 = new Paciente(1, "Franco", "Fernandez", osde);
        Paciente paciente1 = new Paciente(2, "Francisco", "Oliva", swissMedical);
        Paciente paciente2 = new Paciente(3, "Franco", "Hernandez", sancorSalud);
        pacienteDAO.registrar(paciente0);
        pacienteDAO.registrar(paciente1);
        pacienteDAO.registrar(paciente2);
        assertEquals("Hernandez",pacienteDAO.buscarPorId(3).getApellido());
    }

    @Test
    public void testFindByObraSocial(){
        Paciente paciente0 = new Paciente(1, "Franco", "Fernandez", osde);
        Paciente paciente1 = new Paciente(2, "Francisco", "Oliva", swissMedical);
        Paciente paciente2 = new Paciente(3, "Franco", "Hernandez", sancorSalud);
        pacienteDAO.registrar(paciente0);
        pacienteDAO.registrar(paciente1);
        pacienteDAO.registrar(paciente2);
        assertEquals(osde, pacienteDAO.buscarPorId(1).getObraSocial());
    }


}
