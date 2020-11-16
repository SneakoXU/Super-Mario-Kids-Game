import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;


public class Questions {
	
	private Map<String, String> questions = new HashMap<String, String>();

	
	public Questions(Map<String, String> questions) {
		this.questions = questions;
	}


	public Map<String, String> getQuestions() {
		return questions;
	}

	
	
	public void setQuestions(Map<String, String> questions) {
		this.questions = questions;
	}


	public String getRandomQuestion() {
		String gameQuestion = "";
		List<String> questionList = new ArrayList<String>(questions.keySet());
		Random random = new Random();
		gameQuestion = questionList.get(random.nextInt(questionList.size()));
//		String gameQuestion = "";
//		for(String question : questions.keySet()) {
//			gameQuestion = question;
//
//		}
		return gameQuestion;
	}
	
	public boolean userSelectionCheck(Scanner in, String question) {
		boolean result = false;
		if(in.equals(question)) {
			result = true;
		}else {
			result = false;
		}
		return result;
	}
}
