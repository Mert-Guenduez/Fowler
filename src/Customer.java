
import java.lang.*;
import java.util.*;

class Customer {
    private String name;
    private Vector rentals = new Vector();
    public Customer (String newname){
        name = newname;
    };
    public void addRental(Rental rental) {
        rentals.addElement(rental);
    };
    public String getName (){
        return name;
    };
    public String statement() {
        double totalCost = 0;
        int frequentRenterPoints = 0;
        Enumeration customerRentals = rentals.elements();	    
        String resultStatement = "Rental Record for " + this.getName() + "\n";
        resultStatement += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (customerRentals.hasMoreElements()) {
            double rentalPrice = 0;
            Rental each = (Rental) customerRentals.nextElement();
            //determine amounts for each line
            rentalPrice = amountFor(each);
            // add frequent renter points
            frequentRenterPoints ++;
            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1) 
                frequentRenterPoints ++;
            //show figures for this rental
            resultStatement += "\t" + each.getMovie().getTitle()+ "\t" + "\t" + each.getDaysRented() + "\t" + String.valueOf(rentalPrice) + "\n";
            totalCost += rentalPrice;
        }
        //add footer lines
        resultStatement += "Amount owed is " + String.valueOf(totalCost) + "\n";
        resultStatement += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return resultStatement;
    }

    public double amountFor(Rental rental) {
        double rentalPrice = 0;
        switch(rental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                rentalPrice += 2;
                if (rental.getDaysRented() > 2)
                    rentalPrice += (rental.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                rentalPrice += rental.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                rentalPrice += 1.5;
                if (rental.getDaysRented() > 3)
                    rentalPrice += (rental.getDaysRented() - 3) * 1.5;
                break;
        }
        return rentalPrice;
    }

}
    