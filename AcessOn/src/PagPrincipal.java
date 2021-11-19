import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PagPrincipal implements ActionListener {
    
    JFrame frame = new JFrame();
    JLabel mensagem = new JLabel("Seja bem vindo");

    JButton botaoUsuariosOrdenados = new JButton("Listar Usuário");
    JButton botaosair = new JButton("Log off");

    UsuarioeSenha conta;
    HashMap<String,String> logininfo = new HashMap<String,String>();

    PagPrincipal(UsuarioeSenha contas) {

        conta = contas;
        logininfo = conta.getlogininfo();

        //(x, y, w, h), sendo o eixo (0, 0) em cima à esquerda
        mensagem.setBounds(200,200,200,200);
        botaoUsuariosOrdenados.setBounds(125,200,100,25);
        botaosair.setBounds(225,200,100,25);

        botaoUsuariosOrdenados.addActionListener(this);
        botaosair.addActionListener(this);

        botaoUsuariosOrdenados.setFocusable(false);
        botaosair.setFocusable(false);

        frame.add(botaoUsuariosOrdenados);
        frame.add(botaosair);
        frame.add(mensagem);
        frame.setSize(900,900);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == botaosair) {

            frame.dispose();
            new pagLogin(conta);

        }

        if(e.getSource() == botaoUsuariosOrdenados) {

            String text ="";
            
            int cont = 0;
            Set<String> usuarios;
            usuarios = conta.getUsuarios();
            for (String key : usuarios) {
             ++cont;
                //Capturamos o valor a partir da chave
                String value = logininfo.get(key);
                text =  text + "  || Login : " +cont + ". " + key + "- Senha : " + value + "  ";

            //    a.concat(text);
                // System.out.println(key + " = " + value);
            }
         
            mensagem.setText(text);

        }

    }
}
