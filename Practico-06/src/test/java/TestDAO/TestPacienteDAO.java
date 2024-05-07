package TestDAO;

import DAO.Implements.PacienteDAOIm;
import DAO.Interface.PacienteDAO;
import Entity.ObraSocial;
import Entity.Paciente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
