package numerki;
import java.io.*;
import java.util.Arrays;

public class File {
	private String fileName;
	private byte[] header;
	private String extension;

	File(String fileName) throws IOException {
		this.fileName = fileName;
		extension = fileName.toUpperCase().substring(fileName.lastIndexOf(".") + 1);
		loadHeader(fileName);
	}

	private void loadHeader(String fileName) throws IOException {
		try (InputStream file = new FileInputStream(fileName)) {
			byte[] tempHeader = new byte[20];
			int bytesRead = file.read(tempHeader, 0, 20);
			header = Arrays.copyOf(tempHeader, bytesRead);
		}
	}

	public byte[] getHeader() {
		return header;
	}

	public String getHeaderAsString() {
		return new String(header);
	}

	public String getExtension() {
		return extension;
	}

	public String getFileName() {
		return fileName;
	}
}
