package DAO.Implements;

import DAO.Interface.ObraSocialDAO;
import Entity.ObraSocial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObraSocialDAOIm implements ObraSocialDAO {
    private Map<Integer, ObraSocial> obraSociales = new HashMap<>();

    @Override
    public List<ObraSocial> findNombre(String nombre) {
        List<ObraSocial> obraSocialWithNombre = new ArrayList<>();
        for (ObraSocial obraSocial : obraSociales.values()) {
            if (obraSocial.getNombre().equals(nombre)) {
                obraSocialWithNombre.add(obraSocial);
            }
        }
        return obraSocialWithNombre;
    }

    @Override
    public List<ObraSocial> listarTodos() {
        return new ArrayList<>(obraSociales.values());
    }

    @Override
    public ObraSocial buscarPorId(int id) {
        return obraSociales.get(id);
    }

    @Override
    public void registrar(ObraSocial obraSocial) {
        System.out.println("La obraSocial "+ obraSocial.getNombre()+" ha sido registrado");
        obraSociales.put(obraSocial.getId(), obraSocial);

    }

    @Override
    public void modificar(ObraSocial obraSocial) {
        System.out.println("Obra Social "+ obraSocial.getNombre()+" ha sido modificado");
        obraSociales.put(obraSocial.getId(), obraSocial);

    }

    @Override
    public void eliminar(int id) {
        System.out.println("Obra social: "+ obraSociales.get(id).getNombre()+" eliminado");
        obraSociales.remove(id);

    }
}
