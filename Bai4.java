import java.util.LinkedList;

public class Bai4 {
    static class EmergencyRoom {
        private LinkedList<String> waitingList = new LinkedList<>();

        public void patientCheckIn(String name) {
            waitingList.addLast(name);
        }

        public void emergencyCheckIn(String name) {
            waitingList.addFirst(name);
        }

        public void treatPatient() {
            if (waitingList.isEmpty()) {
                System.out.println("Không còn bệnh nhân nào");
                return;
            }

            String patient = waitingList.removeFirst();

            if (patient.equals("C")) {
                System.out.println("Đang cấp cứu: " + patient);
            } else {
                System.out.println("Đang khám: " + patient);
            }
        }
    }

    public static void main(String[] args) {
        EmergencyRoom er = new EmergencyRoom();

        er.patientCheckIn("A");
        er.patientCheckIn("B");
        er.emergencyCheckIn("C");

        er.treatPatient();
        er.treatPatient();
        er.treatPatient();
    }
}