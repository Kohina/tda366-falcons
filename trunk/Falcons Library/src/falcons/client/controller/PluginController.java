package falcons.client.controller;

import falcons.client.model.PluginLogic;
import falcons.client.model.ServerLogic;
import falcons.plugin.AbstractPlugin;
import falcons.plugin.PluginEvent;
import falcons.plugin.PluginEventListener;
import falcons.plugin.PluginEvent.PluginEventType;

class PluginController implements PluginEventListener {

	void loadPlugins(){
		PluginLogic.loadPlugins();
		Object[] keys = PluginLogic.getPluginMap().keySet().toArray();
		for(Object o : keys){
			((AbstractPlugin) PluginLogic.getPluginMap().get(o)).addEventListener(this);
		}
	}

	@Override
	public void actionPerformed(PluginEvent p) {
		PluginEventType e = p.getTypeOfEvent();
		switch (e) {
		case SEND:
			NetworkController.send(p.getPluginCall());
			break;
		default:
			break;
		}
	}

	@Override
	public Object getData(PluginEvent p) {
		PluginEventType e = p.getTypeOfEvent();
		Object returnObject = null;
		switch (e) {
		case GET_CLIENTS:
			returnObject = ServerLogic.getClients();
			break;
		case GET_PLUGINMAP:
			returnObject =  PluginLogic.getPluginMap();
			break;
		default:
			break;
		}
		return returnObject;
	}
}