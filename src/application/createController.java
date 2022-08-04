package application;

import java.awt.AWTException;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

public class createController implements Initializable {

    @FXML
    private Button openImage;

    @FXML
    private ImageView ivFile;

    final FileChooser fc = new FileChooser();

    @FXML
    private TextField topTextField;

    @FXML
    private TextField bottomTextField;

    @FXML
    private Button exportMemeButton;

    @FXML
    private Text topText;

    @FXML
    private Text bottomText;

    @FXML
    void imageHasBeenOpened(ActionEvent event) {

        fc.setTitle("My File Chooser");

        fc.setInitialDirectory(new File(System.getProperty("user.home")));

        fc.getExtensionFilters().clear();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));

        File file = fc.showOpenDialog(null);

        if (file != null) {
            ivFile.setImage(new Image(file.toURI().toString()));

        } else {
            System.out.println("The file is invalid");
        }

    }

    @FXML
    void exportMemeButtonClicked(MouseEvent event) {
        topText.setText(topTextField.getText());
        bottomText.setText(bottomTextField.getText());

    	 try {
             Robot robot = new Robot();
             String format = "jpg";
             String fileName = "PartialScreenshot." + format;
              
             Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
             Rectangle captureRect = new Rectangle(0, 0, screenSize.width, screenSize.height);
             BufferedImage screenFullImage = robot.createScreenCapture(captureRect);
             ImageIO.write(screenFullImage, format, new File(fileName));
              
             System.out.println("A partial screenshot saved!");
         } catch (AWTException | IOException ex) {
             System.err.println(ex);
         }
         
        //this.captureImageComponent(ivFile);
    }

    void captureImageComponent(JComponent component, File imageFile) throws IOException {
        BufferedImage bufImage = new BufferedImage(component.getSize().width, component.getSize().height, BufferedImage.TYPE_INT_RGB);
        component.paint(bufImage.createGraphics());
        imageFile.createNewFile();
        ImageIO.write(bufImage, "jpeg", imageFile);
    }

    void captureComponent(Component component) {
        Rectangle rect = component.getBounds();

        try {
            String format = "png";
            String fileName = component.getName() + "." + format;
            BufferedImage captureImage =
                new BufferedImage(rect.width, rect.height,
                    BufferedImage.TYPE_INT_ARGB);
            component.paint(captureImage.getGraphics());

            ImageIO.write(captureImage, format, new File(fileName));

            System.out.printf("The screenshot of %s was saved!", component.getName());
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

    }

}
