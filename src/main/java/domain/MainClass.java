package domain;

public class MainClass {
	public static void main(String[] args) {
		Usuario u = new Usuario();
		Usuario t = new Usuario();
		Guardarropa g = new Guardarropa("lel");
		
		u.agregarGuardarropa(g);
		u.compartirGuardarropa(t, g);
		//System.out.println(t.getGuardarropas().size());
	}
}
