
public class Student {
	String nama, nis, tgl, tempat, jk, agama, asal, alamat;
	
	public Student(String nama, String nis, String tgl, String tempat, String jk, String agama, String asal, String alamat) {
		super();
		this.nama = nama;
		this.nis = nis;
		this.tgl = tgl;
		this.tempat = tempat;
		this.jk = jk;
		this.agama = agama;
		this.asal = asal;
		this.alamat = alamat;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getNis() {
		return nis;
	}

	public void setNis(String nis) {
		this.nis = nis;
	}

	public String getTgl() {
		return tgl;
	}

	public void setTgl(String tgl) {
		this.tgl = tgl;
	}

	public String getTempat() {
		return tempat;
	}

	public void setTempat(String tempat) {
		this.tempat = tempat;
	}

	public String getJk() {
		return jk;
	}

	public void setJk(String jk) {
		this.jk = jk;
	}

	public String getAgama() {
		return agama;
	}

	public void setAgama(String agama) {
		this.agama = agama;
	}

	public String getAsal() {
		return asal;
	}

	public void setAsal(String asal) {
		this.asal = asal;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	
	

}
