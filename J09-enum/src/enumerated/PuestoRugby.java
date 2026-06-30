package enumerated;

public enum PuestoRugby {
	PILIER_IZQ(1, "Prop"), PILIER_DER(3, "Prop"), TALONADOR(2, "Hooker");
	
	private final int dorsal;
	private final String ingles;
	
	private PuestoRugby(int dorsal, String ingles) {
		this.dorsal = dorsal;
		this.ingles = ingles;
	}

	public int getDorsal() {
		return dorsal;
	}

	public String getIngles() {
		return ingles;
	}
}
