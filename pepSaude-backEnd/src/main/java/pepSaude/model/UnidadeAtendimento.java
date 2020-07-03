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
@Table(name = "unidade_atendiment")
@Data
public class UnidadeAtendimento {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", insertable = false, updatable = false)
	private Integer id;

	@Column(name = "nome")
	@NotNull(message = "O tipo do usuário deve ser informado!")
	private String nome;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cidade", nullable = false)
	@NotNull(message = "A unidade de atendimento deve possuir uma cidade!")
	private Cidade cidade;

	@Column(name = "endereco")
	@NotNull(message = "A descricao do tipo do usuário deve ser informada!")
	private String endereco;

}
