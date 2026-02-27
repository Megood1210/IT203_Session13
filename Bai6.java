import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Bai6 {
    public static class Medicine {
        private String drugId;
        private String drugName;
        private double unitPrice;
        private int quantity;

        public static List<Medicine> medicines = new ArrayList<>();

        public Medicine() {
        }

        public Medicine(String drugId, String drugName, double unitPrice, int quantity) {
            this.drugId = drugId;
            this.drugName = drugName;
            this.unitPrice = unitPrice;
            this.quantity = quantity;
        }

        public String getDrugId() {
            return drugId;
        }

        public String getDrugName() {
            return drugName;
        }

        public double getUnitPrice() {
            return unitPrice;
        }

        public int getQuantity() {
            return quantity;
        }

        public static Medicine findMedicine(String id) {
            for (Medicine m : medicines) {
                if (m.drugId.equalsIgnoreCase(id)){
                    return m;
                }
            }
            return null;
        }

        public void input(Scanner sc) {
            while (true) {
                System.out.print("Nhập mã thuốc: ");
                String inputId = sc.nextLine();
                if (findMedicine(inputId) == null) {
                    this.drugId = inputId;
                    break;
                }
                System.out.println("Lỗi: Mã thuốc này đã tồn tại");
            }
            System.out.print("Tên thuốc: ");
            this.drugName = sc.nextLine();
            System.out.print("Giá bán: ");
            this.unitPrice = Double.parseDouble(sc.nextLine());
            System.out.print("Số lượng: ");
            this.quantity = Integer.parseInt(sc.nextLine());
        }

        public static void printInvoice() {
            if (medicines.isEmpty()) {
                System.out.println("Đơn thuốc trống");
                return;
            }
            System.out.println("\n-------------------------- HÓA ĐƠN THUỐC --------------------------");
            System.out.printf("| %-10s | %-20s | %-10s | %-8s | %-12s |\n",
                    "Mã ID", "Tên thuốc", "Đơn giá", "S.Lượng", "Thành tiền");
            System.out.println("-------------------------------------------------------------------");
            double totalAll = 0;
            for (Medicine m : medicines) {
                double total = m.unitPrice * m.quantity;
                totalAll += total;
                System.out.printf("| %-10s | %-20s | %-10.2f | %-8d | %-12.2f |\n",
                        m.drugId, m.drugName, m.unitPrice, m.quantity, total);
            }
            System.out.println("-------------------------------------------------------------------");
            System.out.printf("TỔNG CỘNG: %.2f VNĐ\n", totalAll);
        }

        public static void findCheapest() {
            if (medicines.isEmpty()) return;
            Medicine min = medicines.get(0);
            for (Medicine m : medicines) {
                if (m.unitPrice < min.unitPrice) min = m;
            }
            System.out.println("Thuốc có giá rẻ nhất là: " + min.drugName + " (" + min.unitPrice + " VNĐ)");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("\n--- HỆ THỐNG QUẢN LÝ ĐƠN THUỐC ---");
            System.out.println("1. Thêm thuốc vào đơn");
            System.out.println("2. Điều chỉnh số lượng");
            System.out.println("3. Xoá thuốc");
            System.out.println("4. In hoá đơn");
            System.out.println("5. Tìm thuốc giá rẻ");
            System.out.println("6. Thoát");
            System.out.print("Chọn lựa chọn: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số");
                continue;
            }

            switch (choice) {
                case 1:
                    Medicine m = new Medicine();
                    m.input(sc);
                    Medicine.medicines.add(m);
                    break;
                case 2:
                    System.out.print("Nhập mã thuốc cần chỉnh: ");
                    Medicine mUpdate = Medicine.findMedicine(sc.nextLine());
                    if (mUpdate != null) {
                        System.out.print("Số lượng mới: ");
                        mUpdate.quantity = Integer.parseInt(sc.nextLine());
                        System.out.println("Đã cập nhật");
                    } else {
                        System.out.println("Không tìm thấy");
                    }
                    break;
                case 3:
                    System.out.print("Nhập mã thuốc cần xóa: ");
                    Medicine mDel = Medicine.findMedicine(sc.nextLine());
                    if (mDel != null) {
                        Medicine.medicines.remove(mDel);
                        System.out.println("Đã xóa");
                    } else System.out.println("Không tìm thấy");
                    break;
                case 4:
                    Medicine.printInvoice();
                    break;
                case 5:
                    Medicine.findCheapest();
                    break;
            }
        } while (choice != 6);
    }
}