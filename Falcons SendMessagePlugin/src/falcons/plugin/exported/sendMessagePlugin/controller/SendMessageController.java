package falcons.plugin.exported.sendMessagePlugin.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import falcons.plugin.exported.sendMessagePlugin.view.SendMessageMainPanel;

public class SendMessageController extends AbstractAction {
	
	private SendMessageMainPanel view;

	public SendMessageController(SendMessageMainPanel view) {
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		view.getSendMessageText();
	}

	@Override
	public String toString(){
		return "send";
	}
}