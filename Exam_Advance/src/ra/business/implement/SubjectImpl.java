package ra.business.implement;

import ra.business.design.IOData;
import ra.business.entity.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubjectImpl implements IOData<Subject> {
    private List<Subject> subjectList;

    public SubjectImpl() {
        subjectList = new ArrayList<>();
    }

    @Override
    public Subject inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập thông tin môn học:");

        String subjectId;
        boolean validSubjectId = false;
        do {
            System.out.print("Mã môn học (bắt đầu bằng \"MH\" và theo sau là 3 kí tự số bất kỳ): ");
            subjectId = scanner.nextLine();
            if (subjectId.matches("^MH\\d{3}$")) {
                validSubjectId = true;
            } else {
                System.out.println("Mã môn học không hợp lệ! Vui lòng nhập lại.");
            }
        } while (!validSubjectId);

        String subjectName;
        boolean validSubjectName = false;
        do {
            System.out.print("Tên môn học: ");
            subjectName = scanner.nextLine();
            if (!subjectName.trim().isEmpty()) {
                validSubjectName = true;
            } else {
                System.out.println("Tên môn học không được để trống! Vui lòng nhập lại.");
            }
        } while (!validSubjectName);

        Subject newSubject = new Subject(subjectId, subjectName);
        // Kiểm tra xem môn học đã tồn tại hay chưa
        if (!subjectList.contains(newSubject)) {
            subjectList.add(newSubject);
            System.out.println("Thêm môn học thành công.");
        } else {
            System.out.println("Mã môn học đã tồn tại. Vui lòng nhập lại.");
        }
        return newSubject;
    }

    @Override
    public void displayData() {
        System.out.println("Danh sách môn học:");
        for (Subject subject : subjectList) {
            System.out.println("Mã môn học: " + subject.getSubjectId());
            System.out.println("Tên môn học: " + subject.getSubjectName());
            System.out.println();
        }
    }

    @Override
    public boolean findStudentById(int id) {
        // Phương thức này không cần thiết cho lớp SubjectImpl
        return false;
    }

    @Override
    public boolean updateStudentInformation(int id) {
        return false;
    }

    @Override
    public boolean deleteSubject(String id) {
        for (Subject subject : subjectList) {
            if (subject.getSubjectId().equals(id)) {
                subjectList.remove(subject);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateSubjectInformation(String id) {
        for (Subject subject : subjectList) {
            if (subject.getSubjectId().equals(id)) {
                System.out.println("Thông tin môn học cần cập nhật:");
                System.out.println("Mã môn học: " + subject.getSubjectId());
                System.out.println("Tên môn học cũ: " + subject.getSubjectName());
                Scanner scanner = new Scanner(System.in);
                System.out.print("Nhập tên môn học mới: ");
                String newSubjectName = scanner.nextLine();
                subject.setSubjectName(newSubjectName);
                return true;
            }
        }

        return false;
    }
}
