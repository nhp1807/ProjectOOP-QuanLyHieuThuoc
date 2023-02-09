package control;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.*;
import database.database;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

public class dashboard_controller implements Initializable {

    @FXML
    private Button about_btn;

    @FXML
    private AnchorPane about_form;

    @FXML
    private Button close_btn;

    @FXML
    private AnchorPane dashboard_form;

    @FXML
    private Button email_btn;

    @FXML
    private Button facebook_btn;

    @FXML
    private Button home_btn;

    @FXML
    private AnchorPane home_form;

    @FXML
    private Label home_khach_txt;

    @FXML
    private Label home_loaithuoc_txt;

    @FXML
    private Label home_thunhap_txt;

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button minus_btn;

    @FXML
    private Button purchase_btn;

    @FXML
    private AnchorPane purchase_form;

    @FXML
    private Button signout_btn;

    @FXML
    private Button store_clear_btn;

    @FXML
    private Button statistic_btn;

    @FXML
    private AnchorPane statistic_form;

    @FXML
    private Button store_btn;

    @FXML
    private TableColumn<medicine, String> store_donGia_col;

    @FXML
    private TextField store_donGia_txt;

    @FXML
    private AnchorPane store_form;

    @FXML
    private TableColumn<medicine, String> store_hsd_col;

    @FXML
    private DatePicker store_hsd_txt;

    @FXML
    private TableColumn<medicine, String> store_loai_col;

    @FXML
    private TableColumn<medicine, String> store_maThuoc_col;

    @FXML
    private TextField store_maThuoc_txt;

    @FXML
    private TableColumn<medicine, String> store_nsx_col;

    @FXML
    private DatePicker store_nsx_txt;


    @FXML
    private TableColumn<medicine, String> store_soLuong_col;

    @FXML
    private TextField store_soLuong_txt;

    @FXML
    private Button store_sua_btn;

    @FXML
    private TableView<medicine> store_table;

    @FXML
    private TableColumn<medicine, String> store_tenThuoc_col;

    @FXML
    private TextField store_tenThuoc_txt;

    @FXML
    private Button store_them_btn;

    @FXML
    private TableColumn<medicine, String> store_thuongHieu_col;

    @FXML
    private TextField store_thuongHieu_txt;

    @FXML
    private Button store_xoa_btn;

    @FXML
    public TextField store_search_txt;

    @FXML
    private ComboBox<String> store_loai_txt;

    @FXML
    private TextField purchase_cachDungTxt;

    @FXML
    private TableColumn<?, ?> purchase_donThuoc_cachDung_col;

    @FXML
    private TableColumn<?, ?> purchase_donThuoc_donGia_col;

    @FXML
    private TableColumn<?, ?> purchase_donThuoc_maThuoc_col;

    @FXML
    private TableColumn<?, ?> purchase_donThuoc_soLuong_col;

    @FXML
    private TableView<donhang> purchase_donThuoc_table;

    @FXML
    private TableColumn<?, ?> purchase_donThuoc_tenThuoc_col;

    @FXML
    private TableColumn<medicine, String> purchase_keDon_donGia_col;

    @FXML
    private TableColumn<medicine, String> purchase_keDon_maThuoc_col;

    @FXML
    private TextField purchase_keDon_searchTxt;

    @FXML
    private TableView<medicine> purchase_keDon_table;

    @FXML
    private TableColumn<medicine, String> purchase_keDon_tenThuoc_col;

    @FXML
    private TextField purchase_khachTraTxt;

    @FXML
    private Button purchase_lamMoi_btn;

    @FXML
    private Button purchase_loaiBo_btn;

    @FXML
    private ComboBox<?> purchase_maThuocTxt;

    @FXML
    private DatePicker purchase_ngay;

    @FXML
    private Spinner<Integer> purchase_soLuongTxt;

    @FXML
    private ComboBox<?> purchase_tenThuocTxt;

    @FXML
    private Button purchase_thanhToan_btn;

    @FXML
    private Label purchase_tienThuaTxt;

    @FXML
    private Button purchase_them_btn;

    @FXML
    private Label purchase_tongTienTxt;

    @FXML
    private TableView<donhang> thongke_ChiTiet_table;

    @FXML
    private TableColumn<donhang, String> thongke_chiTiet_donGia_col;

    @FXML
    private TableColumn<donhang, String> thongke_chiTiet_idKhach_col;

    @FXML
    private TableColumn<donhang, String> thongke_chiTiet_maThuoc_col;

    @FXML
    private TableColumn<donhang, String> thongke_chiTiet_ngayMua_col;

    @FXML
    private TableColumn<donhang, String> thongke_chiTiet_soLuong_col;

    @FXML
    private TableColumn<donhang, String> thongke_chiTiet_tenThuoc_col;

    @FXML
    private TableColumn<?, ?> thongke_donHang_idDonThuoc_col;

    @FXML
    private TableColumn<?, ?> thongke_donHang_idKhach_col;

    @FXML
    private TableColumn<?, ?> thongke_donHang_ngayMua_col;

    @FXML
    private TableView<donhang_info> thongke_donHang_table;

    @FXML
    private TableColumn<?, ?> thongke_donHang_tongTien_col;

    @FXML
    private DatePicker thongke_ngayBatDau_txt;

    @FXML
    private DatePicker thongke_ngayKetThuc_txt;

    @FXML
    private Label thongke_soLuong;

    @FXML
    private Button thongke_Go;

    @FXML
    private Label thongke_doanhthu;

    private Connection connection;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet resultSet;

    /*--------------------------------------------HOME---------------------------------------------*/
    public void homeTongSoThuoc() {
        String sql = "SELECT COUNT(maThuoc) FROM medicine";

        int count = 0;

        connection = database.getConnection("jdbc:mysql://localhost:3306/database_pharmacy", "root", "");

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                count = resultSet.getInt("COUNT(maThuoc)");
            }

            home_loaithuoc_txt.setText(String.valueOf(count));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void homeTongThuNhap() {
        String sql = "SELECT SUM(tongTien) FROM donhang_info";

        double tongThuNhap = 0.0;

        connection = database.getConnection("jdbc:mysql://localhost:3306/database_pharmacy", "root", "");

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                tongThuNhap = resultSet.getInt("SUM(tongTien)");
            }

            home_thunhap_txt.setText(String.valueOf(tongThuNhap));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void homeSoLuongKhach() {
        String sql = "SELECT COUNT(idKhach) FROM donhang_info";
        int count = 0;

        connection = database.getConnection("jdbc:mysql://localhost:3306/database_pharmacy", "root", "");

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                count = resultSet.getInt("COUNT(idKhach)");
            }

            home_khach_txt.setText(String.valueOf(count));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /*--------------------------------------------STORE---------------------------------------------*/

    private String[] loaiThuocList = {"Viên", "Nước", "Bột"};

    public void storeLoaiThuocList() {
        List<String> loaiThuoc = new ArrayList<>();

        for (String cacLoaiThuoc : loaiThuocList) {
            loaiThuoc.add(cacLoaiThuoc);
        }

        ObservableList observableList = FXCollections.observableArrayList(loaiThuoc);
        store_loai_txt.setItems(observableList);
    }

    public ObservableList<medicine> storeMedicineCollectListData() {
        String sql = "SELECT * FROM medicine";
        ObservableList<medicine> listData = FXCollections.observableArrayList();
        medicine medicineData;
        connection = database.getConnection("jdbc:mysql://localhost:3306/database_pharmacy", "root", "");
        try {
            prepare = connection.prepareStatement(sql);
            resultSet = prepare.executeQuery();

            //Up casting
            while (resultSet.next()) {
                if (resultSet.getString("loai").equalsIgnoreCase("Viên")) {
                    medicineData = new thuocVien(resultSet.getString("maThuoc"),
                            resultSet.getString("tenThuoc"),
                            resultSet.getDate("nsx"),
                            resultSet.getDate("hsd"),
                            resultSet.getDouble("donGia"),
                            resultSet.getString("thuongHieu"),
                            resultSet.getInt("soLuong"));
                } else if (resultSet.getString("loai").equalsIgnoreCase("Bột")) {
                    medicineData = new thuocBot(resultSet.getString("maThuoc"),
                            resultSet.getString("tenThuoc"),
                            resultSet.getDate("nsx"),
                            resultSet.getDate("hsd"),
                            resultSet.getDouble("donGia"),
                            resultSet.getString("thuongHieu"),
                            resultSet.getInt("soLuong"));
                } else {
                    medicineData = new thuocNuoc(resultSet.getString("maThuoc"),
                            resultSet.getString("tenThuoc"),
                            resultSet.getDate("nsx"),
                            resultSet.getDate("hsd"),
                            resultSet.getDouble("donGia"),
                            resultSet.getString("thuongHieu"),
                            resultSet.getInt("soLuong"));
                }
                listData.add(medicineData);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listData;
    }

    public void storeCheck(String loaiThuoc){
        if(loaiThuoc.equalsIgnoreCase("Viên")){
            System.out.println("Thêm thuốc viên");
        }else if (loaiThuoc.equalsIgnoreCase("Bột")){
            System.out.println("Thêm thuốc bột");
        }else{
            System.out.println("Thêm thuốc nước");
        }
    }

    public void storeCheck(double donGia){
        if(donGia > 100000){
            System.out.println("Thuốc trên 100.000VND");
        }else{
            System.out.println("Thuốc dưới 100.000VNĐ");
        }
    }

    public void storeCheck(int soLuong){
        if(soLuong > 100){
            System.out.println("Số lượng lớn hơn 100");
        }else {
            System.out.println("Số lượng nhỏ hơn 100");
        }
    }

    private ObservableList<medicine> medicineList;

    public void storeMedicineShowListData() {
        medicineList = storeMedicineCollectListData();

        store_maThuoc_col.setCellValueFactory(new PropertyValueFactory<>("maThuoc"));
        store_tenThuoc_col.setCellValueFactory(new PropertyValueFactory<>("tenThuoc"));
        store_nsx_col.setCellValueFactory(new PropertyValueFactory<>("ngaySx"));
        store_hsd_col.setCellValueFactory(new PropertyValueFactory<>("hanSd"));
        store_donGia_col.setCellValueFactory(new PropertyValueFactory<>("donGia"));
        store_thuongHieu_col.setCellValueFactory(new PropertyValueFactory<>("thuongHieu"));
        store_loai_col.setCellValueFactory(new PropertyValueFactory<>("loaiThuoc"));
        store_soLuong_col.setCellValueFactory(new PropertyValueFactory<>("soLuong"));

        store_table.setItems(medicineList);
    }

    public void storeMedicineSelect() {
        medicine med = store_table.getSelectionModel().getSelectedItem();
        int num = store_table.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        store_maThuoc_txt.setText(med.getMaThuoc());
        store_tenThuoc_txt.setText(med.getTenThuoc());
        store_nsx_txt.setValue(LocalDate.parse(String.valueOf(med.getNgaySx())));
        store_hsd_txt.setValue(LocalDate.parse(String.valueOf(med.getHanSd())));
        store_donGia_txt.setText(String.valueOf(med.getDonGia()));
        store_thuongHieu_txt.setText(med.getThuongHieu());
        store_soLuong_txt.setText(String.valueOf(med.getSoLuong()));
    }

    public void storeMedicineAdd() {
        String themThuoc = "INSERT INTO medicine (`maThuoc`, `tenThuoc`, `nsx`, `hsd`, `donGia`, `thuongHieu`, `loai`, `soLuong`) " +
                "VALUES (?,?,?,?,?,?,?,?)";
        connection = database.getConnection("jdbc:mysql://localhost:3306/database_pharmacy", "root", "");

        try {
            Alert alert;
            if (store_maThuoc_txt.getText().isEmpty()
                    || store_tenThuoc_txt.getText().isEmpty()
                    || store_nsx_txt.getValue() == null
                    || store_hsd_txt.getValue() == null
                    || store_donGia_txt.getText().isEmpty()
                    || store_thuongHieu_txt.getText().isEmpty()
                    || store_loai_txt.getSelectionModel().getSelectedItem() == null
                    || store_soLuong_txt.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR MESSAGE");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                //Check if ma thuoc is already exist
                String checkMaThuoc = "SELECT maThuoc FROM medicine WHERE maThuoc = '" + store_maThuoc_txt.getText() + "'";

                statement = connection.createStatement();
                resultSet = statement.executeQuery(checkMaThuoc);

                if (resultSet.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Mã thuốc" + store_maThuoc_txt.getText() + " was already exist!");
                    alert.showAndWait();
                } else {
                    prepare = connection.prepareStatement(themThuoc);
                    prepare.setString(1, store_maThuoc_txt.getText());
                    prepare.setString(2, store_tenThuoc_txt.getText());
                    prepare.setString(3, String.valueOf(store_nsx_txt.getValue()));
                    prepare.setString(4, String.valueOf(store_hsd_txt.getValue()));
                    prepare.setString(5, store_donGia_txt.getText());
                    prepare.setString(6, store_thuongHieu_txt.getText());
                    prepare.setString(7, (String) store_loai_txt.getSelectionModel().getSelectedItem());
                    prepare.setString(8, store_soLuong_txt.getText());

                    prepare.executeUpdate();

                    storeCheck(store_loai_txt.getSelectionModel().toString());
                    storeCheck(Double.parseDouble(store_donGia_txt.getText()));
                    storeCheck(Integer.parseInt(store_soLuong_txt.getText()));

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();

                    storeMedicineShowListData();
                    storeMedicineSearch();
                    storeMedicineClear();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void storeMedicineUpdate() {
        String updateData = "UPDATE medicine SET "
                + "tenThuoc = '" + store_tenThuoc_txt.getText()
                + "', nsx = '" + store_nsx_txt.getValue()
                + "', hsd = '" + store_hsd_txt.getValue()
                + "', donGia = '" + store_donGia_txt.getText()
                + "', thuongHieu = '" + store_thuongHieu_txt.getText()
                + "', loai = '" + store_loai_txt.getSelectionModel().getSelectedItem()
                + "', soLuong = '" + store_soLuong_txt.getText()
                + "' WHERE maThuoc = '"
                + store_maThuoc_txt.getText() + "'";

        connection = database.getConnection("jdbc:mysql://localhost:3306/database_pharmacy", "root", "");

        try {
            Alert alert;
            if (store_maThuoc_txt.getText().isEmpty()
                    || store_tenThuoc_txt.getText().isEmpty()
                    || store_nsx_txt.getValue() == null
                    || store_hsd_txt.getValue() == null
                    || store_donGia_txt.getText().isEmpty()
                    || store_thuongHieu_txt.getText().isEmpty()
                    || store_loai_txt.getSelectionModel().getSelectedItem() == null
                    || store_soLuong_txt.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR MESSAGE");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE Medicine #" +
                        store_maThuoc_txt.getText() + "?");

                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connection.createStatement();
                    statement.executeUpdate(updateData);

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    storeMedicineShowListData();
                    storeMedicineSearch();
                    storeMedicineClear();
                } else {
                    return;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void storeMedicineDelete() {
        String deleteData = "DELETE FROM medicine WHERE maThuoc = '"
                + store_maThuoc_txt.getText() + "'";
        connection = database.getConnection("jdbc:mysql://localhost:3306/database_pharmacy", "root", "");

        try {
            Alert alert;
            if (store_maThuoc_txt.getText().isEmpty()
                    || store_tenThuoc_txt.getText().isEmpty()
                    || store_nsx_txt.getValue() == null
                    || store_hsd_txt.getValue() == null
                    || store_donGia_txt.getText().isEmpty()
                    || store_thuongHieu_txt.getText().isEmpty()
//                    || store_loai_txt.getSelectionModel().getSelectedItem() == null
                    || store_soLuong_txt.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR MESSAGE");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE Medicine #" +
                        store_maThuoc_txt.getText() + "?");

                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connection.createStatement();
                    statement.executeUpdate(deleteData);

                    String checkData = "SELECT maThuoc FROM medicine "
                            + "WHERE maThuoc = '" + store_maThuoc_txt.getText() + "'";
                    prepare = connection.prepareStatement(checkData);
                    resultSet = prepare.executeQuery();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    storeMedicineShowListData();
                    storeMedicineClear();
                } else {
                    return;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void storeMedicineSearch() {
        FilteredList<medicine> filter = new FilteredList<>(medicineList, e -> true);
        store_search_txt.textProperty().addListener((observableValue, oldValue, newValue) -> {
            filter.setPredicate( predicateMedicine -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateMedicine.getMaThuoc().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateMedicine.getTenThuoc().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateMedicine.getNgaySx().toString().contains(searchKey)) {
                    return true;
                } else if (predicateMedicine.getHanSd().toString().contains(searchKey)) {
                    return true;
                } else if (predicateMedicine.getThuongHieu().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateMedicine.getLoaiThuoc().toLowerCase().contains(searchKey)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<medicine> sortedList = new SortedList<>(filter);
        sortedList.comparatorProperty().bind(store_table.comparatorProperty());
        store_table.setItems(sortedList);
    }

    public void storeMedicineClear() {
        store_maThuoc_txt.setText("");
        store_tenThuoc_txt.setText("");
        store_nsx_txt.setValue(null);
        store_hsd_txt.setValue(null);
        store_donGia_txt.setText("");
        store_thuongHieu_txt.setText("");
        store_loai_txt.getSelectionModel().clearSelection();
        store_soLuong_txt.setText("");
    }
    /*--------------------------------------PURCHASE---------------------------------------------*/
    public void hienThiDanhSachKeDon() {
        medicineList = storeMedicineCollectListData();

        purchase_keDon_maThuoc_col.setCellValueFactory(new PropertyValueFactory<>("maThuoc"));
        purchase_keDon_tenThuoc_col.setCellValueFactory(new PropertyValueFactory<>("tenThuoc"));
        purchase_keDon_donGia_col.setCellValueFactory(new PropertyValueFactory<>("donGia"));

        purchase_keDon_table.setItems(medicineList);
    }

    public void purchaseKeDonSearch() {
        FilteredList<medicine> filter = new FilteredList<>(medicineList, e -> true);
        purchase_keDon_searchTxt.textProperty().addListener((observableValue, oldValue, newValue) -> {
            filter.setPredicate((Predicate<? super medicine>) predicateMedicine -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateMedicine.getMaThuoc().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateMedicine.getTenThuoc().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (((Double) predicateMedicine.getDonGia()).toString().contains(searchKey)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<medicine> sortedList = new SortedList<>(filter);
        sortedList.comparatorProperty().bind(purchase_keDon_table.comparatorProperty());
        purchase_keDon_table.setItems(sortedList);
    }

    public void purchaseMaThuocList() {
        String sql = "SELECT maThuoc FROM medicine";
        connection = database.getConnection("jdbc:mysql://localhost:3306/database_pharmacy", "root", "");

        try {
            prepare = connection.prepareStatement(sql);
            resultSet = prepare.executeQuery();

            ObservableList danhSachMaThuoc = FXCollections.observableArrayList();

            while (resultSet.next()) {
                danhSachMaThuoc.add(resultSet.getString("maThuoc"));
            }

            purchase_maThuocTxt.setItems(danhSachMaThuoc);

            purchaseTenThuocList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void purchaseTenThuocList() {
        String sql = "SELECT tenThuoc FROM medicine WHERE maThuoc = '"
                + purchase_maThuocTxt.getSelectionModel().getSelectedItem() + "'";

        connection = database.getConnection("jdbc:mysql://localhost:3306/database_pharmacy", "root", "");
        try {
            prepare = connection.prepareStatement(sql);
            resultSet = prepare.executeQuery();

            ObservableList danhSachTenThuoc = FXCollections.observableArrayList();

            while (resultSet.next()) {
                danhSachTenThuoc.add(resultSet.getString("tenThuoc"));
            }

            purchase_tenThuocTxt.setItems(danhSachTenThuoc);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private SpinnerValueFactory<Integer> spinner;

    public void purchaseSpinner() {
        // min = 0, max = 50, init = 0
        spinner = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50, 0);

        purchase_soLuongTxt.setValueFactory(spinner);
    }

    private int soLuong;

    public void purchaseSoluong() {
        soLuong = purchase_soLuongTxt.getValue();
    }

    public void purchaseThem() {
        purchaseIdKhach();
        purchaseTotalPrice();

        String sql = "INSERT INTO `donhang`" +
                "(`idKhach`, `maThuoc`, `tenThuoc`, `donGia`, `soLuong`, `cachDung`, `ngayThanhToan`) " +
                "VALUES (?,?,?,?,?,?,?)";
        connection = database.getConnection("jdbc:mysql://localhost:3306/database_pharmacy", "root", "");

        try {
            double purchasePrice = 0;

            String checkMaThuoc = "SELECT * FROM medicine WHERE maThuoc = '"
                    + purchase_maThuocTxt.getSelectionModel().getSelectedItem() + "'";

            statement = connection.createStatement();
            resultSet = statement.executeQuery(checkMaThuoc);


            if (resultSet.next()) {
                purchasePrice = resultSet.getDouble("donGia");
            }

            prepare = connection.prepareStatement(sql);
            prepare.setString(1, String.valueOf(idKhach));
            prepare.setString(2, (String) purchase_maThuocTxt.getSelectionModel().getSelectedItem());
            prepare.setString(3, (String) purchase_tenThuocTxt.getSelectionModel().getSelectedItem());
            double totalPrice = purchasePrice * soLuong;
            prepare.setString(4, String.valueOf(totalPrice));
            prepare.setString(5, String.valueOf(soLuong));
            prepare.setString(6, purchase_cachDungTxt.getText());
            //Date hiện tại
            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            prepare.setString(7, String.valueOf(sqlDate));

            prepare.executeUpdate();

            purchaseHienThiTotalPrice();
            purchaseHienThiDanhSachSp();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void purchaseThanhToan() {
        purchaseIdKhach();
        purchaseTotalPrice();

        String sql = "INSERT INTO `donhang_info`(`idKhach`, `tongTien`, `ngayThanhToan`) VALUES (?,?,?)";
        connection = database.getConnection("jdbc:mysql://localhost:3306/database_pharmacy", "root", "");

        try {
            Alert alert;

            if (totalPrice == 0 || String.valueOf(totalPrice) == "0.0 VND" || String.valueOf(totalPrice) == null) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("You haven't made any purchase!");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    prepare = connection.prepareStatement(sql);
                    prepare.setString(1, String.valueOf(idKhach));
                    prepare.setString(2, String.valueOf(totalPrice));

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepare.setString(3, String.valueOf(sqlDate));

                    prepare.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successful!");
                    alert.showAndWait();

                    purchase_tongTienTxt.setText("0.0VND");
                    purchase_donThuoc_table.getItems().clear();
                } else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Cancelled!");
                    alert.showAndWait();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private double totalPrice = 0;
    public void purchaseTotalPrice() {
        purchaseIdKhach();

        String sql = "SELECT SUM(donGia) FROM donhang WHERE idKhach =" + idKhach;

        connection = database.getConnection("jdbc:mysql://localhost:3306/database_pharmacy", "root", "");

        try {
            prepare = connection.prepareStatement(sql);
            resultSet = prepare.executeQuery();

            if (resultSet.next()) {
                totalPrice = resultSet.getDouble("SUM(donGia)");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void purchaseHienThiTotalPrice() {
        purchaseTotalPrice();
        purchase_tongTienTxt.setText(String.valueOf(totalPrice) + "VND");
    }


    public void purchaseRemove() {
        String sql = "DELETE FROM donhang WHERE idDonThuoc = " + item;
        connection = database.getConnection("jdbc:mysql://localhost:3306/database_pharmacy", "root", "");

        try {
            Alert alert;
            if (item == 0 || String.valueOf(item) == null || String.valueOf(item) == "") {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please select the item first");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to Remove Item: " + item + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connection.createStatement();
                    statement.executeUpdate(sql);

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Removed!");
                    alert.showAndWait();

                    purchaseHienThiDanhSachSp();
                    purchaseHienThiTotalPrice();
                } else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Cancelled!");
                    alert.showAndWait();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private int item;

    public void purchaseSelect() {

        donhang sanPham = purchase_donThuoc_table.getSelectionModel().getSelectedItem();
        int num = purchase_donThuoc_table.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        item = sanPham.getIdDonThuoc();
    }

    public ObservableList<donhang> purchaseDsSanPham() {
        purchaseIdKhach();

        ObservableList<donhang> dsSanPham = FXCollections.observableArrayList();
        String sql = "SELECT * FROM donhang WHERE idKhach = " + idKhach;

        connection = database.getConnection("jdbc:mysql://localhost:3306/database_pharmacy", "root", "");
        try {
            prepare = connection.prepareStatement(sql);
            resultSet = prepare.executeQuery();

            donhang sanPham;

            while (resultSet.next()) {
                sanPham = new donhang(resultSet.getInt("idDonThuoc"),
                        resultSet.getString("maThuoc"),
                        resultSet.getString("tenThuoc"),
                        resultSet.getDouble("donGia"),
                        resultSet.getInt("soLuong"),
                        resultSet.getString("cachDung"));

                dsSanPham.add(sanPham);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dsSanPham;
    }

    private ObservableList<donhang> purchaseDanhSachSanPham;

    public void purchaseHienThiDanhSachSp() {
        purchaseDanhSachSanPham = purchaseDsSanPham();

        purchase_donThuoc_maThuoc_col.setCellValueFactory(new PropertyValueFactory<>("maThuoc"));
        purchase_donThuoc_tenThuoc_col.setCellValueFactory(new PropertyValueFactory<>("tenThuoc"));
        purchase_donThuoc_donGia_col.setCellValueFactory(new PropertyValueFactory<>("donGia"));
        purchase_donThuoc_soLuong_col.setCellValueFactory(new PropertyValueFactory<>("soLuong"));
        purchase_donThuoc_cachDung_col.setCellValueFactory(new PropertyValueFactory<>("cachDung"));

        purchase_donThuoc_table.setItems(purchaseDanhSachSanPham);
    }

    private int idKhach;

    public void purchaseIdKhach() {
        // Get idKhach from donhang: bảng đang kê thuốc
        String sql = "SELECT idKhach FROM donhang";

        connection = database.getConnection("jdbc:mysql://localhost:3306/database_pharmacy", "root", "");

        try {
            prepare = connection.prepareStatement(sql);
            resultSet = prepare.executeQuery();

            while (resultSet.next()) {
                idKhach = resultSet.getInt("idKhach");

            }

            // Lấy idKhach trong bảng đã được thanh toán
            String checkId = "SELECT idKhach FROM donhang_info";

            statement = connection.createStatement();
            resultSet = statement.executeQuery(checkId);

            int idKhachInfo = 0;

            while (resultSet.next()) {
                idKhachInfo = resultSet.getInt("idKhach");
            }

            if (idKhach == 0) {
                idKhach += 1;
            } else if (idKhach == idKhachInfo) {
                idKhach += 1;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    // Date Now  ### "To Date Picker"
    public static final LocalDate NOW_LOCAL_DATE() {
        String date = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);
        return localDate;
    }

    public void hienThiNgay() {
        purchase_ngay.setValue(NOW_LOCAL_DATE());
    }

    /*-----------------------------------THONG KE-----------------------------*/
    private ObservableList<donhang> chiTietDonHang;

    public ObservableList<donhang> layChiTietDonHang() {
        String sql = "SELECT idKhach, maThuoc, tenThuoc, donGia, soLuong, ngayThanhToan FROM donhang";

        ObservableList<donhang> dsChiTiet = FXCollections.observableArrayList();
        connection = database.getConnection("jdbc:mysql://localhost:3306/database_pharmacy", "root", "");

        try {
            prepare = connection.prepareStatement(sql);
            resultSet = prepare.executeQuery();

            donhang sanPhamData;

            while (resultSet.next()) {
                sanPhamData = new donhang(resultSet.getInt("idKhach"),
                        resultSet.getString("maThuoc"),
                        resultSet.getString("tenThuoc"),
                        resultSet.getDouble("donGia"),
                        resultSet.getInt("soLuong"),
                        resultSet.getDate("ngayThanhToan"));

                dsChiTiet.add(sanPhamData);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dsChiTiet;
    }

    public void hienThiChiTietDonHang() {
        chiTietDonHang = layChiTietDonHang();

        thongke_chiTiet_idKhach_col.setCellValueFactory(new PropertyValueFactory<>("idKhach"));
        thongke_chiTiet_maThuoc_col.setCellValueFactory(new PropertyValueFactory<>("maThuoc"));
        thongke_chiTiet_tenThuoc_col.setCellValueFactory(new PropertyValueFactory<>("tenThuoc"));
        thongke_chiTiet_donGia_col.setCellValueFactory(new PropertyValueFactory<>("donGia"));
        thongke_chiTiet_soLuong_col.setCellValueFactory(new PropertyValueFactory<>("soLuong"));
        thongke_chiTiet_ngayMua_col.setCellValueFactory(new PropertyValueFactory<>("ngayThanhToan"));

        thongke_ChiTiet_table.setItems(chiTietDonHang);
    }

    ObservableList<donhang_info> danhSachDonHang;

    public ObservableList<donhang_info> layDanhSachDonHang() {
        String sql = "SELECT * FROM donhang_info";
        ObservableList<donhang_info> dsDonHang = FXCollections.observableArrayList();

        connection = database.getConnection("jdbc:mysql://localhost:3306/database_pharmacy", "root", "");

        try {
            prepare = connection.prepareStatement(sql);
            resultSet = prepare.executeQuery();

            donhang_info donhangInfo;

            while (resultSet.next()) {
                donhangInfo = new donhang_info(resultSet.getInt("idDonThuoc"),
                        resultSet.getInt("idKhach"),
                        resultSet.getDouble("tongTien"),
                        resultSet.getDate("ngayThanhToan"));
                dsDonHang.add(donhangInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dsDonHang;
    }

    public void hienThiDanhSachDonHang() {
        danhSachDonHang = layDanhSachDonHang();

        thongke_donHang_idDonThuoc_col.setCellValueFactory(new PropertyValueFactory<>("idDonThuoc"));
        thongke_donHang_idKhach_col.setCellValueFactory(new PropertyValueFactory<>("idKhach"));
        thongke_donHang_tongTien_col.setCellValueFactory(new PropertyValueFactory<>("tongTien"));
        thongke_donHang_ngayMua_col.setCellValueFactory(new PropertyValueFactory<>("ngayThanhToan"));

        thongke_donHang_table.setItems(danhSachDonHang);
    }

    public void hienThiTongSoLuongThuocDaBan() {
        String sql = "SELECT SUM(soLuong), SUM(donGia) FROM donhang WHERE ngayThanhToan BETWEEN '" + thongke_ngayBatDau_txt.getValue().toString()
                + "' AND '" + thongke_ngayKetThuc_txt.getValue().toString() + "'";

        connection = database.getConnection("jdbc:mysql://localhost:3306/database_pharmacy", "root", "");

        int count = 0;
        double doanhThu = 0.0;

        try {
            prepare = connection.prepareStatement(sql);
            resultSet = prepare.executeQuery();

            if (resultSet.next()) {
                count = resultSet.getInt("SUM(soLuong)");
                doanhThu = resultSet.getDouble("SUM(donGia)");
            }

            thongke_soLuong.setText(String.valueOf(count));
            thongke_doanhthu.setText(String.valueOf(doanhThu));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /*--------------------------------------------OTHER---------------------------------------------*/
    public void facebookBrowser() throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.facebook.com/SoictOfficially"));
    }

    public void emailBrowser() throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://soict.hust.edu.vn/"));
    }

    /*--------------------------------------------SwitchForm---------------------------------------------*/
    @FXML
    void switchForm(ActionEvent event) {
        if (event.getSource() == home_btn) {
            home_form.setVisible(true);
            store_form.setVisible(false);
            purchase_form.setVisible(false);
            statistic_form.setVisible(false);
            about_form.setVisible(false);

            homeTongSoThuoc();
            homeTongThuNhap();
            homeSoLuongKhach();
        } else if (event.getSource() == store_btn) {
            home_form.setVisible(false);
            store_form.setVisible(true);
            purchase_form.setVisible(false);
            statistic_form.setVisible(false);
            about_form.setVisible(false);

            storeMedicineShowListData();
            storeLoaiThuocList();
            storeMedicineSearch();
        } else if (event.getSource() == purchase_btn) {
            home_form.setVisible(false);
            store_form.setVisible(false);
            purchase_form.setVisible(true);
            statistic_form.setVisible(false);
            about_form.setVisible(false);

            //Khu vuc ke don
            hienThiDanhSachKeDon();
            purchaseKeDonSearch();
            purchaseTenThuocList();
            purchaseMaThuocList();
            purchaseSpinner();

            purchaseHienThiDanhSachSp();
            purchaseHienThiTotalPrice();
            hienThiNgay();

        } else if (event.getSource() == statistic_btn) {
            home_form.setVisible(false);
            store_form.setVisible(false);
            purchase_form.setVisible(false);
            statistic_form.setVisible(true);
            about_form.setVisible(false);

            hienThiChiTietDonHang();
            hienThiDanhSachDonHang();

        } else if (event.getSource() == about_btn) {
            home_form.setVisible(false);
            store_form.setVisible(false);
            purchase_form.setVisible(false);
            statistic_form.setVisible(false);
            about_form.setVisible(true);
        }
    }

    private double y = 0;
    private double x = 0;

    @FXML
    void signout() {
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to sign out?");

            Optional<ButtonType> option = alert.showAndWait();
            if (option.get().equals(ButtonType.OK)) {
                signout_btn.getScene().getWindow().hide();

                //Go to login form
                Parent root = FXMLLoader.load(getClass().getResource("/view/login.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                scene.setFill(Color.TRANSPARENT);
                root.setOnMousePressed((MouseEvent event) -> {
                    x = event.getSceneX();
                    y = event.getSceneY();
                });

                root.setOnMouseDragged((MouseEvent event) -> {
                    stage.setX(event.getScreenX() - x);
                    stage.setY(event.getScreenY() - y);

                    stage.setOpacity(.8);
                });

                root.setOnMouseReleased((MouseEvent event) -> {
                    stage.setOpacity(1);
                });

                stage.initStyle(StageStyle.TRANSPARENT);

                stage.setScene(scene);
                stage.show();
            } else {
                return;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    @FXML
    void close_form(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void minus_form(ActionEvent event) {
        Stage stage = (Stage) dashboard_form.getScene().getWindow();
        stage.setIconified(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Show immidiately when process dashboard

        storeMedicineShowListData();
        storeLoaiThuocList();
        storeMedicineSearch();

        //Khu vuc ke don
        hienThiDanhSachKeDon();
        purchaseKeDonSearch();
        purchaseTenThuocList();
        purchaseMaThuocList();
        purchaseSpinner();

        purchaseHienThiDanhSachSp();
        purchaseHienThiTotalPrice();
        hienThiNgay();

        //Home
        homeTongSoThuoc();
        homeTongThuNhap();
        homeSoLuongKhach();

        //Thong ke
        hienThiChiTietDonHang();
        hienThiDanhSachDonHang();
    }
}
