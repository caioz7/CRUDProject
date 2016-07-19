import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
/**
 * @author caio.dantas
 * Classe responsavel pola conexao com o servidor MySQL e manipulacao dos dados.
 */

public class Dados {
	
	Scanner scanf = new Scanner(System.in);
	Connection conexao;
	String servidorBanco,nomeBanco,usuarioBanco,senhaBanco;

	public void StartConnection(){

		System.out.print("Insira o servidor: ");
		String servidorBanco = scanf.next();
		System.out.print("Insira o nome do Banco de Dados: ");
		String nomeBanco = scanf.next();
		System.out.print("Insira o usuario do Banco de Dados: ");
		String usuarioBanco = scanf.next();
		System.out.print("Insira a senha do usuario " + usuarioBanco + " : ");
		String senhaBanco = scanf.next();
		this.servidorBanco = servidorBanco;
		this.nomeBanco = nomeBanco;
		this.usuarioBanco = usuarioBanco;
		this.senhaBanco = senhaBanco;

		try{
			conexao = DriverManager.getConnection("jdbc:mysql://"+servidorBanco+"/"+nomeBanco,usuarioBanco,senhaBanco);
			System.out.println("");

		}catch(Exception e){
			System.err.println("Falha na conexao!"); 
			System.err.println(e.getMessage()); 
			System.exit(0);
		}
	}

	public void CreateData(){
		try{
			System.out.print("Insira o nome do Cliente: ");
			scanf.nextLine();
			String nome = scanf.nextLine();
			System.out.print("Insira a idade : ");
			int idade = scanf.nextInt();

			PreparedStatement adicionarDado = conexao.prepareStatement("INSERT INTO Clientes " +"VALUES('"+nome+"',"+idade+")");
			adicionarDado.executeUpdate();
		}catch (Exception e) {
			System.err.print("Fail!"); 
			System.err.println(e.getMessage()); 
		}
	}
	
	public void ReadData(){
		PreparedStatement pesquisa;
		try {
			pesquisa = conexao.prepareStatement("select * from Clientes");
			ResultSet resultado = pesquisa.executeQuery();
			while(resultado.next()){
				String nome = resultado.getString("nome");
				String idade = resultado.getString("idade");
				System.out.println("Nome: " + nome + "\tIdade: " + idade);
			}
		} catch (SQLException e) {
			System.err.println("Fail!");
			e.getMessage();
		}
	}
	
	public void UpdateData(){
		System.out.println("Esta opcao representa a alteracao de dados e retorna os dados atualizados");
	}
	
	public void DeleteData(){
		System.out.println("Esta opcao representa a remocao de dados");
	}
	
	public void OpenMainMenu(){
		System.out.print("|1 - Inserir novos dados\n|2 - Listar dados\n|3 - Atualizar dados\n|4 - Deletar Dados\n|5 - Sair\nInsira a opcao desejada: ");
		int op = scanf.nextInt();
		System.out.println("");
		switch (op) {
		case 1: CreateData();
		break;
		case 2: ReadData();
		break;
		case 3: UpdateData();
		break;
		case 4: DeleteData();
		break;
		case 5: System.exit(0);	
		break;
		default: System.err.println("Opcao invalida");
		break;
		}
	}
}
