package domain;

import java.util.stream.Collectors;

public class MaxLoanSizeSpecification implements ISpecification < Member > {

    @Override
    public boolean isSatisfied ( Member entity ) {

        boolean b = entity.getLoans ( ).stream ( ).filter ( loan -> loan.hasNotBeenReturned ( ) ).collect ( Collectors.toList ( ) ).size ( ) < 3;
        if ( ! b ) {
            System.out.println ("已达最大借阅数量，不可再借。" );
        }
        return b;
    }
}