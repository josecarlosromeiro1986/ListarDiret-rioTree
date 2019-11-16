import java.io.File;

public class No {
	
	private int key;
	private String nome;
	private File file;
	private No primFilho;
	private No proxIrmao;	
	
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public No getPrimFilho() {
		return primFilho;
	}
	public void setPrimFilho(No primFilho) {
		this.primFilho = primFilho;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public No getProxIrmao() {
		return proxIrmao;
	}
	public void setProxIrmao(No proxIrmao) {
		this.proxIrmao = proxIrmao;
	}
}