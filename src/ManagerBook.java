import java.util.Scanner;

public class ManagerBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Book[] books = new Book[20];
        System.out.println("Menu\n1. Add a new book\n2. Edit a book by index\n3. Get the price of most expensive book\n"
                + "4. Get the total money of bookshelf\n5. Show total book in shelf\n6. Enter 0 to exit ");
        int choice = scanner.nextInt();
        while (choice != 0) {
            switch (choice) {
                case 1:
                    new ManagerBook().addNewBook(books);
                    new ManagerBook().countBooksOnShelf(books);
                    break;
                case 2:
                    new ManagerBook().editBookByIndex(books);
                    new ManagerBook().countBooksOnShelf(books);
                    break;
                case 3:
                    System.out.println("the price of most expensive book is: "+new ManagerBook().getMaxPrice(books));
                    new ManagerBook().countBooksOnShelf(books);
                    break;
                case 4:
                    new ManagerBook().getSumPrice(books);
                    new ManagerBook().countBooksOnShelf(books);
                    break;
                case 5:
                    new ManagerBook().showTotalBook(books);
                    new ManagerBook().countBooksOnShelf(books);
            }
            System.out.println("Menu\n1. Add a new book\n2. Edit a book by index\n3. Get the price of most expensive book\n"
                    + "4. Get the total money of bookshelf\n5. Show total book in shelf\n6. Enter 0 to exit ");
            choice = scanner.nextInt();

        }
    }

    public void addNewBook(Book[] books) {
        Scanner scanner = new Scanner(System.in);
        int j = 0;
        for (int i = 0; i < books.length; i++) {
            j = i;
            if (books[i] == null) {
                System.out.println("insert book's name");
                String name = scanner.nextLine();
                System.out.println("insert book's author");
                String author = scanner.nextLine();
                System.out.println("insert price");
                int price = scanner.nextInt();
                System.out.println("insert amount");
                int amount = scanner.nextInt();
                System.out.println("insert book's weight");
                int weight = scanner.nextInt();
                books[i] = new Book(name, author, price, amount, weight);
                System.out.println("new book be added at index: " + i);
                break;
            }
        }
        if (j >= 20) {
            System.out.println("Can not add more book! Book shelf is full!");
        }
    }


    public void editBookByIndex(Book[] books) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("insert book's index");
        int index = Integer.parseInt(scanner.nextLine());
        System.out.println("Insert book's name");
        String name = scanner.nextLine();
        System.out.println("insert book's author");
        String author = scanner.nextLine();
        System.out.println("insert price");
        int price = scanner.nextInt();
        System.out.println("insert amount");
        int amount = scanner.nextInt();
        System.out.println("insert book's weight");
        int weight = scanner.nextInt();
        books[index] = new Book(name, author, price, amount, weight);


    }

    public int getMaxPrice(Book[] books) {
        int max = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                if (max < books[i].price) {
                }
                max = books[i].price;
                return max;
            }

        }
        return max;
    }

    public void getSumPrice(Book[] books) {
        int totalPrice = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                totalPrice += books[i].getTotalPrice();
            }
        }
        System.out.println("Total Price is: " + totalPrice);
        ;
    }

    public void showTotalBook(Book[] books) {
        String st = "";
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null)
                st += i + 1 + ". " + books[i].getName() + "\n";
        }
        System.out.println(st);
    }

    public void countBooksOnShelf(Book[] books) {
        int count = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                count++;
            }
        }
        System.out.printf("Has %d books in bookshelf\n", count);
    }
}
