package testUI;

public class GameBoard {
	private Cell[] listCell = new Cell[12];
	
	public GameBoard() {
		for(int i = 0; i<12; i++) {
			listCell[i] = new Cell();
		}
	}

	public Cell[] getListCell() {
		return listCell;
	}

	public void setListCell(Cell[] listCell) {
		this.listCell = listCell;
	}
}
