class Question {
	String quest;
	String maxMarks;
	String[] choices;
	int correctAns;
	int penalty;
	Question(String ques , String[] choice, String mm, String corans, String pena) {
		this.quest = ques;
		this.choices = choice;
		this.maxMarks = mm;
		this.correctAns = Integer.parseInt(corans);
		this.penalty = Integer.parseInt(pena);
	}
}