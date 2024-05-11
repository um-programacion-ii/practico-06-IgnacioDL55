package Services;

import Entity.*;

import java.util.List;

public class GestionFarmaciaService {
    private static GestionFarmaciaService instancia;
    private Farmacia farmacia;
    private Drogueria drogueria;

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
    public boolean analizarReceta(Receta receta) {
        List<Medicamento> medicamentosEnStock = receta.getMedicamentos();
        for (Medicamento medicamento : medicamentosEnStock) {
            if (!farmacia.getStockmedicamentos().contains(medicamento)) {
                return false;
            }
        }
        return true;
    }

    public void compraReceta(Receta receta) {
        if (analizarReceta(receta)) {
            List<Medicamento> medicamentosEnReceta = receta.getMedicamentos();
            for (Medicamento medicamento : medicamentosEnReceta) {
                farmacia.retirarMedicamento(medicamento, medicamento.getCantidad());
            }
        } else {
            List<Medicamento> medicamentosEnReceta = receta.getMedicamentos();
            for (Medicamento medicamento : medicamentosEnReceta) {
                List<Medicamento> medicamentosEnDrogueria = drogueria.getMedicamentosEnDrogueria(List.of(medicamento));
                for (Medicamento medicamentoEnDrogueria : medicamentosEnDrogueria) {
                    farmacia.solicitarMedicamento(medicamentoEnDrogueria, medicamentoEnDrogueria.getCantidad());
                }
            }
        }
    }

}
