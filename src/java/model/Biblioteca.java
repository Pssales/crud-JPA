/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author a1600222
 */
@Entity
public class Biblioteca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bliblioteca_id;
    
    @OneToMany(
            mappedBy = "livro",
            targetEntity = Livro.class,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private final List<Livro> livros = new ArrayList<Livro>();

    @Column(length = 70)
    private String nome;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bliblioteca_id != null ? bliblioteca_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Biblioteca)) {
            return false;
        }
        Biblioteca other = (Biblioteca) object;
        if ((this.bliblioteca_id == null && other.bliblioteca_id != null) || (this.bliblioteca_id != null && !this.bliblioteca_id.equals(other.bliblioteca_id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Biblioteca[ id=" + bliblioteca_id + " ]";
    }

    public Long getBliblioteca_id() {
        return bliblioteca_id;
    }

    public void setBliblioteca_id(Long bliblioteca_id) {
        this.bliblioteca_id = bliblioteca_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Livro> getLivros() {
        return livros;
    }
    
        
}
