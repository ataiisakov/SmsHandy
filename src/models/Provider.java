package models;

import java.util.ArrayList;
import java.util.HashMap;

public class Provider {
    private String name;
    private HashMap<String, Phone> abonentsMap;
    private static ArrayList<Provider> providersList = new ArrayList<>();

    public Provider(String name) {
        this.name = name;
        this.abonentsMap = new HashMap<>();
        providersList.add(this);
    }

    public Provider findProviderFor(String number){
        for (Provider provider : providersList) {
            if (provider.getAbonentsMap().containsKey(number)){
               return provider;
            }
        }
        return null;
    }

    public boolean sendMessage(Message message){
        Provider toProvider = this.findProviderFor(message.getTo());
        if (toProvider != null){
            Phone toPhone = toProvider.getAbonentsMap().get(message.getTo());
            toPhone.getReceivedMessagesList().add(message);
            Phone fromPhone = this.getAbonentsMap().get(message.getFrom());
            fromPhone.getSendMessagesList().add(message);
            fromPhone.payForMessage();
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Phone> getAbonentsMap() {
        return abonentsMap;
    }

    public void register(Phone phone){
        abonentsMap.put(phone.getNumber(), phone);
    }

    public static ArrayList<Provider> getProvidersList() {
        return providersList;
    }

    public void register(Provider provider){
        providersList.add(provider);
    }
}
