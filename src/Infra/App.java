package Infra;
import View.pagLogin;

public class App {
    public static void main(String[] args) throws Exception {

        UsuarioeSenha usuarioeSenha = new UsuarioeSenha();

        pagLogin pagLogin = new pagLogin(usuarioeSenha.getlogininfo());
    }
}
