package pepSaude.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "uf")
@Data
public class UF {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", insertable = false, updatable = false)
	private Integer id;

	@Column(name = "uf")
	@NotNull(message = "O nome da uf deve ser informado!")
	private String uf;

	@Column(name = "nome")
	@NotNull(message = "O nome do estado deve ser informado!")
	private String nome;
}
