package org.lessons.java.books;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        // Chiedo quanti libri si vogliono inserire
        System.out.println("How many books? ");
        int nOfBooks = Integer.parseInt(scan.nextLine());
        Book[] books = new Book[nOfBooks];
        // Faccio un ciclo per iterare tutti i libri
        for (int i = 0; i < books.length; i++) {
            Book b = null;
            boolean validBook = false;


            // Chiedo i dati del libro: titolo, numero pagine, autore, editore)
            String title;
            int numberPages;
            String author;
            String editor;
            do {
                try {
                    System.out.println("Title: ");
                    title = scan.nextLine();
                    System.out.println("Number of pages: ");
                    numberPages = Integer.parseInt(scan.nextLine());
                    System.out.println("Author: ");
                    author = scan.nextLine();
                    System.out.println("Editor: ");
                    editor = scan.nextLine();

                    b = new Book(title, numberPages, author, editor);
                    validBook = true;

                } catch (InvalidBookException e) {
                    System.out.println("The title, author, editor must not be null and numbers of page >= 0");
                } catch (NumberFormatException ne) {
                    System.out.println("Invalid number");
                }

            } while (!validBook);
            books[i] = b;

        }

        System.out.println(Arrays.toString(books));

        try {
            FileWriter myWriter = new FileWriter("libro.txt");
            myWriter.write(Arrays.toString(books));
            myWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File libroText = new File("libro.txt");
        Scanner reader = new Scanner(libroText);
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            System.out.println(data);
        }
        
        scan.close();
    }
}
