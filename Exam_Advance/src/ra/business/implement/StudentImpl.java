package ra.business.implement;

import ra.business.design.IOData;
import ra.business.entity.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class StudentImpl implements IOData<Student> {
    private List<Student> studentList;
    private int nextStudentId;

    public StudentImpl() {
        studentList = new ArrayList<>();
        nextStudentId = 1;
    }
    public List<Student> getData() {
        return studentList;
    }
    @Override
    public Student inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập thông tin học sinh:");

        String studentName;
        do {
            System.out.print("Tên học sinh: ");
            studentName = scanner.nextLine();
            if (studentName.trim().isEmpty()) {
                System.out.println("Tên học sinh không được để trống. Vui lòng nhập lại.");
            }
        } while (studentName.trim().isEmpty());


        Date birthDay = null;
        boolean validBirthDay = false;
        do {
            System.out.print("Ngày sinh (yyyy-MM-dd): ");
            String birthDayStr = scanner.nextLine();
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                birthDay = dateFormat.parse(birthDayStr);
                validBirthDay = true;
            } catch (ParseException e) {
                System.out.println("Ngày sinh không hợp lệ! Vui lòng nhập lại.");
            }
        } while (!validBirthDay);


        System.out.print("Địa chỉ: ");
        String address = scanner.nextLine();

        boolean gender = false;
        boolean validGender = false;
        do {
            System.out.print("Giới tính (Nam/Nữ): ");
            String genderStr = scanner.nextLine();
            if (genderStr.equalsIgnoreCase("Nam")) {
                gender = true;
                validGender = true;
            } else if (genderStr.equalsIgnoreCase("Nữ")) {
                gender = false;
                validGender = true;
            } else {
                System.out.println("Giới tính không hợp lệ! Vui lòng nhập lại.");
            }
        } while (!validGender);

        boolean validPhone = false;
        String phone = null;
        do {
            System.out.print("Số điện thoại: ");
            phone = scanner.nextLine();
            if (phone.matches("^0[0-9]{9,10}$")) {
                validPhone = true;
            } else {
                System.out.println("Số điện thoại không hợp lệ! Vui lòng nhập lại.");
            }
        } while (!validPhone);

        Student student = new Student(nextStudentId++ ,studentName ,birthDay, address, gender, phone);
        studentList.add(student);
        return student;
    }
    @Override
    public void displayData() {
        System.out.println("Danh sách học sinh:");
        for (Student student : studentList) {
            System.out.println("ID: " + student.getStudentId());
            System.out.println("Tên: " + student.getStudentName());
            System.out.println("Ngày sinh: " + student.getBirthDay());
            System.out.println("Địa chỉ: " + student.getAddress());
            System.out.println("Giới tính: " + (student.isGender() ? "Nam" : "Nữ"));
            System.out.println("Số điện thoại: " + student.getPhone());
            System.out.println();
        }
    }

    @Override
    public boolean findStudentById(int id) {
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getStudentId() == id) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateStudentInformation(int id) {
        for (Student student : studentList) {
            if (student.getStudentId() == id) {
                System.out.println("Thông tin học sinh cần cập nhật:");
                System.out.println("1. Tên học sinh: " + student.getStudentName());
                System.out.println("2. Ngày sinh: " + student.getBirthDay());
                System.out.println("3. Địa chỉ: " + student.getAddress());
                System.out.println("4. Giới tính: " + (student.isGender() ? "Nam" : "Nữ"));
                System.out.println("5. Số điện thoại: " + student.getPhone());
                System.out.println("6. Quay lại");

                Scanner scanner = new Scanner(System.in);
                System.out.print("Nhập lựa chọn của bạn: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Nhập tên mới sinh viên: ");
                        String newStudentName = scanner.nextLine();
                        student.setStudentName(newStudentName);
                        break;
                    case 2:
                        System.out.print("Nhập Ngày sinh mới sinh viên (yyyy-MM-dd): ");
                        String newBirthDayStr = scanner.nextLine();
                        try {
                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            Date newBirthDay = dateFormat.parse(newBirthDayStr);
                            student.setBirthDay(newBirthDay);
                            System.out.println("Ngày sinh của sinh viên đã được cập nhật thành công.");
                        } catch (ParseException e) {
                            System.out.println("Định dạng ngày không hợp lệ. Vui lòng nhập lại theo định dạng yyyy-MM-dd.");
                        }
                        break;
                    case 3:
                        System.out.print("Nhập Địa chỉ mới sinh viên: ");
                        String newAddress = scanner.nextLine();
                        student.setAddress(newAddress);
                        break;
                    case 4:
                        System.out.print("Nhập Giới tính mới sinh viên (Nam/Nữ): ");
                        String newGender = scanner.nextLine();
                        student.setGender(newGender.equalsIgnoreCase("Nam"));
                        break;
                    case 5:
                        System.out.print("Nhập Số điện thoại mới sinh viên: ");
                        String newPhone = scanner.nextLine();
                        student.setPhone(newPhone);
                        break;
                    case 6:
                        System.out.println("Quay lại.");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ.");
                        break;
                }
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean deleteSubject(String id) {
        return false;
    }

    @Override
    public boolean updateSubjectInformation(String id) {
        return false;
    }

}
