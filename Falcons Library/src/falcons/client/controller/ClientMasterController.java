package falcons.client.controller;

import falcons.utils.LibraryEvent;
import falcons.utils.LibraryEvent.LibraryEventType;

public class ClientMasterController {

	private ClientPreferencesController prefCont;
	private PluginController pluginCont;
	private NetworkController netCont;

	/**
	 * Constructor, instantiates all the sub-controllers.
	 */
	public ClientMasterController() {
		prefCont = new ClientPreferencesController();
		pluginCont = new PluginController();
		netCont = new NetworkController(); //TODO Remove?
	}

	/**
	 * Called by the Client-object when actionPerformed is called from the
	 * ClientView. Determines which type of action was performed and asks the
	 * correct sub-controller to handle it.
	 * 
	 * @param e
	 *            The ClientEvent associated with the action that the View was
	 *            asking for.
	 */
	public void actionPerformed(LibraryEvent e) {
		LibraryEventType type = e.getEventType();
		switch (type) {
		case LOAD_PLUGINS:
			pluginCont.loadPlugins();
			break;
		case READ_PREFERENCES:
			prefCont.readPreferences();
			break;
		case SAVE_PREFERENCES:
			prefCont.savePreferences();
			break;
		default:
			break;
		}
	}

}
