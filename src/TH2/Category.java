package TH2;

import java.util.Scanner; // Import thư viện Scanner từ java.util để nhận dữ liệu từ người dùng

class Category { // Khai báo một class tên là Category
    private int id; // Biến private id để lưu trữ mã thể loại
    private String name; // Biến private name để lưu trữ tên thể loại
    private boolean status; // Biến private status để lưu trữ trạng thái của thể loại

    public Category() {
        // Constructor không tham số
    }

    public Category(int id, String name, boolean status) { // Constructor với 3 tham số
        this.id = id; // Gán giá trị cho id
        this.name = name; // Gán giá trị cho name
        this.status = status; // Gán giá trị cho status
    }

    public int getId() { // Getter cho id
        return id; // Trả về giá trị của id
    }

    public void setId(int id) { // Setter cho id
        this.id = id; // Gán giá trị mới cho id
    }

    public String getName() { // Getter cho name
        return name; // Trả về giá trị của name
    }

    public void setName(String name) { // Setter cho name
        this.name = name; // Gán giá trị mới cho name
    }

    public boolean isStatus() { // Getter cho status
        return status; // Trả về giá trị của status
    }

    public void setStatus(boolean status) { // Setter cho status
        this.status = status; // Gán giá trị mới cho status
    }

    public void inputData() { // Phương thức để nhập dữ liệu từ người dùng
        Scanner scanner = new Scanner(System.in); // Tạo một đối tượng Scanner
        System.out.print("Nhập mã thể loại: "); // In ra thông báo
        this.id = scanner.nextInt(); // Nhận giá trị từ người dùng và gán cho id
        scanner.nextLine(); // Clear the buffer
        System.out.print("Nhập tên thể loại: "); // In ra thông báo
        this.name = scanner.nextLine(); // Nhận giá trị từ người dùng và gán cho name
        System.out.print("Nhập trạng thái (true / false): "); // In ra thông báo
        this.status = scanner.nextBoolean(); // Nhận giá trị từ người dùng và gán cho status
    }

    public void displayData() { // Phương thức để hiển thị dữ liệu
        System.out.println("Mã thể loại: " + id); // In ra mã thể loại
        System.out.println("Tên thể loại: " + name); // In ra tên thể loại
        System.out.println("Trạng thái: " + (status ? "Hoạt động" : "Không hoạt động")); // In ra trạng thái của thể loại
    }
}