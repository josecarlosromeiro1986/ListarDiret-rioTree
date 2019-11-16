import java.io.File;

public class Teste {

	public static void acesso(File f, int v, int key) {

		for(int i = 0; i < v; i++) {
			System.out.print("\t");
		}

		System.out.println(f.getName());		
		if(f.listFiles() != null) {
			for(File tmp : f.listFiles()) {
				if(tmp.isDirectory()) {					
					acesso(tmp, v+1, key+1);
				}else {
					for(int i = 0; i < v+1; i++) {
						System.out.print("\t");
					}
					System.out.println(tmp.getName());
				}
			}
		}
	}


		public static void main(String[] args) {		
	
	
			File f = new File("C:\\Copia");
	
			Teste t = new Teste();
	
			t.acesso(f, 0, 0);
		}

	
}


//else {
//this.addIrmao(raiz.getFilho(), dado, key, keyPai);			
//}				
//}else {
//this.criaNode(raiz.getFilho(), dado, key, keyPai);
