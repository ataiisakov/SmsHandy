package models;

public class TariffPlanPhone extends Phone{
    private int costForSms = 1;

    public TariffPlanPhone(String name, String number, Provider provider) {
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
