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
@Table(name = "tipo_usuario")
@Data
public class TipoUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", insertable = false, updatable = false)
	private Integer id;

	@Column(name = "tipo")
	@NotNull(message = "O tipo do usuário deve ser informado!")
	private String tipo;

	@Column(name = "ds_tipo")
	@NotNull(message = "O a descricao do tipo do usuário deve ser informada!")
	private String dsTipo;
}
