package TH1;

import java.util.Scanner;

public class Product {
    private String productID;
    private String productName;
    private float importPrice;
    private float exportPrice;
    private float profit;

    private int quantity;
    private String descriptions;
    private Boolean status;

    public Product() {
    }

    public Product(String productID, String productName, float importPrice, float exportPrice, float profit, int quantity, String descriptions, Boolean status) {
        this.productID = productID;
        this.productName = productName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.status = status;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getProfit() {
        return profit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void inputData(Scanner scanner) {
//        boolean checkID = false;
//        do {
//            System.out.println("Nhập mã sản phẩm (độ dài 4 ký tự, bắt đầu bằng 'P'): ");
//            String inputProductId = scanner.nextLine();
//            if (inputProductId.length() == 4 && inputProductId.charAt(0) == 'P') {
//                checkID = true;
//                productID = inputProductId;
//            } else {
//                System.out.println("Mã sản phẩm không hợp lệ. Vui lòng nhập lại.");
//            }
//        }while (!checkID);
//        Nhập ten sản phẩm :
        boolean checkName = false;
        do {
            System.out.println("Nhập tên sản phẩm (độ dài 5-50 ký tự): ");
            String inputProductName = scanner.nextLine();
            if (inputProductName.length() >= 5 && inputProductName.length() <= 50) {
                checkName = true;
                productName = inputProductName;
            } else {
                System.out.println("Tên sản phẩm không hợp lệ. Vui lòng nhập lại.");
            }
        } while (!checkName);

        System.out.println("Nhập giá nhâp sản phẩm :");
        importPrice = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập giá xuất sản phẩm :");
        exportPrice = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhâp số lượng dản phẩm :");
        quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Mô tả sản phẩm");
        descriptions = scanner.nextLine();
        System.out.println("Trangj thái sản phẩm :");
        status = Boolean.parseBoolean(scanner.nextLine());
    }

    public void displayData() {
        System.out.println("Product{" +
                "productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", importPrice=" + importPrice +
                ", exportPrice=" + exportPrice +
                ", profit=" + profit +
                ", quantity=" + quantity +
                ", descriptions='" + descriptions + '\'' +
                ", status=" + (status ? "Đang bán" : "Không bán") +
                '}');
        System.out.println("=========================================");
    }

    public void calProfit() {
        profit = exportPrice - importPrice;
    }
}