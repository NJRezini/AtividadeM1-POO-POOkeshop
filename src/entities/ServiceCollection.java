package entities;

import java.util.ArrayList;

public class ServiceCollection {

    private static final ArrayList<Service> registeredServices = new ArrayList<>();

    public ArrayList<Service> getRegisteredServices() {
        return this.registeredServices;
    }

    public void listServices() {
        System.out.println();
        this.getRegisteredServices().forEach(service -> {
            if (service.isDeleted()) {
                System.out.println(service);
            }
        });
    }

    public void registerService(String name, float price, int rarity) {
        Service service = new Service(name, price, rarity);
        this.getRegisteredServices().add(service);
    }

    public void deleteService(Integer serviceId) {
        this.getRegisteredServices().get(serviceId - 1).deleteProduct();
    }
}
