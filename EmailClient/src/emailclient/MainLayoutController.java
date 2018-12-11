/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emailclient;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableView<EmailMessageBean> tableView;

    @FXML
    private TableColumn<EmailMessageBean, String> subjectColumn;

    @FXML
    private TableColumn<EmailMessageBean, String> senderColumn;

    @FXML
    private TableColumn<EmailMessageBean, Integer> sizeColumn;

    private ObservableList<EmailMessageBean> data;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        subjectColumn.setCellValueFactory(new PropertyValueFactory<>("subject"));
        senderColumn.setCellValueFactory(new PropertyValueFactory<>("sender"));
        sizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
    }    
    
}
