import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
class InterfaceGrafica extends JFrame{
	
	JFrame JanelaPrincipal = new JFrame();
	JDesktopPane desktopPane = new JDesktopPane();
	ImageIcon imgAdd = new ImageIcon(getClass().getResource("AdicionarImg.png"));
	ImageIcon imgLista = new ImageIcon(getClass().getResource("ListarImg.png"));
	ImageIcon imgPesquisa = new ImageIcon(getClass().getResource("PesquisarImg.png"));
	ImageIcon imgRemove = new ImageIcon(getClass().getResource("RemoverImg.png"));
	ImageIcon background = new ImageIcon(getClass().getResource("Background.png"));
	JLabel labBack = new JLabel(background);
	JButton buttonAdd = new JButton(imgAdd);
	JButton buttonLista = new JButton(imgLista);
	JButton buttonRemove = new JButton(imgRemove);
	JButton buttonPesquisa = new JButton(imgPesquisa);
	
	static final int RESOLUCAO_X = 1200; 
	static final int RESOLUCAO_Y = 650; 
	
	JInternalFrame internalAdicionar = new JInternalFrame("Adicionar Registro");
	public InterfaceGrafica(){
		JanelaPrincipal.setLayout(null);

		setSize(RESOLUCAO_X, RESOLUCAO_Y);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("CRUD");
		labBack.setSize(RESOLUCAO_X, RESOLUCAO_Y);
		add(desktopPane);
		add(buttonAdd);
		add(buttonPesquisa);
		add(buttonLista);
		add(buttonRemove);
		add(labBack);
		//		JanelaPrincipal.setUndecorated(true);

		buttonAdd.setBounds(10,30,120,120);;
		buttonAdd.setContentAreaFilled(false);
		buttonLista.setBounds(10,180,120,120);
		buttonLista.setContentAreaFilled(false);
		buttonPesquisa.setBounds(10,330,120,120);
		buttonPesquisa.setContentAreaFilled(false);
		buttonRemove.setBounds(10,480,120,120);
		buttonRemove.setContentAreaFilled(false);
		
		internalAdicionar.setMaximizable(false);
		internalAdicionar.setClosable(true);
		buttonAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Vc clicou no botao de Adicionar!");

			}
		});
		buttonLista.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Vc clicou no botao de Listar!");

			}
		});
		buttonPesquisa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Vc clicou no botao de Pesquisar!");

			}
		});
		buttonRemove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Vc clicou no botao de Remover Registro!");

			}
		});
	}

}
