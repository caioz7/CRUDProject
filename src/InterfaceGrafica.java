import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

@SuppressWarnings("serial")
class InterfaceGrafica extends JFrame{
	
	JFrame JanelaPrincipal = new JFrame();
	JDesktopPane desktopPane = new JDesktopPane();
	ImageIcon imgAdd = new ImageIcon(getClass().getResource("AdicionarImg.png"));
	ImageIcon imgLista = new ImageIcon(getClass().getResource("ListarImg.png"));
	ImageIcon imgPesquisa = new ImageIcon(getClass().getResource("PesquisarImg.png"));
	ImageIcon imgRemove = new ImageIcon(getClass().getResource("RemoverImg.png"));
	ImageIcon background = new ImageIcon(getClass().getResource("Background.jpg"));
	JLabel labBack = new JLabel(background);
	JButton buttonAdd = new JButton(imgAdd);
	JButton buttonLista = new JButton(imgLista);
	JButton buttonRemove = new JButton(imgRemove);
	JButton buttonPesquisa = new JButton(imgPesquisa);
	JInternalFrame internalAdicionar = new JInternalFrame("Adicionar Registro");
	JInternalFrame internalListar = new JInternalFrame("Listar Registros");
	JInternalFrame internalPesquisar = new JInternalFrame("Pesquisar Registro");
	JInternalFrame internalRemover = new JInternalFrame("Remover Registro");
	
	static final int RESOLUCAO_X = 1200; 
	static final int RESOLUCAO_Y = 650; 
	
	public InterfaceGrafica(){
		JanelaPrincipal.setLayout(null);

		setSize(RESOLUCAO_X, RESOLUCAO_Y);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("CRUD");
		labBack.setSize(RESOLUCAO_X, RESOLUCAO_Y);
		add(desktopPane);
		add(internalAdicionar);
		add(buttonAdd);
		add(buttonPesquisa);
		add(buttonLista);
		add(buttonRemove);
		add(labBack);
		//		JanelaPrincipal.setUndecorated(true);

		buttonAdd.setBounds(10,30,120,120);;
		buttonAdd.setContentAreaFilled(false);
		buttonAdd.setBorderPainted(false);
		buttonAdd.setRolloverIcon(new ImageIcon(getClass().getResource("AdicionarImgHover.png")));
		buttonAdd.setToolTipText("Adicionar Registro");
		
		buttonLista.setBounds(10,180,120,120);
		buttonLista.setContentAreaFilled(false);
		buttonLista.setBorderPainted(false);
		buttonLista.setRolloverIcon(new ImageIcon(getClass().getResource("ListarImgHover.png")));
		buttonLista.setToolTipText("Listar todos os Registros");
		
		buttonPesquisa.setBounds(10,330,120,120);
		buttonPesquisa.setContentAreaFilled(false);
		buttonPesquisa.setBorderPainted(false);
		buttonPesquisa.setRolloverIcon(new ImageIcon(getClass().getResource("PesquisarImgHover.png")));
		buttonPesquisa.setToolTipText("Pesquisar Registros");
		
		buttonRemove.setBounds(10,480,120,120);
		buttonRemove.setContentAreaFilled(false);
		buttonRemove.setBorderPainted(false);
		buttonRemove.setRolloverIcon(new ImageIcon(getClass().getResource("RemoverImgHover.png")));
		buttonRemove.setToolTipText("Remover Registro");
		
		internalAdicionar.setClosable(true);
		internalAdicionar.setSize(RESOLUCAO_X-150,RESOLUCAO_Y-100);
		internalAdicionar.setLocation(135, 20);
		internalAdicionar.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		internalAdicionar.setBackground(Color.WHITE);
		internalAdicionar.setMaximizable(true);
		internalAdicionar.setIconifiable(true);
		
		buttonAdd.addActionListener(new ActionListener() {
			
			

			@Override
			public void actionPerformed(ActionEvent e) {
				internalAdicionar.setVisible(true);
//				JOptionPane.showMessageDialog(null, "Vc clicou no botao de Adicionar!");

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
