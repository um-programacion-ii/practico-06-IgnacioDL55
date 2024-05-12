package TestDAO;

import DAO.Implements.EspecialidadDAOIm;
import DAO.Interface.EspecialidadDAO;
import Entity.Especialidad;
import Entity.ObraSocial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEspecialidadDAO {
    private EspecialidadDAO especialidadDAO;

    @BeforeEach
    public void setUp() {
        especialidadDAO = new EspecialidadDAOIm();
    }

    @Test
    public void testFindByNombre() {
        Especialidad traumatologia = new Especialidad(1, "Traumatologia");
        Especialidad cardiologia = new Especialidad(2, "Cardiologia");
        Especialidad cirujano = new Especialidad(3, "Cirujano");
        especialidadDAO.registrar(traumatologia);
        especialidadDAO.registrar(cardiologia);
        especialidadDAO.registrar(cirujano);
        assertEquals("Cirujano", especialidadDAO.buscarPorId(3).getNombre());
    }

    @Test
    public void testListarObraSociales(){
        Especialidad traumatologia = new Especialidad(1, "Traumatologia");
        Especialidad cardiologia = new Especialidad(2, "Cardiologia");
        Especialidad cirujano = new Especialidad(3, "Cirujano");
        especialidadDAO.registrar(traumatologia);
        especialidadDAO.registrar(cardiologia);
        especialidadDAO.registrar(cirujano);
        List<Especialidad> EspecialidadesListados= especialidadDAO.listarTodos();
        assertEquals(Arrays.asList(traumatologia,cardiologia,cirujano), EspecialidadesListados);
    }

    @Test
    public void testRegistrar(){
        Especialidad traumatologia = new Especialidad(1, "Traumatologia");
        especialidadDAO.registrar(traumatologia);
        assertEquals(traumatologia, especialidadDAO.buscarPorId(1));
    }

    @Test
    public void testModificar(){
        Especialidad traumatologia = new Especialidad(1, "Traumatologia");
        especialidadDAO.registrar(traumatologia);
        traumatologia.setNombre("Traumatologo");
        especialidadDAO.modificar(traumatologia);
        assertEquals(traumatologia, especialidadDAO.buscarPorId(1));

    }

    @Test
    public void testEliminar(){
        Especialidad traumatologia = new Especialidad(1, "Traumatologia");
        especialidadDAO.registrar(traumatologia);
        especialidadDAO.eliminar(traumatologia.getId());
        assertEquals(null, especialidadDAO.buscarPorId(1));
    }

}
