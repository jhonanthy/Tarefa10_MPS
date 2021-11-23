import java.util.HashMap;

import javax.xml.crypto.Data;

import java.util.*;
import java.text.*;

public class UsuarioeSenha{
    
    Set<String> usuarios = new TreeSet<>();
    String dataNasci;
    
    HashMap<String, String> logininfo = new HashMap<String, String>();
    HashMap<String, String> datasNascimento = new HashMap<String, String>();
    // Map<String, Tuple2 <Person, Person> peopleByForename = new HashMap<>();
    UsuarioeSenha(){

        
    /*  logininfo.put("caio", "1234");
        logininfo.put("cassio", "1234");
        logininfo.put("Jhonanthy", "1234"); */

    }

    protected HashMap<String, String> getlogininfo(){

        return logininfo;

    }
    protected HashMap<String, String> getdatasNascimento(){

        return datasNascimento;

    }

    public void addConta(String usuario, String senha,String dtnasc) {

        logininfo.put(usuario, senha);
        usuarios.add(usuario);
        datasNascimento.put(usuario, dtnasc);

    }

    public Set<String> getUsuarios() {
        return usuarios;
    }

    public void alterarUsuario(String usuario, String senha){
        Iterator<Integer> iterator = usuarios.iterator();
        while(iterator.hasNext()) {
            if(usuarios.toString() == usuario){
                usuarios.add(usuario);
                logininfo.put(usuario, senha);
            }
        }
    }
    /*public void setDataNascimento(int dia, int mes, int ano) {
        dataNasci =  //String.valueOf(dia)+"/"+String.valueOf(mes)+"/"+String.valueOf(ano);

         

    }
     
    public String getDataNascimento() {
        return dataNasci;
    }*/
}