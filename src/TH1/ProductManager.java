package TH1; // Định nghĩa package tên là TH1

import java.util.Scanner; // Nhập class Scanner từ thư viện java.util để đọc dữ liệu từ bàn phím

public class ProductManager { // Khai báo class public tên là ProductManager
    private static Product[] products = new Product[100]; // Khai báo mảng static kiểu Product có 100 phần tử

    static { // Khởi tạo giá trị ban đầu cho mảng products
        products[0] = new Product("P001", "Sản phẩm 1", 100, 150, 50, 10, "Mô tả sản phẩm 1", true);
        products[1] = new Product("P002", "Sản phẩm 2", 120, 180, 60, 15, "Mô tả sản phẩm 2", true);
        products[2] = new Product("P003", "Sản phẩm 3", 150, 200, 50, 20, "Mô tả sản phẩm 3", false);
    }

    private static int length = 3; // Khai báo biến static kiểu int tên là length và gán giá trị ban đầu là 3

    public static void main(String[] args) { // Hàm main
        Scanner scanner = new Scanner(System.in); // Khởi tạo đối tượng scanner để đọc dữ liệu từ bàn phím
        do { // Vòng lặp do-while
            System.out.println( // Hiển thị menu
                    "1. Nhập thông tin cho n sản phẩm (n nhập từ bàn phím) \n" +
                            "2. Hiển thị thông tin các sản phẩm \n" +
                            "3. Tính lợi nhuận các sản phẩm \n" +
                            "4. Sắp xếp các sản phẩm theo lợi nhuận giảm dần \n" +
                            "5. Thống kê các sản phẩm theo khoảng giá bán \n" +
                            "6. Tìm các sản phẩm theo tên sản phẩm \n" +
                            "7. Nhập sản phẩm \n" +
                            "8. Bán sản phẩm  \n" +
                            "9. Cập nhật trạng thái sản phẩm theo mã sản phẩm\n" +
                            "10. Xóa theo mã SP\n" +
                            "0. Thoát ");
            System.out.println("Mời lựa chọn: "); // Yêu cầu người dùng nhập lựa chọn
            int choice = Integer.parseInt(scanner.nextLine()); // Đọc lựa chọn từ bàn phím
            switch (choice) { // Xử lý lựa chọn
                case 1:
                    creatProduct(); // Gọi hàm creatProduct
                    break;
                case 2:
                    showAllProduct(); // Gọi hàm showAllProduct
                    break;
                case 3:
                    calculateProfit(); // Gọi hàm calculateProfit
                    break;
                case 4:
                    selectionSortProfit(); // Gọi hàm selectionSortProfit
                    break;
                case 5:
                    exportPriceRange(); // Gọi hàm exportPriceRange
                    break;
                case 6:
                    searchProductName(); // Gọi hàm searchProductName
                    break;
                case 7:
                    inputProduct(); // Gọi hàm inputProduct
                    break;
                case 8:
                    sellProduct(); // Gọi hàm sellProduct
                    break;
                case 9:
                    updateStatusProduct(); // Gọi hàm updateStatusProduct
                    break;
                case 10:
                    deleteProduct(); // Gọi hàm deleteProduct
                    break;
            }
        } while (true); // Vòng lặp sẽ chạy mãi mãi vì điều kiện luôn là true
    }

    public static void creatProduct() { // Khai báo hàm static tên là creatProduct
        Scanner scanner = new Scanner(System.in); // Khởi tạo đối tượng scanner để đọc dữ liệu từ bàn phím
        System.out.println("Muốn nhập thêm mấy sản phẩm :"); // Yêu cầu người dùng nhập số lượng sản phẩm muốn thêm
        int n = Integer.parseInt(scanner.nextLine()); // Đọc số lượng sản phẩm từ bàn phím
        for (int i = 0; i < n; i++) { // Vòng lặp for để nhập thông tin cho từng sản phẩm
            boolean checkID = false; // Khai báo biến kiểm tra mã sản phẩm
            do { // Vòng lặp do-while để yêu cầu người dùng nhập mã sản phẩm cho đến khi mã sản phẩm hợp lệ
                System.out.println("Nhập mã sản phẩm (độ dài 4 ký tự, bắt đầu bằng 'P'): "); // Yêu cầu người dùng nhập mã sản phẩm
                String inputProductId = scanner.nextLine(); // Đọc mã sản phẩm từ bàn phím
                if (inputProductId.length() == 4 && inputProductId.charAt(0) == 'P') { // Kiểm tra mã sản phẩm có hợp lệ không
                    boolean checkNewID = false; // Khai báo biến kiểm tra mã sản phẩm mới
                    for (int j = 0; j < length; j++) { // Vòng lặp for để kiểm tra mã sản phẩm đã tồn tại chưa
                        if (products[j].getProductID().equals(inputProductId)) { // Nếu mã sản phẩm đã tồn tại
                            checkNewID = true; // Đặt biến checkNewID là true
                            break; // Thoát vòng lặp
                        }
                    }
                    if (!checkNewID) { // Nếu mã sản phẩm chưa tồn tại
                        checkID = true; // Đặt biến checkID là true
                        products[length] = new Product(); // Khởi tạo sản phẩm mới
                        products[length].inputData(scanner); // Nhập dữ liệu cho sản phẩm mới
                        products[length].setProductID(inputProductId); // Đặt mã sản phẩm cho sản phẩm mới
                        length++; // Tăng biến length lên 1
                    } else { // Nếu mã sản phẩm đã tồn tại
                        System.out.println("Mã sản phẩm đã tồn tại. Vui lòng nhập lại!"); // Thông báo lỗi
                    }
                } else { // Nếu mã sản phẩm không hợp lệ
                    System.out.println("Mã sản phẩm không hợp lệ. Vui lòng nhập lại!"); // Thông báo lỗi
                }
            } while (!checkID); // Nếu mã sản phẩm hợp lệ thì thoát vòng lặp
        }
    }

    public static void showAllProduct() {
        for (int i = 0; i < length; i++) {
            products[i].displayData(); // Hiển thị thông tin của từng sản phẩm trong mảng products
        }
    }

    public static void calculateProfit() {
        System.out.println("Lợi nhuận của các sản phẩm: ");
        for (int i = 0; i < length; i++) {
            products[i].calProfit(); // Tính lợi nhuận của từng sản phẩm trong mảng products
            System.out.println("Sản phẩm " + products[i].getProductID() + ": " + products[i].getProfit()); // Hiển thị lợi nhuận của từng sản phẩm
        }
    }

    public static void selectionSortProfit() {
        for (int i = 0; i < length; i++) {
            int maxIndex = i; // Khởi tạo chỉ số của phần tử có lợi nhuận lớn nhất
            for (int j = i + 1; j < length; j++) {
                if (products[j].getProfit() > products[i].getProfit()) { // Nếu lợi nhuận của sản phẩm j lớn hơn sản phẩm i
                    maxIndex = j; // Cập nhật chỉ số của phần tử có lợi nhuận lớn nhất
                }
            }
            Product temp = products[i]; // Hoán đổi vị trí của sản phẩm i và sản phẩm có lợi nhuận lớn nhất
            products[i] = products[maxIndex];
            products[maxIndex] = temp;
        }
        System.out.println("Đã sắp xếp sản phẩm theo profit giảm dần"); // Thông báo đã sắp xếp xong
    }

    public static void exportPriceRange() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập giá thấp nhất trong khoảng giá bán");
        float fromExportPrice = Float.parseFloat(scanner.nextLine()); // Nhập giá thấp nhất
        System.out.println("Nhập giá cao nhất trong khoảng giá bán");
        float toExportPrice = Float.parseFloat(scanner.nextLine()); // Nhập giá cao nhất
        System.out.println("Sản phẩm trong khoảng giá bán từ " + fromExportPrice + " đến " + toExportPrice + " là:");
        boolean checkExportPrice = false; // Biến kiểm tra có sản phẩm nào trong khoảng giá không
        for (int i = 0; i < length; i++) {
            if (products[i].getExportPrice() >= fromExportPrice && products[i].getImportPrice() <= toExportPrice) { // Nếu sản phẩm i có giá bán trong khoảng từ fromExportPrice đến toExportPrice
                products[i].displayData(); // Hiển thị thông tin sản phẩm
                checkExportPrice = true; // Có ít nhất một sản phẩm trong khoảng giá
            }
        }
        if (!checkExportPrice) { // Nếu không có sản phẩm nào trong khoảng giá
            System.out.println("Không có sản phẩm trong khoảng giá bán từ " + fromExportPrice + " đến " + toExportPrice); // Thông báo không có sản phẩm nào
        }
    }

    public static void searchProductName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập tên sản phầm cần tìm: ");
        String inputName = scanner.nextLine(); // Nhập tên sản phẩm cần tìm
        boolean checkName = false; // Biến kiểm tra có sản phẩm nào có tên như đã nhập không
        for (int i = 0; i < length; i++) {
            if (products[i].getProductName().equals(inputName)) { // Nếu tên sản phẩm i giống với tên đã nhập
                products[i].displayData(); // Hiển thị thông tin sản phẩm
                checkName = true; // Có ít nhất một sản phẩm có tên như đã nhập
            }
        }
        if (!checkName) { // Nếu không có sản phẩm nào có tên như đã nhập
            System.out.println("Không có sản phẩm với tên cần tìm"); // Thông báo không tìm thấy sản phẩm
        }
    }

    public static void inputProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã sản phầm: ");
        String inputProductID = scanner.nextLine(); // Nhập mã sản phẩm cần nhập
        boolean check = false; // Biến kiểm tra có sản phẩm nào có mã như đã nhập không
        for (int i = 0; i < length; i++) {
            if (products[i].getProductID().equals(inputProductID)) { // Nếu mã sản phẩm i giống với mã đã nhập
                check = true; // Có ít nhất một sản phẩm có mã như đã nhập
                System.out.println("Nhập số lượng cần thêm: ");
                int addQuantity = Integer.parseInt(scanner.nextLine()); // Nhập số lượng cần thêm
                products[i].setQuantity(products[i].getQuantity() + addQuantity); // Cập nhật số lượng sản phẩm
                System.out.println("Số lượng sản phẩm đã được cập nhật thành công"); // Thông báo đã cập nhật thành công
                break;
            }
        }
        if (!check) { // Nếu không có sản phẩm nào có mã như đã nhập
            System.out.println("Không tìm thấy sản phẩm với mã sản phẩm đã nhập"); // Thông báo không tìm thấy sản phẩm
        }
    }

    public static void sellProduct() {
        Scanner scanner = new Scanner(System.in); // Khởi tạo đối tượng scanner để đọc dữ liệu từ bàn phím
        System.out.println("Nhập tên sản phầm: "); // Yêu cầu người dùng nhập tên sản phẩm cần bán
        String inputProductName = scanner.nextLine(); // Đọc tên sản phẩm từ bàn phím
        boolean check = false; // Biến kiểm tra có sản phẩm nào có tên như đã nhập không
        for (int i = 0; i < length; i++) { // Vòng lặp for để tìm sản phẩm có tên như đã nhập
            if (products[i].getProductName().equals(inputProductName)) { // Nếu tên sản phẩm i giống với tên đã nhập
                check = true; // Có ít nhất một sản phẩm có tên như đã nhập
                if (products[i].getStatus()) { // Nếu sản phẩm đang được bán
                    System.out.println("Nhập số lượng sản phẩm cần bán: "); // Yêu cầu người dùng nhập số lượng sản phẩm cần bán
                    int soldQuantity = Integer.parseInt(scanner.nextLine()); // Đọc số lượng sản phẩm cần bán từ bàn phím
                    if (soldQuantity <= products[i].getQuantity()) { // Nếu số lượng sản phẩm cần bán không vượt quá số lượng sản phẩm hiện có
                        products[i].setQuantity(products[i].getQuantity() - soldQuantity); // Cập nhật số lượng sản phẩm sau khi bán
                        System.out.println("Sản phẩm dã bán thành công"); // Thông báo đã bán thành công
                    } else { // Nếu số lượng sản phẩm cần bán vượt quá số lượng sản phẩm hiện có
                        System.out.println("Số lượng sản phẩm bán vuot qua số lượng sản phẩm hiện có"); // Thông báo lỗi
                    }
                } else { // Nếu sản phẩm không được bán
                    System.out.println("Sản phẩm không còn bán"); // Thông báo sản phẩm không được bán
                }
            }
        }
        if (!check) { // Nếu không có sản phẩm nào có tên như đã nhập
            System.out.println("Không có tên sản phẩm "); // Thông báo không tìm thấy sản phẩm
        }
    }

    public static void updateStatusProduct() {
        boolean checkID = false; // Biến kiểm tra mã sản phẩm hợp lệ
        do { // Vòng lặp do-while để yêu cầu người dùng nhập mã sản phẩm cho đến khi mã sản phẩm hợp lệ
            Scanner scanner = new Scanner(System.in); // Khởi tạo đối tượng scanner để đọc dữ liệu từ bàn phím
            System.out.println("Nhập mã sản phẩm (độ dài 4 ký tự, bắt đầu bằng 'P'): "); // Yêu cầu người dùng nhập mã sản phẩm
            String inputProductId = scanner.nextLine(); // Đọc mã sản phẩm từ bàn phím
            if (inputProductId.length() == 4 && inputProductId.charAt(0) == 'P') { // Kiểm tra mã sản phẩm có hợp lệ không
                checkID = true; // Mã sản phẩm hợp lệ
                boolean check = false; // Biến kiểm tra có sản phẩm nào có mã như đã nhập không
                for (int i = 0; i < length; i++) { // Vòng lặp for để tìm sản phẩm có mã như đã nhập
                    if (products[i].getProductID().equals(inputProductId)) { // Nếu mã sản phẩm i giống với mã đã nhập
                        check = true; // Có ít nhất một sản phẩm có mã như đã nhập
                        if (products[i].getStatus()) { // Nếu sản phẩm đang được bán
                            products[i].setStatus(false); // Cập nhật trạng thái sản phẩm thành không được bán
                            System.out.println("Đã cập nhật trạng thái mã (" + inputProductId + ") chuyển sang : Chưa bán"); // Thông báo đã cập nhật trạng thái
                        } else { // Nếu sản phẩm không được bán
                            products[i].setStatus(true); // Cập nhật trạng thái sản phẩm thành đang được bán
                            System.out.println("Đã cập nhật trạng thái mã (" + inputProductId + ") chuyển sang : Đang bán"); // Thông báo đã cập nhật trạng thái
                        }
                        break;
                    }
                }
                if (!check) { // Nếu không có sản phẩm nào có mã như đã nhập
                    System.out.println("Mã sản phẩm không có"); // Thông báo không tìm thấy sản phẩm
                }
            } else { // Nếu mã sản phẩm không hợp lệ
                System.out.println("Mã sản phẩm không hợp lệ. Vui lòng nhập lại!"); // Thông báo lỗi
            }
        } while (!checkID); // Nếu mã sản phẩm hợp lệ thì thoát vòng lặp
    }

    public static void deleteProduct() {
        Scanner scanner = new Scanner(System.in); // Khởi tạo đối tượng scanner để đọc dữ liệu từ bàn phím
        System.out.println("Nhập mã sản phẩm cần xóa: "); // Yêu cầu người dùng nhập mã sản phẩm cần xóa
        String delProductId = scanner.nextLine(); // Đọc mã sản phẩm từ bàn phím
        boolean check = false; // Biến kiểm tra có sản phẩm nào có mã như đã nhập không
        for (int i = 0; i < length; i++) { // Vòng lặp for để tìm sản phẩm có mã như đã nhập
            if (products[i].getProductID().equals(delProductId)) { // Nếu mã sản phẩm i giống với mã đã nhập
                check = true; // Có ít nhất một sản phẩm có mã như đã nhập
                for (int j = i; j < length - 1; j++) { // Vòng lặp for để xóa sản phẩm có mã như đã nhập
                    products[j] = products[j + 1]; // Di chuyển sản phẩm j+1 lên vị trí j
                }
                length--; // Giảm biến length đi 1
                System.out.println("Đã xóa sản phẩm có mã: " + delProductId); // Thông báo đã xóa sản phẩm
                break;
            }
        }
        if (!check) { // Nếu không có sản phẩm nào có mã như đã nhập
            System.out.println("Không tìm thấy sản phẩm có mã: " + delProductId); // Thông báo không tìm thấy sản phẩm
        }
    }
}