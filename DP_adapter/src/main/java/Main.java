import adaptateur.HdmiVgaAdapter;
import computer.Ecran;
import computer.UniteCentrale;
import tv.Tv;

void main() {
    UniteCentrale uc = new UniteCentrale();

    Ecran ecran = new Ecran();
    uc.setVga(ecran);
    uc.printMessage("Bonjour (via Ecran direct)");


    Tv tv = new Tv();
    HdmiVgaAdapter adapter = new HdmiVgaAdapter();

    // Connect TV to the HDMI side of the adapter
    adapter.setHdmi(tv);

    // Connect the VGA side of the adapter to the computer
    uc.setVga(adapter);

    // The computer still thinks it's talking to a VGA device!
    uc.printMessage("Bonsoir (via Adaptateur vers TV)");
}