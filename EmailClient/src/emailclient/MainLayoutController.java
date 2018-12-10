/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emailclient;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeView;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author Hadi Najafi
 */
public class MainLayoutController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private WebView emailWebView;

    @FXML
    private TreeView<?> treeView;

    @FXML
    private ListView<?> emailListView;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
