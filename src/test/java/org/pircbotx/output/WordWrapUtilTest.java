package org.pircbotx.output;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;
import org.testng.annotations.Test;

import static org.pircbotx.output.WordWrapUtil.wrap;

public class WordWrapUtilTest {
  @Test(description = "manual test")
  public void sendRawLineTest() throws Exception {
    //		String message = "10 years since ditchjones strim.i walk thrddough the empty streets can't think anything about expect mitchjones strim. i stare at the screen for hours and try to summon mitchjones with arcane dream 1%. i watch abn stream be he *-talk mitchjones 1%. i flame sodapoppin in his channel and try to resist the nazi mods.. but it is all meaningless. the end is near.i then usually watch some old arcane dreams 1% vods and cry myself to sleep";
//		String message = "𝟏𝟎 𝐲𝐞𝐚𝐫𝐬 𝐬𝐢𝐧𝐜𝐞 𝐝𝐢𝐭𝐜𝐡𝐣𝐨𝐧𝐞𝐬 𝐬𝐭𝐫𝐢𝐦.𝐢 𝐰𝐚𝐥𝐤 𝐭𝐡𝐫𝐨𝐮𝐠𝐡 𝐭𝐡𝐞 𝐞𝐦𝐩𝐭𝐲 𝐬𝐭𝐫𝐞𝐞𝐭𝐬 𝐜𝐚𝐧'𝐭 𝐭𝐡𝐢𝐧𝐤 𝐚𝐧𝐲𝐭𝐡𝐢𝐧𝐠 𝐚𝐛𝐨𝐮𝐭 𝐞𝐱𝐩𝐞𝐜𝐭 𝐦𝐢𝐭𝐜𝐡𝐣𝐨𝐧𝐞𝐬 𝐬𝐭𝐫𝐢𝐦. 𝐢 𝐬𝐭𝐚𝐫𝐞 𝐚𝐭 𝐭𝐡𝐞 𝐬𝐜𝐫𝐞𝐞𝐧 𝐟𝐨𝐫 𝐡𝐨𝐮𝐫𝐬 𝐚𝐧𝐝 𝐭𝐫𝐲 𝐭𝐨 𝐬𝐮𝐦𝐦𝐨𝐧 𝐦𝐢𝐭𝐜𝐡𝐣𝐨𝐧𝐞𝐬 𝐰𝐢𝐭𝐡 𝐚𝐫𝐜𝐚𝐧𝐞 𝐝𝐫𝐞𝐚𝐦 𝟏%. 𝐢 𝐰𝐚𝐭𝐜𝐡 𝐚𝐛𝐧 𝐬𝐭𝐫𝐞𝐚𝐦 𝐛𝐞 𝐡𝐞 *-𝐭𝐚𝐥𝐤 𝐦𝐢𝐭𝐜𝐡𝐣𝐨𝐧𝐞𝐬 𝟏%. 𝐢 𝐟𝐥𝐚𝐦𝐞 𝐬𝐨𝐝𝐚𝐩𝐨𝐩𝐩𝐢𝐧 𝐢𝐧 𝐡𝐢𝐬 𝐜𝐡𝐚𝐧𝐧𝐞𝐥 𝐚𝐧𝐝 𝐭𝐫𝐲 𝐭𝐨 𝐫𝐞𝐬𝐢𝐬𝐭 𝐭𝐡𝐞 𝐧𝐚𝐳𝐢 𝐦𝐨𝐝𝐬.. 𝐛𝐮𝐭 𝐢𝐭 𝐢𝐬 𝐚𝐥𝐥 𝐦𝐞𝐚𝐧𝐢𝐧𝐠𝐥𝐞𝐬𝐬. 𝐭𝐡𝐞 𝐞𝐧𝐝 𝐢𝐬 𝐧𝐞𝐚𝐫.𝐢 𝐭𝐡𝐞𝐧 𝐮𝐬𝐮𝐚𝐥𝐥𝐲 𝐰𝐚𝐭𝐜𝐡 𝐬𝐨𝐦𝐞 𝐨𝐥𝐝 𝐚𝐫𝐜𝐚𝐧𝐞 𝐝𝐫𝐞𝐚𝐦𝐬 𝟏% 𝐯𝐨𝐝𝐬 𝐚𝐧𝐝 𝐜𝐫𝐲 𝐦𝐲𝐬𝐞𝐥𝐟 𝐭𝐨 𝐬𝐥𝐞𝐞𝐩";
    String message = "xz er 𝐯𝐩𝐢𝐟𝐚𝐥𝐯𝐪𝐱𝐢𝐪𝐤𝐥𝐱𝐠𝐞𝐦𝐠𝐯𝐦𝐨𝐛𝐲𝐭𝐭𝐝𝐮𝐜𝐪𝐲𝐛𝐣𝐧𝐛𝐚𝐝𝐦𝐯𝐛𝐫𝐭𝐱𝐞𝐩𝐠𝐤𝐜𝐛𝐚𝐟𝐛𝐰𝐰𝐥𝐨𝐰𝐚𝐡𝐲𝐥𝐣𝐢𝐭𝐢𝐤𝐭𝐞𝐛𝐟𝐚𝐞𝐫𝐨𝐤𝐤𝐲𝐧𝐣𝐝𝐣𝐩𝐫𝐣𝐧𝐛𝐦𝐭𝐥𝐢𝐧𝐨𝐢𝐬𝐢𝐨𝐝𝐰𝐫𝐠𝐥𝐫𝐱𝐦𝐰𝐚𝐠𝐰𝐟𝐟𝐤𝐧𝐪𝐜𝐜𝐮𝐫𝐞𝐬𝐭𝐫𝐭𝐟𝐩𝐛𝐨𝐤𝐭𝐜𝐬𝐨𝐱𝐚𝐤𝐯𝐢𝐨𝐰𝐬𝐢𝐤𝐦𝐥𝐩𝐞𝐧𝐯𝐝𝐯𝐰𝐝𝐥𝐭𝐟𝐮𝐜𝐚𝐬𝐩𝐮𝐠𝐭𝐛𝐲𝐱𝐛𝐪𝐰𝐦𝐪𝐜𝐟𝐤𝐲𝐥𝐦𝐱𝐯𝐡𝐥𝐨𝐦𝐝𝐦𝐛𝐲𝐛𝐧𝐪𝐪𝐲𝐥𝐣𝐛𝐯𝐤𝐤𝐱𝐝𝐝𝐠𝐤𝐡𝐮𝐯𝐰𝐮𝐰𝐝𝐢𝐥𝐮𝐥𝐮𝐥𝐢𝐚𝐚𝐲𝐢𝐯𝐢𝐩𝐠𝐩𝐟𝐠𝐰𝐝𝐮𝐫𝐢𝐢𝐲𝐧𝐧𝐬𝐮𝐬𝐤𝐮𝐭𝐲𝐤𝐩𝐬𝐦𝐰𝐮𝐯𝐡𝐯𝐥𝐥𝐥𝐢𝐟𝐱𝐫𝐧𝐤𝐭𝐛𝐥𝐜𝐤𝐥𝐝𝐚𝐟𝐰𝐭𝐬𝐧𝐫𝐯𝐚𝐬𝐨𝐱𝐛𝐫𝐜𝐤𝐠𝐯𝐮𝐥𝐧𝐰𝐲𝐦𝐛𝐩𝐫𝐛𝐚𝐧𝐡𝐬𝐰𝐪𝐡𝐥𝐢𝐝𝐛𝐪𝐢𝐫𝐛𝐢𝐨𝐥𝐪𝐨𝐜𝐟𝐮𝐛𝐣𝐯𝐠𝐧𝐞𝐠𝐭𝐤𝐣𝐮𝐨𝐩𝐨𝐞𝐨𝐪𝐩𝐮𝐜𝐲𝐛𝐞𝐲𝐛𝐬𝐤𝐯𝐮𝐛𝐲𝐟𝐜𝐡𝐯𝐩𝐜𝐦𝐣𝐡𝐫𝐛𝐨𝐪𝐥𝐡𝐩𝐦𝐣𝐜𝐫𝐤𝐭𝐭𝐪𝐨𝐫𝐲𝐝𝐟𝐥𝐡𝐤𝐨𝐧𝐪𝐚𝐬𝐞𝐦𝐪𝐢𝐫𝐩𝐤𝐚𝐯𝐥𝐪𝐢𝐮𝐡𝐬𝐦𝐛𝐩𝐞𝐦𝐚𝐢𝐝𝐯𝐨𝐫𝐠𝐡𝐣𝐤𝐝𝐱𝐜𝐥𝐬𝐯𝐤𝐨𝐮𝐢𝐜𝐡𝐪𝐟𝐲𝐥𝐣𝐥𝐠𝐞𝐟𝐲𝐠𝐤𝐦𝐟𝐦𝐜𝐟𝐨𝐜𝐦𝐲𝐡𝐭𝐚𝐰𝐦𝐤𝐚𝐲𝐝𝐰𝐣𝐞𝐱𝐧𝐡𝐠𝐮𝐢𝐤𝐭𝐠𝐭𝐭𝐞𝐡𝐣𝐪𝐚𝐯𝐲𝐞𝐣𝐝𝐜𝐪𝐭𝐨𝐚𝐥𝐜𝐥𝐲𝐬𝐢𝐪𝐛𝐞𝐲𝐤𝐧𝐞𝐭 asdfa fasdfgggggggggggg";
//		String message = "𝐠𝐬𝐦𝐟𝐝𝐯𝐫𝐮𝐝𝐩𝐰𝐯𝐞𝐞𝐪𝐱𝐬𝐮𝐠𝐨𝐚𝐮𝐩𝐪𝐮𝐧𝐫𝐬𝐲𝐢𝐱𝐣𝐤𝐰𝐨𝐥𝐰𝐯𝐫𝐝𝐯𝐢𝐡𝐝𝐱𝐠𝐫𝐲𝐥𝐫𝐛𝐨𝐱𝐜𝐬𝐮𝐲𝐜𝐯𝐲𝐲";
//		String prefix = "PRIVMSG: asdf:";
    String prefix = "PRIVMSG #watchmeblink1 :";
    String suffix = "";
    int maxMessageLength = 100;
    String lineEnding = "\r\n";
  
    boolean includePrefix = false;
    System.out.println("count prefix: "+includePrefix);
    int w = includePrefix ? prefix.length()+suffix.length()+lineEnding.length() : 0;
  
    String result = "";
    for (String curPart : StringUtils.split(WordUtils.wrap(message, maxMessageLength-w, lineEnding, true), lineEnding)) {
//			rawLine(prefix + curPart + suffix);
      String rawLine = prefix + curPart + suffix + lineEnding;
//			System.out.println(curPart.length()+" "+rawLine.length()+" "+curPart.substring(0, curPart.indexOf(" ")));
      System.out.println(curPart.length()+" "+rawLine.length());
      result += rawLine;
    }

//		System.out.println(result.equals(truth));
    System.out.println(result);
//		System.out.println(truth);

//		System.out.println("hey"+"mitchjones strim. i stare at the screen for hours and try to summon mitchjones with arcane dream 1%.".length());

//		// put words into a bin until the total length is over max, but at least 1, then truncate
//		String[] words = message.split(" ");
//		int lengthInBin = words[0].length()+1;
//
//		int startIndex = 0;
//
//		String result2 = "";
//		for (int i=1;i<words.length;i++) {
//			int l = words[i].length();
//			lengthInBin += l+1;
//			if (lengthInBin-1+lineEnding.length() >= maxMessageLength) {
////				System.out.println("too big: "+(lengthInBin-1+lineEnding.length())+", cannot add "+words[i]);
//				StringJoiner sj = new StringJoiner(" ", prefix, lineEnding);
//				for (int j=startIndex;j<i;j++) sj.add(words[j]);
//				result2 += sj.toString();
//				System.out.println(sj.toString().length()-prefix.length()-lineEnding.length());
//				startIndex = i;
//				lengthInBin = l;
//			}
//		}
//		StringJoiner sj = new StringJoiner(" ", prefix, lineEnding);
//		for (int j=startIndex;j<words.length;j++) sj.add(words[j]);
//		result2 += sj.toString();
//		System.out.println(sj.toString().length()-prefix.length()-lineEnding.length());
////		System.out.println(result2.equals(truth));
//		System.out.println(result2);
  
    for (String s : wrap(message, maxMessageLength, prefix, suffix+lineEnding, !includePrefix, true)) System.out.print(s);

//		String xd = "PRIVMSG #watchmeblink1 :𝐰";
//		System.out.println(xd.substring(23+1));

//		String xd = "prIVMSG #watchmeblink1 :𝐠𝐬𝐦𝐟𝐝𝐯𝐫𝐮𝐝𝐩𝐰𝐯𝐞𝐞𝐪𝐱𝐬𝐮𝐠𝐨𝐚𝐮𝐩𝐪𝐮𝐧𝐫𝐬𝐲𝐢𝐱𝐣𝐤𝐰𝐨𝐥𝐰𝐯𝐫𝐝𝐯𝐢𝐡𝐝𝐱𝐠𝐫𝐲𝐥𝐫𝐛𝐨𝐱𝐜𝐬𝐮𝐲𝐜𝐯𝐲";
//		String d = substring(xd, 0, 84, true);
//		System.out.println(length(d, true));
//		System.out.println("abc".substring(0, 2));
//		System.out.println(xd.substring(0, 84));
  }
}