package org.example;

import java.awt.print.Book;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Library_System
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        AtomicInteger memberIDtemp = new AtomicInteger(0);
        Map<String, List<Object>> totalBooks = new HashMap<>();
        Map<String, List<Object>> myBooks = new HashMap<>();
        Map<String, List<Object>> humanInfo = new HashMap<>();

        System.out.println("Library Portal Initialized");
        while(true)
        {
            System.out.println("-------------------");
            System.out.println("1.   Enter as librarian");
            System.out.println("2.   Enter as member");
            System.out.println("3.   Exit");

            int applyHuman = scanner.nextInt();

            if(applyHuman == 1)
            {
                while(true)
                {
                    System.out.println("----------------------");
                    System.out.println("1.   Register a member");
                    System.out.println("2.   Remove a member");
                    System.out.println("3.   Add a book");
                    System.out.println("4.   Remove a book");
                    System.out.println("5.   View all members along with their books and fines to be paid");
                    System.out.println("6.   View all books");
                    System.out.println("7.   Back");
                    System.out.println("-----------------------");

                    int applyValue = scanner.nextInt();

                    if (applyValue == 1)
                    {
                        scanner.nextLine();
                        System.out.println("Enter your name : ");
                        String name = scanner.nextLine();
                        System.out.println("Enter your age : ");
                        int age = scanner.nextInt();
                        System.out.println("Enter your phone number");
                        int phoneNumber = scanner.nextInt();

                        HumanDatabase person = new HumanDatabase(name, age, phoneNumber);
                        boolean major = person.registerMember(humanInfo);
                        if(major == true)
                        {
                            System.out.println("Name is already present");
                        }
                        else
                        {
                            System.out.println("Congratulations, your name has been registered");
                        }
                    }

                    if (applyValue == 2)
                    {
                        scanner.nextLine();
                        System.out.println("Enter your name : ");
                        String name = scanner.nextLine();
                        System.out.println("Enter your age : ");
                        int age = scanner.nextInt();
                        System.out.println("Enter your phone number");
                        int phoneNumber = scanner.nextInt();

                        HumanDatabase person = new HumanDatabase(name, age, phoneNumber);
                        boolean major = person.removeMember(humanInfo);
                        if(major == true)
                        {
                            System.out.println("Your name has been successfully removed");
                        }
                        else
                        {
                            System.out.println("Your name is not in the database");
                        }
                    }

                    if (applyValue == 3)
                    {
                        scanner.nextLine();
                        String bookName = scanner.nextLine();
                        String author = scanner.nextLine();
                        int copies = scanner.nextInt();

                        BookDatabase book = new BookDatabase(bookName, author, copies);
                        book.addBooks(totalBooks);
                    }

                    if (applyValue == 4)
                    {
                        System.out.println("Enter book ID : ");
                        int bookID = scanner.nextInt();
                        BookDatabase book = new BookDatabase(bookID);
                        book.removeBook(totalBooks);
                    }
                    if(applyValue == 5)
                    {
                        for(Map.Entry<String, List<Object>>entry : humanInfo.entrySet())
                        {
                            String newName = entry.getKey();
                            System.out.println("Member name is : " + newName);
                            List<Object>temp = entry.getValue();
                            Map<String, List<Object>> myMap = (Map<String, List<Object>>)temp.get(2);
                            int i = 0;
                            for(Map.Entry<String, List<Object>>entry1 : myMap.entrySet())
                            {
                                i++;
                                System.out.println(i + ". " + entry1.getKey());
                            }
                            int c = (int)temp.get(4);
                            System.out.println("Dues are " + c + " Rupees");
                        }

                    }
                    if(applyValue == 6)
                    {
                        for(Map.Entry<String, List<Object>>entry : totalBooks.entrySet())
                        {
                            List<Object>temp = entry.getValue();
                            List<Integer>a = (List<Integer>)temp.get(2);
                            for(int i = 0; i < a.size(); i++)
                            {
                                System.out.println("BOOK ID :- " + a.get(i));
                                System.out.println("Name :- " + entry.getKey());
                                System.out.println("Author :- " + temp.get(0));
                                System.out.println("\n");
                            }
                            System.out.println("-------------------------------------");
                        }
                    }
                    if(applyValue == 7)
                    {
                        break;
                    }
                }
            }
            if(applyHuman == 2)
            {
                scanner.nextLine();
                System.out.println("Enter your name : ");
                String name = scanner.nextLine();
                System.out.println("Enter your age : ");
                int age = scanner.nextInt();
                System.out.println("Enter your phone number");
                int phoneNumber = scanner.nextInt();

                HumanDatabase person = new HumanDatabase(name, age, phoneNumber);
                boolean mainFlag = person.checkIFpresent(humanInfo);

                if(mainFlag == false)
                {
                    continue;
                }

                while(true)
                {
                    System.out.println("----------------------");
                    System.out.println("1.   List available books");
                    System.out.println("2.   List my books");
                    System.out.println("3.   Issue book(s)");
                    System.out.println("4.   Return book(s)");
                    System.out.println("5.   Pay Fine");
                    System.out.println("6.   Back");
                    System.out.println("-----------------------");

                    int applyValue = scanner.nextInt();

                    if(applyValue == 1)
                    {
                        for(Map.Entry<String, List<Object>>entry : totalBooks.entrySet())
                        {
                            List<Object>temp = entry.getValue();
                            List<Integer>a = (List<Integer>)temp.get(2);
                            for(int i = 0; i < a.size(); i++)
                            {
                                System.out.println("BOOK ID :- " + a.get(i));
                                System.out.println("Name :- " + entry.getKey());
                                System.out.println("Author :- " + temp.get(0));
                                System.out.println("\n");
                            }
                            System.out.println("-------------------------------------");
                        }
                    }
                    if(applyValue == 2)
                    {
                        person.listMyBooks(humanInfo);
                    }
                    if(applyValue == 3)
                    {

                        int bookID = scanner.nextInt();
                        String bookName = scanner.nextLine();
                        scanner.nextLine();
                        BookDatabase book = new BookDatabase(bookName, bookID);
                        boolean flag = book.checkBook(totalBooks);
                        System.out.println(flag);
                        person.issueAbook(flag, humanInfo, bookName, bookID);
                    }
                    if(applyValue == 4)
                    {
                        int bookID = scanner.nextInt();
                        scanner.nextLine();
                        String bookName = scanner.nextLine();

//                        long fine = person;
                        person.returnBook(humanInfo, bookID, bookName);
//
                    }
                    if(applyValue == 5)
                    {
                        person.totalFine(humanInfo);
                    }
                    if(applyValue == 6)
                    {
                        break;
                    }
                }
            }
            if(applyHuman == 3)
            {
                System.out.println("Thank you for visiting");
                break;
            }
        }
    }
}