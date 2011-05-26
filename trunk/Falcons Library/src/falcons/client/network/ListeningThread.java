package falcons.client.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import falcons.plugin.PluginCall;

public class ListeningThread extends Thread {

	private ObjectInputStream in;
	private ClientDataInterpreter interpreter;
	
	public ListeningThread(InputStream in){
		try {
			this.in = new ObjectInputStream(in);
		} catch (IOException e) {
			System.err.println("Could not get connect to InputStream.");
			e.printStackTrace();
		}
		interpreter = interpreter.getInstance();
	}
	
	public void run(){
		try {
			PluginCall call;
			while ((call = (PluginCall) in.readObject()) != null) {
				interpreter.interpret(call);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}