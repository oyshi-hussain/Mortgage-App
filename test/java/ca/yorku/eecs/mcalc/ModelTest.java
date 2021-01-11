package ca.yorku.eecs.mcalc;

import org.junit.Assert;
import org.junit.Test;

public class ModelTest
{
    @Test
    public void testPayment()
    {
        MortgageModel myModel;

        myModel = new MortgageModel("700000", "25", "2.75");
        Assert.assertEquals("C1", "$3,229.18", myModel.computePayment());

        myModel = new MortgageModel("300000", "20", "4.5");
        Assert.assertEquals("C2", "$1,897.95", myModel.computePayment());

        myModel = new MortgageModel("100000", "10", "6.25");
        Assert.assertEquals("C3", "$1,122.80", myModel.computePayment());
    }
}