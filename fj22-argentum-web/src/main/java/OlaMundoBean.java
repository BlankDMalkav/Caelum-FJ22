import javax.faces.bean.ManagedBean;

@ManagedBean
public class OlaMundoBean {
	private String mensagem = "QUEM É VOCê!";
	private String nome;

	public String getMensagem() {
		System.out.println("get Mensagem");
		return mensagem;
	}

	public String getNome() {
		System.out.println("get Nome");
		return nome;
	}

	public void setNome(String nome) {
		System.out.println("set Nome");
		this.nome = nome;
	}

	public void nomeFoiDigitado() {
		System.out.println("\nChamou o botao");
	}
}