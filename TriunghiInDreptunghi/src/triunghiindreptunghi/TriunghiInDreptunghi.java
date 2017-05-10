
package triunghiindreptunghi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @sulitas
 */
public class TriunghiInDreptunghi extends Application {

	class ResizableCanvas extends Canvas {
                         
		public ResizableCanvas() {
			// redeseneaza canvasul cand se modofica dimensiunea
			widthProperty().addListener(evt -> draw());
			heightProperty().addListener(evt -> draw());
		}

                @SuppressWarnings("empty-statement")
		private void draw() {
			double width = getWidth();
			double height = getHeight();
                        double x0=20, y0=20; 
                        double latime;
                        double inaltime;
                        latime=width-2*x0;
                        inaltime=height-2*y0;
                        double x[] = new double[] {(x0+latime/2), (x0+latime), x0};
                        double y[] = new double[] {y0, (y0+inaltime), (y0+inaltime)};
                                                                            
                        GraphicsContext gc = getGraphicsContext2D();
                        gc.clearRect(0, 0, width, height);
                        
                        //deseneaza dreptunghiul
                        gc.setStroke(Color.BLUE);  
                        gc.setLineWidth(20);
                        gc.strokeRect(x0,y0,width-2*x0,height-2*y0);
                        gc.setFill(Color.YELLOW); 
                        gc.fillRect(x0,y0,width-2*x0,height-2*y0);
                         
                        //deseneaza triunghiul
                        gc.setStroke(Color.RED);  
                        gc.setLineWidth(1);
                        gc.strokePolygon(x, y, 3);
                        gc.setFill(Color.RED);
                        gc.fillPolygon(x, y, 3);                        
                }

		@Override
		public boolean isResizable() {
			return true;
		}

		@Override
		public double prefWidth(double height) {
			return getWidth();
		}

		@Override
		public double prefHeight(double width) {
			return getHeight();
		}
	}

	@Override
	public void start(Stage stage) throws Exception {
		ResizableCanvas canvas = new ResizableCanvas();

		StackPane stackPane = new StackPane();
		stackPane.getChildren().add(canvas);
              //  root.getChildren().add(cerc);

		// Conectarea marimii canvasului cu marimea stackpane
		canvas.widthProperty().bind(stackPane.widthProperty());
		canvas.heightProperty().bind(stackPane.heightProperty());

		stage.setScene(new Scene(stackPane, 150, 250));
		stage.setTitle("Silviu Sulita - JavaFX - Triunghi in dreptunghi");
		stage.show();
	}

        /**
        * @param args the command line arguments
        */
	public static void main(String[] args) {
		launch(args);
	}
}
