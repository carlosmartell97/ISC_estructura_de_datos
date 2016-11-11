package Lab4;

public interface TournamentTree<Item> {
	Item getWinner();
	void initialize(Item[] a);
	void play(int father, int left, int right);
	void replay(int i);
	String toString();
}
