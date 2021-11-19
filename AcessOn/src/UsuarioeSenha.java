import java.util.HashMap;
import java.util.*;

public class UsuarioeSenha{
    
    Set<String> usuarios = new TreeSet<>();
    data dataNasci;
    
    HashMap<String, String> logininfo = new HashMap<String, String>();
    HashMap<String, String> datasNascimento = new HashMap<String, String>();

    UsuarioeSenha(){

        
/*      logininfo.put("caio", "1234");
        logininfo.put("cassio", "1234");
        logininfo.put("Jhonanthy", "1234"); */

    }

    protected HashMap<String, String> getlogininfo(){

        return logininfo;

    }

    public void addConta(String usuario, String senha) {

        logininfo.put(usuario, senha);
        usuarios.add(usuario);

    }

    public Set<String> getUsuarios() {
        return usuarios;
    }

    public void setDataNascimento(int dia, int mes, int ano) {

        dataNasci = new data(dia, mes, ano);

    }

    public data getDataNascimento() {
        return dataNasci;
    }
}