package br.com.formchristus.modelo;

import java.util.Date;
import br.com.formchristus.modelo.Campus;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "atividade_complementar", schema = "cadastro_basico")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class AtividadeComplementar implements Serializable {

    @Id
    @Column(name = "atv_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "atv_nome", nullable = false)
    private String nome;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "atv_inicio")
    private Date inicio;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "atv_fim", nullable = false)
    private Date fim;

    @NotBlank
    @Column(name = "atv_local", nullable = false)
    private String local;

    @ManyToOne
    @JoinColumn(name = "cam_id",referencedColumnName = "cam_id",nullable = false)
    private Campus campus;
    
    @ManyToOne
    @JoinColumn(name = "tp_atv_id",referencedColumnName = "tp_atv_id",nullable = false)
    private TipoAtividadeComplementar tipoAtividadeComplementar;

    public TipoAtividadeComplementar getTipoAtividadeComplementar() {
        return tipoAtividadeComplementar;
    }

    public void setTipoAtividadeComplementar(TipoAtividadeComplementar tipoAtividadeComplementar) {
        this.tipoAtividadeComplementar = tipoAtividadeComplementar;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local.toUpperCase();
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AtividadeComplementar other = (AtividadeComplementar) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    

}
