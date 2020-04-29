package domain;

public abstract class UniformeBuilder {
	protected Uniforme uniforme = new Uniforme();

	public Uniforme getUniforme() {
		return uniforme;
	}

	public void setUniforme(Uniforme uniforme) {
		this.uniforme = uniforme;
	}
	
	public abstract void buildSuperior();
	public abstract void buildInferior();
	public abstract void buildCalzado();
}
