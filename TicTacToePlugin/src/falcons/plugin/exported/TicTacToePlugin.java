package falcons.plugin.exported;

import java.io.Serializable;
import java.util.Observable;

import javax.swing.JPanel;

import falcons.plugin.AbstractPlugin;
import falcons.plugin.AbstractPluginData;
import falcons.plugin.Pluggable;
import falcons.plugin.Plugin;
import falcons.plugin.PluginCall;
import falcons.plugin.exported.ticTacToePlugin.controller.TicTacToeController;
import falcons.plugin.exported.ticTacToePlugin.model.TicTacToeLogic;
import falcons.plugin.exported.ticTacToePlugin.model.TicTacToeModel;
import falcons.plugin.exported.ticTacToePlugin.view.TicTacToeMainPanel;

@Plugin(pluginID = "TicTacToePlugin", versionID = "0.1")
public class TicTacToePlugin extends AbstractPlugin{

	private TicTacToeModel model;
	private TicTacToeLogic logic;
	private TicTacToeMainPanel mainPanel;
	private TicTacToeController cont;

	public TicTacToePlugin() {
		model = new TicTacToeModel();
		logic = new TicTacToeLogic(model);
		mainPanel = new TicTacToeMainPanel();
		cont = new TicTacToeController(mainPanel, logic);
		mainPanel.addActionListener(cont);
	}
	
	@Override
	public void receiveCall(PluginCall call) {
		int data = (Integer) call.getPluginData().getData();
		
		if (call.getPluginData().getMethodID().equals("turn")) {
			cont.turn(data, false);
		}
	}

	@Override
	public JPanel getMainPanel() {
		return mainPanel;
	}
}