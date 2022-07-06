package ds.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortAsPerOccurance {

	public static void main(String a[]) {
		int[] c= {1,6,2,2,1,3,6,4,4,4};
        sortBasedOnOccuranceOfElement(c);
	}

    private static void sortBasedOnOccuranceOfElement(int[] c) {

        Map<Integer,Integer> occuranceCount = Arrays.stream(c).boxed()
                .collect(Collectors.toMap(i-> i, i-> Integer.valueOf(1), (oldValue, newValue)->oldValue+newValue));

        List<Map.Entry<Integer,Integer>> entrylist = new ArrayList<>(occuranceCount.entrySet());

        Collections.sort(entrylist, (a, b)->{
            if (a.getValue() > b.getValue())
                return -1;
            else if (a.getValue() < b.getValue())
                return 1;
            else
            {
                if (a.getKey()>b.getKey())
                    return -1;
                else if (a.getKey()<b.getKey())
                    return 1;
                else
                    return 0;
            }
        });

        for (Map.Entry<Integer,Integer> e : entrylist){
            System.out.println("Key: "+e.getKey() +" Value: "+e.getValue());
        }
    }
}

