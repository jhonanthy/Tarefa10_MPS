import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PagPrincipal implements ActionListener {
    
    JFrame frame = new JFrame();
    JLabel mensagem = new JLabel("Seja bem vindo");

    JButton botaosair = new JButton("Log off");

    HashMap<String,String> logininfo = new HashMap<String,String>();

    PagPrincipal(HashMap<String,String> logininfoOriginal) {

        logininfo = logininfoOriginal;

        mensagem.setBounds(200,200,200,200);
        botaosair.setBounds(125,200,100,25);

        botaosair.addActionListener(this);

        botaosair.setFocusable(false);

        frame.add(botaosair);
        frame.add(mensagem);
        frame.setSize(420,420);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == botaosair) {

            frame.dispose();
            pagLogin pagLogin = new pagLogin(logininfo);

        }

    }
}
