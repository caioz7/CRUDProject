import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Aplicacao {

	public static void main(String[] args) {
		
		Scanner scanf = new Scanner(System.in);
		System.out.print("Insira o servidor: ");
		String servidorBanco = scanf.next();
		System.out.print("Insira o nome do Banco de Dados: ");
		String nomeBanco = scanf.next();
		System.out.print("Insira o usuario do Banco de Dados: ");
		String usuarioBanco = scanf.next();
		System.out.print("Insira a senha do usuario " + usuarioBanco + " : ");
		String senhaBanco = scanf.next();
		
		String url = "jdbc:mysql://"+servidorBanco+"/"+nomeBanco;
		try{
			Connection conexao = DriverManager.getConnection(url,usuarioBanco,senhaBanco);
			System.out.println("Conectado");
			PreparedStatement pesquisa = conexao.prepareStatement("select * from Clientes");
			ResultSet resultado = pesquisa.executeQuery();
			while(resultado.next()){
				String nome = resultado.getString("nome");
				String idade = resultado.getString("idade");
				System.out.println("Nome: " + nome + "\tIdade: " + idade);

			}
		}catch(Exception erro){
			 System.err.println("Falha na conexão!");
		}
	}

}
