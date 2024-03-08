package ra.business.design;

public interface IOData<E> {
    E inputData();
    void displayData();

    boolean findStudentById(int id);

    boolean updateStudentInformation(int id);

    boolean deleteSubject(String id);
    boolean updateSubjectInformation(String id);

}
