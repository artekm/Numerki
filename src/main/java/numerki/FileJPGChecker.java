package numerki;
public class FileJPGChecker extends FileChecker {

	@Override
	public String getType() {
		return "Graphic file JPG";
	}

	@Override
	public String getTypeExt() {
		return "JPG";
	}

	@Override
	public boolean checkHeader(File file) {
		byte[] header = file.getHeader();
		return (header[0] == (byte) 0xFF && header[1] == (byte) 0xD8);
	}

	@Override
	public boolean checkExtension(File file) {
		String extension = file.getExtension();
		return extension.equals("JPG") || extension.equals("JPEG");
	}
}
