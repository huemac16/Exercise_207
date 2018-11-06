package BL;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;

public class TableCellRenderer implements javax.swing.table.TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
        WeatherStation s = (WeatherStation) o;
        JLabel label = new JLabel();
        label.setOpaque(true);

        switch (i1) {
            case 0:
                label.setText(s.getPlace());
                break;
            case 1:
                label.setText(s.getSeaLevel() + "m");
                break;
            case 2:
                label.setText(String.format("%.1f°", s.getTemperature()));
                break;
            case 3:
                label.setText(s.getHumi() + "%");
                break;
        }

        return label;
    }

}
