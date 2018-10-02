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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author a1600222
 */
@Entity
public class Livro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long livro_id;
    
    @Column(length = 100)
    private String nome;
    
    @Column(length = 4)
    private Integer edicao;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "biblioteca_id", nullable = false)
    private Biblioteca biblioteca;
    
    @ManyToMany
    @JoinTable(
            name = "livroAutor", 
            joinColumns = {@JoinColumn(name = "livro_id")},
            inverseJoinColumns = {@JoinColumn(name="autor_id")})
    private final List<Autor> autores = new ArrayList<Autor>(); 
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getEdicao() {
        return edicao;
    }

    public void setEdicao(Integer edicao) {
        this.edicao = edicao;
    }

    public Long getLivro_id() {
        return livro_id;
    }

    public void setLivro_id(Long livro_id) {
        this.livro_id = livro_id;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (livro_id != null ? livro_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livro)) {
            return false;
        }
        Livro other = (Livro) object;
        if ((this.livro_id == null && other.livro_id != null) || (this.livro_id != null && !this.livro_id.equals(other.livro_id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Livro[ id=" + livro_id + " ]";
    }
    
}
