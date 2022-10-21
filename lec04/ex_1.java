package lec04;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class ex_1 {
    public ex_1() {
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split("");
        Map<String, Integer> lettersFrequencies = new HashMap();

        for(int i = 0; i < s.length; ++i) {
            if (lettersFrequencies.containsKey(s[i])) {
                lettersFrequencies.put(s[i], (Integer)lettersFrequencies.get(s[i]) + 1);
            } else {
                lettersFrequencies.put(s[i], 1);
            }
        }

        TreeNode huffmanTree = Huffman.encodeText(lettersFrequencies);
        Map<String, String> dictionary = new HashMap();
        Huffman.fillDictionary(huffmanTree, dictionary, "");
        StringBuilder res = new StringBuilder();

        for(int i = 0; i < s.length; ++i) {
            res.append((String)dictionary.get(s[i]));
        }

        PrintStream var10000 = System.out;
        int var10001 = dictionary.size();
        var10000.println("" + var10001 + " " + res.length());
        Iterator var11 = dictionary.entrySet().iterator();

        while(var11.hasNext()) {
            Map.Entry<String, String> key_value = (Map.Entry)var11.next();
            var10000 = System.out;
            String var10 = (String)key_value.getKey();
            var10000.println(var10 + ": " + (String)key_value.getValue());
        }

        System.out.println(res);
    }
}

