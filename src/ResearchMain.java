import Controller.ResearcherLoginController;
import Model.ResearcherLoginModel;
import View.ResearchLoginView;

public class ResearchMain {
	public static void main(String[]args) {
		ResearchLoginView reView = new ResearchLoginView();
		ResearcherLoginModel reModel = new ResearcherLoginModel(null, null);
		ResearcherLoginController reController = new ResearcherLoginController(reView, reModel);
		reController.researchController();
		reView.setVisible(true);
		
	}

}
