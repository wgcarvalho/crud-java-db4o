
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Video Aulas
 */
public class Conexao {
    private ObjectContainer db = null;
    
    private void abrirBanco(){
        db = Db4oEmbedded.openFile("banco");
    }
    
    private void fecharBanco(){
        db.close();
    }
    
    public void insertPessoa(Pessoa p){
        abrirBanco();
        db.store(p);
        fecharBanco();
    }
    public List<Pessoa> selectAllPessoa(){
        abrirBanco();
        ObjectSet listPessoa = db.queryByExample(Pessoa.class);
        List<Pessoa> lp = new ArrayList<>();
        for (Object listPessoa1 : listPessoa) {
            lp.add((Pessoa)listPessoa1);
        }
        fecharBanco();
        return lp;
    }
    public Pessoa selectPessoa(Pessoa p){
        abrirBanco();
        ObjectSet result = db.queryByExample(p);
        Pessoa pessoa = (Pessoa)  result.next();
        fecharBanco();
        return pessoa;
    }
    
    public void updatePessoa(int rg, String nnome, int nidade){
        abrirBanco();
        Pessoa p = new Pessoa();
        p.setRg(rg);
        ObjectSet result = db.queryByExample(p);
        Pessoa presult = (Pessoa) result.next();
        presult.setNome(nnome);
        presult.setIdade(nidade);
        db.store(presult);
        fecharBanco();       
    }
    
    public void deletePessoa(int rg){
        abrirBanco();
        Pessoa p = new Pessoa();
        p.setRg(rg);
        ObjectSet result = db.queryByExample(p);
        Pessoa presult = (Pessoa) result.next();
        db.delete(presult);
        fecharBanco();
    }
    
}
