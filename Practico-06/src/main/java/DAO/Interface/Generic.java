package DAO.Interface;

import java.util.List;

public interface Generic<X>{
    List<X> listarTodos();
    X buscarPorId(int id);
    void registrar(X x);
    void modificar(X x);
    void eliminar(int id);
}
