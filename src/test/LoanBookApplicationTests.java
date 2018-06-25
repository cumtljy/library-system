package test;

import org.junit.Test;
import domain.Book;
import domain.ISpecification;
import domain.LoanOnlyOneSpecification;
import domain.MaxLoanSizeSpecification;
import domain.Member;
public class LoanBookApplicationTests {

    @Test
    public void contextLoads ( ) {

    }

    @Test
    public void test ( ) {

        Book book1 = new Book ( );
        book1.setId ( "9" );
        book1.setISBN ( "C1009" );
        book1.setTitle ( "格林童话" );

        Book book2 = new Book ( );
        book2.setId ( "11" );
        book2.setISBN ( "F1011" );
        book2.setTitle ( "一千零一夜" );

        Book book3 = new Book ( );
        book3.setId ( "20" );
        book3.setISBN ( "A1233" );
        book3.setTitle ( "小王子" );
        Book book4 = new Book ( );
        book4.setId ( "15" );
        book4.setISBN ( "D1215" );
        book4.setTitle ( "傲慢与偏见" );
        System.out.println ( "存入四本书" );

        Member testMember = new Member ( );
        System.out.println ( "新建测试member" );
        ISpecification hasReachMax = new MaxLoanSizeSpecification ( );
        testMember.getSpecifications ( ).add ( hasReachMax );
        System.out.println ( "添加规则：最多借三本" );

        testMember.loan ( book1 );
        testMember.loan ( book2 );
        testMember.loan ( book3 );
        testMember.loan ( book4 );

        System.out.println ( "借阅记录" );
        System.out.println ( "********" );
        testMember.getLoans ( ).stream ( ).filter ( loan -> loan.hasNotBeenReturned ( ) ).forEach ( loan -> {
            System.out.println ( loan.getBook ( ).getTitle ( ) );
        } );
        System.out.println ( "********" );

        System.out.println ( "~~~~~~~~~~~~~~~~" );
        testMember.returnBook ( book1 );
        testMember.returnBook ( book2 );
        testMember.returnBook ( book3 );

        System.out.println ( "添加规则：只能借一本" );
        testMember.getSpecifications ( ).add ( new LoanOnlyOneSpecification ( book1 ) );
        testMember.loan ( book1 );
        testMember.loan ( book1 );
        System.out.println ( "借阅记录" );
        System.out.println ( "--------------" );
        testMember.getLoans ( ).stream ( ).filter ( loan -> loan.hasNotBeenReturned ( ) ).forEach ( loan -> {
            System.out.println ( loan.getBook ( ).getTitle ( ) );
        } );
        System.out.println ( "--------------" );
    }

}
