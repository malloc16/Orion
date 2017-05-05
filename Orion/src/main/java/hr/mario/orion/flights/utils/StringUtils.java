package hr.mario.orion.flights.utils;

public class StringUtils {
	public static String removeSquareBrackets(String data){
		String[] split = data.split("[\\[.*\\]]");
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < split.length; i++){
			if(i%2 == 0){
				if(split[i].startsWith(" ")){
					sb.append(split[i]);
				}else{
					sb.append(" ").append(split[i]);
				}
			}
		}

		return sb.toString().trim();
	}
}
