package Services;

import Entity.*;

import java.util.ArrayList;
import java.util.List;

public class GestionFarmaciaService {
    private static GestionFarmaciaService instancia;
    private Farmacia farmacia;
    private Drogueria drogueria;

    public static void reiniciarInstancia() {
        instancia = null;
    }

    private GestionFarmaciaService(Farmacia farmacia, Drogueria drogueria) {
        this.farmacia = farmacia;
        this.drogueria = drogueria;
    }

    public static synchronized GestionFarmaciaService getInstancia(Farmacia farmacia, Drogueria drogueria) {
        if (instancia == null) {
            instancia = new GestionFarmaciaService(farmacia, drogueria);
        }
        return instancia;
    }

    // Verifica que la farmacia tiene stock
    public List<Medicamento> analizarReceta(Receta receta) {
        List<Medicamento> medicamentosEnReceta = receta.getMedicamentos();
        List<Medicamento> medicamentosAReponer = new ArrayList<>();
        for (Medicamento medicamento : medicamentosEnReceta) {
            if (!farmacia.getStockmedicamentos().contains(medicamento)) {
                medicamentosAReponer.add(medicamento);
            }
        }
        return medicamentosAReponer;
    }

    public void compraReceta(Receta receta) {
        List<Medicamento> medicamentosEnReceta = receta.getMedicamentos();
        for (Medicamento medicamento : medicamentosEnReceta) {
            farmacia.retirarMedicamento(medicamento, medicamento.getCantidad());
        }

    }

    public void reponerMedicamento(List<Medicamento> medicamentos) {
        List<Medicamento> medicamentosEnReceta = medicamentos;
        List<Medicamento> medicamentosEnDrogueria = new ArrayList<>();
        for (Medicamento medicamento : medicamentosEnReceta) {
              medicamentosEnDrogueria.add(drogueria.getMedicamentosEnDrogueria(medicamento));
        }
        for (Medicamento medicamentoEnDrogueria : medicamentosEnDrogueria) {
            farmacia.solicitarMedicamento(medicamentoEnDrogueria, medicamentoEnDrogueria.getCantidad());
        }
    }

}
