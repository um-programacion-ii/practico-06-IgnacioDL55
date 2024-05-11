package TestDAO;

import DAO.Implements.MedicoDAOIm;
import DAO.Implements.PacienteDAOIm;
import DAO.Interface.MedicoDAO;
import Entity.Especialidad;
import Entity.Medico;
import Entity.ObraSocial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMedicoDAO {
    private MedicoDAO medicoDA0;

    @BeforeEach
    public void setUp() {
        medicoDA0 = new MedicoDAOIm();

    }

    List<ObraSocial> obraSociales = new ArrayList<>();
    ObraSocial sancorSalud = new ObraSocial(1, "sancor salud");
    ObraSocial osde = new ObraSocial(2,"OSDE");
    ObraSocial swissMedical = new ObraSocial(2,"Swiss Medical");

    Especialidad traumatologo = new Especialidad(1, "Traumatologo");
    Especialidad cardiologo = new Especialidad(2, "Cardiologo");


    @Test
    public void testListaMedicos() {
        List<ObraSocial> obraSocialesMedico2 = new ArrayList<>();
        obraSocialesMedico2.add(sancorSalud);
        obraSociales.add(sancorSalud);
        obraSociales.add(osde);
        Medico medico1 = new Medico(1,"Pablo","Lopez", obraSociales, traumatologo);
        Medico medico2 = new Medico(2,"Jose", "Perez", obraSocialesMedico2 ,cardiologo);
        medicoDA0.registrar(medico1);
        medicoDA0.registrar(medico2);
        List<Medico> medicosListados = medicoDA0.listarTodos();
        assertEquals(Arrays.asList(medico1, medico2), medicosListados);
    }

    @Test
    public void testFindId() {
        Medico medico = new Medico(1,"Pablo","Lopez", obraSociales,traumatologo);
        medicoDA0.registrar(medico);
        assertEquals(1, medico.getId());
    }

    @Test
    public void testRegistrar() {
        Medico medico = new Medico(1,"Pablo","Lopez", obraSociales,traumatologo);
        medicoDA0.registrar(medico);
        assertEquals(medico, medicoDA0.buscarPorId(1));
    }

    @Test
    public void testModificar() {
        Medico medico = new Medico(1,"Pablo","Lopez", obraSociales,traumatologo);
        medicoDA0.registrar(medico);
        medico.setApellido("Garcia");
        medicoDA0.modificar(medico);
        assertEquals(medico, medicoDA0.buscarPorId(1));
    }

    @Test
    public void testEliminar() {
        Medico medico = new Medico(1,"Pablo","Lopez", obraSociales,traumatologo);
        medicoDA0.registrar(medico);
        medicoDA0.eliminar(medico.getId());
        assertEquals(null, medicoDA0.buscarPorId(1));
    }

    @Test
    public void testFindByNombre() {
        List<ObraSocial> obraSocialesMedico2 = new ArrayList<>();
        obraSocialesMedico2.add(sancorSalud);
        obraSociales.add(sancorSalud);
        obraSociales.add(osde);
        Medico medico1 = new Medico(1,"Pablo","Lopez", obraSociales, traumatologo);
        Medico medico2 = new Medico(2,"Jose", "Perez", obraSocialesMedico2 ,cardiologo);
        medicoDA0.registrar(medico1);
        medicoDA0.registrar(medico2);
        assertEquals("Pablo", medicoDA0.buscarPorId(1).getNombre());

    }

    @Test
    public void testFindByApellido() {
        List<ObraSocial> obraSocialesMedico2 = new ArrayList<>();
        obraSocialesMedico2.add(sancorSalud);
        obraSociales.add(sancorSalud);
        obraSociales.add(osde);
        Medico medico1 = new Medico(1,"Pablo","Lopez", obraSociales, traumatologo);
        Medico medico2 = new Medico(2,"Jose", "Perez", obraSocialesMedico2 ,cardiologo);
        medicoDA0.registrar(medico1);
        medicoDA0.registrar(medico2);
        assertEquals("Perez", medicoDA0.buscarPorId(2).getApellido());
    }

    @Test
    public void testFindObraSocial() {
        List<ObraSocial> obraSocialesMedico2 = new ArrayList<>();
        obraSocialesMedico2.add(sancorSalud);
        obraSociales.add(sancorSalud);
        obraSociales.add(osde);
        Medico medico1 = new Medico(1,"Pablo","Lopez", obraSociales, traumatologo);
        Medico medico2 = new Medico(2,"Jose", "Perez", obraSocialesMedico2 ,cardiologo);
        medicoDA0.registrar(medico1);
        medicoDA0.registrar(medico2);
        assertEquals(osde, medicoDA0.buscarPorId(1).getObraSocialRecibidas().get(1) );
    }

    @Test
    public void testFindEspecialidad() {
        List<ObraSocial> obraSocialesMedico2 = new ArrayList<>();
        obraSocialesMedico2.add(sancorSalud);
        obraSociales.add(sancorSalud);
        obraSociales.add(osde);
        Medico medico1 = new Medico(1,"Pablo","Lopez", obraSociales, traumatologo);
        Medico medico2 = new Medico(2,"Jose", "Perez", obraSocialesMedico2 ,cardiologo);
        medicoDA0.registrar(medico1);
        medicoDA0.registrar(medico2);
        assertEquals(traumatologo, medicoDA0.buscarPorId(1).getEspecialidad());
    }

}
