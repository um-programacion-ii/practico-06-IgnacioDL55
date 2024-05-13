package TestServices;

import DAO.Implements.MedicamentoDAOIm;
import DAO.Implements.MedicoDAOIm;
import Entity.*;
import Services.GestionFarmaciaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

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
        gestionFarmaciaService.reiniciarInstancia();

    }

    @Test
    public void testRecetaConStock(){
        List<Medicamento> medicamentosReceta = new ArrayList<>();
        Medicamento medicamento1 = new Medicamento(1,"Paracetamol",100);
        medicamentosReceta.add(medicamento1);
        Receta receta = new Receta(1,medicamentosReceta,new Medico());

        Mockito.when(farmacia.getStockmedicamentos()).thenReturn(medicamentosReceta);
        List<Medicamento> medicamentos = gestionFarmaciaService.analizarReceta(receta);

        assertEquals(medicamentos, Collections.emptyList());
    }

    @Test
    public void testRecetaSinStock(){
        List<Medicamento> medicamentosReceta = new ArrayList<>();
        Medicamento medicamento1 = new Medicamento(1,"Paracetamol",100);
        medicamentosReceta.add(medicamento1);
        Receta receta = new Receta(1,medicamentosReceta,new Medico());

        Mockito.when(farmacia.getStockmedicamentos()).thenReturn(Collections.emptyList());
        List<Medicamento> medicamentos = gestionFarmaciaService.analizarReceta(receta);

        assertEquals(medicamentos, medicamentosReceta);
    }

    @Test
    public void testComprarReceta(){
        List<Medicamento> medicamentosReceta = new ArrayList<>();
        Medicamento medicamento1 = new Medicamento(1,"Paracetamol",100);
        Medicamento medicamento2 = new Medicamento(2,"Ibuprofeno",100);
        medicamentosReceta.add(medicamento1);
        medicamentosReceta.add(medicamento2);
        Receta receta = new Receta(1,medicamentosReceta,new Medico());

        gestionFarmaciaService.compraReceta(receta);
        Mockito.verify(farmacia).retirarMedicamento(medicamento1,100);
        Mockito.verify(farmacia).retirarMedicamento(medicamento2,100);
    }

    @Test
    public void testReponerMedicamento(){
        List<Medicamento> medicamentosReceta = new ArrayList<>();
        Medicamento medicamento1 = new Medicamento(1,"Paracetamol",100);
        medicamentosReceta.add(medicamento1);

        Mockito.when(drogueria.getMedicamentosEnDrogueria(medicamento1)).thenReturn(medicamento1);
        gestionFarmaciaService.reponerMedicamento(medicamentosReceta);
        Mockito.verify(farmacia).solicitarMedicamento(medicamento1,100);
    }

}
