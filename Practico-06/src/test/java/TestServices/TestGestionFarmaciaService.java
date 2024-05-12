package TestServices;

import Entity.*;
import Services.GestionFarmaciaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestGestionFarmaciaService {
    private GestionFarmaciaService gestionFarmaciaService;

    @Mock
    private Farmacia farmacia;

    @Mock
    private Drogueria drogueria;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        gestionFarmaciaService = GestionFarmaciaService.getInstancia(farmacia, drogueria);
    }

    @Test
    public void testRecetaConStock(){
        Medicamento medicamento1 = new Medicamento(1,"Paracetamol",100);
        Medicamento medicamento2 = new Medicamento(2,"Ibuprofeno",5);
        List<Medicamento> medicamentosReceta = new ArrayList<>();
        medicamentosReceta.add(medicamento1);
        medicamentosReceta.add(medicamento2);
        Receta receta = new Receta(1,medicamentosReceta,new Medico());
        boolean resultado = gestionFarmaciaService.analizarReceta(receta);
        assertTrue(resultado);
    }

}
