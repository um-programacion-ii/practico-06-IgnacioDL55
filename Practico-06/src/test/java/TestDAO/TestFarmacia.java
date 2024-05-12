package TestDAO;

import Entity.Drogueria;
import Entity.Farmacia;
import Entity.Medicamento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFarmacia {
    private Farmacia farmacia;
    private List<Medicamento> stockMedicamentos;
    private Drogueria drogueria;

    @BeforeEach
    public void setUp() {
        farmacia = new Farmacia();
        stockMedicamentos = new ArrayList<Medicamento>();
        Medicamento medicamento1 = new Medicamento(1, "Paracetamol", 50);
        Medicamento medicamento2 = new Medicamento(2, "Ibuprofeno", 100);
        stockMedicamentos.add(medicamento1);
        stockMedicamentos.add(medicamento2);
        drogueria = new Drogueria();
        farmacia.setStockmedicamentos(stockMedicamentos);
        farmacia.setDrogueriaAsociada(drogueria);


    }

    @Test
    public void testSolicitarMedicamento() {
        Medicamento medicamento1 = stockMedicamentos.get(0);
        farmacia.solicitarMedicamento(medicamento1, 10);
        assertEquals(60,medicamento1.getCantidad());
    }

    @Test
    public void testretirarMedicamento() {
        Medicamento medicamento1 = stockMedicamentos.get(0);
        farmacia.retirarMedicamento(medicamento1, 10);
        assertEquals(40,medicamento1.getCantidad());
    }
}
