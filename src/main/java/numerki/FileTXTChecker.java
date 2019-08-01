package numerki;
import java.util.HashSet;
import java.util.Set;

public class FileTXTChecker extends FileChecker {
	
	@Override
	public String getType() {
		return "Plain text";
	}

	@Override
	public String getTypeExt() {
		return "TXT";
	}

	@Override
	public boolean checkHeader(File file) {
		Set<Character> nonTextChars = new HashSet<Character>();
		for (char c = 0; c < 32; c++)
			nonTextChars.add(c);
		nonTextChars.remove((char) 0x09);
		nonTextChars.remove((char) 0x0A);
		nonTextChars.remove((char) 0x0C);
		nonTextChars.remove((char) 0x0D);

		for (byte b : file.getHeader())
			if (nonTextChars.contains((char) b))
				return false;
		return true;
	}

	@Override
	public boolean checkExtension(File file) {
		String extension = file.getExtension();
		return extension.equals("TXT");
	}
}
