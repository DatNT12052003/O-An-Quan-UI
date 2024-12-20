package testUI;

import java.io.File;

import javafx.scene.image.ImageView;

public class Gem {
	private int id;
	private int value;
	private ImageView image;
	private int inCell;
	private static int count = 0;
	
	public Gem(int inCell) {
		count++;
		this.id = count;
		this.value = 1;
		this.image = setImg();
		this.inCell = inCell;
	}
	
	public ImageView setImg() {
    	File file = new File("C:\\Users\\ADMIN\\Desktop\\testUI\\testUI\\src\\testUI\\gem.png");
    	ImageView img = new ImageView(file.toURI().toString());
        img.setFitWidth(20);
        img.setFitHeight(20);
        return img;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	public ImageView getImage() {
		return image;
	}
	public void setImage(ImageView image) {
		this.image = image;
	}
	public int getInCell() {
		return inCell;
	}
	public void setInCell(int inCell) {
		this.inCell = inCell;
	}	
	
}
