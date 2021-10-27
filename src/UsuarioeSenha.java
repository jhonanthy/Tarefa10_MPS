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

    protected HashMap getlogininfo(){

        return logininfo;

    }
}