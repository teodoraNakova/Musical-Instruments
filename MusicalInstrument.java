package musical_instruments;

public abstract class MusicalInstrument {
	
	public enum musicalInstrumentType{BRASS, ELECTRICAL, KEYBOARD, PERCUSSION, STRINGED};

	private musicalInstrumentType typeOfInstrument;
	private String name;
	private int price;
	private int availablePieces;
	private int soldPieces;
	
	public MusicalInstrument(musicalInstrumentType typeOfInstrument, String name, int price, int availablePieces) {
		this.typeOfInstrument = typeOfInstrument;
		this.price = price;
		this.availablePieces = availablePieces;
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getAvailablePieces() {
		return availablePieces;
	}
	
	public void setAvailablePieces(int availablePieces) {
		this.availablePieces = availablePieces;
	}
	
	public void setSoldPieces(int soldPieces) {
		this.soldPieces = soldPieces;
	}
	
	public int getSoldPieces() {
		return soldPieces;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "MusicalInstrument [typeOfInstrument=" + typeOfInstrument
				+ ", name=" + name + ", price=" + price + ", availablePieces="
				+ availablePieces + " sold pieces " + soldPieces + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MusicalInstrument other = (MusicalInstrument) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
	
	
}
