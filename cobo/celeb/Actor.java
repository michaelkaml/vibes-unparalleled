// Big Bird: Jun Hong Wang, Raven (Ruiwen) Tang, Michael Kamela
// APCS pd6
// L09: Some Folks Call It A Charades / working through the College Board Celebrity lab
// 2022-04-27
// time spent: 3.0 hrs

package celeb;

import java.util.ArrayList;

public class Actor extends Celebrity {
  private ArrayList<String> bob;

  public Actor(String name, String movies) {
    super(name,movies);
    processClues();
  }

  private void processClues()
	{
		String [] clues = super.getClue().split(",");
		bob = new ArrayList<String>();
		for (String currentClue : clues)
		{
      currentClue = currentClue.trim();
			bob.add(currentClue);
		}
	}

  public String getClue() {
    if (bob.size() > 0) {
      return bob.remove(0);
    }
    return "That's all the clues!";
  }

  public String toString() {
    String e = "The actor was: " + getAnswer() + ". The clues are:\n";
    for (String f: bob) {
      e += f;
    }
    return e;
  }
}
