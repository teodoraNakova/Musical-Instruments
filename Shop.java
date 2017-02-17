package shop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

import musical_instruments.MusicalInstrument;
import musical_instruments.MusicalInstrument.musicalInstrumentType;

public class Shop {

	private int money;
	private TreeMap<musicalInstrumentType, TreeMap<String, MusicalInstrument>> instrumentsForSale;
	
	public Shop() {
		instrumentsForSale = new TreeMap<musicalInstrumentType, TreeMap<String,MusicalInstrument>>();
	}
	
	public int getMoney() {
		return money;
	}
	
	public void addInstrumentsToShop(musicalInstrumentType type, String name, MusicalInstrument instrument) {
		if(!this.instrumentsForSale.containsKey(type)) {
			this.instrumentsForSale.put(type, new TreeMap<String, MusicalInstrument>());
		}
	    this.instrumentsForSale.get(type).put(name, instrument);
	}
	
	public void sellInstrument(musicalInstrumentType type, String name, int pieces) {
		MusicalInstrument instrumentForSale = this.instrumentsForSale.get(type).get(name);
		int instrumentAvailablePieces = instrumentForSale.getAvailablePieces();
		if(instrumentAvailablePieces >= pieces) {
			this.money += instrumentForSale.getPrice();
			instrumentForSale.setAvailablePieces(instrumentAvailablePieces - pieces);
			System.out.println("Just sold " + pieces + " piece/s from instrument " + name + ".");
			System.out.println("Pieces left - " + instrumentForSale.getAvailablePieces() + ".");
			int countBefore = this.instrumentsForSale.get(type).get(name).getSoldPieces();
			this.instrumentsForSale.get(type).get(name).setSoldPieces(countBefore + pieces);
			return;
		}
		System.out.println("Sorry, we don't have " + pieces + " pieces from instrument " + name + "." );
	}
	
	public void listSoldInstruments() {
		ArrayList<MusicalInstrument> soldInstruments = new ArrayList<MusicalInstrument>();
		soldInstruments = copyInstruments();
		soldInstruments.sort(new Comparator<MusicalInstrument>() {
			@Override
			public int compare(MusicalInstrument o1, MusicalInstrument o2) {
				return o1.getSoldPieces() - o2.getSoldPieces();
			}
		});
		print(soldInstruments);
	}
	
	public String getMostSoldInstrument(){
		ArrayList<MusicalInstrument> instruments = new ArrayList<MusicalInstrument>();
		instruments = copyInstruments();
		String name = "";
		int mostSold = 0;
		for(int i = 0; i < instruments.size(); i++) {
			if(instruments.get(i).getSoldPieces() > mostSold) {
				name = instruments.get(i).getName();
				mostSold = instruments.get(i).getSoldPieces();
			}
		}
		return name;
	}
	
	public void browseCatalogue() {
		System.out.println("Hi, this is our catalogue.");
		while(true) {
			System.out.println("Please enter 0 to exit.");
			System.out.println("Please enter 1 for instruments, sorted by type.");
			System.out.println("Please enter 2 for instruments, sorted by name in alphabetical order.");
			System.out.println("Please enter 3 for instruments, sorted by price(low - high).");
			System.out.println("Please enter 4 for instruments, sorted by price(high - low).");
			System.out.println("Please enter 5 for list of available instruments.");
			int choice = new Scanner(System.in).nextInt();
			ArrayList<MusicalInstrument> instruments = new ArrayList<MusicalInstrument>();
			instruments = copyInstruments();
			
			if(choice == 0) {
				System.out.println("Bye!");
				break;
			}
			
			if(choice == 1) {
				for(Entry<musicalInstrumentType, TreeMap<String, MusicalInstrument>> e : instrumentsForSale.entrySet()) {
					System.out.println(e.getKey());
					System.out.println(e.getValue());
				}
			}	
			
			if(choice == 2) {
				instruments.sort(new Comparator<MusicalInstrument>() {
					@Override
					public int compare(MusicalInstrument o1, MusicalInstrument o2) {
						return o1.getName().compareTo(o2.getName());
					}
				});
				print(instruments);
			}
			
			if(choice == 3) {
				instruments.sort(new Comparator<MusicalInstrument>() {
					@Override
					public int compare(MusicalInstrument o1, MusicalInstrument o2) {
						return o1.getPrice() - o2.getPrice();
					}
				});
				print(instruments);
			}
			
			if(choice == 4) {
				instruments.sort(new Comparator<MusicalInstrument>() {
					@Override
					public int compare(MusicalInstrument o1, MusicalInstrument o2) {
						return o2.getPrice() - o1.getPrice();
					}
				});
				print(instruments);
			}
			
			if(choice == 5) {
				for(MusicalInstrument m : instruments) {
					if(m.getAvailablePieces() > 0) {
						System.out.println(m);
					}
				}
			}
		
		}
	}
	
	private void print(ArrayList<MusicalInstrument> instruments) {
		for(MusicalInstrument m : instruments) {
			System.out.println(m);
		}
	}
	
	private ArrayList<MusicalInstrument> copyInstruments() {
		ArrayList<MusicalInstrument> instruments = new ArrayList<MusicalInstrument>();
		for(Entry<musicalInstrumentType, TreeMap<String, MusicalInstrument>> e : this.instrumentsForSale.entrySet()) {
			TreeMap<String, MusicalInstrument> map = e.getValue();
			for(Entry<String, MusicalInstrument> e1 : map.entrySet()) {
				instruments.add(e1.getValue());
			}
		}
		return instruments;
	}
	
}
