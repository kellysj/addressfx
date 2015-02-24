/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colorfulcircles;

import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

/**
 *
 * @author Kelly
 */
public class ColorfulCircles extends Application {
        int CanL = 400;
        int CanW = 300;
        Canvas canvas = new Canvas(CanL,CanW);
        GraphicsContext gc = canvas.getGraphicsContext2D();
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Draw Shapes");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                drawShapes(gc);
            }
        });
        Button btn2 = new Button();
        btn2.setText("Add text");
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                gc.fillText("ATTAGCACACA", CanW/2, CanL/2);
            }
        });

        
        
        
        StackPane buttonbox = new StackPane();
        buttonbox.getChildren().addAll(btn2);
        StackPane canvasbox = new StackPane();
        canvasbox.getChildren().add(canvas);
        SplitPane inner = new SplitPane();
        inner.getItems().addAll(buttonbox,canvasbox);
        
        StackPane root = new StackPane();
        root.getChildren().add(inner);
        
        Scene scene = new Scene(root, 500, 500);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    private void drawShapes(GraphicsContext gc) {
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        gc.strokeLine(40, 10, 10, 40);
        gc.fillOval(10, 60, 30, 30);
        gc.strokeOval(60, 60, 30, 30);
        gc.fillRoundRect(110, 60, 30, 30, 10, 10);
        gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
        gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
        gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
        gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
        gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
        gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
        gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
        gc.fillPolygon(new double[]{10, 40, 10, 40},
                       new double[]{210, 210, 240, 240}, 4);
        gc.strokePolygon(new double[]{60, 90, 60, 90},
                         new double[]{210, 210, 240, 240}, 4);
        gc.strokePolyline(new double[]{110, 140, 110, 140},
                          new double[]{210, 210, 240, 240}, 4);
    }
    
    private void drawLinearGradient(Color firstColor, Color secondColor) {
    LinearGradient lg = new LinearGradient(0, 0, 1, 1, true,
                        CycleMethod.REFLECT,
                        new Stop(0.0, firstColor),
                        new Stop(1.0, secondColor));
    gc.setStroke(lg);
    gc.setLineWidth(20);
    gc.stroke();
}
}
