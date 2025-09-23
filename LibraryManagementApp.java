import java.util.Scanner;
import java.util.InputMismatchException;

class Book{
    private int id;
    private String title;
    private String author;
    private String deadline;
    private boolean isIssued;
    
    public Book(int id, String title, String author, String deadline){
        this.id=id;
        this.title=title;
        this.author=author;
        this.deadline=deadline;
        this.isIssued=false;
    }
    
    public int getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public boolean getIssue() {
        return isIssued;
    }
    
    public void setIssue(boolean isIssued) {
        this.isIssued=isIssued;
    }
    
    void display(){
        System.out.println("Bood Id: "+id+" , Title: "+title+" , Author: "+author);
    }
}

interface Searchable {
    void search(Book[] books, int count, String key);
}

class SearchName implements Searchable {
    public void search(Book[] books, int count, String key){
        boolean found=false;
        for(int i=0;i<count;i++){
            if(books[i].getTitle().equalsIgnoreCase(key)) {
            books[i].display();
            found=true;
            }
        }
        if(!found) {
            System.out.println("No book is found in this name "+key);
        }
   }
}

class SearchAuthor implements Searchable {
    public void search(Book[] books, int count, String key) {
        boolean found=false;
        for(int i=0;i<count;i++) {
            if(books[i].getAuthor().equalsIgnoreCase(key)) {
            books[i].display();
            found=true;
            }
        }
        if(!found){
            System.out.println("No book found by author "+key);
        }
    }
}

class Library{
    private Book[] books;
    private int count=0;
    
        public Library(int size){ 
        books=new Book[size];
        count=0;
    }
        
    public void addBook(int id,String title,String author,String deadline){
            if(count<books.length){
                books[count++]=new Book(id,title, author,deadline);
                System.out.println("Book added successfully");
            }
            else{
            System.out.println("No more books cab be added.");
            }
            return;
     }
     
     public void viewBook() {
        for(int i=0;i<count;i++){
            if(i>=0){
            books[i].display();}
            else{
            System.out.println("No available books");
        }
     }
     }
     
     public void borrowBook(int id) {
     try{
         boolean bookExist=false;
         for(int i=0;i<count;i++){
                 if(books[i].getId()==id && !books[i].getIssue()){
                     books[i].setIssue(true);
                     System.out.println("Book borrowed "+books[i].getTitle());
                     bookExist=true;
                 }
                 else if(books[i].getId()==id && books[i].getIssue()) {
                     System.out.println("Book already borrowed");
                     bookExist=true;
                 }
         }
                 if(!bookExist){
                     System.out.println("No books available");
                 } 
                 }
                 catch(InputMismatchException e){
                 System.out.println("Please enter the correct format");
                 }
                 
     }
    
    public void returnBook(int id) {
        boolean bookExist=false;
        for(int i=0;i<count;i++){
            if(books[i].getId()==id && books[i].getIssue()){
                books[i].setIssue(false);
                System.out.println("Book returned "+books[i].getTitle());
                bookExist=true;
            }
            else if(books[i].getId()==id && !books[i].getIssue()){
                System.out.println("Book is not yet borrowed");
                bookExist=true;
            }
       }
       if(!bookExist){
           System.out.println("No book in this name is available");}
    }
    
    public Book[] getBooks() {
        return books;
    }
    
    public int getCount() {
        return count;
    }
}

class LibraryManagementApp{
    public static void main(String[] args){
        
        Library library=new Library(5);
        Scanner sc=new Scanner(System.in);
      
        int choice;
        
        while(true) {
        
        System.out.println();
        System.out.println("---LIBRARY MANAGEMENT SYSTEM---");
        System.out.println("1. Add book");
        System.out.println("2. View available books");
        System.out.println("3. Issue book");
        System.out.println("4. Return book");
        System.out.println("5. Search by name");
        System.out.println("6. Search by Author");
        System.out.println("7. Exit");
        
        System.out.println("Enter your choice");
        choice=sc.nextInt();
        sc.nextLine();
        
        switch(choice) {
        
        case 1: 
        System.out.println("Enter book id");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Title of the Book");
        String title=sc.nextLine();
        System.out.println("Enter Author Name of the book");
        String author=sc.nextLine();
        System.out.println("Enter deadline (YYYY-MM-DD): ");
        String deadline=sc.nextLine();
        library.addBook(id,title,author,deadline);
        break;
        
        case 2:
        library.viewBook();
        break;
        
        case 3:
        System.out.println("Enter Book id to borrow book");
        id=sc.nextInt();
        library.borrowBook(id);
        break;
        
        case 4:
        System.out.println("Enter Book id to return book");
        id=sc.nextInt();
        library.returnBook(id);
        break;
        
        case 5:
        System.out.println("Search Book by name");
        title=sc.nextLine();
        Searchable searchName = new SearchName();
        searchName.search(library.getBooks(), library.getCount(), title);
        break;
        
        case 6:
        System.out.println("Search Book by author");
        author=sc.nextLine();
        Searchable searchAuthor=new SearchAuthor();
        searchAuthor.search(library.getBooks(), library.getCount(), author);
        break;
        
        case 7:
        System.out.println("Exit, Thank You!");
        return;
        
        default:
        System.out.println("Invalid options");
        }
        }
        
    }
}

