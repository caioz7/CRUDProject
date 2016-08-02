import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Classe principal da aplicacao
 * @author caio.dantas
 */
public class Aplicacao {


	static Dados d = new Dados();
	public static void main(String[] args) {
		JanelaConexao();
		//d.StartConnection();
		//d.OpenMainMenu();
	}

	static public void JanelaConexao(){
		JFrame conexao = new JFrame();
		JLabel servidorLabel = new JLabel("Servidor MySQL");
		JLabel usuarioLabel = new JLabel("Usuario");
		JLabel bancoNomeLabel = new JLabel("Banco de Dados");
		JLabel senhaLabel = new JLabel("Senha do Usuario");
		JTextField servidorField = new JTextField("localhost");
		JTextField bancoField = new JTextField("java");
		JTextField usuarioField = new JTextField("root");
		JPasswordField senhaField = new JPasswordField();
		JButton botaoConecta = new JButton("Conectar");

		conexao.setVisible(true);
		conexao.setTitle("Acesso ao Banco de Dados");
		conexao.setLayout(null);
		conexao.setSize(523, 279);
		conexao.setLocationRelativeTo(null);
		conexao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		conexao.add(servidorLabel).setBounds(14, 30, 87, 15);
		conexao.add(bancoNomeLabel).setBounds(14, 80, 95, 15);
		conexao.add(usuarioLabel).setBounds(14,130,50,15);
		conexao.add(senhaLabel).setBounds(14, 180, 120, 15);

		conexao.add(servidorField).setBounds(14,47,323,25);
		String servidor = servidorField.getText();
		conexao.add(bancoField).setBounds(14, 97, 323, 25);
		String banco = bancoField.getText();
		conexao.add(usuarioField).setBounds(14,147,323,25);
		
		String usuario = usuarioField.getText();
		conexao.add(senhaField).setBounds(14, 197, 323, 25);
		/**
		 * Verificar String em JPasswordField, ele esta voltando o local da memoria ao invez de corverter para String
		 */
		String senha = new String(senhaField.getPassword());
		conexao.add(botaoConecta).setBounds(380, 47, 100, 25);

		botaoConecta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(senha);
				conexao.dispose();
				d.StartConnection(servidor, banco, usuario, senha);

			}
		});
	}

}
