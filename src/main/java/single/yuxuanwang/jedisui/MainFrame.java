package single.yuxuanwang.jedisui;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.annotation.PostConstruct;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;

import single.yuxuanwang.jedisui.listener.RemoveActionListener;
import single.yuxuanwang.jedisui.listener.SearchButtonListener;

/**
 * @author wangyuxuan
 * 
 */
public class MainFrame extends JPanel {

	private static final long serialVersionUID = -692415067885658763L;

	@Autowired
	private RemoveActionListener removeActionListener;
	
	@Autowired
	private SearchButtonListener searchButtonListener;

	public MainFrame() {
		super(new GridLayout(1, 1));
	}

	@PostConstruct
	private void init() {
		JPanel dataView = new JPanel(new FlowLayout(FlowLayout.LEADING));
		JTextField searchKey = new JTextField();
		searchKey.setColumns(35);
		JButton findBt = new JButton("搜索");
		JButton deleteBt = new JButton("删除");
		
		ComponentRegedit.register("searchKey", searchKey);
		ComponentRegedit.register("findBt", findBt);
		ComponentRegedit.register("deleteBt", deleteBt);
		ComponentRegedit.register("dataView", dataView);

		findBt.addActionListener(searchButtonListener);
		deleteBt.addActionListener(removeActionListener);

		JPanel inputView = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		inputView.add(searchKey);
		inputView.add(findBt);
		inputView.add(deleteBt);

		final JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

		splitPane.setTopComponent(inputView);
		splitPane.setBottomComponent(dataView);

		splitPane.setDividerSize(3);

		add(splitPane);
	}

}
