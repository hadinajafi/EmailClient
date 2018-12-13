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
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private TreeView<String> treeView;
    private TreeItem<String> root = new TreeItem<>();

    @FXML
    private TableView<EmailMessageBean> tableView;

    @FXML
    private TableColumn<EmailMessageBean, String> subjectColumn;

    @FXML
    private TableColumn<EmailMessageBean, String> senderColumn;

    @FXML
    private TableColumn<EmailMessageBean, String> sizeColumn;

    private void addCategoriesTreeItems() {
        TreeItem<String> inbox = new TreeItem<>("Inbox", resolveIcon("Inbox"));
        TreeItem<String> sent = new TreeItem<>("Sent", resolveIcon("Sent"));
        TreeItem<String> spam = new TreeItem<>("Spam", resolveIcon("Spam"));
        TreeItem<String> trash = new TreeItem<>("Trash", resolveIcon("Trash"));
        root.getChildren().addAll(inbox, sent, spam, trash);
        ImageView rootAvatar = new ImageView(new Image("/icons/avatar.png"));
        rootAvatar.setFitWidth(24);
        rootAvatar.setFitHeight(24);
        root.setGraphic(rootAvatar);
        root.setExpanded(true);
    }

    //resolve icons for treeView nodes:
    private Node resolveIcon(String treeItemValue) {
        String lowercaseTreeItemValue = treeItemValue.toLowerCase();
        ImageView returnImage;
        try {
            if (lowercaseTreeItemValue.contains("inbox")) {
                returnImage = new ImageView(new Image(getClass().getResourceAsStream("/icons/inbox.png")));
                returnImage.setFitHeight(24);
                returnImage.setFitWidth(24);
            } else if (lowercaseTreeItemValue.contains("sent")) {
                returnImage = new ImageView(new Image(getClass().getResourceAsStream("/icons/chat.png")));
                returnImage.setFitWidth(24);
                returnImage.setFitHeight(24);
            } else if (lowercaseTreeItemValue.contains("spam")) {
                returnImage = new ImageView(new Image(getClass().getResourceAsStream("/icons/spam.png")));
                returnImage.setFitWidth(24);
                returnImage.setFitHeight(24);
            } else if (lowercaseTreeItemValue.contains("@")) {
                returnImage = new ImageView(new Image(getClass().getResourceAsStream("/icons/email.png")));
                returnImage.setFitWidth(24);
                returnImage.setFitHeight(24);
            } 
            else if(lowercaseTreeItemValue.contains("trash")){
                returnImage = new ImageView(new Image(getClass().getResourceAsStream("/icons/bin.png")));
                returnImage.setFitWidth(24);
                returnImage.setFitHeight(24);
            }
            else {
                returnImage = new ImageView(new Image(getClass().getResourceAsStream("/icons/folder.png")));
                returnImage.setFitWidth(24);
                returnImage.setFitHeight(24);
            }
            return returnImage;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }

    }

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

        //set root item as root in tree view:
        treeView.setRoot(root);
        root.setValue("example@gmail.com");
        addCategoriesTreeItems();
    }

}
