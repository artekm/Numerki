package numerki;
public class FileJPGEXIFChecker extends FileJPGChecker {
	@Override
	public String getType() {
		return "Graphic file JPG/EXIF";
	}

	@Override
	public boolean checkHeader(File file) {
		return super.checkHeader(file) && file.getHeaderAsString().toUpperCase().contains("EXIF");
	}
}
