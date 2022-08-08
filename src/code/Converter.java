package code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Converter {
	public List<List<Integer>> indexesToInt(Port port) {
		List<List<Integer>> intIndexes = new LinkedList<>();
		for (String index : port.getIndexes()) {
			List<Integer> intIndex = new LinkedList<>();
			for (String element : index.split(",")) {
				if (element.indexOf('-') != -1) {
					String[] bounds = element.split("-");
					for (int i = Integer.parseInt(bounds[0]); i <= Integer.parseInt(bounds[1]); i++) {
						intIndex.add(i);
					}
				} else {
					intIndex.add(Integer.parseInt(element));
				}
			}
			intIndexes.add(intIndex);
		}
		return intIndexes;
	}

	public List<List<Integer>> intIndexesPermutation(Port port) {
		return cartesianProduct(indexesToInt(port));
	}

	private List<List<Integer>> cartesianProduct(List<List<Integer>> lists) {
		List<List<Integer>> resultLists = new ArrayList<>();
		if (lists.size() == 0) {
			resultLists.add(new ArrayList<>());
			return resultLists;
		} else {
			List<Integer> firstList = lists.get(0);
			List<List<Integer>> remainingLists = cartesianProduct(lists.subList(1, lists.size()));
			for (Integer condition : firstList) {
				for (List<Integer> remainingList : remainingLists) {
					ArrayList<Integer> resultList = new ArrayList<>();
					resultList.add(condition);
					resultList.addAll(remainingList);
					resultLists.add(resultList);
				}
			}
		}
		return resultLists;
	}
}
