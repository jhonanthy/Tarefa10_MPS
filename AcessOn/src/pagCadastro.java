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
  //  
    JFrame frame = new JFrame();

    JButton botaoreset = new JButton("Reset");
    JButton botaocadastrar = new JButton("Cadastrar");

    JTextField campoUsuario = new JTextField();
    JPasswordField campoSenha = new JPasswordField();

    JLabel usuarioLabel = new JLabel("Usuário:");
    JLabel senhaLabel = new JLabel("Senha:");
    JLabel mensagem = new JLabel();
    JLabel mensagem2 = new JLabel();
    JLabel mensagem3 = new JLabel();

    HashMap<String,String> logininfo = new HashMap<String,String>();

    pagCadastro (HashMap<String,String> logininfoOriginal){

        logininfo = logininfoOriginal;

        usuarioLabel.setBounds(50,100,75,25);
        senhaLabel.setBounds(50,150,75,25);
        mensagem.setBounds(20,225,1050,35);
        mensagem2.setBounds(20,245,1050,35);
        mensagem3.setBounds(20,265,1050,35);
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
        frame.add(mensagem2);
        frame.add(mensagem3);

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
        
        if(e.getSource() == botaocadastrar) {

                String userId = campoUsuario.getText();
                String senha = String.valueOf(campoSenha.getPassword());

                boolean tamSenha = senha.length() < 21 && senha.length() > 7;
                boolean letraSenha = senha.matches(".*[a-z].*");

                int contDigitosSenha = 0;

                for (int i = 0; i < senha.length(); i++){

                    if ( Character.isDigit(senha.charAt(i) ) ) {

                        ++contDigitosSenha;

                    }
                }

                boolean quantDigitosSenha = false;

                if (contDigitosSenha > 1) {

                    quantDigitosSenha = true;

                }

                boolean tamUserId = userId.length() < 13 && userId.length() > 0;
                boolean numUserId = userId.matches(".*\\d.*");

                if( !( logininfo.containsKey(userId) ) 
                    && tamSenha && quantDigitosSenha && letraSenha
                    && tamUserId && !numUserId ) {

                    logininfo.put(userId, senha);
                    frame.dispose();
                    PagPrincipal pagPrincipal = new PagPrincipal(logininfo);

                }
                else {

                    mensagem.setText("Verifique se seu ID tem no mínimo 1 letra e no máximo 12. Ele também não pode ter números.\n");
                    mensagem2.setText("Verifique se sua senha tem tamanho entre 8 e 20, e pelo menos 2 números.\n");
                    mensagem3.setText("Caso as condições acima tenham sido satisfeitas, o usuário já existe, escolha outro.");
                    
                    mensagem.setForeground(Color.RED);
                    mensagem2.setForeground(Color.RED);
                    mensagem3.setForeground(Color.RED);

                }
        }
            
    }

}
