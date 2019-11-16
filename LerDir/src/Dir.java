import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Dir {

	private Node raiz;
	private int key;
	private int keyPai;

	public Dir() {
		this.raiz = null;
		this.key = 1;
		this.keyPai = 0;
	}

	public void acesso(File f) {	
		List<File> lista = new ArrayList<File>();
		if(this.raiz == null) {
			this.criaNode(f, this.key, keyPai);
			this.keyPai++;
		}
		if(f.listFiles() != null) {
			for(File tmp : f.listFiles()) {				
				lista.add(tmp.getAbsoluteFile());
			}
		}
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).isDirectory()) {
				this.key++;
				this.criaNode(lista.get(i), this.key, this.keyPai);				
			}else {
				this.criaNode(lista.get(i), 0, this.keyPai);				
			}
		}
		this.buscaNo(this.raiz);
	}

	public void buscaNo(Node raiz) {
		if(raiz != null) {			
			if(raiz.getDado().isDirectory() && raiz.getFilho() == null) {
				if(raiz.getFilho() == null || raiz.getIrmao() == null) {
					this.keyPai = raiz.getKey();
					this.acesso(raiz.getDado());				
				}
			}else {
				this.buscaNo(raiz.getFilho());					
				this.buscaNo(raiz.getIrmao());
			}
		}
	}
	
	public Node buscaPai(Node raiz, int key) {	
		if(raiz == null) {
			return raiz;
		}
		if(raiz.getKey() == key) {
			return raiz;
		}
		Node pai = raiz.getFilho();
		while(pai != null) {
			Node aux = this.buscaPai(pai, key);
			if(aux != null) {
				return aux;
			}
			pai = pai.getIrmao();
		}
		return null;
	}

	public void criaNode(File dado, int key, int keyPai) {
		this.raiz = this.criaNode(this.raiz, dado, key, keyPai);
	}

	public Node criaNode(Node raiz, File dado, int key, int keyPai) {
		if(raiz != null) {			
			if(keyPai == raiz.getKey()) {
				if(raiz.getFilho() == null) {
					raiz.setFilho(this.criaNode(raiz.getFilho(), dado, key, keyPai));
				}else if(raiz.getFilho() != null){
					this.addIrmao(raiz.getFilho(), dado, key, keyPai);					
				}
			}else {
				this.criaNode(this.buscaPai(raiz, keyPai), dado, key, keyPai);				
			}
		}else {
			raiz = new Node(dado);
			raiz.setDado(dado);
			raiz.setNome(dado.getName());
			raiz.setKey(key);			
		}		
		return raiz;
	}

	public Node addIrmao(Node filho, File dado, int key, int keyPai) {
		if(filho.getIrmao() != null) {
			this.addIrmao(filho.getIrmao(), dado, key, keyPai);
		}else {
			filho.setIrmao(this.criaNode(filho.getIrmao(), dado, key, keyPai));			
		}
		return filho;
	}

	public void print() {
		int v = 0;
		this.print(this.raiz, v);
	}

	public void print(Node raiz, int v) {

		if(raiz != null) {			
			for(int i = 0; i < v; i++) {
				System.out.print("\t");
			}
			System.out.println(raiz.getNome());				
			this.print(raiz.getFilho(), v+1);
			v--;
			this.print(raiz.getIrmao(), v+1);
		}
	}

	public static void main(String[] args) {

		Dir d = new Dir();
		File f = new File("C:\\Copia"); 	//Endereço do Diretório
		d.acesso(f);
		d.print();
	}
}