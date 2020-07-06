package external;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.monkeylearn.ExtraParam;
import com.monkeylearn.MonkeyLearn;
import com.monkeylearn.MonkeyLearnException;
import com.monkeylearn.MonkeyLearnResponse;


public class MonkeyLearnClient {
	private static final String API_KEY = "489a06b3aacce00ee25a118168fdfc86bdc93a08";
	
	public static List<List<String>> extractKeywords(String[] text) {
		if (text == null || text.length == 0) {
			return new ArrayList<>();
		}
		
		// remove the html tags and new line symbols
		
		String[] textClean = removeTags(text);
		
		MonkeyLearn nl = new MonkeyLearn(API_KEY);
		
		ExtraParam[] extraParams = { new ExtraParam("max_keywords", "3")};
		MonkeyLearnResponse response;
		
		try {
			response = nl.extractors.extract("ex_YCya9nrn", textClean, extraParams);
			JSONArray resultArray = response.arrayResult;
			//System.out.println(resultArray);
			return getKeywords(resultArray);
			
		} catch (MonkeyLearnException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<>();
	}
	
	private static List<List<String>> getKeywords(JSONArray nlResultArray) {
		List<List<String>> topKeywords = new ArrayList<>();
		
		for (int i = 0; i < nlResultArray.size(); i++) {
			List<String> keywords = new ArrayList<>();
			JSONArray keywordsArray = (JSONArray)nlResultArray.get(i);
			for (int j = 0; j < keywordsArray.size(); j++) {
				JSONObject keywordObject = (JSONObject)keywordsArray.get(j);
				String keyword = (String)keywordObject.get("keyword");
				keywords.add(keyword);
			}
			topKeywords.add(keywords);
			
		}
		return topKeywords;
	}
	
	/*
	 * remove the html tags for the String in the array of text
	 * return a new String array with cleaned text
	 */
	private static String[] removeTags(String[] text) {
		List<String> stringList = new ArrayList<>();
		for (int i = 0; i < text.length; i++) {
			String singleText = text[i];
			String singleTextClean = singleText.replaceAll("\\<.*?\\>", "").replaceAll("\\n", " ");
			stringList.add(singleTextClean);
		}
		return stringList.toArray(new String[stringList.size()]);
		
	}
	
	public static void main(String[] args) {
		String[] textList = {
				"<p>GAME CLOSURE</p>\\n<p>San Francisco, Mountain View, Tokyo, Remote  -  ",
				"Full Time</p>\\n<p>Game Closure is on the hunt for  Senior Game Engineers to help us build the ",
				"social games that will be tomorrow’s biggest hits on Facebook and other social media platforms. We are a growing team with offices in San Francisco and Mountain View, California, Tokyo, Japan and also some possibilities for remote work. If you want to join us to make great games on our cutting­ edge technology and truly make an impact, then we want to talk to you!</p>\\n<p>Game Closure game engineers make polished",
				", high-performance HTML5 mobile games. We want people who are proficient with JavaScript and who are passionate about making fun social games to be played by millions! As a Game Engineer at Game Closure, you will build games internally on top of our cutting-edge and open source devkit. In addition to building kick­ass instant games, you will play a pivotal role in creating a platform which will revolutionize the future of game development.",
				"</p>\\n<p>It's always a bonus if you know more than JavaScript! We write cross-compilers, GPU shaders, NodeJS back­ends, JavaScript game APIs and tools, and whatever else it takes. You will work with the best engineers in the world; we have top talent in every part of our stack.</p>\\n<p><strong>The Role:</strong></p>\\n<ul>\\n<li>Be responsible for designing, developing and deploying major game features</li>\\n<li>Own game feature areas from end-­to­-end</li>",
				"\\n<li>Be the champion for the user!</li>\\n<li>Insist on the highest standards and create functional and engaging features that will delight our users</li>\\n<li>Be part of a tight game development team looking to iterate fast on a fun concept and then building it out</li>\\n<li>Have real input on end-user product</li>\\n<li>Be a key member of a high performing software engineering team</li>\\n<li>Collaborate with design, engineering and production teams to devise optimal engineering solutions to game requirements",
				"</li>\\n<li>Hands­ on architect and coder for sophisticated client/server systems for mobile gaming</li>\\n<li>Innovate and iterate on process, systems and technology to deliver world­-class social games</li>\\n<li>Be a leader; Identify and articulate technical and production risks and obstacles, as well as generate solutions!</li>\\n</ul>\\n<p><strong>Desired Skills:</strong></p>\\n<ul>\\n<li>Bachelor's degree in Computer Science or related field, or equivalent experience.</li>\\n<li>3+ years of professional software engineering experience, ",
				"working on cross functional teams.</li>\\n<li>Proven effectiveness in directing or delivering production software for high quality games with at least one shipped game product of which you were a primary contributor (self­ published titles are acceptable).</li>\\n<li>Capable of JavaScript + HTML5 to create custom, interactive, user experiences that are enjoyable on all HTML5 browsers.</li>\\n<li>Proficient at using script debuggers like Chrome Debugger.</li>\\n<li>Strong Computer Science fundamentals in object­-oriented design, algorithms, and data structures.</li>\\n<li>",
				"Advanced software engineering skills, including the ability to write maintainable and robust code in a p popular object oriented language.</li>\\n<li>Solid familiarity with analytics and A/B testing in mobile games</li>\\n<li>Familiarity with git, svn or other VCS.</li>\\n<li>Self starter, analytical and creative</li>\\n<li>Strong team player with a positive attitude.</li>\\n<li>Good communication skills and the ability to work effectively on shared projects with designers, artists, testers, product managers and other developers.</li>\\n<li>Check out Everwing on Facebook Instant Games in Messenger. Can you build this game?</li>\\n<li>Understanding of ",
				"the reactive UI paradigm and experience building UIs using reactive UI frameworks (such as React, and state management Utilities like Redux).</li>\\n</ul>\\n<p><strong>Bonus:</strong></p>\\n<ul>\\n<li>Canvas animation work</li>\\n<li>2+ years of game development experience with multiple shipped titles</li>\\n<li>Specialized skills in a particular area of game development (for example: UI, Physics, graphics, multiplayer, game logic, etc.)</li>\\n<li>Expert knowledge of TypeScript</li>\\n</ul>\\n<p><strong>GC Perks:</strong></p>\\n<ul>\\n<li>Medical, Dental, &amp; Vision: Top quality insurance options with 100% of premiums covered</li>\\n<li>Social Events: ",
				"Weekly team dinners, quarterly team excursions, game nights, karaoke, and more</li>\\n<li>Commuter Pass + Free Parking: Your commute and parking to the office is on us!</li>\\n<li>PTO: Unlimited vacation policy</li>\\n<li>Meals: Free daily lunches, well stocked kitchen, healthy snacks and drinks</li>\\n<li>Pet-Friendly Office: Bring your pets to work to foster a friendlier and happier workplace</li>\\n</ul>\\n", };
		
		System.out.println(extractKeywords(textList));
	}

}
