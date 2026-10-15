package computer;

public class UniteCentrale {
    private Vga vga;

    public void setVga(Vga vga) {
        this.vga = vga;
    }

    public void printMessage(String message) {
        System.out.println("----------");
        System.out.println("Unite Centrale processing...");
        if (vga != null) {
            vga.print(message);
        }
    }
}