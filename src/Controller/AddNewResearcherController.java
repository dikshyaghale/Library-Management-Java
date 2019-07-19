package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.AddNewResearcherModel;
import Model.ResearcherLoginModel;
import View.AddNewResearcherView;
import View.AdminResearcherHome;
import View.ListAllResearcherView;
import View.ResearchLoginView;

public class AddNewResearcherController {
	AddNewResearcherView researcherAddHome;
	AddNewResearcherModel newResModel = new AddNewResearcherModel();
	
	public AddNewResearcherController(AddNewResearcherView researcherAddHome) {
		this.researcherAddHome = researcherAddHome;
	}

	public void addResearchCont() {
		researcherAddHome.getjBBackBtn().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
			
				researcherAddHome.dispose();
				AdminResearcherHome admView = new AdminResearcherHome();
				
			}
		});
		researcherAddHome.getjBSignoutBtn().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				researcherAddHome.dispose();
				ResearchLoginView reView = new ResearchLoginView();
				ResearcherLoginModel reModel = new ResearcherLoginModel(null, null);
				ResearcherLoginController reController = new ResearcherLoginController(reView, reModel);
				reController.researchController();
				reView.setVisible(true);
			}
		});
		researcherAddHome.getjBResearchClear().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
		//		researcherAddHome.getjTIdField().setText(null);
				researcherAddHome.getjTResAddress().setText(null);
				researcherAddHome.getjTResEmail().setText(null);
				researcherAddHome.getjTResName().setText(null);
//				researcherAddHome.getjTResPassword().setText(null);
				researcherAddHome.getjPRePass().setText(null);
				researcherAddHome.getjTResPhone().setText(null);
				researcherAddHome.getjTResTUsername().setText(null);
				researcherAddHome.getjLErr().setText("");
				researcherAddHome.getjLPhneErr().setText("");
				
			}
		});
		researcherAddHome.getjBAddBtn().addActionListener(new ActionListener() {
		
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				if(researcherAddHome.getjTIdField().getText().isEmpty() || researcherAddHome.getjTResName().getText().isEmpty() || researcherAddHome.getjTResAddress().getText().isEmpty() || researcherAddHome.getjTResPhone().getText().isEmpty() || researcherAddHome.getjTResEmail().getText().isEmpty() || researcherAddHome.getjTResTUsername().getText().isEmpty() || researcherAddHome.getjPRePass().getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Fill all form");
				}
				else {
					if(newResModel.validEmail1(researcherAddHome.getjTResEmail().getText())) {
						newResModel.addResMod(researcherAddHome);
						JOptionPane.showMessageDialog(null, "Researcher Added");
						researcherAddHome.dispose();
						ListAllResearcherView v = new ListAllResearcherView();
					}
					else {
						researcherAddHome.getjLErr().setText("Please enter valid email");
						JOptionPane.showMessageDialog(null, "Enter valid informations");
					}
				
				}
				
			}
		});
		researcherAddHome.rshInc();
	}

}
