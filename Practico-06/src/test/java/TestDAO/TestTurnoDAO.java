package TestDAO;

import DAO.Implements.TurnoDAOIm;
import DAO.Interface.TurnoDAO;
import Entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTurnoDAO {
    private TurnoDAO turnoDAO;

    @BeforeEach
    public void setUp() {
        turnoDAO = new TurnoDAOIm();
    }

    List<ObraSocial> obraSociales = new ArrayList<>();
    ObraSocial sancorSalud = new ObraSocial(1, "sancor salud");
    ObraSocial osde = new ObraSocial(2,"OSDE");

    Especialidad traumatologo = new Especialidad(1, "Traumatologo");
    Especialidad cardiologo = new Especialidad(2, "Cardiologo");
    Medico medico1 = new Medico(1,"Pablo","Lopez", obraSociales, traumatologo);
    Medico medico2 = new Medico(2,"Jose", "Perez", obraSociales ,cardiologo);
    Paciente paciente0 = new Paciente(1, "Franco", "Fernandez", osde);
    Paciente paciente1 = new Paciente(2, "Francisco", "Oliva", osde);
    Paciente paciente2 = new Paciente(3, "Franco", "Hernandez", sancorSalud);


    @Test
    public void testFindByPaciente(){
        Turno turno = new Turno(1,paciente0,medico1,false);
        Turno turno2 = new Turno(2,paciente1,medico1,false);
        turnoDAO.registrar(turno);
        turnoDAO.registrar(turno2);
        assertEquals(paciente1, turno2.getPaciente());
    }

    @Test
    public void testFindByMedico(){
        Turno turno = new Turno(1,paciente0,medico1,false);
        Turno turno2 = new Turno(2,paciente1,medico2,false);
        turnoDAO.registrar(turno);
        turnoDAO.registrar(turno2);
        assertEquals(medico1, turno.getMedico());
    }

    @Test
    public void testFindByRazon(){
        Turno turno = new Turno(1,paciente0,medico1,false);
        Turno turno2 = new Turno(2,paciente1,medico2,true);
        turnoDAO.registrar(turno);
        turnoDAO.registrar(turno2);
        assertTrue(turno2.isRazonParticular());
    }

    @Test
    public void testListarTurnos(){
        Turno turno = new Turno(1,paciente0,medico1,false);
        Turno turno2 = new Turno(2,paciente1,medico2,true);
        turnoDAO.registrar(turno);
        turnoDAO.registrar(turno2);
        List<Turno>turnosListados = turnoDAO.listarTodos();
        assertEquals(Arrays.asList(turno,turno2), turnosListados);
    }

    @Test
    public void testFindId(){
        Turno turno = new Turno(1,paciente0,medico1,false);
        turnoDAO.registrar(turno);
        assertEquals(1, turno.getId());
    }

    @Test
    public void testregistrar(){
        Turno turno = new Turno(1,paciente0,medico1,false);
        turnoDAO.registrar(turno);
        assertEquals(turno, turnoDAO.buscarPorId(1));
    }

    @Test
    public void testmodificar(){
        Turno turno = new Turno(1,paciente0,medico1,false);
        turnoDAO.registrar(turno);
        turno.setPaciente(paciente2);
        turnoDAO.modificar(turno);
        assertEquals(turno, turnoDAO.buscarPorId(1));
    }

    @Test
    public void testeliminar(){
        Turno turno = new Turno(1,paciente0,medico1,false);
        turnoDAO.registrar(turno);
        turnoDAO.eliminar(turno.getId());
        assertEquals(null, turnoDAO.buscarPorId(1));
    }

}
