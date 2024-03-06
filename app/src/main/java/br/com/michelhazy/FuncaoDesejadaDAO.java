package br.com.michelhazy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FuncaoDesejadaDAO {

    public void adicionar(String task){
        String sql = "INSERT INTO todo (task) VALUES (?);";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnection();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, task);

            pstm.execute();
            System.out.println("Task adicionada com sucesso!");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(conn!=null){
                    conn.close();
                }
                if(pstm!=null){
                    pstm.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void mostrar() {
        String sql = "SELECT task, id FROM todo;";

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet result = null;

        try{
            conn = ConnectionFactory.createConnection();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            result = pstm.executeQuery();
            
            while (result.next()) {
                String task = result.getString("task");
                int taskInt = result.getInt("id");
                System.out.println(taskInt + " - " + task);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(conn!=null){
                    conn.close();
                }
                if(pstm!=null){
                    pstm.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void concluir(int task){
        String sql = "UPDATE todo SET concluido = 1 WHERE id=?;";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, task);
            pstm.execute();
            System.out.println("Task concluida com sucesso!");
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(conn!=null){
                    conn.close();
                }
                if(pstm!=null){
                    pstm.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void deletar(int task){
        String sql = "delete from todo where id=?;";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, task);
            pstm.execute();
            System.out.println("Deletado com sucesso!");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(conn!=null){
                    conn.close();
                }
                if(pstm!=null){
                    pstm.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void editar(int task, String edicao){
        String sql = "UPDATE todo SET task = ? where id = ?;";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, edicao);
            pstm.setInt(2, task);

            pstm.execute();
            System.out.println("Task editada com sucesso!");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(conn!=null){
                    conn.close();
                }
                if(pstm!=null){
                    pstm.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
