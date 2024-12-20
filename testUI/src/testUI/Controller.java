package testUI;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Controller{
	
	List<Gem> gemList = new ArrayList<Gem>();	
	GameBoard gameBoard = new GameBoard();
	
	@FXML
	private ImageView myImage;
	
	@FXML
    private Pane imagePane; // Pane để chứa các ImageView
	
	@FXML
	private Button moveLeftButton;
	
	@FXML
	private Button moveRightButton;
	
	@FXML
	private Button cungChieuButton;
	
	@FXML
	private Button nguocChieuButton;
	
	ToaDo td = new ToaDo();
	
	private static int count = 0;
	
	public ToaDo dichDen(int i) {
		
		switch (i) {
			case 0: 
				td.setX(40+Math.random()*40);
				td.setY(30+Math.random()*120);
				break;
			case 1: 
			case 2: 
			case 3: 
			case 4: 
			case 5: 
				td.setX(10+i*100+Math.random()*60);
				td.setY(10+Math.random()*60);
				break;
			case 6: 
				td.setX(600+Math.random()*40);
				td.setY(30+Math.random()*120);
				break;
			case 7: 
			case 8: 
			case 9: 
			case 10:
			case 11: 
				td.setX(10+(12-i)*100+Math.random()*60);
				td.setY(110+Math.random()*60);
				break;
			case 13:
				td.setX(310+Math.random()*60);
				td.setY(310+Math.random()*60);
				break;
			case 12:
				td.setX(310+Math.random()*60);
				td.setY(-190+Math.random()*60);
				break;
		}
		return td;
	}
	
	@FXML
	public void initialize() {
		
		ToaDo td = new ToaDo();
		
		for(Cell cell : gameBoard.getListCell()){
			for(Gem gem : cell.getListGem()) {
				td = dichDen(cell.getId());
				gem.getImage().setLayoutX(td.getX());
				gem.getImage().setLayoutY(td.getY());
				imagePane.getChildren().add(gem.getImage());
			}
			System.out.println(cell.getValue());
		}
//		System.out.println("X = " + td.getX() + ", Y = " + td.getY());
//
//		for(int i = 0; i<12; i++) {
//	        for (int j = 0; j < 5; j++) {
//	        	td = dichDen(i);
	        	
//	        	File file = new File("C:\\Users\\ADMIN\\Desktop\\testUI\\testUI\\src\\testUI\\gem.png");
//	        	ImageView imageView = new ImageView(file.toURI().toString());

	        	//ImageView imageView = new ImageView(getClass().getResource("/testUI/small-gem-Photoroom.png").toExternalForm());

	        //	ImageView imageView = new ImageView(new String(getClass().getResource("C:\\Users\\ADMIN\\Desktop\\testUI\\testUI\\src\\testUI\small-gem-Photoroom.png").toExternalForm()));
//	            imageView.setFitWidth(20);
//	            imageView.setFitHeight(20);
//	            imageView.setLayoutX(td.getX());
//	            imageView.setLayoutY(td.getY());
//	            
//	            Gem gem = new Gem(1, i);
//	            gemList.add(gem);
//	        }
//		}
//		for (Gem gem : gemList) {
//			System.out.println(gem.getId());
//			System.out.println("In Cell: " + gem.getInCell());
//            imagePane.getChildren().add(gem.getImage());
//		}
	}
	
//	public int moveGemClockwise1Cell(int i) {
//	    SequentialTransition sequentialTransition = new SequentialTransition();
//
//	    int j = 1;
//	    if (gameBoard.getListCell()[i].getListGem().isEmpty()) {
//	        System.out.println("Không có viên đá quý nào để di chuyển.");
//	        return i;
//	    }
//
//	    for (Gem gem : gameBoard.getListCell()[i].getListGem()) {
//	        gameBoard.getListCell()[(i + j) % 12].add(gem);
//
//	        TranslateTransition translate = new TranslateTransition(Duration.millis(500), gem.getImage());
//
//	        double actualX = gem.getImage().getTranslateX() + gem.getImage().getLayoutX();
//	        double actualY = gem.getImage().getTranslateY() + gem.getImage().getLayoutY();
//
//	        ToaDo td = dichDen((i + j) % 12);
//
//	        translate.setByX(td.getX() - actualX);
//	        translate.setByY(td.getY() - actualY);
//
//	        // Tạo độ trễ
//	        translate.setDelay(Duration.millis(50 * j));
//
//	        // Thêm hiệu ứng vào chuỗi
//	        sequentialTransition.getChildren().add(translate);
//	        j++;
//	    }
//
//	    // Xóa các viên đá quý khỏi ô hiện tại
//	    sequentialTransition.setOnFinished(event -> {
//	        gameBoard.getListCell()[i].getListGem().clear();
//	        System.out.println(gameBoard.getListCell()[i].getValue());
//	        System.out.println("Di chuyển hoàn tất!");
//	    });
//
//	    // Bắt đầu hiệu ứng
//	    sequentialTransition.play();
//
//	    return (i + j) % 12;
//	}
	
	
//	public void moveGemClockwise1Cell(int i, Runnable callback) {
//	    SequentialTransition sequentialTransition = new SequentialTransition();
//
//	    int j = 1;
//
//	    for (Gem gem : gameBoard.getListCell()[i].getListGem()) {
//	        gameBoard.getListCell()[(i + j) % 12].add(gem);
//	        TranslateTransition translate = new TranslateTransition();
//	        translate.setNode(gem.getImage());
//	        translate.setDuration(Duration.millis(500));
//
//	        double actualX = gem.getImage().getTranslateX() + gem.getImage().getLayoutX();
//	        double actualY = gem.getImage().getTranslateY() + gem.getImage().getLayoutY();
//
//	        ToaDo td = dichDen((i + j) % 12);
//
//	        translate.setByX(td.getX() - actualX);
//	        translate.setByY(td.getY() - actualY);
//
//	        sequentialTransition.getChildren().add(translate);
//
//	        PauseTransition pause = new PauseTransition(Duration.millis(50));
//	        sequentialTransition.getChildren().add(pause);
//	        j++;
//	    }
//
//	    sequentialTransition.setOnFinished(event -> {
//	        gameBoard.getListCell()[i].getListGem().clear();
//	        if (callback != null) {
//	            callback.run(); // Gọi callback khi hoàn tất
//	        }
//	    });
//
//	    sequentialTransition.play();
//	   // return (i+j)%12;
//	}

//	public void moveGemClockwise(int i) {
//	    int x = moveGemClockwise1Cell(i, () -> {
//	        int k = ; // Xác định ô tiếp theo
//	        if (!gameBoard.getListCell()[k].getListGem().isEmpty()) {
//	            if (k == 0 || k == 6) {
//	                return; // Dừng nếu ô tiếp theo là 0 hoặc 6
//	            }
//	            moveGemClockwise(k); // Đệ quy tiếp tục di chuyển
//	        }
//	    });
//	}

	public void moveGemClockwise1Cell(int i, Consumer<Integer> callback) {
	    SequentialTransition sequentialTransition = new SequentialTransition();

	    AtomicInteger lastCellIndex = new AtomicInteger(i); // Lưu ô cuối cùng bằng AtomicInteger

	    int j = 1; // Dùng để xác định ô đích cho từng viên đá

	    for (Gem gem : gameBoard.getListCell()[i].getListGem()) {
	        lastCellIndex.set((i + j) % 12); // Cập nhật giá trị của ô cuối cùng

	        gameBoard.getListCell()[lastCellIndex.get()].add(gem);

	        TranslateTransition translate = new TranslateTransition();
	        translate.setNode(gem.getImage());
	        translate.setDuration(Duration.millis(500));

	        double actualX = gem.getImage().getTranslateX() + gem.getImage().getLayoutX();
	        double actualY = gem.getImage().getTranslateY() + gem.getImage().getLayoutY();

	        ToaDo td = dichDen(lastCellIndex.get());

	        translate.setByX(td.getX() - actualX);
	        translate.setByY(td.getY() - actualY);

	        sequentialTransition.getChildren().add(translate);

	        // Thêm tạm dừng giữa các viên đá
	        PauseTransition pause = new PauseTransition(Duration.millis(50));
	        sequentialTransition.getChildren().add(pause);

	        j++;
	    }
	    
	    System.out.println(lastCellIndex);

	    sequentialTransition.setOnFinished(event -> {
	        gameBoard.getListCell()[i].getListGem().clear(); // Xóa danh sách viên đá tại ô i
	        if (callback != null) {
	        	System.out.println("---" + lastCellIndex.get());
	            callback.accept(lastCellIndex.get()+1); // Gọi callback với ô cuối cùng
	        }
	    });

	    sequentialTransition.play();
	}

	public void moveGemClockwise(int i) {
	    moveGemClockwise1Cell(i, lastCellIndex -> {
	        if (!gameBoard.getListCell()[lastCellIndex].getListGem().isEmpty()) {
	            // Kiểm tra điều kiện dừng
	            if (lastCellIndex == 0 || lastCellIndex == 6) {
	                return; // Kết thúc nếu rơi vào ô đặc biệt
	            }
	            // Tiếp tục di chuyển từ ô cuối cùng
	            moveGemClockwise(lastCellIndex);
	        }
	    });
	}

//	public void moveGemClockwise1Cell(int i, Consumer<Integer> callback) {
//	    SequentialTransition sequentialTransition = new SequentialTransition();
//
//	    int j = 1; // Dùng để xác định ô đích cho từng viên đá
//	    int lastCellIndex = i; // Lưu lại ô cuối cùng mà đá được đặt vào
//
//	    for (Gem gem : gameBoard.getListCell()[i].getListGem()) {
//	        lastCellIndex = (i + j) % 12; // Tính toán ô đích
//
//	        gameBoard.getListCell()[lastCellIndex].add(gem);
//
//	        TranslateTransition translate = new TranslateTransition();
//	        translate.setNode(gem.getImage());
//	        translate.setDuration(Duration.millis(500));
//
//	        double actualX = gem.getImage().getTranslateX() + gem.getImage().getLayoutX();
//	        double actualY = gem.getImage().getTranslateY() + gem.getImage().getLayoutY();
//
//	        ToaDo td = dichDen(lastCellIndex);
//
//	        translate.setByX(td.getX() - actualX);
//	        translate.setByY(td.getY() - actualY);
//
//	        sequentialTransition.getChildren().add(translate);
//
//	        // Thêm tạm dừng giữa các viên đá
//	        PauseTransition pause = new PauseTransition(Duration.millis(50));
//	        sequentialTransition.getChildren().add(pause);
//
//	        j++;
//	    }
//
//	    sequentialTransition.setOnFinished(event -> {
//	        gameBoard.getListCell()[i].getListGem().clear(); // Xóa danh sách viên đá tại ô i
//	        if (callback != null) {
//	            callback.accept(lastCellIndex); // Gọi callback với ô cuối cùng
//	        }
//	    });
//
//	    sequentialTransition.play();
//	}
//
//
//	public void moveGemClockwise(int i) {
//	    moveGemClockwise1Cell(i, lastCellIndex -> {
//	        if (!gameBoard.getListCell()[lastCellIndex].getListGem().isEmpty()) {
//	            // Kiểm tra điều kiện dừng
//	            if (lastCellIndex == 0 || lastCellIndex == 6) {
//	                return; // Kết thúc nếu rơi vào ô đặc biệt
//	            }
//	            // Tiếp tục di chuyển từ ô cuối cùng
//	            moveGemClockwise(lastCellIndex);
//	        }
//	    });
//	}


	
//	public int moveGemClockwise1Cell(int i) {
//	    SequentialTransition sequentialTransition = new SequentialTransition();
//	    int j = 1;
//
//	    for (Gem gem : gameBoard.getListCell()[i].getListGem()) {
//	    	gameBoard.getListCell()[(i+j)%12].add(gem);
//	        TranslateTransition translate = new TranslateTransition();
//	        translate.setNode(gem.getImage());
//	        translate.setDuration(Duration.millis(500));
//
//	        double actualX = gem.getImage().getTranslateX() + gem.getImage().getLayoutX();
//	        double actualY = gem.getImage().getTranslateY() + gem.getImage().getLayoutY();
//	        
//	        ToaDo td = dichDen((i+j)%12);
//	        
//	        translate.setByX(td.getX() - actualX);
//	        translate.setByY(td.getY() - actualY);
//
//	        // Thêm hiệu ứng chuyển động vào danh sách
//	        sequentialTransition.getChildren().add(translate);
//
//	        // Thêm tạm dừng sau mỗi hiệu ứng
//	        PauseTransition pause = new PauseTransition(Duration.millis(50));
//	        sequentialTransition.getChildren().add(pause);
//	        j++;
//	    }
//	    
//	    
//
//	    // Bắt đầu chuỗi hiệu ứng
//	    sequentialTransition.play();
//	    
//	    gameBoard.getListCell()[i].getListGem().clear();
//	    
//	    return (i+j)%12;
//	}
//	
//	public void moveGemClockwise(int i) {
//		int k = moveGemClockwise1Cell(i);
//		while (gameBoard.getListCell()[k].getListGem().size() != 0) {
//			if(k==0 || k==6) {
//				return;
//			}else {
//				k = moveGemClockwise1Cell(k);
//			}
//		}
//	//	return 0;
//	}
	

//	public int moveGemClockwise(int index) {
//		int k = this.moveGemClockwise1Cell(index);
//		while (this.gameboard[k].getGemInCell().size() != 0) {
//			if ((k==0)||(k==6)) {
//				return 0;
//			}else {
//				k = this.moveGemClockwise1Cell(k);
//			}
//		}
//		int score = 0;
//		while(this.gameboard[k].getGemInCell().size()==0) {
//			if ((this.gameboard[(k+1)%12].getGemInCell().size()!=0)) {
//				score = score + this.gameboard[(k+1)%12].getValue();
//				this.gameboard[(k+1)%12].getGemInCell().clear();
//				if((this.gameboard[0].getValue()==0)&&(this.gameboard[6].getValue()==0)) {
//					this.stopFlag = true;
//				}
//			} else break;
//			k=(k+2)%12;
//		}
//		return score;
//	}
	
	@FXML
	public void click() {
	    SequentialTransition sequentialTransition = new SequentialTransition();

	    for (Gem gem : gameBoard.getListCell()[1].getListGem()) {
	        TranslateTransition translate = new TranslateTransition();
	        translate.setNode(gem.getImage());
	    //    translate.setNode(gemList.get(i).getImage());
	        translate.setDuration(Duration.millis(500));

	        double actualX = gem.getImage().getTranslateX() + gem.getImage().getLayoutX();
	        double actualY = gem.getImage().getTranslateY() + gem.getImage().getLayoutY();
	        ToaDo td = dichDen(12);

	        translate.setByX(td.getX() - actualX);
	        translate.setByY(td.getY() - actualY);

	        // Thêm hiệu ứng chuyển động vào danh sách
	        sequentialTransition.getChildren().add(translate);

	        // Thêm tạm dừng sau mỗi hiệu ứng
	        PauseTransition pause = new PauseTransition(Duration.millis(50));
	        sequentialTransition.getChildren().add(pause);
	    }
	    
//	    for (int i = 0; i < 5; i++) {
//	        TranslateTransition translate = new TranslateTransition();
//	        translate.setNode(gameBoard.getListCell()[1].getListGem().get(i).getImage());
//	    //    translate.setNode(gemList.get(i).getImage());
//	        translate.setDuration(Duration.millis(500));
//
//	        double actualX = gameBoard.getListCell()[1].getListGem().get(i).getImage().getTranslateX() + gameBoard.getListCell()[1].getListGem().get(i).getImage().getLayoutX();
//	        double actualY = gameBoard.getListCell()[1].getListGem().get(i).getImage().getTranslateY() + gameBoard.getListCell()[1].getListGem().get(i).getImage().getLayoutY();
//	        ToaDo td = dichDen(12);
//
//	        translate.setByX(td.getX() - actualX);
//	        translate.setByY(td.getY() - actualY);
//
//	        // Thêm hiệu ứng chuyển động vào danh sách
//	        sequentialTransition.getChildren().add(translate);
//
//	        // Thêm tạm dừng sau mỗi hiệu ứng
//	        PauseTransition pause = new PauseTransition(Duration.millis(50));
//	        sequentialTransition.getChildren().add(pause);
//	    }

	    // Bắt đầu chuỗi hiệu ứng
	    sequentialTransition.play();
	}
	
//	@FXML
//	public void initialize() {
//		ToaDo td = new ToaDo();
//		System.out.println("X = " + td.getX() + ", Y = " + td.getY());
//		for(int i = 0; i<12; i++) {
//	        for (int j = 0; j < 5; j++) {
//	        	td = dichDen(i);
//	        	ImageView imageView = new ImageView(new String(getClass().getResource("small-gem-Photoroom.png").toExternalForm()));
//	            imageView.setFitWidth(20); // Đặt kích thước
//	            imageView.setFitHeight(20);
//	            imageView.setLayoutX(td.getX()); // Đặt vị trí x
//	            imageView.setLayoutY(td.getY());    // Đặt vị trí y
//	            imageViewList.add(imageView); // Thêm vào danh sách
//	            imagePane.getChildren().add(imageView);
//	        }
//		}
//	}
	
//    @FXML
//    public void initialize() {
//        for (int i = 0; i < 60; i++) {
//            // Nếu ảnh nằm cùng thư mục
//            ImageView imageView = new ImageView(new String(getClass().getResource("big-gem-Photoroom.png").toExternalForm()));
//
//            imageView.setFitWidth(50);
//            imageView.setFitHeight(50);
//            imageView.setLayoutX((i % 10) * 60);
//            imageView.setLayoutY((i / 10) * 60);
//            imageViewList.add(imageView);
//            imagePane.getChildren().add(imageView);
//        }
//    }
	
//	@FXML
//	public void cungChieu() {
//	    animateGem(0); // Bắt đầu từ phần tử đầu tiên
//	}

//	private void animateGem(int index) {
//	    if (index >= 5) return; // Kết thúc khi hết danh sách
//
//	    TranslateTransition translate = new TranslateTransition();
//	    translate.setNode(gemList.get(index).getImage());
//	    translate.setDuration(Duration.millis(1000));
//
//	    double actualX = gemList.get(index).getImage().getTranslateX() + gemList.get(index).getImage().getLayoutX();
//	    double actualY = gemList.get(index).getImage().getTranslateY() + gemList.get(index).getImage().getLayoutY();
//	    ToaDo td = dichDen(index + 2);
//
//	    translate.setByX(td.getX() - actualX);
//	    translate.setByY(td.getY() - actualY);
//
//	    translate.setOnFinished(event -> {
//	        PauseTransition pause = new PauseTransition(Duration.millis(50)); // Dừng 1 giây
//	        pause.setOnFinished(e -> animateGem(index + 1)); // Tiếp tục với phần tử tiếp theo
//	        pause.play();
//	    });
//
//	    translate.play(); // Thực hiện chuyển động
//	}
	
	@FXML
	public void click1() {
		moveGemClockwise(3);
		System.out.println("=============");
		for (int i = 0; i<12; i++) {
			System.out.println(gameBoard.getListCell()[i].getValue());
		}
	}
	@FXML
	public void click2() {
		System.out.println(gameBoard.getListCell()[1].getValue());
	}
	@FXML
	public void click3() {
		System.out.println("===================");
		for (int i = 0; i<12; i++) {
			System.out.println(gameBoard.getListCell()[i].getValue());
		}
	}
	@FXML
	public void click4() {
		
	}
	@FXML
	public void click5() {
		
	}
	@FXML
	public void click7() {
		
	}
	@FXML
	public void click8() {
		
	}
	@FXML
	public void click9() {
		
	}
	@FXML
	public void click10() {
		
	}
	@FXML
	public void click11() {
		
	}

	@FXML
	public void cungChieu() {
		System.out.println("Click cungChieuButton!");
	    SequentialTransition sequentialTransition = new SequentialTransition();
	    int count = 2;

	    for (Gem gem : gameBoard.getListCell()[1].getListGem()) {
	        TranslateTransition translate = new TranslateTransition();
	        translate.setNode(gem.getImage());
	        translate.setDuration(Duration.millis(500));

	        double actualX = gem.getImage().getTranslateX() + gem.getImage().getLayoutX();
	        double actualY = gem.getImage().getTranslateY() + gem.getImage().getLayoutY();
	        ToaDo td = dichDen(count++);

	        translate.setByX(td.getX() - actualX);
	        translate.setByY(td.getY() - actualY);

	        // Thêm hiệu ứng chuyển động vào danh sách
	        sequentialTransition.getChildren().add(translate);

	        // Thêm tạm dừng sau mỗi hiệu ứng
	        PauseTransition pause = new PauseTransition(Duration.millis(50));
	        sequentialTransition.getChildren().add(pause);
	    }
	    sequentialTransition.play();
	}
	
//	@FXML
//	public void cungChieu() {
//	    SequentialTransition sequentialTransition = new SequentialTransition();
//
//	    for (int i = 0; i < 5; i++) {
//	        TranslateTransition translate = new TranslateTransition();
//	        translate.setNode(gemList.get(i).getImage());
//	        translate.setDuration(Duration.millis(500));
//
//	        double actualX = gemList.get(i).getImage().getTranslateX() + gemList.get(i).getImage().getLayoutX();
//	        double actualY = gemList.get(i).getImage().getTranslateY() + gemList.get(i).getImage().getLayoutY();
//	        ToaDo td = dichDen(i + 2);
//
//	        translate.setByX(td.getX() - actualX);
//	        translate.setByY(td.getY() - actualY);
//
//	        // Thêm hiệu ứng chuyển động vào danh sách
//	        sequentialTransition.getChildren().add(translate);
//
//	        // Thêm tạm dừng sau mỗi hiệu ứng
//	        PauseTransition pause = new PauseTransition(Duration.millis(50));
//	        sequentialTransition.getChildren().add(pause);
//	    }
//
//	    // Bắt đầu chuỗi hiệu ứng
//	    sequentialTransition.play();
//	}

	
	
//	@FXML
//	public void cungChieu() {
//		for(int i = 0; i<5; i++) {
//			TranslateTransition translate = new TranslateTransition();
//			translate.setNode(gemList.get(i).getImage());
//			translate.setDuration(Duration.millis(1000));
//			double actualX = gemList.get(i).getImage().getTranslateX() + gemList.get(i).getImage().getLayoutX();
//			double actualY = gemList.get(i).getImage().getTranslateY() + gemList.get(i).getImage().getLayoutY();
//			ToaDo td = new ToaDo();
//			td = dichDen(i+2);
//			translate.setByX(td.getX()-actualX);
//			translate.setByY(td.getY()-actualY);
//			translate.play();
//		}
//	}
//	
	
//	@FXML
//	public void cungChieu() {
//		TranslateTransition translate = new TranslateTransition();
//		translate.setNode(myImage);
//		translate.setDuration(Duration.millis(1000));
//		double actualX = myImage.getTranslateX() + myImage.getLayoutX();
//		double actualY = myImage.getTranslateY() + myImage.getLayoutY();
//		ToaDo td = new ToaDo();
//		if (count<11) {
//			count = count+1;
//		} else {
//			count=0;
//		}
//		System.out.println(count);
//		td = dichDen(count);
//		System.out.println("X = " + td.getX() + ", Y = " + td.getY());
//		translate.setByX(td.getX()-actualX);
//		translate.setByY(td.getY()-actualY);
//		translate.play();
//	}
	
	@FXML
	public void nguocChieu() {
		TranslateTransition translate = new TranslateTransition();
		translate.setNode(myImage);
		translate.setDuration(Duration.millis(1000));
		double actualX = myImage.getTranslateX() + myImage.getLayoutX();
		double actualY = myImage.getTranslateY() + myImage.getLayoutY();
		ToaDo td = new ToaDo();
		if (count>0) {
			count = count -1;
		} else {
			count=11;
		}
		System.out.println(count);
		td = dichDen(count);
		System.out.println("X = " + td.getX() + ", Y = " + td.getY());
		translate.setByX(td.getX()-actualX);
		translate.setByY(td.getY()-actualY);
		translate.play();
	}
	
	@FXML
	public void moveLeft() {
		TranslateTransition translate = new TranslateTransition();
		translate.setNode(myImage);
		translate.setDuration(Duration.millis(1000));
		double actualX = myImage.getTranslateX() + myImage.getLayoutX();
		double actualY = myImage.getTranslateY() + myImage.getLayoutY();
		System.out.println("X = " + actualX + ", Y = " + actualY);
			translate.setByX(20+Math.random()*60-actualX);
			translate.setByY(20+Math.random()*60-actualY);
			translate.play();
	}
	@FXML
	public void moveRight() {
		TranslateTransition translate = new TranslateTransition();
		translate.setNode(myImage);
		translate.setDuration(Duration.millis(1000));
		double actualX = myImage.getTranslateX() + myImage.getLayoutX();
		double actualY = myImage.getTranslateY() + myImage.getLayoutY();
		System.out.println("X = " + actualX + ", Y = " + actualY);
		translate.setToX(Math.random()*150);
		translate.setToY(Math.random()*150);
			translate.play();
	}

}
