package pepSaude.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name = "dados_clinicos")
@Data
public class DadosClinicos {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", insertable = false, updatable = false)
	private Integer id;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "paciente")
	@NotNull(message = "O paciente deve ser informada!")
	private Paciente paciente;

	@Basic(optional = false)
	@Column(name = "dt_registro", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull(message = "A data do registro deve ser informada")
	private Date dtRegistro;

	@Basic(optional = false)
	@Column(name = "dt_obito", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtObito;

	@Column(name = "status_paciente")
	private String statusPaciente;

	@Column(name = "madicacoes")
	private String madicacoes;

	@Column(name = "diagnostico")
	private String diagnostico;

	@Column(name = "obs")
	private String obs;

	@Column(name = "sic")
	private String sic;
}
