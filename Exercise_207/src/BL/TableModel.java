package BL;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {

    private ArrayList<WeatherStation> stations = new ArrayList<>();

    private static String[] colNames = {"Place", "Sea Level", "Temperature", "rel. Humidity"};
    
    public void add(WeatherStation s)
    {
        stations.add(s);
        sortList();
    }
    
    public void remove(int idx)
    {
        stations.remove(idx);
        sortList();
    }
    
    public void changeTemp(int idx, double newTmp)
    {
        stations.get(idx).setTemperature(newTmp);
        sortList();
    }
    
    public void changeHumi(int idx, int newHumi)
    {
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
    
    public void sortList()
    {
        Collections.sort(stations, new SortByName());
        fireTableDataChanged();
    }

}
