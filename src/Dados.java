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

	public void StartConnection(String servidorBanco, String nomeBanco, String usuarioBanco, String senhaBanco){

		/*System.out.print("Insira o servidor: ");
		servidorBanco = scanf.next();
		System.out.print("Insira o nome do Banco de Dados: ");
		nomeBanco = scanf.next();
		System.out.print("Insira o usuario do Banco de Dados: ");
		usuarioBanco = scanf.next();
		System.out.print("Insira a senha do usuario " + usuarioBanco + " : ");
		senhaBanco = scanf.next();
		 */
		try{
			conexao = DriverManager.getConnection("jdbc:mysql://"+servidorBanco+"/"+nomeBanco,usuarioBanco,senhaBanco);
			System.out.println("");
			OpenMainMenu();

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
		OpenMainMenu();
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
		OpenMainMenu();
	}

	public void SearchData(){
		PreparedStatement pesquisa;
		System.out.println("insira o nome da Pessoa a ser pesquisada");
		String nameSearch = scanf.next();
		try{
			pesquisa = conexao.prepareStatement("select * from Clientes where nome like ('%"+nameSearch+"%');");
			ResultSet resultado = pesquisa.executeQuery();
			while(resultado.next()){
				String nome = resultado.getString("nome");

				String idade = resultado.getString("idade");
				System.out.println("Nome: " + nome + "\tIdade: " + idade);
				UpdateData(nome);
			}
		}catch (Exception e) {
			System.err.println("Nome nao encontrado!");
			e.getMessage();
		}

	}
	public void UpdateData(String nome){
		System.out.print("Insira um novo nome: ");
		scanf.nextLine();
		String novoNome = scanf.nextLine();
		System.out.print("Insira a nova idade: ");
		int novaIdade = scanf.nextInt();
		String sql = "UPDATE  Clientes SET nome = '"+ novoNome +"', idade ="+ novaIdade +" where nome ='"+ nome +"';";
		try {
			PreparedStatement update = conexao.prepareStatement(sql);
			update.executeUpdate();
		} catch (Exception e) {
			System.err.println("Erro!");
			e.getMessage();
		}
		System.out.println("Atualizado com sucesso!\n");
		OpenMainMenu();
	}

	public void DeleteData(){

		System.out.print("insira o nome da pessoa a ser apagada: ");
		String nameSearch = scanf.next();
		String sqlDelete = "DELETE FROM Clientes where nome like '%"+ nameSearch + "%';";
		
		try {
			PreparedStatement deletaPessoa = conexao.prepareStatement(sqlDelete);
			deletaPessoa.executeUpdate();
		} catch (Exception e) {
			System.err.println("Erro!");
			e.getMessage();
		}
		System.out.println("Apagado com sucesso!\n");
		OpenMainMenu();
	}

	public void OpenMainMenu(){
		System.out.print("\n|1 - Inserir novos dados\n|2 - Listar dados\n|3 - Atualizar dados\n|4 - Deletar Dados\n|5 - Sair\nInsira a opcao desejada: ");
		int op = scanf.nextInt();
		System.out.println("");
		switch (op) {
		case 1: CreateData();
		break;
		case 2: ReadData();
		break;
		case 3: SearchData();
		break;
		case 4: DeleteData();
		break;
		case 5:System.err.println("Adeus!"); 
		System.exit(0);	
		break;
		default: System.err.println("Opcao invalida");
		break;
		}
	}
}
