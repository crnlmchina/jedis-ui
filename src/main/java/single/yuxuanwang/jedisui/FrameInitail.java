package single.yuxuanwang.jedisui;

import java.awt.Label;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
	
	private String shards;
	
	public void showMainFrame() {
		JFrame frame = new JFrame("Jedis GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 600);
		
		final JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, mainFrame, searchFrame);
		splitPane.setDividerLocation(500);
		splitPane.setBorder(BorderFactory.createEmptyBorder());
		
		final Label info = new Label("Shards: " + shards);
		final JPanel infoFrame = new JPanel();
		infoFrame.add(info);
		
		final JSplitPane topPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, infoFrame, splitPane);
		
		frame.add(topPane);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public void setShards(String shards) {
		this.shards = shards;
	}

}
