package Controller;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.rmi.server.LogStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JOptionPane;

import Model.ListAllJournalModel;
import Model.ResearcherLoginModel;
import Model.SeriResearch;
import View.AdminResearcherHome;
import View.AvailableArtcVw;
import View.ListAllJournalView;
import View.ResearchLoginView;

@SuppressWarnings({ "unused", "deprecation" })
public class ResearcherLoginController {
	
	//defining the variable to create instance of view and model
	private ResearchLoginView viewResearch; 
	private ResearcherLoginModel modelResearch;
	
	//controller
	public ResearcherLoginController(ResearchLoginView viewResearch, ResearcherLoginModel modelResearch) {
		this.viewResearch = viewResearch;
		this.modelResearch = modelResearch;
	}

	//method to make the buttons work
	public void researchController() {
		modelResearch.setUserName(viewResearch.getjTUserField().getText());
		modelResearch.setPassword(viewResearch.getjPPassField().getPassword());
		
		//for back reset button
		viewResearch.getjBResetBtn().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				viewResearch.getjTUserField().setText(null);
				viewResearch.getjPPassField().setText(null);
				viewResearch.getBtnGp().clearSelection();
				
			}
		});
		
		//logout button
		viewResearch.getjBLogBtn().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String reName = viewResearch.getjTUserField().getText();
				String rePassword = viewResearch.getjPPassField().getText();
				String memberType = viewResearch.getBtnGp().getSelection().getActionCommand();
				String ResrDatFile = "binaryFiles/Researcher.dat";
				
				//check for the admin
				if(memberType.equals("admin")) {
					if(reName.equals("admin") && rePassword.equals("admin")) {
						JOptionPane.showMessageDialog(null, "Successfully logged in as admin!");
						viewResearch.dispose();
						AdminResearcherHome mainHome = new AdminResearcherHome();
					}
					else {
						JOptionPane.showMessageDialog(null, "Incorrect credentials");
						viewResearch.getjTUserField().setText(null);
						viewResearch.getjPPassField().setText(null);
						viewResearch.getBtnGp().clearSelection();
					}
				}
				//check for the researcher
				if(memberType.equals("researcher")) {
					try {
						if(ResearcherLog(viewResearch)) {
							JOptionPane.showMessageDialog(null, "You're logged in as researcher");
							viewResearch.dispose();
							AvailableArtcVw neAV = new AvailableArtcVw();
						//	VwAftrResearcher neV = new VwAftrResearcher();
						}
						else {
							JOptionPane.showMessageDialog(null, "Incorrect credentials");
							viewResearch.getjTUserField().setText(null);
							viewResearch.getjPPassField().setText(null);
							viewResearch.getBtnGp().clearSelection();
						}
					} catch (HeadlessException e1) {
						
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						
						e1.printStackTrace();
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}
				}
				
			}
		});
		
	}

	//method to read the data stored in researcher file
	@SuppressWarnings("unchecked")
	public boolean ResearcherLog(ResearchLoginView viewResearch) throws IOException, ClassNotFoundException {	
		 boolean logResrch = false;
			ArrayList<SeriResearch> logArr = null;
			try {
				FileInputStream in = new FileInputStream("binaryFiles/Researcher.dat");
				ObjectInputStream obj = new ObjectInputStream(in);
				Object oLgIn = obj.readObject();
				
				logArr = (ArrayList<SeriResearch>)oLgIn;
				
				for(int res=0; res<logArr.size(); res++) {
					modelResearch.setUserName(logArr.get(res).getResUsername());
					modelResearch.setPassword(logArr.get(res).getResPassword());
					if(logResrch=modelResearch.successLog(viewResearch.getResUsrField(), viewResearch.getResPssFld())) {
						break;
					}
					obj.close();
				
				}

			} catch (EOFException e2) {
				e2.printStackTrace();
			}
		
		return logResrch;
		
	}
	

}
