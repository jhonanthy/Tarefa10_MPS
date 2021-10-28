import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class pagCadastro implements ActionListener {
    
    JFrame frame = new JFrame();

    JButton botaoreset = new JButton("Reset");
    JButton botaocadastrar = new JButton("Cadastrar");

    JTextField campoUsuario = new JTextField();
    JPasswordField campoSenha = new JPasswordField();

    JLabel usuarioLabel = new JLabel("Usuário:");
    JLabel senhaLabel = new JLabel("Senha:");
    JLabel mensagem = new JLabel();

    HashMap<String,String> logininfo = new HashMap<String,String>();

    pagCadastro (HashMap<String,String> logininfoOriginal){

        logininfo = logininfoOriginal;

        usuarioLabel.setBounds(50,100,75,25);
        senhaLabel.setBounds(50,150,75,25);
        mensagem.setBounds(125,250,250,35);
        campoUsuario.setBounds(125,100,200,25);
        campoSenha.setBounds(125,150,200,25);
        botaocadastrar.setBounds(125,200,100,25);
        botaoreset.setBounds(225,200,100,25);

        botaocadastrar.addActionListener(this);
        botaoreset.addActionListener(this);

        botaoreset.setFocusable(false);
        botaocadastrar.setFocusable(false);

        frame.add(usuarioLabel);
        frame.add(senhaLabel);

        frame.add(mensagem);

        frame.add(campoUsuario);
        frame.add(campoSenha);

        frame.add(botaoreset);
        frame.add(botaocadastrar);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == botaoreset){

            campoUsuario.setText("");
            campoSenha.setText("");

        }
        
        if(e.getSource() == botaocadastrar){

                String userId = campoUsuario.getText();
                String senha = String.valueOf(campoSenha.getPassword());

                if( !(logininfo.containsKey(userId)) ) {

                    logininfo.put(userId, senha);
                    frame.dispose();
                    PagPrincipal pagPrincipal = new PagPrincipal(logininfo);

                }
                else {

                    mensagem.setText("Usuário já existente");
                    mensagem.setForeground(Color.RED);

                }
        }
            
    }

}
