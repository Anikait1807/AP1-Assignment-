package org.example;

import java.util.*;

public class BookDatabase
{
    public String nameBook;
    public static int newBookID = 1;
    public String author;
    public int copies;
    public int bookID;

    public BookDatabase(String nameBook, String author, int copies)
    {
        this.nameBook = nameBook;
        this.author = author;
        this.copies = copies;
    }
    public BookDatabase(int bookID)
    {
        this.bookID = bookID;
    }
    public BookDatabase(String nameBook, int bookID)
    {
        this.nameBook = nameBook;
        this.bookID = bookID;
    }
    public void addBooks(Map<String, List<Object>> totalBooks)
    {
        boolean isFlag = false;
        for(Map.Entry<String, List<Object>> entry : totalBooks.entrySet())
        {
            List<Object> temp = entry.getValue();
            if(Objects.equals(this.nameBook, entry.getKey()) && Objects.equals(this.author, (String)temp.get(0)))
            {
                isFlag = true;
                int initialValue = (int)temp.get(1);
                initialValue += this.copies;

                temp.set(1, initialValue);

                for(int i = 0; i < this.copies; i++)
                {
                    this.bookID = newBookID++;
                    ((List<Integer>)temp.get(2)).add(this.bookID);
                }
                System.out.println("Te bookIDS are : " + ((List<Integer>)temp.get(2)));
                System.out.println("Since the book of the same name was/were already present, we have added the given number of copies to the original set of copies");
//                System.out.println("Book ID of the book is " + (int)temp.get(2));
                break;
            }
        }
        if(isFlag == false)
        {
//            this.bookID = newBookID++;
            List<Integer> bookIDS = new ArrayList<>();
            for(int i = 0; i < this.copies; i++)
            {
                this.bookID = newBookID++;
                bookIDS.add(this.bookID);
            }
            totalBooks.put(this.nameBook, Arrays.asList(this.author, this.copies, bookIDS));
            if (this.copies > 1)
            {
                System.out.println("The books have been added to the book database");
            }
            else
            {
                System.out.println("The book has been added to the book database");
            }
        }
    }

    public void removeBook(Map<String, List<Object>> totalBooks)
    {
        boolean isFlag = false;
        for(Map.Entry<String, List<Object>> entry : totalBooks.entrySet())
        {
            List<Integer> temp= (List<Integer>)(entry.getValue()).get(2);
            for(int i = 0; i < temp.size(); i++)
            {
                if(temp.get(i) == this.bookID)
                {
                    isFlag = true;
                    int initial_copy = (int)(entry.getValue()).get(1);
                    System.out.println("The initial number of copies was " + initial_copy);
                    initial_copy--;
                    temp.remove(i);
                    System.out.println("A copy of the book of ID " + this.bookID + " has been removed");
                    System.out.println("Total copies of the book bearing the ID " + this.bookID + " is now " + initial_copy);
                    break;
                }
            }

        }
        if(isFlag == false)
        {
            System.out.println("There is no book of this particular ID");
        }
    }

    public boolean checkBook(Map<String, List<Object>> totalBooks)
    {
        for(Map.Entry<String, List<Object>>entry : totalBooks.entrySet())
        {
            List<Object> temp = entry.getValue();
            if(Objects.equals(entry.getKey(), this.nameBook))
            {
                List<Integer> a = (List<Integer>)temp.get(2);
                for(int i = 0; i < a.size(); i++)
                {
                    if(this.bookID == a.get(i))
                    {
                        System.out.println("Hit");
                        a.remove(i);
                        int initial_copy = (int)temp.get(1);
                        initial_copy --;
                        temp.set(1, initial_copy);
                        return true;
                    }
                }
            }

        }
        return false;
    }


}
