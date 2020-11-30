
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

public class YouTubeViewer {
	static String link;
	public YouTubeViewer(String url) {
		link=url;
		NativeInterface.open();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("YouTube Viewer");
				frame.getContentPane().add(getBrowserPanel(), BorderLayout.CENTER);
				frame.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						frame.dispose();
					}
				});
				frame.setSize(800, 600);
				frame.setVisible(true);
			}
		});

	}
	
	public static JPanel getBrowserPanel() {
		JPanel webBrowserPanel = new JPanel(new BorderLayout());
		JWebBrowser webBrowser = new JWebBrowser();
		webBrowserPanel.add(webBrowser, BorderLayout.CENTER);
		webBrowser.setBarsVisible(false);    	
		webBrowser.navigate(link);
		return webBrowserPanel;
	}

	
}
