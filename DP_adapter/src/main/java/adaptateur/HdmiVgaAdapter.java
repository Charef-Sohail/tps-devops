package adaptateur;

import computer.Vga;
import tv.Hdmi;

public class HdmiVgaAdapter implements Vga {
    private Hdmi hdmi;

    public void setHdmi(Hdmi hdmi) {
        this.hdmi = hdmi;
    }

    @Override
    public void print(String message) {
        System.out.println("~~~~ Adaptateur en action ~~~~");
        byte[] data = message.getBytes();
        hdmi.view(data);
    }
}
