package com.example.loginpage;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LoginController {

    @FXML private AnchorPane anchor1;
    @FXML private AnchorPane anchor2;

    @FXML TextField username;
    @FXML PasswordField password;

    @FXML ToggleButton openButton;
    @FXML Label mainLabel;
    @FXML Button mButton;

    TranslateTransition tt=new TranslateTransition();

    public void openButtonAction(){
        if(openButton.isSelected()){

            tt.setNode(anchor2);
            tt.setInterpolator(Interpolator.LINEAR);
            tt.setDuration(Duration.millis(500));
            tt.setFromX(anchor2.getLayoutX());
            tt.setToX(anchor2.getLayoutX()+anchor2.getWidth()-50);
            tt.play();

            mainLabel.setText("Close");
        }

        else{
            tt.setNode(anchor2);
            tt.setInterpolator(Interpolator.LINEAR);
            tt.setDuration(Duration.millis(500));
            tt.setFromX(anchor2.getLayoutX()+anchor2.getWidth()-50);
            tt.setToX(anchor2.getLayoutX()-50);
            tt.play();

            mainLabel.setText("Open");
        }
    }

    public void loginButtonAction(){
        if(!username.getText().equals("") && !password.getText().equals("")){
            mainLabel.setText("Welcome");

            tt.setNode(anchor2);
            tt.setDuration(Duration.millis(1000));
            tt.setFromX(anchor2.getLayoutX()+anchor2.getWidth()-50);
            tt.setToX(anchor2.getLayoutX()-50);
            tt.play();

            RotateTransition rt=new RotateTransition();
            rt.setNode(mainLabel);
            rt.setFromAngle(0);
            rt.setToAngle(360);
            rt.setAxis(Rotate.Y_AXIS);
            rt.setInterpolator(Interpolator.LINEAR);
            rt.setDuration(Duration.millis(750));
            rt.play();

            openButton.setVisible(false);
        }
    }

    public void xButtonAction(){
        System.exit(0);
    }

    public void mButtonAction(){
        ((Stage)anchor1.getScene().getWindow()).setIconified(true);
        mButton.setFocusTraversable(false);
    }
}