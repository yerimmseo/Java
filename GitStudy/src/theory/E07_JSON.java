package theory;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class E07_JSON {

	/*
		# JSON
		- JavaScript의 Object타입과 굉장히 유사한 형태의 데이터 표현 방식
		- 문자열만으로 다양한 데이터를 간결하게 표현할 수 있어서 인기가 많다
		- { "Key" : Value, "Key" : Value, ... }
		
		# JSON의 Value에 표현 가능한 타입들
		- '', "" : String
		- 숫자, 소수 : Number
		- [] : Array
		- {} : Object (JAVA의 Map)
	*/
//	File fileMap = new File("./data/myMap.json");
//	
//	public String mapToJsonStr(HashMap<String, Object> map) {
//		StringBuilder str = new StringBuilder();
//		int j = 0;
//		str.append("{\n");
//		for (String key : map.keySet()) {
//			Object value = map.get(key);
//			
//			if (value instanceof Object[]) {
//				Object[] arr = (Object[])value;
//				
//				str.append("\"" + key + "\"" + ": [");
//				for (int i = 0; i < arr.length; i++) {
//					if (arr[i] instanceof String) {
//						if (i == arr.length - 1) {
//							str.append("\"" + arr[i] + "\"");
//						} else {
//							str.append("\"" + arr[i] + "\"" + ", ");
//						}
//					} else {
//						if (i == arr.length - 1) {
//							str.append(arr[i]);
//						} else {
//							str.append(arr[i] + ", ");
//						}
//					}
//				}
//				str.append("]");
//			} else if (value instanceof String) {
//				str.append("\"" + key + "\"" + ": " + "\"" + value + "\"");
//			} else {
//				str.append("\"" + key + "\"" + ": " + value);
//			}
//			if (j++ != map.size() - 1) {
//				str.append(",\n");
//			} else {
//				str.append("\n");
//			}
//		}
//		str.append("}");
//		return str.toString();
//	}
//	
//	public void mapToJsonFile(HashMap<String, Object> myMap) {
//		String str = mapToJsonStr(myMap);
//		
//		try (FileWriter fw = new FileWriter(fileMap, Charset.forName("UTF-8"))) {
//			
//			fw.append(str);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public HashMap<String, Object> fileToMap() {
//		HashMap<String, Object> myMap = new HashMap<>();
//		ArrayList<String> keyList = new ArrayList<>();
//		ArrayList<String> valueList = new ArrayList<>();
//		StringBuilder sb = new StringBuilder();
//		
//		try (FileReader in = new FileReader(fileMap, Charset.forName("UTF-8"))) {
//			
//			char[] buff = new char[2048];
//			
//			int len = -1;
//			while ((len = in.read(buff)) != -1) {
//				sb.append(new String(buff, 0, len));
//			}
//			String str = sb.toString();
//			System.out.println(str);
//			
//			Pattern regexOfKey = Pattern.compile("[\\w]*\":");
//			Pattern regexOfValue = Pattern.compile(":\s\\[?[가-힣-\\w\"\s,]*\\]?");
//			Matcher matchKey = regexOfKey.matcher(str);
//			Matcher matchValue = regexOfValue.matcher(str);
//			
//			while (matchKey.find()) {
//				String[] keys = matchKey.group().split("\":");
//				for (String key : keys) {
//					keyList.add(key);
//				}
//			}
//			
//			while (matchValue.find()) {
//				String[] values = matchValue.group().split(":\s"); 
//				for (String value : values) {
//					if (!value.isBlank() && value.endsWith(",")) {
//						valueList.add(value.substring(0, value.length() - 1));
//					} else if (!value.isBlank() && !value.endsWith(",")) {
//						valueList.add(value);
//					}
//				}
//			}
//			
//			for (int i = 0; i < keyList.size(); i++) {
//				String value = valueList.get(i);
//				String key = keyList.get(i);
//				
//				if (value.contains("[") && value.contains("]") && value.contains("\"")) {
//					Pattern regexStr = Pattern.compile("[\\w]+");
//					Matcher matchStr = regexStr.matcher(value);
//					
//					ArrayList<String> strList = new ArrayList<>();
//					
//					int count = 0;
//					while (matchStr.find()) {
//						strList.add(matchStr.group());
//						count++;
//					}
//					
//					String[] strArr = new String[count];
//					
//					for (int j = 0; j < count; j++) {
//						strArr[j] = strList.get(j);
//					}
//					myMap.put(key, strArr);
//				} else if (value.contains("[") && value.contains("]")) {
//					Pattern regexOfInt = Pattern.compile("[0-9]+");
//					Matcher matchInt = regexOfInt.matcher(value);
//					
//					ArrayList<Integer> intList = new ArrayList<>();
//					
//					int count = 0;
//					while (matchInt.find()) {
//						Integer num = Integer.parseInt(matchInt.group());
//						intList.add(num);
//						count++;
//					}
//					
//					Integer[] intArr = new Integer[count];
//					
//					for (int j = 0; j < count; j++) {
//						intArr[j] = intList.get(j);
//					}
//					myMap.put(key, intArr);
//				} else if (value.contains("\"")){
//					myMap.put(key, value.substring(1, value.length() - 1));
//				} else if (value.equals("null")) {
//					myMap.put(key, null);
//				} else {
//					myMap.put(key, Integer.parseInt(value));
//				}
//			}
//					
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return myMap;
//	}
	
	public static void main(String[] args) {
		
		// myMap에 저장된 데이터들을 JSON형태의 문자열로 만들어 파일에 출력하는 메서드를 만들어보세요
		// (확장자는 .json)
		HashMap<String, Object> myMap = new HashMap<>();
		
		myMap.put("name", "홍길동");
		myMap.put("age", 123);
		myMap.put("tel", "010-1234-1234");
		myMap.put("tel2", null);
		myMap.put("language", new String[] {"C", "JAVA", "JavaScript", "React"});
		myMap.put("lotto", new Integer[] {1, 2, 3, 4, 5, 6, 7});
		System.out.println(myMap);
		
//		E07_JSON json = new E07_JSON();
//		json.mapToJsonFile(myMap);

		// 작성된 파일의 내용을 다시 JAVA 맵으로 로드하는 메서드를 만들어보세요
//		HashMap<String, Object> testMap = json.fileToMap();
//		System.out.println(testMap.entrySet());
		
		mapToJsonFile(myMap);
		Map<String, Object> map = readJsonFile("./data/json/json.json");
		
		System.out.println(map);
		System.out.println(map.get("age") instanceof Integer); 
		
	}
	
	public static Map<String, Object> readJsonFile(String path) {
		File jsonFile = new File(path);
		StringBuilder sb = new StringBuilder();
		
		// FileReader in = new FileReader(jsonFile, Charset.forname("UTF-8"))
		try (FileReader in = new FileReader(jsonFile)) {
			
			char[] buff = new char[2048];
			
			int len = -1;
			while ((len = in.read(buff)) != -1) {
				sb.append(new String(buff, 0, len));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sb.deleteCharAt(sb.indexOf("{"));
		sb.deleteCharAt(sb.lastIndexOf("}"));
		
		System.out.println(sb);
		
		// 문자열 split을 좀 더 객체지향적으로 활용할 수 있는 클래스
		StringTokenizer st = new StringTokenizer(sb.toString(), ",");
		Map<String, Object> map = new HashMap<>();
		
		boolean appendingArray = false;
		
		String key = null;
		ArrayList<Object> list = new ArrayList<>();
		
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			
			if (appendingArray) {
				if (!token.contains("]")) {
					list.add(parseJsonValue(token.trim()));
				} else {
					appendingArray = false;
					list.add(parseJsonValue(token.replace("]", "")));
					map.put(key, list);
					list = new ArrayList<>();
				}
				continue;
			}
			
			if (token.contains("[")) {
				appendingArray = true;
				String[] entry = token.trim().split(":");
				key = entry[0].trim().replace("\"", "");
				list.add(parseJsonValue(entry[1].replace("[", "")));
				continue;
			}
			
			String[] entry = token.trim().split(":");
			
			map.put(entry[0].trim().replace("\"", ""), parseJsonValue(entry[1].trim()));
		}
		return map;
	}
	
	private static Object parseJsonValue(String value) {
		if (value.contains("\"")) {
			return value.replace("\"", "");
		} else if (!value.equals("null")) {
			return Integer.parseInt(value.trim());
		}
		
		return null;
	}
	
	public static void mapToJsonFile(Map<String, Object> map) {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		
		int i = 0, len = map.size();
		
		for (Entry<String, Object> entry : map.entrySet()) {
			sb.append("\"" + entry.getKey() + "\":");
			
			Object value = entry.getValue();
			if (value instanceof String) {
				sb.append("\"" + entry.getValue() + "\"");
			} else if (value instanceof Integer || value instanceof Double
					|| value instanceof Float) {
				sb.append(entry.getValue());
			} else if (value instanceof Integer[]) {
				sb.append(Arrays.toString((Object[])value));
			} else if (value instanceof String[]) {
				sb.append("[");
				
				for (int j = 0, len2 = ((String[])value).length; j < len2; j++) {
					sb.append("\"" + ((String[])value)[j] + "\"");
					
					if (j != len2 -1) {
						sb.append(",");
					}
				}
				
				sb.append("]");
			} else if (value == null) {
				sb.append("null");
			}
			
			if (i++ != len - 1) {
				sb.append(",");
			}
		}
		
		sb.append("}");
		
		File jsonFile = new File("./data/json/json.json");
		Charset utf8 = Charset.forName("UTF-8");
		
		// try auto close (Autocloseable 인터페이스가 구현되어 있어야함)
		// new FileWriter(jsonFile, utf8) 1.8안됨 버전 차이인가요 -> 버전차이였다고 한다 집15버전
		try (FileWriter out = new FileWriter(jsonFile)) {
			out.append(sb);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
