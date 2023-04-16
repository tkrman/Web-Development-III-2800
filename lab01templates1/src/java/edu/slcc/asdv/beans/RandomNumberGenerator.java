package edu.slcc.asdv.beans;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named(value = "randomNumberGenerator")
@RequestScoped
public class RandomNumberGenerator
{

    public RandomNumberGenerator()
    {
    }

    public double getRandomNum()
    {
        return Math.random();
    }
}
