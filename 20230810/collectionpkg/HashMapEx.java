package collectionpkg;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapEx {

	public static void main(String[] args) {
		String[] names = {"hong", "kim", "lee", "kang", "kim"};
		int[] nums = {1234, 4567, 2350, 9807, 2345};
		
		Map map = new HashMap();
		for (int i=0; i<names.length; i++) {
			map.put(names[i], nums[i]);
		}
		
		Collection values = map.values();
		for (Object v : values) {
			System.out.print(v + " "); // 중복 key에는 마지막 키가 들어감
		}
		
		System.out.println();
		
		Iterator it = values.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " "); // 중복 key에는 마지막 키가 들어감
		}
		
		System.out.println();
		
//		key
		Set keys = map.keySet();
		for (Object k : keys) {
			System.out.print(k + ": " + map.get(k) + " "); // 중복 key가 없어 Set 자료형 사용 가능
		}
		
		System.out.println();
		
		it = keys.iterator();
		while (it.hasNext()) {
			Object o = it.next();
			System.out.print(o + ": " + map.get(o) + " "); // 중복 key가 없어 Set 자료형 사용 가능
		}
		
		System.out.println();
		
//		entrySet()
//		key, value => Map.Entry
		Set entry = map.entrySet();
		for (Object o : entry) {
			Map.Entry m = (Map.Entry) o;
			System.out.println(m.getKey() + ": " + m.getValue());
		}
	}

}
