package TestDAO;

import DAO.Implements.MedicamentoDAOIm;
import DAO.Interface.MedicamentoDAO;
import Entity.Medicamento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMedicamentoDAO {
    private MedicamentoDAO medicamentoDAO;

    @BeforeEach
    public void setUp() {
        medicamentoDAO = new MedicamentoDAOIm();
    }

    @Test
    public void testListarMedicamentos() {
        Medicamento medicamento = new Medicamento(1, "Paracetamol", 10);
        Medicamento medicamento2 = new Medicamento(2, "Ibuprofeno", 10);
        Medicamento medicamento3 = new Medicamento(3, "Aspirina", 10);
        medicamentoDAO.registrar(medicamento);
        medicamentoDAO.registrar(medicamento2);
        medicamentoDAO.registrar(medicamento3);
        List<Medicamento> medicamentosListados = medicamentoDAO.listarTodos();
        assertEquals(Arrays.asList(medicamento, medicamento2,medicamento3), medicamentosListados);
    }

    @Test
    public void testFindId() {
        Medicamento medicamento = new Medicamento(1, "Paracetamol", 10);
        medicamentoDAO.registrar(medicamento);
        assertEquals(1, medicamento.getId());
    }

    @Test
    public void testRegistrar() {
        Medicamento medicamento = new Medicamento(1, "Paracetamol", 10);
        medicamentoDAO.registrar(medicamento);
        assertEquals(medicamento, medicamentoDAO.buscarPorId(1));
    }

    @Test
    public void testModificar() {
        Medicamento medicamento = new Medicamento(1, "Paracetamol", 10);
        medicamentoDAO.registrar(medicamento);
        medicamento.setNombre("Ibuprofeno");
        medicamentoDAO.modificar(medicamento);
        assertEquals(medicamento, medicamentoDAO.buscarPorId(1));
    }

    @Test
    public void testEliminar() {
        Medicamento medicamento = new Medicamento(1, "Paracetamol", 10);
        medicamentoDAO.registrar(medicamento);
        medicamentoDAO.eliminar(medicamento.getId());
        assertEquals(null, medicamentoDAO.buscarPorId(1));
    }

    @Test
    public void FindByNombre(){
        Medicamento medicamento = new Medicamento(1, "Paracetamol", 10);
        Medicamento medicamento2 = new Medicamento(2, "Ibuprofeno", 10);
        Medicamento medicamento3 = new Medicamento(3, "Aspirina", 10);
        medicamentoDAO.registrar(medicamento);
        medicamentoDAO.registrar(medicamento2);
        medicamentoDAO.registrar(medicamento3);
        assertEquals("Aspirina", medicamentoDAO.buscarPorId(3).getNombre());
    }

    @Test
    public void FindByCantidad() {
        Medicamento medicamento = new Medicamento(1, "Paracetamol", 10);
        Medicamento medicamento2 = new Medicamento(2, "Ibuprofeno", 13);
        Medicamento medicamento3 = new Medicamento(3, "Aspirina", 11);
        medicamentoDAO.registrar(medicamento);
        medicamentoDAO.registrar(medicamento2);
        medicamentoDAO.registrar(medicamento3);
        assertEquals(10, medicamentoDAO.buscarPorId(1).getCantidad());
    }
}
