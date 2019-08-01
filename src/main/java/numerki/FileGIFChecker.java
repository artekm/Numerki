package numerki;
public class FileGIFChecker extends FileChecker {

	@Override
	public String getType() {
		return "Graphic file GIF";
	}

	@Override
	public String getTypeExt() {
		return "GIF";
	
	}
	@Override
	public boolean checkHeader(File file) {
		String headerAsString = file.getHeaderAsString();
		return (headerAsString.toUpperCase().contains("GIF89A") || headerAsString.toUpperCase().contains("GIF87A"));
	}

	@Override
	public boolean checkExtension(File file) {
		String extension = file.getExtension();
		return extension.equals("GIF");
	}

}
