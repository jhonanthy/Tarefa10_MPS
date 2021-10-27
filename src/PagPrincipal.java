import javax.swing.JFrame;
import javax.swing.JLabel;

public class PagPrincipal {
    
    JFrame frame = new JFrame();
    JLabel mensagem = new JLabel("Seja bem vindo");

    PagPrincipal(){

        mensagem.setBounds(200,200,200,40);
        
        frame.add(mensagem);
        frame.setSize(420,420);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
