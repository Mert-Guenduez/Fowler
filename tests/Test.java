
import static org.junit.Assert.*;

/*import Application.Customer;
import Application.Movie;
import Application.Price;
import Application.Rental;*/

public class Test {

	@org.junit.Test
	public void TestAmountRentalNewRelease3Days(){
		Movie m = new Movie("Interstellar", Movie.NEW_RELEASE);
		Customer c = new Customer("Testcustomer");
		Rental r = new Rental(m, 3);
		c.addRental(r);
		assertEquals(9.0, c.amountFor(r),0.0001);
	}
	
	@org.junit.Test
	public void TestGetCorrectPriceCode(){;
		Movie m = new Movie("Caillou Remastered", Movie.CHILDRENS);
		assertEquals(2, m.getPriceCode());
	}
	
	@org.junit.Test
	public void Test(){
		Customer c = new Customer("Hangox");
		Movie m1 = new Movie("movie1", Movie.CHILDRENS);
        Movie m2 = new Movie("movie2", Movie.NEW_RELEASE);
        Rental r1 = new Rental(m1, 10);
        Rental r2 = new Rental(m2, 3);
        c.addRental(r1);
        c.addRental(r2);
    assertEquals("Rental Record for Hangox\n" +
            "\tTitle\t\tDays\tAmount\n" +
            "\tmovie1\t\t10\t12.0\n" +
            "\tmovie2\t\t3\t9.0\n" +
            "Amount owed is 21.0\n" +
            "You earned 3 frequent renter points",c.statement());
	}

}