package TH2;

import java.util.Scanner; // Import thư viện Scanner từ gói java.util
import java.util.ArrayList; // Import thư viện ArrayList từ gói java.util
import java.util.Collections; // Import thư viện Collections từ gói java.util

class Library { // Khai báo lớp Library
    private ArrayList<Category> categories = new ArrayList<>(); // Khai báo danh sách categories dưới dạng ArrayList
    private ArrayList<Book> books = new ArrayList<>(); // Khai báo danh sách books dưới dạng ArrayList
    private Scanner scanner = new Scanner(System.in); // Khai báo biến scanner để đọc dữ liệu từ bàn phím

    public static void main(String[] args) { // Phương thức main
        Library library = new Library(); // Khởi tạo đối tượng thư viện
        library.run(); // Gọi phương thức run
    }

    public void run() { // Phương thức chạy chương trình
        int choice; // Khai báo biến lựa chọn
        do { // Vòng lặp do-while
            // Hiển thị menu chức năng
            System.out.println("===== QUẢN LÝ THƯ VIỆN =====");
            System.out.println("1. Quản lý Thể loại");
            System.out.println("2. Quản lý Sách");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt(); // Nhập lựa chọn từ bàn phím
            switch (choice) { // Xử lý lựa chọn
                case 1: // Nếu chọn chức năng 1
                    manageCategories(); // Gọi phương thức quản lý thể loại
                    break;
                case 2: // Nếu chọn chức năng 2
                    manageBooks(); // Gọi phương thức quản lý sách
                    break;
                case 0: // Nếu chọn chức năng 0
                    System.out.println("Kết thúc chương trình."); // Thoát chương trình
                    break;
                default: // Nếu lựa chọn không hợp lệ
                    System.out.println("Chức năng không hợp lệ, vui lòng chọn lại.");
            }
        } while (true); // Lặp vô hạn
    }

    // Phương thức quản lý thể loại
    private void manageCategories() {
        int choice; // Khai báo biến lựa chọn
        do { // Vòng lặp do-while
            // Hiển thị menu chức năng quản lý thể loại
            System.out.println("===== QUẢN LÝ THỂ LOẠI =====");
            System.out.println("1. Thêm mới thể loại");
            System.out.println("2. Hiển thị danh sách theo tên thể loại A – Z");
            System.out.println("3. Thống kê thể loại và số sách có trong mỗi thể loại");
            System.out.println("4. Cập nhật thể loại");
            System.out.println("5. Xóa thể loại");
            System.out.println("0. Quay lại");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt(); // Nhập lựa chọn từ bàn phím
            switch (choice) { // Xử lý lựa chọn
                case 1: // Nếu chọn chức năng 1
                    addCategory(); // Gọi phương thức thêm mới thể loại
                    break;
                case 2: // Nếu chọn chức năng 2
                    displayCategories(); // Gọi phương thức hiển thị danh sách thể loại
                    break;
                case 3: // Nếu chọn chức năng 3
                    // Statistical function // Chưa được triển khai
                    break;
                case 4: // Nếu chọn chức năng 4
                    // Update function // Chưa được triển khai
                    break;
                case 5: // Nếu chọn chức năng 5
                    deleteCategory(); // Gọi phương thức xóa thể loại
                    break;
                case 0: // Nếu chọn chức năng 0
                    System.out.println("Quay lại menu quản lý thư viện."); // Quay lại menu quản lý thư viện
                    break;
                default: // Nếu lựa chọn không hợp lệ
                    System.out.println("Chức năng không hợp lệ, vui lòng chọn lại.");
            }
        } while (choice != 0); // Lặp cho đến khi lựa chọn là 0
    }

    // Phương thức thêm mới thể loại
    private void addCategory() {
        Category category = new Category(); // Khởi tạo đối tượng thể loại
        category.inputData(); // Nhập thông tin cho thể loại
        // Kiểm tra nếu thể loại đã tồn tại
        for (Category cat : categories) {
            if (cat.getName().equalsIgnoreCase(category.getName())) {
                System.out.println("Thể loại đã tồn tại.");
                return;
            }
        }
        categories.add(category); // Thêm thể loại vào danh sách
        System.out.println("Thêm thể loại thành công.");
    }

    // Phương thức hiển thị danh sách thể loại
    private void displayCategories() {
        if (categories.isEmpty()) { // Kiểm tra nếu danh sách thể loại trống
            System.out.println("Danh sách thể loại trống.");
            return;
        }
        // Sắp xếp thể loại theo tên
        Collections.sort(categories, (c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        // Hiển thị thông tin của từng thể loại
        for (Category category : categories) {
            category.displayData();
            System.out.println("---------------------");
        }
    }

    // Phương thức xóa thể loại
    private void deleteCategory() {
        if (categories.isEmpty()) { // Kiểm tra nếu danh sách thể loại trống
            System.out.println("Danh sách thể loại trống.");
            return;
        }
        System.out.print("Nhập mã thể loại cần xóa: ");
        int id = scanner.nextInt(); // Nhập mã thể loại cần xóa
        boolean exists = false; // Biến kiểm tra tồn tại
        for (Category category : categories) {
            if (category.getId() == id) { // Nếu tìm thấy thể loại cần xóa
                exists = true;
                // Kiểm tra nếu có sách tham chiếu đến thể loại này
                for (Book book : books) {
                    if (book.getCategory().getId() == id) {
                        System.out.println("Thể loại đang có sách.");
                        return;
                    }
                }
                categories.remove(category); // Xóa thể loại khỏi danh sách
                System.out.println("Xóa thể loại thành công.");
                return;
            }
        }
        if (!exists) { // Nếu không tìm thấy thể loại
            System.out.println("Không tìm thấy thể loại có mã " + id);
        }
    }

    // Phương thức quản lý sách
    private void manageBooks() {
        int choice; // Khai báo biến lựa chọn
        do { // Vòng lặp do-while
            // Hiển thị menu chức năng quản lý sách
            System.out.println("===== QUẢN LÝ SÁCH =====");
            System.out.println("1. Thêm mới sách");
            System.out.println("2. Cập nhật thông tin sách");
            System.out.println("3. Xóa sách");
            System.out.println("4. Tìm kiếm sách");
            System.out.println("5. Hiển thị danh sách sách theo nhóm thể loại");
            System.out.println("0. Quay lại");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt(); // Nhập lựa chọn từ bàn phím
            switch (choice) { // Xử lý lựa chọn
                case 1: // Nếu chọn chức năng 1
                    addBook(); // Gọi phương thức thêm mới sách
                    break;
                case 2: // Nếu chọn chức năng 2
                    // Update function // Chưa được triển khai
                    break;
                case 3: // Nếu chọn chức năng 3
                    deleteBook(); // Gọi phương thức xóa sách
                    break;
                case 4: // Nếu chọn chức năng 4
                    searchBook(); // Gọi phương thức tìm kiếm sách
                    break;
                case 5: // Nếu chọn chức năng 5
                    displayBooksByCategory(); // Gọi phương thức hiển thị danh sách sách theo nhóm thể loại
                    break;
                case 0: // Nếu chọn chức năng 0
                    System.out.println("Quay lại menu quản lý thư viện."); // Quay lại menu quản lý thư viện
                    break;
                default: // Nếu lựa chọn không hợp lệ
                    System.out.println("Chức năng không hợp lệ, vui lòng chọn lại.");
            }
        } while (choice != 0); // Lặp cho đến khi lựa chọn là 0
    }

    // Phương thức thêm mới sách
    private void addBook() {
        if (categories.isEmpty()) { // Kiểm tra nếu danh sách thể loại trống
            System.out.println("Danh sách thể loại trống, vui lòng thêm thể loại trước.");
            return;
        }
        Book book = new Book(); // Khởi tạo đối tượng sách
        book.inputData(); // Nhập thông tin cho sách
        // Tìm thể loại theo mã
        Category foundCategory = null;
        do {
            System.out.print("Nhập mã thể loại sách: ");
            int categoryId = scanner.nextInt(); // Nhập mã thể loại sách
            for (Category category : categories) {
                if (category.getId() == categoryId) {
                    foundCategory = category;
                    break;
                }
            }
            if (foundCategory == null) {
                System.out.println("Không tìm thấy thể loại có mã " + categoryId);
            }
        } while (foundCategory == null);
        book.setCategory(foundCategory); // Thiết lập thể loại cho sách
        books.add(book); // Thêm sách vào danh sách
        System.out.println("Thêm sách thành công.");
    }

    // Phương thức xóa sách
    private void deleteBook() {
        if (books.isEmpty()) { // Kiểm tra nếu danh sách sách trống
            System.out.println("Danh sách sách trống.");
            return;
        }
        System.out.print("Nhập mã sách cần xóa: ");
        String id = scanner.next(); // Nhập mã sách cần xóa
        boolean exists = false; // Biến kiểm tra tồn tại
        for (Book book : books) {
            if (book.getId().equals(id)) { // Nếu tìm thấy sách cần xóa
                books.remove(book); // Xóa sách khỏi danh sách
                System.out.println("Xóa sách thành công.");
                exists = true;
                break;
            }
        }
        if (!exists) { // Nếu không tìm thấy sách
            System.out.println("Không tìm thấy sách có mã " + id);
        }
    }

    // Phương thức tìm kiếm sách
    private void searchBook() {
        if (books.isEmpty()) { // Kiểm tra nếu danh sách sách trống
            System.out.println("Danh sách sách trống.");
            return;
        }
        System.out.print("Nhập từ khóa tìm kiếm: ");
        String keyword = scanner.next(); // Nhập từ khóa tìm kiếm
        boolean found = false; // Biến kiểm tra tìm thấy
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                book.displayData(); // Hiển thị thông tin của sách
                System.out.println("---------------------");
                found = true;
            }
        }
        if (!found) { // Nếu không tìm thấy sách
            System.out.println("Không tìm thấy sách nào.");
        }
    }

    // Phương thức hiển thị danh sách sách theo nhóm thể loại
    private void displayBooksByCategory() {
        if (categories.isEmpty()) { // Kiểm tra nếu danh sách thể loại trống
            System.out.println("Danh sách thể loại trống.");
            return;
        }
        for (Category category : categories) {
            System.out.println("- Thể loại: " + category.getName()); // Hiển thị tên thể loại
            for (Book book : books) {
                if (book.getCategory().getId() == category.getId()) { // Nếu sách thuộc thể loại này
                    System.out.println("• " + book.getTitle()); // Hiển thị tên sách
                }
            }
        }
    }
}