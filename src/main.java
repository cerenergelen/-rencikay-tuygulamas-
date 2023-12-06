import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuForm());
    }
}

class Ders {
    private String dersKodu;
    private String dersAd;
    private String dersDonem;

    public Ders() {
    }

    public Ders(String dersKodu, String dersAd, String dersDonem) {
        this.dersKodu = dersKodu;
        this.dersAd = dersAd;
        this.dersDonem = dersDonem;
    }

    public String getDersKodu() {
        return dersKodu;
    }

    public void setDersKodu(String dersKodu) {
        this.dersKodu = dersKodu;
    }

    public String getDersAd() {
        return dersAd;
    }

    public void setDersAd(String dersAd) {
        this.dersAd = dersAd;
    }

    public String getDersDonem() {
        return dersDonem;
    }

    public void setDersDonem(String dersDonem) {
        this.dersDonem = dersDonem;
    }

    @Override
    public String toString() {
        return "{" +
                "\"dersKodu\":\"" + dersKodu + "\"," +
                "\"dersAd\":\"" + dersAd + "\"," +
                "\"dersDonem\":\"" + dersDonem + "\"" +
                "}";
    }
}

class Ogrenci {
    private String ogrenciNo;
    private String ogrenciAd;
    private String ogrenciSoyad;
    private String ogrenciBolum;
    private List<Ders1> ogrenciDersler;

    public Ogrenci() {
        ogrenciDersler = new ArrayList<>();
    }

    public String getOgrenciNo() {
        return ogrenciNo;
    }

    public void setOgrenciNo(String ogrenciNo) {
        this.ogrenciNo = ogrenciNo;
    }

    public String getOgrenciAd() {
        return ogrenciAd;
    }

    public void setOgrenciAd(String ogrenciAd) {
        this.ogrenciAd = ogrenciAd;
    }

    public String getOgrenciSoyad() {
        return ogrenciSoyad;
    }

    public void setOgrenciSoyad(String ogrenciSoyad) {
        this.ogrenciSoyad = ogrenciSoyad;
    }

    public String getOgrenciBolum() {
        return ogrenciBolum;
    }

    public void setOgrenciBolum(String ogrenciBolum) {
        this.ogrenciBolum = ogrenciBolum;
    }

    public void ogrenciDersEkle(Ders1 ders) {
        ogrenciDersler.add(ders);
    }

    @Override
    public String toString() {
        StringBuilder derslerString = new StringBuilder("[");
        for (Ders1 ders : ogrenciDersler) {
            derslerString.append(ders.toString()).append(",");
        }
        if (derslerString.length() > 1) {
            derslerString.deleteCharAt(derslerString.length() - 1);
        }
        derslerString.append("]");

        return "{" +
                "\"ogrenciNo\":\"" + ogrenciNo + "\"," +
                "\"ogrenciAd\":\"" + ogrenciAd + "\"," +
                "\"ogrenciSoyad\":\"" + ogrenciSoyad + "\"," +
                "\"ogrenciBolum\":\"" + ogrenciBolum + "\"," +
                "\"ogrenciDersler\":" + derslerString.toString() +
                "}";
    }
}

class MenuForm extends JFrame {

    public MenuForm() {
        setTitle("öğrenci kayıt uygulaması");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        JButton dersKayitButton = new JButton("Ders Kayıt Formu");
        JButton ogrenciKayitButton = new JButton("Öğrenci Kayıt Formu");

        dersKayitButton.addActionListener(e -> new DersKayitForm());
        ogrenciKayitButton.addActionListener(e -> new OgrenciKayitForm());

        setLayout(new GridLayout(2, 1));
        add(dersKayitButton);
        add(ogrenciKayitButton);

        setVisible(true);
    }
}


class Ders1 {
    private String dersKodu;
    private String dersAd;
    private String dersDonem;

    public Ders1() {
    }

    public Ders1(String dersKodu, String dersAd, String dersDonem) {
        this.dersKodu = dersKodu;
        this.dersAd = dersAd;
        this.dersDonem = dersDonem;
    }

    public String getDersKodu() {
        return dersKodu;
    }

    public String getDersAd() {
        return dersAd;
    }

    @Override
    public String toString() {
        return dersKodu + ": " + dersAd;
    }

    public Object getDersDonem() {
        return null;
    }
  }


class OgrenciKayitForm extends JFrame {
    private JTextField ogrenciNoField;
    private JTextField ogrenciAdField;
    private JTextField ogrenciSoyadField;
    private JTextField ogrenciBolumField;
    private JComboBox<String> derslerComboBox;
    private final List<Ders1> dersListesi;

    public OgrenciKayitForm() {
        setTitle("Öğrenci Kayıt Formu");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 250);
        setLocationRelativeTo(null);

        ogrenciNoField = new JTextField(20);
        ogrenciAdField = new JTextField(20);
        ogrenciSoyadField = new JTextField(20);
        ogrenciBolumField = new JTextField(20);

        dersListesi = new ArrayList<>();
        dersListesi.add(new Ders1("101", "Elektronik", "2023-1"));
        dersListesi.add(new Ders1("102", "Nesneye Dayalı Programlama", "2023-1"));
        dersListesi.add(new Ders1("103", "Görsel Programlama", "2023-1"));

        derslerComboBox = new JComboBox<>();
        for (Ders1 ders : dersListesi) {
            derslerComboBox.addItem(ders.getDersAd());
        }

        JButton kaydetButton = new JButton("Kaydet");
        kaydetButton.addActionListener(e -> kaydet());

        setLayout(new GridLayout(6, 2));
        add(new JLabel("Öğrenci No:"));
        add(ogrenciNoField);
        add(new JLabel("Öğrenci Adı:"));
        add(ogrenciAdField);
        add(new JLabel("Öğrenci Soyadı:"));
        add(ogrenciSoyadField);
        add(new JLabel("Bölüm:"));
        add(ogrenciBolumField);
        add(new JLabel("Dersler:"));
        add(derslerComboBox);
        add(new JLabel(""));
        add(kaydetButton);

        setVisible(true);
    }

    private void kaydet() {
        String ogrenciNo = ogrenciNoField.getText();
        String ogrenciAd = ogrenciAdField.getText();
        String ogrenciSoyad = ogrenciSoyadField.getText();
        String ogrenciBolum = ogrenciBolumField.getText();

        if (ogrenciNo.isEmpty() || ogrenciAd.isEmpty() || ogrenciSoyad.isEmpty() || ogrenciBolum.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Lütfen tüm alanları doldurun!", "Hata", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String secilenDersAdi = (String) derslerComboBox.getSelectedItem();
        Ders1 secilenDers = null;
        for (Ders1 ders : dersListesi) {
            if (ders.getDersAd().equals(secilenDersAdi)) {
                secilenDers = ders;
                break;
            }
        }

        if (secilenDers != null && secilenDers.getDersDonem().equals("2023-1")) {
            Ogrenci ogrenci = new Ogrenci();
            ogrenci.setOgrenciNo(ogrenciNo);
            ogrenci.setOgrenciAd(ogrenciAd);
            ogrenci.setOgrenciSoyad(ogrenciSoyad);
            ogrenci.setOgrenciBolum(ogrenciBolum);
            ogrenci.ogrenciDersEkle(secilenDers);

            kaydetJSON("ogrenci.json", ogrenci.toString());
            JOptionPane.showMessageDialog(this, "Öğrenci kaydedildi!");
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Geçersiz ders seçimi veya dönem! Lütfen tekrar deneyiniz.", "Hata", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        ogrenciNoField.setText("");
        ogrenciAdField.setText("");
        ogrenciSoyadField.setText("");
        ogrenciBolumField.setText("");
    }

    private void kaydetJSON(String dosyaAdi, String icerik) {
        try (FileWriter writer = new FileWriter(dosyaAdi, true)) {
            writer.write(icerik + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
