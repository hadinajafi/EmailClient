/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emailclient;

import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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
    private TableColumn<EmailMessageBean, String> sizeColumn;

    /*
    private ObservableList<EmailMessageBean> data = FXCollections.observableArrayList(
            new EmailMessageBean("Hello Subject1", "hello@ymail.com", 450000),
            new EmailMessageBean("hello2", "hello@gmail.ir", 34),
            new EmailMessageBean("hadi", "test@yahoo.com", 3456)
    );*/
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        subjectColumn.setCellValueFactory(new PropertyValueFactory<>("subject"));
        senderColumn.setCellValueFactory(new PropertyValueFactory<>("sender"));
        sizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
        //tableView.setItems(data);
        //override the comperator method for size column:
        sizeColumn.setComparator((String o1, String o2) -> {
            Integer int1 = EmailMessageBean.formattedValues.get(o1);
            Integer int2 = EmailMessageBean.formattedValues.get(o2);
            return int1.compareTo(int2);
        });
    }    
    
}
