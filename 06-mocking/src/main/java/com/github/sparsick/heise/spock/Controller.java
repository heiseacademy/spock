package com.github.sparsick.heise.spock;

public class Controller {

    private Service service;

    public Controller(Service service) {
        this.service = service;
    }

    public boolean handleRequest(String data) {
        service.letMeKnow();

        return service.receiveData(data);
    }

}
