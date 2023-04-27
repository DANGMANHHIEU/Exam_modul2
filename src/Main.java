import view.Client;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\u001B[32m" + """
                    1.Xem danh sách sinh viên.
                    2.Thêm mới.
                    3.Cập nhật.
                    4.Xóa.
                    5.Sắp xếp.
                    6.Đọc từ file.
                    7.Ghi vào file.
                    8.Thoát.
                      """ + "\u001B[0m");
            System.out.println();
            System.out.println("Mời chọn chức năng !!!");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                   Client.Display();
                   break;
                case 2:
                     Client.Add();
                     break;
                case 3:
                    Client.Update();
                    break;
                case 4:
                    Client.Delete();
                    break;
                case 5:
                    Client.Sort();
                    break;
                case 6:
                    Client.Read();
                    break;
                case 7:
                    Client.Write();
                    break;
            }

        } while (choice != 8);
    }
}