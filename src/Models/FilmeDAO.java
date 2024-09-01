/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andre
 */
public class FilmeDAO {
    public Connection connect() {
        try {
            //O método forName carrega e inicia o driver passado por parâmetro
            Class.forName("com.mysql.cj.jdbc.Driver"); //Verifica no computador
            String URL = "jdbc:mysql://localhost:3306/locadoradb"; //Verifica no computador
            String USER = "root";
            String PASSWORD = "";
            
            return (Connection) DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException ex) {
        System.out.println("Driver não encontrado: " + ex.getMessage());
        return null;
    } catch (SQLException ex) {
        System.out.println("Erro de SQL: " + ex.getMessage());
        return null;
        }   
    }
    
    public void cadastrar(FilmeModel filme) throws SQLException, ClassNotFoundException{
        Connection con = connect();
        PreparedStatement command = con.prepareStatement("insert into Filme (nome, descricao, genero, precoDia, duracaoMin, dataLancamento, estudio, diretor, estrela, notaImdb) values(?,?,?,?, ?, ?, ?, ?, ?, ?)");
        command.setString(1, filme.getNome());
        command.setString(2, filme.getDescricao());
        command.setString(3, filme.getGenero());
        command.setDouble(4, filme.getPrecoDia());
        command.setInt(5, filme.getDuracaoMin());
        command.setString(6, filme.getDataLancamento());
        command.setString(7, filme.getEstudio());
        command.setString(8, filme.getDiretor());
        command.setString(9, filme.getEstrela());
        command.setDouble(10, filme.getNotaImdb());
        command.execute();
        con.close();
    }
    
    public void deletar(int id) throws SQLException, ClassNotFoundException{
        Connection con = connect();
        PreparedStatement command = con.prepareStatement("delete from Filme where id = ?");
        command.setString(1, Integer.toString(id));
        
        command.execute();
        con.close();
    }
    
    public void atualizar(FilmeModel filme) throws SQLException, ClassNotFoundException{
        Connection con = connect();
        PreparedStatement command = con.prepareStatement("update Filme set nome = ?, descricao = ?, genero = ?, precoDia = ?, duracaoMin = ?, dataLancamento = ?, estudio = ?, diretor = ?, estrela = ?, notaImdb = ? WHERE id = ?");
        command.setString(1, filme.getNome());
        command.setString(2, filme.getDescricao());
        command.setString(3, filme.getGenero());
        command.setDouble(4, filme.getPrecoDia());
        command.setInt(5, filme.getDuracaoMin());
        command.setString(6, filme.getDataLancamento());
        command.setString(7, filme.getEstudio());
        command.setString(8, filme.getDiretor());
        command.setString(9, filme.getEstrela());
        command.setDouble(10, filme.getNotaImdb());
        command.setInt(11, filme.getId());
        command.execute();
        con.close();
    }
    
    public List<FilmeModel> buscarTodos() throws SQLException, ClassNotFoundException{
        Connection con = connect();
        PreparedStatement command = con.prepareStatement("select * from Filme");
        ResultSet result = command.executeQuery();
        List<FilmeModel> filmes = new ArrayList<FilmeModel>();
        while (result.next()) {
            FilmeModel f = new FilmeModel();
            f.setId(result.getInt("id"));
            f.setNome(result.getString("nome"));
            f.setDescricao(result.getString("descricao"));
            f.setGenero(result.getString("genero"));
            f.setPrecoDia(result.getDouble("precoDia"));
            f.setDuracaoMin(result.getInt("duracaoMin"));
            f.setEstrela(result.getString("estrela"));
            f.setEstudio(result.getString("estudio"));
            f.setDiretor(result.getString("diretor"));
            f.setNotaImdb(result.getDouble("notaImdb"));
            f.setDataLancamento(result.getString("dataLancamento"));
            filmes.add(f);
        }
        con.close();
        return filmes;
    }
    
   
}
