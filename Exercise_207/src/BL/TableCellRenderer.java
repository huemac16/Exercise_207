package BL;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;

public class TableCellRenderer implements javax.swing.table.TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
        WeatherStation s = (WeatherStation) o;
        JLabel label = new JLabel();
        label.setOpaque(true);

        if (s.getTemperature() > 25 && s.getHumi() < 20) {
            label.setBackground(Color.YELLOW);
        } else if (s.getTemperature() < 0 && s.getHumi() < 30) {
            label.setBackground(Color.BLUE);
        } else if (s.getTemperature() >= 0 && s.getTemperature() <= 25 && s.getHumi() > 50) {
            label.setBackground(Color.GREEN);
        }

        label.setBackground(bln ? Color.DARK_GRAY : label.getBackground());

        if (TableModel.def) {
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
        } else {
            switch (i1) {
                case 0:
                    label.setText(s.getPlace());
                    break;
                case 1:
                    label.setText(String.format("%.1f°", s.getTemperature()));
                    break;
                case 2:
                    label.setText(s.getHumi() + "%");
                    break;
            }

        }

        return label;
    }

}
