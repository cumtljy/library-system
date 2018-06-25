package domain;

import java.time.LocalDateTime;

public class Loan {

    private String id;

    private LocalDateTime loanDate;

    private LocalDateTime dateForReturn;

    private LocalDateTime returnDate;

    private Book book;

    private Member member;

    public boolean hasNotBeenReturned ( ) {

        return returnDate == null;
    }

    public void markAsReturned ( ) {

        setReturnDate ( LocalDateTime.now ( ) );
    }

    public String getId ( ) {

        return id;
    }

    public void setId ( String id ) {

        this.id = id;
    }

    public LocalDateTime getLoanDate ( ) {

        return loanDate;
    }

    public void setLoanDate ( LocalDateTime loanDate ) {

        this.loanDate = loanDate;
    }

    public LocalDateTime getDateForReturn ( ) {

        return dateForReturn;
    }

    public void setDateForReturn ( LocalDateTime dateForReturn ) {

        this.dateForReturn = dateForReturn;
    }

    public LocalDateTime getReturnDate ( ) {

        return returnDate;
    }

    public void setReturnDate ( LocalDateTime returnDate ) {

        this.returnDate = returnDate;
    }

    public Book getBook ( ) {

        return book;
    }

    public void setBook ( Book book ) {

        this.book = book;
    }

    public Member getMember ( ) {

        return member;
    }

    public void setMember ( Member member ) {

        this.member = member;
    }
}