package com.zhc.commonjava.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MapTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(MapTest.class);

	public static void main(String[] args) {
		Map<String, Object> application = new HashMap<>();
		application.put("commons.redis.host", "111--application");
		application.put("commons.redis.port", "6379--application");

		Map<String, Object> service = new HashMap<>();
		service.put("commons.redis.host", "222--service");
		service.put("commons.redis.expire", "6379--service");

		Map<String, Object> version = new HashMap<>();
		version.put("commons.redis.host", "333--version");
		version.put("commons.redis.password", "password--version");

		Map<String, Object> tag = new HashMap<>();
		tag.put("commons.redis.host", "444--tag");
		tag.put("commons.redis.maxIdle", "3--tag");

		Map<String, Map<String, Object>> items = new LinkedHashMap<String, Map<String, Object>>();
		items.put("provider@helloworld#0.0.1!test", tag);
		items.put("application", application);
		items.put("provider@helloworld#0.0.1", version);
		items.put("provider@helloworld", service);

		Map<String, Object> map1 = MapTest.merge(items);

		map1.keySet().stream().forEach(n -> System.out.println(n + ":" + map1.get(n)));
	}

	public static Map<String, Object> merge(Map<String, Map<String, Object>> items) {
		Map<String, Object> flatMap = new HashMap<>();
		Set<String> keySet = items.keySet();
		if (keySet.contains("application")) {
			flatMap.putAll(items.get("application"));
			keySet.remove("application");
		}
		if (!keySet.isEmpty()) {
			TreeSet<String> sortedKeys = new TreeSet<String>(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return o1.length() - o2.length();
				}
			});
			sortedKeys.addAll(keySet);
			sortedKeys.forEach(key -> flatMap.putAll(items.get(key)));
		}
		return flatMap;
	}

}
