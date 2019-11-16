import java.io.File;

public class Node {
	
	private int key;
	private String nome;
	private Node filho;
	private Node irmao;
	private File dado;
	
	public Node(File dado) {
		this.setDado(dado);
		this.setFilho(null);
		this.setIrmao(null);
		this.nome = dado.getName();
	}		

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public File getDado() {
		return dado;
	}

	public void setDado(File dado) {
		this.dado = dado;
	}

	public Node getFilho() {
		return filho;
	}

	public void setFilho(Node filho) {
		this.filho = filho;
	}

	public Node getIrmao() {
		return irmao;
	}

	public void setIrmao(Node irmao) {
		this.irmao = irmao;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
}
