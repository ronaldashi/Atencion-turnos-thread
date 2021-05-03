package edu.uptc.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.uptc.models.Management;
import edu.uptc.view.Actions;
import edu.uptc.view.MainStadistics;

public class Control implements ActionListener{
	private Management management;
	private Actions actions;
	
	public Control(Actions actions) {
		this.actions = actions;
		management=new Management();
		actions.show(management.showData(), Actions.ACTIVATE);
		run();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case Actions.ACCEPT:
			String[] input = actions.catchInfo(Actions.ACCEPT);	
			input[2] = management.turn(input[1]);
			actions.message(management.addUser(input[0], input[1], input[2]));
			actions.extraMethod(Actions.ACCEPT);
			actions.activate(Actions.ACCEPT);
			new Thread(( ) -> {
				while(true) {
					actions.extraMethod(Actions.WAITINGROOM);
					actions.show(management.showUsers(), Actions.ACCEPT);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			}).start();
		break;
		case Actions.STADISTICS:
			
			
			actions.extraMethod(Actions.STADISTICS);
			actions.activate(Actions.STADISTICS);
			actions.show(management.showStadistics(), Actions.STADISTICS);
		break;
		default:
			break;
		}
	}	
	
	private void run() {
		actions.activate(Actions.RUNMODULES);
		new Thread(( ) -> {
			while(true) {
				actions.extraMethod(Actions.RUNMODULES);
				actions.show(management.showData(), Actions.RUNMODULES);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}).start();
	}
}