package single.yuxuanwang.jedisui;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wangyuxuan
 * 
 */
public class FrameInitail {
	
	@Autowired
	private MainFrame mainFrame;
	
	@Autowired
	private SearchFrame searchFrame;
	
	public void showMainFrame() {
		JFrame frame = new JFrame("Jedis GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 600);
		
		final JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		
		splitPane.setDividerSize(5);
		splitPane.setDividerLocation(500);
		
		splitPane.setLeftComponent(mainFrame);
		splitPane.setRightComponent(searchFrame);
		
		frame.add(splitPane);
		
		frame.setLocationRelativeTo(null);

		frame.setVisible(true);
	}

}
