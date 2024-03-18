package ra.model; // Khai báo package tên là 'ra.model'

import java.util.Scanner; // Import lớp Scanner từ package java.util

public class Main { // Khai báo lớp public tên là 'Main'
    private static Student[] students = new Student[100]; // Khai báo mảng static 'students' chứa 100 phần tử kiểu Student

    static { // Khối static, sẽ được thực thi khi lớp được load vào bộ nhớ
        students[0] = new Student(1, "P001", 22, true, "Hà Nội", 12345678); // Khởi tạo phần tử đầu tiên của mảng 'students'
        students[1] = new Student(2, "P002", 21, true, "Bắc Ninh", 87654321); // Khởi tạo phần tử thứ hai của mảng 'students'
        students[2] = new Student(3, "P003", 21, true, "Hưng Yên", 13579113); // Khởi tạo phần tử thứ ba của mảng 'students'
    }

    private static int length = 3; // Khai báo biến static 'length' và gán giá trị là 3

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Khởi tạo đối tượng scanner để nhận input từ người dùng
        Main.showAllStudent(); // Hiển thị tất cả sinh viên
        do {
            // Hiển thị menu cho người dùng
            System.out.println("1.\tHiển thị danh sách sinh viên\n" +
                    "2.\tThêm mới sinh viên\n" +
                    "3.\tUpdate thông tin sinh viên theo mã\n" +
                    "4.\tXoá sinh viên theo mã\n" +
                    "5.\tSắp xếp sinh viên theo mã\n" +
                    "6.\tTìm sinh viên theo tuổi\n");
            System.out.println("Mời bạn chọn: ");
            int choice = Integer.parseInt(scanner.nextLine()); // Nhận lựa chọn từ người dùng
            switch (choice) { // Xử lý lựa chọn của người dùng
                case 1:
                    showAllStudent(); // Hiển thị tất cả sinh viên
                    break;
                case 2:
                    createStudent(); // Thêm mới sinh viên
                    break;
                case 3:
                    updateStudent(); // Cập nhật thông tin sinh viên
                    break;
                case 4:
                    delete(scanner); // Xóa sinh viên
                    break;
                case 5:
                    sort(); // Sắp xếp sinh viên
                    break;
                case 6:
                    seachStudent(scanner); // Tìm sinh viên theo tuổi
                    break;
                default:
                    System.out.println("Lựa chọn không đúng, mời chọn lại"); // Thông báo khi lựa chọn không hợp lệ
            }
        } while (true); // Vòng lặp vô hạn cho đến khi người dùng thoát chương trình
    }

    public static void seachStudent(Scanner scanner) {
        System.out.println("Nhập số tuổi: "); // Yêu cầu người dùng nhập tuổi
        int age = Integer.parseInt(scanner.nextLine()); // Nhận tuổi từ người dùng
        boolean check = true; // Biến kiểm tra xem có tìm thấy sinh viên không
        for (int i = 0; i < length; i++) { // Duyệt qua danh sách sinh viên
            if (students[i].getAge() == age) { // Nếu tuổi của sinh viên bằng tuổi người dùng nhập
                System.out.println("Thông tin sinh viên"); // Hiển thị thông tin sinh viên
                students[i].displayData(); // Hiển thị dữ liệu của sinh viên
                check = false; // Đánh dấu đã tìm thấy sinh viên
            }
        }
        if (check) { // Nếu không tìm thấy sinh viên
            System.out.println("Không tìm thấy!"); // Thông báo không tìm thấy sinh viên
        }
    }

    public static void showAllStudent() {
        // Duyệt qua danh sách sinh viên và hiển thị thông tin của từng sinh viên
        for (int j = 0; j < length; j++) {
            students[j].displayData();
            System.out.println("===============================================");
        }
    }

    public static void createStudent() {
        Scanner scanner = new Scanner(System.in); // Khởi tạo đối tượng scanner để nhận input từ người dùng
        System.out.println("Mày muốn nhập mấy thằng?"); // Yêu cầu người dùng nhập số lượng sinh viên muốn thêm
        int n = Integer.parseInt(scanner.nextLine()); // Nhận số lượng sinh viên từ người dùng
        // Tạo mới và thêm n sinh viên vào danh sách
        for (int i = 0; i < n; i++) {
            Student student = new Student(); // Tạo mới đối tượng sinh viên
            student.inputData(scanner, students, length); // Nhập dữ liệu cho sinh viên
            students[length] = student; // Thêm sinh viên vào danh sách
            length++; // Tăng độ dài danh sách sinh viên
        }
    }

    public static void updateStudent() {
        Scanner scanner = new Scanner(System.in); // Khởi tạo đối tượng scanner để nhận input từ người dùng
        System.out.println("Nhập mã sinh viên muốn sửa :"); // Yêu cầu người dùng nhập mã sinh viên muốn sửa
        int id = Integer.parseInt(scanner.nextLine()); // Nhận mã sinh viên từ người dùng
        // Tìm sinh viên theo id và cập nhật thông tin
        for (int i = 0; i < length; i++) {
            if (students[i].getId() == id) { // Nếu tìm thấy sinh viên có mã tương ứng
                System.out.println("Chọn 1 để sửa tên sinh viên: "); // Hiển thị lựa chọn cho người dùng
                System.out.println("Chọn 2 để sửa tuổi sinh viên: ");
                System.out.println("Chọn 3 để sửa địa chỉ sinh viên: ");
                System.out.println("Chọn 0 để quay lại: ");
                System.out.println("Nhập lựa chọn của bạn: ");
                int choice = Integer.parseInt(scanner.nextLine()); // Nhận lựa chọn từ người dùng
                switch (choice) { // Xử lý lựa chọn của người dùng
                    case 1:
                        System.out.println("Mời nhập tên muốn sửa: "); // Yêu cầu người dùng nhập tên mới
                        String newName = scanner.nextLine(); // Nhận tên mới từ người dùng
                        students[i].setName(newName); // Cập nhật tên mới cho sinh viên
                        break;
                    case 2:
                        System.out.println("Mời nhập tuổi để sửa: "); // Yêu cầu người dùng nhập tuổi mới
                        int newAge = Integer.parseInt(scanner.nextLine()); // Nhận tuổi mới từ người dùng
                        students[i].setAge(newAge); // Cập nhật tuổi mới cho sinh viên
                        break;
                    case 3:
                        System.out.println("Mời nhập địa chỉ mới: "); // Yêu cầu người dùng nhập địa chỉ mới
                        String newAddress = scanner.nextLine(); // Nhận địa chỉ mới từ người dùng
                        students[i].setAddress(newAddress); // Cập nhật địa chỉ mới cho sinh viên
                        break;
                    default:
                        System.out.println("Cook!"); // Thông báo khi lựa chọn không hợp lệ
                        break;
                }
            }
        }
    }

    public static void delete(Scanner scanner) {
        System.out.println("Nhập mã sinh viên muốn xóa: "); // Yêu cầu người dùng nhập mã sinh viên muốn xóa
        int x = Integer.parseInt(scanner.nextLine()); // Nhận mã sinh viên từ người dùng
        boolean isExist = false; // Biến kiểm tra xem có tìm thấy sinh viên không
        // Tìm và xóa sinh viên theo id
        for (int i = 0; i < length; i++) {
            if (students[i].getId() == x) { // Nếu tìm thấy sinh viên có mã tương ứng
                students[i] = students[i + 1]; // Xóa sinh viên khỏi danh sách
                isExist = true; // Đánh dấu đã tìm thấy sinh viên
            }
        }
        if (!isExist) { // Nếu không tìm thấy sinh viên
            System.out.println("Không tồn tại mã sinh viên cần xóa!"); // Thông báo không tìm thấy sinh viên
        } else {
            length--; // Giảm độ dài danh sách sinh viên
        }
    }

    public static void sort() {
        // Sắp xếp danh sách sinh viên theo tuổi
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (students[i].getAge() > students[j].getAge()) { // Nếu tuổi của sinh viên thứ i lớn hơn tuổi của sinh viên thứ j
                    Student st = students[i]; // Hoán đổi vị trí của sinh viên thứ i và j
                    students[i] = students[j];
                    students[j] = st;
                }
            }
        }
    }
}