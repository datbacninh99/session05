package TH2;

import java.util.Scanner; // Import thư viện Scanner từ java.util để nhận dữ liệu từ người dùng

class Book { // Khai báo một class tên là Book
    private String id; // Biến private id để lưu trữ mã sách
    private String title; // Biến private title để lưu trữ tiêu đề sách
    private String author; // Biến private author để lưu trữ tên tác giả
    private int year; // Biến private year để lưu trữ năm xuất bản
    private String description; // Biến private description để lưu trữ mô tả sách
    private Category category; // Biến private category để lưu trữ thể loại sách

    public Book() {
        // Constructor không tham số
    }

    public Book(String id, String title, String author, int year, String description, Category category) { // Constructor với 6 tham số
        this.id = id; // Gán giá trị cho id
        this.title = title; // Gán giá trị cho title
        this.author = author; // Gán giá trị cho author
        this.year = year; // Gán giá trị cho year
        this.description = description; // Gán giá trị cho description
        this.category = category; // Gán giá trị cho category
    }

    public String getId() { // Getter cho id
        return id; // Trả về giá trị của id
    }

    public void setId(String id) { // Setter cho id
        this.id = id; // Gán giá trị mới cho id
    }

    public String getTitle() { // Getter cho title
        return title; // Trả về giá trị của title
    }

    public void setTitle(String title) { // Setter cho title
        this.title = title; // Gán giá trị mới cho title
    }

    public String getAuthor() { // Getter cho author
        return author; // Trả về giá trị của author
    }

    public void setAuthor(String author) { // Setter cho author
        this.author = author; // Gán giá trị mới cho author
    }

    public int getYear() { // Getter cho year
        return year; // Trả về giá trị của year
    }

    public void setYear(int year) { // Setter cho year
        this.year = year; // Gán giá trị mới cho year
    }

    public String getDescription() { // Getter cho description
        return description; // Trả về giá trị của description
    }

    public void setDescription(String description) { // Setter cho description
        this.description = description; // Gán giá trị mới cho description
    }

    public Category getCategory() { // Getter cho category
        return category; // Trả về giá trị của category
    }

    public void setCategory(Category category) { // Setter cho category
        this.category = category; // Gán giá trị mới cho category
    }

    public void inputData() { // Phương thức để nhập dữ liệu từ người dùng
        Scanner scanner = new Scanner(System.in); // Tạo một đối tượng Scanner
        System.out.print("Nhập mã sách: "); // In ra thông báo
        this.id = scanner.nextLine(); // Nhận giá trị từ người dùng và gán cho id
        System.out.print("Nhập tiêu đề sách: "); // In ra thông báo
        this.title = scanner.nextLine(); // Nhận giá trị từ người dùng và gán cho title
        System.out.print("Nhập tên tác giả: "); // In ra thông báo
        this.author = scanner.nextLine(); // Nhận giá trị từ người dùng và gán cho author
        System.out.print("Nhập năm xuất bản: "); // In ra thông báo
        this.year = scanner.nextInt(); // Nhận giá trị từ người dùng và gán cho year
        scanner.nextLine(); // Clear the buffer
        System.out.print("Nhập mô tả sách: "); // In ra thông báo
        this.description = scanner.nextLine(); // Nhận giá trị từ người dùng và gán cho description
        System.out.print("Nhập mã thể loại sách: "); // In ra thông báo
        int categoryId = scanner.nextInt(); // Nhận giá trị từ người dùng và gán cho categoryId
        this.category = new Category(categoryId, "", false); // Tạo một đối tượng Category mới với categoryId, tên và trạng thái là rỗng
    }

    public void displayData() { // Phương thức để hiển thị dữ liệu
        System.out.println("Mã sách: " + id); // In ra mã sách
        System.out.println("Tiêu đề sách: " + title); // In ra tiêu đề sách
        System.out.println("Tác giả: " + author); // In ra tên tác giả
        System.out.println("Năm xuất bản: " + year); // In ra năm xuất bản
        System.out.println("Mô tả sách: " + description); // In ra mô tả sách
        System.out.println("Thể loại sách: " + category.getName()); // In ra tên thể loại sách
    }
}