package hw;

import hw.services.DefaultService;

public class Main {
    public static void main(String[] args) {
        String text = "banana";
        DefaultService defaultService = new DefaultService();

        defaultService.option1(text);
        defaultService.option2(text);
    }
}
