
public class KiemTraHopLe {
	public boolean SoThongTin (String[] t, int n) {
		return t.length == n ? true : false;
	}
	public boolean MaHopLe (String s) {
		if (s.length() < 2)
			return false;
		return (s.charAt(0) == 'c' && s.charAt(1) == 'b') ? true : false;
	}
}
