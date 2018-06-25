package domain;

public class LoanOnlyOneSpecification implements ISpecification < Member > {

    private Book wantBook;

    public LoanOnlyOneSpecification ( Book wantBook ) {

        this.wantBook = wantBook;
    }

    @Override
    public boolean isSatisfied ( Member entity ) {

        boolean b = entity.getLoans ( )
                .stream ( )
                .noneMatch ( loan -> loan.hasNotBeenReturned ( ) && loan.getBook ( ).getISBN ( ).equals ( wantBook.getISBN ( ) ) );
        if ( ! b ) {
            System.out.println (  "你已经借了"+wantBook.getTitle ()+"，ISBN：" + wantBook.getISBN ( ) +"。不可重复借阅！");
        }
        return b;
    }

}
