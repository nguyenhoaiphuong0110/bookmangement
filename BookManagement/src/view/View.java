package view;

import controller.DataController;
import model.Book;
import model.Reader;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    public static void main(String[] args) {
        int choice = 0;
        var booksFileName = "BOOK.DAT";
        var readersFileName = "READER.DAT";
        var controller = new DataController();
        var books = new ArrayList<Book>();
        var readers = new ArrayList<Reader>();
        var isReaderChecker = false;
        var isBookChecked = false;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("______________MENU_____________");
            System.out.println("1. them 1 dau sach vao file");
            System.out.println("2. Hien thi danh sach co sach co trog file");
            System.out.println("3. Them 1 ban doc file");
            System.out.println("4. Hien thi danh sach cac ban doc co trong file");
            System.out.println("0. Thoat ra");
            System.out.println("Ban chon ?");
            choice = scanner.nextInt();
            scanner.nextLine();///doc bo dong chua lua chon
            switch (choice) {
                case 0:
                    System.out.println("___________________________________________");
                    System.out.println("Cam on ban da su dung dich vu cua chung toi");
                    break;

                case 1:
                    if(!isBookChecked){
                        checkBookID(controller,booksFileName);
                        isBookChecked = true;
                    }

                    String[] specs = {"Science", "Art", "Economic", "IT"};
                    String bookName, author, spec;
                    int year, quan, sp;
                    System.out.println("Nhap ten sach:");
                    bookName = scanner.nextLine();

                    System.out.println("ten tac gia");
                    author = scanner.nextLine();

                    do {
                        System.out.println("the loai");
                        System.out.println("1.Science.\n2.Art.\n3.Economic.\n4.IT");
                        sp = scanner.nextInt();
                    } while (sp < 1 || sp > 4);
                    spec = specs[sp - 1];

                    System.out.println("Nam xuat ban:");
                    year = scanner.nextInt();

                    System.out.println("Nhap so luong");
                    quan = scanner.nextInt();

                    Book book = new Book(0,bookName,author,spec,year,quan);
                    controller.writeBookToFile(book, booksFileName);
                    break;
                case 2:
                    books = controller.readBooksFromFile(booksFileName);
                    showBookInfor(books);
                    break;
                case 3:
                    if(!isReaderChecker){
                        checkReaderID(controller,readersFileName);
                        isReaderChecker = true;
                    }
                    String fullName , address, phoneName;
                    System.out.println("Nhap ten:");
                    fullName = scanner.nextLine();

                    System.out.println("Mhap dia chi:");
                    address = scanner.nextLine();

                    do{
                        System.out.println("Nhap so dien thoai");
                        phoneName = scanner.nextLine();
                    }while (!phoneName.matches("\\d{10}"));
                    Reader reader = new Reader(0,fullName,address,phoneName);
                    controller.writeReaderToFile(reader,readersFileName);
                    break;
                case  4:
                    readers = controller.readReadersFromFile(readersFileName);
                    showReadersInfor(readers);
                    break;
            }
        } while (choice != 0);
    }

    private static void showReadersInfor(ArrayList<Reader> readers) {
        System.out.println("_________________Thong tin cac ban doc trong file______________");
        for (var r: readers) {
            System.out.println(r);
        }
    }

    private static void checkReaderID(DataController controller, String readersFileName) {
        var readers = controller.readReadersFromFile(readersFileName);
        if(readers.size() == 0){
            // do nothing
        }else {
            Reader.setId((readers.get(readers.size()-1).getReaderID())+ 1);
        }
    }

    private static void checkBookID(DataController controller , String fileName) {
        var listBooks = controller.readBooksFromFile(fileName);
        if(listBooks.size() == 0){
            //do nothing
        }else {
            Book.setId(listBooks.get(listBooks.size() - 1).getBookID() + 1);
        }
    }

    private static void showBookInfor(ArrayList<Book> books) {
        System.out.println("____________Thong tin sach trong file_____________");
        for (var b:books) {
            System.out.println(b);

        }
    }
}
