package org.example;

import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.security.Key;
import java.time.Instant;
import java.time.Duration;
import java.util.*;

public class HumanDatabase
{
    public String name;
    public int age;
    public static int newMemberID = 1;
    public int memberID;
    public int phoneNumber;


    public HumanDatabase(String name, int age, int phoneNumber)
    {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public boolean registerMember(Map<String, List<Object>> humanInfo)
    {

        boolean isFlag = false;


            for(Map.Entry<String, List<Object>> entry : humanInfo.entrySet())
            {
                List<Object> temp = entry.getValue();
                if(Objects.equals(this.name, entry.getKey()) && this.age == (int)temp.get(0) && this.phoneNumber == (int)temp.get(1))
                {
                    isFlag = true;
                    return true;
                }
            }
        this.memberID = newMemberID++;
        Map<String, List<Object>> myMap = new HashMap<>();
        int myFine = 0;
        List<Object> temp1 = new ArrayList<>(Arrays.asList(age, phoneNumber, myMap, this.memberID, myFine));
        humanInfo.put(this.name, temp1);

        return false;
    }

    public boolean removeMember(Map<String, List<Object>> humanInfo)
        {
            boolean isFlag = false;


            for(Map.Entry<String, List<Object>> entry : humanInfo.entrySet())
            {
                List<Object> temp = entry.getValue();
                if(Objects.equals(this.name, entry.getKey()) && this.age == (int)temp.get(0) && this.phoneNumber == (int)temp.get(1))
                {
                    humanInfo.remove(this.name);
                    isFlag = true;
                    return true;
                }
            }
            return false;
    }

    public boolean checkIFpresent(Map<String, List<Object>>humanInfo)
    {
        boolean isFlag = false;
        for(Map.Entry<String, List<Object>>entry : humanInfo.entrySet())
        {
            List<Object>temp = entry.getValue();
            if(Objects.equals(this.name, entry.getKey()) && (int)temp.get(0) == this.age && this.phoneNumber == (int)temp.get(0))
            {
                System.out.println("Welcome " + (this.name) + ". Member ID : " + (int)temp.get(3));
                isFlag = true;
                return isFlag;
            }
        }
        System.out.println("Member with Name : " + (this.name) + " and phone number : " + (this.phoneNumber) + " doesn't exist");
        return isFlag;
    }

    public void issueAbook(boolean main, Map<String, List<Object>>humanInfo, String bookName, int bookID)
    {
        if(main)
        {
            for(Map.Entry<String, List<Object>> entry : humanInfo.entrySet())
            {
                List<Object> temp = (List<Object>)entry.getValue();
                if(Objects.equals(this.name, entry.getKey()))
                {
                    Map<String, List<Object>> a = (Map<String, List<Object>>)temp.get(2);
                    int c = (int)temp.get(4);
                    if(c > 0)
                    {
                        System.out.println("I am sorry, but you are in due to pay " + c + " .Please pay the fine for further issuing of books ");
                    }
                    if(a.size() < 2)
                    {
                        Instant dueTime = Instant.now();
                        a.put(bookName, Arrays.asList(bookID, 0, dueTime));
                        System.out.println("You have issued the book");
                    }
                    if(a.size() >= 2)
                    {
                        System.out.println("We are sorry but you have exceeded the limit of issuing books, please return some to continue issuing");
                    }

                }
            }
        }
        else
        {
            System.out.println("I am sorry but the book is not available");
        }
    }

    public void returnBook(Map<String, List<Object>> humanInfo, int bookID, String bookName)
    {
        for (Map.Entry<String, List<Object>> entry : humanInfo.entrySet())
        {
            List<Object> temp = entry.getValue();
            if (Objects.equals(this.name, entry.getKey()))
            {
                Map<String, List<Object>> a = (Map<String, List<Object>>) temp.get(2);
                for (Map.Entry<String, List<Object>> entry1 : a.entrySet())
                {
                    if (Objects.equals(bookName, entry1.getKey()))
                    {
                        List<Object> b = entry1.getValue();
                        if (bookID == (int) b.get(0))
                        {
                            long fine;
                            System.out.println("Hello");
                            Instant returnTime = Instant.now();
                            Duration timeDifference = Duration.between((Instant) b.get(2), returnTime);
                            long extraTimeInSeconds = timeDifference.toSeconds();
                            if (extraTimeInSeconds > 10)
                            {
                                fine = 3 * (extraTimeInSeconds - 10);
                                int c = (int)temp.get(4);
                                c += fine;
                                temp.set(4, c);
                                System.out.println("Fine is " + fine + " and delay is " + (extraTimeInSeconds - 10) + " days");
                            } else
                            {
                                fine = 0;
                                System.out.println("Fine is " + fine + " and there is no delay");
                            }
                            a.remove(entry1.getKey());
                        }
                    }
                }
            }
        }
    }

    public void totalFine(Map<String, List<Object>>humanInfo)
    {
        for (Map.Entry<String, List<Object>> entry : humanInfo.entrySet())
        {
            List<Object> temp = entry.getValue();
            if(Objects.equals(this.name, entry.getKey()))
            {
                int c = (int)temp.get(4);
                System.out.println("The total fine you have to pay is " + c + " rupeees");
                c = 0;
                temp.set(4, c);
            }
        }
    }

    public void listMyBooks(Map<String, List<Object>> humanInfo)
    {
        for(Map.Entry<String, List<Object>>entry : humanInfo.entrySet())
        {
            if(Objects.equals(this.name, entry.getKey()))
            {
                List<Object>temp = entry.getValue();
                Map<String, List<Object>>myMap = (Map<String, List<Object>>)temp.get(2);
                int i = 0;
                for(Map.Entry<String, List<Object>>entry1 : myMap.entrySet())
                {
                    i++;
                    System.out.println(i + ". " + entry1.getKey());
                }
            }
        }
    }



}
