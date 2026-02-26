import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;
public class Bai5 {
    static class Patient {
        private String id;
        private String fullName;
        private int age;
        private String diagnosis;

        public Patient(String id, String fullName, int age, String diagnosis) {
            this.id = id;
            this.fullName = fullName;
            this.age = age;
            this.diagnosis = diagnosis;
        }

        public String getId() {
            return id;
        }

        public String getFullName() {
            return fullName;
        }

        public int getAge() {
            return age;
        }

        public String getDiagnosis() {
            return diagnosis;
        }

        public void setDiagnosis(String diagnosis) {
            this.diagnosis = diagnosis;
        }

        @Override
        public String toString() {
            return "ID: " + id + " | Tên: " + fullName + " | Tuổi: " + age + " | Chẩn đoán: " + diagnosis;
        }
    }

    static ArrayList<Patient> patientList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            showMenu();
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    updateDiagnosis();
                    break;
                case 3:
                    dischargePatient();
                    break;
                case 4:
                    sortPatients();
                    break;
                case 5:
                    displayPatients();
                    break;
                case 6:
                    System.out.println("Thoát chương trình");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }

        } while (choice != 6);
    }

    public static void showMenu() {
        System.out.println("||=====================MENU=====================||");
        System.out.println("|| 1. Tiếp nhận bệnh nhân                       ||");
        System.out.println("|| 2. Cập nhật chẩn đoán                        ||");
        System.out.println("|| 3. Xuất viện                                 ||");
        System.out.println("|| 4. Sắp xếp danh sách bệnh nhân               ||");
        System.out.println("|| 5. Hiển thị danh sách bệnh nhân              ||");
        System.out.println("|| 6. Thoát                                     ||");
        System.out.println("||==============================================||");
    }

    public static void addPatient() {
        System.out.print("Nhập ID bệnh nhân: ");
        String id = scanner.nextLine();

        for (Patient p : patientList) {
            if (p.getId().equals(id)) {
                System.out.println("ID đã tồn tại");
                return;
            }
        }

        System.out.print("Nhập tên bệnh nhân: ");
        String name = scanner.nextLine();

        System.out.print("Nhập tuổi: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập chẩn đoán: ");
        String diagnosis = scanner.nextLine();

        patientList.add(new Patient(id, name, age, diagnosis));

        System.out.println("Bệnh nhân đã được thêm thành công.");
    }

    public static void updateDiagnosis() {
        System.out.print("Nhập ID bệnh nhân cần cập nhật: ");
        String id = scanner.nextLine();

        for (Patient p : patientList) {
            if (p.getId().equals(id)) {
                System.out.print("Nhập chẩn đoán mới: ");
                String newDiagnosis = scanner.nextLine();
                p.setDiagnosis(newDiagnosis);
                System.out.println("Chuẩn đoán đã được cập nhật.");
                return;
            }
        }

        System.out.println("Không có bệnh nhân.");
    }

    public static void dischargePatient() {
        System.out.print("Nhập ID bệnh nhân xuất viện: ");
        String id = scanner.nextLine();

        Iterator<Patient> iterator = patientList.iterator();

        while (iterator.hasNext()) {
            Patient p = iterator.next();
            if (p.getId().equals(id)) {
                iterator.remove();
                System.out.println("Bệnh nhân đã xuất viện.");
                return;
            }
        }

        System.out.println("Không tìm thấy bệnh nhân với ID đã cho.");
    }

    public static void sortPatients() {
        Collections.sort(patientList, new Comparator<Patient>() {
            @Override
            public int compare(Patient p1, Patient p2) {
                if (p2.getAge() != p1.getAge()) {
                    return p2.getAge() - p1.getAge();
                }

                return p1.getFullName().compareToIgnoreCase(p2.getFullName());
            }
        });

        System.out.println("Danh sách bệnh nhân đã được sắp xếp.");
    }

    public static void displayPatients() {
        if (patientList.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }

        for (Patient p : patientList) {
            System.out.println(p);
        }
    }
}