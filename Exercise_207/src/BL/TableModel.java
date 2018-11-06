package BL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {

    private ArrayList<WeatherStation> stations = new ArrayList<>();

    private static String[] colNames = {"Place", "Sea Level", "Temperature", "rel. Humidity"};

    public void add(WeatherStation s) {
        stations.add(s);
        sortList();
    }

    public void remove(int[] values) {
        for (int i = 0; i < values.length; i++) {
            stations.remove(values[i]);
        }
        sortList();
    }

    public void changeTemp(int idx, double newTmp) throws Exception {
        stations.get(idx).setTemperature(newTmp);
        sortList();
    }

    public void changeHumi(int idx, int newHumi) throws Exception {
        stations.get(idx).setHumi(newHumi);
        sortList();
    }

    @Override
    public int getRowCount() {
        return stations.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        WeatherStation s = stations.get(i);
        return s;
    }

    @Override
    public String getColumnName(int i) {
        return colNames[i];
    }

    public void sortList() {
        Collections.sort(stations, new SortByName());
        fireTableDataChanged();
    }

    public void save(File f) throws FileNotFoundException, IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        for (WeatherStation s : stations) {
            oos.writeObject(s);

        }

        oos.flush();
        oos.close();
    }

    public void load(File f) throws FileNotFoundException, IOException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        Object o;
        try {
            while ((o = ois.readObject()) != null) {
                stations.add((WeatherStation) o);
            }
            sortList();

        } catch (Exception e) {
        }

        ois.close();
    }

}
