import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class pagLogin implements ActionListener{

    JFrame frame = new JFrame();

    JButton botaologin = new JButton("Login");
    JButton botaoreset = new JButton("Reset");
    JButton botaoAdd = new JButton("Criar Usuário");
    
    

    JTextField campoUsuario = new JTextField();
    JPasswordField campoSenha = new JPasswordField();

    JLabel usuarioLabel = new JLabel("Usuário:");
    JLabel senhaLabel = new JLabel("Senha:");
    JLabel mensagem = new JLabel();

    HashMap<String,String> logininfo = new HashMap<String,String>();

    pagLogin(HashMap<String,String> logininfoOriginal){

        logininfo = logininfoOriginal;

        usuarioLabel.setBounds(50,100,75,25);
        senhaLabel.setBounds(50,150,75,25);
        mensagem.setBounds(125,250,1050,35);
        campoUsuario.setBounds(125,100,200,25);
        campoSenha.setBounds(125,150,200,25);
        botaologin.setBounds(125,200,100,25);
        botaoreset.setBounds(225,200,100,25);
        
        
        botaoAdd.setBounds(125,225,110,25);

        botaologin.addActionListener(this);
        botaoreset.addActionListener(this);
       
        botaoAdd.addActionListener(this);

        botaologin.setFocusable(false);
        botaoreset.setFocusable(false);
        
        botaoAdd.setFocusable(false);

        frame.add(usuarioLabel);
        frame.add(senhaLabel);
        frame.add(mensagem);
        frame.add(campoUsuario);
        frame.add(campoSenha);
        frame.add(botaologin);
        frame.add(botaoreset);
        
        
        frame.add(botaoAdd);

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
       
        
        if(e.getSource() == botaologin){

                String userId = campoUsuario.getText();
                String senha = String.valueOf(campoSenha.getPassword());

                if(logininfo.containsKey(userId)){
                    if(logininfo.get(userId).equals(senha)){
                        mensagem.setText("Senha Correta");
                        mensagem.setForeground(Color.GREEN);
                        frame.dispose();
                        PagPrincipal pagPrincipal = new PagPrincipal(logininfo);
                    }
                    else{
                        mensagem.setText("Senha Errada");
                        mensagem.setForeground(Color.RED);
                    }
                }
                else{
                    mensagem.setText("Usuário não encontrado");
                    mensagem.setForeground(Color.RED);
                }
        }
            
        if(e.getSource() == botaoAdd){

            frame.dispose();
            pagCadastro cadastrar = new pagCadastro(logininfo);

        }
    }
    
}
