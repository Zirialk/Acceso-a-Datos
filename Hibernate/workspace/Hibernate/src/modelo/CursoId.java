package modelo;
// Generated 08-dic-2015 12:35:20 by Hibernate Tools 3.4.0.CR1

/**
 * CursoId generated by hbm2java
 */
public class CursoId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codOe;
	private String codCurso;

	public CursoId() {
	}

	public CursoId(String codOe, String codCurso) {
		this.codOe = codOe;
		this.codCurso = codCurso;
	}

	public String getCodOe() {
		return this.codOe;
	}

	public void setCodOe(String codOe) {
		this.codOe = codOe;
	}

	public String getCodCurso() {
		return this.codCurso;
	}

	public void setCodCurso(String codCurso) {
		this.codCurso = codCurso;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CursoId))
			return false;
		CursoId castOther = (CursoId) other;

		return ((this.getCodOe() == castOther.getCodOe()) || (this.getCodOe() != null && castOther.getCodOe() != null
				&& this.getCodOe().equals(castOther.getCodOe())))
				&& ((this.getCodCurso() == castOther.getCodCurso()) || (this.getCodCurso() != null
						&& castOther.getCodCurso() != null && this.getCodCurso().equals(castOther.getCodCurso())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getCodOe() == null ? 0 : this.getCodOe().hashCode());
		result = 37 * result + (getCodCurso() == null ? 0 : this.getCodCurso().hashCode());
		return result;
	}

}
