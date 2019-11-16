import java.io.File;

public class Tree {
	
	private No raiz;
	
	private Tree() {
		this.raiz = null;
	}
	
	public void acesso(File f, int key, int keyPai) {
		if(this.raiz == null) {
			this.raiz = this.criaNovoNo(f, key);
			this.insert(this.raiz, f, key, keyPai);			
		}
		if(f.listFiles() != null) {
			for(File tmp : f.listFiles()) {
				if(tmp.isDirectory()) {
					this.insert(this.raiz, tmp, key+1, keyPai+1);
					acesso(tmp, key+1, keyPai+1);
				}else {	
					this.insert(this.raiz, tmp, 0, key);
				}
			}
		}
	}

	public Tree(File dado, int key) {

	}

	public No criaNovoNo(File file, int key) {
		No novo = new No();
		novo.setPrimFilho(null);
		novo.setProxIrmao(null);
		novo.setFile(file);
		novo.setNome(file.getName());
		novo.setKey(key);
		return novo;
	}

	public boolean insert(No raiz, File file,int novaChave,  int chavePai) {

		No pai = buscaChave(chavePai, raiz);
		if(pai == null) {
			return false;
		}
		No filho = this.criaNovoNo(file, novaChave);
		No p = pai.getPrimFilho();
		if(p == null) {
			pai.setPrimFilho(filho);
		}else {
			while(p.getProxIrmao() != null) {
				p = p.getProxIrmao();
				p.setProxIrmao(filho);
			}
		}

		return true;
	}

	public No buscaChave(int ch, No raiz) {
		if(raiz == null) {
			return null;
		}else if(raiz.getKey() == ch) {
			return raiz;
		}
		No p = raiz.getPrimFilho();
		while(p != null) {
			No aux = this.buscaChave(ch, p);
			if(aux != null) {
				return aux;
			}
			p = p.getProxIrmao();
		}
		return null;
	}
	
	public void print() {
		this.print(this.raiz);
	}
	
	public void print(No raiz) {
		if(raiz == null) {
			return;
		}
		System.out.print(raiz.getNome()+"((((");
		No p = raiz.getPrimFilho();
		while(p != null) {
			this.print(p);
			p = p.getProxIrmao();
		}
		System.out.print(")");
	}
	public static void main(String[] args) {
		
		Tree d = new Tree();
		File f = new File("D:\\teste");
		d.acesso(f, 1, 1);		
		d.print();
	}
}
