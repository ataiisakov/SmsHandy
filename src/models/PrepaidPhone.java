package models;

public class PrepaidPhone extends Phone{
    private double costForSms = 5;

    public PrepaidPhone(String name, String number, Provider provider) {
        super(name, number, provider);
    }

    @Override
    public boolean canSendMessage() {
        return this.getBalance() - costForSms >= 0;
    }

    @Override
    public void payForMessage() {
        this.setBalance(this.getBalance() - this.costForSms);
    }
}
