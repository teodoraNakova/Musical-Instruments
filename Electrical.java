package musical_instruments;

public class Electrical extends MusicalInstrument {
	
	public enum elektronniType{SINTEZATOR, BAS_KITARA, ELEKTRICHESKA_CIGULKA};
	
	private elektronniType type;

	public Electrical(musicalInstrumentType typeOfInstrument, String name,
			int price, int availablePieces) {
		super(typeOfInstrument, name, price, availablePieces);
	}

}
