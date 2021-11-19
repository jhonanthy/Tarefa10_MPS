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
    JButton botaoMostraUsuarios = new JButton("Lista Usuário");
    JButton botaoDelete = new JButton("Deletar Usuário");

    JTextField campoUsuario = new JTextField();
    JTextField dataNasci = new JTextField();
    JPasswordField campoSenha = new JPasswordField();
    JLabel usuarioLabel = new JLabel("Usuário:");
    JLabel senhaLabel = new JLabel("Senha:");
    JLabel dataLabel = new JLabel("Data de nascimento:");
    JLabel mensagem = new JLabel();
    JLabel mensagem2 = new JLabel();
    JLabel mensagem3 = new JLabel();

    UsuarioeSenha conta;

    HashMap<String,String> logininfo = new HashMap<String,String>();

    pagCadastro (UsuarioeSenha contas){

        conta = contas;
        logininfo = conta.getlogininfo();

        usuarioLabel.setBounds(20,100,75,25);
        dataLabel.setBounds(20,150,75,25);
        senhaLabel.setBounds(20,200,75,25);
        mensagem.setBounds(20,295,1050,35);
        mensagem2.setBounds(20,315,1050,35);
        mensagem3.setBounds(20,335,1050,35);
        campoUsuario.setBounds(125,100,200,25);
        dataNasci.setBounds(125,150,200,25);
        campoSenha.setBounds(125,200,200,25);
        botaocadastrar.setBounds(125,250,100,25);
        botaoreset.setBounds(225,250,100,25);
        botaoMostraUsuarios.setBounds(125,275,110,25);
        //125,200,100,25);
        botaoDelete.setBounds(225,275,100,25);
       
       
        botaocadastrar.addActionListener(this);
        botaoreset.addActionListener(this);
        botaoDelete.addActionListener(this);
        botaoMostraUsuarios.addActionListener(this);

        botaoreset.setFocusable(false);
        botaocadastrar.setFocusable(false);
        botaoMostraUsuarios.setFocusable(false);
        botaoDelete.setFocusable(false);

        frame.add(usuarioLabel);
        frame.add(senhaLabel);
        frame.add(dataLabel);
        //labels mensagens
        frame.add(mensagem);
        frame.add(mensagem2);
        frame.add(mensagem3);
        //Dados
        frame.add(campoUsuario);
        frame.add(campoSenha);
        frame.add(dataNasci);
        //Botões
        frame.add(botaoreset);
        frame.add(botaocadastrar);
        frame.add(botaoMostraUsuarios);
        frame.add(botaoDelete);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,900);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == botaoreset){

            campoUsuario.setText("");
            campoSenha.setText("");

        }

        if (e.getSource() == botaoMostraUsuarios){
            String text ="";
            
            int cont = 0;
            for (String key : logininfo.keySet()) {
             ++cont;
                //Capturamos o valor a partir da chave
                String value = logininfo.get(key);
                text =  text + "  || Login : " +cont + ". " + key + "- Senha : " + value + "  ";

            //    a.concat(text);
                // System.out.println(key + " = " + value);
            }
         
            mensagem.setText(text);

        }

        if (e.getSource()== botaoDelete){
            String userId = campoUsuario.getText();
            if (userId.isEmpty()){
              mensagem.setText("Insira o nome do usuario a ser excluido!");  
            }
            else{
                
             // remove by value
                logininfo.keySet().removeIf(key -> key != userId);
                if (logininfo.containsKey(userId)){
                    mensagem.setText("O usuario não foi excluido :"+userId+" ERRO! ");
                }
                else {
                    mensagem.setText("Usuario :"+ userId +" Excluido com Sucesso!" );
                }
                

               }

        }
        if(e.getSource() == botaocadastrar) {

                String userId = campoUsuario.getText();
                String senha = String.valueOf(campoSenha.getPassword());

                boolean tamSenha = senha.length() < 21 && senha.length() >=8;
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

                if (!logininfo.containsKey(userId) && tamSenha && quantDigitosSenha && letraSenha
                    && tamUserId && !numUserId ) {

                    conta.addConta(userId, senha);
                    frame.dispose();
                    new PagPrincipal(conta);

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
