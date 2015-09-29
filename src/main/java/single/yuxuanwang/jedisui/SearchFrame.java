package single.yuxuanwang.jedisui;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.annotation.PostConstruct;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;

import single.yuxuanwang.jedisui.listener.RegexButtonListener;

/**
 * 通配查询Key
 * 
 * @author wangyuxuan
 * 
 */
public class SearchFrame extends JPanel {
	private static final long serialVersionUID = -692415067885658763L;

	@Autowired
	private RegexButtonListener regexButtonListener;
	
	public SearchFrame(){
		super(new GridLayout(1, 1));
	}

	@PostConstruct
	private void init() {
		JPanel regexDataView = new JPanel(new FlowLayout(FlowLayout.LEADING));
		JTextField regexSearchKey = new JTextField();
		regexSearchKey.setColumns(35);
		JButton regexBt = new JButton("模糊查询");
		
		ComponentRegedit.register("regexBt", regexBt);
		ComponentRegedit.register("regexSearchKey", regexSearchKey);
		ComponentRegedit.register("regexDataView", regexDataView);
		
		regexBt.addActionListener(regexButtonListener);

		JPanel inputView = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		inputView.add(regexSearchKey);
		
		JPanel regexBtView = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		regexBtView.add(regexBt);
		
		final JSplitPane inputPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, inputView, regexBtView);
		inputPane.setBorder(BorderFactory.createEmptyBorder());
		
		final JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, inputPane, regexDataView);
		
		splitPane.setDividerSize(3);
		
		add(splitPane);
	}
}
