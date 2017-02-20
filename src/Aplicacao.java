/**
 * @Resumo Classe principal da aplicacao
 * @author caio
 */
public class Aplicacao {

	public static void main(String[] args) {
		Dados d = new Dados();
		Connect conecta = new Connect();
//		InterfaceGrafica interfaceGrafica = new InterfaceGrafica();
		d.StartConnection(conecta.servidorBanco,conecta.nomeBanco,conecta.usuarioBanco, conecta.senhaBanco);
		new InterfaceGrafica();
	}
}
