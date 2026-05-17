package model;

/**
 * Represents a Tabung savings goal for an account holder.
 */
// Previously named: Tabung
public class SavingsGoal {

    private String name;
    private double targetAmount;
    private double currentAmount;

    public SavingsGoal(String name) {
        this.name = name;
    }

    public SavingsGoal(String name, double targetAmount) {
        this.name = name;
        this.targetAmount = targetAmount;
        this.currentAmount = 0;
    }

    public String getName() {
        return name;
    }

    public double getTargetAmount() {
        return targetAmount;
    }

    public double getCurrentAmount() {
        return currentAmount;
    }

    public void deposit(double amt) {
        this.currentAmount += amt;
    }

    public void withdraw(double amt) {
        this.currentAmount -= amt;
    }

    public double progressPercent() {
        return targetAmount == 0 ? 0 : (currentAmount / targetAmount) * 100;
    }
}
