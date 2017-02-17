package demo;

import musical_instruments.Brass;
import musical_instruments.Electrical;
import musical_instruments.Keyboard;
import musical_instruments.Percussion;
import musical_instruments.MusicalInstrument.musicalInstrumentType;
import musical_instruments.Stringed;
import shop.Shop;

public class Demo {

	public static void main(String[] args) {
		
		Shop myShop = new Shop();
		Brass trombon = new Brass(musicalInstrumentType.BRASS, "Trombon", 300, 5);
		Electrical basKitara = new Electrical(musicalInstrumentType.ELECTRICAL, "Bas kitara", 700, 10);
		Keyboard piano = new Keyboard(musicalInstrumentType.KEYBOARD, "Piano", 1200, 2);
		Stringed arfa = new Stringed(musicalInstrumentType.STRINGED, "Arfa", 1400, 1);
		Percussion baraban = new Percussion(musicalInstrumentType.PERCUSSION, "Baraban", 70, 20);

		myShop.addInstrumentsToShop(musicalInstrumentType.BRASS, "Trombon", trombon);
		myShop.addInstrumentsToShop(musicalInstrumentType.ELECTRICAL, "Bas kitara", basKitara);
		myShop.addInstrumentsToShop(musicalInstrumentType.KEYBOARD, "Piano", piano);
		myShop.addInstrumentsToShop(musicalInstrumentType.STRINGED, "Arfa", arfa);
		myShop.addInstrumentsToShop(musicalInstrumentType.PERCUSSION, "Baraban", baraban);
		
		myShop.browseCatalogue();
		
	    myShop.sellInstrument(musicalInstrumentType.BRASS, "Trombon", 1);
	    myShop.sellInstrument(musicalInstrumentType.ELECTRICAL, "Bas kitara", 5);
	    myShop.sellInstrument(musicalInstrumentType.BRASS, "Trombon", 2);
	    myShop.sellInstrument(musicalInstrumentType.STRINGED, "Arfa", 1);
	    
	    myShop.listSoldInstruments();
	    System.out.println("Profit for the shop, after all the deals: " + myShop.getMoney());
	    System.out.println("Most sold instrument " + myShop.getMostSoldInstrument() + ".");
	    
	}

}
