package musical_instruments;

public class Stringed extends MusicalInstrument {
	
//	public enum strunniType{CIGULKA, VIOLA, KONTRABAS, ARFA, KITARA};
//	private strunniType type;
	
	public Stringed(musicalInstrumentType typeOfInstrument, String name, int price,
			int availablePieces) {
		super(typeOfInstrument, name, price, availablePieces);
	}
}
