package domain;

public class Book {

    private String id;

    private String ISBN;

    private String title;

    private Member LoanTo;

    public String getId ( ) {

        return id;
    }

    public void setId ( String id ) {

        this.id = id;
    }

    public String getISBN ( ) {

        return ISBN;
    }

    public void setISBN ( String ISBN ) {

        this.ISBN = ISBN;
    }

    public String getTitle ( ) {

        return title;
    }

    public void setTitle ( String title ) {

        this.title = title;
    }

    public Member getLoanTo ( ) {

        return LoanTo;
    }

    public void setLoanTo ( Member loanTo ) {

        LoanTo = loanTo;
    }
}
