import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import com.toedter.calendar.JDateChooser;

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
	
	JLabel nomeLabel = new JLabel("Nome:");
	JLabel cpfLabel = new JLabel("CPF:");
	JLabel idadeLabel = new JLabel("Idade:");
	JLabel dataNascLabel = new JLabel("Data de Nascimento:");
	JLabel cidadeLabel = new JLabel("Cidade:");
	JLabel estadoLabel = new JLabel("Estado:");
	JLabel paisLabel = new JLabel("País:");
	
	JTextField nomeField = new JTextField();
	JFormattedTextField cpfField = new JFormattedTextField();
	JTextField idadeField = new JTextField();
	JTextField dataNascField = new JTextField();
	JTextField cidadeField = new JTextField();
	JTextField estadoField = new JTextField();
	JTextField paisField = new JTextField();
	
	JDateChooser dataChooser = new JDateChooser();
	static final int RESOLUCAO_X = 1200; 
	static final int RESOLUCAO_Y = 650; 
	
	public InterfaceGrafica(){
		repaint();
		JanelaPrincipal.getContentPane().setLayout(null);

		setSize(RESOLUCAO_X, RESOLUCAO_Y);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("CRUD");
		labBack.setSize(RESOLUCAO_X, RESOLUCAO_Y);
		getContentPane().add(desktopPane);
		getContentPane().add(internalAdicionar);
		getContentPane().add(internalListar);
		getContentPane().add(buttonAdd);
		getContentPane().add(buttonPesquisa);
		getContentPane().add(buttonLista);
		getContentPane().add(buttonRemove);
		getContentPane().add(labBack);
		//		JanelaPrincipal.setUndecorated(true);

		buttonAdd.setBounds(10,30,120,120);;
		buttonAdd.setContentAreaFilled(false);
		buttonAdd.setBorderPainted(false);
		buttonAdd.setRolloverIcon(new ImageIcon(getClass().getResource("AdicionarImgHover.png")));
		buttonAdd.setToolTipText("Adicionar Registro");
		buttonAdd.setEnabled(true);
		
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
		
		internalAdicionar.getContentPane().setLayout(null);
		internalAdicionar.setClosable(true);
		internalAdicionar.setSize(RESOLUCAO_X-170,RESOLUCAO_Y-100);
		internalAdicionar.setLocation(RESOLUCAO_X - 1045, RESOLUCAO_Y - 620);
		internalAdicionar.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		internalAdicionar.setMaximizable(true);
		internalAdicionar.setIconifiable(true);
		internalAdicionar.add(nomeLabel).setBounds(30, 10,40,100);
		internalAdicionar.add(nomeField).setBounds(70, 48, 500, 30);
		internalAdicionar.add(idadeLabel).setBounds(600, 48, 40, 30);
		internalAdicionar.add(idadeField).setBounds(638, 48, 40, 30);
		internalAdicionar.add(cpfLabel).setBounds(30, 148, 40, 30);
		internalAdicionar.add(cpfField).setBounds(70, 148, 200, 30);
		internalAdicionar.add(dataNascLabel).setBounds(320, 148, 150, 30);
		internalAdicionar.add(dataChooser).setBounds(450, 148, 100, 30);
		internalAdicionar.add(cidadeLabel).setBounds(30,248,100,30);
		internalAdicionar.add(cidadeField).setBounds(80, 248, 200, 30);
		internalAdicionar.add(estadoLabel).setBounds(300,248,100,30);
		internalAdicionar.add(estadoField).setBounds(350,248,100,30);
		internalAdicionar.add(paisLabel).setBounds(480,248,100,30);
		internalAdicionar.add(paisField).setBounds(520,248,100,30);
		
		MaskFormatter maskData;	
		try {
			maskData = new MaskFormatter("###.###.###-##");
			maskData.install(cpfField);
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		internalListar.setClosable(true);
		internalListar.setSize(RESOLUCAO_X-170,RESOLUCAO_Y-100);
		internalListar.setLocation(RESOLUCAO_X - 1045, RESOLUCAO_Y - 620);
		internalListar.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		internalListar.setBackground(Color.WHITE);
		internalListar.setMaximizable(true);
		internalListar.setIconifiable(true);
		
		buttonAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
				internalAdicionar.setVisible(true);
				//JOptionPane.showMessageDialog(null, "Vc clicou no botao de Adicionar!");
			}
		});
		
		buttonLista.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				internalListar.setVisible(true);

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
