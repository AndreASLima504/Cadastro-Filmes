/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import models.FilmeDAO;
import models.FilmeModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andre
 */
public class FilmeController {
    public void Cadastrar(String[] dados) throws SQLException, ClassNotFoundException{
        FilmeModel f = new FilmeModel();
        f.setNome(dados[0]);
        f.setDataLancamento(dados[1]);
        f.setDescricao(dados[2]);
        f.setDiretor(dados[3]);
        f.setDuracaoMin(Integer.parseInt(dados[4]));
        f.setEstrela(dados[5]);
        f.setEstudio(dados[6]);
        f.setNotaImdb(Double.parseDouble(dados[7]));
        f.setPrecoDia(Double.parseDouble(dados[8]));
        f.setGenero(dados[9]);
        
        FilmeDAO fop = new FilmeDAO();
        fop.cadastrar(f);
        
    }
    
    public void deletarId(String id) throws SQLException, ClassNotFoundException{
        FilmeDAO fop = new FilmeDAO();
        fop.deletar(Integer.parseInt(id));
    }
    
    public void atualizar(String[] dados) throws SQLException, ClassNotFoundException{
        FilmeModel f = new FilmeModel();
        f.setNome(dados[0]);
        f.setDataLancamento(dados[1]);
        f.setDescricao(dados[2]);
        f.setDiretor(dados[3]);
        f.setDuracaoMin(Integer.parseInt(dados[4]));
        f.setEstrela(dados[5]);
        f.setEstudio(dados[6]);
        f.setNotaImdb(Double.parseDouble(dados[7]));
        f.setPrecoDia(Double.parseDouble(dados[8]));
        f.setGenero(dados[9]);
        f.setId(Integer.parseInt(dados[10]));
        FilmeDAO fop = new FilmeDAO();    
        fop.atualizar(f);
        
    }
    
    public List<String[]> listarTodos() throws SQLException, ClassNotFoundException{
        List<String[]> filmes = new ArrayList<String[]>();
        FilmeDAO fop = new FilmeDAO();
         
        for(FilmeModel filme : fop.buscarTodos()){
             String[] fArray = new String[11];
             
            fArray[0] = Integer.toString(filme.getId());
            fArray[1] = filme.getNome();
            fArray[2] = filme.getDescricao();
            fArray[3] = filme.getGenero();
            fArray[4] = Double.toString(filme.getPrecoDia());
            fArray[5] = Integer.toString(filme.getDuracaoMin());
            fArray[6] = filme.getDataLancamento();
            fArray[7] = filme.getEstudio();
            fArray[8] = filme.getDiretor();
            fArray[9] = filme.getEstrela();
            fArray[10] = Double.toString(filme.getNotaImdb());
             
            filmes.add(fArray);
          }
        
        return filmes;
    }
}
