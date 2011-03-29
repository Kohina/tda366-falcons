package falcons.client.model;

import java.util.HashMap;
import java.util.Map;

import falcons.client.abstractions.AbstractPlugin;

public class PluginModel {

	private HashMap<String, AbstractPlugin> pluginMap = new HashMap<String, AbstractPlugin>();

	/**
	 * The Constructor for the PluginModel. Should read the plugin folder and
	 * load all plugins into the pluginMap.
	 */
	public PluginModel() {
		pluginMap.put("SendMessage", new SendMessagePlugin());
	}

	/**
	 * 
	 * @return Returns a map containing all the currently loaded plugins with
	 *         their pluginID as key.
	 */
	public HashMap<String, AbstractPlugin> getPluginMap() {
		return pluginMap;
	}

}
