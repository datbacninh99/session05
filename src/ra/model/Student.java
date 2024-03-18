package ra.model; // Khai báo package tên là ra.model

import java.util.Scanner; // Import thư viện Scanner từ java.util để nhập dữ liệu từ bàn phím

public class Student { // Khai báo một class public tên là Student
    private int id; // Khai báo biến private id kiểu int
    private String name; // Khai báo biến private name kiểu String
    private int age; // Khai báo biến private age kiểu int
    private Boolean gender; // Khai báo biến private gender kiểu Boolean
    private String address; // Khai báo biến private address kiểu String
    private int phone; // Khai báo biến private phone kiểu int

    public Student() { // Constructor không tham số của class Student
    }

    public Student(int id, String name, int age, Boolean gender, String address, int phone) { // Constructor có tham số của class Student
        this.id = id; // Gán giá trị cho biến id của đối tượng
        this.name = name; // Gán giá trị cho biến name của đối tượng
        this.age = age; // Gán giá trị cho biến age của đối tượng
        this.gender = gender; // Gán giá trị cho biến gender của đối tượng
        this.address = address; // Gán giá trị cho biến address của đối tượng
        this.phone = phone; // Gán giá trị cho biến phone của đối tượng
    }

    public int getId() { // Phương thức getter cho biến id
        return id; // Trả về giá trị của biến id
    }

    public void setId(int id) { // Phương thức setter cho biến id
        this.id = id; // Gán giá trị cho biến id của đối tượng
    }

    public String getName() { // Phương thức getter cho biến name
        return name; // Trả về giá trị của biến name
    }

    public void setName(String name) { // Phương thức setter cho biến name
        this.name = name; // Gán giá trị cho biến name của đối tượng
    }

    public int getAge() { // Phương thức getter cho biến age
        return age; // Trả về giá trị của biến age
    }

    public void setAge(int age) { // Phương thức setter cho biến age
        this.age = age; // Gán giá trị cho biến age của đối tượng
    }

    public Boolean getGender() { // Phương thức getter cho biến gender
        return gender; // Trả về giá trị của biến gender
    }

    public void setGender(Boolean gender) { // Phương thức setter cho biến gender
        this.gender = gender; // Gán giá trị cho biến gender của đối tượng
    }

    public String getAddress() { // Phương thức getter cho biến address
        return address; // Trả về giá trị của biến address
    }

    public void setAddress(String address) { // Phương thức setter cho biến address
        this.address = address; // Gán giá trị cho biến address của đối tượng
    }

    public int getPhone() { // Phương thức getter cho biến phone
        return phone; // Trả về giá trị của biến phone
    }

    public void setPhone(int phone) { // Phương thức setter cho biến phone
        this.phone = phone; // Gán giá trị cho biến phone của đối tượng
    }

    public void inputData(Scanner scanner, Student[] students, int length) {
        // Phương thức này dùng để nhập dữ liệu cho đối tượng Student
        System.out.println("Nhập vào mã sinh viên: ");
        id = Integer.parseInt(scanner.nextLine()); // Nhập mã sinh viên từ bàn phím và chuyển đổi sang kiểu int
        do {
            System.out.println("Mời nhập tên: ");
            this.name = scanner.nextLine(); // Nhập tên sinh viên từ bàn phím
            if (this.name.length() == 4 && this.name.startsWith("P")) { // Kiểm tra nếu tên sinh viên có độ dài là 4 và bắt đầu bằng chữ 'P'
                boolean isExist = true;
                for (int i = 0; i < length; i++) { // Duyệt qua danh sách sinh viên
                    if (this.name.equals(students[i].getName())) { // Nếu tên sinh viên đã tồn tại trong danh sách
                        System.out.println("Tên đã tồn tại, mời nhập lại!"); // In ra thông báo
                        isExist = false; // Đặt cờ isExist = false
                    }
                }
                if (isExist) { // Nếu tên sinh viên không tồn tại trong danh sách
                    break; // Thoát khỏi vòng lặp
                }
            } else {
                System.out.println("Chuỗi phải bắt đầu bằng P hoặc phải có 4 ký tự, mời nhập lại!"); // In ra thông báo nếu tên sinh viên không hợp lệ
            }
        } while (true); // Vòng lặp sẽ chạy cho đến khi tên sinh viên hợp lệ

        System.out.println("Nhập vào tuổi của sinh viên: ");
        age = Integer.parseInt(scanner.nextLine()); // Nhập tuổi sinh viên từ bàn phím và chuyển đổi sang kiểu int
        System.out.println("Nhập vào giới tính sinh viên: ");
        gender = Boolean.parseBoolean(scanner.nextLine()); // Nhập giới tính sinh viên từ bàn phím và chuyển đổi sang kiểu Boolean
        System.out.println("Nhập vào địa chỉ sinh viên: ");
        address = scanner.nextLine(); // Nhập địa chỉ sinh viên từ bàn phím
        System.out.println("Nhập vào số điện thoại sinh viên: ");
        phone = Integer.parseInt(scanner.nextLine()); // Nhập số điện thoại sinh viên từ bàn phím và chuyển đổi sang kiểu int
    }

    public void displayData() {
        // Phương thức này dùng để hiển thị dữ liệu của đối tượng Student
        System.out.println("Student {" +
                "id ='" + id + '\'' +
                ", name = '" + name + '\'' +
                ", age = " + age +
                ", gender = '" + gender + '\'' +
                ", address = '" + address + '\'' +
                ", phone = '" + phone + '\'' +
                '}');
        // In ra thông tin của sinh viên
    }
}