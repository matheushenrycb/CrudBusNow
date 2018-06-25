/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.UsuarioMapeamento;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Marcelo Emeka
 */
public class UsuarioModelo extends conexaoDao {
    public void inserir(UsuarioMapeamento usuario){
        super.inicializar();
        super.getSecao().save(usuario);
        super.executar();
    
    }
     public void remover(UsuarioMapeamento usuario){
        super.inicializar();
        super.getSecao().delete(usuario);
        super.executar();
    }

   public void editar(UsuarioMapeamento usuario) {
        super.inicializar();
        super.getSecao().update(usuario);
        super.executar();
    }
    
    public List<UsuarioMapeamento> buscarTodos(){
        
        return consulta("from UsuarioMapamento");
    }
    
    public List<UsuarioMapeamento> buscar(UsuarioMapeamento usermap){
    
        return consulta("from UsuarioMapeamento where id = " + usermap.getId());
    }
    
    public List<UsuarioMapeamento> consulta(String sql){
        List<UsuarioMapeamento> listausuario = new ArrayList<>();
        super.inicializar();
        listausuario = super.getSecao().createQuery(sql).list();
        super.executar();
        return listausuario;
    }
}
