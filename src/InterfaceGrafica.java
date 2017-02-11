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

import jdk.nashorn.internal.runtime.regexp.joni.Warnings;
import sun.invoke.empty.Empty;

@SuppressWarnings("serial")
class InterfaceGrafica extends JFrame{
	Funcoes funcoes = new Funcoes();
	JFrame JanelaPrincipal = new JFrame();
	JDesktopPane desktopPane = new JDesktopPane();
	JLabel labBack = new JLabel(new ImageIcon(getClass().getResource("Background.jpg")));
	
	JButton buttonAdd = new JButton(new ImageIcon(getClass().getResource("AdicionarImg.png"))); // ter usar o imageicon direto no jbutton
	JButton buttonLista = new JButton(new ImageIcon(getClass().getResource("ListarImg.png")));
	JButton buttonRemove = new JButton(new ImageIcon(getClass().getResource("RemoverImg.png")));
	JButton buttonPesquisa = new JButton(new ImageIcon(getClass().getResource("PesquisarImg.png")));
	JButton buttonSalvar = new JButton(new ImageIcon(getClass().getResource("SaveImg.png")));
	JButton buttonSair = new JButton(new ImageIcon(getClass().getResource("SairImg.png")));
	
	JInternalFrame internalAdicionar = new JInternalFrame("Adicionar Registro");
	JInternalFrame internalListar = new JInternalFrame("Listar Registros");
	JInternalFrame internalPesquisar = new JInternalFrame("Pesquisar Registro");
	JInternalFrame internalRemover = new JInternalFrame("Remover Registro");
	
	JLabel nomeLabel = new JLabel("Nome:");
	JLabel cpfLabel = new JLabel("CPF:");
	JLabel idadeLabel = new JLabel("Idade:");
	JLabel dataNascLabel = new JLabel("Data de Nascimento(DD/MM/AAAA): ");
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
		JanelaPrincipal.setUndecorated(true);
		getContentPane().add(desktopPane);
		getContentPane().add(internalAdicionar);
		getContentPane().add(internalListar);
		getContentPane().add(buttonAdd);
		getContentPane().add(buttonPesquisa);
		getContentPane().add(buttonLista);
		getContentPane().add(buttonRemove);
		getContentPane().add(buttonSair);
		getContentPane().add(labBack);

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
		
		buttonSair.setBounds(1050,490,120,120);
		buttonSair.setContentAreaFilled(false);
		buttonSair.setBorderPainted(false);
		buttonSair.setRolloverIcon(new ImageIcon(getClass().getResource("SairImgHover.png")));
		buttonSair.setToolTipText("Sair");
		
		buttonRemove.setBounds(10,480,120,120);
		buttonRemove.setContentAreaFilled(false);
		buttonRemove.setBorderPainted(false);
		buttonRemove.setRolloverIcon(new ImageIcon(getClass().getResource("RemoverImgHover.png")));
		buttonRemove.setToolTipText("Remover Registro");
		
		//buttonSalvar.setRolloverIcon(new ImageIcon(getClass().getResource("SaveImgHover.png")));
		buttonSalvar.setPressedIcon(new ImageIcon(getClass().getResource("SaveImgHover.png")));
		buttonSalvar.setToolTipText("Salvar registro");
		buttonSalvar.setContentAreaFilled(false);
		buttonSalvar.setBorderPainted(false);
		
		internalAdicionar.getContentPane().setLayout(null);
		internalAdicionar.setClosable(true);
		internalAdicionar.setSize(RESOLUCAO_X-400,RESOLUCAO_Y-250);
		internalAdicionar.setLocation(RESOLUCAO_X - 945, RESOLUCAO_Y - 500);
		internalAdicionar.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		internalAdicionar.setMaximizable(true);
		internalAdicionar.setIconifiable(true);
		internalAdicionar.add(nomeLabel).setBounds(30, 10,40,100);
		internalAdicionar.add(nomeField).setBounds(70, 48, 350, 30);
		internalAdicionar.add(idadeLabel).setBounds(450, 48, 40, 30);
		internalAdicionar.add(idadeField).setBounds(488, 48, 40, 30);
		internalAdicionar.add(cpfLabel).setBounds(30, 148, 40, 30);
		internalAdicionar.add(cpfField).setBounds(70, 148, 200, 30);
		internalAdicionar.add(dataNascLabel).setBounds(320, 148, 250, 30);
		internalAdicionar.add(dataChooser).setBounds(522, 148, 100, 30);
		internalAdicionar.add(cidadeLabel).setBounds(30,248,100,30);
		internalAdicionar.add(cidadeField).setBounds(80, 248, 200, 30);
		internalAdicionar.add(estadoLabel).setBounds(300,248,100,30);
		internalAdicionar.add(estadoField).setBounds(350,248,100,30);
		internalAdicionar.add(paisLabel).setBounds(480,248,100,30);
		internalAdicionar.add(paisField).setBounds(520,248,100,30);
		internalAdicionar.add(buttonSalvar).setBounds(680, 250, 75,	75);;

		MaskFormatter maskData;	
		try {
			maskData = new MaskFormatter("###.###.###-##");
			maskData.install(cpfField);
			
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		buttonSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if((nomeField.getText().trim().equals("")) 
						|| cpfField.getText().trim().equals("") 
						|| dataChooser.equals("") 
						|| idadeField.getText().trim().equals("") 
						|| cidadeField.getText().trim().equals("") 
						|| estadoField.getText().trim().equals("")
						|| nomeField.getText().trim().equals("")
						|| paisField.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "Por favor, insira todos os dados");
				}else
				funcoes.InsereDados(nomeField, cpfField, dataChooser, idadeField, cidadeField, estadoField, paisField);
				
			}
		});
		
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
		buttonSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(1);				
			}
		});
		
	}
}
