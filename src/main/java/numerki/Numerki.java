package numerki;
import java.io.IOException;
import java.util.*;

public class Numerki {
	private List<FileChecker> fileCheckers;

	Numerki() {
		fileCheckers = new LinkedList<>();
		fileCheckers.add(new FileJPGJFIFChecker());
		fileCheckers.add(new FileJPGEXIFChecker());
		fileCheckers.add(new FileJPGChecker());
		fileCheckers.add(new FileGIFChecker());
		fileCheckers.add(new FileTXTChecker());
	}

	public static void main(String[] Args) throws IOException {

		if (Args.length == 0) {
			System.out.println("Filename is missing");
			return;
		}
		String fileName = Args[0];

		Numerki numerki = new Numerki();
		numerki.checkFile(fileName);
	}

	private void checkFile(String fileName) throws IOException {
		File file = new File(fileName);

		FileChecker matchExtension = findTypeByExtension(file);
		FileChecker matchHeader = findTypeByHeader(file);

		if (matchHeader.getTypeExt().equals(matchExtension.getTypeExt()))
			System.out.println("File " + file.getFileName() + " is OK, type: " + matchHeader.getType());
		else
			System.out.println("File " + file.getFileName() + " is not OK, extension says " + file.getExtension()
					+ ", while it should be " + matchHeader.getTypeExt());
	}

	private FileChecker findTypeByExtension(File file) throws IOException {
		for (FileChecker fileChecker : fileCheckers)
			if (fileChecker.checkExtension(file))
				return fileChecker;
		throw new IOException("Unsupported file extension " + file.getExtension());
	}

	private FileChecker findTypeByHeader(File file) throws IOException {
		for (FileChecker fileChecker : fileCheckers)
			if (fileChecker.checkHeader(file))
				return fileChecker;
		throw new IOException("Unknown file type " + file.getFileName());
	}
}