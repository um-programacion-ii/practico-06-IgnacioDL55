package TestDAO;

import DAO.Implements.ObraSocialDAOIm;
import DAO.Interface.ObraSocialDAO;
import Entity.ObraSocial;
import Entity.Paciente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestObraSocialDAO {
    private ObraSocialDAO obraSocialDAO;

    @BeforeEach
    public void setUp() {
        obraSocialDAO = new ObraSocialDAOIm();
    }

    @Test
    public void testFindByNombre() {
        ObraSocial obraSocial = new ObraSocial(1,"osde");
        ObraSocial obraSocial2 = new ObraSocial(2,"osep");
        ObraSocial obraSocial3 = new ObraSocial(3,"sanco salud");
        obraSocialDAO.registrar(obraSocial);
        obraSocialDAO.registrar(obraSocial2);
        obraSocialDAO.registrar(obraSocial3);
        assertEquals("osde", obraSocialDAO.buscarPorId(1).getNombre());
    }

    @Test
    public void testListarObraSociales(){
        ObraSocial obraSocial = new ObraSocial(1,"osde");
        ObraSocial obraSocial2 = new ObraSocial(2,"osep");
        ObraSocial obraSocial3 = new ObraSocial(3,"sanco salud");
        obraSocialDAO.registrar(obraSocial);
        obraSocialDAO.registrar(obraSocial2);
        obraSocialDAO.registrar(obraSocial3);
        List<ObraSocial> ObrasSocialListados= obraSocialDAO.listarTodos();
        assertEquals(Arrays.asList(obraSocial,obraSocial2,obraSocial3), ObrasSocialListados);
    }

    @Test
    public void testRegistrar(){
        ObraSocial obraSocial = new ObraSocial(1,"osde");
        obraSocialDAO.registrar(obraSocial);
        assertEquals(obraSocial, obraSocialDAO.buscarPorId(1));
    }

    @Test
    public void testModificar(){
        ObraSocial obraSocial = new ObraSocial(1,"osde");
        obraSocialDAO.registrar(obraSocial);
        obraSocial.setNombre("ospe");
        obraSocialDAO.modificar(obraSocial);
        assertEquals(obraSocial, obraSocialDAO.buscarPorId(1));
    }

    @Test
    public void testEliminar(){
        ObraSocial obraSocial = new ObraSocial(1,"osde");
        obraSocialDAO.registrar(obraSocial);
        obraSocialDAO.eliminar(obraSocial.getId());
        assertEquals(null, obraSocialDAO.buscarPorId(1));
    }
}

