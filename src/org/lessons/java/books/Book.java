package org.lessons.java.books;

public class Book {
    // FIELDS (private)
    private String title;
    private int numberPages;
    private String author;
    private String editor;

    public Book(String title, int numberPages, String author, String editor) throws InvalidBookException {
        // Procedo solo se title
        if (title != null && !title.isBlank() && author != null && !author.isBlank() && editor != null && !editor.isBlank() && numberPages > 0) {
            this.title = title;
            this.numberPages = numberPages;
            this.author = author;
            this.editor = editor;
        } else {
            throw new InvalidBookException();
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws InvalidBookException {
        if (title != null && !title.isBlank()) {
            throw new InvalidBookException();
        }
        this.title = title;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(int numberPages) {
        if (numberPages <= 0) {
            throw new IllegalArgumentException();
        }
        this.numberPages = numberPages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) throws InvalidBookException {
        if (author != null && !title.isBlank()) {
            throw new InvalidBookException();
        }
        this.author = author;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) throws InvalidBookException {
        if (editor != null && !title.isBlank()) {
            throw new InvalidBookException();
        }
        this.editor = editor;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", numberPages=" + numberPages +
                ", author='" + author + '\'' +
                ", editor='" + editor + '\'' +
                '}';
    }
}
