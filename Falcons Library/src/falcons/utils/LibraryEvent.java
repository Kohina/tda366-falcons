package falcons.utils;

public class LibraryEvent {

	public static enum LibraryEventType {
		/*
		 * 
		 * ClientPreferencesEvents
		 * 
		 */
		/**
		 * Tells the controller that it should save the preferences currently
		 * loaded
		 */
		SAVE_PREFERENCES,
		/**
		 * Tells the controller that is should read the preferences from the ClientPreferences.xml
		 */
		READ_PREFERENCES,		
		/*
		 * 
		 * PluginEvents
		 * 
		 */
		/**
		 * Tells the controller that it should load all plugins inside the "/plugins/" folder.
		 */
		LOAD_PLUGINS
	}

	private LibraryEventType typeOfEvent;

	/**
	 * Creates a new ClientEvent that to be sent to the Client's controller.
	 * 
	 * @param e
	 *            This parameter is a ClientEventType. Each Type has a specified
	 *            meaning and this will tell the controller what to do.
	 */
	public LibraryEvent(LibraryEventType e) {
		typeOfEvent = e;
	}

	/**
	 * Returns what type of event this is.
	 * 
	 * @return The type of event, specified by a ClientEventType.
	 */
	public LibraryEventType getEventType() {
		return typeOfEvent;
	}

}