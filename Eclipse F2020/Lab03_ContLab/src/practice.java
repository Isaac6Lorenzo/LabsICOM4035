import java.util.ArrayList;
import java.util.Set;

public class practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Lab03P1Wrapper.Bag bag = new Lab03P1Wrapper.DynamicBag(1);
		bag.add("Joe");
		bag.add("Kim");
		bag.add("Ned");
		bag.add("Ned");
		bag.add("Joe");
		bag.add("Joe");
		bag.add("Li");
		
		Lab03P1Wrapper.Bag bag2 = bag.moreFrequentThan("Apu");
		Object[] temp = bag2.toArray();
		for (int i = 0; i < temp.length; i++) {
			System.out.println(temp[i]);
		}
		
		ArrayList<Set<Integer>> sets = new ArrayList<Set<Integer>>();
//		System.out.println(Lab03P2Wrapper.checkDisjoint(sets));
//		Lab03P2Wrapper.Set temp1 = new Lab03P2Wrapper.ArraySet();
		

	}

}
