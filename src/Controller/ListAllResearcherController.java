package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import Model.AddNewResearcherModel;
import Model.ListAllResearcherModel;
import Model.ResearcherLoginModel;
import View.AdminResearcherHome;
import View.ListAllResearcherView;
import View.ResearchLoginView;

public class ListAllResearcherController {
	ListAllResearcherView listResearcher;
	ListAllResearcherModel researcherListModel;
	AddNewResearcherModel rsEm;
	
	public ListAllResearcherController(ListAllResearcherView listResearcher) {
		this.listResearcher = listResearcher;
	}
	
	public void listResearcherCont() {			
		listResearcher.getjBResBackBtn().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				listResearcher.dispose();
				@SuppressWarnings("unused")
				AdminResearcherHome admHome = new AdminResearcherHome();
				
			}
		});
		listResearcher.getjBLogoutBtn().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				listResearcher.dispose();
				ResearchLoginView reView = new ResearchLoginView();
				ResearcherLoginModel reModel = new ResearcherLoginModel(null, null);
				ResearcherLoginController reController = new ResearcherLoginController(reView, reModel);
				reController.researchController();
				reView.setVisible(true);
				
			}
		});
		listResearcher.getjBResEditBtn().addActionListener(new ActionListener() {
			
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				AddNewResearcherModel rsrchMod = new AddNewResearcherModel();
				//check if the fields are empty or not
				if(listResearcher.getRsrchId().isEmpty()||
						listResearcher.getRsrchNme().isEmpty()||
						listResearcher.getRsrchAddrss().isEmpty()||
						listResearcher.getRsrchPhne().isEmpty()||
						listResearcher.getRsrchEml().isEmpty()||
						listResearcher.getRsrchUsrnme().isEmpty()||
						listResearcher.getRsrchPsswrd().isEmpty()) {
					JOptionPane.showMessageDialog(null, "You have to select one row to modify the data!");
				}
				else {
					//check if the entered email is valid or not
					if(rsEm.validEmail1(listResearcher.getRsrchEml())) {
						try {
							rsrchMod.reserChnge(listResearcher, listResearcher.getReserNum());
							JOptionPane.showMessageDialog(null, "Data changed!");
							listResearcher.dispose();
							listResearcher = new ListAllResearcherView();
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					}
					else {
						listResearcher.getjLEmErr().setText("Enter the valid email!");
					}
				}
				
			}
		});
		
		listResearcher.getjBResDeltBtn().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				AddNewResearcherModel modRers = new AddNewResearcherModel();
				
				if(listResearcher.getRsrchId().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Id must be selected");
				}
				else {
					try {
						modRers.reserDelt(listResearcher, listResearcher.getReserNum());
						listResearcher.dispose();
						listResearcher = new ListAllResearcherView();
				
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
			}
		});
		
		researcherListModel = new ListAllResearcherModel();
		JScrollPane j = researcherListModel.getjSResearch();
		listResearcher.setjTabResearchTable(researcherListModel.getResearchTab());
		listResearcher.setjSResearchPane(j);

	}

}
