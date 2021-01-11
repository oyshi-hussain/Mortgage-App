package ca.yorku.eecs.mcalc;

public class MortgageModel
{
    private double principle;
    private int amortization;
    private double interest;

    public MortgageModel(String p, String a, String i)
    {
        this.principle = Double.parseDouble(p);
        this.amortization = Integer.parseInt(a);
        this.interest = Double.parseDouble(i);
    }

    public double calc() // raw calculation
    {
        double r = this.interest / (12 * 100); //monthly interest rate
        int n = this.amortization * 12; //amortization months

        //the monthly payment calculation
        double monthlyPayment = (r * this.principle) / (1 - Math.pow((1+r),-n));
        return monthlyPayment;
    }

    public String computePayment()
    {
        String result = String.format("$%,.2f", calc());
        return result;
    }

    public String outstandingAfter(int x)
    {
        double r = this.interest / (12 * 100); //monthly interest rate
        int n = this.amortization * 12; //amortization months
        x = x * 12;
        double monthlyPayment = calc();
        double remaining = this.principle - ((monthlyPayment / r - this.principle) * (Math.pow((1 + r), x) - 1));
        String remainingR = String.format("$%,.2f", remaining);
        return remainingR;
    }

    public static void main(String[] args)
    {
        MortgageModel myModel = new MortgageModel("700000", "25", "2.75");
        System.out.println(myModel.computePayment());
        System.out.println(myModel.outstandingAfter(5));

        myModel = new MortgageModel("300000", "20", "4.50");
        System.out.println(myModel.computePayment());

        myModel = new MortgageModel("100000", "10", "6.25");
        System.out.println(myModel.computePayment());
    }
}
