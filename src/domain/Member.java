package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Member {

    private String id;

    private String name;

    private List < Loan > Loans = new ArrayList <> ( );

    private List < ISpecification < Member > > specifications = new ArrayList <> ( );

    public Member ( ) {

        //        specifications.add ( new LoanOnlyOneSpecification ( ) );
    }

    public void returnBook ( Book book ) {

        Loan loan = findCurrentLoanFor ( book );
        if ( loan != null ) {
            loan.markAsReturned ( );
            book.setLoanTo ( null );
            System.out.println ( "还书" + book.getTitle ( ) + "成功！" );
        }
    }

    public boolean canLoan ( Book book ) {

        return book.getLoanTo ( ) == null && validate ( );
    }

    public Loan loan ( Book book ) {

        Loan loan = null;
        if ( canLoan ( book ) ) {
            loan = LoanFactory.CreateLoan ( book , this );
            System.out.println ( "借阅" + book.getTitle ( ) + "成功！" );
            getLoans ( ).add ( loan );
            return loan;
        }
        System.out.println ( book.getTitle ( ) + "不可以借阅！" );
        return loan;

    }

    public Loan findCurrentLoanFor ( Book book ) {

        List < Loan > collect = getLoans ( ).stream ( )
                .filter ( loan -> book.getId ( ).equals ( loan.getBook ( ).getId ( ) ) && loan.hasNotBeenReturned ( ) )
                .collect ( Collectors.toList ( ) );
        if ( collect.size ( ) > 0 ) {
            return collect.get ( 0 );
        }
        return null;
    }

    private boolean validate ( ) {

        boolean result = false;
        for ( ISpecification < Member > specification : specifications ) {
            result = specification.isSatisfied ( this );
            if ( ! result ) {
                return false;
            }
        }
        return result;
    }

    public String getId ( ) {

        return id;
    }

    public void setId ( String id ) {

        this.id = id;
    }

    public String getName ( ) {

        return name;
    }

    public void setName ( String name ) {

        this.name = name;
    }

    public List < Loan > getLoans ( ) {

        return Loans;
    }

    public void setLoans ( List < Loan > loans ) {

        Loans = loans;
    }

    public List < ISpecification < Member > > getSpecifications ( ) {

        return specifications;
    }

    public void setSpecifications ( List < ISpecification < Member > > specifications ) {

        this.specifications = specifications;
    }
}