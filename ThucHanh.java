import java.util.ArrayList;
import java.util.Scanner;

class Patient {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String disease;

    public Patient(int id, String name, int age, String gender, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.disease = disease;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public void display() {
        System.out.println("ID: " + id + " | Tên: " + name + " | Tuổi: " + age + " | Giới tính: " + gender + " | Bệnh lý: " + disease);
    }
}

class PatientManager {
    private ArrayList<Patient> patientList = new ArrayList<>();

    public void addPatient(Patient patient) {
        patientList.add(patient);
        System.out.println("Thêm bệnh nhân thành công");
    }

    public void removePatient(int patientId) {
        for (Patient p : patientList) {
            if (p.getId() == patientId) {
                patientList.remove(p);
                System.out.println("Xóa bệnh nhân thành công");
                return;
            }
        }
        System.out.println("Không có bệnh nhân");
    }

    public void updatePatient(int patientId, Patient updatedPatient) {
        for (int i = 0; i < patientList.size(); i++) {
            if (patientList.get(i).getId() == patientId) {
                patientList.set(i, updatedPatient);
                System.out.println("Cập nhật thành công");
                return;
            }
        }
        System.out.println("Không tìm có bệnh nhân");
    }

    public void searchPatientByName(String name) {
        boolean found = false;
        for (Patient p : patientList) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                p.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không có bệnh nhân");
        }
    }

    public void displayPatients() {
        if (patientList.isEmpty()) {
            System.out.println("Danh sách trống");
            return;
        }
        for (Patient p : patientList) {
            p.display();
        }
    }
}

public class ThucHanh {
    private static Scanner scanner = new Scanner(System.in);
    private static PatientManager manager = new PatientManager();

    public static void displayMenu() {
        System.out.println("\n===== QUẢN LÝ BỆNH NHÂN =====");
        System.out.println("1. Thêm bệnh nhân");
        System.out.println("2. Xóa bệnh nhân");
        System.out.println("3. Cập nhật bệnh nhân");
        System.out.println("4. Tìm kiếm bệnh nhân");
        System.out.println("5. Hiển thị danh sách bệnh nhân");
        System.out.println("6. Thoát");
        System.out.print("Lựa chọn của bạn: ");
    }

    public static void handleMenuSelection() {
        int choice;

        do {
            displayMenu();
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    System.out.print("Nhập ID: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.print("Nhập tên: ");
                    String name = scanner.nextLine();

                    System.out.print("Nhập tuổi: ");
                    int age = Integer.parseInt(scanner.nextLine());

                    System.out.print("Nhập giới tính: ");
                    String gender = scanner.nextLine();

                    System.out.print("Nhập bệnh lý: ");
                    String disease = scanner.nextLine();

                    Patient newPatient = new Patient(id, name, age, gender, disease);
                    manager.addPatient(newPatient);
                    break;

                case 2:
                    System.out.print("Nhập ID cần xóa: ");
                    int removeId = Integer.parseInt(scanner.nextLine());
                    manager.removePatient(removeId);
                    break;

                case 3:
                    System.out.print("Nhập ID cần cập nhật: ");
                    int updateId = Integer.parseInt(scanner.nextLine());

                    System.out.print("Nhập tên mới: ");
                    String newName = scanner.nextLine();

                    System.out.print("Nhập tuổi mới: ");
                    int newAge = Integer.parseInt(scanner.nextLine());

                    System.out.print("Nhập giới tính mới: ");
                    String newGender = scanner.nextLine();

                    System.out.print("Nhập bệnh lý mới: ");
                    String newDisease = scanner.nextLine();

                    Patient updatedPatient = new Patient(updateId, newName, newAge, newGender, newDisease);

                    manager.updatePatient(updateId, updatedPatient);
                    break;

                case 4:
                    System.out.print("Nhập tên cần tìm: ");
                    String searchName = scanner.nextLine();
                    manager.searchPatientByName(searchName);
                    break;

                case 5:
                    manager.displayPatients();
                    break;

                case 6:
                    System.out.println("Thoát chương trình");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }

        } while (choice != 6);
    }

    public static void main(String[] args) {
        handleMenuSelection();
    }
}