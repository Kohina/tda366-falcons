package falcons.client.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

import falcons.plugin.manager.DataInterpreter;
import falcons.plugin.manager.PluginCall;
import falcons.plugin.manager.PluginModel;

public class ListeningThread extends Thread {

	private ObjectInputStream in;
	private DataInterpreter interpreter;
	
	public ListeningThread(InputStream in){
		try {
			this.in = new ObjectInputStream(in);
		} catch (IOException e) {
			System.err.println("Could not get connect to InputStream.");
			e.printStackTrace();
		}
		interpreter = interpreter.getInstance(false);
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