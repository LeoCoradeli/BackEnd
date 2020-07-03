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
@Table(name = "consulta")
@Data
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", insertable = false, updatable = false)
	private Integer id;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario")
	@NotNull(message = "A cidade do usuário deve ser informada!")
	private Usuario usuario;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "paciente")
	@NotNull(message = "A paciente deve ser informado!")
	private Paciente paciente;

	@Basic(optional = false)
	@Column(name = "dt_consulta", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull(message = "A data da consulta deve ser informado")
	private Date dtConsulta;

	@Column(name = "motivo")
	@NotNull(message = "O motivo da consulta deve ser informado")
	private String motivo;

	@Column(name = "diagnostico")
	@NotNull(message = "O motivo da consulta deve ser informado")
	private String diagnostico;
}
