package ra.presentation;

import ra.business.design.IOData;
import ra.business.entity.Mark;
import ra.business.entity.Student;
import ra.business.entity.Subject;
//import ra.business.implement.MarkImpl;
import ra.business.implement.StudentImpl;
import ra.business.implement.SubjectImpl;

import java.util.List;
import java.util.Scanner;

public class SchoolManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IOData<Student> studentIO = new StudentImpl();
        IOData<Subject> subjectIO = new SubjectImpl();
//        IOData<Mark> markIO = new MarkImpl();
        SchoolManagement schoolManagement = new SchoolManagement();
        int choice;
        do {
            System.out.println("************************SCHOOL-MANAGEMENT*************************");
            System.out.println("1. Quản lý học sinh");
            System.out.println("2. Quản lý môn học");
            System.out.println("3. Quản lý điểm thi");
            System.out.println("4. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc ký tự new line

            switch (choice) {
                case 1:
                    manageStudents(studentIO);
                    break;
                case 2:
                    manageSubjects(subjectIO);
                    break;
                case 3:
//                    manageMarks(markIO);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }  while (true);

    }

    private static void manageStudents(IOData<Student> studentIO) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {

            System.out.println("**********************STUDENT-MANAGEMENT************************");
            System.out.println("1. Thêm mới học sinh");
            System.out.println("2. Hiển thị danh sách tất cả học sinh đã lưu trữ");
            System.out.println("3. Thay đổi thông tin học sinh");
            System.out.println("4. Xóa học sinh");
            System.out.println("5. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    studentIO.inputData();
                    break;
                case 2:
                    studentIO.displayData();
                    break;
                case 3:
                    System.out.print("Nhập ID của học sinh cần cập nhật thông tin: ");
                    int studentIdToUpdate = scanner.nextInt();
                    boolean updated = studentIO.updateStudentInformation(studentIdToUpdate);
                    if (updated) {
                        System.out.println("Cập nhật thông tin học sinh thành công.");
                    } else {
                        System.out.println("Không tìm thấy học sinh có ID " + studentIdToUpdate + " để cập nhật thông tin.");
                    }
                    break;
                case 4:
                    System.out.print("Nhập ID của học sinh cần xóa: ");
                    int studentIdToDelete = scanner.nextInt();
                    boolean deleted = studentIO.findStudentById(studentIdToDelete);
                    if (deleted) {
                        System.out.println("Học sinh đã được xóa thành công.");
                    } else {
                        System.out.println("Không tìm thấy học sinh có ID " + studentIdToDelete + ".");
                    }
                    break;
                case 5:
                    System.out.println("Quay lại menu chính.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 5);
    }

    private static void manageSubjects(IOData<Subject> subjectIO) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("**********************SUBJECT-MANAGEMENT*************************");
            System.out.println("1. Thêm mới môn học");
            System.out.println("2. Hiển thị danh sách tất cả môn học đã lưu trữ");
            System.out.println("3. Thay đổi thông tin môn học");
            System.out.println("4. Xóa môn học");
            System.out.println("5. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    subjectIO.inputData();
                    break;
                case 2:
                    subjectIO.displayData();
                    break;
                case 3:
                    System.out.print("Nhập ID của môn học cần cập nhật thông tin: ");
                    String subjectIdToUpdate = scanner.next();
                    boolean updated = subjectIO.updateSubjectInformation(subjectIdToUpdate);
                    if (updated) {
                        System.out.println("Cập nhật thông tin môn học thành công.");
                    } else {
                        System.out.println("Không tìm thấy môn học có ID " + subjectIdToUpdate + " để cập nhật thông tin.");
                    }
                    break;

                case 4:
                    System.out.print("Nhập ID môn học cần xóa: ");
                    String subjectIdToDelete = scanner.next();
                    boolean deleted = subjectIO.deleteSubject(subjectIdToDelete);
                    if (deleted) {
                        System.out.println("Xóa môn học thành công.");
                    } else {
                        System.out.println("Không tìm thấy môn học có ID " + subjectIdToDelete + " để xóa.");
                    }
                    break;
                case 5:
                    System.out.println("Quay lại menu chính.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 5);
    }

    private static void updateStudentInformation(Student studentToUpdate, Scanner scanner) {
        // Hiển thị thông tin học sinh cần thay đổi
        System.out.println("Thông tin học sinh cần thay đổi:");
        System.out.println("1. Tên học sinh: " + studentToUpdate.getStudentName());
        System.out.println("2. Ngày sinh: " + studentToUpdate.getBirthDay());
        System.out.println("3. Địa chỉ: " + studentToUpdate.getAddress());
        System.out.println("4. Giới tính: " + (studentToUpdate.isGender() ? "Nam" : "Nữ"));
        System.out.println("5. Số điện thoại: " + studentToUpdate.getPhone());
        System.out.println("6. Quay lại");
        System.out.print("Nhập lựa chọn của bạn: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự new line

        switch (choice) {
            case 1:
                System.out.print("Nhập tên học sinh mới: ");
                String newName = scanner.nextLine();
                studentToUpdate.setStudentName(newName);
                System.out.println("Tên học sinh đã được cập nhật thành công.");
                break;
            case 2:
                System.out.print("Nhập ngày sinh mới (yyyy-MM-dd): ");
                String newBirthDay = scanner.nextLine();
                break;
            case 3:
                System.out.print("Nhập địa chỉ mới: ");
                String newAddress = scanner.nextLine();
                studentToUpdate.setAddress(newAddress);
                System.out.println("Địa chỉ đã được cập nhật thành công.");
                break;
            case 4:
                System.out.print("Nhập giới tính mới (true là Nam, false là Nữ): ");
                boolean newGender = scanner.nextBoolean();
                studentToUpdate.setGender(newGender);
                System.out.println("Giới tính đã được cập nhật thành công.");
                break;
            case 5:
                System.out.print("Nhập số điện thoại mới: ");
                String newPhone = scanner.nextLine();
                studentToUpdate.setPhone(newPhone);
                System.out.println("Số điện thoại đã được cập nhật thành công.");
                break;
            case 6:
                System.out.println("Quay lại menu chính.");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                break;
        }
    }

}
