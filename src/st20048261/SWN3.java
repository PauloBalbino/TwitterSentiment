/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package st20048261;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/**
 * This class reads the sentiword net file into the system so it can be used to calculate the sentiment values
 * @author paulobalbino
 */
public class SWN3 {
	private HashMap<String, Double> _dict;

	public SWN3(String pathToSWN) {

		_dict = new HashMap<String, Double>();
		HashMap<String, Double> _temp = new HashMap<String, Double>();
		try {
			BufferedReader csv = new BufferedReader(new FileReader(pathToSWN));
			String line = "";
			while ((line = csv.readLine()) != null) {
				if (line.startsWith("#") || line.startsWith("				#"))
					continue;

				String[] data = line.split("\t");
				Double score = Double.parseDouble(data[2])
						- Double.parseDouble(data[3]);
				String[] words = data[4].split(" ");
				for (String w : words) {
					String[] w_n = w.split("#");
					// w_n[0] += "#" + data[0];
					// int index = Integer.parseInt(w_n[1]) - 1;
					if (_temp.containsKey(w_n[0])) {
						Double v = _temp.get(w_n[0]);
						_temp.put(w_n[0], (v + score) / 2);
					} else {
						_temp.put(w_n[0], score);
					}
				}
			}
			Set<String> temp = _temp.keySet();
			for (Iterator<String> iterator = temp.iterator(); iterator
					.hasNext();) {
				String word = (String) iterator.next();
				double score = _temp.get(word);

				_dict.put(word, new Double(score));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public double extract(String word) {
            if(_dict.containsKey(word))
                return _dict.get(word);
            return 0;
	}

	public double extractSentence(List<String> sentence) {
		double d = 0.0d;
		for (String word : sentence) {
			if (_dict.containsKey(word))
				d += _dict.get(word);
		}
		return d;
	}
}
