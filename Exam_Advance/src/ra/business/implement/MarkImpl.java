//import ra.business.design.IOData;
//import ra.business.entity.Mark;
//import ra.business.entity.Student;
//import ra.business.entity.Subject;
//
//import java.util.Scanner;
//
//public class MarkImpl implements IOData<Mark> {
//    private Mark mark;
//
//    @Override
//    public Mark inputData() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Nhập thông tin điểm số:");
//
//        System.out.print("Nhập markId: ");
//        int markId = scanner.nextInt();
//        scanner.nextLine();
//
//        System.out.print("Nhập ID học sinh: ");
//        int studentId = scanner.nextInt();
//        scanner.nextLine();
//
//        System.out.print("Tên học sinh: ");
//        String studentName = scanner.nextLine();
//        System.out.print("Ngày sinh (yyyy-MM-dd): ");
//        String birthDayStr = scanner.nextLine();
//        System.out.print("Địa chỉ: ");
//        String address = scanner.nextLine();
//        System.out.print("Giới tính (Nam/Nữ): ");
//        String genderStr = scanner.nextLine();
//        boolean gender = genderStr.equalsIgnoreCase("Nam");
//        System.out.print("Số điện thoại: ");
//        String phone = scanner.nextLine();
//
//        // Tạo đối tượng Student
//        Student student = new Student(studentId, studentName, birthDayStr, address, gender, phone);
//
//        // Nhập thông tin môn học
//        System.out.print("Nhập ID môn học: ");
//        String subjectId = scanner.next();
//
//
//        double point;
//        do {
//            System.out.print("Nhập điểm số (từ 0 đến 10): ");
//            point = scanner.nextDouble();
//            if (point < 0 || point > 10) {
//                System.out.println("Điểm số không hợp lệ! Vui lòng nhập lại.");
//            }
//        } while (point < 0 || point > 10);
//
//
//        mark = new Mark(markId, student, new Subject(subjectId, ""), point);
//
//        return mark;
//    }
//
//    @Override
//    public void displayData() {
//        System.out.println("Thông tin điểm số:");
//        System.out.println("markId: " + mark.getMarkId());
//        System.out.println("ID học sinh: " + mark.getStudent().getStudentId());
//        System.out.println("Tên học sinh: " + mark.getStudent().getStudentName());
//        System.out.println("Mã môn học: " + mark.getSubject().getSubjectId());
//        System.out.println("Điểm số: " + mark.getPoint());
//    }
//
//    @Override
//    public boolean findStudentById(int id) {
//        return false;
//    }
//}