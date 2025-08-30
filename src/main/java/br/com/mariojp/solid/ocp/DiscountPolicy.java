package br.com.mariojp.solid.ocp;

public interface DiscountPolicy{
    
	double apply(double amount);
	
	CustomerType getType();
}
