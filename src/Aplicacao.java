/**
 * @Resumo Classe principal da aplicacao
 * @author caio.dantas
 */
public class Aplicacao {

	public static void main(String[] args) {
		Dados d = new Dados();
		Conect conecta = new Conect();

		d.StartConnection(conecta.servidorBanco,conecta.nomeBanco,conecta.usuarioBanco, conecta.senhaBanco);
	}
}
