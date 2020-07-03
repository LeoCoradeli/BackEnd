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
@Table(name = "usuario")
@Data
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", insertable = false, updatable = false)
	private Integer id;

	@Column(name = "email")
	@NotNull(message = "O email deve ser informado!")
	private String email;

	@Column(name = "nome")
	@NotNull(message = "O campo nome deve ser informado!")
	private String nome;

	@Column(name = "senha")
	private String senha;

	@Column(name = "cpf")
	@NotNull(message = "O cpf do usuário deve ser informado!")
	private String cpf;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo")
	@NotNull(message = "O tipo do usuário deve ser informado!")
	private TipoUsuario tipoUsuario;

	@Column(name = "crm")
	private String crm;

	@Column(name = "endereco")
	private String endereco;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cidade")
	@NotNull(message = "A cidade do usuário deve ser informada!")
	private Cidade cidade;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "especialidade")
	@NotNull(message = "A especialidade do usuário deve ser informada!")
	private Especialidade especialidade;

	@Column(name = "telefone")
	private String telefone;

	@Column(name = "situacao")
	private String situacao;
}
