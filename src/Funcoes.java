import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

// Classe apenas para funcoes/metodos
public class Funcoes {
	Scanner scanf = new Scanner(System.in);
	Connection conexao;
	public void InsereDados(JTextField nomeField, JFormattedTextField cpfField, JDateChooser dataChooser, JTextField idadeField, 
							JTextField cidadeField, JTextField estadoField, JTextField paisField){
		try{
			
			PreparedStatement adicionarDado = conexao.prepareStatement("INSERT INTO Pessoas " +"VALUES('"
					+nomeField+"','"
					+cpfField+"','"
					//+cpfField+","
					+dataChooser+"','"
					+idadeField+"','"
					+cidadeField+"','"
					+estadoField+"','"
					+paisField+"')"
			);
			adicionarDado.executeUpdate();
		}catch (Exception e) {
			//JOptionPane.showMessageDialog(null, "Fail!"); 
			System.err.print(e.getMessage()); 
		}
		JOptionPane.showMessageDialog(null, "Dados Salvos com sucesso!");
	}

}
