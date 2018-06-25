/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.CarroMapeamento;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Marcelo Emeka
 */
public class CarroModelo extends conexaoDao {
    public void inserir(CarroMapeamento carro){
        super.inicializar();
        super.getSecao().save(carro);
        super.executar();
    
    }
     public void remover(CarroMapeamento carro){
        super.inicializar();
        super.getSecao().delete(carro);
        super.executar();
    }

   public void editar(CarroMapeamento carro) {
        super.inicializar();
        super.getSecao().update(carro);
        super.executar();
    }
    
    public List<CarroMapeamento> buscarTodos(){
        
        return consulta("from CarroMapeamento");
    }
    
    public List<CarroMapeamento> buscar(CarroMapeamento carmap){
    
        return consulta("from CarroMapeamento where id = " + carmap.getId());
    }
    
    public List<CarroMapeamento> consulta(String sql){
        List<CarroMapeamento> listaFornecedor = new ArrayList<>();
        super.inicializar();
        listaFornecedor = super.getSecao().createQuery(sql).list();
        super.executar();
        return listaFornecedor;
    }
}
