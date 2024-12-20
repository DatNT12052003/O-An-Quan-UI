package testUI;

import java.util.ArrayList;
import java.util.List;

public class Cell {
	private int id;
	private List<Gem> listGem = new ArrayList<Gem>();
	private int value;
	static int count = 0;
	
	
	public Cell() {
		this.id = count;
		count++;
		for(int i = 0; i<5; i++) {
			listGem.add(new Gem(this.id));
		}
	}
	
	public void add(Gem gem) {
		listGem.add(gem);
		}
	
	public void remove(Gem gem) {
		if(listGem.contains(gem)) {
			listGem.remove(gem);
		}
	}
	
	
	public int getValue() {
		int total = 0;
		for (Gem g : listGem) {
			total += g.getValue();
		}
		return  total;
	}

	public void valueCaculate() {
		int total = 0;
		for (Gem g : listGem) {
			total += g.getValue();
		}
		this.value = total;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Gem> getListGem() {
		return listGem;
	}
	public void setListGem(List<Gem> listGem) {
		this.listGem = listGem;
	}
}
