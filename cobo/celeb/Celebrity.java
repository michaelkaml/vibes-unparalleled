// Big Bird: Jun Hong Wang, Raven (Ruiwen) Tang, Michael Kamela
// APCS pd6
// L09: Some Folks Call It A Charades / working through the College Board Celebrity lab
// 2022-04-27
// time spent: 3.0 hrs

package celeb;

/**
 * Celebrity base class for the Celebrity game.
 * @author cody.henrichsen
 * @version 1.4 17/09/2018
 */
public class Celebrity
{
	/**
	 * The clue to determine the celebrity
	 */
	private String clue;

	/**
	 * The answer or name of the celebrity.
	 */
	private String name;
	/**
	 * Creates a Celebrity instance with the supplied answer and clue
	 * @param answer
	 * @param clue
	 */
	public Celebrity(String answer, String clue)
	{
		name = answer;
		this.clue = clue;
	}

	/**
	 * Supplies the clue for the celebrity
	 * @return
	 */
	public String getClue()
	{
		return clue;
	}

	/**
	 * Supplies the answer for the celebrity.
	 * @return
	 */
	public String getAnswer()
	{
		return name;
	}

	/**
	 * Updates the clue to the provided String.
	 * @param clue The new clue.
	 */
	public void setClue(String clue)
	{
		this.clue = clue;
	}

	/**
	 * Updates the answer to the provided String.
	 * @param answer The new answer.
	 */
	public void setAnswer(String answer)
	{
		name = answer;
	}

	/**
	 * Provides a String representation of the Celebrity.
	 */
	@Override
	public String toString()
	{
		return name + ":" + clue;
	}

	public static void main(String[] args) {
		Celebrity thing = new Celebrity("bob","a");
		System.out.println(thing);
		thing.setAnswer("answer");
		thing.setClue("clue");
		System.out.println(thing.getClue());
		System.out.println(thing.getAnswer());
	}
}
