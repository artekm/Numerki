package numerki;
public class FileJPGJFIFChecker extends FileJPGChecker {
	@Override
	public String getType() {
		return "Graphic file JPG/JFIF";
	}

	@Override
	public boolean checkHeader(File file) {
		return super.checkHeader(file) && file.getHeaderAsString().toUpperCase().contains("JFIF");
	}
}
