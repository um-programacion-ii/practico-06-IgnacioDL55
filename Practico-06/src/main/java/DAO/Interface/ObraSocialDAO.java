package DAO.Interface;

import Entity.ObraSocial;

import java.util.List;

public interface ObraSocialDAO extends Generic<ObraSocial> {
    List<ObraSocial> findNombre(String nombre);

}
