package Infra;
import java.util.HashMap;

public class UsuarioeSenha{
    
    HashMap<String, String> logininfo = new HashMap<String, String>();

    UsuarioeSenha(){

        logininfo.put("caio", "1234");
        logininfo.put("cassio", "1234");
        logininfo.put("Jhonanthy", "1234");

    }

    protected void addUsuario(String user, String senha){

        logininfo.put(user, senha);
        
    }

    // Adapter
    // o método esperado
    protected HashMap getlogininfo(){

        return meotodoUtil();

    }

    private HashMap meotodoUtil() {

        return logininfo;

    }
}