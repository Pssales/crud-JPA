/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author a1600222
 */
@Entity
public class Autor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long autor_id;
    
    @Column(length = 90)
    private String nome;
    
    @ManyToMany
    @JoinTable(
            name = "livroAutor", 
            joinColumns = {@JoinColumn(name = "autor_id")},
            inverseJoinColumns = {@JoinColumn(name="livro_id")})
    private List<Livro> livros = new ArrayList<Livro>();

    public Long getAutor_id() {
        return autor_id;
    }

    public void setAutor_id(Long autor_id) {
        this.autor_id = autor_id;
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

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (autor_id != null ? autor_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autor)) {
            return false;
        }
        Autor other = (Autor) object;
        if ((this.autor_id == null && other.autor_id != null) || (this.autor_id != null && !this.autor_id.equals(other.autor_id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Autor[ id=" + autor_id + " ]";
    }
    
}
