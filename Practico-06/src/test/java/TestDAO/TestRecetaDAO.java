package TestDAO;

import DAO.Implements.RecetaDAOIm;
import DAO.Interface.RecetaDAO;
import Entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRecetaDAO {
    private RecetaDAO recetaDAO;

    @BeforeEach
    public void setUp() {
        recetaDAO = new RecetaDAOIm();
    }

    List<ObraSocial> obraSociales = new ArrayList<>();
    ObraSocial sancorSalud = new ObraSocial(1, "sancor salud");
    ObraSocial osde = new ObraSocial(2,"OSDE");
    ObraSocial swissMedical = new ObraSocial(2,"Swiss Medical");
    Especialidad traumatologo = new Especialidad(1, "Traumatologo");
    Especialidad cardiologo = new Especialidad(2, "Cardiologo");
    Medico medico1 = new Medico(1,"Pablo","Lopez", obraSociales, traumatologo);
    Medico medico2 = new Medico(2,"Jose", "Perez", obraSociales ,cardiologo);
    List<Medicamento> medicamentos = new ArrayList<>();
    Medicamento medicamento = new Medicamento(1, "Paracetamol", 10);
    Medicamento medicamento2 = new Medicamento(2, "Ibuprofeno", 10);
    Medicamento medicamento3 = new Medicamento(3, "Aspirina", 10);

    @Test
    public void testFindMedicamento() {
        medicamentos.add(medicamento);
        medicamentos.add(medicamento2);
        Receta receta = new Receta(1,medicamentos,medico1);
        recetaDAO.registrar(receta);
        assertEquals(medicamento, receta.getMedicamentos().get(0));
    }

    @Test
    public void testFindMedico() {
        medicamentos.add(medicamento);
        medicamentos.add(medicamento2);
        Receta receta = new Receta(1,medicamentos,medico1);
        Receta receta1 = new Receta(2,medicamentos,medico2);
        recetaDAO.registrar(receta);
        recetaDAO.registrar(receta1);
        assertEquals(medico2, receta1.getMedico());
    }

    @Test
    public void testListarRecetas() {
        medicamentos.add(medicamento);
        medicamentos.add(medicamento2);
        Receta receta = new Receta(1,medicamentos,medico1);
        Receta receta1 = new Receta(2,medicamentos,medico2);
        recetaDAO.registrar(receta);
        recetaDAO.registrar(receta1);
        List<Receta> recetasListadas = recetaDAO.listarTodos();
        assertEquals(Arrays.asList(receta,receta1), recetasListadas);
    }

    @Test
    public void testFindById() {
        Receta receta = new Receta(1,medicamentos,medico1);
        recetaDAO.registrar(receta);
        assertEquals(receta, recetaDAO.buscarPorId(1));
    }

    @Test
    public void testRegistrar() {
        Receta receta = new Receta(1,medicamentos,medico1);
        recetaDAO.registrar(receta);
        assertEquals(receta, recetaDAO.buscarPorId(1));
    }

    @Test
    public void testModificar(){
        Receta receta = new Receta(1,medicamentos,medico1);
        recetaDAO.registrar(receta);
        receta.setMedico(medico2);
        recetaDAO.modificar(receta);
        assertEquals(receta, recetaDAO.buscarPorId(1));
    }

    @Test
    public void testEliminar() {
        Receta receta = new Receta(1,medicamentos,medico1);
        recetaDAO.registrar(receta);
        recetaDAO.eliminar(receta.getId());
        assertEquals(null, recetaDAO.buscarPorId(1));
    }


}

