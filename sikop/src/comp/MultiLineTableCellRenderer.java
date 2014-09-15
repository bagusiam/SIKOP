package comp;

import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;

public class MultiLineTableCellRenderer extends JTextArea implements TableCellRenderer{

	private ArrayList<ArrayList<Integer>> rowColHeight = new ArrayList<ArrayList<Integer>>();
	
	public MultiLineTableCellRenderer() {
		// TODO Auto-generated constructor stub
		setLineWrap(true);
		setWrapStyleWord(true);
		setOpaque(true);
	}
	
	@Override
	public Component getTableCellRendererComponent(JTable arg0, Object arg1,
			boolean arg2, boolean arg3, int arg4, int arg5) {
		// TODO Auto-generated method stub
		if(arg2){
			setForeground(arg0.getSelectionForeground());
			setBackground(arg0.getSelectionBackground());
		}else{
			setForeground(arg0.getForeground());
			setBackground(arg0.getBackground());
		}
		setFont(arg0.getFont());
		if(arg3){
			setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
			if(arg0.isCellEditable(arg4, arg5)){
				setForeground(UIManager.getColor("Table.focusCellForeground"));
				setBackground(UIManager.getColor("Table.focusCellBackground"));
			}
		}else{
			setBorder(new EmptyBorder(1,2,1,2));
		}
		if(arg1 != null){
			setText(arg1.toString());
		}else{
			setText("");
		}
		adjustRowHeight(arg0, arg4, arg5);
		return this;
	}
	
	private void adjustRowHeight(JTable table, int row, int col){
		int cWidth = table.getTableHeader().getColumnModel().getColumn(col).getWidth();
		setSize(new Dimension(cWidth, 1000));
		int prefH = getPreferredSize().height;
		while (rowColHeight.size() <= row) {
			rowColHeight.add(new ArrayList<Integer>(col));
		}
		ArrayList<Integer> colHeight = rowColHeight.get(row);
		while (colHeight.size() <= col) {
			colHeight.add(0);
		}
		colHeight.set(col, prefH);
		int maxh = prefH;
		for (Integer colH : colHeight) {
			if(colH > maxh){
				maxh = colH;
			}
		}
		if(table.getRowHeight(row) != maxh){
			table.setRowHeight(row, maxh);
		}
	}

}
