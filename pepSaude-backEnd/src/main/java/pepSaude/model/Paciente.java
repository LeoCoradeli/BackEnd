package pepSaude.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name = "paciente")
@Data
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", insertable = false, updatable = false)
	private Integer id;

	@Column(name = "nome")
	@NotNull(message = "O nome do peciente deve ser preenchido!")
	private String nome;

	@Column(name = "cpf")
	@NotNull(message = "O cpf do peciente deve ser preenchido!")
	private String cpf;

	@Column(name = "rg")
	private String rg;

	@Column(name = "endereco")
	@NotNull(message = "O endereco do peciente deve ser preenchido!")
	private String endereco;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cidade")
	@NotNull(message = "A cidade do usuário deve ser informada!")
	private Cidade cidade;

	@Column(name = "tipo_sanguineo")
	@NotNull(message = "O tipo sanguineo do peciente deve ser preenchido!")
	private String TipoSanguineo;

	@Column(name = "alergias")
	private String alergias;

	@Column(name = "estado_civil")
	@NotNull(message = "O nome do peciente deve ser preenchido!")
	private String estadoCivil;

	@Column(name = "peso")
	@NotNull(message = "O nome do peciente deve ser preenchido!")
	private String peso;

	@Column(name = "idade")
	@NotNull(message = "O nome do peciente deve ser preenchido!")
	private String idade;

	@Column(name = "sexo")
	@NotNull(message = "O nome do peciente deve ser preenchido!")
	private String sexo;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario")
	private Usuario responsavel;
}
