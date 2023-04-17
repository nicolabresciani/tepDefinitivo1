import java.awt.*;
import javax.swing.*;
public class Grafica {
    public JPanel industria;
    public JFrame f;
    public JLabel braccio;
    public JPanel immagineBraccio;
    public JLabel braccioSpecchiato;
    public JLabel carrello;
    public JLabel scatolotto; //case computer
    public JLabel discoFisso;
    public JLabel memoriaRam;
    public JLabel schedaMadre;
    public JLabel schedaVideo;
    public JLabel ventola;
    public Grafica(){
        industria = new JPanel();
        industria.setSize(900, 900);
        industria.setVisible(true);
        braccio = new JLabel(new ImageIcon("src/braccio meccanico.jpg"));
        braccioSpecchiato = new JLabel(new ImageIcon("src/braccio meccanico specchiato.jpg"));
        carrello = new JLabel(new ImageIcon("src/carrello.png"));
        scatolotto = new JLabel(new ImageIcon("src/case.jpg"));
        discoFisso  = new JLabel(new ImageIcon("src/discoFisso.jpg"));
        memoriaRam = new JLabel(new ImageIcon("src/memoriaRam.jpg"));
        schedaMadre = new JLabel(new ImageIcon("src/schedaMadre.jpg"));
        schedaVideo = new JLabel(new ImageIcon("src/schedaVideo.jpg"));
        ventola = new JLabel(new ImageIcon("src/ventola.jpg"));
        init();
        initPannelli();
    }
    public void init(){
        industria.setLocation(100, 500);
        braccio.setVisible(true);
        braccioSpecchiato.setVisible(false);
        carrello.setVisible(true);
        scatolotto.setVisible(false);
        discoFisso.setVisible(false);
        memoriaRam.setVisible(false);
        schedaVideo.setVisible(false);
        schedaMadre.setVisible(false);
        ventola.setVisible(false);
        industria.add(braccio);
        industria.add(braccioSpecchiato);
        industria.add(carrello);
        industria.add(scatolotto);
        industria.add(discoFisso);;
        industria.add(memoriaRam);
        industria.add(schedaMadre);
        industria.add(schedaVideo);
        industria.add(ventola);
        f = new JFrame();
        f.setSize(2000, 2000);
        f.setVisible(true);
        f.add(industria);
    }
    public void initPannelli(){
        immagineBraccio = new JPanel();
        immagineBraccio.add(braccio);
        immagineBraccio.setLocation(0, 500);
        f.add(immagineBraccio);
    }
}
