import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
import javax.swing.JOptionPane;


// Classe apenas para funcoes/metodos
public class Funcoes {
	Scanner scanf = new Scanner(System.in);
	Connection conexao;
	public void InsereDados(String nome, String cpf, int idade, String cidade, String estado){
		//System.out.println(nome +"', '"+ cpf +"', '" + idade +"', '" + cidade +"', '" + estado);
		try{
			
			PreparedStatement adicionarDado = conexao.prepareStatement("INSERT INTO Pessoas(`nome`, `cpf`, `idade`, `cidade`, `estado`) VALUES ('"+ nome +"', '"+ cpf +"', " + idade +", '" + cidade +"', '" + estado +"');");
			
			adicionarDado.executeUpdate();
			JOptionPane.showMessageDialog(null, "Dados Salvos com sucesso!");
		}catch (Exception e) {
			
			System.err.print(e.getMessage()); 
		}
	}

}
